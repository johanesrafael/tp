package jobs;

import constants.Constants;

public class ToDo extends Task {

    public ToDo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return Constants.TODO_ICON + super.toString();
    }
}
