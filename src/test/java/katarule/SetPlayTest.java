package katarule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class SetPlayTest {

	@Test
	public void testPlay() throws Exception {
		SetPlay sp = new SetPlay();
		sp.initGame();
		assertNotNull(sp.getSet());
		assertEquals(0, sp.getSet().getWinner());
		sp.play();
		assertNotEquals(0, sp.getSet().getWinner());
	}

}
