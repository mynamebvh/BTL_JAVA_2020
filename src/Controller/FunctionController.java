package Controller;

import Model.Member;
import Model.MemberSubjectManage;
import Model.Subject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public class FunctionController {
    FileManageController fileManageController;

    // Các phương thức kiểm tra
    public boolean CheckTheMemId(LinkedList<Member> members, int id){
        for(Member member : members){
            if(member.getStudentId() == id)
                return true;
        }
        return false;
    }

    public int CheckMemberStrict(LinkedList<Member> members){
        int memberId;
        Scanner sc = new Scanner(System.in);
        FunctionController functionController = new FunctionController();
        do{

            System.out.println("nhập id thành viên");
            memberId = sc.nextInt();


            if(functionController.CheckTheMemId(members, memberId) == true){
                System.out.println("id đã tồn tại");
            }
            else {
                return memberId;
            }
        }while (true);
    }

    public boolean CheckTheSubjectId(LinkedList<Subject> subjects, int subjectId){
        for(Subject subject : subjects){
            if(subject.getSubjectId() == subjectId)
                return true;
        }
        return false;
    }

    public int CheckSubjectStrict(LinkedList<Subject> subjects){
        Scanner sc = new Scanner(System.in);
        int subjectId;
        do{
            System.out.println("nhập id subject: ");
            subjectId = sc.nextInt();

            if(CheckTheSubjectId(subjects, subjectId) == true){
                System.out.println("id subject đã tồn tại");
            }
            else {
                return subjectId;
            }
        }while (true);
    }

    public boolean CheckMemIDInMSM(LinkedList<Member> members, LinkedList<MemberSubjectManage> MSMS){
        for(MemberSubjectManage MSM : MSMS){

        }
        return false;
    }

    // Các phương thức thêm thông tin

    public void AddMemberNew(String fileName, LinkedList<Member> members, Member member){
        fileManageController = new FileManageController();
        members.add(member);
        fileManageController.UpdateMember(fileName, members);
    }

    // Các phương thức hiển thị

    public void DisplayAllMember(LinkedList<Member> members){
        System.out.printf("%-15s%-15s%-20s%-10s%-10s%-15s%-15s%-15s%-15s", "ID", "StudentCode", "FullName",
                "Sex", "ClassName", "Address", "SchoolYear", "Phone", "Email");
        System.out.println();
        for(Member member : members){
            member.ExportMember();
        }
    }

    public void DisplayAllSubject(LinkedList<Subject> subjects){
        System.out.printf("%-15s%-15s%-20s%-15s%-15s%-15s", "ID", "SubjectName", "TeacherName",
                "StartDay", "EndDay", "NumberOfStudent");
        System.out.println();
        for(Subject subject : subjects){
            subject.ExportSubject();
        }
    }

    public void DisplayAllMSM(LinkedList<MemberSubjectManage> subjectManages){
        System.out.printf("%-15s%-15s%-15s", "IdMember", "IdSubject", "statusSubject");
        System.out.println();
        for(MemberSubjectManage memberSubjectManage : subjectManages){
            memberSubjectManage.ExportMemberSubjectManage();
        }
    }
    //Các phương thức sửa thông tin

    public LinkedList<Member> EditInfoMember(LinkedList<Member> members, int memberId, String type){
        Scanner sc = new Scanner(System.in);
        // Khai báo biến tạm
        int indexMember, studentCode;
        String fullName, sex, className, address, schoolYear, phone, email;

        //Regex
        String regexStudentCode = "^\\d{10}$";
        String regexFullName = "^[a-zA-Z]+$";
        String regexSex = "^[(nam)(nu)(Nam)(Nu)]+$";
        String regexClassName = "^[a-zA-Z]{4}[0-9]{1,2}$";
        String regexSchoolYear = "^K[0-9]{1,2}$";
        String regexPhone = "^0(9\\d{8}|3\\d{8}|5\\d{8})$";
        String regexEmail = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

        // lấy index member cần edit
        indexMember = getIndexMember(members, memberId);
        switch (type){
            case "studentCode":
                do{
                    System.out.println("Nhập mã sinh viên: (VD: 2019606167)");
                    studentCode = sc.nextInt();
                }while (regexStudentCode.matches(Integer.toString(studentCode)) == true);

                members.get(indexMember).setStudentCode(studentCode);
                return members;
            case "fullName":
                do{
                    System.out.println("Nhập họ và tên: ");
                    fullName = sc.nextLine();
                }while (regexFullName.matches(fullName) == true);

                members.get(indexMember).setFullName(fullName);
                break;
            case "sex":
                do{
                    System.out.println("Nhập giới tính: ");
                    sex = sc.nextLine();
                }while (regexSex.matches(sex) == true);

                members.get(indexMember).setSex(sex);
                break;
            case "className":
            do{
                System.out.println("Nhập tên lớp (VD: HTTT2):  ");
                className = sc.nextLine();
            }while (regexClassName.matches(className) == true);

            members.get(indexMember).setClassName(className);
            break;
            case "address":
                System.out.println("Nhập địa chỉ (VD: Hà Nội):  ");
                address = sc.nextLine();
                members.get(indexMember).setAddress(address);
                break;
            case "schoolYear":
                do{
                    System.out.println("Nhập khóa (VD: K14):  ");
                    schoolYear = sc.nextLine();
                }while (regexSchoolYear.matches(schoolYear) == true);

                members.get(indexMember).setSchoolYear(schoolYear);
                break;
            case "phone":
                do{
                    System.out.println("Nhập sđt :  ");
                    phone = sc.nextLine();
                }while (regexPhone.matches(phone) == true);
                members.get(indexMember).setPhone(phone);
                break;
            case "email":
                do{
                    System.out.println("Nhập email:  ");
                    email = sc.nextLine();
                }while (regexEmail.matches(email) == true);
                members.get(indexMember).setEmail(email);
                break;
            default:
                System.out.println("Không có lựa chọn này");
        }

        return members;
    }

    public LinkedList<Subject> EditInfoSubject(LinkedList<Subject> subjects, int subjectId, String type){
        // lấy id subject cần sửa
        int indexSubject = getIndexSubject(subjects, subjectId);

        // Tạo các đối tượng
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        // Các biến tạm
        String subjectName, teacherName;
        int numberOfStudent;

        // regex
        String regexSubjectName = "^[a-zA-Z]+$";
        String regexTeacherName = "^[a-zA-Z]{30}$";
        switch (type){
            case "subjectName":
                do{
                    System.out.println("Nhập tên lớp: ");
                    subjectName = sc.nextLine();
                }while (regexSubjectName.matches(subjectName) == true);

                subjects.get(indexSubject).setSubjectName(subjectName);
                return subjects;
            case "teacherName":
                do{
                    System.out.println("Nhập tên giáo viên: ");
                    teacherName = sc.nextLine();
                }while (regexTeacherName.matches(teacherName) == true);

                subjects.get(indexSubject).setTeacherName(teacherName);
                return subjects;
            case "startDay":

                Date dateStart;
                try {
                    System.out.println("Nhập ngày bắt đầu: ");
                    dateStart = simpleDateFormat.parse(sc.nextLine());
                    subjects.get(indexSubject).setStartDay(simpleDateFormat.format(dateStart));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return subjects;
            case "endDay":
                Date dateEnd;
                System.out.println("Nhập ngày kết thúc: ");
                try {
                    dateEnd = simpleDateFormat.parse(sc.nextLine());
                    subjects.get(indexSubject).setEndDay(simpleDateFormat.format(dateEnd));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return subjects;
            case "numberOfStudent":
                System.out.println("Nhập sĩ số: ");
                numberOfStudent = sc.nextInt();
                subjects.get(indexSubject).setNumberOfStudent(numberOfStudent);
                return subjects;
        }

        return null;
    }


    // Các phương thức lấy vị trí

    public int getIndexMember(LinkedList<Member> members, int memberId){
        for(int i = 0 ; i < members.size(); i++){
            if(members.get(i).getStudentId() == memberId)
                return i;
        }
        return -1;
    }

    public int getIndexSubject(LinkedList<Subject> subjects, int subjectId){
        for(int i = 0 ; i < subjects.size(); i++){
            if(subjects.get(i).getSubjectId() == subjectId)
                return i;
        }
        return -1;
    }

    // Các phương thức xóa

    public LinkedList<Member> DeleteMember(LinkedList<Member> members, int memberId, String fileName){
        Scanner sc = new Scanner(System.in);
        FileManageController fileManageController = new FileManageController();
        LinkedList<MemberSubjectManage> memberSubjectManages = fileManageController.ReadMemSubManageFromFile(
                fileName);
        Boolean isDelete = false;
        String choose;
        int indexMember = getIndexMember(members, memberId);
        for(MemberSubjectManage MSM : memberSubjectManages){
            if(MSM.getMember().getStudentId() == memberId){
                System.out.println("Thành viên này đang học bạn có chắc muốn xóa không ? (Y/N) ");
                choose = sc.nextLine();
                if(choose.equals("Y")|| choose.equals("y")){
                    members.remove(indexMember);
                    return members;
                }
            }
        }

        if(indexMember != -1){
            members.remove(indexMember);
            return members;
        }
        return null;
    }

    public LinkedList<Subject> DeleteSubject(LinkedList<Subject> subjects, int subjectId, String fileName){
        Scanner sc = new Scanner(System.in);
        FileManageController fileManageController = new FileManageController();
        LinkedList<MemberSubjectManage> memberSubjectManages = fileManageController.ReadMemSubManageFromFile(
                fileName);
        Boolean isDelete = false;

        String choose;

        int indexSubject = getIndexSubject(subjects, subjectId);

        for(MemberSubjectManage MSM : memberSubjectManages){

            if(MSM.getSubject().getSubjectId() == subjectId) {
                System.out.println("Lớp này đang có học sinh bạn có chắc muốn xóa không ? (Y/N) ");
                choose = sc.nextLine();
                if (choose.equals("Y") || choose.equals("y")) {
                    subjects.remove(indexSubject);
                    return subjects;
                }
            }
            System.out.println(MSM.getSubject());
        }

        if(indexSubject != -1){
            subjects.remove(indexSubject);
            return subjects;
        }
        return null;
    }

    public LinkedList<MemberSubjectManage> DeleteMSMByMemId(int memberId, LinkedList<MemberSubjectManage> msbs){
        for(int i = 0 ;i < msbs.size(); i++){
            if(msbs.get(i).getMember().getStudentId() == memberId){
                msbs.remove(i);
            }
        }
        return msbs;
    };

    public LinkedList<MemberSubjectManage> DeleteMSMBySubId(int subjectId, LinkedList<MemberSubjectManage> msbs){
        for(int i = 0 ;i < msbs.size(); i++){
            if(msbs.get(i).getSubject().getSubjectId() == subjectId){
                msbs.remove(i);
            }
        }
        return msbs;
    };
    // Các phương thức tìm kiếm
    public void FindMemberById(LinkedList<Member> members, int memberId){
        System.out.printf("%-15s%-15s%-20s%-10s%-10s%-15s%-15s%-15s%-15s", "ID", "StudentCode", "FullName",
                "Sex", "ClassName", "Address", "SchoolYear", "Phone", "Email");
        System.out.println();
        for(Member member : members){
            if(member.getStudentId() == memberId)
                member.ExportMember();
        }
    }

    public void FindSubjectById(LinkedList<Subject> subjects, int subjectId){
        System.out.printf("%-15s%-15s%-20s%-15s%-15s%-15s", "ID", "SubjectName", "TeacherName",
                "StartDay", "EndDay", "NumberOfStudent");
        System.out.println();
        for(Subject subject : subjects){
            if(subject.getSubjectId() == subjectId)
                subject.ExportSubject();
        }
    }

    public void FindMemberByName(LinkedList<Member> members, String fullName){
        System.out.printf("%-15s%-15s%-20s%-10s%-10s%-15s%-15s%-15s%-15s", "ID", "StudentCode", "FullName",
                "Sex", "ClassName", "Address", "SchoolYear", "Phone", "Email");
        System.out.println();
        for(Member member : members){
            if(member.getFullName().equals(fullName))
                member.ExportMember();
        }
    }

    public void FindSubjectByName(LinkedList<Subject> subjects, String subjectName){
        System.out.printf("%-15s%-15s%-20s%-15s%-15s%-15s", "ID", "SubjectName", "TeacherName",
                "StartDay", "EndDay", "NumberOfStudent");
        System.out.println();
        for(Subject subject : subjects){
            if(subject.getSubjectName().equals(subjectName))
                subject.ExportSubject();
        }
    }

    public void FindMemSubManageByMemId(LinkedList<MemberSubjectManage> MSMS, int memberId){
        System.out.printf("%-15s%-15s%-15s", "IdMember", "IdSubject", "statusSubject");
        System.out.println();
        for(MemberSubjectManage MSM : MSMS){
            if(MSM.getMember().getStudentId() == memberId)
                MSM.ExportMemberSubjectManage();
        }
    }

    public void FindMemSubManageByMemName(LinkedList<MemberSubjectManage> MSMS, String memberName){
        System.out.printf("%-15s%-15s%-15s", "IdMember", "IdSubject", "statusSubject");
        System.out.println();
        for(MemberSubjectManage MSM : MSMS){
            if(MSM.getMember().getFullName().equals(memberName))
                MSM.ExportMemberSubjectManage();
        }
    }
}
