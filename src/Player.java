
public class Player {

	public Player(String name){
		this.setName(name);
	}
	
	private String name;
	private String hand;
	private Integer points = 0;
	
	public String getHand() {
		return hand;
	}
	public void setHand(String hand) {
		this.hand = hand;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}	
	
	
}
