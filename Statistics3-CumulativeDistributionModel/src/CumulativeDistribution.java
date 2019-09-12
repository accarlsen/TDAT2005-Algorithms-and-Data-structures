public class CumulativeDistribution{
    
    //fields
    public double[] x;
    public double[] probX;

    //constructor

    //methods
    public boolean setX     (double[] x)    { this.x = x;           return true;}
    public boolean setProbX (double[] probX){ this.probX = probX;   return true;}

    public double calculateE(){ 
        double retVal = 0; 
        for(int i = 0; i < x.length; i++){
            retVal += ( x[i] * probX[i] );
        }
        return retVal;
    }

    public double calculateVar(){
        double retVal = 0; 
        for(int i = 0; i < x.length; i++){
            retVal += ( Math.pow(x[i], 2) * probX[i] );
        }
        return retVal - this.calculateE();
    }

    public double calculateStandardVar(){
        return Math.pow(this.calculateVar(), 2);
    }

    public double[] calculateDistFunc(){
        double[] retVal = new double[probX.length];
        retVal[0] = probX[0];
        for(int i = 1; i < x.length; i++){
            retVal[i] = retVal[i-1] + probX[i];
        }
        return retVal;
    }
}