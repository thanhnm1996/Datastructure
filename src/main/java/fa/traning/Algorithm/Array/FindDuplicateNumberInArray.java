package fa.traning.Algorithm.Array;

import java.util.*;

/**
 * B0:Kiến thức về vấn đề xử lí đã có chưa -> Có: Kiến thức mảng, Set
 *
 * B1: Xác định vấn đề cần xử lí: Tìm các phần tử trùng lặp có trong mảng
 * +Input: arr = {1, 22, 3, 14, 14, 33, 22, 11, 1, 1, 1}
 * +Output: arr{1, 22, 14}
 *
 * B2: Liệt kê ra các hướng giải quyết vấn đề
 * +Sử dụng mảng: => Sử dụng 2 vòng lặp for
 * Vòng for 1: Duyệt từ đầu mảng đến cuối mảng - 1
 * Vòng for 2: Duyệt từ vị trí thứ i + 1 cho đến cuối mảng, mục đích để so sánh i với các phần tử còn lại trong mảng
 * Kiểm tra xem nếu arr[i] == với arr[j] => Phần tử đó bị trùng lặp => Add vào list
 * Check xem list đã tồn tại phần tử trùng lặp chưa, nếu chưa thì mới add
 *
 * +Sử dụng set : => Cho các phần tử trong mảng lần lượt vào Set
 * Nếu set không cho add, tư là phần tử đó là phần tử bị trùng lăp => Add vào list mới
 * Tuy nhiên nếu cứ add các phần tử không được add vào Set thì list của ta cũng bị trùng lặp
 * Vì vậy ta phải làm thêm 1 bước nữa: Kiểm tra trong list đã có phần tử đó hay chưa, chưa có ms cho add list
 *
 * +Sử dụng map cho bài toán hiển thị số lần trùng lặp của mỗi phần tử
 * Khởi tạo map, Duyệt các phần tử trong mảng lần lượt từ 0 -> arr.length
 * Kiểm tra key của map đã tồn tại chưa, nếu chưa Add key = arr[i] , value = 1
 * Nếu key tồn tại put ghi đè lại key = arr[i], và value + 1.
 *
 * B3: Đánh giá, chọn phương án giải quyết tối ưu
 * Sử dụng Mảng: Thời gian O(n²) do phải sử dụng 2 vòng for
 * Sử dụng Set : Thời gian O(n)  do chỉ cần sử dụng 1 vòng for
 * Sử dụng Map : Thời gian O(n)
 *
 * B4: Code
 */
public class FindDuplicateNumberInArray {
    //Sử dụng mảng
    private void findDuplicateNumberInArray(int arr[]) {
        ArrayList<Integer> duplicateList = new ArrayList<>();

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    if (!duplicateList.contains(arr[i])) {
                        duplicateList.add(arr[i]);
                    }
                }
            }
        }
        duplicateList.forEach(System.out::println);
    }

    /**
     * Sử dụng Set
     * B1: Duyệt từ đầu mảng đến cuối mảng
     * B2: Cho các phần tử trong mảng lần lượt vào Set
     * B3: Kiểm tra Nếu phần tử Arr[i] nào không được Add vào Set
     * B4: Kiếm trả tiếp nếu ArrayList mà CHƯA chứa phần tử ko được add vào set bên trên
     * B5: Lúc này mới add phần tử đó vào List, nếu chứa rồi chạy tiếp vòng lặp
     */
    private void findDuplicateNumberInArraySet(int arr[]) {
        ArrayList<Integer> duplicateList = new ArrayList<>();
        Set<Integer> integerSet = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            if (!integerSet.add(arr[i])) {
                if (!duplicateList.contains(arr[i]))
                    duplicateList.add(arr[i]);
            }
        }
        duplicateList.forEach(System.out::println);
    }

    /**
     * Sử dụng HashMap để đếm số lần trùng lặp của các phần tử trong mảng
     * +Input: arr = {1, 22, 3, 14, 14, 33, 22, 11, 1, 1, 1}
     * +Output arr = {1, 22, 3, 14, 33, 11}
     * B1: Duyệt mảng từ đầu đến cuối
     * B2: Kiểm tra xem trong Map có chứa Key = arr[i] đó chưa
     * B3: Nếu chưa có thì put key = arr[i], value = 1 vào Trong Map
     * B4: Nếu đã chứa key trong Map: Ghi đè lại key đó: Key = arr[i], và tăng Value lên 1 đơn vị
     */
    private void findDuplicateNumberInArrayMap(int arr[]) {
        Map<Integer, Integer> map = new HashMap();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        //Hiển thị các phần tử xuất hiện nhiều hơn 1 lần
        Set<Integer> set = map.keySet();
        for (Integer key : set) {
            if (map.get(key) > 1)
                System.out.println(key + " " + map.get(key));
        }

    }

    private void countDuplicateByLoop(int[] arr) {
        boolean[] printed = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (!printed[i]) {
                int count = 1;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i] == arr[j]) {
                        count++;
                        printed[j] = true;
                    }
                }
                System.out.println(arr[i] + " xuất hiện " + count + " lần");
                printed[i] = true;
            }
        }
    }

    /** Bài toán: Tìm phần tử trùng lặp đầu tiên trong mảng
     * Ý tưởng: Cho tất cả các phần tử vào Set, phần tử nào đã có trong Set return luôn
     * Nếu chưa có trong Set thì add mới.
     * Nếu không có phần tử trùng lặp, return -1
     * O(n)
    * */
    private int findFirstDuplicateNumber(int arr[]){
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++){
            if (set.contains(arr[i])){
                return arr[i];
            }else {
                set.add(arr[i]);
            }
        }
        return -1;
    }

    /**Sử dụng 2 vòng For để tìm ra phần tử trùng lặp đầu tiên trong mảng
     * Duyệt mảng và so sánh i với j, nếu = nhau => Return luôn
     * O(n2)
    * */
    private int findFirstDuplicateNumberLoop(int arr[]) {
        for (int i =0; i < arr.length; i++ ){
            for (int j = i + 1; j < arr.length; j++){
                if (arr[i] == arr[j]){
                    return arr[i];
                }
            }
        }
        return -1;
    }

    /**==============================================EXTENDS=======================================
     * Extends: Xoá các phần tử trùng lặp trong mảng
     * Các hướng giải quyết
     * +)Đơn giản nhất  : Ném Các phần tử trong Arr vào Hashset -> OK Done
     * +)Dùng arrayList : loop từ đầu mảng đến cuối mảng
     * +Kiểm tra xem arrayList có chứa phần tử đó trong list chưa, ko có -> add vào list -> OK Done
     * +)Dùng 2 vòng lặp for: Cách thủ công
     */

    private void removeDuplicateSetInArr(int arr[]) {
        HashSet<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        set.forEach(System.out::println);
    }

    private void removeDuplicateArrayListInArr(int arr[]) {
        List<Integer> arrayList = new ArrayList();
        for (int i = 0; i < arr.length; i++) {
            if (!arrayList.contains(arr[i])) {
                arrayList.add(arr[i]);
            }
        }
        arrayList.forEach(System.out::println);
    }

    /**
     *Sử dụng 2 vòng lặp for, Mảng có 10 phần tử
     * Vòng lặp for 1 duyệt từ đầu Arr[0] cho đến cuối mảng
     * Vòng lặp for thứ 2 chạy từ Arr[i+1] cho đến phần tử thứ 10 của mảng Arr[9]
     * So sánh Arr[i] == Arr[j], Nếu bằng nhau tại vị trí Arr[j] nào đó.
     * Ta sẽ gán k = j Duyệt một vòng for mới Với mục đích thay đổi giá trị của phần tử trùng lặp bằng
     * giá trị của phần tử kế tiếp (Dịch chuyển các phần tử phía sau lùi lên 1 ô)
     * Sau đó ta sẽ --n kíck thước mảng đi 1 đơn vị
     * Khi in ra ta chỉ cần in mảng đến phần tử n là được
     * */
    private void removeDuplicateInArrLoop(int arr[]) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    // Dịch chuyển các phần tử trong mảng lên một bậc để xóa phần tử trùng lặp
                    for (int k = j; k < n -1; k++) {
                        arr[k] = arr[k + 1];
                    }
                    n--;
                    j--;
                }
            }
        }

        // In ra mảng đã xóa các phần tử trùng lặp
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        FindDuplicateNumberInArray find = new FindDuplicateNumberInArray();
        int[] arr = {1, 22, 1, 3, 14, 14, 33, 22, 1, 4};
//        find.findDuplicateNumberInArray(arr);
//        find.findDuplicateNumberInArraySet(arr);
//        find.findDuplicateNumberInArrayMap(arr);
//        find.removeDuplicateArrayListInArr(arr);
        System.out.println("=============================");
        find.removeDuplicateInArrLoop(arr);
    }
}
