package fa.traning.ArrayList;

import java.util.ArrayList;
import java.util.Iterator;

public class CustomArrayList<T> implements Iterable<T> {

    //Mảng tĩnh
    private T[] arr;

    //Độ dài mảng ban đầu
    private int capacity = 0;

    //Size thực tế các phần tử có trong mảng
    private int size = 0;

    //Contructor Array 1 tham số truyền vào là capacity
    //Nếu tham số truyền vào < 0 -> Thow Exception,
    //Nếu tham số truyền vào > 0 -> Ta một mảng mới với kích thước bằng capacity truyền vào.
    public CustomArrayList(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("Capacity cannot be negative:" + capacity);
        this.capacity = capacity;
        this.arr = (T[]) new Object[capacity];
    }

    //Contructor không tham số, Khi không có tham số truyền vào nó sẽ gọi lại
    //Hàm contructor 1 tham số phía trên và truyền vào capacity mặc định = 10.
    public CustomArrayList() {
        this(10);
    }

    //Lấy ra các phần t có trong mảng
    public int size() {
        return this.size;
    }

    //Gọi hàm Size bên trên và so sánh với 0, nếu bằng nhau => Mảng rỗng(true)
    public boolean isEmpty() {
        return size() == 0;
    }

    // Lấy ra phần tử trong mảng thông qua giá trị index truyền vào
    public T get(int index) {
        return this.arr[index];
    }

    // Thêm một phần tử vào mảng thông qua index
    public void set(int index, T element) {
        this.arr[index] = element;
    }

    // Xoá mảng và sét size mảng bằng 0
    public void clear() {
        for (int i = 0; i < size; i++) {
            this.arr[i] = null;
        }
        this.size = 0;
    }

    //Thêm mới phần tử vào trong mảng (append vào cuối mảng)
    //Check nếu số lượng element(size) gần đầy rồi, nếu add 1 phần tử mới vào thì sẽ đầy
    // Lúc này ta sẽ phải tăng kích thước mảng, nếu mảng chưa có phần tử nào -> Set capaciti = 1
    //Nếu mảng đã có phần tử thì ta sẽ nhân đôi kích thước mảng
    //Do kích thước mảng tĩnh là cố định nên ta sẽ tạo một mảng mới và truyền kích thước capacity mới vào newArr
    //Sau đó duyệt vòng lặp for để gán element từ mảng cũ sang mảng mới
    //Sau đó gán newArr ngược lại cho mảng arr ban đầu

    public void add(T element) {
        if (this.size >= this.capacity - 1) {
            if (this.capacity == 0) this.capacity = 1;
            else {
                this.capacity *= 2;
            }
            T[] newArr = (T[]) new Object[this.capacity];
            for (int i = 0; i < this.arr.length; i++) {
                newArr[i] = this.arr[i];
            }
            this.arr = newArr;
        }
        //Sau bước tăng kích thước thì sẽ thêm phần phần mới vào trong mảng,
        //Hoặc nếu mảng chưa đầy thì ta thêm phần tử luôn.
        arr[size++] = element;
    }

    //Khởi tạo ra một mảng tĩnh mới với size nhỏ hơn 1 size so vơi mảng ban đầu
    //Khởi tạo vòng lặp gồm 2 biến chạy old và new, ta sẽ cho nó chạy từ đầu size cho đến cuối size mảng gốc
    //Sau đó cả mảng cũ và mảng mới đều tăng index lên 1 đơn vị
    //Gán từng giá trị của mảng cũ vào mảng mới
    //Nếu index của mảng cũ trùng mới index cần xoá ta truyền vào, lúc này ta sẽ LÙI bộ đếm của mảng mới 1 đơn vị,
    //Và không thực hiện phép gán nào cả, tiếp tục chạy đến cuối mảng
    //Sau đó gán mới vào bảng cũ, và set capacity = -- size (size của mảng mới).
    public void removeAt(int removeIndex) {
        if (removeIndex >= size || removeIndex < 0) throw new IllegalArgumentException();

        T[] newArr = (T[]) new Object[size - 1];
        for (int oldArrIndex = 0, newArrIndex = 0; oldArrIndex < size; oldArrIndex++, newArrIndex++) {

            if (oldArrIndex == removeIndex) newArrIndex--;

            else newArr[newArrIndex] = this.arr[oldArrIndex];
        }
        this.arr = newArr;
        capacity = --size;
    }

    //Hàm xoá object, ta sẽ phải tìm ra index của object này trong Array
    //Sau đó gọi hàm removeAt() để remove object đó
    public void remove(Object object) {
        int removeIndex = indexOf(object);
        removeAt(removeIndex);
    }


    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (object == null ){
                if (arr[i] == null) return i;
            }
            if (object.equals(arr[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
