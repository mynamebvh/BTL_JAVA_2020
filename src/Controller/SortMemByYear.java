package Controller;

import Model.Member;

import java.util.Comparator;

public class SortMemByYear implements Comparator<Member> {

    @Override
    public int compare(Member o1, Member o2) {
        return -(o1.getSchoolYear().compareTo(o2.getSchoolYear()));
    }
}
