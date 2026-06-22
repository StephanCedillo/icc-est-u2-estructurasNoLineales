import java.util.function.IntBinaryOperator;

import models.Persona;
import structures.node.Node;

import structures.trees.*;


public class App {
    public static void main(String[] args) throws Exception {
        //runIntTree();
        //System.out.println();
       //runBinaryTree();
        runEjercicios();
        }

    private static void runEjercicios() {
        Ejercicio1 ejercicio1 = new Ejercicio1();
        Ejercicio2 ejercicio2 = new Ejercicio2();
        Ejercicio3 ejercicio3 = new Ejercicio3();
        int[] numeros = new int[]{5,3,7,2,4,6,8};
        System.out.println("====EJERCICIO 1====");
        ejercicio1.insert(numeros);
        System.out.println("====EJERCICIO 2 ====");
         int[] numeros2 = new int[]{4,2,7,1,3,6,9};
         ejercicio1.insert(numeros);
         System.out.println();
        ejercicio2.invertTree(numeros2);
        System.out.println("====EJERCICIO 3 ====");

        ejercicio3.insert(numeros2);
    }

    private static void runBinaryTree() {
       // BinaryTree<String> arbolStrings = new BinaryTree<>();
        BinaryTree<Persona> arbolPersona = new BinaryTree<>();
        arbolPersona.add(new Persona("Pablo", 30));
        arbolPersona.add(new Persona("Ana", 25));
        arbolPersona.add(new Persona("Maria", 28));
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
