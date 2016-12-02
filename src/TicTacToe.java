import java.util.Scanner;
/**
*
* Name: Laturski, Garrett William
* Teacher: Mr.Hardman
* Assignment #3
* Date Last Modified: 
*
*/

public class TicTacToe
{

	private static char[][] board = new char[3][3];

	public static void main( String[] args )
	{
		Scanner keyboard = new Scanner(System.in);
		String playerOne;
		String playerTwo;
		
		boolean player1Win = false;
		boolean player2Win = false;
		
		int row = -1;
		int collum = -1;

		initBoard();
		displayBoard();
		
		System.out.print("Player one what's your name? ");
		playerOne = keyboard.next();
		
		System.out.println(playerOne + ", you are x");
		
		System.out.print("Player two what's your name? ");
		playerTwo = keyboard.next();
		System.out.println(playerTwo + ", you are o");
		
		while(player1Win == false && player2Win == false && (board[0][0] == ' ' || board[0][1] == ' ' || board [0][2] == ' ' || board [1][0] == ' ' || board [1][1] == ' ' || board [1][2] == ' ' || board [2][0] == ' ' || board [2][1] == ' ' || board [2][2] == ' ')){
			
			while(row == -1){
			
				System.out.print(playerOne + ", please select a row: ");
				row = keyboard.nextInt();
				
				if(row < 0 || row > 2){
					
					System.out.println(" Please chose one of the three rows available.");
					row = -1;
					
				} else if(board[row][0] != ' ' && board[row][1]!= ' ' && board[row][2] != ' '){
					
					System.out.println(" This row is full, please chose another one");
					row = -1;
					
				} else {
					
					while(collum == -1){
					
						System.out.print(playerOne + " please select a collum: ");
						collum = keyboard.nextInt();
					
						if(collum < 0 || collum > 2){
						
							System.out.println(" Please chose one of the three collums available.");
							collum = -1;
						
						} else if(board[row][collum] != ' '){
							
							System.out.println(" This space is full, please chose another one");
							collum = -1;
						
						} else {
						
							board[row][collum] = 'x'; 
						
						}
						
					}
					
				}
			
			}
			
			displayBoard();
			
			player1Win = checkWin();
			
			row = -1;
			collum = -1;
			
			if(player1Win == false && player2Win == false && (board[0][0] == ' ' || board[0][1] == ' ' || board [0][2] == ' ' || board [1][0] == ' ' || board [1][1] == ' ' || board [1][2] == ' ' || board [2][0] == ' ' || board [2][1] == ' ' || board [2][2] == ' ')){
				
				while(row == -1){
					
					System.out.print(playerTwo + ", please select a row: ");
					row = keyboard.nextInt();
					
					if(row < 0 || row > 2){
						
						System.out.println(" Please chose one of the three rows available.");
						row = -1;
						
					} else if(board[row][0] != ' ' && board[row][1]!= ' ' && board[row][2] != ' '){
						
						System.out.println(" This row is full, please chose another one");
						row = -1;
						
					} else {
						
						while(collum == -1){
						
							System.out.println(playerTwo + " please select a collum: ");
							collum = keyboard.nextInt();
						
							if(collum < 0 || collum > 2){
							
								System.out.println(" Please chose one of the three collums available.");
								collum = -1;
							
							} else if(board[row][collum] != ' '){
							
								System.out.println(" This space is full, please chose another one");
								collum = -1;
							
							} else {
							
								board[row][collum] = 'o'; 
							
							}
							
						}
						
					}
				
				}
				
				displayBoard();
				
				player2Win = checkWin();
				
				row = -1;
				collum = -1;
				
			}
			
		}
		
		if(player1Win == true){
			System.out.println(playerOne + " you won!");
		}else if(player2Win == true){
			System.out.println(playerTwo + " you won!");
		}
		
	}

	public static void initBoard()
	{
		// fills up the board with blanks
		for ( int r=0; r<3; r++ )
			for ( int c=0; c<3; c++ )
				board[r][c] = ' ';
	}


	public static void displayBoard()
	{
		System.out.println("  0  " + board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
		System.out.println("    --+-+--");
		System.out.println("  1  " + board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
		System.out.println("    --+-+--");
		System.out.println("  2  " + board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
		System.out.println("     0 1 2 ");
	}


	public static void displayBoard2()
	{
		for ( int r=0; r<3; r++ )
		{
			System.out.print("\t"+r+" ");
			for ( int c=0; c<3; c++ )
			{
				System.out.print( board[r][c] + " " );
			}
			System.out.println();
		}
		
		System.out.println("\t  0 1 2 ");
		
		
		
	}
	
	public static boolean checkWin(){
		
		boolean win = false;
		
		if(board[0][0] == 'x' && board[0][1] == 'x' && board[0][2] == 'x'){
			win = true;
		} else if(board[1][0] == 'x' && board[1][1] == 'x' && board[1][2] == 'x'){
			win = true;
		} else if(board[2][0] == 'x' && board[2][1] == 'x' && board[2][2] == 'x'){
			win = true;
		} else if(board[0][0] == 'x' && board[1][0] == 'x' && board[2][0] == 'x'){
			win = true;
		} else if(board[0][1] == 'x' && board[1][1] == 'x' && board[2][1] == 'x'){
			win = true;
		} else if(board[0][2] == 'x' && board[1][2] == 'x' && board[2][2] == 'x'){
			win = true;
		} else if(board[0][0] == 'x' && board[1][1] == 'x' && board[2][2] == 'x'){
			win = true;
		} else if(board[0][2] == 'x' && board[1][1] == 'x' && board[2][0] == 'x'){
			win = true;
		} else if(board[0][0] == 'o' && board[0][1] == 'o' && board[0][2] == 'o'){
			win = true;
		} else if(board[1][0] == 'o' && board[1][1] == 'o' && board[1][2] == 'o'){
			win = true;
		} else if(board[2][0] == 'o' && board[2][1] == 'o' && board[2][2] == 'o'){
			win = true;
		} else if(board[0][0] == 'o' && board[1][0] == 'o' && board[2][0] == 'o'){
			win = true;
		} else if(board[0][1] == 'o' && board[1][1] == 'o' && board[2][1] == 'o'){
			win = true;
		} else if(board[0][2] == 'o' && board[1][2] == 'o' && board[2][2] == 'o'){
			win = true;
		} else if(board[0][0] == 'o' && board[1][1] == 'o' && board[2][2] == 'o'){
			win = true;
		} else if(board[0][2] == 'o' && board[1][1] == 'o' && board[2][0] == 'o'){
			win = true;
		}
		
		return win;
		
	}
}

