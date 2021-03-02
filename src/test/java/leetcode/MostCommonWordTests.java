package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MostCommonWordTests {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] tokens = paragraph.replaceAll("\\p{Punct}", " ").split("\\s+");
        Set<String> bannedSet = Arrays.stream(banned).collect(Collectors.toSet());
        Map<String, Long> countMap = Arrays.stream(tokens).map(String::toLowerCase)
                .filter(token->!bannedSet.contains(token))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return countMap.entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .orElseThrow()
                .getKey();
    }

    @Test
    public void test() {
        System.out.println(mostCommonWord("a, a, a, a, b,b,b,c, c", new String[]{"a"}));

    }
}
