package code.string;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 609. 在系统中查找重复文件
 */
public class FindDuplicate {
    public List<List<String>> findDuplicate(String[] paths) {

        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String path : paths) {
            String[] splitPath = path.split(" ");
            String dir = splitPath[0] + "/";
            for (int i = 1; i < splitPath.length; i++) {

                String[] temp = splitPath[i].split("\\(");
                String fileName = dir + temp[0];
                String file = temp[1].substring(0, temp[1].length() - 1);

                if (map.containsKey(file)) {
                    map.get(file).add(fileName);
                } else {
                    List<String> tempList = new ArrayList<>();
                    tempList.add(fileName);
                    map.put(file, tempList);
                }
            }
        }
        for (List<String> strings:map.values()) {
            if (strings.size()>1){
                res.add(strings);
            }
        }
        return res;
    }
}
