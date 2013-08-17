package bowling;

import java.util.ArrayList;


public class Frame {
	
	private int score;
	private ArrayList<Character> symbol = new ArrayList<Character>();
	
	Frame() {
		
	}
	
	public void addSymbol(bowlingSymbol symbol) {
		this.symbol.add(symbol.getSymbol());
	}
	
	ArrayList<Character> getSymbolList() {
		return symbol;
	}
	
	int getScore() {
		return score;
	}
	
	
}
