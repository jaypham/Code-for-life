package javaapplication2;
import java.util.Random;
import java.util.Scanner;
import static javaapplication2.BagelsTest.main;

public class Bagels {
    static Scanner console= new Scanner(System.in);
    {System.out.println("Would you like to read the rules, or start the game? (Enter \"rules\" or \"start\")");
		      System.out.println("Enter \"quit\" if you would like to quit");
    String answer1 = console.next();
		if (answer1.equalsIgnoreCase("rules")){
			rules();
		}if (answer1.equalsIgnoreCase("start")){
			playGame();}
                if (answer1.equalsIgnoreCase("quit")){
                    System.out.println("Aw! You quit tho...");
                    System.exit(0);
                }
    }
        public static void rules() {
            System.out.println("I will think of 3 digit numbers,");
            System.out.println("and what you will do is to guess what the number is.");
            System.out.println("The number that I think of has no repeating digits and");
            System.out.println("start with a 0. Everytime you make a guess, I will tell you if you are close to getting the number");
            System.out.println("The hint will be \"Fermi,\" \"Pico,\" and/or \"Bagels.\"");
            System.out.println("If it prints \"Fermi,\" that means one digit matches and is in the proper place.");
	    System.out.println("If it prints \"Pico,\" that means one digit matches and is NOT in the proper place.");
	    System.out.println("If it prints \"Bagels,\" that means no digits match.");
	    System.out.println("Note: you must only guess 3 digit numbers that do not repeat or start with 0.");
	    System.out.println("Ready to play? (yes/no)");
	    String startYes = console.next();
            
            if (startYes.contains("yes")){
                System.out.println("Let's get started.");
                playGame();
            }
             if (startYes.equalsIgnoreCase("no")){
                System.out.println("Let's go over the rules again");
                rules();
            } 
            
            
        }
   public static void playGame(){
       
       System.out.println("Give it a try...");
       Random ranNum=new Random();
       
       int num = ranNum.nextInt(900)+100;
       int d1=(num/100)%10;
       int d2=(num/100)%10;
       int d3=num%10;
       
       while(d1==d2||d1==d3||d2==d3){
           num=ranNum.nextInt(900)+100;
                d1 = (num / 100) % 10;
                d2 = (num / 10)  % 10;
                d3 = num % 10;
       }
       int count=1;
       int x1=1;
       int x2=1;
       int x3=1;
       runGame(x1,x2,x3,d1,d2,d3,num, count);
   	}
   public static void runGame(int x1, int x2, int x3, int d1, int d2, int d3, int num, int count){
       
       int userGuess=console.nextInt();
       x1= (userGuess/100)%10;
       x2= (userGuess/10)%10;
       x3= userGuess%10;
       
       while(x3==x2 || x3==x1 || x2==x1 || x1==0){
				System.out.println("Invalid, try again");
				userGuess = console.nextInt();
				x1 = (userGuess / 100) % 10;
				x2 = (userGuess / 10)  % 10;
				x3 = userGuess % 10;
   }
   if(userGuess == num){
			System.out.print("Ding Ding Ding!! ");	
			winGame(count);	
		}else if(userGuess != num){
			if(d1 == x1){
				System.out.print("Fermi ");
			}if(d2 == x2){
				System.out.print("Fermi ");
			}if(d3 == x3){
				System.out.print("Fermi ");
			}if(d1 == x2){
				System.out.print("Pico ");
			}if(d1 == x3){
				System.out.print("Pico ");
			}if(d2 == x1){
				System.out.print("Pico ");
			}if(d2 == x3){
				System.out.print("Pico ");
			}if(d3 == x1){
				System.out.print("Pico ");
			}if(d3 == x2){
				System.out.print("Pico ");
			}
                }
   if(d1 != x1 && d1 != x2 && d1 != x3 && d2 != x1 && d2 != x2 && x2 != x3 && d3 != x1 && d3 != x2 && d3 != x3){
			System.out.print("Bagels");
		}
		
		count++;
		System.out.println();
                
                runGame(x1, x2, x3, d1, d2, d3, num, count);
                	
		}				
private static void winGame(int count) {
    
			System.out.println("You got it!");
			System.out.println("You guessed my number in " + count + " turns!");
			System.out.println("Would you like to play again? (yes/no)");
			String response = console.next();
			if (response.equalsIgnoreCase("yes")){
				main(null);
			}else{
				System.out.println("Well ok! Thank you for playing!");

			}
		}
	}
























