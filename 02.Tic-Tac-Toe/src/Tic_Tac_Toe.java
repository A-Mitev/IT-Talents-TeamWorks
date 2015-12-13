import java.util.Scanner;

public class Tic_Tac_Toe {

	static Scanner sc = new Scanner(System.in); // tuk shte inicializiram
												// scanner-a i shte bue bude
												// statichen
	static int row;
	static int col;
	static char[][] board = new char[3][3]; // tuk inicializirame duskata
	static char turn = 'X'; // simvol za suotvetniq igrach
	static int countTurn = 0;
	
	public static void main(String[] args) {
		//zadavame prazni mesta(space-ove) na vsichki elementi na duskata
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = ' ';
			}
		}
		
		// Tozi metod printira daskata i promenite po neq.
		play();
	}

	// shte printiram poletata za igra
	static void printBoard() {
		System.out.print(" ----------- ");
		for (int i = 0; i < 3; i++) {
			System.out.println();
			for (int j = 0; j < 3; j++) {
				if (j == 0) {
					System.out.print("| ");
				}
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();
			System.out.print(" ----------- ");
		}
		System.out.println();
	}

	// Metod za proverka na pobedite - dali ima tri ednakvi na edin red, colona
	// ili diagonal.
	static boolean gameOver(int rMove, int cMove) {
		if (board[0][cMove] == board[1][cMove] && board[0][cMove] == board[2][cMove]) {
			return true;
		}
		if (board[rMove][0] == board[rMove][1] && board[rMove][0] == board[rMove][2]) {
			return true;
		}
		if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[1][1] != ' ') {
			return true;
		}
		//na sledvashtata proverka opravih greshka vmesto board[0][2] == board[2][0], beshe board[0][0] == board[2][0]
		//zaradi koeto davashe nepravomerna pobeda pri dadeni obstoqtelstva
		if (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[1][1] != ' ') {
			return true;
		}
		return false;
	}
	
	//tuk e realizirana samata igra s vsichki proverki za daden igrach i
	// proverki za vuvejdaniqta
	static void play() {

		boolean playing = true; // ako igrata ne za vurshila
		printBoard(); // printira duskata
		while(playing == true){
			
			System.out.println("Please enter a row and column: ");
			row = sc.nextInt() - 1; // vivejdame koordinati
			col = sc.nextInt() - 1; // vivejdame koordinati
				
			checkField(row, col);
			
			 //vuvejda simvola za suotveni igrach
			if(gameOver(row,col) == true){ //proverka dali igrata ne svurshva
				playing = false;
				System.out.println("Game over! Player " + turn + " wins!"); //otpechatva koi e pobeditel
			}
			if(countTurn == 9){
				playing = false;
				System.out.println("It is a draw.");
			}
			printBoard(); // printira vuvedenite promeni po duskata
			if(turn == 'X'){ //smqna na simvola ako e X da stanee O, a ako e O da e stane X
				turn = 'O';
			}else{
				turn = 'X';
			}
			
		}
	}
	
	static void checkField(int r, int c){
		
		if(r < 0 || r > 2){
			row = sc.nextInt() - 1; // vivejdame koordinati
		}
		if(c < 0 || c > 2){
			col = sc.nextInt() - 1; // vivejdame koordinati
		}
		if(board[r][c] != ' '){
			row = sc.nextInt() - 1; // vivejdame koordinati
			col = sc.nextInt() - 1; // vivejdame koordinati
		}
		
		board[row][col] = turn;
		countTurn++;
		
	}
}