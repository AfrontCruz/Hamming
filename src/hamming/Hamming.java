
package hamming;

/**
 *
 * @author Juárez Cruz Oscar Daniel | Student from ESCOM IPN
 */

public class Hamming {
    private String hammingApply;
    private String hammingWord;
    private int nmbBits;
    
    public Hamming(){
        this.hammingWord = "0";
    }
    
    public Hamming(String hammingWord){
        this.hammingWord = hammingWord;
        calculateHammingsBits();
        applyHamming();
    }

    public void reset(){
        calculateHammingsBits();
        applyHamming();
    }
    
    public void reset(String hammingWord){
        this.hammingWord = hammingWord;
        reset();
    }

    public void calculateHammingsBits() {
        int strLength = hammingWord.length();
        nmbBits = 0;
        while( !( Math.pow(2, nmbBits) >= strLength + nmbBits + 1) ){
            nmbBits++;
        }
        System.out.println("Hamming's bits: " + nmbBits);
    }

    public void applyHamming() {
        int length = hammingWord.length() + nmbBits;
        char[] aux = new char[ length ];
        int ones = 0;
        
        for( int i = 0; i <  nmbBits; i++){
            aux[ (int)Math.pow(2, i) - 1 ] = 'H';
        }
        
        for( int i = 0, j = 0; i < length; i++ ){
            if( aux[i] != 'H' ){
                aux[i] = hammingWord.charAt(j);
                j++;
            }
        }
        
        for( int i = 0, a = 1; i < nmbBits; i++ ){
            for( int j = 0; j < length; j++ ){
                if( aux[j] != 'H' ){
                    if( ( a & (j + 1) ) == a ){
                        if( aux [j] == '1' )
                            ones++;
                    }
                }
            }
            char hamming;
            if( ( ones % 2 ) == 0 )
                hamming = '0';
            else
                hamming = '1';
            
            System.out.println("H: " + hamming );
            
            for( int j = 0; j < length; j++ ){
                if( aux[j] == 'H' ){
                    aux[j] = hamming;
                    break;
                }
            }
            
            a = a << 1;
            ones = 0;
        }
        
        hammingApply = "";
        for( int i = 0, j = 0; i < length; i++ )
            hammingApply += aux[i];
        
        System.out.println(hammingApply);
    }

    public String getHammingApply() {
        return hammingApply;
    }

    public void setHammingApply(String hammingApply) {
        this.hammingApply = hammingApply;
    }

    public String getHammingWord() {
        return hammingWord;
    }

    public void setHammingWord(String hammingWord) {
        this.hammingWord = hammingWord;
    }

    public int getNmbBits() {
        return nmbBits;
    }

    public void setNmbBits(int nmbBits) {
        this.nmbBits = nmbBits;
    }
}
