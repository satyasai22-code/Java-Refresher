package com.javarefresher.week05.solidprinciples;


// class Book {

//     private String name;
//     private String author;
//     private String text;

//     //constructor, getters and setters

//     // methods that directly relate to the book properties
//     public String replaceWordInText(String word, String replacementWord){
//         return text.replaceAll(word, replacementWord);
//     }

//     // methods for outputting text
//     void printTextToConsole(String text){
//         return ;
//     }

//     void printTextToAnotherMedium(String text){
//         return;
//     }
// }
// Above code not only stores book info but also prints in 2 ways.
// So above class managing 2 responsibilities which is inefficient

//Solution:
class Book {

    private String name;
    private String author;
    private String text;

    // methods that directly relate to the book properties
    public String replaceWordInText(String word, String replacementWord){
        return text.replaceAll(word, replacementWord);
    }
}

class BookPrinter{
    // methods for outputting text
    void printTextToConsole(String text){
        return ;
    }
    void printTextToAnotherMedium(String text){
        return;
    }
}

//A class should have one and only one reason to change, meaning that a class should have only one job.
public class S {
    
}
