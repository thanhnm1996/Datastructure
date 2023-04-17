package fa.traning.PracticeJava8;

import java.util.StringJoiner;

public class PracticeStringJoiner {

    public static void main(String[] args) {
        StringJoiner stringJoiner = new StringJoiner("- ");
        stringJoiner.add("one");
        stringJoiner.add("two");
        stringJoiner.add("three");
        System.out.println(stringJoiner);
    }
}
