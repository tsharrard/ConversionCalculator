package a1_sharrard;

/**
 *
 * @author todds
 */

import java.util.*;

public class Main_Inve {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
      
        boolean valueSet = false;                /*  has the value of the object been updated */
        final double SALESTAX = 0.13;       /* sales tax applied to purchases                   */
        
/**
 * Create Inventory object
 */
        
        Inventory item = new Inventory();
        System.out.println(item);
        
/**
 * Set Inventory ID
 */

        item.setId();
        System.out.println(item);
        
 /**
 * Set inventory name
 */
 
        String newName;

        do{
        
             try{
                System.out.println("Enter item name");
                newName = input.nextLine();
                item.setName(newName);
                valueSet = true;
             }
             catch (NullPointerException ex) {
                System.out.println("Incorrect Entry for \"Name\" - cannot "
                        + "be a null entry for name");
                // input.nextLine(); // discard input 
                }

        } while (valueSet == false);
    
 /**
 * Set quantity  on hand - qoh
 */
        
    valueSet = false;                /*  has the value of the object been updated */
    int newQoh;

    do{

         try{
            System.out.println("Enter item QOH");
            newQoh = input.nextInt();
            item.setQoh(newQoh);
            valueSet = true;
         }
         catch (IllegalArgumentException ex) {
            System.out.println("Incorrect value for Quantity On Hand - "
                    + "\"QOH\" cannot be less than zero (0)");
            }
         catch (InputMismatchException ex) {
            System.out.println("Incorrect value for Quantity On Hand - "
                    + "\"QOH\" must be an integer");
            input.nextLine(); // discard input 
            }  
         
    } while (valueSet == false);
      
    /**
     * Set Re Order Point - rop
     */
     
   valueSet = false;                /*  has the value of the object been updated */
   int newRop;

    do{

         try{
            System.out.println("Enter item ROP");
            newRop = input.nextInt();
            item.setRop(newRop);
            valueSet = true;  
         }
         catch (IllegalArgumentException ex) {
            System.out.println("Incorrect value for Re-order Point - "
                    + "\"ROP\" cannot be less than zero (0)");
            }
         catch (InputMismatchException ex) {
            System.out.println("Incorrect value for Re-order Point - "
                    + "\"ROP\" must be an integer");
            input.nextLine(); 
         }

    } while (valueSet == false);

/**
 * Set Selling Price
 */

   valueSet = false;                /*  has the value of the object been updated */
   double newSellPrice; 
      
    do{
        
         try{
           System.out.println("Enter item selling price");
           newSellPrice = input.nextDouble();  
           item.setSellPrice(newSellPrice);
           valueSet = true;  // update seqwe-1234tRop boolean if method is successful
         }
         catch (IllegalArgumentException ex) {
            System.out.println("Try again. (" + 
                "Incorrect input: sellPrice needs to be >0)");
            }
         catch (InputMismatchException ex) {
            System.out.println("Try again. (" + 
                "Incorrect input: an integer(0) or double is required (0.00) is required)");
            input.nextLine(); // discard input 
         }
        
    } while (valueSet == false);

        System.out.println(item);                   /*  display modifed object  */
        
/**
 *      determine if order is required and if so
 *      prompt user for amount to order and update QOH value
 */
        
        if (item.getQoh() <= item.getRop()){
            System.out.println(item.getRop() - item.getQoh());
            System.out.println("based on your ROP value -  need to reorder " 
                    + (item.getRop() - item.getQoh()) + " more " + item.getName());
            }
        
        int AmountToOrder;

        System.out.println("Enter # of units to buy");
        AmountToOrder = input.nextInt();
        
        double totalCost = item.getSellPrice()*AmountToOrder*(1+SALESTAX);
        item.setQoh(AmountToOrder + item.getQoh());
        System.out.println("Qoh for " + item.getName() + "has been updated to: " + item.getQoh());
        System.out.printf("Total Cost $%.2f%n", totalCost);

    }
       
}
