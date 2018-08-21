
package hamming;

import java.util.Scanner;

/**
 *
 * @author Juárez Cruz Oscar Daniel | Student from ESCOM IPN
 */

public class RunHamming {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Hamming hamming = new Hamming();
        while( true ){
            System.out.println("Set 'exit' from get out\n");
            System.out.print("Get Hamming Word: ");
            String nbm = scan.next();
            System.out.println("\n\n");
            if( nbm.equals("exit") )
                break;
            hamming.reset(nbm);
            System.out.println("\n\n");
        }
    }
}