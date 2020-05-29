package shop.main;

import shop.ui.UI;
import shop.ui.UIFactory;
import shop.data.Data;

public class Main {
  private Main() {}
  public static void main(String[] args) {
	UIFactory ui = new UIFactory();
    Control control = new Control(Data.newInventory(), (UI) ui.start("popup", null, null));
    control.run();
  }  
}
