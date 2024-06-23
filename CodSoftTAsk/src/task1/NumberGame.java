package task1;

import java.util.Scanner;
import java.util.Random;

public class NumberGame {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		int randomNum = random.nextInt(100);
		int roundPlayed = 0;
		
		while (roundPlayed < 10) {
			roundPlayed++;
			System.out.println("Guess The Number : ");
			int guessNum = sc.nextInt();
			if (randomNum == guessNum) {
				System.out.println("Congratulations..!! You have guessed it correctly..!!");
				System.out.println("Total Rounds Played : "+roundPlayed);
				break;
			}
			else if (randomNum > guessNum)
				System.out.println("Sorry..!! The number you guessed is low");
			else if (randomNum < guessNum)
				System.out.println("Sorry..!! The number you guessed is high");
		}	
			
			if (roundPlayed > 10)
			System.out.println("Game Over..!!");
		
	}
}
