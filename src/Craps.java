import java.util.Random;
import java.util.Scanner;

public class Craps {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rnd = new Random();
        String playAgain = "";

        do {
            int die1 = rnd.nextInt(6) + 1;
            int die2 = rnd.nextInt(6) + 1;
            int sum = die1 + die2;

            System.out.println("Initial roll: Die 1 = " + die1 + ", Die 2 = " + die2 + " | Sum = " + sum);

            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Crapped out! You lost.");
            } else if (sum == 7 || sum == 11) {
                System.out.println("Natural! You won.");
            } else {
                int point = sum;
                System.out.println("The sum is now the point: " + point);

                boolean pointOver = false;

                while (!pointOver) {
                    System.out.println("Trying for point...");
                    die1 = rnd.nextInt(6) + 1;
                    die2 = rnd.nextInt(6) + 1;
                    sum = die1 + die2;

                    System.out.println("Roll: Die 1 = " + die1 + ", Die 2 = " + die2 + " | Sum = " + sum);

                    if (sum == 7) {
                        System.out.println("Got a seven and lost.");
                        pointOver = true;
                    } else if (sum == point) {
                        System.out.println("Made point and won.");
                        pointOver = true;
                    }
                }
            }

            System.out.print("Do you want to play again? [Y/N]: ");
            playAgain = in.nextLine();
            System.out.println();

        } while (playAgain.equalsIgnoreCase("Y"));

        System.out.println("Thanks for playing!");
    }
}