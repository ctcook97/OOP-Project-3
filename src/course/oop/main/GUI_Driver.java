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
	
	public void createPlayer(String p1name, String p1marker, int playerNum) {
		ticTacToe.createPlayer(p1name, p1marker, playerNum);
	}
	
	public String userMove(int row, int col) {
		if(! (ticTacToe.determineWinner() > 0)) {
			if(ticTacToe.setSelection(row, col, (turn%2) + 1)) {
				turn++;
			}
		}
		switch(ticTacToe.determineWinner()) {
			case 0:
				return ticTacToe.getPlayerName((turn%2) + 1) + "'s move";
			case 1:
				return ticTacToe.getPlayerName(turn%2) + " wins";
			case 2:
				return ticTacToe.getPlayerName(turn%2) + " wins";
			default:
				return "tie game";
		}
	}
	
	public String computerMove() {
		//Keeps randomly picking squares until it finds an open one
		int ran = (int) (Math.random()*9);
		while(! ticTacToe.setSelection(ran/3, ran%3, 2)) {
			ran = (int) (Math.random()*9);
		}
		turn++;
		switch(ticTacToe.determineWinner()) {
		case 0:
			return ran + (ticTacToe.getPlayerName((turn%2) + 1) + "'s move");
		case 2:
			return ran + ("Computer wins");
		default:
			return ran + "tie game";
		}
	}
	
	public boolean isGameOver() {
		return (ticTacToe.determineWinner() > 0);
	}

	public String getSquare(int row, int col) {
		return ticTacToe.getSquare(row, col);
	}

}
