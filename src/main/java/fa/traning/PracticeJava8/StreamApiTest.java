package fa.traning.PracticeJava8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiTest {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Hello", "World");
        Stream<String> letters = words.stream().flatMap(str -> str.chars().mapToObj(ch -> Character.toString((char) ch)));
        System.out.println(letters.collect(Collectors.toList()));
        List<Object> objects;
    }
}
