import java.util.ArrayList;
import java.util.List;
import java.util.Set;


import collections.*;
import collections.maps.Maps;
import collections.set.Sets;
import models.Contacto;
import models.Persona;
import structures.node.Node;

import structures.trees.*;

public class App {
    public static void main(String[] args) throws Exception {
        // runIntTree();
        System.out.println();
        // runBinaryTree();
        // runEjercicios();
        // runSets();
        runMaps();
    }

    private static void runMaps() {
       Maps maps = new Maps();
       System.out.println(maps.construirHashMap());
       System.out.println("==========");
       maps.construirTreeMap();
       
       List<Contacto> lista = new ArrayList<>();

       lista.add (new Contacto("Juan", "Perez", "123456789"));
       lista.add (new Contacto("Ana", "Gomez", "987654321"));
       lista.add (new Contacto("Pedro", "Lopez", "456789123"));
       lista.add (new Contacto("Maria", "Rodriguez", "789123456"));
       lista.add (new Contacto("Juan", "Perez", "123456789")); // Duplicado, no se agregará
       lista.add (new Contacto("Juan", "Lopez", "123456789"));

      System.out.println( maps.ordenarUnicos(lista));
       
    }

    private static void runSets() {
        Sets sets = new Sets();

        // Implimentacion

        System.out.println("=====HASH CODE======");
        Set<String> hashset = sets.construirHashSet();

        System.out.println(hashset);

        System.out.println("Size = " + hashset.size());
        System.out.println("Contiene la " + "F" + " = " + (hashset.contains("F") ? "Si" : "No"));
        System.out.println("=====LINKEDHASH CODE======");

         Set<String> linkedHashSet = sets.construirLinkedHashSet();

        System.out.println(linkedHashSet);

        System.out.println("Size = " + linkedHashSet.size());
        System.out.println("Contiene la " + "F" + " = " + (linkedHashSet.contains("F") ? "Si" : "No"));

        System.out.println("=====TREESET CODE=====");

         Set<String> treeSet = sets.construirTreeSet();

        System.out.println(treeSet);

        System.out.println("Size = " + treeSet.size());
        System.out.println("Contiene la " + "F" + " = " + (treeSet.contains("F") ? "Si" : "No"));

        System.out.println("=====HASHCONTACTO CODE=====");

        Set<Contacto> contactoSet = sets.contactoSet();

        System.out.println(contactoSet);

        System.out.println("Size = " + contactoSet.size());
        System.out.println("Contiene la " + (new Contacto("Maria", "Rodriguez", "789123456")) + " = " + (contactoSet.contains(new Contacto("Maria", "Rodriguez", "789123456")) ? "Si" : "No"));

         System.out.println("=====TREECONTACTOSET CODE=====");

        Set<Contacto> treeContactoSet = sets.construirTreeSetContacto();

        System.out.println(treeContactoSet);

        System.out.println("Size = " + treeContactoSet.size());
        //System.out.println("Contiene la " + "F" + " = " + (treeContactoSet.contains("F") ? "Si" : "No"));
    }

    private static void runEjercicios() {
        Ejercicio1 ejercicio1 = new Ejercicio1();
        Ejercicio2 ejercicio2 = new Ejercicio2();
        Ejercicio3 ejercicio3 = new Ejercicio3();
        Ejercicio4 ejercicio4 = new Ejercicio4();
        int[] numeros = new int[] { 5, 3, 7, 2, 4, 6, 8 };

        int[] numeros2 = new int[] { 4, 2, 7, 1, 3, 6, 9 };
        BinaryTree<Integer> arbolBinario = new BinaryTree<>();

        for (int i = 0; i < numeros.length; i++) {
            arbolBinario.add(numeros2[i]);
        }
        System.out.println("====EJERCICIO 1====");
        ejercicio1.insert(numeros);
        System.out.println("====EJERCICIO 2 ====");

        System.out.println("Arbol original : ");
        ejercicio1.insert(numeros2);
        System.out.println();
        System.out.println("Arbol Invertido : ");
        ejercicio2.invertTree(arbolBinario);

        System.out.println("====EJERCICIO 3 ====");
        ejercicio3.listLevels(arbolBinario);

        int[] numeros3 = new int[] { 6, 4, 7, 3, 5, 2 };
        BinaryTree<Integer> arbolBinario2 = new BinaryTree<>();

        for (int i = 0; i < numeros3.length; i++) {
            arbolBinario2.add(numeros3[i]);
        }
        System.out.println("====EJERCICIO 4 ====");
        System.out.println("Profundidad Maxima : " + ejercicio4.maxDepth(arbolBinario2.getRoot()));

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
