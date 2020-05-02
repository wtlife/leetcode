package code.daybyday.marchapril;

public class ReverseWords {
    public String reverseWords(String s) {
        String res = "";
        if (s == null || s.length() <= 0) {
            return s;
        }
        if (s.trim().length()<=0){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        String[] tempArr = s.split(" ");
        int index = tempArr.length;
        for (int i = index - 1; i >= 0; i--) {
            String temp = tempArr[i];
            if (temp.length() <= 0) {
                continue;
            }
            sb.append(tempArr[i]).append(" ");
        }
        res = sb.toString().substring(0, sb.length() - 1);
        return res;
    }
}
