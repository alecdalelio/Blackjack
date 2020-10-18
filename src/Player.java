// An implementation of a Blackjack player

public class Player {
    // Player's name
    private String name;

    // Player's hand
    // We would not need to specify # of cards with ArrayList/LinkedList
    private Card[] myHand = new Card[10];

    // Number of cards
    private int numCards;

    // Player constructor
    // playerName = name of the player
    public Player(String playerName) {
        this.name = playerName;

        // set player's hand to empty
        this.emptyHand();
    }

    // Reset player's hand to have no cards
    public void emptyHand() {
        for (int i = 0; i < 10; i++) {
            this.myHand[i] = null;
        } 
        this.numCards = 0;
    }

    // Add a card to the player's hand
    // Is the sum of the new hand below or = to 21?
    public boolean addCard(Card aCard) {
        // print error if we have max number of cards
        if(this.numCards == 10) {
            System.err.printf("%s's hand already has 10 cards; " + "cannot add another\n", this.name);
            System.exit(1);
        }

        // add new card in next slot and increment # of cars
        this.myHand[this.numCards] = aCard;
        this.numCards++;
        
        return (this.getHandSum() <= 21);
    }
    
    // Get the sum of the cards in the player's hand
    public int getHandSum() {

        int handSum = 0;
        int cardNum;
        int numAces = 0;

        // Calculate each card's contribution to hand sum
        for (int i = 0; i < myHand.length; i++) {
            
            // Get the number for the current card
            cardNum = this.myHand[i].getNumber();

            if (cardNum == 1) {
                // If we have Aces...
                numAces++;
                handSum += 11;
            } else if (cardNum > 10) {
                // This means we have hand sum
                handSum += 10;
            } else {
                handSum += cardNum;
            }

        }

        // Convert 11 to 1 as necessary for aces...

        while(numAces != 0 && handSum > 21) {
            handSum -= 10;
            numAces--;
        }
        
        return handSum;
    }

    // Print the cards in the player's hand
    // showFirstCard = do we want to print the first value? Not if it is the dealer...
    public void printHand(boolean showFirstCard) {
        System.out.printf("%s's cards:\n", this.name);
        for (int i = 0; i < this.numCards; i++) {
            if (i == 0 && !showFirstCard) {
                System.out.println("[hidden]");
            } else System.out.printf("%s\n", this.myHand[i].toString());
        }
    }
}