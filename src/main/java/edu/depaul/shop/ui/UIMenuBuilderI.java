package edu.depaul.shop.ui;

public interface UIMenuBuilderI {
	UIFormMenu toUIMenu(String heading);
	void add(String prompt, UIMenuAction action);
}
