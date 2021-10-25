public class Lesson2 {
    private static WorkWithIntArray utl = new WorkWithIntArray();

    public static void main(String[] args) {
        final int SIZE = 100_000;

        int[] arr = utl.setArray(SIZE);
        int[] arrCopy = utl.getArrayCopy(arr);

        long startTime;
        long endTime;

        arrCopy = utl.getArrayCopy(arr);
        startTime = System.currentTimeMillis();
        sort1(arrCopy);
        endTime = System.currentTimeMillis();
        System.out.println(String.valueOf(endTime - startTime) + " - мс, сортировка методом выбора");

        arrCopy = utl.getArrayCopy(arr);
        startTime = System.currentTimeMillis();
        sort2(arrCopy);
        endTime = System.currentTimeMillis();
        System.out.println(String.valueOf(endTime - startTime) + " - мс, сортировка методом вставки");

        arrCopy = utl.getArrayCopy(arr);
        startTime = System.currentTimeMillis();
        sort3(arrCopy);
        endTime = System.currentTimeMillis();
        System.out.println(String.valueOf(endTime - startTime) + " - мс, пузырьковая сортировка");
    }

    // методом выбора
    private static void sort1(int[] arr) {
        int minValue;
        int minIndex;

        for (int i = 0; i < arr.length; i++) {
            minValue = arr[i];
            minIndex = i;

            for (int j = i; j < arr.length; j++) {
                if (arr[j] < minValue) {
                    minValue = arr[j];
                    minIndex = j;
                }
            }

            arr[minIndex] = arr[i];
            arr[i] = minValue;
        }
    }

    // методом вставки
    private static void sort2(int[] arr) {
        int currValue;
        int currIndex;

        for (int i = 0; i < arr.length; i++) {
            currValue = arr[i];
            currIndex = i;

            for (int j = i - 1; j >= 0; j--) {
                if (currValue > arr[j]) {
                    utl.move(arr, currIndex, j + 1);
                    break;
                }
                if (j == 0) {
                    utl.move(arr, currIndex, 0);
                }
            }
        }
    }

    // пузырьковая
    private static void sort3(int[] arr) {
        int currValue;
        boolean flgExchange = true;

        while (flgExchange) {
            currValue = arr[0];
            flgExchange = false;

            for (int i = 1; i < arr.length; i++) {
                if (currValue > arr[i]) {
                    arr[i - 1] = arr[i];
                    arr[i] = currValue;
                    currValue = arr[i];
                    flgExchange = true;
                } else {
                    currValue = arr[i];
                }
            }
        }
    }
}
