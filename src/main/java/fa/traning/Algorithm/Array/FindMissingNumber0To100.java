package fa.traning.Algorithm.Array;

import java.util.HashSet;
import java.util.Set;

/**
 * B1: Knoweldge => Toán
 * <p>
 * B2: Xác định vấn đề => Tìm số còn thiếu trong mảng từ 0 -> 100
 * <p>
 * B3: Phương án giải quyết
 *      +) Tính tổng từ 0 -> 100. Tính tổng mảng truyền vào missing 1 số nào đó
 *          => 5050 - tổng mảng truyền vào = số còn thiếu
 *      +) Cho các số từ 1 -> 100 vào Set
 *          =>Sau đó cho duyệt mảng bị missing 1 số -> Xoá các phần tử trong set
 *          =>Phần tử nào từ dãy 1-100 không bị soá thì đó là số bị missing
 *          =>Tại sao không xoá bằng ArrayList đc (do hàm remove list là remove theo index, set remove theo object)
 * B4: Đánh giá, lựa chọn phương án tối ưu
 * <p>
 * B5: Code
 */
public class FindMissingNumber0To100 {

    private void findMissingByMath(int arr[]) {
        int count = 0;
        for (int i = 0; i <= 100; i++) {
            count += i;
        }
        int countArr = 0;
        for (int i = 0; i < arr.length; i++) {
            countArr += arr[i];
        }
        System.out.println(count - countArr);
    }

    private void findMissingBySet(int arr[]) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < 100; i++) {
            set.add(i);
        }
        for (int i =0; i<arr.length; i++){
            set.remove(arr[i]);
        }
        System.out.println("Set: " + set);

    }

    public static void main(String[] args) {
        int[] arrMissing = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
                21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
                41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60,
                61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80,
                81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 93, 94, 95, 96, 97, 98, 99, 100};

        FindMissingNumber0To100 find = new FindMissingNumber0To100();
        find.findMissingByMath(arrMissing);
        find.findMissingBySet(arrMissing);
    }
}
