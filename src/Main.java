import model.Expense;
import service.ExpenseManager;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExpenseManager manager = new ExpenseManager();
        int choice;
        do {
            System.out.println("\n=== Personal Expense Tracker ===");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. View Total");
            System.out.println("4. Exit");
            System.out.println("Choose an Option: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 ->{
                    System.out.println("Enter Category");
                    String category = sc.nextLine();
                    System.out.print("Enter amount: ");
                    double amount = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Enter date (yyyy-mm-dd): ");
                    String date = sc.nextLine();
                    manager.addExpense(new Expense(category, amount, date));
                    System.out.println("Expense added successfully!");
                }
                case 2 -> manager.viewExpenses();
                case 3 -> manager.viewTotal();
                case 4 -> System.out.println("Exiting... Goodbye!");
                default -> System.out.println("Invalid choice, please try again! ");

            }
        }while (choice != 4);
        sc.close();
    }

}
