
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int choice = 0;

    while (choice != 4) {
      printMenu();
      String input = readInput(scanner, "Enter your choice: ");
      try {
        choice = Integer.parseInt(input);
      } catch (NumberFormatException e) {
        System.out.println("Invalid input. Please enter a number.");
        continue;
      }

      Program program;
      switch (choice) {
        case 1 -> program = new LinkedListProgram();
        case 2 -> program = new StackProgram();
        case 3 -> program = new QueueProgram();
        case 4 -> {
          System.out.println("Exiting the program.");
          continue;
        }
        default -> {
          System.out.println("Invalid choice. Please try again.");
          continue;
        }
      }

      program.run();
    }

    scanner.close();
  }

  public static void printMenu() {
    System.out.println("===== Program Menu =====");
    System.out.println("1. Linked List Program");
    System.out.println("2. Stack Program");
    System.out.println("3. Queue Program");
    System.out.println("4. Exit");
  }

  public static String readInput(Scanner scanner, String prompt) {
    System.out.print(prompt);
    return scanner.nextLine();
  }

  public static class LinkedListProgram implements Program {
    @Override
    public void run() {
      // Buat program untuk Linked List di sini
      System.out.println("Running Linked List Program...");
    }
  }

  public static class StackProgram implements Program {
    private Stack<String> undoStack;
    private Stack<String> redoStack;
    private String currentText;

    public StackProgram() {
      undoStack = new Stack<>();
      redoStack = new Stack<>();
      currentText = "";
    }

    public void addText(String text) {
      undoStack.push(currentText);
      currentText += text;
      redoStack = new Stack<>(); // Clear redo stack
    }

    public void undo() {
      if (!undoStack.isEmpty()) { // jika undoStack tidak kosong, lakukan undo
        redoStack.push(currentText); // simpan currentText ke redoStack sebelum melakukan undo
        currentText = undoStack.pop(); // ambil teks terakhir dari undoStack dan jadikan currentText
      } else {
        System.out.println("Tidak ada aksi apapun untuk di-undo.");
      }
    }

    public void redo() {
      if (!redoStack.isEmpty()) { // jika redoStack tidak kosong, lakukan redo
        undoStack.push(currentText); /// simpan currentText ke undoStack sebelum melakukan redo
        currentText = redoStack.pop(); // ambil teks terakhir dari redoStack dan jadikan currentText
      } else {
        System.out.println("Tidak ada aksi apapun untuk di-redo.");
      }
    }

    public String getCurrentText() {
      return currentText;
    }

    @Override
    public void run() {
      System.out.println();

      addText("Selamat");
      addText(" datang");

      System.out.printf("Teks saat ini: \"%s\"%n", getCurrentText());

      undo();
      System.out.printf("Undo: \"%s\"%n", getCurrentText());

      redo();
      System.out.printf("Redo: \"%s\"%n", getCurrentText());

      System.out.println();
    }
  }

  public static class QueueProgram implements Program {
    @Override
    public void run() {
      // Buat program untuk Queue di sini
      System.out.println("Running Queue Program...");
    }
  }
}
