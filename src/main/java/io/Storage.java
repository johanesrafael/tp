package io;

import command.Command;
import data.Item;
import lexical.Parser;
import constants.Constants;
import data.Data;

import java.io.IOException;
import java.util.ArrayList;

/**
 * The type Storage.
 */
public class Storage {

    private FileLoader loader;
    private FileSaver saver;
    private Parser parser;
    private ReadFile moduleloader;

    /**
     * Instantiates a new Storage.
     *
     * @param directory the directory
     * @param fileName  the file name
     * @param parser    the parser
     */
    public Storage(String directory, String fileName, Parser parser) {
        loader = new FileLoader(directory, fileName);
        saver = new FileSaver(directory, fileName);
        this.parser = parser;
        this.moduleloader = new ReadFile("data/courselist11.txt");
    }

    /**
     * Save tasks.
     *
     * @param tasks the tasks
     */
    public void saveTasks(ArrayList<Item> tasks) {
        saver.save(tasks);
    }

    /**
     * Load task list.
     *
     * @return the task list
     */
    public Data load() {
        String[] lines = loader.loadAllLines();
        int index = 0;
        Data list = new Data();
        for (String line: lines) {
            String output = dataToCommand(line, index);
            if (!output.equals(Constants.ZERO_LENGTH_STRING)) {
                index++;
            }
            ArrayList<Command> commands = parser.parse(output);
            for (Command c: commands) {
                c.execute(list);
            }
        }
        try {
            list.mods = moduleloader.load();
        } catch (IOException e) {
            e.addSuppressed(new IOException());
        }
        return list;
    }

    private String dataToCommand(String input, int index) {
        boolean isDone = false;
        String output = Constants.ZERO_LENGTH_STRING;
        String iconCleared = input.replace(Constants.ICON_SIGNATURE, Constants.ICON_SEPARATOR);
        String[] iconSeparated = iconCleared.split(Constants.LINE_UNIT);
        switch (iconSeparated[0]) {
        case Constants.TODO_ICON:
            output = Constants.TODO + Constants.SPACE;
            break;
        case Constants.EVENT_ICON:
            output = Constants.EVENT + Constants.SPACE;
            break;
        case Constants.DDL_ICON:
            output = Constants.DEADLINE + Constants.SPACE;
            break;
        default:
            return output; //break is unreachable
        }
        String statusCleared = iconSeparated[1].replace(Constants.BODY_SIGNATURE, Constants.BODY_SEPARATOR);
        String[] statusSeparated = statusCleared.split(Constants.LINE_UNIT);
        if (statusSeparated[0].equals(Constants.TICK_ICON)) {
            isDone = true;
        }
        String bodyCleared = statusSeparated[1].replace(Constants.PARAM_SIGNATURE, Constants.PARAM_SEPARATOR);
        String[] bodySeparated = bodyCleared.split(Constants.LINE_UNIT);
        if (bodySeparated.length == 1) { // no params
            output += bodyCleared;
        } else {
            output += bodySeparated[0] + Constants.SPACE;
            String params = bodySeparated[1].replace(Constants.PARAM_LEFT, Constants.ZERO_LENGTH_STRING).replace(
                    Constants.PARAM_RIGHT,Constants.ZERO_LENGTH_STRING).trim();
            output += Constants.PARAM + params.replace(Constants.DETAILS_SIGNATURE, Constants.SPACE);
        }
        if (isDone) {
            output += Constants.CMD_END + Constants.DONE + Constants.SPACE + (index + 1);
        }
        return output;
    }

}
