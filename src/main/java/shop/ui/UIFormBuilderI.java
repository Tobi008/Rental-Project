package shop.ui;

public interface UIFormBuilderI {

	UIFormMenu toUIForm(String heading);
	void add(String prompt, UIFormTest test);
}
