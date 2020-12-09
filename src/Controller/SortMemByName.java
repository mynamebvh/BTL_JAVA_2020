package Controller;

import Model.Member;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortMemByName implements Comparator<Member> {
    List<Character> alphaOrder = Arrays.asList('a', 'ă', 'â', 'b', 'c', 'd', 'đ', 'e', 'ê', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'ơ', 'p', 'q', 'r', 's', 't', 'u', 'ư', 'v', 'w', 'x', 'y', 'z');

    private String Slug(String str) {
        str = str.toLowerCase();
        String from = "àáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ·/_,:;";
        String to = "aaaaaaaaaaaaaaaaaeeeeeeeeeeeiiiiiooooooooooooooooouuuuuuuuuuuyyyyyd------";
        for (int i = 0; i < from.length(); i++) {
            str = str.replace(from.charAt(i), to.charAt(i));
        }
        return str;
    }


    @Override
    public int compare(Member o1, Member o2) {
        String[] arrNameAfter = o1.getFullName().toLowerCase().split("\\s+");
        String[] arrNameBefore = o2.getFullName().toLowerCase().split("\\s+");


        String nameBefore = arrNameAfter[arrNameAfter.length - 1].charAt(0) + Slug(arrNameAfter[arrNameAfter.length - 1]).substring(1);
        System.out.println(nameBefore);
        String nameAfter = arrNameBefore[arrNameBefore.length - 1].charAt(0) + Slug(arrNameBefore[arrNameBefore.length - 1]).substring(1);

        if (nameBefore.charAt(0) == nameAfter.charAt(0)){
            return nameBefore.compareTo(nameAfter);
        }

        return Integer.compare(alphaOrder.indexOf(arrNameAfter[arrNameAfter.length - 1].charAt(0)),
                alphaOrder.indexOf(arrNameBefore[arrNameBefore.length - 1].charAt(0)));
    }

}
