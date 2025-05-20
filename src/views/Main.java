package views;

import controllers.HomeController;

public class Main {
	public static void main(String[] args) {
		Home home = new Home();
		new HomeController(home);
		home.setVisible(true);
	}
}
