/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg1;

/**
 *
 * @author Khalid Eltawagny
 */
import java.util.InputMismatchException;
import java.lang.ArithmeticException;
public class Clac implements ICalculator {    
   public Clac (){
    }
    @Override
    public int add(int x, int y) {
        return x+y;
    }
   @Override
    public float divide (int x , int y){
        try {
        return (float) x/y;
        }
        catch (InputMismatchException e){
            System.out.println("Numeric Values Only");
        }
        catch (ArithmeticException e){
            System.out.println("Devide by zero isn't allowed");
        }
        return 0;
        
        }
}
