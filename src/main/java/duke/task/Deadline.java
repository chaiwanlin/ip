package duke.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Represents a task with a deadline
 */
public class Deadline extends Task {

    protected LocalDate date;

    /**
     * Deadline constructor.
     *
     * @param description Description of deadline task.
     * @param date Date of deadline.
     */
    public Deadline(String description, LocalDate date) {
        super(description);
        this.date = date;
    }

    /**
     * Returns a Deadline from string input with description and date.
     *
     * @param args String input with description and date in
     *                  '[description] (by: [MMM d yyyy]' format.
     * @return Deadline from string input with description and date.
     */
    public static Deadline build(String args) {
        String[] desc_date = Task.splitDescriptionAndDate(args, "by");
        String desc = desc_date[0];
        String dateString = desc_date[1];
        LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("MMM d yyyy"));
        return new Deadline(desc, date);
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + date.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ")";
    }
}