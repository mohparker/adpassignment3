
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Locale;



/**
 *
 * @author Raaziq 219154554
 */
public class FHandling {
         private ArrayList<Customer> customerArray = new ArrayList<>();
    private ArrayList<Supplier> supplierArray = new ArrayList<>();
    private ListIterator<Customer> nlistIterator; 
    ObjectInputStream objectInputStream;

    
    //Opens the file to read from.
    public void openFile() {
        try{
 
             objectInputStream = new ObjectInputStream(new FileInputStream("stakeholder.ser"));
         } 
         catch(IOException e) {
             System.out.println("Could not open file!" + e.getMessage());
         }           
    }
    
    //Close files
    public void closeFile() {
        try{
           
            objectInputStream.close();
        }
        catch(IOException e) {
            System.out.println("Could not close file!!" + e.getMessage());

        }
    
    }
    
    //Read Files
    public void readFile() {
        Object object;
            Supplier supplier;
        try{
           
            while (true){
                for (int i = 0; i <10; i++) {
                object = objectInputStream.readObject();
                
                
                if (object.getClass() == Supplier.class){
                    
                    supplier = (Supplier) object;
                    supplier.getName();
                    supplier.getProductDescription();
                    supplier.getProductType();
                    supplier.getStHolderId();
                    System.out.println(supplier + "\n");
            }   
                  else {
                    customer = (Customer) object;
                    customerArray.add(customer);
                    
                    nlistIterator=customerArray.listIterator();
                  
            
                    customer=nlistIterator.next();
                    System.out.println(customerArray);
                    ++i;
                }
        } 
                
         
            }
            private String formatDate(String dob){ 
            
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.ENGLISH);
                    
            
         LocalDate parseDob = LocalDate.parse(dob); 

        return parseDob.format(formatter);
            }
            
            
            private int calculateAge(String dob){

        LocalDate pareeDob LocalDate.parse(dob); 

        int dobYear - parseDob.getYear();




        ZonedDateTime todayDate = ZonedDateTime.nov();

         int currentYear = todayDate.getYear();


         return currentYear - dobYear;
            }


      private int canRent(){

        int canRent = 0;

         for (int i = 0; i < customersList().aize(); i++)
         {


         if (customersList().get(i).getCanRent()){
                    canRent += 1;
         }
         }

       return canRent;

      }


     private int canNotRent()
     {
         int canNotRent=0; 

        for (int i = 0; i < customersList().size() ; i++){

          if (!customersList().get(i).getCanRent() )
          {
              canNotRent +=1;
          }
          }
         return canNotRent;
     }
           
            
            }
        catch(IOException | ClassNotFoundException e) {
            System.out.println("Could not find file!!" + e.getMessage());

        }
    }
     public static void main(String args[])  {
FHandling obj=new FHandling(); 
obj.openFile();
obj.readFile();
obj.closeFile();
     }
}
