package app;

import java.io.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class HuffmanCode {

    // fields
    private String inputFileName;
    private String outputFileName;
    byte a = 1;
    byte b = 2;
    byte c = 3;
    byte d = 4;
    byte e = 5;
    byte f = 6;
    byte g = 7;
    public Byte[] data = { new Byte(b), new Byte(a), new Byte(b), new Byte(c), new Byte(a), new Byte(d),
                            new Byte(e), new Byte(e), new Byte(e), new Byte(e), new Byte(f), new Byte(f),
                            new Byte(f), new Byte(g) };
    public ArrayList<Integer> frequencyList = new ArrayList<Integer>();
    public ArrayList<Node> symbolTree = new ArrayList<Node>();

    static class Node {
        public int id;
        Node parent;
        Node child0;
        Node child1;
        int frequency;
        ArrayList<Integer> bit = new ArrayList<Integer>();

        public Node(int id, int frequency) {
            this.id = id;
            this.frequency = frequency;
        }
    }

    // constructor
    public HuffmanCode() {
        /*
         * DataInputStream innfil = new DataInputStream(new BufferedInputStream(new
         * FileInputStream(inputFileName))); DataOutputStream utfil = new
         * DataOutputStream(new BufferedOutputStream(new
         * FileOutputStream(outputFileName))); innfil.readFully(data);
         */
    }

    // methods
    public void calcFrequency() {
        for (int i = 0; i < 256; i++) {
            frequencyList.add(0);
        }

        for (int i = 0; i < data.length; i++) {
            frequencyList.set(data[i].intValue(), frequencyList.get(data[i].intValue()) + 1);
        }
    }

    public void createTree() {
        ArrayList<Node> rootTree = new ArrayList<Node>();
        // create bottom nodes
        for (int i = 0; i < frequencyList.size(); i++) {
            if (frequencyList.get(i) != 0) {
                rootTree.add(new Node(i, frequencyList.get(i)));
                symbolTree.add(new Node(i, frequencyList.get(i)));
            }
        }

        // create tree-structure
        symbolTree = bubbleSort(symbolTree);

        ArrayList<Node> tempTree = new ArrayList<Node>();
        for(int i = 0; i < symbolTree.size(); i++){
            tempTree.add(i, symbolTree.get(i));
        }

        int numNonRootNodes = 0;

        while(tempTree.size() > 1){
            Node a = tempTree.get(0);
            tempTree.remove(0);
            Node b = tempTree.get(0);
            tempTree.remove(0); 
            
            if(a.bit.isEmpty()){ a.bit.add(0); }
            else{ a.bit.add(0, 0); }

            if(b.bit.isEmpty()){ b.bit.add(1); }
            else{ b.bit.add(0, 1); }

            numNonRootNodes++;
            Node parent = new Node(-numNonRootNodes, a.frequency + b.frequency);
            parent.child0 = a;          parent.child1 = b;
            a.parent = parent;          b.parent = parent;

            symbolTree.add(parent);    
            tempTree.add(parent);        

            symbolTree = bubbleSort(symbolTree);     tempTree = bubbleSort(tempTree);
            
            //index++;
        }
        System.out.println("done");

        rootTree = bubbleSort(rootTree);
        for(int i = 0; i < rootTree.size(); i++){
            rootTree.get(i).bit = calcBit(rootTree.get(i));
        }

        for(int i = 0; i < rootTree.size(); i++){
            System.out.println(nodeToString(rootTree.get(i)));
        }

    }

    // Support methods
    public ArrayList<Node> bubbleSort(ArrayList<Node> arr) {
        int length = arr.size();
        for (int i = 0; i < length - 1; i++){
            for (int u = 0; u < length - i - 1; u++){
                if (arr.get(u).frequency > arr.get(u+1).frequency) {
                    // swap arr[u+1] and arr[i]
                    Node temp = arr.get(u+1);
                    arr.set(u+1, arr.get(u));
                    arr.set(u, temp);
                }
            }
        }
        return arr;
    }

    public String nodeToString(Node node){
        String s = "Id: " + node.id + " | ";
        s += "Frequency : ";
        s += node.frequency;
        s += " | bit: ";
        for(int i = 0; i < node.bit.size(); i++){
            s += node.bit.get(i);
        }
        return s;
    }

    public ArrayList<Integer> calcBit(Node node){
        ArrayList<Integer> bit = new ArrayList<Integer>();
        ArrayList<Integer> bitParent = new ArrayList<Integer>();
        for(int i = 0; i < node.bit.size(); i++){
            bit.add(0, node.bit.get(i));
        }
        if(node.parent != null){
            bitParent = calcBit(node.parent);
            for(int i = 0; i < bitParent.size(); i++){
                bit.add(0, bitParent.get(i));
            }
        }
        return bit;
    }
}