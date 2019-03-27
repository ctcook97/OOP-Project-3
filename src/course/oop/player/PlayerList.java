package course.oop.player;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PlayerList {
	
	private ArrayList<HumanPlayer> list;
	
	public PlayerList() {
		list = new ArrayList<HumanPlayer>();
		load();
	}
	
	public HumanPlayer checkAndAdd(String name, String marker) {
		for (HumanPlayer player: list) {
		    if (player.getUserName().contentEquals(name)) {
		    	return player;
		    }
		}
		HumanPlayer newPlayer = new HumanPlayer(name,marker);
		list.add(newPlayer);
		return newPlayer;
	}
	
	public void load() {
		try(BufferedReader bufferedReader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/src/course/oop/player/players.txt"))) {  
		    String line = bufferedReader.readLine();
		    while(line != null) {		        
		        String name = line.substring(0,line.indexOf(";"));
		        line = line.substring(line.indexOf(";") + 3);
		        String marker = line.substring(0,line.indexOf("'"));
		        line = line.substring(line.indexOf("'") + 2);
		        int wins = Integer.parseInt(line.substring(0,line.indexOf("-")));
		        line = line.substring(line.indexOf("-") + 1);
		        int losses = Integer.parseInt(line.substring(0,line.indexOf("-")));
		        line = line.substring(line.indexOf("-") + 1);
		        int ties = Integer.parseInt(line);
		        
		        list.add(new HumanPlayer(name, marker, wins, losses, ties));
		        
		        line = bufferedReader.readLine();
		    }
		    System.out.println(list.size());
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	
	public void save() {
		try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "/src/course/oop/player/players.txt"))) { 
			list.forEach(player -> {
				try {
					bufferedWriter.write(player.toString()+"\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
}
