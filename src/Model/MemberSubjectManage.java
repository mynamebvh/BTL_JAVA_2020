package Model;

import Model.Member;
import Model.Subject;

import java.util.Scanner;

public class MemberSubjectManage {
    private Member member;
    private Subject subject;
    private String statusSubject;

    public MemberSubjectManage() {
    }

    public MemberSubjectManage(Member member, Subject subject, String statusSubject) {
        this.member = member;
        this.subject = subject;
        this.statusSubject = statusSubject;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getStatusSubject() {
        return statusSubject;
    }

    public void setStatusSubject(String statusSubject) {
        this.statusSubject = statusSubject;
    }

    public void ImportMemberSubjectManage(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập id thành viên: ");

    }

    public void ExportMemberSubjectManage(){
        System.out.printf("%-15d%-15d%-15s", this.member.getStudentId(), this.subject.getSubjectId(),
                this.statusSubject);
        System.out.println();
    }
}
