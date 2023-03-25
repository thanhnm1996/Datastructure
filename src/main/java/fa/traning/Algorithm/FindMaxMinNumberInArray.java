package fa.traning.Algorithm;

import java.util.Arrays;

/**
 * B1: Kiến thưức => Đã có, Mảng
 *
 * B2: Xác định vấn đề
 *      Tìm giá trị lớn nhất và nhỏ nhất trong mảng
 * B3: Đưa ra các hướng giải quyết
 *      + Duyệt mảng từ đầu đến cuối, so sánh các phần tử với nhau
 *      + Sắp xếp mảng -> Tìm được Max và Min
 * B4: Đánh giá, chọn phương án giải quyết tối ưu
 * B5: Code*/
public class FindMaxMinNumberInArray {

    private void findMaxMinLoopFor(int arr[]) {
        int max = arr[0];
        int min = arr[0];

        for (int i = 0; i< arr.length; i++){
            if (max < arr[i]){
                max = arr[i];
            }
            if (min > arr[i]){
                min = arr[i];
            }
        }
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
    }

    private void finMaxMinSort(int[] arr){
       int max = Arrays.stream(arr).max().getAsInt();
       int min = Arrays.stream(arr).min().getAsInt();
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
    }

        public static void main(String[] args) {
            int[] arr = {1, 22, 3, 14, 14, 33, 22, 11, 1, 1};
            FindMaxMinNumberInArray find = new FindMaxMinNumberInArray();
            find.findMaxMinLoopFor(arr);

            find.finMaxMinSort(arr);
    }
}
