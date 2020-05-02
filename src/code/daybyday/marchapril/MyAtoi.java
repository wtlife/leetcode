package code.daybyday.marchapril;

public class MyAtoi {
    public int myAtoi(String str) {
        int len = str.length();
        if (len == 0) {
            return 0;
        }
        int index = 0;
        while (index < len && str.charAt(index) == ' ') {
            index++;
        }
        if (index == len) {
            return 0;
        }

        boolean isMinus = false;
        char indexChar = str.charAt(index);
        if (indexChar != '-' && !Character.isDigit(indexChar)) {
            return 0;
        }
        if (indexChar == '-') {
            isMinus = true;
            index++;
        }



        int index2 = index;
        while (index2 < len) {
            char index2Char = str.charAt(index2);
            if (Character.isDigit(index2Char)) {
                index2++;
            } else {
                break;
            }
        }
        String resStr = str.substring(index, index2);
        if (isMinus) {
            resStr = "-" + resStr;
        }
        return Integer.parseInt(resStr);
    }
}
