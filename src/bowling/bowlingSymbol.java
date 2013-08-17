package bowling;

public enum bowlingSymbol {
	STRIKE('X',10),
	SPARE('/',10),
	GUTTER('-',0),
	EMPTY(' ',0),
	ZERO('0',0),
	ONE('1',1),
	TWO('2',2),
	THREE('3',3),
	FOUR('4',4),
	FIVE('5',5),
	SIX('6',6),
	SEVEN('7',7),
	EIGHT('8',8),
	NINE('9',9),
	TEN('X',10);
	private char symbol;
	private int pin;
	bowlingSymbol(char symbol, int pin) {
		this.symbol = symbol;
		this.pin = pin;
	}
	
	char getSymbol() {
		return symbol;
	}

	public int getPin() {
		// TODO Auto-generated method stub
		return pin;
	}
}
