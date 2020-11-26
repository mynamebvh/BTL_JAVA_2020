import java.util.Scanner;

public class Date {
    private int day;
    private int month;
    private int year;

    public Date() {
    }

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void importDate(){
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap ngay: ");
        this.day = sc.nextInt();
        System.out.println("nhap thang: ");
        this.month = sc.nextInt();
        System.out.println("nha nam: ");
        this.year = sc.nextInt();
    }

    public String exportDate(){
        return this.day + "/" + this.month + "/" + this.year;
    }
}
