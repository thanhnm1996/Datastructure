package fa.traning.Algorithm.Array;
/**
 * B1: Kiến thức
 *
 * B2: Xác định vấn đề :
 *      Đảo ngược mảng số nguyên
 *
 *
 * B3: Đưa ra các hướng giải quyết
 *      Hướng 1: Sử dụng vòng lặp while và sử dụng biến tạm để hoán đôổi
 *
 *      Hướng 2: Sử dụng đệ quy
 *
 *
 * B4: Đánh giá, chọn phương án giải quyết tối ưu
 *
 * B5: Code*/
public class ReverseArray {

    private void reverseArray(int arr[]){
        int left = 0;
        int right = arr.length -1;
        int temp;
        while (left < right){
            temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        for (int i : arr){
            System.out.print(i +", ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 22, 1, 3, 14, 14, 33, 22, 1, 4};
        ReverseArray reverseArray = new ReverseArray();
        reverseArray.reverseArray(arr);
    }
}
