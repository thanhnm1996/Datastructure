package fa.traning.Algorithm.Practice;

import java.util.*;

public class Duplicate {
    /**
     * Tìm và hiển thị những phần tử bị trùng lặp trong mảng
     * int[] arr = {2, 4, 3, 5, 4, 2, 4, 3, 8, 9};
     */
    private void findDuplicateByLoop(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
//            boolean check = false;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    if (!list.contains(arr[i])) {
                        list.add(arr[i]);
                    }
                }
            }
//            if (check == true){
//                list.add(arr[i]);
//            }
        }
        list.forEach(System.out::print);
    }

    private void findDuplicateBySet(int[] arr) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (!set.add(arr[i])) {
                if (!list.contains(arr[i])) {
                    list.add(arr[i]);
                }
            }
        }
        list.forEach(System.out::print);
    }

    private void removeDuplicateBySet(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        set.forEach(System.out::print);
    }

    private void removeDuplicateByLoop(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    for (int k = j; k < n - 1; k++) {
                        arr[k] = arr[k + 1];
                    }
                    n--;
                    j--;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println("");
            System.out.print(arr[i]);
        }
    }

    private void findFirstDuplicateByLoop(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1 + i; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    System.out.println(arr[i]);
                    return;
                }
            }
        }
    }

    private void countDuplicateByMap(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        Set<Integer> setKey = map.keySet();
        for (Integer key : setKey) {
            System.out.println(key + " - " + map.get(key));
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


    public static void main(String[] args) {
        int[] arr = {2, 4, 3, 5, 4, 2, 4, 3, 8, 12};
        Duplicate duplicate = new Duplicate();
//        duplicate.findDuplicateByLoop(arr);
//        System.out.println("");
//        duplicate.findDuplicateBySet(arr);
//        System.out.println("");
//        duplicate.removeDuplicateBySet(arr);
//        duplicate.removeDuplicateByLoop(arr);
//        duplicate.findFirstDuplicateByLoop(arr);
//            duplicate.countDuplicateByMap(arr);
        duplicate.countDuplicateByLoop(arr);
    }
}
