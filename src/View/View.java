package View;

import Controller.FunctionController;
import Controller.FileManageController;
import Model.Member;
import Model.MemberSubjectManage;
import Model.Subject;

import java.io.File;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class View {
    public static void main(String[] args) {
        // Khai báo các hằng số
        final String FILE_NAME_MEMBER = "./Member.txt";
        final String FILE_NAME_SUBJECT = "./Subject.txt";
        final String FILE_NAME_MEMSUBMANAGE = "./MSM.txt";


        // Khai báo các đối tượng
        Scanner sc = new Scanner(System.in);
        FunctionController functionController = new FunctionController();
        FileManageController fileManageController = new FileManageController();

        int choose;
        while (true){
            int memberId, subjectId;
            LinkedList<Member> members = fileManageController.ReadMemberFromFile(FILE_NAME_MEMBER);
            LinkedList<Subject> subjects = fileManageController.ReadSubjectFromFile(FILE_NAME_SUBJECT);
            LinkedList<MemberSubjectManage> memberSubjectManages = fileManageController.ReadMemSubManageFromFile(
                    FILE_NAME_MEMSUBMANAGE
            );

            System.out.println("=============MENU=============");
            System.out.println("1. Thêm thành viên\n2. Hiển thị thành viên\n3. Sửa thông tin thành viên");
            System.out.println("4. Xóa thành viên\n5. Thêm lớp học\n6. Hiển thị lớp học");
            System.out.println("7. Sửa lớp học\n8. Xóa lớp học\n" +
                    "9. Tạo thông tin MemBer Subject Manage (MSM): " + "\n10. Hiển thị MSM" +
                    "\n11. Sắp xếp\n12. Tìm kiếm\n0. Thoát");

            System.out.println("nhập lựa chọn: ");
            choose = sc.nextInt();

            if(choose == 0)
                break;
            else{
                switch (choose){
                    case 1:
                        memberId = functionController.CheckMemberStrict(members);
                        Member member = new Member();
                        member.ImportMember(memberId);
                        functionController.AddMemberNew(FILE_NAME_MEMBER, members, member);
                        break;
                    case 2:
                        System.out.println("===================DANH SÁCH TV===================");
                        functionController.DisplayAllMember(members);
                        break;
                    case 3:
                        int choose1;
                        LinkedList<Member> memberss = fileManageController.ReadMemberFromFile(FILE_NAME_MEMBER);
                        do{
                            System.out.println("Nhập id cần sửa: ");
                            memberId = sc.nextInt();
                            Boolean isMember = functionController.CheckTheMemId(members, memberId);

                            if(isMember == false){
                                System.out.println("Id không tồn tại");
                            }
                            else
                                break;
                        }while (true);

                        System.out.println("=====================MENU EDIT INFO=====================");
                        System.out.println("1. Sửa mã sinh viên\n2. Sửa họ và tên\n3. Sửa giới tính");
                        System.out.println("4. Sửa tên lớp\n5. Sửa địa chỉ\n6. Sửa khóa\n7. Sửa sđt" +
                                "\n8. Sửa email\n9. Thoát");

                        System.out.println("Vui lòng chọn: ");
                        choose1 = sc.nextInt();
                        switch (choose1){
                            case 1:
                                LinkedList<Member> membersTemp = functionController.EditInfoMember(memberss,
                                        memberId, "studentCode");
                                fileManageController.UpdateMember(FILE_NAME_MEMBER, membersTemp);
                                break;
                            case 2:
                                LinkedList<Member> membersTemp_1 = functionController.EditInfoMember(memberss,
                                        memberId, "fullName");
                                fileManageController.UpdateMember(FILE_NAME_MEMBER, membersTemp_1);
                                break;
                            case 3:
                                LinkedList<Member> membersTemp_2 = functionController.EditInfoMember(memberss,
                                        memberId, "sex");
                                fileManageController.UpdateMember(FILE_NAME_MEMBER, membersTemp_2);
                                break;
                            case 4:
                            LinkedList<Member> membersTemp_3 = functionController.EditInfoMember(memberss,
                                    memberId, "className");
                            fileManageController.UpdateMember(FILE_NAME_MEMBER, membersTemp_3);
                            break;
                            case 5:
                            LinkedList<Member> membersTemp_4 = functionController.EditInfoMember(members,
                                    memberId, "address");
                            fileManageController.UpdateMember(FILE_NAME_MEMBER, membersTemp_4);
                            break;
                            case 6:
                            LinkedList<Member> membersTemp_5 = functionController.EditInfoMember(members,
                                    memberId, "schoolYear");
                            fileManageController.UpdateMember(FILE_NAME_MEMBER, membersTemp_5);
                            break;
                            case 7:
                            LinkedList<Member> membersTemp_6 = functionController.EditInfoMember(members,
                                    memberId, "phone");
                            fileManageController.UpdateMember(FILE_NAME_MEMBER, membersTemp_6);
                            break;
                            case 8:
                            LinkedList<Member> membersTemp_7 = functionController.EditInfoMember(members,
                                    memberId, "email");
                            fileManageController.UpdateMember(FILE_NAME_MEMBER, membersTemp_7);
                            break;
                            default:
                                System.out.println("Không có lựa chọn này");
                        }
                        break;
                    case 4:
                        System.out.println("Nhập id thành viên muốn xóa: ");
                        memberId = sc.nextInt();
                        LinkedList<Member> member3 = functionController.DeleteMember(members,
                                memberId, FILE_NAME_MEMSUBMANAGE);
                        if(member3 != null){
                            fileManageController.UpdateMember(FILE_NAME_MEMBER, member3);
                        }
                        break;
                    case 5:
                        subjectId = functionController.CheckSubjectStrict(subjects);
                        Subject subject = new Subject();
                        subject.ImportSubject(subjectId);
                        fileManageController.WriteSubjectToFile(FILE_NAME_SUBJECT, subject);
                        break;
                    case 6:
                        functionController.DisplayAllSubject(subjects);
                        break;
                    case 7:
                        int choose2;
                        FunctionController functionController1 = new FunctionController();
                        do{
                            System.out.println("Nhập id lớp: ");
                            subjectId = sc.nextInt();

                            if(functionController.CheckTheSubjectId(subjects, subjectId) == true){
                                break;
                            }else{
                                System.out.println("Id sai");
                            }
                        }while (true);

                        while (true){
                            System.out.println("==================MENU EDIT INFO SUBJECT==================");
                            System.out.println("1. Sửa tên lớp\n2. Sửa tên giáo viên\n3. Sửa ngày bắt đầu");
                            System.out.println("4. Sửa ngày kết thúc\n5. Sửa sĩ số\n0. Thoát");
                            System.out.println("Nhập lựa chọn: ");
                            choose2 = sc.nextInt();

                            if(choose2 == 0)
                                break;

                            switch (choose2){
                                case 1:
                                    LinkedList<Subject> subjects_1 = functionController.EditInfoSubject
                                            (subjects, subjectId, "subjectName");
                                    fileManageController.UpdateSubject(FILE_NAME_SUBJECT, subjects_1);
                                    break;
                                case 2:
                                    LinkedList<Subject> subjects_2 = functionController.EditInfoSubject
                                            (subjects, subjectId, "teacherName");
                                    fileManageController.UpdateSubject(FILE_NAME_SUBJECT, subjects_2);
                                    break;
                                case 3:
                                    LinkedList<Subject> subjects_3 = functionController.EditInfoSubject
                                            (subjects, subjectId, "startDay");
                                    fileManageController.UpdateSubject(FILE_NAME_SUBJECT, subjects_3);
                                    break;
                                case 4:
                                    LinkedList<Subject> subjects_4 = functionController.EditInfoSubject
                                            (subjects, subjectId, "endDay");
                                    fileManageController.UpdateSubject(FILE_NAME_SUBJECT, subjects_4);
                                    break;
                                case 5:
                                    LinkedList<Subject> subjects_5 = functionController.EditInfoSubject
                                            (subjects, subjectId, "numberOfStudent");
                                    fileManageController.UpdateSubject(FILE_NAME_SUBJECT, subjects_5);
                                    break;
                            }

                        }
                        break;
                    case 8:
                        System.out.println("Nhập id lớp: ");
                        subjectId = sc.nextInt();

                        LinkedList<Subject> subjects1 = functionController.DeleteSubject(subjects,
                                subjectId, FILE_NAME_MEMSUBMANAGE);
                        if(subjects1 != null){
                            fileManageController.UpdateSubject(FILE_NAME_SUBJECT, subjects1);
                        }
                        break;
                    case 9:
                        int memberId_1, subjectId_1 ;
                        String statusSubject;

                        do{
                            System.out.println("Nhập id thành viên: ");
                            memberId_1 = sc.nextInt();

                            if(functionController.CheckTheMemId(members, memberId_1) == true){
                                break;
                            }
                            else {
                                System.out.println("id thành viên không tồn tại");
                            }
                        }while (true);

                        do {
                            System.out.println("Nhập id lớp học: ");
                            subjectId_1 = sc.nextInt();

                            if(functionController.CheckTheSubjectId(subjects, subjectId_1) == true){
                                break;
                            }
                            else {
                                System.out.println("Id lớp học không tồn tại");
                            }
                        }while (true);

                        sc.nextLine();
                        System.out.println("Nhập trang thái: ");
                        statusSubject = sc.nextLine();

                        Member member1 = fileManageController.getMember(members, memberId_1);
                        Subject subject1 = fileManageController.getSubject(subjects, subjectId_1);
                        MemberSubjectManage memberSubjectManage = new MemberSubjectManage(
                                member1, subject1, statusSubject
                        );
                        fileManageController.WriteMemSubManageToFile(FILE_NAME_MEMSUBMANAGE, memberSubjectManage);
                        break;
                    case 10:
                        functionController.DisplayAllMSM(memberSubjectManages);
                        break;
                    case 11:

                        break;
                    case 12:
                        int choose3;
                        System.out.println("==================MENU TÌM KIẾM==================");
                        System.out.println("1. Tìm kiếm thành viên theo id");
                        System.out.println("2. Tìm kiếm thành viên theo tên");
                        System.out.println("3. Tìm kiếm lớp theo id");
                        System.out.println("4. Tìm kiếm lớp theo tên");
                        System.out.println("5. Tìm kiếm MSM theo id thành viên");
                        System.out.println("6. Tìm kiếm MSM theo name thành viên");

                        System.out.println("vui lòng lựa chọn: ");
                        choose3 = sc.nextInt();

                        switch (choose3){
                            case 1:
                                int memberId1;
                                System.out.println("Nhập id thành viên: ");
                                memberId1 = sc.nextInt();
                                functionController.FindMemberById(members, memberId1);
                                break;
                            case 2:
                                String fullName;
                                sc.nextLine();
                                System.out.println("Nhập tên thành viên: ");
                                fullName = sc.nextLine();
                                functionController.FindMemberByName(members, fullName);
                                break;
                            case 3:
                                int subjectId1;
                                System.out.println("Nhập id lớp: ");
                                subjectId1 = sc.nextInt();
                                functionController.FindSubjectById(subjects, subjectId1);
                                break;
                            case 4:
                                String subjectName;
                                sc.nextLine();
                                System.out.println("Nhập tên lớp: ");
                                subjectName = sc.nextLine();
                                functionController.FindSubjectByName(subjects, subjectName);
                                break;
                            case 5:
                                int memberId2;
                                System.out.println("Nhập id thành viên: ");
                                memberId2 = sc.nextInt();
                                functionController.FindMemSubManageByMemId(memberSubjectManages, memberId2);
                                break;
                            case 6:
                                String fullName2;
                                sc.nextLine();
                                System.out.println("Nhập id thành viên: ");
                                fullName2 = sc.nextLine();
                                functionController.FindMemSubManageByMemName(memberSubjectManages, fullName2);
                                break;
                            default:
                                System.out.println("Lựa chọn không tồn tại");
                        }
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + choose);
                }
            }
        }
    }
}
