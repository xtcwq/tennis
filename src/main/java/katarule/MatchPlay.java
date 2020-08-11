package katarule;

import katamodel.Match;

public class MatchPlay {
	Match match = new Match();

	private void affiche() {
		System.out.println("Match Table: ");
		// TODO
	}

	void play() throws Exception {

		while (match.winner == null) {
			// play
			int gagnant = (Math.random() <= 0.5) ? 1 : 2;
			System.out.println("Joueur : " + gagnant + " gagne ");
			// calcul point

			affiche();
		}
	}
}
