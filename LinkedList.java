// implementasi Single Linked List untuk menyimpan data mahasiswa
public class LinkedList {

  private Node<Student> head; // pointer ke node pertama

  public LinkedList() {
    head = null;
  }

  // menambahkan mahasiswa baru ke akhir list
  public void addStudent(Student student) {
    Node<Student> newNode = new Node<>(student);

    if (head == null) { // jika list masih kosong, langsung jadi head
      head = newNode;
      return;
    }

    // cari node terakhir lalu sambungkan
    Node<Student> current = head;
    while (current.getNext() != null) {
      current = current.getNext();
    }
    current.setNext(newNode);
  }

  // menghapus mahasiswa berdasarkan NIM, return true jika berhasil
  public boolean deleteStudent(String nim) {
    if (head == null) return false; // list kosong

    if (head.getData().getNim().equals(nim)) { // cek apakah head yang dihapus
      head = head.getNext();
      return true;
    }

    // cari node sebelum node yang akan dihapus
    Node<Student> current = head;
    while (current.getNext() != null) {
      if (current.getNext().getData().getNim().equals(nim)) {
        current.setNext(current.getNext().getNext()); // lewati node yang dihapus
        return true;
      }
      current = current.getNext();
    }

    return false; // NIM tidak ditemukan
  }

  // mengupdate nilai mahasiswa berdasarkan NIM, return true jika berhasil
  public boolean updateNilai(String nim, int nilaBaru) {
    Node<Student> current = head;

    while (current != null) {
      if (current.getData().getNim().equals(nim)) {
        current.getData().setNilai(nilaBaru); // set nilai baru
        return true;
      }
      current = current.getNext();
    }

    return false; // NIM tidak ditemukan
  }

  // enampilkan seluruh daftar mahasiswa
  public void displayAll() {
    if (head == null) {
      System.out.println("Daftar mahasiswa kosong.");
      return;
    }

    System.out.println("Daftar Mahasiswa:");
    Node<Student> current = head;
    int index = 1;

    while (current != null) {
      System.out.println(index + ". " + current.getData());
      current = current.getNext();
      index++;
    }
    System.out.println(); // baris kosong agar rapi
  }

  // mengecek apakah linked list kosong
  public boolean isEmpty() {
    return head == null;
  }
}