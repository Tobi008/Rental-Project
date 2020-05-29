package edu.depaul.shop.ui;

public class UIFactory {
 public UIFactoryI start(String i, String head, Pair[] t) {
	 switch(i){
     case UIFactoryI.popup: 
         return new PopupUI();

     case UIFactoryI.textui:
         return new TextUI();

     case UIFactoryI.UIFormBuilder:
         return new UIFormBuilder();

     case UIFactoryI.UIFormMenu:
         return new UIFormMenu(head, t);

     case UIFactoryI.UIMenuBuilder:
         return new UIMenuBuilder();

     default:
         return null;
 }
 }
}
