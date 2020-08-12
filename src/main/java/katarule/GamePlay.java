package katarule;

import kataenum.GameEnum;
import katamodel.Game;
import katamodel.GameScore;
import katamodel.SetScore;
import katamodel.TieScore;

public class GamePlay {

	public SetScore note(SetScore ss, Game game, int winner) throws Exception {
		// tie break
		SetScore newSs = new SetScore(ss.getP1(), ss.getP2());
		if (ss.getP1() == 6 && ss.getP2() == 6) {
			TieScore tiescore = game.getTies().get(game.getTies().size() - 1);
			TieScore newtiescore = GameRule.tieRule(tiescore, winner);
			game.getTies().add(newtiescore);
			if ((newtiescore.getP1() + newtiescore.getP2()) == 0) {
				if (winner == 1) {
					newSs.setP1(7);
				} else {
					newSs.setP2(7);
				}
				// afficheGameScore(game);
			}
			System.out.println(newtiescore.getP1() + " : " + newtiescore.getP2());
		} else {
			GameScore gs = game.getGames().get(game.getGames().size() - 1);
			GameScore newgs = GameRule.chooseRule(gs, winner);
			game.getGames().add(newgs);
			if (newgs.getP1() == GameEnum.LOVE && newgs.getP2() == GameEnum.LOVE) {
				if (winner == 1) {
					newSs.setP1(ss.getP1() + 1);
				} else {
					newSs.setP2(ss.getP2() + 1);
				}
				// afficheGameScore(game);
			}
			System.out.println(newgs.getP1() + " : " + newgs.getP2());
		}

		return newSs;
	}

	private void afficheGameScore(Game game) {

		for (GameScore element : game.getGames()) {
			// print each element of the array
			System.out.println(element.getP1() + " : " + element.getP2());
		}
	}

}
