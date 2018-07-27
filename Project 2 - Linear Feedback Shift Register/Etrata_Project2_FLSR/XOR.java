/**
 * The XOR class consists of methods that do calculations based on XOR logic.
 * 
 * @author (Gabriel Etrata)
 * @(v1.0)
 */
public class XOR{
    /**
     * Implements the exclusive OR function on two bits of data.
     * 
     * @param x - first boolean
     * @param y - second boolean
     * 
     * return boolean value of the boolean
     */
    public static boolean xor(boolean x, boolean y){
       return ( (x || y ) && !(x && y) );
    }
    
    /**
     * Implements the exclusive OR function on two strings.
     * 
     * @param x - first string
     * @param y - second string
     * 
     * @return out - output of two XOR'd strings.
     */
    public static String xor(String x, String y){
       int s1 = x.length();
       int s2 = y.length();
       int xIndex = s1 - 1;
       int yIndex = s2 - 1;
       int max = Math.max(s1, s2);
       String out = "";
        for(int j = 0; j < max; j++){
            while(x.length() < y.length()){
                x = "0" + x;
            }
            while(y.length() < x.length()){
                y = "0" + y;
            }
            if (x.charAt(j) == y.charAt(j)){
                out = out + "0";
            } else if (x.charAt(j) != y.charAt(j)){
                out = out + "1";
            }
        }
        return out;
        }
      
    /**
     * Implements the exclusive OR function on two integers.
     * 
     * @param x - an integer
     * @param y - an integer
     * 
     * @return output - output of two XOR'd integers
     */
    public static int xor(int x, int y){
       int xToBin = Integer.parseInt(decToBinary(x));
       int yToBin = Integer.parseInt(decToBinary(y));
       String z = xor(Integer.toString(xToBin), Integer.toString(yToBin));
       int output = binaryToDec(z);
       return output;        
        //assumes the integers are non-negative
        //don't forget to convert your integers to binary first
        //replace this with the actual xor logic for two integers
    }
    
    /**
     * Takes an integer in base 10 and converts it to binary.
     * 
     * @param x integer in base 10
     * 
     * @return binary binary representation of the integer.
     */
    public static String decToBinary(int x){
        //assumes x >= 0 
        if(x == 0){
            return "0"; 
        }
        String binary = "";
        while (x > 0) {
           int rem = x % 2;
           binary = rem + binary;
           x = x / 2;
       }
       return binary;
    }
    
    /**
     * Takes a binary number and converts it to base 10.
     * 
     * @param s string representation of binary number
     * 
     * @return decimal integer representation of binary in base 10
     */
    public static int binaryToDec(String s){
        //assumes s is a string of 1s and 0s. 
        int powTwo = 1; 
        int decimal = 0; 
        for(int i = s.length()-1; i >= 0; i--){
            int x = Integer.parseInt(s.substring(i, i+1)); 
            decimal = decimal + x*powTwo; 
            powTwo = 2*powTwo; 
        }
        return decimal; 
    }

    /**
     * Main method that tests the various XOR static functions
     * @param args - no command line arguments needed 
     */
    public static void main(String[] args){
        String s = decToBinary(873); 
        System.out.println(s);  //expected output: 1101101001
        int x = binaryToDec(s);  
        System.out.println(x);  //expected output: 873
        boolean t = true;
        boolean f = false;
        System.out.println(xor(f, f)); //expected output: false
        System.out.println(xor(f, t)); //expected output: true
        System.out.println(xor(t, f)); //expected output: true
        System.out.println(xor(t, t)); //expected output: false
        String s2 = "11001";
        System.out.println(xor(s2, "0100")); //expected output: 11101
        int y = 10;
        int z = 5;
        System.out.println(xor(y, z)); //expected output: 15
    }
}