
import java.util.regex.Pattern;


/**
 *
 * @author Ronish Prajapati
 * LMU ID: 23048584
 */
public class ValidationUtil {
    
    private static final Pattern STRING_PATTERN = Pattern.compile("^[a-zA-Z0-9]+$");
    
    /**
     * Validates if a string is null or empty.
     * 
     * @param value the string to validate
     * @return true if the string is null or empty, otherwise false
    */
    public boolean isNullOrEmpty(String value){
        return value ==null||value.trim().isEmpty();
    }
    
    /**
     * Validates the string input if the string contains alphanumeric
     * 
     * @param string the string to validate
     * @return true if valid else false
     */
    public boolean isValidString(String string){
        return !isNullOrEmpty(string) && STRING_PATTERN.matcher(string).matches();
    }
    
    /**
     * Validates if the price is a positive number
     * @param price the price to validate
     * @return true if valid, otherwise false
     */
    public boolean isValidPrice(double price){
        return price >= 0;
    }
}
