import java.util.Scanner;

public class Subject {
    private static int i = 0;
    private int subjectCode;
    private String subjectName;
    private String teacherName;
    private Date startDay;
    private Date endDay;
    private int numberOfStudent;


    public Subject() {
    }

    public Subject(int subjectCode, String subjectName, String teacherName, Date startDay, Date endDay, int numberOfStudent) {
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.teacherName = teacherName;
        this.startDay = startDay;
        this.endDay = endDay;
        this.numberOfStudent = numberOfStudent;
    }

    public static int getI() {
        return i;
    }

    public static void setI(int i) {
        Subject.i = i;
    }

    public int getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(int subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public int getNumberOfStudent() {
        return numberOfStudent;
    }

    public void setNumberOfStudent(int numberOfStudent) {
        this.numberOfStudent = numberOfStudent;
    }

    public Date getStartDay() {
        return startDay;
    }

    public void setStartDay(Date startDay) {
        this.startDay = startDay;
    }

    public Date getEndDay() {
        return endDay;
    }

    public void setEndDay(Date endDay) {
        this.endDay = endDay;
    }

    public void importSubject() {
        i++;
        this.subjectCode = i;
        Scanner sc = new Scanner(System.in);
            System.out.println("====NHAP THONG TIN SUBJECT====");
            System.out.println("nhap ten lop (clb): ");
            this.subjectName = sc.nextLine();
            System.out.println("nhap ten giao vien: ");
            this.teacherName = sc.nextLine();
            System.out.println("nhap ngay bat dau: ");
            this.startDay = new Date();
            startDay.importDate();
            System.out.println("nhap ngay ket thuc: ");
            this.endDay = new Date();
            this.endDay.importDate();
            System.out.println("nhap so luong hoc sinh: ");
            this.numberOfStudent = sc.nextInt();
    }


    public void exportSubject() {
            System.out.printf("%-15d%-15s%-15s%-15s%-15s%-15d", subjectCode, this.subjectName, this.teacherName, this.startDay.exportDate(), this.endDay.exportDate(), this.numberOfStudent);
            System.out.println();
    }

}
