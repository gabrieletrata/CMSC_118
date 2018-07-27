
/**
 * The LFSR class.
 * 
 * @author(Gabriel Etrata)
 * @(v1.0)
 */
public class LFSR
{
    private String seed;
    private int tap;
    /**
     * Constructor for objects of type LFSR.
     * 
     * @param seed the initial seed
     * @param tap the initial tap
     */
    public LFSR(String seed, int tap){
    this.seed = seed;
    this.tap = tap;    
    }
    
    /**
     * Returns a string representation of the LFSR.
     * 
     * @return seed the seed converted to type String
     */
    public String toString(){
        return seed;
    }
    
    /**
     * Simulates one step of the LFSR.
     * 
     * @return bit XOR of the last bit and tap bit of the register
     */
    public int step(){
        String seed2 = seed.substring(0, 1);
        int seedInt = Integer.parseInt(seed2);
        String tap2 = seed.substring(tap, tap+1);
        int tapInt = Integer.parseInt(tap2);
        int bit = seedInt^tapInt;
        seed = seed.substring(1, seed.length()) + bit;
        return bit;
    }
    
    /**
     * Simulates k steps of the LFSR.
     * 
     * @param k number of steps
     * @return r base 10 representation of shifted string
     */
    public int generate(int k){
        int r = 0;
        for(int i = 0; i < k; i++){
            step();
            String s = seed.substring(seed.length() - k, seed.length());
            r = XOR.binaryToDec(s);
        }
        return r;
    }
    
    /**
     * Main method for LFSR class.
     * 
     * @param args
     */
    public static void main(String[] args){
        LFSR lfsr = new LFSR("01101000010", 2);
        for(int i = 0; i < 10; i++){
            int r = lfsr.generate(5);
            System.out.println(lfsr + " " + r);
            /*expected output:
            00001011001 25
            01100100100 4
            10010011110 30
            01111011011 27
            01101110010 18
            11001011010 26
            01101011100 28
            01110011000 24
            01100010111 23
            01011111101 29
            */
        }
    }
}


