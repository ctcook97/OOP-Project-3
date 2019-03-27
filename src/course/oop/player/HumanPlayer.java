package course.oop.player;

public class HumanPlayer {
	
	String userName;
	String marker;
	private int wins; //These will be used in later iterations
	private int losses;
	private int ties;
	
	public HumanPlayer(String Name, String Marker) {
		userName = Name;
		marker = Marker;
		wins = 0;
		losses = 0;
		ties = 0;
	}
	
	public HumanPlayer(String Name, String Marker, int win, int loss, int tie) {
		userName = Name;
		marker = Marker;
		wins = win;
		losses = loss;
		ties = tie;
	}
	
	public void win() {
		wins++;
	}
	
	public void lose() {
		losses++;
	}
	
	public void tie() {
		ties++;
	}
	
	public String toString() {
		return userName + "; '" + marker + "' " + wins + "-" + losses + "-" + ties;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getMarker() {
		return marker;
	}
	
}