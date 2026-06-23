package structures.trees;

import structures.node.Node;

public class BinaryTree<T extends Comparable<T>> {
    private Node<T> root;
    private int peso;

    public BinaryTree() {
        this.root = null;
        peso = 0;
    }

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public void add(T value) {
        Node<T> node = new Node<T>(value);
        root = addRecursivo(root, node);
    }

    public Node<T> addRecursivo(Node<T> nodeActual, Node<T> nodeInsertar) {
        if (nodeActual == null) {
            peso += 1;
            return nodeInsertar;
        }
        if (nodeActual.getValue().compareTo(nodeInsertar.getValue()) < 0) {
            nodeActual.setRight(addRecursivo(nodeActual.getRight(), nodeInsertar));
        } else {
            nodeActual.setLeft(addRecursivo(nodeActual.getLeft(), nodeInsertar));
        }

        return nodeActual;

    }

    public void preOrden() {
        preOrderRecursivo(root);
    }

    public void posOrder() {
        posOrderRecursivo(root);
    }

    public void inOrder() {
        inOrderRecursivo(root);
    }

    private void preOrderRecursivo(Node<T> actual) {
        if (actual == null) {
            return;
        }
        System.out.println(actual);
        preOrderRecursivo(actual.getLeft());
        preOrderRecursivo(actual.getRight());
    }

    private void posOrderRecursivo(Node<T> actual) {
        if (actual == null) {
            return;
        }
        preOrderRecursivo(actual.getLeft());
        preOrderRecursivo(actual.getRight());
        System.out.println(actual);
    }

    private void inOrderRecursivo(Node<T> actual) {
        if (actual == null) {
            return;
        }
        preOrderRecursivo(actual.getLeft());
        System.out.println(actual);
        preOrderRecursivo(actual.getRight());

    }

    public int getHeight() {
        return getHeightRecursivo(root);
    }

    public int getWeight() {
        return getPeso();
    }

    private int getHeightRecursivo(Node<T> actual) {
        if (actual == null) {
            return 0;
        }
        int masAlto = Math.max(getHeightRecursivo(actual.getLeft()), getHeightRecursivo(actual.getRight()));
        return masAlto + 1;
    }

    // private int getWeightRecursivo2(Node<T> actual) {
    // return actual != null ? getWeightRecursivo2(actual.getLeft()) +
    // getWeightRecursivo2(actual.getRight())+1
    // : null;
    // }

}
