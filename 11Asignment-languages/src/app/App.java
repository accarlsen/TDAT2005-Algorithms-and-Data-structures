package app;

public class App {
    public static void main(String[] args) throws Exception {
        int[] con1 = {1,3};
		int[] con2 = {1,2};
		int[] con3 = {2,3};
		int[] con4 = {3,3};
		int[][] nextConditionTable = {con1, con2, con3, con4};
		int[] acceptConditions = {2};
		char[] inputAlphabet = {'0', '1'};
		Automat automat = new Automat(acceptConditions, nextConditionTable, inputAlphabet);
		String s1 = "";
		String s2 = "010";
		String s3 = "111";
		String s4 = "001";
		
		System.out.println(automat.checkInput(s1));
		System.out.println(automat.checkInput(s2));
		System.out.println(automat.checkInput(s3));
		System.out.println(automat.checkInput(s4));
    }
}