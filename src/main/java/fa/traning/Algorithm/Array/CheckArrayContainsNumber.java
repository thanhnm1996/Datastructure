package fa.traning.Algorithm.Array;

/**
 * B1: Kiến thưức => Đã có, Mảng
 *
 * B2: Xác định vấn đề
 *      Kiểm tra xem phần tử này có chứa trong Mảng không?
 *
 * B3: Đưa ra các hướng giải quyết
 *      +PA1: Mảng chưa sort: Duyệt tuần tự mảng từ đầu đến cuối, so sánh các phần tử trong mảng với phần tử truyền vào
 *      +PA2: Nếu mảng đã được sắp xếp, sử dụng tìm kiếm nhị phân -> Chia đôi mảng đến chết
 *
 * B4: Đánh giá, chọn phương án giải quyết tối ưu
 *      +Phương án 1, Tìm kiếm tuần tự -> Thời gian O(n)
 *      +Phương án 2, Tìm kiếm nhị phân nếu mảng đã được sort O(LogN)
 *
 * B5: Code*/

public class CheckArrayContainsNumber {

    //LinearSearch
    public boolean CheckArrContainsWithLinearSearch(int arr[], int numberFind){
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == numberFind){
            return true;
            }
        }
        return false;
    }
    //BianarySearch
    //Cach nay dung trong truong hop mang da duoc sort
    public boolean CheckArrContainsWithBinarySearch(int arr[], int numberFind){
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == numberFind) {
                return true;
            } else if (arr[mid] < numberFind) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 22, 1, 3, 14, 14, 33, 22, 1, 4};
        CheckArrayContainsNumber ch = new CheckArrayContainsNumber();
        boolean b = ch.CheckArrContainsWithLinearSearch(arr, 222);
        System.out.println(b);
    }
}
