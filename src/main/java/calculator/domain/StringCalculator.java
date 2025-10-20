package calculator.domain;

import java.util.regex.Pattern;

public final class StringCalculator {

    private StringCalculator() {
    }

    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        if (input.startsWith("//")) {
            int realNl = input.indexOf('\n');
            int litNl = input.indexOf("\\n");

            if (realNl < 0 && litNl < 0) {
                throw new IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다.");
            }

            if (realNl >= 0) {
                String delimiter = input.substring(2, realNl);
                String body = input.substring(realNl + 1);

                ensureHasNumbers(body);

                return sumTokens(body.split(Pattern.quote(delimiter)));
            }

            String delimiter = input.substring(2, litNl);
            String body = input.substring(litNl + 2);

            ensureHasNumbers(body);

            return sumTokens(body.split(Pattern.quote(delimiter)));
        }

        return sumTokens(input.split("[,:]"));
    }

    private static int sumTokens(String[] tokens) {
        int sum = 0;

        for (String token : tokens) {
            sum += Integer.parseInt(token);
        }

        return sum;
    }

    private static void ensureHasNumbers(String body) {
        if (body == null || body.isEmpty()) {
            throw new IllegalArgumentException("덧셈할 숫자가 없습니다.");
        }
    }
}
