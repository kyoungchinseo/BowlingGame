package bowling;
import junit.framework.TestCase;
import static bowling.bowlingSymbol.*;

public class BowlingGameTest extends TestCase {
	
	private BowlingGame game; 
	@Override
	protected void setUp() throws Exception {
		game = new BowlingGame();
	}
	
	public void testCreate() throws Exception {
		assertEquals(1, game.getFrame());
		assertEquals(0, game.getChanceToRoll());		
	}
	
	public void testRoll() throws Exception {
		game.roll(NINE);
		game.roll(ONE);
		game.roll(EIGHT);
		game.roll(GUTTER);
		game.roll(TEN);
		game.roll(TEN);
		game.roll(EIGHT);
		game.roll(GUTTER);
		game.roll(TEN);
		game.roll(EIGHT);
		game.roll(ONE);
		game.roll(NINE);
		game.roll(ONE);
		game.roll(EIGHT);
		game.roll(ONE);
		
		
		game.getSymbolList();
	}
}
