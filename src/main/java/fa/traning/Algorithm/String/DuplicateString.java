package fa.traning.Algorithm.String;

import java.util.*;

/**
 * B1: Kiến thức : Sring = mảng các kí tự
 * <p>
 * B2: Xác định vấn đề: Tìm các phần tử trùng lặp trong một chuỗi String
 * <p>
 * B3: Đưa ra các hướng giải quyết
 * +)Sử dụng 2 vòng lặp để so sánh từng kí tự, nếu ==    -> Duplicate
 * +)Cho vào HashSet, nếu kí tự đã tồn tại trong hashSet -> Duplicate
 * <p>
 * <p>
 * B4: Đánh giá, chọn phương án giải quyết tối ưu
 * <p>
 * B5: Code
 */

public class DuplicateString {

    //Hiển thị các phần tử trùng lặp trong String  => Sử dụng Loop O(n2)
    private void finDuplicateStringByLoop(String string) {
        List<Character> list = new ArrayList();
        for (int i = 0; i < string.length() - 1; i++) {
            for (int j = i + 1; j < string.length(); j++) {
                if (string.charAt(i) == string.charAt(j)) {
                    if (!list.contains(string.charAt(i))) {
                        list.add(string.charAt(i));
                    }
                }
            }
        }
        list.forEach(System.out::println);
    }

    //Hiển thị các phần tử trùng lặp trong String, sử dụng Set O(n)
    private void findDuplicateStringBySet(String string) {
        HashSet<Character> set = new HashSet();
        List<Character> list = new ArrayList<>();

        for (int i = 0; i < string.length(); i++) {
            if (!set.add(string.charAt(i))) {
                if (!list.contains(string.charAt(i))) {
                    list.add(string.charAt(i));
                }
            }
        }
        list.forEach(System.out::println);
    }

    //Hiển thị các phần tử trùng lặp trong String, và đếm số lần xuất hiện của mỗi phần tử O(n)

    private void findDuplicateStringByMap(String string) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            if (map.containsKey(string.charAt(i))) {
                map.put(string.charAt(i), map.get(string.charAt(i)) + 1);
            } else
                map.put(string.charAt(i), 1);
        }
        Set<Character> sets = map.keySet();
        for (Character key : sets) {
            System.out.println(key + " Xuất hiện " + map.get(key) + "Lần");
        }
    }

    //Xoá các phần tử trùng lặp, Đơn giản nhất, cho con mẹ nó hết vào Set
    private void deleteDuplicateStringBySet(String string) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < string.length(); i++) {
            set.add(string.charAt(i));
        }
        set.forEach(System.out::print);
    }

    /** Xoá phần tử trùng lặp sử dụng 2 vòng Loop => Thời gian O(n2)
     * Ý tưởng: Khai báo một biến check bên trong vòng lặp ngoài
     * Kiểm tra lần lượt phần tử đầu với các phần tử sau, nếu trùng lặp sẽ đổi trạng thái biến đó thành True
     * Nếu kiểm tra từ đầu chuỗi đến cuối chuỗi mà không có phần tử trùng lặp thì mới add vào StringBuilder
     * Sử dụng StringBuilder để append đỡ tốn bộ nhớ hơn String + chuỗi.
     *  */
    private void deleteDuplicateStringByLoop(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            boolean check = false;
            for (int j = i + 1; j < string.length(); j++) {
                if (string.charAt(i) == string.charAt(j)) {
                    check = true;
                    break;
                }
            }
            if (!check) {
                stringBuilder.append(string.charAt(i));
            }
        }
        System.out.println(stringBuilder);
    }


    public static void main(String[] args) {
        DuplicateString duplicateString = new DuplicateString();
        String s = "Thanah Dat";
        duplicateString.finDuplicateStringByLoop(s);
        System.out.println("===========================================");
        duplicateString.findDuplicateStringBySet(s);
        System.out.println("===========================================");

        duplicateString.findDuplicateStringByMap(s);
        System.out.println("===========================================");

        duplicateString.deleteDuplicateStringBySet(s);
        System.out.println("");
        duplicateString.deleteDuplicateStringByLoop(s);
    }

}
