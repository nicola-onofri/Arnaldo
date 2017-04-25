package utils;

/**
 * Created by nicola on 11/04/17.
 */
public class MathsUtil {

    //Euclidean algorithm
    public int gcd(int a, int b){
        if(b==0) return a;
        else if(b==1) return 1;
        else return gcd(b, a%b);
    }


}
