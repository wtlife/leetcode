package code.string;


import java.util.Arrays;

/**
 * 937. 重新排列日志文件
 */
public class ReorderLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            String[] l1 = log1.split(" ", 2);
            String[] l2 = log2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(l1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(l2[1].charAt(0));
            if (!isDigit1 && !isDigit2) {
                int cmp = l1[1].compareTo(l2[1]);
                if (cmp != 0) {
                    return cmp;
                }
                return l1[0].compareTo(l2[0]);
            }

            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;

        });
        return logs;
    }

}
