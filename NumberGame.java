import java.util.Scanner;
import java.util.Random;
public class NumberGame {
    public static void main(String args[]){
        int i;
        Random random =new Random();
        int n =random.nextInt(100);
        System.out.println("____________________________NUMBER GAME_________________________");
        for(i =1;i <=3;i++){
        System.out.println(" \n Attempted  " + i);
        Scanner sc = new Scanner(System.in);
        System.out.print("\nYour guess : ");
        int user = sc.nextInt();
        if(user == n){
            System.out.println("\n\n  Congrats You Won...");
            break;
        }
        else if(user > n){
            int diff = user - n;
            if(diff <= 10){
                System.out.println("\n Well Done!! You are close to the guess ");
                System.out.println("\n__________________________________________________________________");
            }
            else{
                System.out.println("\n Oops..You are away from guess..");
                System.out.println("\n__________________________________________________________________");
            }
        }
        else{
            int diff =n- user;
            if(diff <= 10){
                System.out.println("\n Well Done!! You are close to the guess ");
                System.out.println("\n__________________________________________________________________");
            }
            else{
                System.out.println("\n  Oops..You are far away from guess.. ");
                System.out.println("\n__________________________________________________________________");
            }
        }
    }
    int score;
    switch(i){
        case 1:
           score = 100;
           System.out.println("\n===> SCORE = "+ score);
           break;
        case 2:
            score =80;
            System.out.println("\n===> SCORE = "+ score);
            break;
        case 3:
            score =60;
            System.out.println("\n===> SCORE = "+ score);
            break;
        default:
            System.out.println("Your Attempt are overed...");
            System.out.println("\n You Loss the Game.");
            System.out.println("\nThe Number is "+ n);
    }
    System.out.println("__________________________THANK YOU___________________________");

    } 
}
