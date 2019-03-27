package course.oop.controller;

import course.oop.board.ThreeByThreeBoard;
import course.oop.player.HumanPlayer;
import course.oop.player.PlayerList;

public class TTTControllerImpl implements TTTControllerInterface {
	
	HumanPlayer[] players = new HumanPlayer[2];
	PlayerList playerList = new PlayerList();
	ThreeByThreeBoard gameBoard;
	boolean completed = false;

	@Override
	public void startNewGame(int numPlayers, int timeoutInSecs) {
		gameBoard = new ThreeByThreeBoard();
		if (numPlayers == 1) {
			createPlayer("Computer", "COM", 2);
		}
	}

	@Override
	public void createPlayer(String username, String marker, int playerNum) {
		if (playerNum != 1 && playerNum != 2) {
			System.out.println("Player number must be 1 or 2");
			return;
		}
		
		if(playerNum == 1)
			players[0] = playerList.checkAndAdd(username, marker);
		else
			players[1] = playerList.checkAndAdd(username, marker);
	}

	@Override
	public boolean setSelection(int row, int col, int currentPlayer) {
		if(currentPlayer != 1 && currentPlayer != 2) {
			return false;
		}
		return gameBoard.setSelection(row, col, currentPlayer);
	}

	@Override
	public int determineWinner() {
		int winner = gameBoard.determineWinner();
		if (winner > 0 && ! completed) {
			switch(winner) {
			case 1:
				players[0].win();
				players[1].lose();
				playerList.save();
				break;
			case 2:
				players[0].lose();
				players[1].win();
				playerList.save();
				break;
			case 3:
				players[0].tie();
				players[1].tie();
				playerList.save();
				break;
			}
			completed = true;
		}
		return winner;
	}

	@Override
	public String getGameDisplay() {
		
		String boardString = "";
				
		boardString += "   |   |   \n";
		boardString += getSquare(0,0) + "|";
		boardString += getSquare(0,1) + "|";
		boardString += getSquare(0,2) + "\n   |   |   \n-----------\n   |   |   \n";
		boardString += getSquare(1,0) + "|";
		boardString += getSquare(1,1) + "|";
		boardString += getSquare(1,2) + "\n   |   |   \n-----------\n   |   |   \n";
		boardString += getSquare(2,0) + "|";
		boardString += getSquare(2,1) + "|";
		boardString += getSquare(2,2) + "\n   |   |   ";
		boardString += "\n";
		
		return boardString;
	}
	
	//Helper method for getGameDisplay()
	public String getSquare(int row, int col) {
		if(gameBoard.getSquare(row,col) > 0)
			return String.format("%3s", players[gameBoard.getSquare(row,col) - 1].getMarker());
		else
			return "   ";
	}
	
	public String getPlayerName(int playerNum) {
		return players[playerNum-1].getUserName();
	}

}
