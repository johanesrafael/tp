package data;

import constants.Constants;
import data.jobs.Deadline;
import data.jobs.Event;
import data.jobs.Task;
import data.jobs.ToDo;
import messages.MessageOptions;

import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * The type Task list.
 */
public class Data {

    private static final Logger LOGGER = Logger.getLogger(Data.class.getName());

    private static ArrayList<Item> tempList;
    public String flag;
    /**
     * The Tasks.
     */
    public ArrayList<Item> tasks;
    /**
     * The default list of modules read in from courselist11.txt.
     */
    public ArrayList<Item> mods;
    /**
     * The Index option.
     */
    public MessageOptions indexOption;
    public ArrayList<Item> target;
    /**
     * The Last input.
     */
    public String lastInput;
    /**
     * The Last index option.
     */
    public MessageOptions lastIndexOption;
    private String dataType;

    /**
     * Instantiates a new Task list.
     */
    public Data() {
        lastInput = "";
        lastIndexOption = MessageOptions.NOT_INDEXED;
        tasks = new ArrayList<>();
        indexOption = MessageOptions.NOT_INDEXED;
        target = tasks;
        mods = new ArrayList<>();
        flag = Constants.TASK;
    }

    public void setFlag(String flag) {
        this.flag = flag;
        target = getTarget();
    }

    public ArrayList<Item> getTarget() {
        return getTarget(flag);
    }

    public ArrayList<Item> getTarget(String flag) {
        refreshTarget(flag);
        return target;
    }

    public void refreshTarget() {
        refreshTarget(flag);
    }

    public void refreshTarget(String flag) {
        switch (flag) {
        case Constants.DEADLINE: // break is unreachable
            target = tasks.stream().filter(x -> x instanceof Deadline).collect(Collectors.toCollection(ArrayList::new));
            break;
        case Constants.EVENT: // break is unreachable
            target = tasks.stream().filter(x -> x instanceof Event).collect(Collectors.toCollection(ArrayList::new));
            break;
        case Constants.TODO: // break is unreachable
            target = tasks.stream().filter(x -> x instanceof ToDo).collect(Collectors.toCollection(ArrayList::new));
            break;
        case Constants.MOD:
            target = mods;
            break;
        case Constants.SELECTED:
            target = mods.stream().filter(x -> x.isSelected).collect(Collectors.toCollection(ArrayList::new));
            target.addAll(tasks.stream().filter(x -> x.isSelected).collect(Collectors.toList()));
            break;
        case Constants.TAKEN:
            target = mods.stream().filter(
                x -> ((SingleModule) x).isTaken).collect(Collectors.toCollection(ArrayList::new));
            break;
        default:
            target = tasks;
            break;
        }
    }

    private String getTaskType(Task task) {
        if (task instanceof Deadline) {
            return Constants.DEADLINE;
        } else if (task instanceof Event) {
            return Constants.EVENT;
        }
        return "task";
    }


    public void addTask(Task task) {
        LOGGER.entering(getClass().getName(), "addTask");
        tempList = new ArrayList<>(getTarget(getTaskType(task)));
        Checker cc = new Checker(tempList, task);
        LocalDateTime newDate = cc.checkRecurrenceDate(task);
        if (newDate != null) {
            task.setDateTime(newDate);
        }
        if (!cc.checkDuplicates()) {
            LOGGER.log(Level.INFO, "Task was added to data");
            tasks.add(task);
        }
        refreshTarget();
        LOGGER.exiting(getClass().getName(), "addTask");
    }

    public void removeItem(int index) {
        Item currentItem = target.get(index);
        refreshTarget();
        target.remove(currentItem);
        refreshTarget();
    }

    public void updateItem(int index, Item newItem) {
        Item currentItem = target.get(index);
        refreshTarget();
        target.set(target.indexOf(currentItem), newItem);
        refreshTarget();
    }

    /**
     * Get task.
     *
     * @param index the index
     * @return the task
     */
    public Item get(int index) {
        return target.get(index);
    }


}
