package edu.depaul.shop.main;
import edu.depaul.shop.ui.UIFormTest;

enum UIFormE {
	NUMBERTEST(new UIFormTest() {
		public boolean run(String input) {
			try {
				Integer.parseInt(input);
				return true;
			} catch (NumberFormatException e) {
				return false;
			}
		}

	}), STRINGTEST(new UIFormTest() {
		public boolean run(String input) {
			return !"".equals(input.trim());
		}
	}), YEARTEST(new UIFormTest() {
		public boolean run(String input) {
			try {
				int i = Integer.parseInt(input);
				return i > 1800 && i < 5000;
			} catch (NumberFormatException e) {
				return false;
			}
		}
	});

	private final UIFormTest UIFT;

	private UIFormE(UIFormTest UIFT) {
		this.UIFT = UIFT;
	}

	public UIFormTest getUIFT() {
		return UIFT;
	}

}
