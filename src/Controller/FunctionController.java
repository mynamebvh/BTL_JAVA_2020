package Controller;

import Model.Member;
import Model.MemberSubjectManage;

import java.util.LinkedList;

public class FunctionController {
    FileManageController fileManageController;

    // Các phương thức kiểm tra
    public boolean CheckTheMemID(LinkedList<Member> members, int id){
        for(Member member : members){
            if(member.getStudentId() == id)
                return true;
        }
        return false;
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


}
