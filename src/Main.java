import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите арифметическую операцию: ");
        String input = scanner.nextLine();
        try {
            String result = calc(input);
            System.out.println(result);
        } catch (IllegalArgumentException | ArithmeticException e) {
            System.out.println(e.getMessage());
        }

    }

    public static String calc(String input) {
        String[] parts = input.split(" ");

        if (parts.length < 3) {
            throw new IllegalArgumentException("throws Exception //т.к. строка не является математической операцией");
        }

        if (parts.length != 3) {
            throw new IllegalArgumentException("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }


        int num1 = Integer.parseInt(parts[0]);
        int num2 = Integer.parseInt(parts[2]);

        if (num2 == 0) {
            throw new ArithmeticException("Деление на 0 невозможно");
        }

        if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
            throw new IllegalArgumentException("Числа должны быть от 1 до 10");
        }

        int result = switch (parts[1]) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;
            default -> throw new IllegalArgumentException("Неверный формат математической операции");
        };


        return "Результат: " + result;
    }

}
