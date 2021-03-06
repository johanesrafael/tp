package constants;

/**
 * The enum Help text.
 */
public enum HelpText {

    /**
     * The Bye.
     */
    BYE(
            "bye",
            "Quit the program",
            new String[]{
                "bye"
            },
            new String[]{
                "1. \"bye\" >> quits the program"
            }),
    /**
     * The Clear.
     */
    CLEAR(
            "clear",
            "Clear the task list",
            new String[]{
                "clear"
            },
            new String[]{
                "1. \"clear\" >> clears the task list"
            }),
    /**
     * The Deadline.
     */
    DEADLINE(
            "deadline",
            "Add a deadline to the task list",
            new String[]{
                "deadline [description] -by [time]"
            },
            new String[]{
                "1. \"deadline ddl -by 21/9/15 1:12\" >> "
                        + "adds a deadline with description \"ddl\" and time \"Sep 15 2021 1:12\""
            }),
    /**
     * The Delete.
     */
    DELETE(
            "delete",
            "Delete a task from the task list",
            new String[]{
                "delete [index]"
            },
            new String[]{
                "1. \"delete 1\" >> deletes the task with index 1 from the current list"
            }),
    /**
     * The Done.
     */
    DONE(
            "done",
            "Mark a task as done",
            new String[]{
                "done [index]"
            },
            new String[]{
                "1. \"done 1\" >> marks the task with index 1 as done"
            }),
    /**
     * The Event.
     */
    EVENT(
            "event",
            "Add an event to the task list",
            new String[]{
                "event [description] -at [time]"
            },
            new String[]{
                "1. \"event e -at May 13 2020 8:00\" >> "
                        + "adds an event with description \"e\" and time \"May 13 2020 8:00\""
            }),
    /**
     * The Find.
     */
    FIND(
            "find",
            "Find an event in the task list with the specified keyword",
            new String[]{
                "find [keyword]"
            },
            new String[]{
                "1. \"find exam\" >> finds all tasks with the \"exam\" keyword from the task list"
            }),
    /**
     * The Help.
     */
    HELP(
            "help",
            "Print the list of available commands, or print the details of a specified command",
            new String[]{
                "help [target]",
                "target: the name of the target command"
            },
            new String[]{
                "1. \"help\" >> prints the list of available commands",
                "2. \"help event\" >> prints the details of the \"event\" command"
            }),
    /**
     * The Focus.
     */
    FOCUS(
            "focus",
            "Change context. Changes the target of other commands to the specified target",
            new String[]{
                "focus",
                "focus [deadline / todo / event / task / mod / selected / taken]"
            },
            new String[]{
                "1. \"focus\" >> focus on \"task\". e.g. \"list\" will list all tasks from now on",
                "2. \"focus mod\" >> focus on \"mod\". e.g. \"list\" will list all modules from now on",
                "3. \"focus selected\" >> focus on \"selected\". e.g. \"list\" will list selected items from now on"
            }),

    REMINDER(
            "reminder",
            "List out events and deadlines tasks that are due within " + Constants.REMINDER_RANGE + " days",
            new String[]{
                "reminder"
            },
            new String[]{
                "1. \\\"list\\\" >> list all added tasks\","
            }),
    /**
     * The List.
     */
    LIST(
            "list",
            "Print a list of tasks/modules depending on the current Focus",
            new String[]{
                "list",
                "list date [asc / desc / spec \"date\"(any common date format)]"
            },
            new String[]{
                "1. \"list\" >> list all added tasks",
                "2. \"list date asc\" >> list tasks with a \"date\" field in ascending order",
                "3. \"list date spec Oct 5 2020\" >> list tasks with specific \"date\" field of Oct 5 2020"
            }),
    /**
     * The Todo.
     */
    TODO(
            "todo",
            "Add a todo to the task list",
            new String[]{
                "todo [description]"
            },
            new String[]{
                "1. \"todo class\" >> adds a todo with description \"class\""
            }),
    /**
     * The Undone.
     */
    UNDONE(
            "undone",
            "Mark a task as undone",
            new String[]{
                "undone [index]"
            },
            new String[]{
                "1. \"undone 1\" >> marks the task with index 1 as undone"
            }),
    /**
     * The Unknown.
     */
    UNKNOWN(
            "unknown",
            "Prints the error message for an unrecognized command for debugging purposes",
            new String[]{
                "unknown"
            },
            new String[]{
                "1. \"unknown\" >> prints \"OOPS, I don't know what that means :-( Try \"help\"!\""
            }),
    /**
     * The Next.
     */
    NEXT(
            "next",
            "Switch the target region to the next page, keeping other regions unchanged.",
            new String[]{
                "next [region]",
                "region: i(item list), s(selection), a(all, default)"
            },
            new String[]{
                "1. \"next\" >> switch both item list (top) and selection (bottom) region to the next page (default)",
                "2. \"next s\" >> switch only the selection (bottom) region to the next page"
            }),
    /**
     * The Prev.
     */
    PREV(
            "prev",
            "Switch the target region to the previous page, keeping other regions unchanged.",
            new String[]{
                "prev [region]",
                "region: i(items), s(selection), a(all, default)"
            },
            new String[]{
                "1. \"prev\" >> switch both item list (top) and selection (bottom) to the previous page (default)",
                "2. \"prev s\" >> switch the selection (bottom) to the previous page"
            }),
    /**
     * The Fancy.
     */
    FANCY(
            "fancy",
            "Switch to a fancy Cli (requires the shell to support ansi codes).",
            new String[]{
                "fancy"
            },
            new String[]{
                "1. \"fancy\" >> switch to a fancy Cli with graphics. Use \"plain\" to switch to plain Cli"
            }),
    /**
     * The Plain.
     */
    PLAIN(
            "plain",
            "Switch to a plain Cli.",
            new String[]{
                "plain"
            },
            new String[]{
                "1. \"plain\" >> switch to a plain pure-text Cli. Use \"fancy\" to switch to fancy Cli"
            }),
    /**
     * The Sel.
     */
    SEL(
            "sel",
            "Make selection: Add specified item(s) to the selection.",
            new String[]{
                "sel [index(es) (for the currently listed items) / module code(s) (for modules only)]",
            },
            new String[]{
                "1. \"sel 1 2 3\" >> add the item with indices 1, 2and 3 from the item list to the selection",
                "2. \"sel CS1010 CS2113\" >> add the modules CS1010 and CS2113 on the item list to the selection",
                "2. \"sel 5 CS2113\" >> add the item with index 5 and module CS2113 on the item list to the selection"
            }),
    /**
     * The Unsel.
     */
    UNSEL(
            "unsel",
            "Cancel selection: Make specified item(s) no longer selected.",
            new String[]{
                "unsel [index(es) (for the currently listed items) / module code(s) (for modules only)]",
            },
            new String[]{
                "1. \"unsel 1 2 3\" >> make items with indices 1, 2and 3 no longer selected",
                "2. \"unsel CS1010 CS2113\" >> make modules CS1010 and CS2113 no longer selected",
                "2. \"unsel 5 CS2113\" >> make the item with index 5 and module CS2113 no longer selected"
            }),
    /**
     * The Add.
     */
    ADD(
            "add",
            "Add task(s) to module(s): Add specified task(s) to specified module(s).",
            new String[]{
                "add -task [index(es)] -mod [module code(s)]",
            },
            new String[]{
                "1. \"add -task 1 2 -mod CS2113 CS2113T \" >> add task 1 and task 2 in the current list to "
                        + "the modules CS2113 and CS2113T",
            }),
    /**
     * The Take.
     */
    TAKE(
            "take",
            "Take module(s): Mark specified module(s) as taken.",
            new String[]{
                "take [index(es) / module code(s) (for modules only)]",
            },
            new String[]{
                "1. \"take\" >> if there is any module selected but not taken, mark it as taken",
                "2. \"take 1 2\" >> mark module 1 and module 2 as taken",
                "3. \"take CS2113T\" >> mark module CS2113T as taken",
                "4. \"take 1 2 CS2113T\" >> mark module 1, module 2 and module CS2113T as taken",
            }),
    /**
     * The Untake.
     */
    UNTAKE(
            "untake",
            "Untake module(s): Mark specified module(s) as not taken.",
            new String[]{
                "untake [index(es) / module code(s) (for modules only)]",
            },
            new String[]{
                "1. \"untake\" >> if there is any module selected but not taken, mark it as not taken",
                "2. \"untake 1 2\" >> mark module 1 and module 2 as not taken",
                "3. \"untake CS2113T\" >> mark module CS2113T as not taken",
                "4. \"untake 1 2 CS2113T\" >> mark module 1, module 2 and module CS2113T as not taken"
            }),
    /**
     * The Mc.
     */
    MC(
            "mc",
            "Print MCs: Print the number of MCs based on selected option.",
            new String[]{
                "mc [-option] [-detail]",
                "option: {-c(current, default), -p(prospective), -help}",
                "detail: {-t(total, default), -d(detailed)}"
            },
            new String[]{
                "1. \"mc\" >> print the total number of MCs currently taking",
                "2. \"mc -p\" >> print the total number of MCs in the selection region",
                "3. \"mc -p -d \" >> print the detailed MC composition of the selection region",
            }),
    /**
     * The Mc.
     */
    DETAIL(
            "detail",
            "Print Details: Print the details of a specified module.",
            new String[]{
                "detail [module code / index]",
            },
            new String[]{
                "1. \"detail 1\" >> print the detail of module 1 in the list",
                "2. \"detail CS2113T\" >> print the detail of module CS2113T",
            }),
    /**
     * Help commands for CAP.
     */
    CAP(
            "cap",
            "Calculate CAP: Calculate CAP for courses based on selected option.",
            new String[]{
                "cap [-option] [module] [grade] {[module] [grade]...}",
                "option: {-u(user, default), -m(multiple/custom modules), -help}"
            },
            new String[]{
                "1. \"cap\" >> calculate user CAP from their taken modules",
                "2. \"cap -m M1 G1 M2 G2 \" >> calculate cap based on input modules: "
                        + "modules M1 with grade G1, module M2 with grade G2 correspondingly.",
            }),
    ;

    /**
     * The Name.
     */
    public String name;
    /**
     * The Description.
     */
    public String description;
    /**
     * The Syntax.
     */
    public String[] syntax;
    /**
     * The Usages.
     */
    public String[] usages;

    HelpText(String name, String description, String[] syntax, String[] usages) {
        this.name = name;
        this.syntax = syntax;
        this.description = description;
        this.usages = usages;
    }

    /**
     * Array to string string.
     *
     * @param input the input
     * @return the string
     */
    public String arrayToString(String[] input) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string: input) {
            stringBuilder.append(string).append(Constants.WIN_NEWLINE);
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Name:");
        stringBuilder.append(Constants.SPACE).append(name).append(Constants.WIN_NEWLINE);
        stringBuilder.append("Description:").append(Constants.SPACE).append(
                description).append(Constants.WIN_NEWLINE);
        stringBuilder.append("Syntax:").append(Constants.WIN_NEWLINE).append(arrayToString(syntax));
        stringBuilder.append("Usages:").append(Constants.WIN_NEWLINE).append(arrayToString(usages));
        return stringBuilder.toString();
    }
}
