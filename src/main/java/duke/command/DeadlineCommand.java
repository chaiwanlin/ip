package duke.command;

import duke.task.Deadline;
import duke.task.Task;
import duke.task.TaskList;

import duke.Ui;
import duke.Storage;

import java.time.LocalDate;

public class DeadlineCommand extends Command {

    public static final String COMMAND_WORD = "deadline";
    public static final String USAGE_TEXT = "Usage: deadline [description] /by [date in YYYY-MM-DD format]";

    private String description;
    private LocalDate date;

    public DeadlineCommand(String desc, LocalDate date) {
        description = desc;
        this.date = date;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        // Add new deadline
        Task task = new Deadline(description, date);
        taskList.addTask(task);
        ui.showTasksReply(true, task.toString(), taskList.size());
    }
}
