package constants;

import command.action.Action;
import command.action.ByeAction;
import command.action.UnknownAction;
import command.action.UndoneAction;
import command.action.TodoAction;
import command.action.ListAction;
import command.action.HelpAction;
import command.action.EventAction;
import command.action.DoneAction;
import command.action.DeleteAction;
import command.action.DeadlineAction;
import command.action.AddAction;
import command.action.ClearAction;

import java.util.Map;

public class Constants {

    public static final char LPAREN = '(';
    public static final char RPAREN = ')';
    public static final char PARAM = '/';
    public static final char PARAM_ALIAS = '-';
    public static final char CMD_END = ';';
    public static final char CHAR_SPACE = ' ';

    public static final String LINE_UNIT = "_";
    public static final String DOT = ".";
    public static final String SPACE = " ";
    public static final String ICON_LEFT = "[";
    public static final String ICON_RIGHT = "]";
    public static final String PARAM_LEFT = "(";
    public static final String PARAM_RIGHT = ")";
    public static final String TODO_ICON = ICON_LEFT + "T" + ICON_RIGHT;
    public static final String EVENT_ICON = ICON_LEFT + "E" + ICON_RIGHT;
    public static final String DDL_ICON = ICON_LEFT + "D" + ICON_RIGHT;
    public static final String ICON_SIGNATURE = ICON_RIGHT + ICON_LEFT;
    public static final String ICON_SEPARATOR = ICON_RIGHT + LINE_UNIT + ICON_LEFT;
    public static final String BODY_SIGNATURE = ICON_RIGHT + SPACE;
    public static final String BODY_SEPARATOR = ICON_RIGHT + LINE_UNIT;
    public static final String PARAM_SIGNATURE = SPACE + PARAM_LEFT;
    public static final String PARAM_SEPARATOR = LINE_UNIT + PARAM_LEFT;
    public static final String DETAILS_SIGNATURE = ": ";
    public static final String TICK = "V"; //"\u2713";
    public static final String CROSS = "X"; //"\u2718";
    public static final String TICK_ICON = ICON_LEFT + TICK + ICON_RIGHT;
    public static final String CROSS_ICON = ICON_LEFT + CROSS + ICON_RIGHT;
    public static final String TAB = "\t";
    public static final String NEWLINE = "\n";
    public static final String RETURN = "\r";
    public static final String WIN_NEWLINE = RETURN + NEWLINE;
    public static final String ZERO_LENGTH_STRING = "";
    public static final String TEXT_PLACEHOLDER = "_t_";
    public static final String NUMBER_PLACEHOLDER = "_n_";

    public static final String PATH = "./data";
    public static final String FILENAME = "duke.txt";

    public static final String BYE = "bye";
    public static final String CLEAR = "clear";
    public static final String DEADLINE = "deadline";
    public static final String DELETE = "delete";
    public static final String DONE = "done";
    public static final String EVENT = "event";
    public static final String HELP = "help";
    public static final String LIST = "list";
    public static final String TODO = "todo";
    public static final String UNDONE = "undone";
    public static final String UNKNOWN = "unknown";

    public static final String ATOMIC = "_atom_";
    public static final String DEFAULT = "1";
    public static final String EMPTY = "0";
    public static final String NEXT = "next";
    public static final String PREV = "prev";
    public static final String SEL = "sel";
    public static final String ADD = "add";
    public static final String MC = "mc";

    public static final String INDEX_OUT = "Index out of range.";
    public static final String ADDED = "Got it. I've added this task:";
    public static final String REMOVED = "Noted. I've removed this task:";
    public static final String COUNT_PREFIX = "Now you have ";
    public static final String COUNT_SUFFIX = " tasks in the list.";
    public static final String CHANGED = Constants.WIN_NEWLINE + Constants.TEXT_PLACEHOLDER
            + Constants.WIN_NEWLINE + Constants.COUNT_PREFIX + Constants.NUMBER_PLACEHOLDER
            + Constants.COUNT_SUFFIX;
    public static final String INVALID = "Invalid Command! Please check the syntax." + WIN_NEWLINE;
    public static final String WELCOME = "Hello, I'm Duke. What can I do for you?";
    public static final String HELP_PROMPT = "Use \"help [target]\" to see details :) Try \"help help\"!";

    public static final int LINE_REPETITION = 60;
    public static final int NO_INDENT = 0;
    public static final int INDENT_1 = 1;
    public static final int INDENT_2 = 2;
    public static final int INDENT_3 = 3;
    public static final int LETTER_OFFSET = 64;
    public static final int BITMAP_W = 100;
    public static final int BITMAP_LIST_H = 15;
    public static final int BITMAP_SEL_H = 6;
    public static final int CELL_W = 10;
    public static final int CELL_H = 2;
    public static final int BANNER = 1;

    public static final Map<String, Action> actionMap = Map.ofEntries(
            Map.entry(BYE, new ByeAction()),
            Map.entry(CLEAR, new ClearAction()),
            Map.entry(DEADLINE, new DeadlineAction()),
            Map.entry(DELETE, new DeleteAction()),
            Map.entry(DONE, new DoneAction()),
            Map.entry(EVENT, new EventAction()),
            Map.entry(HELP, new HelpAction()),
            Map.entry(LIST, new ListAction()),
            Map.entry(TODO, new TodoAction()),
            Map.entry(UNDONE, new UndoneAction()),
            Map.entry(UNKNOWN, new UnknownAction()));
    public static final Map<String, HelpText> helpMap = Map.ofEntries(
            Map.entry(BYE, HelpText.BYE),
            Map.entry(CLEAR, HelpText.CLEAR),
            Map.entry(DEADLINE, HelpText.DEADLINE),
            Map.entry(DELETE, HelpText.DELETE),
            Map.entry(DONE, HelpText.DONE),
            Map.entry(EVENT, HelpText.EVENT),
            Map.entry(HELP, HelpText.HELP),
            Map.entry(LIST, HelpText.LIST),
            Map.entry(TODO, HelpText.TODO),
            Map.entry(UNDONE, HelpText.UNDONE),
            Map.entry(UNKNOWN, HelpText.UNKNOWN));
    public static final Map<String, String> paramMap = Map.ofEntries(
            Map.entry(DEADLINE, "by"),
            Map.entry(EVENT, "at"));
    public static final Map<String, String> messageMap = Map.ofEntries(
            Map.entry(BYE,"Bye. Hope to see you again soon!"),
            Map.entry(CLEAR, "Nice! I've cleared everything in the list."),
            Map.entry(DEADLINE, Constants.ADDED + Constants.CHANGED),
            Map.entry(DELETE, Constants.REMOVED + Constants.CHANGED),
            Map.entry(DONE, "Nice! I've marked this task as done:"
                    + Constants.WIN_NEWLINE + Constants.TEXT_PLACEHOLDER),
            Map.entry(EVENT, Constants.ADDED + Constants.CHANGED),
            Map.entry(HELP, Constants.TEXT_PLACEHOLDER),
            Map.entry(LIST, Constants.TEXT_PLACEHOLDER),
            Map.entry(TODO, Constants.ADDED + Constants.CHANGED),
            Map.entry(UNDONE, "Nice! I've marked this task as undone:"
                    + Constants.WIN_NEWLINE + Constants.TEXT_PLACEHOLDER),
            Map.entry(UNKNOWN, "OOPS, I don't know what that means :-( Try \"help\"!"));
}
