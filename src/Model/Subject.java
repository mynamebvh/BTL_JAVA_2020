package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.SimpleFormatter;

public class Subject {
    private int subjectId;
    private String subjectName;
    private String teacherName;
    private String startDay;
    private String endDay;
    private int numberOfStudent;


    public Subject() {
    }

    public Subject(int subjectId, String subjectName, String teacherName, String startDay, String endDay, int numberOfStudent) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.teacherName = teacherName;
        this.startDay = startDay;
        this.endDay = endDay;
        this.numberOfStudent = numberOfStudent;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
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

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public int getNumberOfStudent() {
        return numberOfStudent;
    }

    public void setNumberOfStudent(int numberOfStudent) {
        this.numberOfStudent = numberOfStudent;
    }

    public void ImportSubject(int subjectId){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        this.subjectId = subjectId;
        System.out.println("Nhập tên lớp: ");
        this.subjectName = sc.nextLine();
        System.out.println("Nhập tên giáo viên: ");
        this.teacherName = sc.nextLine();

        try {
            System.out.println("Nhập ngày bắt đầu: ");
            Date dateStart = simpleDateFormat.parse(sc.nextLine());
            this.startDay = simpleDateFormat.format(dateStart);
            System.out.println("Nhập ngày kết thúc: ");
            Date dateEnd = simpleDateFormat.parse(sc.nextLine());
            this.endDay = simpleDateFormat.format(dateEnd);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Nhập số học sinh: ");
        this.numberOfStudent = sc.nextInt();
    }

    public void ExportSubject(){
        System.out.printf("%-15d%-15s%-20s%-15s%-15s%-15d", this.subjectId, this.subjectName, this.teacherName,
                this.startDay, this.endDay, this.numberOfStudent);
        System.out.println();
    }
    @Override
    public String toString() {
        return "Subject{" +
                "subjectId=" + subjectId +
                ", subjectName='" + subjectName + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", startDay='" + startDay + '\'' +
                ", endDay='" + endDay + '\'' +
                ", numberOfStudent=" + numberOfStudent +
                '}';
    }
}
