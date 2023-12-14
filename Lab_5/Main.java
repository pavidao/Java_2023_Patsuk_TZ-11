
public class Main {

    // Метод сортування вибором (Selection Sort)
    public static float[] selectionSort(float[] arr) {
        int n = arr.length;
        float[] inerArr = {4.0f, 2.0f, 7.0f, 1.0f, 5.0f}; // Ваш вхідний масив

        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;

            // Знаходимо індекс найбільшого елемента в невідсортованій частині масиву
            for (int j = i + 1; j < n; j++) {
                if (inerArr[j] > inerArr[maxIndex]) {
                    maxIndex = j;
                }
            }

            // Міняємо місцями знайдений найбільший елемент з першим елементом невідсортованої частини
            float temp = inerArr[maxIndex];
            inerArr[maxIndex] = inerArr[i];
            inerArr[i] = temp;
        }

        return inerArr;
    }

    // Метод сортування вставками (Insertion Sort)
    public static void InsertionSort(float[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            float key = arr[i];
            int j = i - 1;

            // Порівнюємо поточний елемент з попередніми та вставляємо його на відповідне місце
            while (j >= 0 && arr[j] < key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        // Заданий масив для сортування
        float[] array = {4.2f, 12.7f, 8.9f, 3.2f, 11.9f};

        // Виведення несортованого масиву
        System.out.println("Несортований масив:");
        PrintArray(array);

        // Копіювання масиву для сортування вибором
        float[] selectionSortArray = array.clone();
        // Виклик методу сортування вибором
        selectionSort(selectionSortArray);
        System.out.println("Після сортування вибором:");
        PrintArray(selectionSortArray);

        // Копіювання масиву для сортування вставками
        float[] insertionSortArray = array.clone();
        // Виклик методу сортування вставками
        InsertionSort(insertionSortArray);
        System.out.println("Після сортування вставками:");
        PrintArray(insertionSortArray);

        // Виклик методу сортування вибором для масиву 2
        float[] sortedArray = selectionSort(new float[]{});
        System.out.println("Після сортування вибором масиву 2:");
        PrintArray(sortedArray);
    }

    // Допоміжний метод для виведення масиву на екран
    public static void PrintArray(float[] arr) {
        for (float value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
