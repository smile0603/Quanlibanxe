package ui;

import javax.swing.*;

import entity.NhaCungCap;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

import java.awt.Color;
import java.awt.event.*;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
public class Help {
	public static void main(String[] args){
		SecurityManager securityManager = System.getSecurityManager();
		if(securityManager == null)
		{
			System.setProperty("java.security.policy", "policy/policy.policy");
			System.setSecurityManager(new SecurityManager());
		}
	JFrame f = new JFrame("Menu");
	f.setVisible(true);
	f.setSize(500, 100);
	f.setDefaultCloseOperation(EXIT_ON_CLOSE);
	JMenuBar menuBar = new JMenuBar();
	f.setJMenuBar(menuBar);	
	JMenu help = new JMenu("Help");
	menuBar.add(help);
	JMenuItem about = new JMenuItem("About");
	about.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			UI_NhanVien u;
			try {
				u = new UI_NhanVien();
				u.setVisible(true);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (NotBoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	});
	
	JMenuItem document = new JMenuItem("Document");
	document.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			About nv;
			try {
				nv = new About();
				nv.setVisible(true);
				
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	});
	
	
	help.add(about);
	help.add(document);
	
	}
}
