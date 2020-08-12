package katarule;

import katamodel.SetGame;

public class SetPlay {

	SetGame set = new SetGame();

	private void affiche() {
		System.out.println("Match Table: ");
		// TODO
	}

	void play() throws Exception {

		while (set.getWinner() == null) {

			Thread.sleep(2000); // play
			int gagnant = (Math.random() <= 0.5) ? 1 : 2;
			System.out.println("Joueur : " + gagnant + " gagne ");
			// calcul point

			affiche();
		}
	}

}
