import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int score = 0;
        char playAgain;

        do {
            // Generate random number between 1 and 100
            int randomNumber = random.nextInt(100) + 1;

            int attempts = 0;
            int maxAttempts = 5;
            boolean guessedCorrectly = false;

            System.out.println("\n===== NUMBER GUESSING GAME =====");
            System.out.println("Guess a number between 1 and 100");
            System.out.println("You have " + maxAttempts + " attempts.");

            // Loop for guessing
            while (attempts < maxAttempts) {

                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();

                attempts++;

                // Compare guess with random number
                if (guess == randomNumber) {
                    System.out.println("Correct! You guessed the number.");

                    guessedCorrectly = true;

                    // Score calculation
                    score = score + (maxAttempts - attempts + 1);

                    break;
                } 
                else if (guess > randomNumber) {
                    System.out.println("Too high!");
                } 
                else {
                    System.out.println("Too low!");
                }

                System.out.println("Attempts left: " + (maxAttempts - attempts));
            }

            // If user fails to guess
            if (!guessedCorrectly) {
                System.out.println("You lost!");
                System.out.println("The correct number was: " + randomNumber);
            }

            // Display score
            System.out.println("Current Score: " + score);

            // Ask user to play again
            System.out.print("Do you want to play again? (Y/N): ");
            playAgain = sc.next().charAt(0);

        } while (playAgain == 'Y' || playAgain == 'y');

        System.out.println("\nFinal Score: " + score);
        System.out.println("Thanks for playing!");

        sc.close();
    }
}