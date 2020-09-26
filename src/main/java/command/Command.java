package command;

import command.action.UnknownAction;
import constants.Constants;
import command.action.Action;
import constants.HelpText;
import data.TaskList;
import exceptions.InvalidCommandException;

public class Command implements Help {

    public ParamNode args;
    public ParamNode[] flattenedArgs;
    public String name;
    private HelpText helpText;
    public Action action;
    public String result = "";

    public Command(ParamNode args) {
        this.args = args;
        name = args.name;
        flattenedArgs = new ParamNode[0];
        if (args.thisData != null) {
            flattenedArgs = args.thisData.flatten().toArray(flattenedArgs);
        }
        helpText = Constants.helpMap.getOrDefault(name, HelpText.UNKNOWN); // later change to help.
        initiateAction();
    }

    private boolean isArgsValid() {
        String targetArg = Constants.paramMap.get(name);
        if (targetArg == null) {
            return true; // does not need any parameter
        } else {
            for (ParamNode node: flattenedArgs) {
                if (targetArg.equals(node.name)) {
                    return true;
                }
            }
            return false;
        }
    }

    private void initiateAction() {
        action = Constants.actionMap.getOrDefault(name, new UnknownAction());
    }

    public void execute(TaskList tasks) {
        try {
            if (isArgsValid()) {
                action.prepare(args);
                result = action.act(tasks);
            } else {
                throw new InvalidCommandException();
            }
        } catch (Exception e) {
            StringBuilder builder = new StringBuilder(Constants.INVALID);
            for (String string: getSyntax()) {
                builder.append(string).append(Constants.TAB);
            }
            result = builder.toString();
        }
    }

    public boolean isExit() {
        return result.equals(Constants.messageMap.get(Constants.BYE));
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return helpText.description;
    }

    @Override
    public String[] getSyntax() {
        return helpText.syntax;
    }

    @Override
    public String[] getUsages() {
        return helpText.usages;
    }

    @Override
    public String getHelp() {
        return helpText.toString();
    }

    @Override
    public String toString() {
        return args.toString();
    }

}