package fa.traning.Algorithm.String;

import java.util.*;

/**
 * B1: Kiến thức : String
 *
 * B2: Xác định vấn đề:
 *      Đảo ngược chuỗi kí tự String
 *
 *
 * B3: Đưa ra các hướng giải quyết
 *      +) Sử dụng 1 vòng lặp For
 *      +) Sử dụng thư viện
 *      +) Cho vào Stack
 *
 *
 * B4: Đánh giá, chọn phương án giải quyết tối ưu
 *
 * B5: Code*/

public class ReverseString {

    private void reverseStringByLoop(String str){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = str.length() - 1; i >=0; i--){
            stringBuilder.append(str.charAt(i));
        }
        System.out.println(stringBuilder);
    }

    private void reverseStringByStack(String str){
        Stack<Character> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++){
            stack.push(str.charAt(i));
        }
        while (!stack.isEmpty()){
            stringBuilder.append(stack.pop());
        }
        System.out.println(stringBuilder);
    }

    public static void main(String[] args) {
        String s = "Thanh";
        ReverseString reverseString = new ReverseString();
        reverseString.reverseStringByLoop(s);
        //Cách 2 sử dụng thư viện String
        StringBuilder builder = new StringBuilder(s);
        System.out.println(builder.reverse());
        //Cách 3 sử dụng Stack
        reverseString.reverseStringByStack(s);
    }
}
