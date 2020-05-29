package edu.depaul.shop.main;

import edu.depaul.shop.ui.UI;
import edu.depaul.shop.ui.UIFactory;
import edu.depaul.shop.data.Data;

public class Main {
  private Main() {}
  public static void main(String[] args) {
	UIFactory ui = new UIFactory();
    Control control = new Control(Data.newInventory(), (UI) ui.start("popup", null, null));
    control.run();
  }  
}
