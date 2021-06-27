package ControlFlowProject;

import java.util.Random;
import java.util.Scanner;

public class ScannerClass {

	public static void printUserName() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please Enter your name: "); // type a word and hit enter
		String name = scanner.next();
		System.out.println("Hello " + name);
		System.out.println("Continue survey press 'yes' or 'y' ");
		String survey = scanner.next();

		if (survey.equals("yes") || survey.equals("y")) {
			surveyQuestion();
		} else {
			System.out.println("Please return later to complete the survey");
		}

	}

	public static int randomNum() {
		Random rand = new Random(); // instance of random class
		final int upperbound = 65;
		// generate random values from 1-65
		int intRandom = rand.nextInt(upperbound);

		return intRandom;

	}

	public static int firstNum(String pet, int carYear, int luckyNumber) {
		// Find the 3rd letter of their favorite pet. Convert that character value to an
		// integer value.
		int petVal = 0;

		if (pet.length() >= 3) {
			char petNum = pet.charAt(2);
			petVal = Integer.parseInt(String.valueOf(petNum));
		} else {
			petVal = carYear + luckyNumber;
		}

		petVal = inRange(petVal, 1, 65);

		return petVal;
	}

	public static int secondNum(int luckyNum, int rand2) {
		// Use the two digit model year of their car and add their lucky number to it.
		int ball2 = luckyNum - rand2;
		ball2 = inRange(ball2, 1, 65);

		return ball2;
	}

	public static int thirdNum(String actorName) {
		// Use the random number between 1 and 50, subtracting one of the generated
		// random numbers.
		int ball3 =  (int) actorName.charAt(0);
		ball3 = inRange(ball3, 1, 65);

		return ball3;

	}

	public static int forthNum(String actorName) {
		// Convert the first letter of their favorite actor/actress to an integer and
		// use that value.
		int valNum = (int) actorName.charAt(actorName.length()-1);

		valNum = inRange(valNum, 1, 65);

		return valNum;
	}

	public static int fifthNum(int petAge, int carYear) {
		int ball5 = petAge + carYear;
		
		ball5 = inRange(ball5, 1, 65);

		return ball5;
	}

	public static int generateMagicBall(int rand1, int rand2, boolean check, int jersy) {
		int magicBall;
		if (check) {
			magicBall = rand1 * jersy;
		} else {
			magicBall = rand1 * jersy;
		}

		magicBall = inRange(magicBall, 1, 75);

		return magicBall;
	}

	public static int inRange(int value, int low, int high) {
		int width = high - low + 1;

		// This block of code keeps adding by the size of the
		// range until value >= low.
		while (value < low) {
			value += width;
		}

		// And this is a trick to instantly fix the high range.
		return (value - low) % width + low;
	}

	public static void surveyQuestion() {

		boolean playAgain = false;

		do {
			// user loop for some questions
			Scanner userInput = new Scanner(System.in);
			System.out.print("Do you have a red car? (yes, no): ");
			String answer = userInput.next();
			System.out.print("What is your favorite pet name: ");
			String pet = userInput.next();
			System.out.print("What is age of your favorite pet: ");
			int agePet = userInput.nextInt();
			System.out.print("What is your lucky number?: ");
			int luckyNum = userInput.nextInt();
			System.out.print("Do they have a favorite quarterback?");
			String jerseyAns = userInput.next();
			boolean qbExist = false;
			int jerseyNum = 0;
			if (jerseyAns.equals("yes") || jerseyAns.equals("y")) {
				System.out.print("What is their jersey number? ");
				jerseyNum = Integer.parseInt(userInput.nextLine());
				qbExist = true;
			}

			System.out.println("What is two-digit model year of your car? :");
			int carYear = userInput.nextInt();
			while (carYear == 0 || carYear == 00) {
				System.out.println("Please Enter your valid car year ");
			}
			System.out.print("What is the first name of the your favorite actor or actress?");
			String actName = userInput.next();
			System.out.println("Enter a random number between 1 and 50.");
			int random = userInput.nextInt();

			int rand1 = randomNum();
			int rand2 = randomNum();

			int magicBall = generateMagicBall(rand1, rand2, qbExist, jerseyNum);
			int ball1, ball2, ball3, ball4, ball5;

			ball1 = firstNum(pet, carYear, luckyNum);
			ball2 = secondNum(random, rand2);
			ball3 = thirdNum(actName);
			ball4 = forthNum(actName);
			ball5 = fifthNum(agePet, carYear);

			System.out.printf("Lottery numbers: %d, %d, %d, %d, %d Magic ball: %d\n", ball1, ball2, ball3, ball4, ball5,
					magicBall);

			System.out.print("Do you want to play again: ");
			String prompt = userInput.nextLine();
			playAgain = false;

			if (prompt == "yes" || prompt == "y") {
				playAgain = true;
			}
		} while (playAgain);
		System.out.println("Thanks for playing!");
	}

}
