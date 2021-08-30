package duke.command;

import duke.DukeException;
import duke.Storage;
import duke.task.TaskList;
import duke.Ui;

/**
 * Represents an terminate command
 */
public class ByeCommand extends Command {

    public static final String COMMAND_WORD = "bye";
    public static final String USAGE_TEXT = "Usage: bye";

    /**
     * Saves tasks in given TaskList and displays final message.
     *
     * @param taskList List of tasks.
     * @param ui User interface.
     * @param storage Storage of tasks.
     * @throws DukeException If error occurs while saving tasks.
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        try {
            // Save taskList
            storage.save(taskList);
        } catch (DukeException e) {
            ui.showLoadingError(e.getMessage());
        }
        ui.showBye();
    }
}
