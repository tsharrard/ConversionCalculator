package a1_sharrard;

/**
 *
 * @author todds
 */



public class Inventory {
    
    
    private String id = "ABC-1234";
    private String name ="New Item";    // string name cannot be a null object
    private int qoh;                    // quanityonhand
    private int rop = 25;                    // reoderpoint
    private double sellPrice;                       

    public Inventory(){
    }
    public Inventory(String id, String name, int qoh, int rop, double sellPrice){
        this.id = id;
        this.name = name;
        this.qoh = qoh;
        this.rop = rop;
        this.sellPrice = sellPrice;        
    }
   
 
    public String getId() {
        return id;
    }
 
    public void setId() {
    java.util.Scanner input = new java.util.Scanner(System.in);
        String newString;
        boolean validString;
  
      do{
          System.out.println("ZZ - Enter the Inventory Item ID: ");
                newString = input.next();
                validString =(newString.length() ==  8);
                if (validString == false) System.out.println("String must "
                        + "be 8 characters long" );

          char[] ch = newString.toCharArray();
          for (int i=0; i<newString.length();i++){
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
      
      this.id = newString;
    }

    public String getName() {
        return name;
    }
  
    public void setName(String str) throws NullPointerException {
              
         
        if (str.length() == 0) {
        throw new NullPointerException  ("Name string cannot be null");
        } else {
            this.name = str;
        }
         
    }
 
    public int getQoh() {
        return qoh;
    }
 
    public void setQoh(int qoh) throws IllegalArgumentException {

          if (qoh >= 0) {
            this.qoh = qoh;
          }
          else {
            throw new IllegalArgumentException ("QOH cannot be negative");
          } 
          
         
 
    }
    
    public int getRop() {
        return rop;
    }

    public void setRop(int rop) throws IllegalArgumentException {
        
        if (rop > 0) {
            this.rop = rop;
          }
          else{
            throw new IllegalArgumentException("Re Order Point cannot be negative");
          }
            
    }               
  
    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        
        if (sellPrice >= 0) {
            this.sellPrice = sellPrice;
          }
          else{
            throw new IllegalArgumentException("Selling Price cannot be negative");
          }
        
    }
  
    public String toString(){
        //Item ID (Item Name), QOH: * Price: $x.xx
        return id + " ("+ name + "), QOH:" + qoh + " Price: $" + sellPrice;
      
    }
    
}

