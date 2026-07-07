class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int[] hash = new int[256];
        int start = 0;
        int end = 0;

        while (start < s.length()) {
            int num = s.charAt(start);
            hash[num]++;

            if (hash[num] > 1) {
                while (hash[num] > 1 && end < s.length()) {
                    hash[s.charAt(end)]--;
                    end++;
                }
            }

            result = Math.max(result, start - end + 1);
            start++;
        }

        return result;
    }
}