import java.util.Scanner;
import java.time.LocalDate;

public class Executer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        reminderManager rm = new reminderManager();

        while (true) {
            System.out.println("\n**** Event Menu ****");
            System.out.println("1. Add event");
            System.out.println("2. Display events");
            System.out.println("3. Show occurred events");
            System.out.println("4. Mark event as completed");
            System.out.println("5. Remove Event");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int ch = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (ch) {
                case 1:
                    System.out.print("Enter event title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter event description: ");
                    String desc = sc.nextLine();
                    System.out.print("Enter event date (yyyy-MM-dd): ");
                    String dateStr = sc.nextLine();
                    try {
                        LocalDate date = LocalDate.parse(dateStr);
                        Event e = new Event(title, desc, date);
                        rm.addEvent(e);
                    } catch (Exception ex) {
                        System.out.println("Invalid date format! Use yyyy-MM-dd.");
                    }
                    break;

                case 2:
                    rm.displayEvents();
                    break;

                case 3:
                    rm.showOccurredEvents();
                    break;

                case 4:
                    System.out.print("Enter event number to mark as completed: ");
                    int comp = sc.nextInt();
                    rm.markEventCompleted(comp);
                    break;

                case 5:
                    System.out.print("Enter event number to remove: ");
                    int rem = sc.nextInt();
                    rm.removeEvent(rem);
                    break;

                case 6:
                    System.out.println("Exiting... Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Not a valid input!");
            }
        }
    }
}
