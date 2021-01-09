import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class Problem68644Tests {

    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                set.add(sum);
            }
        }
        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }


    // argument source method
    private static Stream<Arguments> provideSources() {
        return Stream.of(
                Arguments.of(
                        // numbers
                        new int[] {2,1,3,4,1},
                        // expected
                        new int[] {2,3,4,5,6,7}),

                Arguments.of(
                        // numbers
                        new int[] {5,0,2,7},
                        // expected
                        new int[] {2,5,7,9,12})
        );
    }

    @ParameterizedTest
    @MethodSource("provideSources")
    void testSolution(int[] numbers, int[] expected) {
        int[] result = solution(numbers);
        for (int index = 0; index < result.length; index++) {
            System.out.println(result[index]);
        }
        Assertions.assertEquals(expected.length, result.length);
        for (int i = 0; i < numbers.length; i++) {
            Assertions.assertEquals(expected[i], result[i]);
        }

    }
}
