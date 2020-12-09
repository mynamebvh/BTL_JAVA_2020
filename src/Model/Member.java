package Model;

import java.util.Scanner;

public class Member {
    private static int i = 0;
    private int studentId;
    private int studentCode;
    private String fullName;
    private String sex;
    private String className;
    private String address;
    private String schoolYear;
    private String phone;
    private String email;

    public Member() {
    }

    public Member(int studentId,int studentCode, String fullName, String sex, String className, String address, String schoolYear, String phone, String email) {
        this.studentId = studentId;
        this.studentCode = studentCode;
        this.fullName = fullName;
        this.sex = sex;
        this.className = className;
        this.address = address;
        this.schoolYear = schoolYear;
        this.phone = phone;
        this.email = email;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
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

    public void ImportMember(int id){
        //Regex
        String regexId ="^[0-9]+$";
        String regexStudentCode = "^\\d{10}$";
        String regexFullName = "^[^0-9!@#$%^&*()_+{}:\"<>?\\-=;',.\\[\\]]+$";
        String regexSex = "^(nam)|(nữ)|(Nam)|(Nữ)$";
        String regexClassName = "^[a-zA-Z]{4}[0-9]{1,2}$";
        String regexSchoolYear = "^K[0-9]{1,2}$";
        String regexPhone = "^0(9\\d{8}|3\\d{8}|5\\d{8})$";
        String regexEmail = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

        Scanner sc = new Scanner(System.in);

        do{
            this.studentId = id;
        }while (!Integer.toString(this.studentId).matches(regexId));

        do{
            System.out.println("nhập mã sinh viên: ");
            this.studentCode = sc.nextInt();
        }while (!Integer.toString(this.studentCode).matches(regexStudentCode));

        sc.nextLine();
        do {
            System.out.println("nhập họ và tên: ");
            this.fullName = sc.nextLine();
        }while (!this.fullName.matches(regexFullName));

        do{
            System.out.println("nhập giới tính: ");
            this.sex = sc.nextLine().toLowerCase();
        }while (!this.sex.matches(regexSex));

        do {
            System.out.println("Nhập lớp (trên trường): ");
            this.className = sc.nextLine();
        }while (!this.className.matches(regexClassName));
        System.out.println("Nhập địa chỉ: ");
        this.address = sc.nextLine();

        do {
            System.out.println("Nhập khóa: ");
            this.schoolYear = sc.nextLine();
        }while (!this.schoolYear.matches(regexSchoolYear));

        do {
            System.out.println("Nhập sđt: ");
            this.phone = sc.nextLine();
        }while (!this.phone.matches(regexPhone));

        do {
            System.out.println("Nhập email: ");
            this.email = sc.nextLine();
        }while (!this.email.matches(regexEmail));
    }

    public void ExportMember(){
        System.out.printf("%-15d%-15d%-20s%-10s%-10s%-15s%-15s%-15s%-15s", this.studentId, this.studentCode
                , this.fullName, this.sex, this.className, this.address, this.schoolYear, this.phone,
                this.email);
        System.out.println();
    }

    @Override
    public String toString() {
        return "Member{" +
                "studentId=" + studentId +
                ", studentCode=" + studentCode +
                ", fullName='" + fullName + '\'' +
                ", sex='" + sex + '\'' +
                ", className='" + className + '\'' +
                ", address='" + address + '\'' +
                ", schoolYear='" + schoolYear + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
