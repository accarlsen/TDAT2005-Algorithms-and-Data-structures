package app;

import java.io.*;
import java.util.ArrayList;

public class HuffmanCode {

    // fields
    public File fileInput;
    public File fileOutput;
    byte a = 1;
    byte b = 2;
    byte c = 3;
    byte d = 4;
    byte e = 5;
    byte f = 6;
    byte g = 7;
    public byte[] data;
    public ArrayList<Integer> frequencyList = new ArrayList<Integer>();
    public ArrayList<Node> symbolTree = new ArrayList<Node>();
    public ArrayList<String> Tree = new ArrayList<String>();

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
    public HuffmanCode(File fileInput, File fileOutput) {
        this.fileInput = fileInput;
        this.fileOutput = fileOutput;
        data = readFromFile(fileInput).getBytes();

        System.out.println(data.length);
    }

    // methods
    public void calcFrequency() {
        for (int i = 0; i < 256; i++) {
            frequencyList.add(0);
        }
        System.out.println(data[0]);
        for (int i = 0; i < data.length; i++) {
            frequencyList.set((int) (data[i] + 128), frequencyList.get((int) data[i] + 128) + 1); // Add toInt to fix
                                                                                                  // all
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
        System.out.println(symbolTree.size());

        ArrayList<Node> tempTree = new ArrayList<Node>();
        for (int i = 0; i < symbolTree.size(); i++) {
            tempTree.add(i, symbolTree.get(i));
        }

        int numNonRootNodes = 0;

        while (tempTree.size() > 1) {
            Node a = tempTree.get(0);
            tempTree.remove(0);
            Node b = tempTree.get(0);
            tempTree.remove(0);

            if (a.bit.isEmpty()) {
                a.bit.add(0);
            } else {
                a.bit.add(0, 0);
            }

            if (b.bit.isEmpty()) {
                b.bit.add(1);
            } else {
                b.bit.add(0, 1);
            }

            numNonRootNodes++;
            Node parent = new Node(-numNonRootNodes, a.frequency + b.frequency);
            parent.child0 = a;
            parent.child1 = b;
            a.parent = parent;
            b.parent = parent;

            symbolTree.add(parent);
            tempTree.add(parent);

            symbolTree = bubbleSort(symbolTree);
            tempTree = bubbleSort(tempTree);

            // index++;
        }
        System.out.println("Tree created");

        for (int i = 0; i < symbolTree.size(); i++) {
            if (symbolTree.get(i).id >= 0) {
                symbolTree.get(i).bit = calcBit(symbolTree.get(i));
                System.out.println(nodeToString(symbolTree.get(i)));
            }
        }

        createFrequencyTable();
        for (int i = 0; i < Tree.size(); i++) {
        }
        System.out.println("Frequency table made");
        if(writeToFile(fileOutput)){
            System.out.println("File compressed successfully");
        }
        else{
            System.out.println("Compressing failed");
        }
    }

    // Support methods
    public ArrayList<Integer> calcBit(Node node) {
        ArrayList<Integer> bit = new ArrayList<Integer>();
        if (node.parent != null) {
            if (node.parent.child0.id == node.id) {
                bit.add(0, 0);
            } else if (node.parent.child1.id == node.id) {
                bit.add(0, 1);
            }
            bit.addAll(0, calcBit(node.parent));
        }
        return bit;
    }

    public String nodeToString(Node node) { // For testing
        String s = "Id: " + node.id + " | ";
        s += "Frequency: " + node.frequency + " | bit: ";
        for (int i = 0; i < node.bit.size(); i++) {
            s += node.bit.get(i);
        }
        return s;
    }

    public void createFrequencyTable() {
        for (int i = 0; i < frequencyList.size(); i++) {
            Tree.add("2");
        }
        for (int i = 0; i < frequencyList.size(); i++) {
            for (int u = 0; u < symbolTree.size(); u++) {
                if (symbolTree.get(u).id == i) {
                    Tree.add(i, bitToString(symbolTree.get(u).bit));
                }
            }
        }
    }

    public String bitToString(ArrayList<Integer> bit) {
        String s = "";
        for (int i = 0; i < bit.size(); i++) {
            s += Integer.toString(bit.get(i));
        }
        return s;
    }

    public ArrayList<Node> bubbleSort(ArrayList<Node> arr) {
        int length = arr.size();
        for (int i = 0; i < length - 1; i++) {
            for (int u = 0; u < length - i - 1; u++) {
                if (arr.get(u).frequency > arr.get(u + 1).frequency) {
                    // swap arr[u+1] and arr[i]
                    Node temp = arr.get(u + 1);
                    arr.set(u + 1, arr.get(u));
                    arr.set(u, temp);
                }
            }
        }
        return arr;
    }

    public String readFromFile(File file) {
        try {
            FileReader reader = new FileReader(file);
            BufferedReader buffer = new BufferedReader(reader);
            ArrayList<String> lines = new ArrayList<String>();
            String line = "";

            while ((line = buffer.readLine()) != null) {
                lines.add(line);
            }
            String input = "";

            for (int i = 0; i < lines.size(); i++) {
                input += lines.get(i);
            }
            buffer.close();
            return input;
        } catch (FileNotFoundException fnfe) {
            System.out.println("fnfe exception");
        } catch (IOException ioe) {
            System.out.println("ioe exception");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean writeToFile(File file) {
        ArrayList<String> translatedData = new ArrayList<String>();
        // <Character> outputData = new ArrayList<Character>();
        for (int i = 0; i < data.length; i++) {
            translatedData.add(Tree.get(data[i] + 128));
        }

        ArrayList<String> s = new ArrayList<String>();
        for (int i = 0; i < translatedData.size(); i++) {
            String[] translatedDataSplit = translatedData.get(i).split("");
            for (int u = 0; u < translatedDataSplit.length; u++) {
                s.add(translatedDataSplit[u]);
            }
        }

        int index = 0;
        
        try (OutputStream os = new FileOutputStream(fileInput.getName() + ".carlzip")) {
            byte a = 10;
            for(int i = 0; i < frequencyList.size(); i++){
                os.write(frequencyList.get(i));
            }
            os.write(a);
            for(int i = 0; i < Tree.size(); i++){
                os.write(Tree.get(i).getBytes());
                os.write((byte) 3);
            }
            os.write(a);
            
            while (s.size() > 0) {

                byte b = 0;

                for (int i = 0; i < 8; i++) {
                    if (s.size() > 0) {
                        if (s.get(0).equals("0")) {
                            //System.out.println(0);
                            b = (byte) (b & ~(1 << i));
                            s.remove(0);
                        } else if (s.get(0).equals("1")) {
                            //System.out.println(1);
                            b = (byte) (b | (1 << i));
                            s.remove(0);
                        } else {
                            s.remove(0);
                        }
                    }
                }
                os.write(b);
                index++;

            }

            os.close();

        }

        catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
}