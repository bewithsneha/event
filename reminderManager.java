import java.util.ArrayList;
import java.time.LocalDate;

public class reminderManager {
    private ArrayList<Event> arr;

    public reminderManager() {
        arr = new ArrayList<>();
    }

    // Add event
    public void addEvent(Event e) {
        arr.add(e);
        System.out.println("Event added successfully!");
    }

    // Display all events
    public void displayEvents() {
        if (arr.isEmpty()) {
            System.out.println("No events to display.");
            return;
        }
        System.out.println("All Events:");
        for (int i = 0; i < arr.size(); i++) {
            Event e = arr.get(i);
            System.out.println((i + 1) + ". " + e); // Uses Event.toString()
        }
    }

    // Show occurred events (date <= today)
    public void showOccurredEvents() {
        LocalDate today = LocalDate.now();
        boolean found = false;
        for (Event e : arr) {
            if (!e.isCompleted() && !e.getDate().isAfter(today)) {
                System.out.println(e);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No occurred events yet.");
        }
    }

    // Mark event as completed
    public void markEventCompleted(int ind) {
        if (ind <= 0 || ind > arr.size()) {
            System.out.println("Invalid event number!");
            return;
        }
        Event e = arr.get(ind - 1);
        e.markCompleted();
        System.out.println("Event marked as completed: " + e.getTitle());
    }

    // Remove an event
    public void removeEvent(int ind) {
        if (ind <= 0 || ind > arr.size()) {
            System.out.println("Invalid event number!");
            return;
        }
        Event e = arr.remove(ind - 1);
        System.out.println("Event removed successfully: " + e.getTitle());
    }
}
