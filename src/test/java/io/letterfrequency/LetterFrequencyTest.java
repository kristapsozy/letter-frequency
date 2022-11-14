package io.letterfrequency;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Map;

import static io.letterfrequency.LetterFrequency.textToLetterCountMap;


public class LetterFrequencyTest {
    private static final String FILE = "src/main/resources/letterfrequency/text.txt";
    private static final String RESULT = "src/main/resources/letterfrequency/result.txt";

    @Test
    void readingFileTest() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(new File(FILE).getAbsolutePath()));
        String result = in.readLine();
        in.close();
        Assertions.assertEquals("Deer or true deer are hoofed ruminant mammals forming the family Cervidae."
                , result);
    }

    @Test
    void writeFileTest() throws IOException {
        BufferedWriter out = new BufferedWriter(new FileWriter(new File(RESULT).getAbsolutePath()));
        BufferedReader in = new BufferedReader(new FileReader(new File(RESULT).getAbsolutePath()));
        out.write("Writing!");
        out.close();
        Assertions.assertEquals("Writing!", in.readLine());
        in.close();
    }

    @Test
    void testLetterCounter() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(new File(FILE).getAbsolutePath()));
        Map<Character, Long> result = textToLetterCountMap(in.lines());
        Assertions.assertEquals("{A=69, B=2, C=20, D=37, E=107, F=20, G=7, H=29, I=44, J=1, K=2," +
                " L=31, M=20, N=39, O=34, P=11, R=54, S=24, T=49, U=13, V=6, W=10, X=1, Y=9}", result.toString());
    }
}
