package app;

import java.io.File;

public class App {
    public static void main(String[] args) throws Exception {
        File test1 = new File("test1");
        File test1Komprimert = new File("test1Komprimert.txt");
        HuffmanCode hf = new HuffmanCode(test1, test1Komprimert);

        hf.calcFrequency();
        hf.createTree();
    }
}