public class Pow2{

    //methods

    public double solve(double x, int n){
        if(n==0){
            return 1;
        }
        else if(n > 0){
            if(n%2==0){
                return this.solve(x*x, n/2);
            }
            else{
                return x * this.solve(x*x, (n-1)/2);
            }
        }
        else{
            return -1;
        }

    }
}