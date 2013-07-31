package bowling;
import junit.framework.TestCase;


public class BowlingGameTest extends TestCase {
	public void testCreate() throws Exception {
		BowlingGame game = new BowlingGame();
		assertEquals(1, game.getFrame());
		assertEquals(1, game.getChanceToRoll());
		
		
		
		
		
	}
}
