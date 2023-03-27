public class MaxFrequemcyChar {
    static int getIndexOfChar(char ch){
        return ch - 97;
    }
    static int CHAR_COUNT_SIZE = 26;
    static char getMaxOccurringChar(String s)
    {
        int count[] = new int[CHAR_COUNT_SIZE];
        int len = s.length();
        for (int i = 0; i < len; i++)
            count[getIndexOfChar(s.charAt(i))]++;
 
        int max = 0;
        char result = ' '; 
        for (int i = 0; i < len; i++) {
            if (max < count[getIndexOfChar(s.charAt(i))]) {
                max = count[getIndexOfChar(s.charAt(i))];
                result = s.charAt(i);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(getMaxOccurringChar("null"));
        System.out.println(getMaxOccurringChar("abcde"));
        System.out.println(getMaxOccurringChar("wwwxxxyyyzzz"));
        System.out.println(getMaxOccurringChar("wwwwxxxyyyzzz"));
    }
}
