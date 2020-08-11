package katarule;

import katamodel.MatchSet;

public class SetPlay {

	MatchSet set = new MatchSet();

	private void affiche() {
		System.out.println("Match Table: ");
		// TODO
	}

	void play() throws Exception {

		while (set.winner == null) {

			Thread.sleep(2000); // play
			int gagnant = (Math.random() <= 0.5) ? 1 : 2;
			System.out.println("Joueur : " + gagnant + " gagne ");
			// calcul point

			affiche();
		}
	}

}
