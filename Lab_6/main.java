public class Main {
    public static void main(String[] args) {
        // Завдання 1: Перетворення int в двійковий String
        int number = 21;
        String binaryString = intToBinaryString(number);
        System.out.println("Завдання 1:");
        System.out.println("Аргумент: " + number);
        System.out.println("Результат: \"" + binaryString + "\"");
        System.out.println();

        // Завдання 2: Заміна слів на верхній регістр
        String sentence = "The user dog with the nickname koala757677 this month wrote 3 times more comments than the user with the nickname croco181dile920 4 months ago";
        String upperCaseResult = convertWordsToUpperCase(sentence);
        System.out.println("Завдання 2:");
        System.out.println("Аргумент: \"" + sentence + "\"");
        System.out.println("Результат: \"" + upperCaseResult + "\"");
    }

    // Завдання 1: Перетворення int в двійковий String
    public static String intToBinaryString(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Число повинно бути не від'ємним");
        }

        return Integer.toBinaryString(i);
    }

    // Завдання 2: Заміна слів на верхній регістр
    public static String convertWordsToUpperCase(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            throw new IllegalArgumentException("Речення не може бути пустим або null");
        }

        String[] words = sentence.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (word.matches("^[a-zA-Z]+$")) {
                // Якщо слово складається лише з літер, замінюємо його на верхній регістр
                result.append(word.toUpperCase()).append(" ");
            } else {
                result.append(word).append(" ");
            }
        }

        return result.toString().trim();
    }
}
