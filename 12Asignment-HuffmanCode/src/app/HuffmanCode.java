package app;

import java.io.*;
import java.io.File;
import java.util.ArrayList;

public class HuffmanCode{

    //fields
    private String inputFileName;
    private String outputFileName;
    byte a = 11;
    byte b = 4;
    public Byte[] data = {new Byte(b), new Byte(a), new Byte(b)};
    public ArrayList<Integer> frequencyList = new ArrayList<Integer>();

    static class Node{
        public int id;
        Node parent;
        Node child0;
        Node child1;
        int frequency;
        int bit;
        public Node(int id, int frequency){
            this.id = id;
            this.frequency = frequency;
        }
    }

    //constructor
    public HuffmanCode(){
        /*
        DataInputStream innfil = new DataInputStream(new BufferedInputStream(new FileInputStream(inputFileName))); 
        DataOutputStream utfil = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(outputFileName)));
        innfil.readFully(data);
        */
    }

    //methods
    public void calcFrequency(){
        for(int i = 0; i < 256; i++){
            frequencyList.add(0);
        }

        for(int i = 0; i < data.length; i++){
            frequencyList.set(data[i].intValue(), frequencyList.get(data[i].intValue()) + 1);
        }
    }

    public void createTree(){
        //create roots
        for(int i = 0; i < frequencyList.size(); i++){
            if(frequencyList.get(i) != 0){
                new Node(i, frequencyList.get(i));
            }
        }

    }
}