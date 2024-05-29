//Name: Geethan Sundaram
//Computing ID: mhy9qc@virginia.edu
//HW 4 - Blackjack
//Resources used: https://www.draftkings.com/v2/landingpages-assets/blt02fb52e5e7a6fbb9/blt5f35bb7ea125a73a/626c28083debbf3afdd2c9bc/DESKTOP_blackjackhtp2.png

//A stack of more than one deck of cards used in a casino game
public class DeckShoe {

    //An array of decks of cards that comprise this multi-deck.
    private Deck[] decks;

    //An integer that represents the index of the current deck within decks
    private int cur = 0;


    //Constructor: instantiates the number of decks specified and
    //adds them to the list of decks
    public DeckShoe(int numDecks) {
        decks = new Deck[numDecks];
        for(int i = 0; i < decks.length; i++){
            decks[i] = new Deck();
        }
    }


    //Deals the top card from the stack of decks and returns that Card.
    //You can implement this several ways, as long as it correctly
    //deals a card from one of the decks.
    //Important: if you've dealt the last card in all the decks, you'll want
    //to reshuffle all the decks and start over again
    public Card dealTopCard() {
        if(cur < decks.length && decks[cur].cardsLeft() == 0){
            cur++;
        }
        if(cur == decks.length) {
            for(int x = 0; x < decks.length; x++){decks[x].restockDeck();}
            cur = 0;
        }
        return decks[cur].dealTopCard();
    }


    //Reshuffles all of the decks.
    protected void restoreDecks() {
        for(int i = 0; i < decks.length; i++){decks[i].shuffle();}
    }


    //returns the number of cards left to be dealt in the entire stack of cards.
    public int cardsLeft() {
        int num = 0;
        for(int i = 0; i < decks.length; i++){
            num += decks[i].cardsLeft();
        }
        return num;
    }


}
