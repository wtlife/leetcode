package code.sword;

/**
 * @Desc 58-1.ReverseWords
 * @date 2020/9/4
 */
public class ReverseWords {

    public String reverseWords(String s) {
        s=s.trim();
        if (s.length()<1){
            return "";
        }
        String[] strings = s.split(" ");
        int i = 0;
        int j = strings.length - 1;
        while (i < j) {
            while (i < j && strings[i].equals("")) {
                i++;
            }

            while (i < j && strings[j].equals("")) {
                j--;
            }
            if (i >= j) {
                break;
            }
            String tmp = strings[i];
            strings[i] = strings[j];
            strings[j] = tmp;

            i++;
            j--;
        }
        StringBuilder res = new StringBuilder();
        for (String s1 : strings) {
            if (s1.equals("")) {
                continue;
            }
            res.append(s1).append(" ");
        }
        return res.substring(0, res.length() - 1);
    }

}
