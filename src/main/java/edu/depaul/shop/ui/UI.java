package edu.depaul.shop.ui;

public interface UI {
  public void processMenu(UIFormMenuI _menus);
  public String[] processForm(UIFormMenuI _getVideoForm);
  public void displayMessage(String message);
  public void displayError(String message);
}
