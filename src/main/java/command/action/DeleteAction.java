package command.action;

import command.ParamNode;
import constants.Constants;
import data.TaskList;
import jobs.Task;

public class DeleteAction extends Action {

    private int index;

    @Override
    public String act(TaskList tasks) {
        if (index < 0 || index >= tasks.tasks.size()) {
            return Constants.INDEX_OUT;
        }
        Task task = tasks.tasks.get(index);
        String result = super.act(tasks);
        tasks.tasks.remove(task);
        return replaceStrings(result, task.toString(), tasks.tasks.size());
    }

    @Override
    public void prepare(ParamNode args) {
        super.prepare(args);
        index = getIndex(args.thisData.name);
    }
}
