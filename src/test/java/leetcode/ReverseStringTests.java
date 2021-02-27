package leetcode;

// https://leetcode.com/problems/reverse-string
public class ReverseStringTests {
    class Solution {
        public void reverseString(char[] s) {
            int length = s.length;
            for (int i = 0; i < length/2; i++) {
                swap(s, i, length -1 -i);
            }
        }

        public void swap(char[] s, int first, int second) {
            char temp = s[first];
            s[first] = s[second];
            s[second] = temp;
        }
    }
}
