package Controller;

import Model.Member;
import Model.MemberSubjectManage;
import Model.Subject;

import java.io.*;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Scanner;

public class FileManageController {
    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;
    private PrintWriter printWriter;
    private Scanner scanner;


    public void OpenFileToWrite(String fileName){
        try {
            fileWriter = new FileWriter(fileName, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(bufferedWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void OpenFileToWriteNoAppend(String fileName){
        try {
            fileWriter = new FileWriter(fileName);
            bufferedWriter = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(bufferedWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void CloseFileAfterWrite(String fileName){

        try {
            printWriter.close();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void OpenFileToRead(String fileName){
        try {
            File file = new File(fileName);
            if (!file.exists()){
                file.createNewFile();
            }
            scanner = new Scanner(Paths.get(fileName), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void CloseFileAfterRead(String fileName){
        try {
            scanner.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void WriteMemberToFile(String fileName, Member member){
        OpenFileToWrite(fileName);
        printWriter.println(member.getStudentId() + "|" + member.getStudentCode() + "|" + member.getFullName() + "|" +
                member.getSex() + "|" + member.getClassName() + "|" + member.getAddress() + "|"
                + member.getSchoolYear() + "|" + member.getPhone() + "|" + member.getEmail());
        CloseFileAfterWrite(fileName);
    }

    public void WriteSubjectToFile(String fileName, Subject subject){
        OpenFileToWrite(fileName);
        printWriter.println(subject.getSubjectId() + "|" + subject.getSubjectName() + "|" + subject.getTeacherName()
                + "|" + subject.getStartDay() + "|" + subject.getEndDay() + "|" + subject.getNumberOfStudent());
        CloseFileAfterWrite(fileName);
    }

    public void WriteMemSubManageToFile(String fileName, MemberSubjectManage memberSubjectManage){
        OpenFileToWrite(fileName);
        printWriter.println(memberSubjectManage.getMember().getStudentId() + "|"
                + memberSubjectManage.getSubject().getSubjectId() + "|" + memberSubjectManage.getStatusSubject());
        CloseFileAfterWrite(fileName);
    }

    public LinkedList<Member> ReadMemberFromFile(String fileName){
        OpenFileToRead(fileName);
        LinkedList<Member> memberList = new LinkedList<>();
        while (scanner.hasNext()){
            String data = scanner.nextLine();
            Member member = CupMemberFromData(data);
            memberList.add(member);
        }
        CloseFileAfterRead(fileName);
        return memberList;
    }

    private Member CupMemberFromData(String data) {
        String[] datas = data.split("\\|");
        Member member = new Member(Integer.parseInt(datas[0]), Integer.parseInt(datas[1]), datas[2], datas[3]
                ,datas[4], datas[5], datas[6], datas[7],datas[8]);
        return member;
    }

    public LinkedList<Subject> ReadSubjectFromFile(String fileName){
        OpenFileToRead(fileName);
        LinkedList<Subject> subjectList = new LinkedList<>();
        while (scanner.hasNext()){
            String data = scanner.nextLine();
            Subject subject = CupSubjectFromData(data);
            subjectList.add(subject);
        }
        CloseFileAfterRead(fileName);
        return subjectList;
    }

    private Subject CupSubjectFromData(String data) {
        String[] datas = data.split("\\|");
        Subject subject = new Subject(Integer.parseInt(datas[0]),datas[1],datas[2],datas[3], datas[4],Integer.parseInt(datas[5]));
        return subject;
    }

    public LinkedList<MemberSubjectManage> ReadMemSubManageFromFile(String fileName){
        LinkedList<Member> memberList = ReadMemberFromFile("./Member.txt");
        LinkedList<Subject> subjectsList = ReadSubjectFromFile("./Subject.txt");
        OpenFileToRead(fileName);
        LinkedList<MemberSubjectManage> memberSubjectManages = new LinkedList<>();
        while (scanner.hasNext()){
            String data = scanner.nextLine();
            MemberSubjectManage temp = CupMemSubManageFromData(data, memberList, subjectsList);
            memberSubjectManages.add(temp);
        }
        CloseFileAfterRead(fileName);
        return memberSubjectManages;
    }

    private MemberSubjectManage CupMemSubManageFromData(String data, LinkedList<Member> member
            , LinkedList<Subject> subjects){

        String[] datas = data.split("\\|");

        Member mem = getMember(member, Integer.parseInt(datas[0]));
        Subject sub = getSubject(subjects, Integer.parseInt(datas[1]));
        MemberSubjectManage memberSubjectManage = new MemberSubjectManage(mem, sub, datas[2]);
        return memberSubjectManage;
    }

    public void UpdateMember(String fileName, LinkedList<Member> members){
        File file = new File(fileName);
        if(file.exists()){
            file.delete();
        }

        OpenFileToWriteNoAppend(fileName);
        for(Member member : members){
            WriteMemberToFile(fileName, member);
        }
        CloseFileAfterWrite(fileName);
    }

    public void UpdateSubject(String fileName, LinkedList<Subject> subjects){
        File file = new File(fileName);
        if(file.exists()){
            file.delete();
        }

        OpenFileToWriteNoAppend(fileName);
        for(Subject subject : subjects){
            WriteSubjectToFile(fileName, subject);
        }
        CloseFileAfterWrite(fileName);
    }

    public void UpdateMemSubManage(String fileName, LinkedList<MemberSubjectManage> MSMS){
        File file = new File(fileName);

        if(file.exists()){
            file.delete();
        }

        OpenFileToWriteNoAppend(fileName);
        for(MemberSubjectManage MSM : MSMS){
            WriteMemSubManageToFile(fileName, MSM);
        }

        CloseFileAfterWrite(fileName);

    }
    public Member getMember(LinkedList<Member> member, int memberId){
        for(Member mem : member){
            if(mem.getStudentId() == memberId)
                return mem;
        }
        return null;
    }


    public Subject getSubject(LinkedList<Subject> subjects, int subjectId){
        for(Subject sub : subjects)
            if(sub.getSubjectId() == subjectId)
                return sub;
        return null;
    }
}
