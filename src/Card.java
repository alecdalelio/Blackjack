public class Card {
 
    // One of the four valid suits for this card
    private Suit mySuit;

    // The number of this card, where Ace = 1, Jack-King = 11-13
    private int myNumber;

    /*
        param aSuit --- the suit of the card
        param aNumber --- the number of the card
    */

    public Card (Suit aSuit, int aNumber) {
        this.mySuit = aSuit;
        if(aNumber >= 1 && aNumber <= 13) {
        this.myNumber = aNumber;
        } else {
            System.err.println(aNumber + " is not a valid Card number");
            System.exit(1);
        }
    }

    /*
        getNumber() method returns the number of the card
    */

    public int getNumber() {
        return myNumber;
    }

    public String toString() {
        String numString = "Default";

        switch (this.myNumber) {
            case 1:
                numString = "Ace";
                break;
                
            case 2:
                numString = "Two";
                break;

            case 3:
                numString = "Three";
                break;
            
            case 4:
                numString = "Four";
                break;
            
            case 5:
                numString = "Five";
                break;

            case 6:
                numString = "Six";
                break;

            case 7:
                numString = "Seven";
                break;
            
            case 8:
                numString = "Eight";
                break;

            case 9:
                numString = "Nine";
                break;

            case 10:
                numString = "Ten";
                break;

            case 11:
                numString = "Jack";
                break;

            case 12:
                numString = "Queen";
                break;

            case 13:
                numString = "King";
                break;
        
            default:
                numString = "Error";
                break;
        }
        String suitString = mySuit.toString();
        String cardID = numString + " of " + suitString;
        return cardID;
    }

}
