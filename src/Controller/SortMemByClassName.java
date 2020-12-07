package Controller;

import Model.Member;

import java.util.Comparator;

public class SortMemByClassName implements Comparator<Member> {

    @Override
    public int compare(Member o1, Member o2) {
        return o1.getClassName().compareTo(o2.getClassName());
    }
}
