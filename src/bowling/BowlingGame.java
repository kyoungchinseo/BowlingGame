package bowling;

import java.util.ArrayList;

import static bowling.bowlingSymbol.*;

public class BowlingGame {
	
	private int frameNumber  = 1;
	private int chanceToRoll = 0;
	private int numOfRemainedPins    = 10;
	private int numRemainedChance = 3;  // for last frame (10 frame)
	private boolean endOfGame = false;
	
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
		if (endOfGame) {
			return;
		}
 		if (frameNumber != 10) {
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
 		} else { // last frame (10 frame)
 			if (chanceToRoll == 1) {
 				if (numOfRemainedPins == 0) { // first chance and strike
 					frame.get(frameNumber-1).addSymbol(STRIKE);  
 					numOfRemainedPins = 10;
 					numRemainedChance = 2;
 				} else { // open frame > just one more chance to roll
 					frame.get(frameNumber-1).addSymbol(pin);
 					numRemainedChance = 1;
 				}
 			} else if (chanceToRoll == 2) {
 				if (numOfRemainedPins == 0) { // spare you have additional chance
 					if (pin.getPin() == 10) {
 						frame.get(frameNumber-1).addSymbol(STRIKE);
 					} else {
 						frame.get(frameNumber-1).addSymbol(SPARE);
 					}
 					numOfRemainedPins = 10;
 				} else { // open, there is no bonus shoot (end of this game)
 					frame.get(frameNumber-1).addSymbol(pin);
 					if (numRemainedChance == 1) { // first frame is STRIKE, you have one more chance
	 					chanceToRoll = 0;
	 					numOfRemainedPins = 10;
	 					endOfGame = true;
 					}
 				}
 			} else if (chanceToRoll == 3) {
 				if (numOfRemainedPins == 0) {
 					if (pin.getPin() == 10) {
 						frame.get(frameNumber-1).addSymbol(STRIKE);
 					} else {
 						frame.get(frameNumber-1).addSymbol(SPARE);
 					}
 					System.out.println("Spare!!!");
 					numOfRemainedPins = 10;
 				} else {
 					System.out.println("Hello");
 					frame.get(frameNumber-1).addSymbol(pin);
 					chanceToRoll = 0;
 					numOfRemainedPins = 10;
 					endOfGame = true;
 				}
 			}
 		}
		
		
	}

	public void getSymbolList() {
		// TODO Auto-generated method stub
		for(int i=0;i<frameNumber;i++) {
			ArrayList<Character> list = frame.get(i).getSymbolList();
			System.out.println("Frame ("+String.valueOf(i+1)+") : "+list);
		}
	}
	
	
	
}
