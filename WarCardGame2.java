//Henry Sychanthavong
//package cardGame;

import java.util.Scanner;

public class WarCardGame {
    private static LinkList cardList = new LinkList();  // Main deck of cards
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to War!");
        System.out.println("Each player draws a card, higher card wins.");
        
        // Initialize the game using cardgame logic we already have
        String[] args2 = {};
        CardGame.main(args2);  // This loads the deck from cards.txt
        
        System.out.println("\nLet's play War!");
        playGame();
        
        scanner.close();
    }
    
    private static void playGame() {
        int playerScore = 0;
        int opponentScore = 0;
        
        while (true) {
            System.out.print("\nPress Enter to draw a card (or type 'quit' to exit): ");
            String input = scanner.nextLine();
            
            if (input.equalsIgnoreCase("quit")) {
                break;
            }
            
            // Draw cards for player and computer
            Card playerCard = cardList.getFirst();
            Card opponentCard = cardList.getFirst();
            
            if (playerCard == null || opponentCard == null) {
                System.out.println("No more cards in the deck. Game over!");
                break;
            }
            
            // Display the cards
            System.out.println("You drew: " + playerCard);
            System.out.println("Computer drew: " + opponentCard);
            
            // Compare cards and determine winner
            if (playerCard.getCardValue() > opponentCard.getCardValue()) {
                System.out.println("You win this round!");
                playerScore++;
            } else if (opponentCard.getCardValue() > playerCard.getCardValue()) {
                System.out.println("Opponent wins this round!");
                opponentScore++;
            } else {
                System.out.println("It's a tie!");
            }
            
            // Show current score
            System.out.println("SCORE - You: " + playerScore + " | Opponent: " + opponentScore);
        }
        
        // Final result
        System.out.println("\n=== FINAL SCORE ===");
        System.out.println("You: " + playerScore);
        System.out.println("Computer: " + opponentScore);
        
        if (playerScore > opponentScore) {
            System.out.println("Congratulations! You win the game!");
        } else if (opponentScore > playerScore) {
            System.out.println("Opponent wins the game!");
        } else {
            System.out.println("The game ends in a tie!");
        }
    }
}