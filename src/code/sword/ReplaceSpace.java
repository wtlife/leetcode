package code.sword;

/**
 * sword05. 替换空格
 */
public class ReplaceSpace {
    public String replaceSpace(String s) {
        if (s.length() == 0) {
            return s;
        }
        char[] sChar = s.toCharArray();
        int spaceCnt = 0;
        for (char a : sChar) {
            if (a == ' ') {
                spaceCnt++;
            }
        }
        int resLen = sChar.length + spaceCnt * 2;
        char[] resChar = new char[resLen];

        int resIndex = resLen - 1;
        int sIndex = sChar.length - 1;
        while (resIndex >= 0) {
            if (sChar[sIndex] == ' ') {
                resChar[resIndex--] = '0';
                resChar[resIndex--] = '2';
                resChar[resIndex--] = '%';
            } else {
                resChar[resIndex--] = sChar[sIndex];
            }
            sIndex--;
        }
        return new String(resChar);
    }
}
