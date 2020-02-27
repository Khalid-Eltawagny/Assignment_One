package eg.edu.alexu.csd.datastructure.hangman.cs18010594;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Khalid Eltawagny
 */
public class Test {

    public static void main(String[] args) {
    System.out.println("WelCome To Our Game :)))))))\n");
    System.out.println("The Secret Word is a Country name .. Please Guess Well :D \n");
    int MAX = 5;
    try {
    File myfile = new File("dictionary.txt");
    if (myfile.createNewFile()) {
       try {
       FileWriter mywriter = new FileWriter("dictionary.txt");
       mywriter.write("EGYPT\nUZBAKISTAN\nBELGIUM\nSINGAPORE\nMAURITANIA\nCOLOMBIA\nBURUNDI\nCHINA\nKAZAKHSTAN\nARGENTINA\n");
       mywriter.close();
       } catch (IOException e){
        e.printStackTrace();}
       
      } else {
        //System.out.println("File already exists.");
      }
    }catch (IOException e){
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
        Hungman newGame = new Hungman();
        newGame.setMaxWrongGuesses(MAX);
        newGame.StartGame();
        
    }
    
}
