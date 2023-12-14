import java.util.Arrays;

public class Task_3_67 {
    public static void main(String[] args) {
        int[] arrayA = {1, 3, 5};
        int[] arrayB = {2, 4, 6};
        int[] result = mergeArrays(arrayA, arrayB);

        System.out.println("Масив A: " + Arrays.toString(arrayA));
        System.out.println("Масив B: " + Arrays.toString(arrayB));
        System.out.println("Результат об'єднання масивів A та B: " + Arrays.toString(result));
    }

    public static int[] mergeArrays(int[] arrA, int[] arrB) {
        if (arrA == null || arrB == null) {
            throw new NullPointerException("Вхідні масиви не повинні бути null");
        }

        if (arrA.length != arrB.length) {
            throw new IllegalArgumentException("Масиви A та B повинні мати однакову довжину");
        }

        int n = arrA.length;
        int[] result = new int[2 * n];

        for (int i = 0; i < n; i++) {
            result[2 * i] = arrA[i];
            result[2 * i + 1] = arrB[i];
        }

        return result;
    }
}
