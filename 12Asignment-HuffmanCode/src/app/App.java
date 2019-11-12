package app;

public class App {
    public static void main(String[] args) throws Exception {
        HuffmanCode hf = new HuffmanCode();

        hf.calcFrequency();
        for(int i = 0; i < hf.frequencyList.size(); i++){
            System.out.println(hf.frequencyList.get(i));
        }
        hf.createTree();
    }
}