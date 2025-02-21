import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

// Card class to represent each card with rank and suit
class Card {
    private String rank;
    private String suit;

    // Constructor to create a card with a specific rank and suit
    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    // Getters
    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    // Display card details
    public void displayCard() {
        System.out.println("Card: " + rank + " of " + suit);
    }
}

// CardCollection class to manage the collection of cards
class CardCollection {
    private Collection<Card> cards; // Collection to hold all the cards

    // Constructor to initialize the card collection
    public CardCollection() {
        cards = new ArrayList<>();
    }

    // Add a card to the collection
    public void addCard(String rank, String suit) {
        Card card = new Card(rank, suit);
        cards.add(card);
        System.out.println("Card added: " + rank + " of " + suit);
    }

    // Find and display all cards of a given suit
    public void findCardsBySuit(String suit) {
        boolean found = false;
        Iterator<Card> iterator = cards.iterator();
        while (iterator.hasNext()) {
            Card card = iterator.next();
            if (card.getSuit().equalsIgnoreCase(suit)) {
                card.displayCard();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No cards found with suit: " + suit);
        }
    }

    // Display all cards in the collection
    public void displayAllCards() {
        if (cards.isEmpty()) {
            System.out.println("No cards in the collection.");
        } else {
            System.out.println("\nAll Cards in the Collection:");
            for (Card card : cards) {
                card.displayCard();
            }
        }
    }
}

public class CardManager {
    public static void main(String[] args) {
        CardCollection cardCollection = new CardCollection();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // Display menu
            System.out.println("\nCard Management System");
            System.out.println("1. Add a Card");
            System.out.println("2. Find Cards by Suit");
            System.out.println("3. Display All Cards");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1: // Add a card
                    System.out.print("Enter card rank (e.g., 2, 3, 4, ..., King, Ace): ");
                    String rank = scanner.nextLine();
                    System.out.print("Enter card suit (e.g., Hearts, Diamonds, Clubs, Spades): ");
                    String suit = scanner.nextLine();
                    cardCollection.addCard(rank, suit);
                    break;

                case 2: // Find cards by suit
                    System.out.print("Enter suit to search for (e.g., Hearts, Diamonds, Clubs, Spades): ");
                    suit = scanner.nextLine();
                    cardCollection.findCardsBySuit(suit);
                    break;

                case 3: // Display all cards
                    cardCollection.displayAllCards();
                    break;

                case 4: // Exit
                    System.out.println("Exiting the Card Management System...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
