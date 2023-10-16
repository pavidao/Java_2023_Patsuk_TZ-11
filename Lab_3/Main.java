import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Завдання 1
        System.out.print("Завдання 1: Введіть a, b, та k (k ≤ 30): ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        int k = scanner.nextInt();
        if (k <= 30) {
            double sum = calculateSum(a, b, k);
            System.out.println("Сума ряду: " + sum);
        } else {
            System.out.println("Помилковий параметр k для завдання 1.");
        }

        // Завдання 2
        System.out.print("Завдання 2: Введіть t та i: ");
        double t = scanner.nextDouble();
        int i = scanner.nextInt();
        double result = calculateFunctionValue(t, i);
        System.out.println("Значення функції: " + result);

        // Завдання 3
        System.out.print("Завдання 3: Введіть точність ε: ");
        double epsilon = scanner.nextDouble();
        double infiniteSum = calculateInfiniteSum(epsilon);
        System.out.println("Значення нескінченної суми: " + infiniteSum);
    }

    public static double calculateSum(double a, double b, int k) {
        double sum = 0;
        for (int i = 1; i <= k; i++) {
            double term = Math.sqrt(a * i * Math.sqrt(b / i));
            sum += term;
        }
        return sum;
    }

    public static double calculateFunctionValue(double t, int i) {
        if (i == 1) {
            return Math.sqrt(t);
        } else if (i == 2) {
            if (t == 0) {
                return Double.POSITIVE_INFINITY;
            }
            return 1 / Math.sqrt(t);
        } else {
            double sum = 0;
            for (int k = 1; k <= i; k++) {
                sum += k * t;
            }
            return sum;
        }
    }

    public static double calculateInfiniteSum(double epsilon) {
        double sum = 0;
        double term = 1;
        int i = 1;
        while (Math.abs(term) > epsilon) {
            term = Math.pow(-1, i) / factorial(i);
            sum += term;
            i++;
        }
        return sum;
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
