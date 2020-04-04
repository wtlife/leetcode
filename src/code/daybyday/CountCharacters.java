package code.daybyday;

public class CountCharacters {
    public int countCharacters(String[] words, String chars) {
        int[] chars_count = count(chars);
        int res = 0;
        for (String word : words) {
            int[] word_count = count(word);
            if (contain(word_count, chars_count)) {
                res += word.length();
            }
        }
        return res;
    }

    private boolean contain(int[] word_count, int[] chars_count) {
        for (int i = 0; i < chars_count.length; i++) {
            if (chars_count[i] < word_count[i]) {
                return false;
            }
        }
        return true;
    }

    private int[] count(String s) {
        int[] res = new int[26];
        char[] chars = s.toCharArray();
        for (char a : chars) {
            int index = a - 'a';
            res[index]++;
        }
        return res;
    }

}
