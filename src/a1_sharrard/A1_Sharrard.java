package a1_sharrard;

/**
 *
 * @author todds
 */
public class A1_Sharrard {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        java.util.Scanner input = new java.util.Scanner(System.in);
        String newString;
        boolean validString;
  
      do{
          System.out.println("ZZ - Enter the Inventory Item ID: ");
                newString = input.next();
                validString =(newString.length() ==  8);
                if (validString == false) System.out.println("String must be 8 characters long" );

          char[] ch = newString.toCharArray();
          myloop: for (int i=0; i<newString.length();i++){
                    if (i <=2  && validString == true){
                        validString = (Character.isLetter(ch[i])); 
                        if (validString == false) {
                            System.out.println("No letter at string index " +i);
                        break;}
                        }
                    else if (i ==3 && validString == true){
                        validString = (ch[i] =='-');
                         if (validString == false){
                             System.out.println("No \"-\" at index " +i);
                         break;}
                        }
                    else if (i >= 4 && validString == true){
                        validString = (Character.isDigit(ch[i])); 
                        if (validString == false) {
                            System.out.println("No number at string index " +i );
                        break;}
                    }
          }
    
       } while (validString == false);
			
}
}

