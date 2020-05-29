package edu.depaul.shop.ui;

abstract class CommandUI {
	String heading;
	Pair[] pair;

	public CommandUI(String _heading, Pair[] pair) {
		this.heading = _heading;
		this.pair = pair;
	}

	public int size() {
		return pair.length;
	}

	public String getPrompt(int i) {
		return pair[i].prompt;
	}

	public String getHeading() {
		return heading;
	}
	
}
