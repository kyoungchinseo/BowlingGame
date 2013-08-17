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
		game.roll(NINE);  	// 1
		game.roll(ONE);   	// 1
		game.roll(EIGHT); 	// 2
		game.roll(GUTTER);	// 2
		game.roll(TEN);   	// 3
		game.roll(TEN);   	// 4
		game.roll(EIGHT); 	// 5
		game.roll(GUTTER);	// 5
		game.roll(TEN);		// 6
		game.roll(EIGHT);	// 7
		game.roll(ONE);		// 7
		game.roll(NINE);	// 8
		game.roll(ONE); 	// 8
		game.roll(EIGHT);	// 9
		game.roll(ONE);		// 9
		game.roll(TEN);		// 10
		game.roll(NINE);	// 10
		game.roll(ONE);		// 10
		
		game.getSymbolList();
	}
}
