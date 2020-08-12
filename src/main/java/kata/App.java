package kata;

import katarule.SetPlay;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) throws Exception {

		System.out.println("The Match begin!");
		SetPlay match = new SetPlay();
//		if (args.length == 1) {
//			match.setMode(Integer.valueOf(args[0]));// NumberFormatException
//		} else {
//			match.setMode(0);
//		}
		match.initGame();
		match.play();
	}

}
