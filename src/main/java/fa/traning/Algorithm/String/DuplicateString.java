package fa.traning.Algorithm.String;

import java.util.HashSet;

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

    private void finDuplicateStringByLoop(String string) {
        for (int i = 0; i < string.length() - 1; i++) {
            for (int j = i + 1; j < string.length(); j++) {
                if (string.charAt(i) == string.charAt(j)){
                    System.out.println( string.charAt(i));
                }
            }
        }
    }

    private void findDuplicateStringBySet(String string){
        HashSet<Character> set = new HashSet();
        for (int i =0; i < string.length(); i++){
            if(!set.add(string.charAt(i))){
                System.out.println(string.charAt(i));
            }
        }
    }


    public static void main(String[] args) {
        DuplicateString duplicateString = new DuplicateString();
        duplicateString.finDuplicateStringByLoop("Thanazzh");
        duplicateString.findDuplicateStringBySet("Thanazzh");
    }
}
