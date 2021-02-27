package leetcode;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

//https://leetcode.com/problems/reorder-data-in-log-files/
public class ReorderLogFilesTests {
    class Solution {
        public String[] reorderLogFiles(String[] logs) {
            List<String> letterLogList = Arrays.stream(logs)
                    .filter(log->Character.isLetter(log.split(" ")[1].charAt(0)))
                    .sorted((a, b)->{
                        String identifierA = a.split(" ")[0];
                        String identifierB = b.split(" ")[0];

                        int result = a.substring(identifierA.length() + 1)
                                .compareTo(b.substring(identifierB.length() + 1));
                        if (result == 0) {
                            result = identifierA.compareTo(identifierB);
                        }
                        return result;
                    })
                    .collect(Collectors.toList());

            List<String> digitLogList = Arrays.stream(logs)
                    .filter(log->Character.isDigit(log.split(" ")[1].charAt(0)))
                    .collect(Collectors.toList());

            List<String> answer = new ArrayList<>();
            answer.addAll(letterLogList);
            answer.addAll(digitLogList);

            return answer.toArray(new String[logs.length]);
        }
    }
}
