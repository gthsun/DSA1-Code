//Name: Geethan Sundaram
//Computing ID: mhy9qc@virginia.edu
//HW 4 - Blackjack
//Resources used: https://www.draftkings.com/v2/landingpages-assets/blt02fb52e5e7a6fbb9/blt5f35bb7ea125a73a/626c28083debbf3afdd2c9bc/DESKTOP_blackjackhtp2.png

/*
 * Define a blackjack player by inheriting from the superclass BlackjackPlayer
 *   and implementing the 3 abstract methods.
 */

//A blackjack player that uses the results of previous rounds and information regarding their hand
//and the dealer's cards to make decisions
public class MyBlackjackPlayer extends BlackjackPlayer{

	//Instance variable that stores the total chips before betting from the previous round
	private int prev = getChips();

	//Instance variable that stores the bet from the previous round
	private int prevBet = 1;
	/*
	Bet-deciding algorithm that chooses bet based on events of the previous round
	If previous round was a win, the method returns 10 x the previous round's bet (Very risky!)
	If previous round was a loss, the method returns roughly half of the previous round's bet
	The method accounts for truncation by changing the bet to 1 if it was truncated by the loss logic
	If the player is out of chips, they cannot bet anymore so bet is set to be 0 for all following rounds
	 */
	@Override
	public int getBet() {
		int diff = getChips() - prev;
		int bet = prevBet;
		if(diff > 0){
			bet = (int) (prevBet * 10);
		} else if (diff < 0){
			bet = (int) (prevBet/2);
		}
		if(bet <= 0){bet = 1;}
		if(getChips() == 0){
			bet = 0;
		}
		System.out.println("BET: " +bet);
		prev = getChips();
		prevBet = bet;
		return bet;
	}

	//A method that uses information regarding the dealer's cards and the player's hand in order to decide
	//whether to Stay, Double, or Hit. Check resources for logic that this method follows.
	@Override
	public Move getMove() {
		Card card = dealer.getVisibleCard();

		if(this.handScore() == 9){
			if(card.getRank() <= 3 && card.getRank() >= 6) {return Move.DOUBLE;}
		}
		if(this.handScore() == 10){
			if(card.getRank() <= 2 && card.getRank() >= 9) {return Move.DOUBLE;}
		}
		if(this.handScore() == 11){
			if(card.getRank() <= 2 && card.getRank() >= 10) {return Move.DOUBLE;}
		}
		if(this.handScore() == 12){
			if(card.getRank() <= 4 && card.getRank() >= 6) {return Move.STAY;}
		}
		if(this.handScore() >= 13 && this.handScore() <= 16) {
			if(card.getRank() <= 2 && card.getRank() >= 6) {return Move.STAY;}
		}
		if(this.handScore() >= 17) {return Move.STAY;}
		return Move.HIT;
	}

	//This method is unused
	@Override
	public void handOver(Card[] dealerHand) {
		/**
		 * If you care about looking at the dealer's hand once
		 * the hand is over, then you can do it here. This method
		 * is called automatically after every hand and a copy of the dealer's
		 * final hand is given to you to process. The dealer's hand will be
		 * found in the array of Cards that you pass when the method returns.
		 */
		
	}

	
}
