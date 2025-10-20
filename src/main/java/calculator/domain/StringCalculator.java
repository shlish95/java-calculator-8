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

                if (body.isEmpty()) {
                    throw new IllegalArgumentException("덧셈할 숫자가 없습니다.");
                }

                String[] tokens = body.split(Pattern.quote(delimiter));
                int sum = 0;

                for (String token : tokens) {
                    sum += Integer.parseInt(token);
                }

                return sum;
            }

            String delimiter = input.substring(2, litNl);
            String body = input.substring(litNl + 2);

            if (body.isEmpty()) {
                throw new IllegalArgumentException("덧셈할 숫자가 없습니다.");
            }

            String[] tokens = body.split(Pattern.quote(delimiter));
            int sum = 0;

            for (String token : tokens) {
                sum += Integer.parseInt(token);
            }

            return sum;
        }

        String[] tokens = input.split("[,:]");
        int sum = 0;

        for (String token : tokens) {
            sum += Integer.parseInt(token);
        }

        return sum;
    }
}
