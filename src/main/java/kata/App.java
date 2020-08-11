package kata;

import katarule.GamePlay;

/**
 * Hello world!
 *
 */
public class App {

	GamePlay game = new GamePlay();

	public static void main(String[] args) throws Exception {

		System.out.println("The Mache begin!");
		GamePlay game = new GamePlay();
		game.play();
	}

}
