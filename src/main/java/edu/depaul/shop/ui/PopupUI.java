package edu.depaul.shop.ui;

import javax.swing.JOptionPane;
//import java.io.IOException;

final class PopupUI implements UI, UIFactoryI {
  PopupUI() {} 

  public void displayMessage(String message) {
    JOptionPane.showMessageDialog(null,message);
  }

  public void displayError(String message) {
    JOptionPane.showMessageDialog(null,message,"Error",JOptionPane.ERROR_MESSAGE);
  }

  public void processMenu(UIFormMenuI menu) {
    StringBuffer b = new StringBuffer();
    b.append(menu.getHeading());
    b.append("\n");
    b.append("Enter choice by number:");
    b.append("\n");

    for (int i = 1; i < menu.size(); i++) {
      b.append("  " + i + ". " + menu.getPrompt(i));
      b.append("\n");
    }

    String response = JOptionPane.showInputDialog(b.toString());
    int selection;
    try {
      selection = Integer.parseInt(response, 10);
      if ((selection < 0) || (selection >= menu.size()))
        selection = 0;
    } catch (NumberFormatException e) {
      selection = 0;
    }

    menu.runAction(selection);
  }

  public String[] processForm(UIFormMenu  form) {
    // TODO  
	  int size = form.size();
	  String[] commands = new String[size];
	  
	  for(int i = 0; i < size ; i++) {
		String input = JOptionPane.showInputDialog(form.getPrompt(i));
		
		if(input == null) {
			return commands;
		}
		if(!form.checkInput(i, input)) {
			displayError("Invalid input try again");
		}else {
			commands[i] = input;
			//i++;
		}
	  }
	  
    return commands;
  }

@Override
public String[] processForm(UIFormMenuI _getVideoForm) {
	// TODO Auto-generated method stub
	return null;
}
}
