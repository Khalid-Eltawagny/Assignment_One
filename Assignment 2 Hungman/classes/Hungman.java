package eg.edu.alexu.csd.datastructure.hangman.cs18010594;
import java.io.File;
import java.util.Scanner;
import eg.edu.alexu.csd.datastructure.hangman.IHangman;

/**
 *
 * @author Khalid Eltawagny
 */

public class Hungman implements IHangman {
    File myfile = new File("dictionary.txt");
    String[] dictionary = new String[100];
    int ONETIME = 0;
    int NOFWords = 0;
    int maxWrong = 1;
    
    String TrueWord = this.selectRandomSecretWord();
    StringBuilder Original_Word = new StringBuilder(TrueWord);
    StringBuilder guess = new StringBuilder(TrueWord);
    
    @Override
    public void setDictionary(String[] words)
    {
        NOFWords = 0;
        try (Scanner Reader = new Scanner(myfile)){
            while(Reader.hasNextLine()){
                words[NOFWords] = Reader.nextLine();
                NOFWords++;
            }
        }
        catch(Exception anything){
            System.out.println(anything.getMessage());
        }
    }
    
    @Override
    public String selectRandomSecretWord()
    {
        this.setDictionary(dictionary);
        if(NOFWords == 0)
            return "";
        int rand = (int)(Math.random()*50)% NOFWords;
        return dictionary[rand];
    }
    
    private void setstring()
    {
        for(int i=0; i < guess.length(); i++)
            guess.setCharAt(i, '-');
    }
    
    @Override
    public String guess(Character sm)
    {
        char c = Character.toUpperCase(sm);
        if(!Character.isLetter(c)){
            maxWrong++;
            throw new RuntimeException("Please Enter a correct CHAR");
        }
        if(Original_Word.toString().indexOf(c)!=-1) maxWrong++;
        while(Original_Word.toString().indexOf(c)!= -1){
            guess.setCharAt(Original_Word.toString().indexOf(c),c);
            Original_Word.setCharAt(Original_Word.toString().indexOf(c),'$');
        }
        return guess.toString();
    }
    
    @Override
    public void setMaxWrongGuesses(Integer max)
    {
        maxWrong = max;
    }
        
    public void StartGame()
    {
        if(NOFWords !=0){
            setstring();
            while( maxWrong>0 && guess.toString().indexOf('-') != -1){
                System.out.println("You have "+ maxWrong +" Chances");
                System.out.print("Please , Guess a letter  : \n");
                if (ONETIME==0){
                System.out.println(guess);
                ONETIME++;}
                Scanner input = new Scanner(System.in);
                char Guess = input.next().charAt(0);
                try{System.out.println(guess(Guess));}
                catch(RuntimeException blabla){System.out.println(blabla.getMessage());}
                maxWrong--;
            }
            if(maxWrong==0)
                System.out.println("OOOOOOH , You Lose !");
            else
                System.out.println("Good Work You Have Won !!");
            System.out.println("The secret word is "+ TrueWord);
        }
    }

}
