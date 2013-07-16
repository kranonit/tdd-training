package org.kranonit.tdd.stringCalculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    public static final String DEFAULT_DELIMITER_REGEX = "[,\n]";
    public static final String PREFIX = "//";

    public int add(String s) {
        if (s.isEmpty()) return 0;
        String delimiter;
        String numbers;
        if (s.startsWith(PREFIX)) {
            delimiter = s.substring(PREFIX.length(), PREFIX.length() + 1);
            numbers = s.substring(s.indexOf('\n') + 1);
        } else {
            delimiter = DEFAULT_DELIMITER_REGEX;
            numbers = s;
        }

        String[] strings = numbers.split(delimiter);
        int sum = 0;
        List<Integer> negatives = new ArrayList<Integer>();
        for (String string : strings) {
            int n = Integer.parseInt(string);
            if (n < 0) negatives.add(n);
            sum += n;
        }

        if (!negatives.isEmpty()) {
            throw new NumberFormatException("negatives not allowed " + negatives);
        }

        return sum;
    }
}
