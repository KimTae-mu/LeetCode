package com.alva.LeetCode.back;

/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class SpellWord {
    public int countCharacters(String[] words, String chars) {
        int alphabet[] = new int[26];

        for (int i = 0; i < chars.length(); i++) {
            alphabet[chars.charAt(i) - 'a']++;
        }

        int res = 0;
        for (String word : words) {
            int wordCount[] = new int[26];

            for (int i = 0; i < word.length(); i++) {
                wordCount[word.charAt(i) - 'a']++;
            }

            if (contains(alphabet, wordCount)) {
                res += word.length();
            }
        }
        return res;
    }

    public static boolean contains(int[] alphabet, int[] wordCount) {
        for (int i = 0; i < 26; i++) {
            if (alphabet[i] < wordCount[i]) {
                return false;
            }
        }
        return true;
    }
}
