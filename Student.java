// kelas student untuk menyimpan data mahasiswa:
public class Student {
  private String nim;
  private String nama;
  private int nilai;

  public Student(String nim, String nama, int nilai) {
    this.nim = nim;
    this.nama = nama;
    this.nilai = nilai;
  }

  // getter
  public String getNim() {
    return nim;
  }

  public String getNama() {
    return nama;
  }

  public int getNilai() {
    return nilai;
  }

  // setter
  public void setNim(String nim) {
    this.nim = nim;
  }

  public void setNama(String nama) {
    this.nama = nama;
  }

  public void setNilai(int nilai) {
    this.nilai = nilai;
  }

  @Override
  public String toString() {
    return "NIM: " + nim + ", Nama: " + nama + ", Nilai: " + nilai;
  }
}
