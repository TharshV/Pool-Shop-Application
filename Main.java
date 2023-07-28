/*
Name: Tharshigan
Purpose: To create the Swim For Less Application 
*/

//Importing classes
import java.util.*;
import java.text.NumberFormat;
import java.io.*;

class Main {

  
  public static double calculateFencingPrice(double p){
    return (10*p);
  }

  public static double calculateConcreteArea(double pool, double walkway){
    return (walkway-pool);
  }

  public static double calculateConcretePrice(double concreteArea){
    return (1.8*concreteArea);
  }

  public static String receiptInfo (double [][] poolInfo, int poolID, double poolLength, double poolWidth){

    //Creating object to use money format
    NumberFormat money = NumberFormat.getCurrencyInstance();

    return "\nPool #"+(poolID+1) + " ("+poolLength+" x "+poolWidth+")\nBase cost of pool: "+money.format(poolInfo [0][2])+"\n\nThe amount of concrete needed is "+ poolInfo[0][0] + " sq.ft\nThe concrete costs 1.80/sq.ft, the total cost for the concrete is " + money.format(poolInfo[1][0]) + "\n\nFence needed is "+ poolInfo[0][1] + " linear ft.\nFence total cost is " + money.format(poolInfo[1][1])+"\n\nSubtotal: "+money.format(poolInfo[1][2]);

  }

  public static void main(String[] args) {
    //Variables
    double inputLength=0, inputWidth=0, totalOrderCost=0;
    String runAgain = "", modifyChoice = "";
    int poolNum=0, poolNumChoice = 0;

    //Creating scanner objects
    Scanner input =  new Scanner (System.in);
    NumberFormat money = NumberFormat.getCurrencyInstance();

    //Arraylists to store the pools, walkways, and arrays storing information about each pool
    ArrayList <Rect> pools = new ArrayList <Rect>();
    ArrayList <Rect> walkways = new ArrayList <Rect>();
    ArrayList <double [][]> infoPools = new ArrayList <double[][]>();

    System.out.println("\nWelcome to the Swim For Less Shop!!!!!\n-------------------------");

    //Do while loop to keep running if user wants to modify another pool
    do{
      //Do while loop to run through the program if user chooses purchase a new pool/modify a previous pool
      do{

        //2D array declared to store the pool's information
        double [][] poolCosts = new double [2][3];
        
        //If statement to create objects if user didn't specify choice to modify
        if (!modifyChoice.equalsIgnoreCase("Yes")&&!modifyChoice.equalsIgnoreCase("Y")){
          //Adding new objects/elements into arraylists (They all have the same index in their related array list)
          pools.add(new Rect());
          walkways.add(new Rect());
          infoPools.add(poolCosts);
        }
        
        //Do while loop to check for valid input 
        do{
          //Try-catch statements to deal with exceptions (specifically for if user inputs a String for an int input)
          try{
            //User enters desired dimensions of pool
            System.out.print("\nPlease enter the length of the pool: ");
            inputLength = input.nextDouble();
            System.out.print("Please enter the width of the pool: ");
            inputWidth = input.nextDouble();
          }

          catch (Exception e){
            //Assigning variables with sentinal values to run through loop again
            System.out.println("\nPlease ensure that you enter the dimensions with numbers.");
            //Input line to prevent input skips
            input.next();
            inputLength = 0;
          }

          try{
            //Accessing the object in the array list then using mutator methods to set fields with user input 
            pools.get(poolNum).setLength(inputLength);
            pools.get(poolNum).setWidth(inputWidth);
          }
          catch (Exception e){
            System.out.println("\nPlease ensure that both the length and width of the pool is greater than 0.");
            inputLength = 0;
          }
        }while (inputLength<=0 || inputWidth<=0);
  
        //Setting the dimensions for the walkway using the mutator methods 
        walkways.get(poolNum).setLength(inputLength+12);
        walkways.get(poolNum).setWidth(inputWidth+12);

        //Setting every element in 2D array with specific information and costs associated with the pool
        poolCosts [0][0] = calculateConcreteArea(pools.get(poolNum).area(), walkways.get(poolNum).area());
        poolCosts [1][0] = calculateConcretePrice(poolCosts[0][0]);
        poolCosts [0][1] = walkways.get(poolNum).perimeter();
        poolCosts [1][1] = calculateFencingPrice(poolCosts[0][1]);

        //If statements to assign the right pool base cost to an index in 2D array depending on pool area
        if (pools.get(poolNum).area()>140){
          poolCosts [0][2] = 39320;
        }

        else{
          poolCosts [0][2] = 20540;
        }

        //Subtotal costs assigned to an index in 2D array by adding all the prices for the pool
        poolCosts [1][2] = poolCosts [1][0] + poolCosts [1][1] + poolCosts [0][2];

        //Changing the 2D array already added in the array list with a new 2D array with all the pool's information/costs
        infoPools.set(poolNum, poolCosts);

        //Outputting receipt by printing the return value of the receipt method
        System.out.println(receiptInfo(poolCosts, poolNum, pools.get(poolNum).getLength(), pools.get(poolNum).getWidth()));

        //If statement to only run the new pool purchase segment if user didn't choose to modify a previous pool
        if (!modifyChoice.equalsIgnoreCase("Yes")&&!modifyChoice.equalsIgnoreCase("Y")){
          //Do while loop to check for invalid input
          do{
            //User enters if they want to purchase another pool
            System.out.print("\nDo you want to purchase another pool? (Y/N): ");
            runAgain = input.next();
          }while (!runAgain.equalsIgnoreCase("Yes")&&!runAgain.equalsIgnoreCase("Y")&&!runAgain.equalsIgnoreCase("No")&&!runAgain.equalsIgnoreCase("N"));

          //Increasing poolNum by 1 in order to ensure a new object is used within the previous lines of code above
          poolNum++; 
        }
        
      }while (runAgain.equalsIgnoreCase("Yes")||runAgain.equalsIgnoreCase("Y"));

      //Do while loop to check for invalid input
      do{
        //User enters whether they want to modify previous pools or not 
        System.out.print("\nDo you want to modify any of the pool dimensions? (Y/N): ");
        modifyChoice = input.next();
      }while(!modifyChoice.equalsIgnoreCase("Yes")&&!modifyChoice.equalsIgnoreCase("Y")&&!modifyChoice.equalsIgnoreCase("No")&&!modifyChoice.equalsIgnoreCase("N"));

      //If statement output the previous pools and option to specify which pool to modify only if they choose the modify option
      if (modifyChoice.equalsIgnoreCase("Yes")||modifyChoice.equalsIgnoreCase("Y")){
        System.out.println("\nSHOPPING CART\n-----------------\n");
        //For loop to output the pool numbers and their respective dimensions
        for (int x=0; x<pools.size(); x++){
          System.out.println("Pool #"+(x+1)+": "+ pools.get(x).getLength()+"ft. x "+pools.get(x).getWidth()+" ft.");
        }

        //Do while loop to check for invalid input
        do{
          //Try-catch statements to handle exceptions (especially for entered string input for int input)
          try{
            //User enters the pool number that they want to modify based off the shopping cart
            System.out.print("\nUsing the pool numbers, indicate which pool you want to change the dimensions for?: ");
          poolNumChoice = input.nextInt();
          }
  
          catch (Exception e){
            System.out.println("\nPlease ensure that you enter your choice using whole numbers.");
            //Setting variable to a sentinal value to force another iteration of the loop
            poolNumChoice = 0;
            input.next();
          }
        }while(poolNumChoice<=0||poolNumChoice>pools.size());

        //Variable assigned with the pool# - 1 in order to call the pools respective object again within the next iteration of the program to ensure that the right object has its fields modified 
        poolNum = poolNumChoice-1;
       
      }

    }while (modifyChoice.equalsIgnoreCase("Yes")||modifyChoice.equalsIgnoreCase("Y"));

    //Try-catch to handle exceptions with the text-file
    try{
      //Creating/adding to the Receipt.txt file
      FileWriter fw = new FileWriter ("Receipt.txt");
      PrintWriter pw = new PrintWriter (fw);

      //Adding receipt header to file
      pw.println("Company: SWIM FOR LESS\nINVOICE\n----------------------------------------------\n");

      //For loop to add the receipt info for each pool in the array list
      for (int x=0; x<pools.size(); x++){
        //Adding receipt info to file by using a method
        pw.println(receiptInfo(infoPools.get(x), x, pools.get(x).getLength(), pools.get(x).getWidth()));
        //Adding total with tax to the receipt for that pool
        pw.println("Total: "+money.format(infoPools.get(x)[1][2]*1.13));
        //Adding each pool's totals to the order's total
        totalOrderCost += (infoPools.get(x)[1][2]*1.13);
        pw.println("------------------------------------------------\n");
      }

      //If statement to apply discount to order if there are 3 or more pools that were purchased
      if (pools.size()>=3){
        //Adding the discount amount applied to the order
        pw.println("Total Order Discount: -"+money.format(totalOrderCost*0.2)+" (20%)");
        //Subtracting 20% of the cost
        totalOrderCost *= 0.8;
      }

      else{
        pw.println("Total Order Discount: N/A");
      }

      //Adding the order total cost to text file
      pw.println("The total order cost for the "+pools.size()+" pools is "+ money.format(totalOrderCost));

      //Closing printWriter object to save all data entered
      pw.close();
    }

    catch (Exception e){
      System.out.println("Invalid Action!");
    }

    //Output confirmation message
    System.out.println("\nORDER CONFIRMED!!!\n");
    System.out.println("Thank you for shopping with SWIM FOR LESS!\nPlease view your purchases and receipt in the Receipt.txt file.");

    //Closing Scanner object
    input.close();
  }
}