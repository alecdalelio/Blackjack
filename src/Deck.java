import java.util.Random;

// An implementation of a deck of cards

public class Deck {
    // The array of cards in the deck, top card = first index
    private Card[] myCards;

    /* Other options:
        private ArrayList<Card> myCards;
        private LinkedList<Card> myCards;
    */
    
    // The number of cards currently in the deck
    private int numCards;

    // Default constructor with one unshuffled deck 
    public Deck() {
        // Call other constructor to create unshuffled deck
        this(1, false);
    }

    /*
        Constructor that defines # of decks / if they're shuffled
        param numDeck = the number of 52-card decks in this deck
        param isShuffled = whether or not the deck is shuffled
    */
    public Deck(int numDecks, boolean isShuffled) {
        this.numCards = numDecks * 52;
        this.myCards = new Card[this.numCards];

        // init card index
        int cardIndex = 0;

        // for each deck
        for(int deck = 0; deck < numDecks; deck++) {

            // for each suit
            for(int suit = 0; suit < 4; suit++) {

                // for each number
                for(int num = 1; num <= 13; num++) {

                    // add a new card to the deck
                    this.myCards[cardIndex] = new Card(Suit.values()[suit], num);
                    cardIndex++;
                }
        }

    }
    // shuffle, if necessary
    if (isShuffled) {
        this.shuffle();
    }

    }

    // Shuffle method, invoke if necessary

        public void shuffle() {
        // init random number generator
        Random rng = new Random();

        // temporary card
        Card temp;

        int j;
        for (int i = 0; i < this.numCards; i++) {

            // get a random card to swap i's value with j
            j = rng.nextInt(this.numCards); 

            // do swap
            temp = this.myCards[i];
            this.myCards[i] = myCards[j];
            this.myCards[j] = temp;
        }   
    }

    // Deal the next card from the top of the deck
    public Card dealNextCard() {
        // Get the top card
        Card top = this.myCards[0];
        
        // Shift subsequent cards to the left by one index
        for (int c = 1; c < this.numCards; c++) {
            this.myCards[c-1] = this.myCards[c];
        }
        this.myCards[this.numCards-1] = null;

        // Decrement the number of cards in our deck
        this.numCards--;

        return top;
    }

    /*
        Print the top cards in the deck
        numToPrint = the number of cards from the top of the deck to print
    */

    public void printDeck(int numToPrint) {
        for (int c = 0; c < numToPrint; c++) {
            System.out.printf("% 3d%d %s\n", c+1, this.numCards, this.myCards[c].toString());
        }
        
        System.out.printf("\t\t[%d other]", 
        this.numCards-numToPrint);
    }

}





