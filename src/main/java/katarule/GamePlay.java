package katarule;

public class GamePlay {

	Boolean stop = false;
	MatchPlay match = new MatchPlay();

	public void play() throws Exception {
		match.play();
		afficheTable();
	}

	private void afficheTable() {
		System.out.println("Match Table: ");
	}
}
