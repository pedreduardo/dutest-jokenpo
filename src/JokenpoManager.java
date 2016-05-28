import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class JokenpoManager {

	private ArrayList<Player> players;	//todos os jogadores
	private FileReader fr;				
	private BufferedReader br;
	private StringBuilder sb;
	private Writer writer;
	String basePath = new File("").getAbsolutePath();
	
	public JokenpoManager(){
		this.players = new ArrayList<>();
	}
	
	public void readRounds() throws FileNotFoundException{
		
		this.fr = new FileReader(basePath + "/src/txt/jokenpo.txt");
		this.br = new BufferedReader(fr);
		
		try {
			
		    this.sb = new StringBuilder();
		    
		    String line = br.readLine();
		    while (line != null){
		    	
		    	String[] terms = line.split("[:|]");
		    	
		    	//Nome do player 1
		    	Player p1 = new Player(terms[0].trim());
		    	//Jogada do player 1
		    	p1.setHand(terms[1].trim());
		    	//Nome do player 2
		    	Player p2 = new Player(terms[2].trim());
		    	//Jogada do player 2
		    	p2.setHand(terms[3].trim());
		    	
		    	//Adicionando jogadores atuais à lista de todos os jogadores
		    	this.addPlayer(p1);
		    	this.addPlayer(p2);
		    	
		    	Round round = new Round(this.players, p1, p2);
		    	round.startRound();
		    	
		    	line = br.readLine();
		    }
		    
		
		} catch (IOException e) {
			e.printStackTrace();
		
		} finally {
		    try {
		    	br.close();
		    } catch (IOException e) {
		    	e.printStackTrace();
		    }
		}
		
		//Ordena os jogadores por pontos
		orderWinners();
	}
	
	public void writeResults(){
		
		try {
		    writer = new BufferedWriter(new OutputStreamWriter(
		          new FileOutputStream(basePath + "/src/txt/result.txt")));
		    
		    writer.write("Classificação do torneio mundial de jokenpo - patrocínio: Epa, seu supervizinho todo dia melhor (?)\n");
		    writer.write("---------------------------------------------\n");
		    for(int i = this.players.size() -1; i >= 0 ; i--){
		    	Player player = this.players.get(i);
		    	writer.write(player.getName() + ": " + player.getPoints() + " pontos\n");
		    }
		    
		    
		} catch (IOException ex) {
		} finally {
		   try {writer.close();
		   } catch (Exception ex) {
			   ex.printStackTrace();
		   }
		}
	}
	
	public void addPlayer(Player p){
		if(!containsPlayerName(this.players, p.getName())){
			this.players.add(p);
		}
	}
	
	private void orderWinners(){
		Collections.sort(this.players, new Comparator<Player>() {
		    @Override
		    public int compare(Player p1, Player p2) {
		        return p1.getPoints().compareTo(p2.getPoints());
		    }
		});
	}
	
	public static boolean containsPlayerName(Collection<Player> players, String name) {
	    for(Player player : players) {
	        if(player.getName().equals(name)) {
	            return true;
	        }
	    }
	    return false;
	}
	
}
