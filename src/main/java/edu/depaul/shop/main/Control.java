package edu.depaul.shop.main;

import edu.depaul.shop.ui.UIFormBuilderI;
import edu.depaul.shop.ui.UIFormMenuI;
import edu.depaul.shop.data.Inventory;
import edu.depaul.shop.ui.UI;
import edu.depaul.shop.ui.UIError;
import edu.depaul.shop.ui.UIFactory;
import edu.depaul.shop.ui.UIMenuBuilderI;

class Control {
	private UIFormMenuI[] _menus;
	private UIFormMenuI _getVideoForm;
	private UIFormE _numberTest;
	private UIFormE _stringTest;
	private State _state;
	private Inventory _inventory;
	private UI _ui;
	private static UIFactory uiFactory = new UIFactory();

	Control(Inventory inventory, UI ui) {
		_inventory = inventory;
		_ui = ui;
		_menus = new UIFormMenuI[State.NUMSTATES.getValue()];
		_state = State.START;
		addSTART(State.START);
		addEXIT(State.EXIT);
		UIFormE yearTest = UIFormE.YEARTEST;
		_numberTest = UIFormE.NUMBERTEST;
		_stringTest = UIFormE.STRINGTEST;
		UIFormBuilderI f = (UIFormBuilderI) uiFactory.start("UIFB", null, null);
		f.add("Title", _stringTest.getUIFT());
		f.add("Year", yearTest.getUIFT());
		f.add("Director", _stringTest.getUIFT());
		_getVideoForm = f.toUIForm("Enter Video");
		new UIMenuActionE.UIMenuActionEnumConstructor(_ui, _inventory, _getVideoForm, _state);

	}

	void run() {
		try {
			while (_state != State.EXITED) {
				_ui.processMenu(_menus[_state.getValue()]);
				_state = UIMenuActionE.getState();
			}
		} catch (UIError e) {
			_ui.displayError("UI closed"); 
		}
	}

	private void addSTART(State start) {
		UIMenuBuilderI m = (UIMenuBuilderI) uiFactory.start("UIMB", null, null);

		m.add("Default", UIMenuActionE.DEFAULT.getUIMA());
		m.add("Add/Remove copies of a video", UIMenuActionE.ADDREMOVE.getUIMA());
		m.add("Check in a video", UIMenuActionE.CHECKIN.getUIMA());
		m.add("Check out a video", UIMenuActionE.CHECKOUT.getUIMA());
		m.add("Print the inventory", UIMenuActionE.PRINT.getUIMA());
		m.add("Clear the inventory", UIMenuActionE.CLEAR.getUIMA());
		m.add("Undo", UIMenuActionE.UNDO.getUIMA());
		m.add("Redo", UIMenuActionE.REDO.getUIMA());
		m.add("Print top ten all time rentals in order", UIMenuActionE.TOPTEN.getUIMA());
		m.add("Exit", UIMenuActionE.EXIT.getUIMA());
		m.add("Initialize with bogus contents", UIMenuActionE.BOGUS.getUIMA());
		_menus[start.getValue()] = m.toUIMenu("Bob's Video");
	}

	private void addEXIT(State start) {
		UIMenuBuilderI m = (UIMenuBuilderI) uiFactory.start("UIMB", null, null);

		m.add("Default", UIMenuActionE.DEFAULT.getUIMA());
		m.add("Yes", UIMenuActionE.YES.getUIMA());
		m.add("No", UIMenuActionE.NO.getUIMA());

		_menus[start.getValue()] = m.toUIMenu("Are you sure you want to exit?");
	}
  }
