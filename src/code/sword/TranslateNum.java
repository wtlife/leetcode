package code.sword;

/**
 * @Desc 46.TranslateNum
 * @date 2020/9/1
 */
public class TranslateNum {
    public int translateNum(int num) {
        int cur = 1, pre = 1;
        String str = String.valueOf(num);
        for (int i = 2; i <= str.length(); i++) {
            String tmp = str.substring(i - 2, i);
            int tmpCur = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? pre + cur : cur;
            pre = cur;
            cur = tmpCur;
        }
        return cur;
    }
}
