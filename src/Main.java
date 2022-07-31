import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public boolean shouldQuit = false;
    public static ArrayList<String> tasks;
    public static Scanner scanner = new Scanner(System.in);

    public Main() {
        tasks = new ArrayList<String>();
    }

    public static void main(String[] args) {

        Main l = new Main();
        setUpArrList();

        System.out.println("This is the list.");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(i + " " + tasks.get(i));
        }
        do {

            String answer = (SafeInput.getRegExString(scanner, "What would you like to do, Add an item, Delete an item, Print the list, or Quit? (A/D/P/Q)", "[AaDdPpQq]"));

            if (answer.equalsIgnoreCase("A")) {
                addToList();
            } else if (answer.equalsIgnoreCase("D")) {
                deleteFromList();
            } else if (answer.equalsIgnoreCase("P")) {
                printList();
            } else if (answer.equalsIgnoreCase("Q")) {
                if (quit()) {
                    break;
                }
            }
        } while (l.shouldQuit == false);
    }


    public static void addToList() {
        //A
        tasks.add(SafeInput.getNonZeroLenString(scanner, "Please input what you want added to the list"));
    }

    public static void deleteFromList() {
        //D
        tasks.remove(SafeInput.getRangedInt(scanner, "What is the number of the item you'd like to remove?", 0, tasks.size() - 1));
    }

    public static boolean quit() {
        //Q
        return SafeInput.getYNConfirm(scanner, "Do you wish to quit?");
    }

    public static void printList() {

        //P
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(i + " " + tasks.get(i));
        }
    }

    public static void setUpArrList() {
        tasks.add("Hi");
        tasks.add("Hello");
        tasks.add("Hey");
        tasks.add("Howdy");
    }
}