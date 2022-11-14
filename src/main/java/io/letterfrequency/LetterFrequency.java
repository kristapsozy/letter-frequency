package io.letterfrequency;

import java.io.*;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LetterFrequency {
    private static final String FILE = "src/main/resources/letterfrequency/text.txt";
    private static final String RESULT = "src/main/resources/letterfrequency/result.txt";

    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(new File(FILE).getAbsolutePath()));
            BufferedWriter out = new BufferedWriter(new FileWriter(new File(RESULT).getAbsolutePath()));

            Map<Character, Long> result = textToLetterCountMap(in.lines());
            out.write(result.toString());
            in.close();
            out.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static Map<Character, Long> textToLetterCountMap(Stream<String> lines) {
        return lines.toList().stream()
                .flatMap(str -> str.toUpperCase()
                        .replaceAll("[^A-Z]", "").chars()
                        .mapToObj(c -> (char) c))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
