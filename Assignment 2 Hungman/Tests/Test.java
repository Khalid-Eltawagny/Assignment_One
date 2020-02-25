package eg.edu.alexu.csd.datastructure.hangman;

/**
 *
 * @author Khalid Eltawagny
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("WelCome To Our Game :)))))))\n");
        System.out.println("The Secret Word is a Country name .. Please Guess Well :D \n");
        int MAX = 5;
        Hungman newGame = new Hungman();
        newGame.setMaxWrongGuesses(MAX);
        newGame.StartGame();
        
    }
    
}
