// Solution by aryankpandey

import java.util.*;

class Solution {

    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new ArrayList<>();

        if (s == null || s.length() == 0 || words.length == 0) {
            return result;
        }

        int wordLength = words[0].length();
        int wordCount = words.length;
        int windowLength = wordLength * wordCount;

        Map<String, Integer> target = new HashMap<>();

        for (String word : words) {
            target.put(word, target.getOrDefault(word, 0) + 1);
        }

        // Try every possible starting offset
        for (int offset = 0; offset < wordLength; offset++) {

            int left = offset;
            int count = 0;

            Map<String, Integer> window = new HashMap<>();

            for (int right = offset;
                 right + wordLength <= s.length();
                 right += wordLength) {

                String word = s.substring(right, right + wordLength);

                if (target.containsKey(word)) {

                    window.put(word,
                            window.getOrDefault(word, 0) + 1);

                    count++;

                    while (window.get(word) > target.get(word)) {

                        String leftWord =
                                s.substring(left, left + wordLength);

                        window.put(leftWord,
                                window.get(leftWord) - 1);

                        left += wordLength;
                        count--;
                    }

                    if (count == wordCount) {

                        result.add(left);

                        String leftWord =
                                s.substring(left, left + wordLength);

                        window.put(leftWord,
                                window.get(leftWord) - 1);

                        left += wordLength;
                        count--;
                    }

                } else {

                    window.clear();
                    count = 0;
                    left = right + wordLength;
                }
            }
        }

        return result;
    }
}