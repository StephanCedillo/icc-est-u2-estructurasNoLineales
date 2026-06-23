package structures.trees;

import java.util.ArrayDeque;
import java.util.Queue;

import structures.node.Node;

public class Ejercicio2 {
    private Queue<Node<Integer>> cola = new ArrayDeque<>();

    public void invertTree(BinaryTree<Integer> arbolBinario) {

        inOrder(arbolBinario);
        int alturaTotal = getHeight(arbolBinario.getRoot());
        while (!cola.isEmpty()) {
            Node<Integer> nodoImprimir = cola.poll();
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
        cola.add(actual);
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
