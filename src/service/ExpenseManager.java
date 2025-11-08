package service;

import model.Expense;
import java.io.*;
import java.util.*;

public class ExpenseManager {
    private  List<Expense> expenses = new ArrayList<>();
    private  final String FILE_PATH = "expenses.txt";

    public ExpenseManager(){
        loadExpenses();
    }

    public void addExpense(Expense expense){
        expenses.add(expense);
        saveExpenses();
    }
    public void viewExpenses(){
    if(expenses.isEmpty()){
        System.out.println("No expenses recorded yet.");
        return;
    }
        System.out.println("------ All Expenses ------");
        for (Expense e: expenses){
            System.out.println(e.getCategory() + " | $" + e.getAmount() + " | "+ e.getDate());
        }
    }
    public void viewTotal(){
        double total = expenses.stream().mapToDouble(Expense :: getAmount).sum();
        System.out.println("Total spent: $" + total);
    }
    public void saveExpenses(){
        try(PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))){
            for (Expense e : expenses){
                writer.println(e.toString());
            }

        } catch (Exception e) {
            System.out.println("Error Saving data: "+e.getMessage());
        }
    }

    public void loadExpenses(){
        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))){
            String line;
            while ((line = reader.readLine()) != null){
                expenses.add(Expense.fromString(line));
            }
        } catch (Exception e) {

        }
    }

}
