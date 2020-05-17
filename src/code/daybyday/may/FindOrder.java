package code.daybyday.may;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 210. 课程表II
 */
public class FindOrder {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        //两个特判
        if (numCourses == 0) {
            return new int[0];
        }
        int preLen = prerequisites.length;
        if (preLen == 0) {
            int[] res = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                res[i] = i;
            }
            return res;
        }

        //初始化邻接链表与入度数组
        int[] inDegree = new int[numCourses];
        Set<Integer>[] adj = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new HashSet<>();
        }

        //构造邻接链表与入度数组
        for (int[] prerequisit : prerequisites) {
            adj[prerequisit[1]].add(prerequisit[0]);
            inDegree[prerequisit[0]]++;
        }
        //把入度为0的入队
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] res = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            Integer first = queue.poll();
            res[index] = first;
            index++;

            Set<Integer> firstAdjSet = adj[first];
            for (Integer adjItem : firstAdjSet) {
                inDegree[adjItem]--;
                if (inDegree[adjItem] == 0) {
                    queue.offer(adjItem);
                }
            }
        }

        if (index == numCourses) {
            return res;
        }
        return new int[0];
    }
}
