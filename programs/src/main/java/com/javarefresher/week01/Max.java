package com.javarefresher.week01;



interface IMaximumFrequencyCharacter{
    Character getMaxChar(String string);
}

class MaxFrequemcyChar implements IMaximumFrequencyCharacter{

    @Override
    public Character getMaxChar(String string) {
        if(string == null || string.equals("")){
            throw new IllegalArgumentException("String cant be null or empty");
        }
        boolean isStringSmallCaseAlphabetic = isStringSmallCaseAlphabetic(string);
        if(isStringSmallCaseAlphabetic){
            throw new IllegalArgumentException("String should have small case english alphabet letters");
        }
        int[] countArray = new int[26];
        for(int i=0;i<string.length();i++){
            countArray[getCharIndex(string.charAt(i))]++; 
        }
        int maxCountIndex = 0, maxCount = Integer.MIN_VALUE;
        for(int i = 0;i<26;i++){
            if(countArray[i] > maxCount){
                maxCountIndex = i;
                maxCount = countArray[i];
            }
        }
        // for()
        return (char)('a' + maxCountIndex);
    }
    private int getCharIndex(Character ch){
        return ch - 'a';
    }
    private boolean isStringSmallCaseAlphabetic(String string){
        for(int i=0;i<string.length();i++){
            Character ch = string.charAt(i);
            if(ch < 'a' || ch >'z'){
                return false;
            }
        }
        return true;
    }
    
}


public class Max {
    public static void main(String[] args) {
        IMaximumFrequencyCharacter m = new MaxFrequemcyChar();
        System.out.println(m.getMaxChar("wwwxxxyyyzzz"));
    }
}
