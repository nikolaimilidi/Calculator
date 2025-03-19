public class Main {
    public static void main(String[] args) {
            String result = calc("3 - 5");
            System.out.println(result);
    }

    public static String calc(String input) {
        String[] parts = input.split(" ");

        if (parts.length != 3) {
            throw new IllegalArgumentException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }

        int num1 = Integer.parseInt(parts[0]);
        int num2 = Integer.parseInt(parts[2]);

        if (num1 < 1 || num1 > 10 || num2 < 0 || num2 > 10) {
            throw new IllegalArgumentException("Числа должны быть от 1 до 10");
        }

        int result = 0;

        switch (parts[1]) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    throw new ArithmeticException("Деление на 0 невозможно");
                }
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("Неверный формат математической операции");
        }


        return "Результат: " + result;
    }

}
