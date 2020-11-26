import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Member {
    private static int i = 0;
    private int id;
    private int studentCode;
    private String fullName;
    private String sex;
    private String className;
    private String address;
    private String schoolYear;
    private String phone;
    private String email;
    private LinkedList<Subject> subjects = new LinkedList<>();

    private int n;
    public Member() {
    }

    public Member(int id, int studentCode, String fullName, String sex, String className, String address, String schoolYear, String phone, String email, LinkedList<Subject> subjects) {
        this.id = id;
        this.studentCode = studentCode;
        this.fullName = fullName;
        this.sex = sex;
        this.className = className;
        this.address = address;
        this.schoolYear = schoolYear;
        this.phone = phone;
        this.email = email;
        this.subjects = subjects;
    }

    public Member(int id, int studentCode, String fullName, String sex, String className, String address, String schoolYear, String phone, String email) {
        this.id = id;
        this.studentCode = studentCode;
        this.fullName = fullName;
        this.sex = sex;
        this.className = className;
        this.address = address;
        this.schoolYear = schoolYear;
        this.phone = phone;
        this.email = email;
    }

    public static int getI() {
        return i;
    }

    public static void setI(int i) {
        Member.i = i;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LinkedList<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(LinkedList<Subject> subjects) {
        this.subjects = subjects;
    }

    public int getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(int studentCode) {
        this.studentCode = studentCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(String schoolYear) {
        this.schoolYear = schoolYear;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void importMember(){
        i++;
        this.id = i;
        Scanner sc = new Scanner(System.in);
        System.out.println("====NHAP THONG TIN====");
        System.out.println("nhap ma sv: ");
        this.studentCode = sc.nextInt();
        sc.nextLine();
//        System.out.println("nhap ho va ten: ");
//        this.fullName = sc.nextLine();
//        System.out.println("nhap gioi tinh: ");
//        this.sex = sc.nextLine();
//        System.out.println("nhap ten lop (tren truong): ");
//        this.className = sc.nextLine();
//        System.out.println("nhap dia chi: ");
//        this.address = sc.nextLine();
//        System.out.println("nhap khoa (VD: K14): ");
//        this.schoolYear = sc.nextLine();
//        System.out.println("nhap sdt: ");
//        this.phone = sc.nextLine();
//        System.out.println("nhap email: ");
//        this.email = sc.nextLine();
//        System.out.println("nhap so lop hoc (clb): ");
//        this.n = sc.nextInt();

//        for(int i = 0 ; i < n; i++){
//            Subject p = new Subject();
//            p.importSubject();
//            subjects.add(p);
//        }
    }

    public void exportMember(){
        System.out.printf("%-15d%-15s%-20d%-15s%-15s%-15s%-15s%-15s%-15s", id, this.fullName, this.studentCode,this.sex, this.className, this.address,this.schoolYear, this.phone, this.email);
        System.out.println();

//        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s", "Id", "SubjectName", "TeacherName", "StartDay", "EndDay", "NumberOfStudent");
    }
}
