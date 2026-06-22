package structures.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import structures.node.Node;

public class Ejercicio3 {
    private  Queue<Node> pila  = new ArrayDeque<>();
    private  Node<Integer>[] numerosLista;
    public void insert(int[] numeros){

        //CREAR EL ARBOL DE ENTEROS

        // INSERTAR CADA NUMERO
        // IMPRIMIR EL ARBOL
        BinaryTree<Integer> arbolBinario = new BinaryTree<>();
        
        for (int i = 0; i < numeros.length; i++) {
            arbolBinario.add(numeros[i]);
        }
        numerosLista = new Node[arbolBinario.getPeso()];

        
        inOrder(arbolBinario);
        int alturaTotal = getHeight(arbolBinario.getRoot());
        int i = 0;
        while (!pila.isEmpty()) {
            numerosLista[i] = pila.poll();
             i+=1;
        }

        List<Node> nivel1 = new ArrayList<Node>();
        List<Node> nivel2 = new ArrayList<Node>();
        List<Node> nivel3 = new ArrayList<Node>();
        for (i = 0; i < numerosLista.length; i++) {
            if (getHeight(numerosLista[i])- alturaTotal == 0) {
                nivel1.add(numerosLista[i]);
            }else if (alturaTotal - getHeight(numerosLista[i]) == 1) {
                nivel2.add(numerosLista[i]);               
            } else if (alturaTotal- getHeight(numerosLista[i]) == 2) {
                nivel3.add(numerosLista[i]);
            }
        }

        
        System.out.println(nivel1);
        System.out.println(nivel2);
        System.out.println(nivel3);
    }

     public void  inOrder(BinaryTree<Integer> arbolBinario) {
         inOrderRecursivo(arbolBinario.getRoot());
    }
    public void inOrderRecursivo(Node<Integer> actual){
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
