import java.util.function.IntBinaryOperator;

import models.Persona;
import structures.node.Node;
import structures.trees.BinaryTree;
import structures.trees.IntTree;

public class App {
    public static void main(String[] args) throws Exception {
        runIntTree();
        System.out.println();
        runBinaryTree();
        }

    private static void runBinaryTree() {
       // BinaryTree<String> arbolStrings = new BinaryTree<>();
        BinaryTree<Persona> arbolPersona = new BinaryTree<>();
        arbolPersona.add(new Persona("Pablo", 30));
arbolPersona.add(new Persona("Maria", 28));
        arbolPersona.add(new Persona("Ana", 25));
        
        arbolPersona.add(new Persona("Luis", 35));
        
       // arbolPersona.add(new Persona("Pablo", 30));
        arbolPersona.inOrder();
    }

    private static void runIntTree() {
        IntTree arbolNumero = new IntTree();

        arbolNumero.add(50);
        arbolNumero.add(10);
        arbolNumero.add(30);
        arbolNumero.add(60);
        arbolNumero.add(55);
        arbolNumero.add(70);

        System.out.println("=======PRE ORDER=======");
        arbolNumero.preOrden();
        System.out.println("=======POS ORDER=======");
        arbolNumero.posOrder();
        System.out.println("=======IN ORDER=======");
        arbolNumero.inOrder();

        System.out.println("ALTURA : " + arbolNumero.getHeight());
        System.out.println("PESO : " + arbolNumero.getWeight());

    }

}
