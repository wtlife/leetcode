package code.leetbook.bytedance.str;

/**
 * @Desc ReverseWords
 * @date 2020/9/10
 */
public class ReverseWords {
    public String reverseWords(String s) {
        String str = s.trim();
        String[] strings = str.split(" ");
        int left = 0;
        int right = strings.length - 1;

        while (left < right) {
            while (left < right && strings[left].equals("")) {
                left++;
            }
            while (left < right && strings[right].equals("")) {
                right--;
            }
            if (left >= right) {
                break;
            }


            String tmp = strings[left];
            strings[left] = strings[right];
            strings[right] = tmp;
            left++;
            right--;
        }

        String res = "";
        for (String s1 : strings) {
            if (s1.equals("")) {
                continue;
            }
            res = res + s1 + " ";
        }
        return res.substring(0, res.length() - 1);
    }

    public String reverseWord(String s) {
        if (s.trim().length() <=0) {
            return s.trim();
        }
        s = s.trim();

        String[] strings = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strings.length-1; i >= 0; i--) {
            if (strings[i].length() <= 0) {
                continue;
            }
            sb.append(strings[i]).append(" ");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }


}
