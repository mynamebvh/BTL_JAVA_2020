package Controller;

import Model.Subject;

import java.util.Comparator;

public class SortSubByName implements Comparator<Subject> {
    @Override
    public int compare(Subject o1, Subject o2) {
        return o1.getSubjectName().compareTo(o2.getSubjectName());
    }
}
