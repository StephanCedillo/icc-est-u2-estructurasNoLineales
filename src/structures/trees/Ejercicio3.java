package structures.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import structures.node.Node;

public class Ejercicio3 {
    private Queue<Node<Integer>> pila = new ArrayDeque<>();
    private Node<Integer>[] numerosLista;

    public List<List<Node<Integer>>> listLevels(BinaryTree<Integer> arbolBinario) {
        numerosLista = new Node[arbolBinario.getPeso()];
        inOrder(arbolBinario);
        int i = 0;
        while (!pila.isEmpty()) {
            numerosLista[i] = pila.poll();
            i += 1;
        }
        int alturaTotal = getHeight(arbolBinario.getRoot());
        List<List<Node<Integer>>> listaNodos = new ArrayList<>();
        for (i = 0; i < alturaTotal; i++) {

            List<Node<Integer>> nivelAux = new ArrayList<Node<Integer>>();
            for (int j = 0; j < numerosLista.length; j++) {
                if (alturaTotal - getHeight(numerosLista[j]) == i) {
                    nivelAux.add(numerosLista[j]);
                }
            }
            listaNodos.add(nivelAux);
        }
        imprimirListaNodos(listaNodos);
        return listaNodos;

    }

    private void imprimirListaNodos(List<List<Node<Integer>>> listaNodos) {
        for (int i = 0; i < listaNodos.size(); i++) {
            int nodoActual = listaNodos.get(i).size();
            for (int j = 0; j < listaNodos.get(i).size(); j++) {

                System.out.print(nodoActual == j + 1 ? listaNodos.get(i).get(j) : 
                listaNodos.get(i).get(j) + " ->");
            }
            System.out.println();
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
        int masAlto = Math.max(getHeightRecursivo(actual.getLeft()), getHeightRecursivo(actual.getRight()));
        return masAlto + 1;
    }
}
