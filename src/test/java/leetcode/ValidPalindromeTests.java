package leetcode;

import java.util.*;

// https://leetcode.com/problems/valid-palindrome
public class ValidPalindromeTests {
    class Solution {
        public boolean isPalindrome(String s) {
            Deque dequeue = new ArrayDeque(s.length());
            for (char c : s.toCharArray()) {
                if (!Character.isAlphabetic(c) && !Character.isDigit(c)) {
                    continue;
                }

                char lowerC = Character.toLowerCase(c);
                dequeue.add(lowerC);
            }

            while (!dequeue.isEmpty()) {
                Character c1 = (Character)dequeue.pollFirst();
                Character c2 = (Character)dequeue.pollLast();
                if (c2 == null) {
                    continue;
                }

                if (!c1.equals(c2)) {
                    return false;
                }
            }

            return true;
        }
    }
}
