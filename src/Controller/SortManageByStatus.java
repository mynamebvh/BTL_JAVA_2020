package Controller;

import Model.MemberSubjectManage;

import java.util.Comparator;

public class SortManageByStatus implements Comparator<MemberSubjectManage> {

    @Override
    public int compare(MemberSubjectManage o1, MemberSubjectManage o2) {
        return (o1.getStatusSubject().compareTo(o2.getStatusSubject()));
    }
}
