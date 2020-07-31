package code.tree;

import entity.TreeNode;
import sun.plugin.javascript.navig.Link;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Desc 297. Codec
 * @date 2020/7/29
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root==null){
            return "[]";
        }
        LinkedList<String> list= new LinkedList<>();
        helpSerialize(root,list);
        String res= "["+String.join(",",list)+"]";
        return res;
    }


    private void helpSerialize(TreeNode root, LinkedList<String> list) {
        if (root==null){
            list.addLast("null");
            return;
        }
        list.addLast(String.valueOf(root.val));
        helpSerialize(root.left,list);
        helpSerialize(root.right,list);

    }

//     Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length()<=2){
            return null;
        }
        String tmp = data.substring(1,data.length()-1);
        String[] tmp2= tmp.split(",");
        List<String> list1 = Arrays.asList(tmp2);
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addAll(list1);
        TreeNode root = helpDeserialize(linkedList);
        return root;
    }

    private TreeNode helpDeserialize(LinkedList<String> list) {
        if (list.size()<=0) {
            return null;
        }
        String first = list.removeFirst();
        if ("null".equals(first)){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(first));
        root.left = helpDeserialize(list);
        root.right = helpDeserialize(list);
        return root;
    }


}
