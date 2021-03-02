package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupAnagramsTests {
    public List<List<String>> groupAnagrams(String[] strs) {
        return Arrays.stream(strs)
                .collect(Collectors.groupingBy(s -> s.chars().boxed().sorted().map(v->Character.valueOf((char)v.byteValue()))
                        .collect(Collector.of(StringBuilder::new, StringBuilder::append, StringBuilder::append, StringBuilder::toString)))).values().stream().collect(Collectors.toList());

    }
}
