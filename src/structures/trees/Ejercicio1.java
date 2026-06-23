package structures.trees;

import java.util.Stack;

import structures.node.Node;

public class Ejercicio1 {
    private Stack<Node<Integer>> pila = new Stack<>();
    public void insert(int[] numeros) {
        BinaryTree<Integer> arbolBinario = new BinaryTree<>();
        for (int i = 0; i < numeros.length; i++) {
            arbolBinario.add(numeros[i]);
        }
        inOrder(arbolBinario);
        int alturaTotal = getHeight(arbolBinario.getRoot());
        while (!pila.isEmpty()) {
            Node<Integer> nodoImprimir = pila.pop();
            int espacios = alturaTotal - getHeight(nodoImprimir);
            for (int i = 0; i < espacios; i++) {
                System.out.print("\t");
            }
            System.out.println(nodoImprimir);
        }
    }
    public void inOrder(BinaryTree<Integer> arbolBinario) {
        inOrderRecursivo(arbolBinario.getRoot());
    }
    public void inOrderRecursivo(Node<Integer> actual) {
        if (actual == null) {
            return;
        }
        inOrderRecursivo(actual.getLeft());
        pila.add(actual);
        inOrderRecursivo(actual.getRight());
    }
    public int getHeight(Node<Integer> actual) {
        return getHeightRecursivo((actual));
    }
    private int getHeightRecursivo(Node<Integer> actual) {
        if (actual == null) {
            return 0;
        }
        int masAlto = Math.max(getHeightRecursivo(actual.getLeft()), 
        getHeightRecursivo(actual.getRight()));
        return masAlto + 1;
    }
}
