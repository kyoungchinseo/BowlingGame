package bowling;

import java.util.ArrayList;

import static bowling.bowlingSymbol.*;

public class BowlingGame {
	
	private int frameNumber  = 1;
	private int chanceToRoll = 0;
	private int numOfRemainedPins    = 10;
	
	private ArrayList<Frame> frame = new ArrayList<Frame>();
	
	BowlingGame() {
		initialize();
	}
	
	private void initialize() {
		for(int i=0;i<10;i++) {
			frame.add(new Frame());
		}
	}

	public int getFrame() {
		return frameNumber;
	}

	public int getChanceToRoll() {
		return chanceToRoll;
	}
	
	public int getNumOfPins() {
		return numOfRemainedPins;
	}

	public void roll(bowlingSymbol pin) {
		chanceToRoll++;
		numOfRemainedPins -= pin.getPin();
		
		if ((chanceToRoll == 1) && (numOfRemainedPins == 0)) { //strike
			frame.get(frameNumber-1).addSymbol(STRIKE);
			frame.get(frameNumber-1).addSymbol(EMPTY);
			
			frameNumber++;
			chanceToRoll = 0;
			numOfRemainedPins = 10;
		} 
		
		if ((chanceToRoll == 1) && (numOfRemainedPins > 0)) {
			frame.get(frameNumber-1).addSymbol(pin);
		}
		
		if ((chanceToRoll == 2) && (numOfRemainedPins == 0)) {
			frame.get(frameNumber-1).addSymbol(SPARE);
			frameNumber++;
			chanceToRoll = 0;
			numOfRemainedPins = 10;
		}
		
		if ((chanceToRoll == 2) && (numOfRemainedPins > 0)) {
			// open frame
			frame.get(frameNumber-1).addSymbol(pin);
			frameNumber++;
			chanceToRoll = 0;
			numOfRemainedPins = 10;
		}
		
		
		
	}

	public void getSymbolList() {
		// TODO Auto-generated method stub
		for(int i=0;i<frameNumber;i++) {
			ArrayList<Character> list = frame.get(i).getSymbolList();
			System.out.println(list);
		}
	}
	
	
	
}
