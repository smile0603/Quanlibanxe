package main;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;

import others.SplashScreen;
import ui.Login;
import ui.Menu;

public class Test {
	@SuppressWarnings("unused")
	private static Menu m;

	public static void main(String[] args) throws InterruptedException, SQLException, MalformedURLException, RemoteException, NotBoundException {
		SplashScreen slScreen= new SplashScreen();
		slScreen.setVisible(true);
		slScreen.setLocationRelativeTo(null);
		Login lg = new Login();
		
		m = new Menu();
		for (int i = 0; i < 101; i++) {
			Thread.sleep(15);
			slScreen.lbLoad.setText("Đang tải "+Integer.toString(i)+"%");
			slScreen.progressBar.setValue(i);
			  
			if(i==100) {
				slScreen.setVisible(false);
				lg.setVisible(true);
				//m.setVisible(true);
				//m.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		}
	}
}
