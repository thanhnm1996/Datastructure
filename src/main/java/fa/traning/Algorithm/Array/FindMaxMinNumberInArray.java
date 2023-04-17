package fa.traning.Algorithm.Array;

import java.util.Arrays;

/**
 * B1: Kiến thức => Đã có, Mảng
 * <p>
 * B2: Xác định vấn đề
 * Tìm giá trị lớn nhất và nhỏ nhất trong mảng
 * <p>
 * B3: Đưa ra các hướng giải quyết
 * + Duyệt mảng từ đầu đến cuối, so sánh các phần tử với nhau
 * + Sắp xếp mảng -> Tìm được Max và Min
 * <p>
 * B4: Đánh giá, chọn phương án giải quyết tối ưu
 * <p>
 * B5: Code
 */
public class FindMaxMinNumberInArray {

    private void findMaxMinLoopFor(int arr[]) {
        int max = arr[0];
        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
    }

    private void finMaxMinStream(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
    }

    /** Tìm 2 số lớn nhất trong mảng
     * Ý tưởng: Duyệt mảng, so sánh số lớn nhất với các phần tử trong mảng
     * Gán seconLarget = larget , gán largest = Arr[i]
     * */
    private void findMaxLargestTwoNumber(int arr[]) {
        int largest = arr[0];
        int secondLargest = arr[1];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            }
        }
        System.out.println(largest);
        System.out.println(secondLargest);
    }

    public static void main(String[] args) {
        int[] arr = {1, 22, 3, 14, 14, 33, 22, 11, 1, 1,44,34,66};
        FindMaxMinNumberInArray find = new FindMaxMinNumberInArray();
        find.findMaxMinLoopFor(arr);

        find.finMaxMinStream(arr);

        find.findMaxLargestTwoNumber(arr);

    }


}
