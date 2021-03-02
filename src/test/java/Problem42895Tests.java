import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class Problem42895Tests {
    public int solution(int N, int number) {
        int[] counts = new int[100000];
        counts[N] = 1;
        counts[0] = 2;
        if (N != 1) {
            counts[N*N] = 2;
            counts[1] = 2;
        }

        counts[11*N] = 2;
        counts[111*N] = 3;
        counts[1111*N] = 4;
        counts[11111*N] = 5;


        for (int i = 2; i <= 32000; i++) {
            if (counts[i] == 0) {
                counts[i] = counts[i - 1] + counts[1];
            }

            if (i > N) {
                counts[i] = Math.min(counts[i-N] + 1, counts[i]);
            }
            if (i % N == 0) {
                counts[i] = Math.min(counts[i/N] + 1, counts[i]);
            }
            
            if (i*N < 100000 && counts[i*N] != 0) {
                counts[i] = Math.min(counts[i*N] + 1, counts[i]);
            }
        }

        for (int i = 0; i <= 60; i++) {
            System.out.println(String.format("i: %d, value: %d", i, counts[i]));
        }

        return counts[number] > 8 ? -1:counts[number];
    }

    // argument source method
    private static Stream<Arguments> provideSources() {
        return Stream.of(
                Arguments.of(2, 11, 3),
                Arguments.of(5, 12, 4),
                Arguments.of(2, 11, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("provideSources")
    void testSolution(int N, int number, int expected) {
        int result = solution(N, number);
        Assertions.assertEquals(expected, result);
    }
}
