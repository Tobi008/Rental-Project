package shop.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import javax.swing.JOptionPane;

final class TextUI implements UI, UIFactoryI {
  final BufferedReader _in;
  final PrintStream _out;

  TextUI() {
    _in = new BufferedReader(new InputStreamReader(System.in));
    _out = System.out;
  }

  public void displayMessage(String message) {
    _out.println(message);
  }

  public void displayError(String message) {
    _out.println(message);
  }

  private String getResponse() {
    String result;
    try {
      result = _in.readLine();
    } catch (IOException e) {
      throw new UIError(); // re-throw UIError
    }
    if (result == null) {
      throw new UIError(); // input closed
    }
    return result;
  }

  public void processMenu(UIFormMenuI menu) {
    _out.println(menu.getHeading());
    _out.println("Enter choice by number:");

    for (int i = 1; i < menu.size(); i++) {
      _out.println("  " + i + ". " + menu.getPrompt(i));
    }

    String response = getResponse();
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

  public String[] processForm(UIFormMenuI form) {
    // TODO  
	  int size = form.size();
	  String[] command = new String[size];
	  
	  for(int i = 0; i < size ; i++) {
		String input = JOptionPane.showInputDialog(form.getPrompt(i));
		
		if(input == null) {
			return command;
		}
		if(!form.checkInput(i, input)) {
			displayError("Invalid input, try again");
		}else {
			command[i] = input;
			//i++;
		}
	  }
	
    return command;
  }
}
