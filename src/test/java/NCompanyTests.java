import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

class Solution {


    @Test
    void test() {
        System.out.println(solution(1, 8, 3, 2));
        System.out.println(solution(2, 3, 3, 2));
        System.out.println(solution(6, 2, 4, 7));
    }

    public int solution(int A, int B, int C, int D) {
        // write your code in Java SE 11
        int[] array = new int[] {A, B, C, D};
        Set<List<Integer>> permutationSet = new HashSet<>();
        permutation(array, 0, 4, 4, permutationSet);

        int answer = 0;
        for (List<Integer> ints : permutationSet) {
            int hour = ints.get(0) * 10 + ints.get(1);
            if (hour >= 24) {
                continue;
            }

            int minutes = ints.get(2) * 10 + ints.get(3);
            if (minutes >= 60) {
                continue;
            }
            answer++;
        }
        return answer;
    }


    void permutation(int[] arr, int depth, int n, int r, Set<List<Integer>> permutationSet) {
        if (depth == r) {
            permutationSet.add(Arrays.stream(arr).boxed().collect(Collectors.toList()));
            return;
        }

        for (int i = depth; i<n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r, permutationSet);
            swap(arr, depth, i);
        }
    }

    void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }
}
