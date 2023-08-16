import java.util.Scanner;

public class Main {
    private static Card[][] Board = new Card[4][4];

    private static Card[][] emptyBoard = new Card[4][4];

    public static void main(String[] args) {
        emptyBoard[0][0]=new Card(' ');
        emptyBoard[0][1]=new Card(' ');
        emptyBoard[0][2]=new Card(' ');
        emptyBoard[0][3]=new Card(' ');
        emptyBoard[1][0]=new Card(' ');
        emptyBoard[1][1]=new Card(' ');
        emptyBoard[1][2]=new Card(' ');
        emptyBoard[1][3]=new Card(' ');
        emptyBoard[2][0]=new Card(' ');
        emptyBoard[2][1]=new Card(' ');
        emptyBoard[2][2]=new Card(' ');
        emptyBoard[2][3]=new Card(' ');
        emptyBoard[3][0]=new Card(' ');
        emptyBoard[3][1]=new Card(' ');
        emptyBoard[3][2]=new Card(' ');
        emptyBoard[3][3]=new Card(' ');
        Board[0][0]=new Card('E');
        Board[0][1]=new Card('A');
        Board[0][2]=new Card('D');
        Board[0][3]=new Card('A');
        Board[1][0]=new Card('D');
        Board[1][1]=new Card('T');
        Board[1][2]=new Card('R');
        Board[1][3]=new Card('E');
        Board[2][0]=new Card('T');
        Board[2][1]=new Card('R');
        Board[2][2]=new Card('Y');
        Board[2][3]=new Card('U');
        Board[3][0]=new Card('I');
        Board[3][1]=new Card('U');
        Board[3][2]=new Card('Y');
        Board[3][3]=new Card('I');
        while(isGameEnd()==false){
            printEmptyboard();
            makeGuess();
        }

    }
    public static boolean isGameEnd() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(Board[i][j].isGuess()== false){
                return false;
            }
            }
        }
        System.out.println("You have completely guessed all the cards true");
        return true;
    }
    public static void makeGuess(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your first guess with row and column");
        int r1 = scan.nextInt();
        int j1 = scan.nextInt();
        Board[r1][j1].setGuess(true);
        printBoard();
        System.out.println("Enter your second guess with row and column");
        int r2 = scan.nextInt();
        int j2 = scan.nextInt();
        if (Board[r1][j1].getCardValue() == Board[r2][j2].getCardValue() ){
            Board[r2][j2].setGuess(true);
            printBoard();

            for (int i=0;i<4;i++){
                for (int j=0;j<4; j++){
                    if (Board[i][j].isGuess()) {
                        emptyBoard[i][j].setCardValue(Board[i][j].getCardValue());
                    }
                    }
            }
            System.out.println("your guess is true");

        }else{
            Board[r2][j2].setGuess(true);
            printBoard();
            Board[r1][j1].setGuess(false);
            Board[r2][j2].setGuess(false);
            System.out.println("Wrong guess");
        }


    }
    public static void printEmptyboard(){
        System.out.println("-----------------------------------");

        for (int i = 0; i<4; i++){
            for (int j =0; j<4; j++){
                System.out.print("| " + emptyBoard[i][j].getCardValue() + " | ");
            }
            System.out.println();
        }
        System.out.println("-----------------------------------");
    }
    public static void printBoard(){
        System.out.println("-----------------------------------");

        for (int i = 0; i<4; i++){
            for (int j =0; j<4; j++){
                if (Board[i][j].isGuess()) {
                    System.out.print("| " + Board[i][j].getCardValue() + " | ");
                }else {
                    System.out.print("|   |");
                }
                }
            System.out.println();
        }
        System.out.println("-----------------------------------");
    }
}