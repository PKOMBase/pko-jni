package com.tree.redblack;

public class RedBlackTree<K extends Comparable<K>, V> {

    private Node<K, V> root;

    public RedBlackTree(Node<K, V> root) {
        super();
        this.root = root;
    }

    static enum EnumRedBlack {
        Red, Black;
    }

    static class Node<K, V> {
        private Node<K, V> left;
        private Node<K, V> right;
        private K key;
        private V value;
        private EnumRedBlack color;

        public Node<K, V> getLeft() {
            return left;
        }

        public void setLeft(Node<K, V> left) {
            this.left = left;
        }

        public Node<K, V> getRight() {
            return right;
        }

        public void setRight(Node<K, V> right) {
            this.right = right;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public EnumRedBlack getColor() {
            return color;
        }

        public void setColor(EnumRedBlack color) {
            this.color = color;
        }

    }

    public V get(K key) {
        return get(root, key);
    }

    private V get(Node<K, V> node, K key) {
        return null;
    }

    public void put(K key, V value) {
        put(root, key, value);
    }

    private Node<K, V> put(Node<K, V> node, K key, V value) {
        return null;
    }

    private Node<K, V> RotateLeft(Node<K, V> node) {
        Node<K, V> result = node.right;
        result.setColor(node.color);
        node.setColor(EnumRedBlack.Red);

        node.right = result.left;
        result.left = node;
        return result;
    }

    private Node<K, V> RotateRight(Node<K, V> node) {
        Node<K, V> result = node.left;
        result.setColor(node.color);
        node.setColor(EnumRedBlack.Red);

        node.left = result.right;
        result.right = node;
        return result;
    }

    private Node<K, V> FilpColor(Node<K, V> node) {
        if (node.left.color != node.right.color) {
            return node;
        }
        EnumRedBlack nodeColor = node.left.color;
        node.right.setColor(node.color);
        node.left.setColor(node.color);
        node.setColor(nodeColor);
        return node;
    }

    private boolean isRed(Node<K, V> node) {
        if (null == node) {
            return false;
        }
        return EnumRedBlack.Red == node.getColor() ? true : false;
    }

}
