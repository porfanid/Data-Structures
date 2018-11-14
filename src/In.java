/**
 *Pavlos Orfanidis 4134
 *Pantelis Rempakos 4279
 *Giorgos Kamaridis 4264
 */

/**
 * Various input methods
 * Source :  R. Sedgewick, Algorithms in Java, parts 1-4
 */
import java.io.*;
/**
 * getting input methods
 * @author porfanid
 *
 */
public class In {

    private static int c;
    
    
    
    
    
    
    
    /**
     * 
     * @return if the current character is blank or not, based on whether the int c is a whitespace character if down casted to character.
     */
    private static boolean blank() {
        return Character.isWhitespace((char) c);
    }

    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * setting the c field the character that is read from the input method
     * 
     * if there is an IO exception, the character is set to -1 to suggest that an error has occurred.
     */
    private static void readC() {
        try {
            c = System.in.read();
        } catch (IOException e) {
            c = -1;
        }
    }

   
    
    
    
    
    
    
    
    
    
    
    /**
    * Reading the first character from the input stream
    */
    public static void init() {
        readC();
    }

    
    
    
    
    
    
    
    
    
    
    
    
    /**
      * returning whether the class could not read the file. 
      * @return
      */
    public static boolean empty() {
        return c == -1;
    }
    
    
    
    
    
    
    
    
    
    
    

    /**
     * reading from the input stream.
     * 
     * if the stream is empty, it returns null
     * 
     * it creates an empty string
     * 
     * while the input character is not empty or is blank, it adds it to the string that will return
     * 
     * while the input character is not empty and is blank, it adds it to the string that will return
     * 
     * @return the string that has been constructed
     */
    public static String getString() {
    	
    	
    	
    	
    	
        if (empty()) {
            return null;
        }
        
        
        
        
        
        String s = "";
        while (!(empty() || blank())) {
            s += (char) c;
            readC();
        }
        
        
        
        while (!empty() && blank()) {
            readC();
        }
        
        
        
        
        return s;
    }
    
    
    
    
    
    
    
    
    
    
    
    /**
     * read integer from input stream
     * @return the integer from the string that has been constructed from the characters that were read from the default input stream.
     */
    public static int getInt() {
        return Integer.parseInt(getString());
    }
    
    
    
    
    
    
    /**
     * doing the same thing but with long type numbers.
     * @return
     */
    public static long getLong() {
        return Long.parseLong(getString());
    }

    
    
    
    
    
    
    /**
     * reading a double from the default input stream.
     * @return the double that was read.
     */
    public static double getDouble() {
        return Double.parseDouble(getString());
    }
}
