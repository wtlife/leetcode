package classic.tree;

import entity.TreeNode;

import java.util.Stack;

/**
 * 树的结构十分直观，而树的很多概念定义都有一个相同的特点：递归，也就是说，一棵树要满足某种性质，往往要求每个节点都必须满足。例如，在定义一棵二叉搜索树时，每个节点也都必须是一棵二叉搜索树。
 * 正因为树有这样的性质，大部分关于树的面试题都与递归有关，换句话说，面试官希望通过一道关于树的问题来考察你对于递归算法掌握的熟练程度。
 * 我们常见的树的形状有：普通二叉树、平衡二叉树、完全二叉树、二叉搜索树、四叉树（Quadtree）、多叉树（N-ary Tree）。
 * 另外还有一些特殊的树，例如红黑树（Red-Black Tree）、自平衡二叉搜索树（AVL Tree）,常用于实现数据库索引等相关知识。
*/
public class TreeOrder {

    // 假设树🌲结构如下：

/**
    前序遍历 Preorder
    Traversal(DLR)
        (1)访问根结点。
        (2)前序遍历左子树**。**
        (3)前序遍历右子树 。
 应用场景：运用最多的场合包括在树里进行搜索以及创建一棵新的树。
*/
    private void preOrder(TreeNode biTree) {
        if (biTree == null) {
            return;
        }
        System.out.print(biTree.val + "");
        preOrder(biTree.left);
        preOrder(biTree.right);
    }

    //非递归实现：
    public void preOrder2(TreeNode biTree) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (biTree != null || !stack.isEmpty()) {
            while (biTree != null) {
                System.out.print(biTree.val + "");
                stack.push(biTree);
                biTree = biTree.left;
            }
            if (!stack.isEmpty()) {
                biTree = stack.pop();
                biTree = biTree.right;
            }
        }
    }


//    中序遍历 Inorder
//    Traversal(LDR)
//（1）中序遍历左子树
//（2）访问根结点
//（3）中序遍历右子树。
//    应用场景：最常见的是二叉搜素树，由于二叉搜索树的性质就是左孩子小于根节点，根节点小于右孩子，对二叉搜索树进行中序遍历的时候，被访问到的节点大小是按顺序进行的。

    public void inOrder(TreeNode biTree) {
        if (biTree == null) {
            return;
        }
        inOrder(biTree.left);
        System.out.print(biTree.val + "");
        inOrder(biTree.right);
    }

//    非递归：
    public void inOrder2(TreeNode biTree) {
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || biTree != null) {
            while (biTree != null) {
                stack.push(biTree);
                biTree = biTree.left;
            }

            if (!stack.isEmpty()) {
                biTree = stack.pop();
                System.out.print(biTree.val + "");
                biTree = biTree.right;
            }
        }
    }


//    后序遍历 Postorder
//    Traversal(LRD)
//（1）后序遍历左子树
//（2）后序遍历右子树
//（3）访问根结点
//    应用场景：在对某个节点进行分析的时候，需要来自左子树和右子树的信息。收集信息的操作是从树的底部不断地往上进行，好比你在修剪一棵树的叶子，修剪的方法是从外面不断地往根部将叶子一片片地修剪掉。
//    递归：
    public void postOrder(TreeNode biTree) {
        if (biTree == null) {
            return;
        }
        postOrder(biTree.left);
        postOrder(biTree.right);
        System.out.print(biTree.val);
    }

//    非递归,使用两个栈，stack2用于判断是否从右子树返回的：
    public void postOrder2(TreeNode biTree) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<String> stack2 = new Stack<>();
        while (biTree != null || !stack.isEmpty()) {
            while (biTree != null) {
                stack.push(biTree);
                stack2.push("LEFT");
                biTree = biTree.left;
            }

            while (!stack.isEmpty() || "RIGHT".equals(stack2.peek())) {
                stack2.pop();
                //打印
                System.out.print(stack.pop().val);
            }

            if (!stack.empty() && "LEFT".equals(stack2.peek())) {
                stack2.pop();
                stack2.push("RIGHT");
                biTree = stack.peek().right;
            }
        }
    }
}
