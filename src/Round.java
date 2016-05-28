import java.util.ArrayList;

public class Round {

	private Player p1;	//Jogador 1 da rodada
	private Player p2;	//Jogador 2 da rodada
	private Player winner;	//Vencedor da rodada
	private ArrayList<Player> players;	//Todos os jogadores
	
	public Round(ArrayList<Player> players, Player p1, Player p2){
		this.setP1(p1);
		this.setP2(p2);
		this.players = players;
	}
	
	public Player getP1() {
		return p1;
	}
	public void setP1(Player p1) {
		this.p1 = p1;
	}
	public Player getP2() {
		return p2;
	}
	public void setP2(Player p2) {
		this.p2 = p2;
	}
	public Player getWinner() {
		return winner;
	}
	
	//Lógica do jokenpo
	public void startRound(){
		if(p1.getHand().equals(p2.getHand())){
			draw();
			return;
		}
		else if(p1.getHand().equals("scissors") && p2.getHand().equals("rock")	||
				p1.getHand().equals("rock") && p2.getHand().equals("paper")		||
				p1.getHand().equals("paper") && p2.getHand().equals("scissors")){
			setWinner(p2);
			return;
		}
		setWinner(p1);
	}
	
	//Somando os pontos da vitória ao vencedor da rodada
	public void setWinner(Player winner) {
		this.winner = findPlayer(winner);
		
		Integer winnerPoints = this.winner.getPoints();
		Integer winPoints = new Integer(5);
		
		if(this.winner != null){
			this.winner.setPoints(Integer.valueOf(winnerPoints.intValue() + winPoints.intValue()));
		}
	}
	
	//Somando os pontos do empate aos dois jogadores da rodada
	public void draw(){
		Player player1 = findPlayer(this.p1);
		Player player2 = findPlayer(this.p2);
		
		Integer p1Points = player1.getPoints();
		Integer p2Points = player2.getPoints();
		Integer drawPoints = new Integer(2);
		
		player1.setPoints(Integer.valueOf(p1Points.intValue() + drawPoints.intValue()));
		player2.setPoints(Integer.valueOf(p2Points.intValue() + drawPoints.intValue()));
	}
	
	//Encontrando um jogador para modificar seus pontos
	private Player findPlayer(Player player) {
		for(Player p : this.players){
			if(player.getName().equals(p.getName())){
				return p;
			}
		}
		return null;
	}
	
}
