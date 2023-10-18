package com.example.ordenamiento;



import java.util.Random;

class Tree
{

    // Class containing left and
    // right child of current
    // node and key value
    class Node
    {
        int key;
        Node left, right;

        public Node(int item)
        {
            key = item;
            left = right = null;
        }
    }

    // Root of BST
    Node root;

    // Constructor
    Tree()
    {
        root = null;
    }

    // This method mainly
    // calls insertRec()
    void insert(int key)
    {
        root = insertRec(root, key);
    }

    /* A recursive function to
    insert a new key in BST */
    Node insertRec(Node root, int key)
    {

        /* If the tree is empty,
        return a new node */
        if (root == null)
        {
            root = new Node(key);
            return root;
        }

        /* Otherwise, recur
        down the tree */
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        /* return the root */
        return root;
    }

    // A function to do
    // inorder traversal of BST
    void inorderRec(Node root)
    {
        if (root != null)
        {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }
    void treeins(int arr[])
    {
        for(int i = 0; i < arr.length; i++)
        {
            insert(arr[i]);
        }

    }

    public static void printArray(int[] arr, int n)
    {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");
    }

    // Driver Code
    public double treeSort(int size, int limit) {
        double miliInicio = System.currentTimeMillis();

        Tree tree = new Tree();

        int[] arreglo = new int[size];

        Random generadorAleatorio = new Random();

        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = generadorAleatorio.nextInt(limit);  // Asigna un número aleatorio al elemento del arreglo.
        }

        System.out.println("Algoritmo arbol \n");

        System.out.println("Arreglo sin ordenar");
        printArray(arreglo, arreglo.length);


        tree.treeins(arreglo);
        System.out.println("Arreglo ordenado");
        tree.inorderRec(tree.root);

        double miliFin = System.currentTimeMillis();


        double segundos = (miliFin - miliInicio) / 1000;
        double minutos = segundos / 60;
        double horas = minutos / 60;

        System.out.println("\n");
        System.out.println("T(n) en segundos: " + segundos);
        System.out.println("T(n) en minutos: " + minutos);
        System.out.println("T(n) en horas: " + horas);

        return miliFin - miliInicio;
    }
}

