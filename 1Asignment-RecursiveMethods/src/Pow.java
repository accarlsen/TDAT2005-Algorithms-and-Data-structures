public class Pow{
    
    //methods
    public double solve(double x, int n){
        if(n == 0){
            return x;
        }
        else if(n > 0){
            return x*this.solve(x, n-1);
        }
        else{
            return -1;
        }
    }
}