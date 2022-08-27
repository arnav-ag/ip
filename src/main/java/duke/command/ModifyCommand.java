package duke.command;

import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

public class ModifyCommand extends Command {
    enum CommandType {
        DONE,
        UNDONE,
        LIST
    }

    private CommandType commandType;

    ModifyCommand(CommandType commandType, int index) {
        super(index);
        this.commandType = commandType;
    }

    ModifyCommand(CommandType commandType) {
        this.commandType = commandType;
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) {
        switch (commandType) {
            case DONE:
                tasks.markAsDone(index, ui);
                break;
            case UNDONE:
                tasks.markAsUndone(index, ui);
                break;
            case LIST:
                tasks.listTasks(ui);
                break;
        }

        storage.saveToFile(tasks);
    }
}