/*ASSIGNMENT 2:CAR RENTAL SYSTEM USING OBJECT-ORIENTED PROGRAMMING PRINCIPLES(JAVA)*/
import java.util.Scanner;
public class Rental_system {
   
    //prompting the user to enter his/her logins 
   public static void main(String[] args) {
     String username,password;

     Scanner input = new Scanner(System.in);
     //entering username
     System.out.println("Enter Username:");
     username = input.nextLine();
     //entering password
     System.out.println("Enter Password");
     password = input.nextLine();

     //this is to tell the user to re-enter the name
     String username1;
      do {
        System.out.println("Re-enter username:");
        username1 = input.nextLine();
        if (!username.equals(username1)) {
          System.out.println("THE USERNAME DOESN'T MATCH!!");
        }
      } while (!username.equals(username1));
     //this is to tell the user to re-enter the password
     String password1;
      do {
        System.out.println("Re-enter password:");
        password1=input.nextLine();

        if (!password.equals(password1)) {
          System.out.println("THE PASSWORD DOESN'T MATCH!!");  
        }
      } while (!password.equals(password1));

     //this is to tell the user to re-enter the name
     String username2;
      do {
        System.out.println("Re-enter username2:");
        username2 =input.nextLine();

        if (!username1.equals(username2)) {
          System.out.println("THE USERNAME DOESN'T MATCH!!");  
        }
      } while (!username1.equals(username2));
     //this is to tell the user to re-enter the password
     String password2;
      do {
        System.out.println("Re-enter password2:");
        password2 =input.nextLine();
        if (!password1.equals(password2)) {
          System.out.println("THE PASSWORD DOESN'T MATCH!!");  
        }
      } while (!password1.equals(password2));

      //OUTPUTTING OUR CARS
        System.out.println("AVAILABLE CARS AND PRICING");

         String[][] cars_available/*[][] CAN ALSO BE USED HERE */ = {
              {"Audi Q5", "70000"},
              {"Volvo S60", "50000"},
              {"Mazda CX5", "40000"},
              {"Nissan GTR", "90000"},
              {"Subaru Forester", "9000"}
          };
          for (int i = 0; i < cars_available.length; i++) {
          System.out.println("Car:" +cars_available[i][0] +cars_available[i][1]);
          }
         //Prompting the user to enter his credentials
         //name
         System.out.println("Enter your name:");
         String name =input.nextLine();
         //car to rent
         System.out.println("Car to rent:");
         String car = input.nextLine();

         //CHARGES ACCORDING TO THE DAYS TAKEN 
           System.out.println("CHARGES ACCORDING TO THE DAYS TAKEN ");
           boolean carFound = false;
           int days;
           //days to rent
        
         do {//this is to prompt the user to re-enter the days if he/she enters less than the required days
            System.out.println("Enter Renting days:");
            days = input.nextInt();
            input.nextLine();
            if (days<2) {
             System.out.println("Less RENTING DAYS!! SORRY!!");   
            } 
         } while (days<2);
          
           
          /*  The Integer.parseInt() method in Java is used to 
           convert a string into an integer. Since user inputs
            and data stored in arrays are often in the form of
             strings, you need parseInt()  
           to turn them into numerical values for calculations.*/
           int total=0;
           
           for (int i = 0; i < cars_available.length; i++) {
            if (cars_available[i][0].equalsIgnoreCase(car)) {
                int pricePerDay = Integer.parseInt(cars_available[i][1]);
                total = pricePerDay * days;
                System.out.println("Total charges for " + car + " for " + days + " days: $" + total);
                carFound = true;
                break;
            }
        }
        //the control programm if is taken out of the for loop to avoid it from looping
         if (!carFound) {
        System.out.println("Car not found. Please check the name exactly as shown.");
         }
         
         // CLIENT'S DATA-a collateral factor.

         
          String nationalID;
          do {
            System.out.println("Enter nationalID:");
            nationalID =input.nextLine();

            if (nationalID.length()<10) {
                System.out.println("INVALID INPUT!!");
            }
         } while (nationalID.length()<10);
            
          //RESULT
              System.out.println("RENTAL SUMMARY");
              System.out.println("Enter Username:" +username);
              System.out.println("Enter password:" +password);
             
              //output customers detail
              System.out.println("Name:" +name);
              System.out.println("Car rented:" +car);
              System.out.println("Days:" +days);
              System.out.println("Total: &:" + total);
              System.out.println("NationalID:" +nationalID);
  
        }
             
}

