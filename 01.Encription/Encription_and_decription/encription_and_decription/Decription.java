package encription_and_decription;

import java.util.Scanner;

public class Decription {
	
	static Scanner sc = new Scanner(System.in);
	// vuvejdame string-a za dekriptirane
	static String secret = sc.nextLine();
	// suzdavame vtori string sus StringBuildera
	static StringBuilder decrypted;
	
	public static void main(String[] args) {
			
		// qdosah se na ogranicheniata na samata matrica za kripirane 
		// i q razshirih da raboti i za celi izrecheniq
		// kato istinska programa za kriptirane
		// izvinqvam se che prestupih pravilata
		char[][] keyTable = {
				{'A', 'T', 'O', 'F', 'J', '9', 'd', ' '},
				{'N', 'E', 'K', 'W', 'R', '7', 's', '.'},
				{'I', 'S', 'D', 'H', 'Y', '5', 'i', 'z'},
				{'X', 'P', 'L', 'U', 'B', '3', 'r', 'q'},
				{'C', 'G', 'V', 'M', 'Q', '1', 'w', 'm'},
				{'0', '2', '4', '6', '8', 'Z', 'k', 'v'},
				{'a', 't', 'o', 'f', 'j', 'n', 'e', 'g'},
				{'h', 'y', 'x', 'p', 'l', 'u', 'b', 'c'}
		};
		
		// pravim string chrez StringBuilder s duljinata na purvia string i negovite
		// simvoli za da mojem da gi promenqme
		decrypted = new StringBuilder(secret);
		// zadavame purvata pozicia
		int letterPosition = 0;
		// dekriptirame
		decrypt(keyTable, secret, letterPosition);
		// izvejdame rezultata
		System.out.println(decrypted);
		
	}
	
	static void decrypt(char[][] keyTable, String secret, int letterPosition){
		//proverka za poziciata ako e po-golqma ot predposlednata pozicia
		//vrushta spira
		if(letterPosition > secret.length() - 2){
			return;
		}
		// prisvoqvane za po-lesna rabota s duljinata na tablicata
		int length = keyTable.length;
		// namirane na koordinatite za red i kolona na purvata bukva
		int letter1row = getRowPosition(keyTable, secret.charAt(letterPosition));
		int letter1col = getColPosition(keyTable, secret.charAt(letterPosition));
		// namirane na koordinatite za red i kolona na vtorata bukva
		int letter2row = getRowPosition(keyTable, secret.charAt(letterPosition + 1));
		int letter2col = getColPosition(keyTable, secret.charAt(letterPosition + 1));
		// suvpadat po red
		if(letter1row == letter2row){
			
			letter1col = equalOnRowOrCol(length,letter1col);
			letter2col = equalOnRowOrCol(length,letter2col);
			
		}
		// ako suvpadat po kolona
		if(letter1col == letter2col){
			
			letter1row = equalOnRowOrCol(length,letter1row);
			letter2row = equalOnRowOrCol(length,letter2row);
			
		}
		
		// ako ne se zasichat nito po kolona nito po red
		if(letter1row != letter2row && letter1col != letter2col){
			
			int diff = letter1col;
			letter1col = letter2col;
			letter2col = diff;
			
		}
		// zamenqne na starite simvoli s novite v novia string koito shte vurnem
		decrypted.setCharAt(letterPosition, keyTable[letter1row][letter1col]);
		decrypted.setCharAt((letterPosition + 1), keyTable[letter2row][letter2col]);
			
		// rekursia za sledvashtite dva simvola
		decrypt(keyTable, secret, letterPosition + 2);
		
	}
	
	//ako sa endakvi po kolona ili red na kude da mesti
		static int equalOnRowOrCol(int length, int letterPosition){
			// ako poziciata pri mestene s dve e po-malka ot 0
			// vrushame duljinata na tablicata -2
			if(letterPosition == 0){
				
				return length - 2;
			}
			// ako pri mestene s dve e ravna na 0
			// vrushtame duljinata na tablicata - 1
			else if(letterPosition == 1){
				
				return length - 1;
			}
			// ako ne izliza po-malka ili ravna ot 0
			// vrushtame si poziciata uvelichena s 2
			else{
				
				return letterPosition - 2;
			}
		}
		
		// namira posiciite na koito se namirat bukvite za red
		// vzima pozicia na reda za suotvetanta bukva
		static int getRowPosition(char[][] keyTable, char letter){
			// inicializirame promenliva koqto da vurnem
			int r = 0;
			// namirane na reda
			here: for(int row = 0; row < keyTable.length; row++){
				
				for(int col = 0; col < keyTable[0].length; col++){
					
					if(letter == keyTable[row][col]){
						
						r = row;
						break here;
					}
				}
			}
			// vrushtame reda
			return r;
		}
		
		// namira posiciite na koito se namirat bukvite za kolona
		// vizma poziciata na colonata za suotvetata bukva
		static int getColPosition(char[][] keyTable, char letter){
			// inicializirame promenliva koqto da vurnem
			int c = 0;
			// namira kolonata
			here: for(int row = 0; row < keyTable.length; row++){
				
				for(int col = 0; col < keyTable[0].length; col++){
					
					if(letter == keyTable[row][col]){
						
						c = col;
						break here;
					}
				}
			}
			// vrushtame kolonata
			return c;
		}
	
}
