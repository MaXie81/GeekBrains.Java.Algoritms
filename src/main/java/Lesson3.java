import arrays.*;

import java.util.Arrays;

public class Lesson3 {
    public static void main(String[] args) throws Exception {
        // проверка выполнения п.1
        StringBuilder word = new StringBuilder("Слово");
        Stack<Character> arr = new Stack<>(word.length());

        for (Character c : word.toString().toCharArray()) {
            arr.pushIn(c);
        }

        word = new StringBuilder();
        while (!arr.isEmpty()) {
            word.append(arr.pushOut());
        }

        System.out.println(word);
        System.out.println();

        // проверка выполнения п.2
        Dequeue<String> arrD = new Dequeue<>(10);

        arrD.pushInLeft("L0");
        arrD.pushInLeft("L1");
        arrD.pushInLeft("L2");
        System.out.println(Arrays.asList(arrD.getArr()));

        arrD.pushInRight("R0");
        System.out.println(Arrays.asList(arrD.getArr()));

        arrD.pushInLeft("L3");
        System.out.println(Arrays.asList(arrD.getArr()));

        arrD.pushOutRight();
        System.out.println(Arrays.asList(arrD.getArr()));

        arrD.pushOutRight();
        System.out.println(Arrays.asList(arrD.getArr()));

        arrD.pushOutLeft();
        arrD.pushInRight("R1");
        System.out.println(Arrays.asList(arrD.getArr()));

        arrD.pushOutLeft();
        arrD.pushOutLeft();
        System.out.println(Arrays.asList(arrD.getArr()));

        arrD.pushOutLeft();
        System.out.println(Arrays.asList(arrD.getArr()));

        arrD.pushInRight("R3");
        arrD.pushInRight("R4");
        arrD.pushInLeft("L4");
        System.out.println(Arrays.asList(arrD.getArr()));
    }
}