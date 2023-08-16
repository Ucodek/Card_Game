public class Card {
    private char cardValue;
    private boolean guess = false;
    public Card (char cardValue) {
        this.cardValue=cardValue;
    }

    public char getCardValue() {
        return cardValue;
    }

    public void setCardValue(char cardValue) {
        this.cardValue = cardValue;
    }

    public void setGuess(boolean guess) {
        this.guess = guess;
    }
    public boolean isGuess(){
        return guess;
    }
}
