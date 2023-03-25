package fa.traning.Algorithm.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * B1: Kiến thức => Map, Array
 * <p>
 * B2: Xác định vấn đề
 * => Input: một mảng bất kì, và một số sumTarget
 * => Output: In ra các cặp có tổng = với sumTarget
 * <p>
 * B3: Đưa ra các hướng giải quyết
 * +)Phương Án 1: Sử dụng cách tiếp cận 2 chỉ số
 * B1: Sort mảng theo thứ tự tăng dần
 * B2: Khơi tạo 2 biến left, right tương ứng vị trí đầu và cuối mảng
 * B3: Sử dụng while duyệt mảng. Kiểm tra tổng của 2 phần tử left right
 * Nếu tổng = targetSum => In ra cặp left + right sau đó left++, right --
 * Nếu tổng != targetSum: check tổng < targetSum => left++
 * Nếu tổng != targetSum: check tổng > targetSum => right--
 * <p>
 * +)Phương án 2: Sử dụng Map
 * <p>
 * <p>
 * B4: Đánh giá, chọn phương án giải quyết tối ưu
 * Phương án 1: nếu đã được sort trước thì mất tg O(NlogN)
 * Phương án 2: O(n)
 * <p>
 * B5: Code
 */
public class FindTwoSumEqualTargetSum {
    private void findSumEqualsTargetSum(int arr[], int targetSum) {
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;

        //Do mảng đã soft nên ta cứ vét cạn từ ngoài vào trong, cho đến khi tìm ra các cặp có sum = targetSum
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == targetSum) {
                System.out.println(arr[left] + " - " + arr[right]);
                left++;
                right--;
            } else if (sum < targetSum) {
                left++;
            } else if (sum > targetSum) {
                right--;
            }
        }
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    public static void main(String[] args) {
        int[] arr = {2, 4, 3, 5, 6, -2, 4, 7, 8, 9};

        FindTwoSumEqualTargetSum find = new FindTwoSumEqualTargetSum();
        find.findSumEqualsTargetSum(arr, 6);
    }
}























