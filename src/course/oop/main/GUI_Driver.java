package course.oop.main;

import course.oop.controller.TTTControllerImpl;

public class GUI_Driver {
	
	static TTTControllerImpl ticTacToe;
	int turn = 0;
	
	public GUI_Driver() {
		ticTacToe = new TTTControllerImpl();
	}
	
	public void start(int numPlayers, int timeout) {
		ticTacToe.startNewGame(numPlayers, timeout);
	}
	
	public void create1Player(String p1name, String p1marker) {
		ticTacToe.createPlayer(p1name, p1marker, 1);
	}
	
	public void create2Players(String p1name, String p1marker, String p2name, String p2marker) {
		ticTacToe.createPlayer(p1name, p1marker, 1);
		ticTacToe.createPlayer(p2name, p2marker, 2);
	}
	
	public String userMove(int row, int col) {
		if(ticTacToe.setSelection(row, col, (turn%2) + 1)) {
			turn++;
		}
		if (ticTacToe.determineWinner() > 0) {
			return "Game over";
		}
		else
			return "Move";
	}
	
	public static void computerMove(int player) {
		//Keeps randomly picking squares until it finds an open one
		int ran = (int) (Math.random()*9);
		while(! ticTacToe.setSelection(ran/3, ran%3, player)) {
			ran = (int) (Math.random()*9);
		}
		//check if game is over and quit if so
	}

	public String getSquare(int row, int col) {
		return ticTacToe.getSquare(row, col);
	}

}
