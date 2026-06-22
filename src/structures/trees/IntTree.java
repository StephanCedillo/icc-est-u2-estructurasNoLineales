package structures.trees;

//Clase de arbol solo de enteros
import structures.node.Node;

public class IntTree {
    private Node<Integer> root;
    private int peso;

    public IntTree() {
        this.root = null;
        peso = 0;
    }

    public Node<Integer> getRoot() {
        return root;
    }

    public void setRoot(Integer value) {
        Node<Integer> node = new Node<Integer>(value);
        this.root = node;
    }

    public void setRoot(Node<Integer> root) {

        this.root = root;
    }
     public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
    

    public void add(Integer value) {
        Node<Integer> node = new Node<Integer>(value);
        root = addRecursivo(root, node);
    }

    public Node<Integer> addRecursivo(Node<Integer> nodeActual, Node<Integer> nodeInsertar) {
        if (nodeActual == null) {
            peso +=1;
            return nodeInsertar;
        }
        if (nodeActual.getValue() < nodeInsertar.getValue()) {
            nodeActual.setRight(addRecursivo(nodeActual.getRight(), nodeInsertar));
        } else {
            nodeActual.setLeft(addRecursivo(nodeActual.getLeft(), nodeInsertar));
        }

       
        return nodeActual;

    }

    public void preOrden() {
        preOrderRecursivo(root);
    }

    private void preOrderRecursivo(Node<Integer> actual) {
        if (actual == null) {
            return;
        }
        System.out.println(actual);
        preOrderRecursivo(actual.getLeft());
        preOrderRecursivo(actual.getRight());
    }

    public void posOrder() {

        posOrderRecursivo(root);
    }

    private void posOrderRecursivo(Node<Integer> actual) {
        if (actual == null) {
            return;
        }
        preOrderRecursivo(actual.getLeft());
        preOrderRecursivo(actual.getRight());
        System.out.println(actual);
    }

    public void inOrder() {

        inOrderRecursivo(root);
    }

    private void inOrderRecursivo(Node<Integer> actual) {

        if (actual == null) {
            return;
        }
        inOrderRecursivo(actual.getLeft());
        System.out.println(actual);
        inOrderRecursivo(actual.getRight());

    }

    public int getHeight() {
        return getHeightRecursivo(root);
    }
    public int getWeight(){
        return getPeso();
    }

    private int getHeightRecursivo(Node<Integer> actual) {
        if (actual == null) {
            return 0;
        }
        int masAlto = Math.max(getHeightRecursivo(actual.getLeft()), getHeightRecursivo(actual.getRight()));
        return masAlto + 1;
    }

    // private int getWeightRecursivo2(Node<Integer> actual) {
    //     return actual != null ? getWeightRecursivo2(actual.getLeft()) +
    //             getWeightRecursivo2(actual.getRight())+1
    //             : null;
    // }

   

}
