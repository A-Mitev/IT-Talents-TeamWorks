package horse_move;

import java.util.Scanner;

public class Horse_Move {
	
	static Scanner sc = new Scanner(System.in);
	
	static int firstRow; //nachalen red ot koito trugva konq
	static int firstCol; //nachalna kolona ot koqto trugva konq
	static int row; //inicializirame granici na duskata po
	static int col; //koqto shte se dviji konq
	static char[][] board; //duska
	static char horseFirstPosition = 'k'; //simvol kudeto e stupval konq
	
	public static void main(String[] args) {
		//zadavame promenlivite na granicite
		do{
			//duskata vinagi trqbva da e s red ili kolata ravna na 3 i 
			//dvete po-golqmi ot 1 za da imame pone edin hod na konq
			System.out.print("Enter a row length: ");
			row = sc.nextInt();
			if(row == 2){
				do{
					System.out.print("Enter a col length: ");
					col = sc.nextInt();
				}while(col < row + 1);//ako reda e raven na dve
			}else{
				do{
					System.out.print("Enter a col length: ");
					col = sc.nextInt();
				}while(col < 2);//ako reda e po-golqm ot dve
			}
		}while(row < 2);//reda trqbva da e vinagi po-golqm or 1
		board = new char[row][col];//zadavat se granicite na duskata
		//zadavat se simvolite vutre v poletata
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				board[i][j] = '_';
			}
		}
		//printirame praznata duska
		printBoard();
		//zadavame purvata pozicia za red
		do{
			System.out.print("Enter begining row: ");
			firstRow = sc.nextInt();
		}while(firstRow < 0 || firstRow > board.length - 1);
		//zadavame purvata pozicia za kolona
		do{
			System.out.print("Enter begining col: ");
			firstCol = sc.nextInt();
		}while(firstCol < 0 || firstCol > board[0].length - 1);
		//proverka za hodovete na konq
		horseMove(board, firstRow, firstCol);
		//printirame novata duska
		printBoard();
		
	}
	
	//tozi meto izprintira duskata
	static void printBoard() {
		//printira gornata granica
		System.out.print(" ");
		for(int j = 0; j < col; j++){
			
			System.out.print("=====");
			
		}
		System.out.println();
		//printira poletata
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (j == 0) {
					System.out.print("|| ");
				}
				System.out.print(board[i][j] + " || ");
			}
			System.out.println();
		}
		//printira dolnata granica
		System.out.print(" ");
		for(int j = 0; j < col; j++){
			
			System.out.print("=====");
			
		}
		System.out.println();
	}
	
	static void horseMove(char[][] board, int r, int c){
		//tuk pravim proverka dali ne izliza izvun granicite na redovete
		if(r < 0 || r > row - 1){
			return;
		}
		//proverka dali ne izliza izvun granicite na kolonite
		if(c < 0 || c > col - 1){
			return;
		}
		//proverka dali ne e zapulneno mqstoto veche
		if(board[r][c] != '_'){
			return;
		}
		board[r][c] = horseFirstPosition;
		//tuk v rekursia izvikvame za vsqka pozicia vuzmojnite hodove na konq
		horseMove(board, r + 1, c - 2);
		horseMove(board, r + 2, c - 1);
		horseMove(board, r + 2, c + 1);
		horseMove(board, r + 1, c + 2);
		horseMove(board, r - 1, c + 2);
		horseMove(board, r - 2, c + 1);
		horseMove(board, r - 2, c - 1);
		horseMove(board, r - 1, c - 2);
	}
	
}