import java.io.*;
import java.util.*; 

public class CodeChecker{

    //fields

    //constructor

    //methods
    public int check(String sRaw){
        String[] s = sRaw.split("");
        Stack<Integer> stack = new Stack<Integer>(); 

        for(int i = 0; i < s.length; i++){
            //Add to stack
            if(s[i].equals("(")){
                stack.push(1);
            }
            else if(s[i].equals("[")){
                stack.push(2);
            }
            else if(s[i].equals("{")){
                stack.push(3);
            }
            //Reduce stack
            else if(s[i].equals(")")){
                if(!stack.empty()){ if(stack.peek() == 1){  stack.pop();}}
                else{ return 1;}
            }
            else if(s[i].equals("]")){
                if(!stack.empty()){ if(stack.peek() == 2){  stack.pop();}}
                else{ return 2;}
            }
            else if(s[i].equals("}")){
                if(!stack.empty()){ if(stack.peek() == 3){  stack.pop();}}
                else{ return 3;}
            }
        }
        if(stack.empty()){
            return 0;
        }
        else{
            return stack.peek();
        }
    }

    public String readFile(File file) throws IOException {
        Scanner scanner = new Scanner( file );
        String text = scanner.useDelimiter("\\A").next();
        char a = '"';
        String ab = Character.toString(a);
        text = text.replaceAll(ab, "\"");
        scanner.close();
        return text;
    }
}