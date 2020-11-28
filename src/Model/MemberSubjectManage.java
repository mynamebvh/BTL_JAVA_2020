package Model;

import Model.Member;
import Model.Subject;

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

}
