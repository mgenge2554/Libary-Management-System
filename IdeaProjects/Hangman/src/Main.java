import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String word;
        char guess;
        int incorrect = 0;

        ArrayList<Character> WordState = new ArrayList<>();
        System.out.println("Welcome to the hangman game");



    System.out.println("First player, please enter your word");

        word = scanner.nextLine();

        for (int i = 0; i <word.length(); i++){
            WordState.add('_');

        }
        while(incorrect < 6){
        System.out.print("2nd player please make a guess: ");
        guess = scanner.next().toLowerCase().charAt(0);
        if(word.indexOf(guess) >= 0 ){
            System.out.println("Correct guess");
            for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) == guess){
                WordState.set(i, guess);
            }
            }
            System.out.println(WordState);
        } else{
            System.out.println("Incorrect");
            incorrect++;
            System.out.println(getHangmanArt(incorrect));
            }
        if(incorrect == 6){
            System.out.println("you lose");
        }

                if(!WordState.contains('_')){
                    System.out.println("you win!");
                    break;

            }
        }
    }
    static String getHangmanArt(int incorrect){
        return switch (incorrect){
            case 0 -> """
                    
                    
                    
                    """;
            case 1 -> """
                     O
                    
                    """;
            case 2 -> """
                     O
                     |
                    """;
            case 3 -> """
                     O
                     |\\
                    """;
            case 4 -> """
                     O
                    /|\\
                    """;
            case 5 -> """
                     O
                    /|\\
                    /
                    """;
            case 6 -> """
                     O
                    /|\\
                    / \\
                    """;
            default -> "";
        };

    }
}