package app;

public class Automat{
    int condition;
    int[] acceptConditions;
    int[][] nextConditionTable;
    char[] inputAlphabet;

    public Automat(int[] acceptConditions, int[][] nextConditionTable, char[] inputAlphabet){
        this.acceptConditions = acceptConditions;
        this.nextConditionTable = nextConditionTable;
        this.inputAlphabet = inputAlphabet;
    }

    public void setCondition(int condition){
        this.condition = condition;
    }

    public boolean checkInput(String s){
        for(int i = 0; i < s.length(); i++){
            for(int u = 0; u < inputAlphabet.length; u++){
                if(s.charAt(i) == inputAlphabet[u]){
                    setCondition(nextConditionTable[condition][u]);
                    break;
                }
            }
        }
        for(int i = 0; i < acceptConditions.length; i++){
            if(acceptConditions[i] == condition){
                return true;
            }
        }
        resetCondition();
        return false;
    }

    public void resetCondition(){
        this.condition = 0;
    }
}