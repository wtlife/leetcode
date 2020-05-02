package code.daybyday.marchapril;

public class CompressString {
    public String compressString(String S) {
        int len = S.length();
        if (len<=2){
            return S;
        }
        StringBuilder res = new StringBuilder();
        int count = 1;
        res.append(S.charAt(0));
        for (int i = 1; i < len; i++) {
            char chari = S.charAt(i);
            char chariLast = S.charAt(i - 1);
            if (chari == chariLast) {
                count++;
            } else {
                res.append(count).append(chari);
                count = 1;
            }
        }
        res.append(count);
        return res.length() > S.length() ? S : res.toString();
    }
}
