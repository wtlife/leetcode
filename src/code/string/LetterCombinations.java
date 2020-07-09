package code.string;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字符组合
 */
public class LetterCombinations {


    List<String> res = new ArrayList<>();
    private String[] phone = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if (digits.isEmpty()) return ans;
        ans.add("");
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            while (ans.peek().length() == i) {
                String t = ans.remove();
                for (char s : phone[x].toCharArray())
                    ans.add(t + s);
            }
        }
        return ans;
    }

    public List<String> letterCombinations2(String digits) {
        if (digits.length() == 0) {
            return res;
        }
        backTrack("", digits);
        return res;
    }

    private void backTrack(String combination, String digits) {
        if (digits.length() == 0) {
            res.add(digits);
        } else {
            Integer digit = Integer.valueOf(digits.substring(0, 1));
            String letters = phone[digit];
            for (int i = 0; i < letters.length(); i++) {
                String letter = letters.substring(i, i + 1);
                backTrack(combination + letter, digits.substring(1));
            }
        }
    }

    public List<String> getRes(String digits) {
        LinkedList<String> res = new LinkedList<>();
        res.add("");

        for (int i = 0; i < digits.length(); i++) {
            String letters = phone[Character.getNumericValue(digits.charAt(i))];
            while (res.peek().length()==i){
                String first = res.remove();
                for (int j = 0; j <letters.length() ; j++) {
                    String tmp = first+ letters.substring(j,j+1);
                    res.add(tmp);
                }
            }
        }

        return res;
    }

}
