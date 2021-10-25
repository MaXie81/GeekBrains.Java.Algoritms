import java.util.Arrays;
import java.util.Random;

public class WorkWithIntArray {
    public int[] setArray(int size) {
        int[] arr = new int[size];
        Random rnd = new Random();

        for (int i = 0; i < size; i++) {
            arr[i] = rnd.nextInt(size);
        }

        return arr;
    }

    public int[] getArrayCopy(int[] arr) {return Arrays.copyOf(arr, arr.length);};

    public void print(int[] arr, int count) {
        for (int i = 0; i < count; i++) {
            if ((i + 1) % 50 == 0)
                System.out.println(String.valueOf(arr[i]) + " ");
            else
                System.out.print(String.valueOf(arr[i]) + " ");
        }
        System.out.println();
    }

    public void move(int[] arr, int currIndex, int newIndex) {
        if (currIndex == newIndex) return;

        int currValue = arr[currIndex];
        if (currIndex > newIndex)
            for (int i = currIndex - 1; i >= newIndex; i--) {
                arr[i + 1] = arr[i];
            }
        else {
            for (int i = currIndex + 1; i <= newIndex; i++) {
                arr[i - 1] = arr[i];
            }
        }
        arr[newIndex] = currValue;
    }
}
