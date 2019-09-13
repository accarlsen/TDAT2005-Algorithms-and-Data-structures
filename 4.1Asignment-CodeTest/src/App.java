import java.io.File;

public class App {
    public static void main(String[] args) throws Exception {
        
        CodeChecker cc = new CodeChecker();
        //String s = "import java.io.*; import java.util.*; public class CodeChecker{ //fields //constructor //methods public int check(String sRaw){ String[] s = sRaw.split(\"\"); Stack<Integer> stack = new Stack<Integer>(); for(int i = 0; i < s.length; i++){ //Add to stack if(s[i].equals(\"(\")){ stack.push(1); } else if(s[i].equals(\"[\")){ stack.push(2); } else if(s[i].equals(\"{\")){ stack.push(3); } //Reduce stack else if(s[i].equals(\")\") && stack.peek() == 1){ stack.pop(); } else if(s[i].equals(\"]\") && stack.peek() == 2){ stack.pop(); } else if(s[i].equals(\"}\") && stack.peek() == 3){ stack.pop(); } } if(stack.empty()){ return 0; } else{ return stack.peek(); } }";
        File file = new File("/AlexanderSkole/NTNU 2019Høst/Algoritmer og Datastrukturer/TDAT2005-Algorithms-and-Data-structures/4.1Asignment-CodeTest/src/file.txt");
        String s = cc.readFile(file);

        System.out.println(cc.check(s));
    }
}