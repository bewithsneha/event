import java.time.LocalDate;

public class Event {
    private String title;
    private String description;
    private LocalDate date;
    private boolean completed;

    public Event(String title, String description, LocalDate date) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.completed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markCompleted() {
        this.completed = true;
    }

    @Override
    public String toString() {
        return title + " | " + description + " | " + date + (completed ? " | Completed" : "");
    }
}
