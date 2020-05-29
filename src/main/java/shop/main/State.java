package shop.main;

public enum State {
	EXITED(0), EXIT(1), START(2), NUMSTATES(10);
	private final int value;
	
	private State(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
