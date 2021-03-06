package seedu.duke;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;


import command.Command;
import constants.Constants;
import data.Data;
import io.Storage;
import lexical.Parser;
import visualize.Cli;
import visualize.FancyCli;

/**
 * The type Duke.
 */
public class Duke {

    private final Storage storage;
    private final FancyCli fui; // fancy ui
    private final Cli pui; //plain ui
    private final Parser parser;
    private Data data;
    private Cli ui;
    private boolean isFancy;

    /**
     * Instantiates a new Duke.
     *
     * @param isFancy   the is fancy
     * @param stream    the stream
     * @param input     the input
     * @param directory the directory
     * @param fileName  the file name
     */
    public Duke(boolean isFancy, PrintStream stream, InputStream input, String directory, String fileName) {
        fui = new FancyCli(stream, input);
        pui = new Cli(stream, input);
        ui = isFancy ? fui : pui;
        this.isFancy = isFancy;
        ui.showWelcome();
        parser = new Parser();
        storage = new Storage(directory, fileName, parser);
        try {
            data = storage.load();
        } catch (Exception e) {
            ui.showText(e.getMessage());
            data = new Data();
        }
    }

    private void reattachUI(boolean isFancy, boolean isPlain) {
        if (this.isFancy && isPlain) {
            ui = pui;
            this.isFancy = false;
            ui.setSwitched();
        } else if (!this.isFancy && isFancy) {
            ui = fui;
            this.isFancy = true;
            ui.setSwitched();
        }
    }

    /**
     * Run.
     */
    public void run() {
        ui.showReminder(data);
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.nextLine();
                ArrayList<Command> commands = parser.parse(fullCommand); //array list of commands
                for (Command c : commands) {
                    c.execute(data);
                    reattachUI(c.isFancy(), c.isPlain());
                    ui.update(c.result, data);
                    isExit = c.isBye();
                    storage.saveTasks(data.tasks);
                }
            } catch (Exception e) {
                String message = e.getMessage();
                if (message == null) {
                    message = Constants.INDEX_OUT;
                }
                ui.update(message, data);
            }
        }
    }

    /**
     * Execute JUnit test with output.
     *
     * @param command Command of user
     * @return Duke's response
     */
    public String testOutputSut(String command) {
        try {
            String fullCommand = command;
            ArrayList<Command> commands = parser.parse(fullCommand); //array list of commands
            for (Command c : commands) {
                c.execute(data);
                reattachUI(c.isFancy(), c.isPlain());
                ui.update(c.result, data);
                // uncomment when want to test for storage only
                // storage.saveTasks(data.tasks);
                return c.result;
            }
        } catch (Exception e) {
            String message = e.getMessage();
            if (message == null) {
                message = Constants.INDEX_OUT;
            }
            ui.showText(message);
        }
        return "0";
    }

    /**
     * Execution command for JUnit tests.
     *
     * @param command Command of user
     * @return Duke's response
     */
    public String testExecuteSut(String command) {
        try {
            String fullCommand = command;
            ArrayList<Command> commands = parser.parse(fullCommand); //array list of commands
            for (Command c : commands) {
                c.execute(data);
                return c.result;
            }
        } catch (Exception e) {
            String message = e.getMessage();
            if (message == null) {
                message = Constants.INDEX_OUT;
            }
            ui.showText(message);
        }
        return "0";
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        // Starts up using colored CLI on mac or linux, and pure text on windows (for now).
        // This is because ansi sequences needed to be enabled on programs started by cmd in recent windows versions.
        // this is an intended behaviour brought by microsoft developers, so that programs called by cmd
        // do not inherit the appearance of cmd.exe (which by default supports ansi escape sequences).
        // when cmd runs "java -jar xxx", the javac.exe is started by cmd.exe
        // which does not enable the ansi mode by default.
        // if the jar was started by something else such as gitbash or intelliJ shell, there is no such problem
        // thus, we need to find a way to reliable call the windows api to set such mode
        // However, no matter what mode it starts in, I have created switching commands.
        // you can use "fancy" command to switch to fancyCli, and use "plain" command to switch to plain Cli.
        // [AFTER READING THE ABOVE TEXT, PLEASE UNCOMMENT THE FOLLOWING 2 LINES TO RUN THE PROGRAM]
        //boolean isWindows = System.getProperty("os.name").toLowerCase().contains("win");
        //new Duke(!isWindows, System.out, System.in, Constants.PATH, Constants.FILENAME).run();
    }
}
