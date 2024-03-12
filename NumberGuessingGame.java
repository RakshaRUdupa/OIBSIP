import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int randomNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;

        int maxAttempts = 10;
        int attempts = 0;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Guess the number between " + lowerBound + " and " + upperBound);

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess == randomNumber) {
                System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                score += maxAttempts - attempts + 1;
                break;
            } else if (userGuess < randomNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }

            System.out.println("Attempts left: " + (maxAttempts - attempts));
        }

        System.out.println("Game over! The correct number was: " + randomNumber);
        System.out.println("Your score: " + score);

        scanner.close();
    }
}
