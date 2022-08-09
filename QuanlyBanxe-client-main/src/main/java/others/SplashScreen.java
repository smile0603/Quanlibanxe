package others;


import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.SwingConstants;
import javax.swing.JProgressBar;
import javax.swing.border.LineBorder;

public class SplashScreen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JLabel lbLoad;
	public JProgressBar progressBar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					SplashScreen frame = new SplashScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SplashScreen() {
		setUndecorated(true);
		setBounds(100, 100, 795, 443); 
		contentPane = new JPanel();
		
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		
		lbLoad = new JLabel("...");
		lbLoad.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lbLoad.setHorizontalAlignment(SwingConstants.CENTER);
		lbLoad.setForeground(new Color(255, 255, 255));
		lbLoad.setBackground(Color.WHITE);
		lbLoad.setBounds(312, 359, 149, 23);
		contentPane.add(lbLoad);
		
		progressBar = new JProgressBar();
		progressBar.setBackground(new Color(255, 255, 255));
		progressBar.setForeground(Color.ORANGE);
		progressBar.setBounds(0, 385, 795, 21);
		progressBar.setBorder(BorderFactory.createLineBorder(Color.black));
		contentPane.add(progressBar);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 795, 443);
		BufferedImage img = null;
		String img1="img/Main.png";
		try {
		    img = ImageIO.read(new File(img1));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		Image dimg = img.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(),
		        Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(dimg);
		lblNewLabel.setIcon(imageIcon);
		contentPane.add(lblNewLabel);
		
		
	}
}
