import com.sun.security.jgss.GSSUtil;

import java.awt.*;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class RunMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choose, n;

        // khai bao cac bien tam
        String temp;
        int temp1, choose1;
//        Member member = new Member(2010606167,"Bui Viet Hoang", "nam", "HTTT2", "HN", "K14", "0979", "hmm");
        List<Member> members = new LinkedList<Member>();


        Date date = new Date(1,1,1);
        Date date1 = new Date(1,2,1);
        Subject subject = new Subject(11,"web", "khanh", date, date1, 20);
        Subject subject1 = new Subject(12,"oop", "Trung", date, date1, 13);
        List<Subject> sub = new LinkedList<>();
        sub.add(subject);
        sub.add(subject1);

        Member hoang = new Member(1,2019, "Bui Viet Hoang", "nam", "HTTT","hn", "k14", "222", "mm", (LinkedList<Subject>) sub);
        Member hieu = new Member(2,2020, "Long Trung Hieu", "nam", "HTTT","bg", "k14", "333", "hh", (LinkedList<Subject>) sub);
        Member manh = new Member(3,2022, "Nguyen Duc Manh", "nam", "HTTT","bg", "k14", "333", "hh");

        members.add(hoang);
        members.add(hieu);
        members.add(manh);


        while (true){
            System.out.println("===BANG DIEU KHIEN===");
            System.out.println("1. Them thanh vien\n2.Hien thi danh sach sinh vien\n3.Sua thong tin sinh vien");
            System.out.println("4.Xoa thanh vien\n5.Hien thi danh sach lop\n6.Sua thong tin lop hoc\n7.Xoa lop\n8.Sap xep\n9.Tim kiem");
            System.out.println("0.Thoat");

            System.out.println("nhap lua chon: ");
            choose = sc.nextInt();

            if(choose == 0){
                break;
            }
            switch (choose){
                case 1:
                    System.out.println("nhap tv can them: ");
                    n = sc.nextInt();
                    for(int i = 0 ; i < n; i++){
                    }
                    break;
                case 2:
                    System.out.println("====XUAT THONG TIN TV====");
                    System.out.printf("%-15s%-15s%-20s%-15s%-15s%-15s%-15s%-15s%-15s", "ID", "NAME", "MSV", "SEX", "CLASSNAME", "ADDRESS", "KHOA", "PHONE", "EMAIL");
                    System.out.println();
                    for(Member i : members){
                        i.exportMember();
                    }
                    break;
                case 3:
                    int idMem;

                    String regexString = "^[a-zA-Z]+$";
                    String regexClass = "^([a-zA-Z]){1,6}([0-9]){1}$";
                    String regexSdt = "^0[0-9]{9}$";
                    String regexEmail = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
                    String regexStudentCode = "^[0-9]{10}$";
                    while (true) {
                        System.out.println("vui long chon: ");
                        System.out.println("1. Sua ma sv\n2.Sua ten\n3.Sua gioi tinh\n4.Sua lop");
                        System.out.println("5.Sua dia chi\n6.Sua khoa\n7.Sua sdt\n8.Sua email");
                        System.out.println("0.Thoat");
                        choose1 = sc.nextInt();
                        if(choose1 == 0){
                            break;
                        }
                        System.out.println("nhap id thanh vien can sua: ");
                        idMem = sc.nextInt();
                        if(checkId(members,idMem)){
                            switch (choose1){
                                case 1:

                                    System.out.println("nhap ma sv: ");
                                    temp1 = sc.nextInt();
                                    if(Pattern.matches(regexStudentCode, Integer.toString(temp1)) == false){
                                        System.out.println("Sai dinh dang");
                                        break;
                                    }
                                    members.get(getPosition(members,idMem)).setStudentCode(temp1);
                                    System.out.println("Sua thanh cong");
                                    break;
                                case 2:
                                    System.out.println("nhap ten: ");
                                    sc.nextLine();
                                    temp = sc.nextLine();
                                    if(Pattern.matches(regexString,temp) == false){
                                        System.out.println("Sai dinh dang");
                                        break;
                                    }
                                    members.get(getPosition(members,idMem)).setFullName(temp);
                                    System.out.println("Sua thanh cong");
                                    break;
                                case 3:
                                    System.out.println("Nhap gioi tinh: ");
                                    sc.nextLine();
                                    temp = sc.nextLine();
                                    if(Pattern.matches(regexString,temp) == false){
                                        System.out.println("Gioi tinh khong hop le");
                                        break;
                                    }
                                    members.get(getPosition(members,idMem)).setSex(temp);
                                    System.out.println("Sua thanh cong");
                                    break;
                                case 4:
                                    System.out.println("Nhap lop: ");
                                    sc.nextLine();
                                    temp = sc.nextLine();
                                    if(Pattern.matches(regexClass,temp) == false){
                                        System.out.println("sai dinh dang");
                                        break;
                                    }
                                    members.get(getPosition(members,idMem)).setClassName(sc.nextLine());
                                    System.out.println("Sua thanh cong");
                                    break;
                                case 5:
                                    System.out.println("nhap dia chi: ");
                                    sc.nextLine();
                                    members.get(getPosition(members,idMem)).setAddress(sc.nextLine());
                                    System.out.println("Sua thanh cong");
                                    break;
                                case 6:
                                    System.out.println("nhap khoa: ");
                                    sc.nextLine();
                                    temp = sc.nextLine();
                                    if(checkSchoolYear(temp,14) == false || Pattern.matches(regexClass, temp) == false){
                                        System.out.println("Sai dinh dang");
                                        break;
                                    }
                                    members.get(getPosition(members,idMem)).setSchoolYear(sc.nextLine());
                                    System.out.println("Sua thanh cong");
                                    break;
                                case 7:
                                    System.out.println("nhap sdt: ");
                                    sc.nextLine();
                                    temp = sc.nextLine();
                                    if(Pattern.matches(regexSdt, temp) == false){
                                        System.out.println("Sai dinh dang");
                                        break;
                                    }
                                    members.get(getPosition(members,idMem)).setPhone(temp);
                                    System.out.println("Sua thanh cong");
                                    break;
                                case 8:
                                    System.out.println("nhap email: ");
                                    sc.nextLine();
                                    temp = sc.nextLine();
                                    if(Pattern.matches(regexEmail, temp) == false){
                                        System.out.println("Sai dinh dang");
                                        break;
                                    }
                                    members.get(getPosition(members,idMem)).setEmail(temp);
                                    System.out.println("Sua thanh cong");
                                    break;
                                default:
                                    break;
                            }
                        }
                        else {
                            System.out.println("no");
                        }
                    }
                    break;
                case 4:
                    System.out.println("nhap id: ");
                    temp1 = sc.nextInt();
                    int position = getPosition(members, temp1);
                    if(checkId(members,temp1) == false){
                        System.out.println("id khong ton tai");
                        break;
                    }

                    if(members.get(position).getSubjects().size() > 0){
                        System.out.println("Khong the xoa tv dang hoc");
                    }
                    else{
                        members.remove(position);
                        System.out.println("xoa thanh cong");
                    }
                    break;
                case 5:
                    System.out.println("====XUAT THONG TIN LOP====");
                    System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s", "Id", "SubjectName", "TeacherName", "StartDay", "EndDay", "NumberOfStudent");
                    System.out.println();
                    for(Member i : members){
                        for(int j = 0 ; j < i.getSubjects().size(); j++){
                            i.getSubjects().get(j).exportSubject();
                        }
                    }
                    break;
                case 6:
                    int idClass, positionClass;
                    int day, month, year;
                    System.out.println("vui long chon: ");
                    System.out.println("1. Sua ten lop\n2.Sua ngay bat dau");
                    System.out.println("3.Sua ngay ket thuc\n4.Sua so luong hoc sinh");
                    System.out.println("0.Thoat");
                     choose1 = sc.nextInt();
                    if(choose1 == 0){
                        break;
                    }
                    System.out.println("nhap id lop can sua: ");
                    idClass = sc.nextInt();

                    if(checkIdClass(members,idClass) == false){
                        System.out.println("Ma lop khong ton tai");
                    }
                    else {
                        switch (choose1) {
                            case 1:
                                sc.nextLine();
                                System.out.println("nhap ten lop: ");
                                temp = sc.nextLine();

                                for(Member m : members){
                                    positionClass = getPositionClass(m, idClass);
                                    if(positionClass != -1)
                                        m.getSubjects().get(positionClass).setSubjectName(temp);
                                }
                                System.out.println("Sua thanh cong");
                                break;
                            case 2:
                                sc.nextLine();
                                System.out.println("nhap ngay: ");
                                day = sc.nextInt();
                                System.out.println("nhap thang: ");
                                month = sc.nextInt();
                                System.out.println("nhap nam: ");
                                year = sc.nextInt();
                                for(Member m : members){
                                    positionClass = getPositionClass(m, idClass);
                                    if(positionClass != -1)
                                        m.getSubjects().get(positionClass).setStartDay(new Date(day,month,year));
                                }
                                System.out.println("Sua thanh cong");
                                break;
                            case 3:
                                sc.nextLine();
                                System.out.println("nhap ngay: ");
                                day = sc.nextInt();
                                System.out.println("nhap thang: ");
                                month = sc.nextInt();
                                System.out.println("nhap nam: ");
                                year = sc.nextInt();

                                for(Member m : members){
                                    positionClass = getPositionClass(m, idClass);
                                    if(positionClass != -1)
                                        m.getSubjects().get(positionClass).setEndDay(new Date(day,month,year));
                                }
                                break;

                            case 4:
                                sc.nextLine();
                                System.out.println("nhap so luong hoc sinh: ");
                                temp1 = sc.nextInt();

                                for(Member m : members){
                                    positionClass = getPositionClass(m, idClass);
                                    if(positionClass != -1)
                                        m.getSubjects().get(positionClass).setNumberOfStudent(temp1);
                                }
                                System.out.println("Sua thanh cong");
                                break;
                            default:
                                System.out.println("vui long nhap lai");
                                break;
                        }
                    }
                    break;

                case 9:
                    break;
                default:
                    System.out.println("vui long nhap lai");
                    break;
            }
        }
    }


    public static boolean checkId(List<Member> members, int id){
        for(Member i : members){
            if(i.getId() == id)
                return true;
        }
        return false;
    };

    public static int getPosition(List<Member> members, int id) {
        for(int i = 0 ; i < members.size(); i++){
            if(members.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    };

    public static boolean checkSchoolYear(String schoolYear, int smallerConditions){
        int length = schoolYear.length();
        if(Integer.parseInt(schoolYear.substring(length - (length - 1))) <= smallerConditions){
            return true;
        }
        return false;
    }

    public static boolean checkIdClass(List<Member> members, int id){
        for(Member i : members){
            for(Subject j : i.getSubjects()){
                if(j.getSubjectCode() == id)
                    return true;
            }
        }
        return false;
    }

    public static int getPositionClass(Member members, int id) {
        for(int i = 0 ; i < members.getSubjects().size(); i++){
            if(members.getSubjects().get(i).getSubjectCode() == id){
                return i;
            }
        }
        return -1;
    }


}
