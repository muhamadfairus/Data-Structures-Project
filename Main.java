
import java.util.Scanner;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

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
      redoStack.clear(); // Clear redo stack
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
      long start = System.nanoTime();
      System.out.println();

      addText("Selamat");
      addText(" datang");

      System.out.printf("Teks saat ini: \"%s\"%n", getCurrentText());

      undo();
      System.out.printf("Undo: \"%s\"%n", getCurrentText());

      redo();
      System.out.printf("Redo: \"%s\"%n", getCurrentText());


      long end = System.nanoTime();
      double durationMs = (end - start) / 1_000_000.0;
      System.out.printf("===== Stack Execution time: %.3f ms =====%n", durationMs);
      System.out.println();
    }
  }

  public static class QueueProgram implements Program {
	    // Menggunakan LinkedList bawaan Java sebagai Queue
	    private Queue<String> customerQueue;

	    public QueueProgram() {
	      customerQueue = new LinkedList<>();
	    }

	    // Fitur 1: Tambah pelanggan baru ke antrean
	    public void addCustomer(String name) {
	      customerQueue.add(name);
	    }

	    // Fitur 2: Layani pelanggan (menghapus dari antrean/FIFO)
	    public void serveCustomer() {
	      if (!customerQueue.isEmpty()) {
	        String served = customerQueue.poll();
	        System.out.println("Melayani pelanggan: " + served);
	      } else {
	        System.out.println("Antrean kosong. Tidak ada yang bisa dilayani.");
	      }
	    }

	    // Fitur 3: Menampilkan daftar pelanggan
	    public void displayQueue() {
	      System.out.println("Pelanggan dalam antrean:");
	      if (customerQueue.isEmpty()) {
	        System.out.println("Antrean kosong.");
	      } else {
	        int index = 1;
	        // Looping untuk menampilkan setiap pelanggan sesuai urutan
	        for (String customer : customerQueue) {
	          System.out.println(index + ". " + customer);
	          index++;
	        }
	      }
	      System.out.println(); // Jarak baris kosong agar rapi
	    }

	    @Override
	    public void run() {
	      long start = System.nanoTime();
	      System.out.println();

	      // Menambahkan data awal sesuai contoh di soal
	      addCustomer("Andi");
	      addCustomer("Budi");
	      addCustomer("Siti");

	      // Menampilkan kondisi awal antrean
	      displayQueue();

	      // Melayani pelanggan pertama (Andi)
	      serveCustomer();

	      // Menampilkan kondisi antrean setelah dilayani
	      displayQueue();

	      // Menghitung waktu eksekusi
	      long end = System.nanoTime();
	      double durationMs = (end - start) / 1_000_000.0;
	      System.out.printf("===== Queue Execution time: %.3f ms =====%n", durationMs);
	      System.out.println();
	    }
	  }
}
