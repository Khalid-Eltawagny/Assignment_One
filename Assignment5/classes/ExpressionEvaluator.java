package eg.edu.alexu.csd.datastructure.stack;

/**
 *
 * @author Khalid Eltawagny
 */
import java.lang.*;
public class ExpressionEvaluator implements IExpressionEvaluator {
    // this function checks the precedent of operators
    private boolean Precedent (char op1,char op2 ){
        if ((op1=='/'||op1=='*')&& (op2!='*' && op2!='/' ) ){
            return true;
        }else if (op2=='(') return true; 
        else return false;
    }
    // this function checks if char is operator or not
   private boolean IsOpr (char c){
       if (c=='+'||c=='-'||c=='*'||c=='/'){
           return true;
       }
       return false;
   }
   int digits = 0; // to count digits in expression
   int operators = 0; // to count operators in expression
   boolean LastIsDigit=false; // to indicate last char in evert loop
   boolean IsSpace = false; // to indicate any space in expression
   StringBuilder FPostfix = new StringBuilder("");
/**
* Takes a symbolic/numeric infix expression as input and converts it to
* postfix notation. There is no assumption on spaces between terms or the
* length of the term (e.g., two digits symbolic or numeric term)
*
* @param expression
* infix expression
* @return postfix expression
*/
@Override
public String infixToPostfix(String expression){
    if (expression.length()==0){throw new RuntimeException("Invalid Input");}
    for (int i=0;i<expression.length();i++){
        if (i==expression.length()-1 && !IsOpr(expression.charAt(i) )&&((expression.charAt(i)!=')') && expression.charAt(i)!= '(') && expression.charAt(i)!=' ' ){
        digits++;
        } else if (i!=expression.length()-1 &&!IsOpr(expression.charAt(i)) && ( expression.charAt(i+1)==' ' || expression.charAt(i+1)=='(' || expression.charAt(i+1)==')'|| IsOpr(expression.charAt(i+1)) )&& ((expression.charAt(i)!=')') && expression.charAt(i)!= '(') && expression.charAt(i)!=' ' ){
        digits++;
        }
    }
    for (int i =0;i<expression.length();i++){
        if (IsOpr(expression.charAt(i)) && LastIsDigit){
            operators++;
            LastIsDigit = false;
        }else if (IsOpr(expression.charAt(i)) && !LastIsDigit){throw new RuntimeException("Invalid Input");}
        else LastIsDigit = true;
    }
    if (IsOpr(expression.charAt(0))){throw new RuntimeException("Invalid Input");}
    Stack opr = new Stack();
    StringBuilder Postfix = new StringBuilder("");
    int i=0;
    boolean Special_case = false;
    int Special_counter = 1 ;
    if (expression.charAt(0)=='(') {
        Special_case = true;
       
    }
    while(i<expression.length()){ 
        if (!(expression.contains("/")||expression.contains("*")||expression.contains("+")||expression.contains("-"))){
        throw new RuntimeException("Invalid Input");
        }
        else if (expression.contains("%") || expression.contains("&")
        || expression.contains("|") || expression.contains("!")
        || expression.contains("^")) {
      throw new RuntimeException("Invalid Input");
    }
        while(opr.isEmpty()&& !Special_case){ 
        if (i>=expression.length()) throw new RuntimeException("Invalid Input");
        if(Character.isDigit(expression.charAt(i))||expression.charAt(i)==' '){
            if (Postfix.length()!=0 &&Postfix.charAt(Postfix.length()-1)==' ' && expression.charAt(i)==' '){}else{
            Postfix.append(expression.charAt(i));}
            i++;
        }else if(IsOpr(expression.charAt(i))){
            opr.push((char)expression.charAt(i));
            Postfix.append(" ");
            i++;
            break;
        }else{ 
            Postfix.append(expression.charAt(i)); 
            i++;
        }
        }
        //Special case
        if (i>=expression.length()) throw new RuntimeException("Something went wrong");
        if (expression.charAt(i)=='(' || Special_case){
            opr.push('(');
            i++;
            Special_case=true;
            try {
            while (Special_case){
            if (IsOpr(expression.charAt(i))&&Precedent(expression.charAt(i),(char)opr.peek())){
            Postfix.append(" ");
            opr.push((char)expression.charAt(i));
            Special_counter++;
            
            i++;
            } 
            else if (IsOpr(expression.charAt(i))&& !Precedent(expression.charAt(i),(char)opr.peek())){
               Postfix.append(" ");
            while ((char)opr.peek()!=')' && !Precedent(expression.charAt(i),(char)opr.peek())){
                Postfix.append((char)opr.peek());
            if (Postfix.length()!=0 &&Postfix.charAt(Postfix.length()-1)==' ' && expression.charAt(i)==' '){
            }else{
                Postfix.append(' ');}
                opr.pop();  
                Special_counter--;
            }
            if ((char)opr.peek()=='(') {
            opr.push(expression.charAt(i));
            
            Special_counter++;
            }
            i++;            
            }
            else if (expression.charAt(i)==')' && Special_counter==1){throw new RuntimeException("Invalid Inputs");}
            else if (expression.charAt(i)==')'){
                if (Postfix.length()!=0 &&Postfix.charAt(Postfix.length()-1)==' '){}else{
                Postfix.append(' ');}
                while((char)opr.peek()!='('){
                    Postfix.append((char)opr.peek());
            if (Postfix.length()!=0 &&Postfix.charAt(Postfix.length()-1)==' ' && expression.charAt(i)==' '){
            }else{
                    Postfix.append(' ');}
                    opr.pop();
                Special_counter--;
                }
                i++;
                opr.pop();
                Special_counter--;
            }
            else if (expression.charAt(i)=='('){
                opr.push(expression.charAt(i));
                Special_counter++;
                i++;
            }   
        else  {
        if (Postfix.length()!=0 &&Postfix.charAt(Postfix.length()-1)==' '&& expression.charAt(i)==' ')
              {i++;
              }else {
                Postfix.append(expression.charAt(i));i++;
        }
            }
            
                if (Special_counter == 0){
                    Special_case=false;
                    Special_counter=1;
                }
        }
            }catch (StringIndexOutOfBoundsException e){
                throw new RuntimeException("Invalid Input");
            }
        }
        //Odrinary case
        else if (IsOpr(expression.charAt(i))&&Precedent(expression.charAt(i),(char)opr.peek())){
            opr.push((char)expression.charAt(i));
            Postfix.append(" ");
            i++;
        } else if (IsOpr(expression.charAt(i))&& !Precedent(expression.charAt(i),(char)opr.peek())){
            Postfix.append(" ");
            while (!opr.isEmpty()&& !Precedent(expression.charAt(i),(char)opr.peek())){
                
                if (opr.size()!=1){
                Postfix.append((char)opr.peek());
                Postfix.append(" ");
                    if (Postfix.length()!=0 &&Postfix.charAt(Postfix.length()-1)==' ' && expression.charAt(i)==' '){
                    }else{
                     Postfix.append(' ');}
                
                }
                else Postfix.append((char)opr.peek());
                Postfix.append(" ");
                opr.pop();  
            }
            if (opr.isEmpty()) opr.push(expression.charAt(i));
            i++;
        }else if (expression.charAt(i)==')' && Special_counter==1){throw new RuntimeException("Invalid Inputs");}
        else  {
            if (Postfix.length()!=0 &&Postfix.charAt(Postfix.length()-1)==' ' && expression.charAt(i)==' '){
            }else{
            Postfix.append(expression.charAt(i));}
            i++;
        }
    }
    //check for invalid inputs
    if (operators >= digits || digits-operators > 1){
        throw new RuntimeException("Invalid Input");
    }
    else {
    Postfix.append(' ');
    while(!opr.isEmpty()){
        if (opr.size()!=1){
        Postfix.append((char)opr.peek());
        Postfix.append(' ');}
        else Postfix.append((char)opr.peek());
        opr.pop();
    }
    String S = Postfix.toString();
    for (i=0;i<S.length();i++){
        if (Postfix.charAt(i)==' '&& !IsSpace&& i!=0){
            FPostfix.append(S.charAt(i));
            IsSpace = true;
        }
        else if (S.charAt(i)!= ' '){
            FPostfix.append(S.charAt(i));
            IsSpace=false;
            }
    }
    }
   return FPostfix.toString();
}
/**
* Evaluate a postfix numeric expression, with a single space separator
*
* @param expression
* postfix expression
* @return the expression evaluated value
*/
@Override
public int evaluate(String expression){
Stack opr = new Stack();
float val =0;
int i=0;
StringBuilder temp = new StringBuilder("");
if (expression.equals(null) || expression.length() == 0)
throw new RuntimeException("Invalid Input");
while (i<expression.length()){
    if (Character.isDigit(expression.charAt(i))){
        while (expression.charAt(i)!=' '){
            temp.append(expression.charAt(i++));
        }
        opr.push(Float.parseFloat(temp.toString()));
        temp.setLength(0);
    }
    else if (IsOpr(expression.charAt(i))){
        float num1=(float)opr.pop();
        float num2=(float)opr.pop();
        switch (expression.charAt(i)){
            case '+':
                val=(num1+num2);
                opr.push((float)val);
                break;
            case '-':
                val=(num2-num1);
                opr.push((float)val);
                break;
            case '/':
                if (num1==0f){
                    throw new RuntimeException("Divide By Zero Isn't allowed");
                }else {
                val=(num2/num1);
                opr.push((float)val);
                break;}
            case '*':
                val=(num2*num1);
                opr.push((float)val);
                break;                
            
    }  
    }else if (expression.charAt(i)!= ' ') throw new RuntimeException("Invalid Input");
    i++;
}
return (int)val;
}
}
