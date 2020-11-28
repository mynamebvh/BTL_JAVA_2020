package View;

import Controller.FunctionController;
import Controller.FileManageController;
import Model.Member;

import java.util.LinkedList;
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
            int memberId;
            LinkedList<Member> members = fileManageController.ReadMemberFromFile(FILE_NAME_MEMBER);
            System.out.println("=============MENU=============");
            System.out.println("1. Thêm thành viên\n2. Hiển thị thành viên\n3. Sửa thông tin thành viên");
            System.out.println("4. Xóa thành viên\n5. Thêm lớp học\n6. Sửa thông tin lớp học");
            System.out.println("7. Xóa lớp học\n8. Sắp xếp\n9. Tìm kiếm\n0. Thoát");

            System.out.println("nhập lựa chọn: ");
            choose = sc.nextInt();

            if(choose == 0)
                break;
            else{
                switch (choose){
                    case 1:
                        System.out.println("nhập id thành viên");
                        memberId = sc.nextInt();

                        if(functionController.CheckTheMemID(members, memberId) == false){
                            Member member = new Member();
                            member.ImportMember(memberId);
                            functionController.AddMemberNew(FILE_NAME_MEMBER, members, member);
                        }
                        else{
                            System.out.println("Id đã tồn tại");
                            break;
                        }
                        break;
                    case 2:
                        System.out.println("===================DANH SÁCH TV===================");
                        functionController.DisplayAllMember(members);
                        break;
                    case 3:
                        System.out.println();
                        break;
                    case 4:
                        System.out.println("nhập id: ");
                        memberId = sc.nextInt();
                        if(functionController.CheckTheMemID(members, memberId) == false){

                        }
                        else {
                            System.out.println("Id không tồn tại");
                        }
                        break;
                }
            }
        }
    }
}
