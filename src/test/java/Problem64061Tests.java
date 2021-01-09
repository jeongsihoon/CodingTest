import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Stack;
import java.util.stream.Stream;

public class Problem64061Tests {
    private static class Solution64061 {
        public static int solution(int[][] board, int[] moves) {
            int answer = 0;
            Stack<Integer> stack = new Stack<>();
            for (int pickedNumber : moves) {
                int doll = 0;
                for (int row = 0; row < board.length; row++) {
                    int column = pickedNumber - 1;
                    if (board[row][column] != 0) {
                        doll = board[row][column];
                        board[row][column] = 0;
                        break;
                    }
                }
                if (doll == 0) {
                    continue;
                }

                if (!stack.isEmpty() && stack.peek().equals(doll)) {
                    stack.pop();
                    answer += 2;
                } else {
                    stack.push(doll);
                }
            }

            return answer;
        }
    }
    private static Stream<Arguments> provideSources() { // argument source method
        return Stream.of(
                Arguments.of(
                        // board
                        new int[][] {
                                {0, 0, 0, 0, 0},
                                {0, 0, 1, 0, 3},
                                {0, 2, 5, 0, 1},
                                {4, 2, 4, 4, 2},
                                {3, 5, 1, 3, 1}},
                        // moves
                        new int[] {1, 5, 3, 5, 1, 2, 1, 4},
                        // expected
                        4)
        );
    }

    @ParameterizedTest
    @MethodSource("provideSources")
    void testSolution(int[][] board, int[] moves, int expected) {
        int result = Solution64061.solution(board, moves);
        Assertions.assertEquals(expected, result);
    }
}
