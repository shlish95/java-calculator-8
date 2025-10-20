package calculator.domain;

public final class StringCalculator {

    private StringCalculator() {
    }

    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] tokens = input.split("[,:]");
        int sum = 0;

        for (String token : tokens) {
            sum += Integer.parseInt(token);
        }

        return sum;
    }
}
