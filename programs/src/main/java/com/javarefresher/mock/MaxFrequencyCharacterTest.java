package com.javarefresher.mock;

// problem:
// Find maximum occuring character when given a string with only smallcase alphabetic letters

//Feedback
//1.Commenting

interface IMaximumFrequencyCharacter{
    Character getMaximumCharacter(String string);
}

class MaximumfrequencyCharacter implements IMaximumFrequencyCharacter{

    final int CHAR_SIZE = 26; 
    @Override
    public Character getMaximumCharacter(String string){
        if(string == null || string.equals("")){
            throw new IllegalArgumentException("Input can not be null or empty");
        }
        boolean isStringSmallCaseAlphabetic = isStringSmallCaseAlphabetic(string);
        if(isStringSmallCaseAlphabetic){
            throw new IllegalArgumentException("Input should contain only smallcase alphabetic letters");
        }
        int[] characterCountArray = new int[CHAR_SIZE];
        for(int i =0 ;i<string.length();i++){
            characterCountArray[getCharacterIndex(string.charAt(i))]++;
        }
        int maxCount = Integer.MIN_VALUE, maxCountIndex = 0;
        for(int i = 0;i<26;i++){
            if(characterCountArray[i]>maxCount){
                maxCount = characterCountArray[i];
                maxCountIndex = i;
            }
        }
        return (char)('a' + maxCountIndex);
    }
    private int getCharacterIndex(Character ch){
        return ch - 'a';
    }      

    private boolean isStringSmallCaseAlphabetic(String string){
        for(int i = 0;i<string.length();i++){
            Character ch = string.charAt(i);
            if(ch < 'a' || ch > 'z'){
                return false;
            }
        }
        return true;
    }
}











public class MaxFrequencyCharacterTest {
    public static void main(String[] args) {
    }
}
