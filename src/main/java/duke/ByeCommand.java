package duke;

public class ByeCommand extends Command {

    public static final String COMMAND_WORD = "bye";
    public static final String USAGE_TEXT = "Usage: bye";

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        try {
            storage.save(taskList);
        } catch (DukeException e) {
            ui.showLoadingError(e.getMessage());
        }
        ui.showBye();
    }
}
