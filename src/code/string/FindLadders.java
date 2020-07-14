package code.string;

import java.util.*;

/**
 * 126. 单词接龙II
 */
public class FindLadders {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        Deque<List<String>> queue = new ArrayDeque<>();
        boolean isFound = false;

        visited.add(beginWord);
        path.add(beginWord);
        queue.addLast(path);

        while (!queue.isEmpty()) {

            int size = queue.size();
            Set<String> subVisited = new HashSet<>();
            for (int i = 0; i < size; i++) {
                List<String> p = queue.pollFirst();
                String lastNode = p.get(p.size() - 1);
                List<String> neighbors = getNeighbors(lastNode, wordSet);

                for (String neighbor : neighbors) {
                    if (visited.contains(neighbor)) {
                        continue;
                    }
                    if (endWord.equals(neighbor)) {
                        isFound = true;
                        p.add(neighbor);
                        res.add(new ArrayList<>(p));
                        p.remove(p.size() - 1);
                    }

                    p.add(neighbor);
                    subVisited.add(neighbor);
                    queue.addLast(new ArrayList<>(p));
                    p.remove(p.size() - 1);


                }
            }

            visited.addAll(subVisited);
            if (isFound) {
                break;
            }
        }
        return res;
    }

    private List<String> getNeighbors(String lastNode, Set<String> wordSet) {
        List<String> res = new ArrayList<>();
        char[] nodeChar = lastNode.toCharArray();
        for (int i = 0; i < lastNode.length(); i++) {
            char oldChar = lastNode.charAt(i);
            for (char j = 'a'; j <= 'z'; j++) {
                if (j == oldChar) {
                    continue;
                }
                nodeChar[i] = j;
                if (wordSet.contains(String.valueOf(nodeChar))) {
                    res.add(String.valueOf(nodeChar));
                }
                nodeChar[i] = oldChar;
            }
        }
        return res;
    }
}
