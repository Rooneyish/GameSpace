package com.gamespace.util;


import java.util.regex.Pattern;

/**
 *
 * @author Ronish Prajapati
 * LMU ID: 23048584
 */
public class ValidationUtil {
    
    private static final Pattern STRING_PATTERN = Pattern.compile("^[a-zA-Z0-9]+$");
    private static final Pattern INTEGER_PATTERN = Pattern.compile("\\d+");
    private static final Pattern YEAR_PATTERN = Pattern.compile("\\d{4}");
    private static final Pattern MONTH_DAY_PATTERN = Pattern.compile("\\d{1,2}");
    
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
     * Validates the integer input if the integer contains numeric values or not
     * 
     * @param value the integer value to validate
     * @return true if validate else false
     */
    public boolean isValidInteger(String value){
        return !isNullOrEmpty(value) && INTEGER_PATTERN.matcher(value).matches();
    }
    
    /**
     * Validates if the price is a positive number
     * @param price the price to validate
     * @return true if valid, otherwise false
     */
    public boolean isValidPrice(double price){
        return price >= 0;
    }
    /**
     * Validates if the GameNum is a positive number
     * @param gameNum the gameNum to validate
     * @return true if valid else false
     */
    public boolean isValidGameNum(int gameNum){
        return gameNum>0;
    }
    
    /**
     * Validates if the released date is in a date format or not
     * @param year the year of the game released
     * @param month the month of the game released
     * @param day the day of the game released
     * @return false if invalid and true for valid
     */
    public boolean isValidReleasedDate(String year, String month, String day){
        if(isNullOrEmpty(year) || isNullOrEmpty(month) || isNullOrEmpty(day)){
            return false;
        }
        
        if(!YEAR_PATTERN.matcher(year).matches() || !MONTH_DAY_PATTERN.matcher(month).matches() || !MONTH_DAY_PATTERN.matcher(day).matches()){
            return false;
        }
        
        int monthNum = Integer.parseInt(month);
        int dayNum = Integer.parseInt(day);
        
        if (monthNum < 1 || monthNum > 12){
            return false;
        }
        return !(dayNum < 1 || dayNum > 31);
    }
}
