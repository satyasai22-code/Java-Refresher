package com.javarefresher.week01;
public class MaxFrequemcyChar {
    static int getIndexOfChar(char ch){
        return ch - 97;
    }
    static int CHAR_COUNT_SIZE = 26;
    // Only small case enlgish letters are allowed
    static char getMaxOccurringChar(String s) throws InvalidAlphaCharException
    {
        try {
            if(s == null || s.equals("")){
                throw new InvalidStringException("String can't be empty or null");
            }
            int count[] = new int[CHAR_COUNT_SIZE];
            int len = s.length();
            for (int i = 0; i < len; i++){
                char ch = s.charAt(i);
                if(ch>=65 && ch<=90){
                    throw new InvalidAlphaCharException(ch + " is not an small case letter");
                }
                if(ch<97 || ch>122){
                    throw new InvalidAlphaCharException(ch + " is not an english alphabet");
                }
    
                count[getIndexOfChar(ch)]++;
            }
     
            int max = 0;
            char result = ' '; 
            for (int i = 0; i < len; i++) {
                if (max < count[getIndexOfChar(s.charAt(i))]) {
                    max = count[getIndexOfChar(s.charAt(i))];
                    result = s.charAt(i);
                }
            }
            return result;
        }catch(InvalidAlphaCharException e){
            System.out.println(e.getMessage());
        } 
        catch(InvalidStringException e){
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
    public static void main(String[] args) throws InvalidAlphaCharException {
        System.out.println(getMaxOccurringChar("null"));
        System.out.println(getMaxOccurringChar("abcde"));
        System.out.println(getMaxOccurringChar("wwwxxxyyyzzz"));
        System.out.println(getMaxOccurringChar("wwwwxxxyyyzzz"));
        System.out.println(getMaxOccurringChar("Wwwwxxxyyyzzz"));
        System.out.println(getMaxOccurringChar("w@wwwxxxyyyzzz"));
    }
}
