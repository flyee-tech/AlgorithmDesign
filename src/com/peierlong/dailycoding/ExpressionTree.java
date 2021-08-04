package com.peierlong.dailycoding;

/**
 * #955 [Easy] Expression Tree
 *
 * @author peiel
 * @version V1.0
 * @date 2021/8/4
 */
public class ExpressionTree {

    public static class Node {
        private Node left;
        private Node right;
        private String item;

        public Node(String item) {
            this.item = item;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public String getItem() {
            return item;
        }

        public void setItem(String item) {
            this.item = item;
        }

        public boolean hasLeft() {
            return left != null;
        }

        public boolean hasRight() {
            return right != null;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.item).append('\n');
            if (this.hasLeft()) {
                sb.append(this.getLeft().toString());
            }
            if (this.hasRight()) {
                sb.append(this.getRight().toString());
            }
            return sb.toString();
        }

    }

    public static void main(String[] args) throws Exception {
        test1();
        System.out.println("--------------------------");
        test2();
    }

    public static void test1() throws Exception {
        Node root = new Node("*");
        Node rootLeft = new Node("+");
        Node rootRight = new Node("+");
        Node left1 = new Node("3");
        Node right1 = new Node("2");
        Node left2 = new Node("4");
        Node right2 = new Node("5");

        root.setLeft(rootLeft);
        root.setRight(rootRight);
        rootLeft.setLeft(left1);
        rootLeft.setRight(right1);
        rootRight.setLeft(left2);
        rootRight.setRight(right2);

        System.out.println(root);

        System.out.println(solove(root));
    }

    public static void test2() throws Exception {
        Node root = new Node("+");
        root.setLeft(new Node("3"));
        Node rootRight = new Node("*");
        root.setRight(rootRight);

        rootRight.setRight(new Node("2"));
        Node left = new Node("+");
        rootRight.setLeft(left);
        left.setLeft(new Node("5"));
        left.setRight(new Node("9"));

        System.out.println(root);
        System.out.println(solove(root));
    }

    public static int solove(Node node) throws Exception {
        if (isOperator(node)) {
            return opration(solove(node.getLeft()), solove(node.getRight()), node.getItem());
        }
        return Integer.parseInt(node.getItem());
    }

    public static int opration(int left, int right, String item) throws Exception {
        if (item.equals("+")) {
            return left + right;
        }
        if (item.equals("-")) {
            return left - right;
        }
        if (item.equals("*")) {
            return left * right;
        }
        if (item.equals("/")) {
            return left / right;
        }
        throw new Exception("");
    }

    public static boolean isOperator(Node node) {
        return node.getItem().equals("+")
                || node.getItem().equals("-")
                || node.getItem().equals("*")
                || node.getItem().equals("/");
    }

}
