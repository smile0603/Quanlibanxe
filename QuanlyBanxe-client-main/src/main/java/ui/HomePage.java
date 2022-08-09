package ui;
/*
* (C) Copyright 2020 IUH. All rights reserved.
*
* @author: nhathung
* @date: Nov 27, 2020
* @version: 1.0
*/

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;


import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JTextArea;
import java.awt.SystemColor;
import com.toedter.calendar.JCalendar;


public class HomePage extends JFrame  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lbltieuDe,lblanh;
	private JLabel lbClock;
	private String[] list = {
			"banner1.jpg",
			"banner2.jpg",
			"Banner03.jpg"
	};
	int x = 0;
	@SuppressWarnings("unused")
	private JLabel lblimg;
	int position=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SecurityManager securityManager = System.getSecurityManager();
		if(securityManager == null)
		{
			System.setProperty("java.security.policy", "policy/policy.policy");
			System.setSecurityManager(new SecurityManager());
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
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
	public HomePage() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (InstantiationException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IllegalAccessException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (UnsupportedLookAndFeelException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(100, 100, screen.width, (screen.height-50));

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		lbltieuDe = new JLabel("CHÀO MỪNG ĐẾN VỚI CỬA HÀNG XE MÁY THÀNH NAM");
		lbltieuDe.setBackground(new Color(255, 140, 0));
		lbltieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lbltieuDe.setFont(new Font("Tahoma", Font.BOLD, 35));
		
		lbltieuDe.setBounds(0, 0, 1522, 72);
		
		contentPane.add(lbltieuDe);
		
		JPanel panelthongTin = new JPanel();
		panelthongTin.setBackground(new Color(102, 102, 255));
		panelthongTin.setBounds(10, 545, 1512, 232);
		contentPane.add(panelthongTin);
		panelthongTin.setLayout(null);
		
		JLabel lblCngTy = new JLabel("@ Cửa Hàng Xe Máy Thành Nam");
		lblCngTy.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCngTy.setBounds(33, 92, 254, 20);
		panelthongTin.add(lblCngTy);
		
		JLabel lblNewLabel = new JLabel("Mã số doanh nghiệp: 0108617038. \r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(33, 122, 237, 36);
		panelthongTin.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("GỌI MUA HÀNG, HỖ TRỢ (08:00 - 21:00): 1900.272737");
		lblNewLabel_1.setBounds(33, 169, 294, 14);
		panelthongTin.add(lblNewLabel_1);
		
		JLabel lblThng = new JLabel("THÔNG TIN");
		lblThng.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblThng.setBounds(31, 24, 170, 36);
		panelthongTin.add(lblThng);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(31, 71, 164, 4);
		panelthongTin.add(panel);
		
		JLabel lblLinH = new JLabel("Liên Hệ");
		lblLinH.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblLinH.setBounds(605, 24, 170, 36);
		panelthongTin.add(lblLinH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(551, 71, 229, 4);
		panelthongTin.add(panel_1);
		
		JLabel lblChiNhnhH = new JLabel("Chi nhánh tại TPHCM :");
		lblChiNhnhH.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblChiNhnhH.setBounds(595, 92, 179, 14);
		panelthongTin.add(lblChiNhnhH);
		
		JLabel lblNewLabel_2 = new JLabel("14-16 Quốc Hương, Phường Thảo Điền, Quận 2");
		lblNewLabel_2.setBounds(595, 123, 229, 14);
		panelthongTin.add(lblNewLabel_2);
		
		JLabel lblChiNhnhTi = new JLabel("Chi nhánh tại Hà Nội :");
		lblChiNhnhTi.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblChiNhnhTi.setBounds(595, 148, 179, 19);
		panelthongTin.add(lblChiNhnhTi);
		
		JLabel lblNewLabel_2_1 = new JLabel("Tầng 2, T-231, Aeon Hà Đông");
		lblNewLabel_2_1.setBounds(595, 181, 229, 14);
		panelthongTin.add(lblNewLabel_2_1);
		
		JLabel lbCall = new JLabel("");
		lbCall.setIcon(new ImageIcon(HomePage.class.getResource("/img/Phone-icon.png")));
		lbCall.setBounds(7, 169, 16, 14);
		panelthongTin.add(lbCall);
		
		JLabel lbH = new JLabel("");
		lbH.setIcon(new ImageIcon(HomePage.class.getResource("/img/blue-home-icon.png")));
		lbH.setBounds(565, 122, 20, 15);
		panelthongTin.add(lbH);
		
		JLabel lbh1 = new JLabel("");
		lbh1.setIcon(new ImageIcon(HomePage.class.getResource("/img/blue-home-icon.png")));
		lbh1.setBounds(565, 181, 20, 15);
		panelthongTin.add(lbh1);
		
		JLabel lblTheoDiChng = new JLabel("Theo dõi chúng tôi tại");
		lblTheoDiChng.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTheoDiChng.setBounds(1020, 24, 322, 36);
		panelthongTin.add(lblTheoDiChng);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.BLACK);
		panel_1_1.setBounds(1020, 71, 294, 4);
		panelthongTin.add(panel_1_1);
		
		JLabel lbFb = new JLabel("");
		lbFb.setIcon(new ImageIcon(HomePage.class.getResource("/img/social-facebook-box-blue-icon.png")));
		lbFb.setBounds(1030, 92, 39, 30);
		panelthongTin.add(lbFb);
		
		JLabel lbt = new JLabel("");
		lbt.setIcon(new ImageIcon(HomePage.class.getResource("/img/Twitter-icon.png")));
		lbt.setBounds(1097, 92, 39, 30);
		panelthongTin.add(lbt);
		
		JLabel lbGG = new JLabel("");
		lbGG.setIcon(new ImageIcon(HomePage.class.getResource("/img/google-plus-icon.png")));
		lbGG.setBounds(1159, 92, 39, 30);
		panelthongTin.add(lbGG);
		
		JLabel lbIn = new JLabel("");
		lbIn.setIcon(new ImageIcon(HomePage.class.getResource("/img/Linked-In-icon.png")));
		lbIn.setBounds(1219, 92, 39, 30);
		panelthongTin.add(lbIn);
		
		JLabel lbYt = new JLabel("");
		lbYt.setIcon(new ImageIcon(HomePage.class.getResource("/img/youtube-icon.png")));
		lbYt.setBounds(1275, 92, 39, 30);
		panelthongTin.add(lbYt);
		
	    lblanh = new JLabel("");
	    lblanh.setHorizontalAlignment(SwingConstants.CENTER);
		lblanh.setBounds(49, 111, 673, 386);
		contentPane.add(lblanh);
		
		JTextArea txtrCaHngXe = new JTextArea();
		txtrCaHngXe.setForeground(SystemColor.desktop);
		txtrCaHngXe.setEditable(false);
		txtrCaHngXe.setBackground(SystemColor.control);
		txtrCaHngXe.setFont(new Font("Courier New", Font.PLAIN, 20));
		txtrCaHngXe.setText("Cửa hàng xe máy Thành Nam là một trong các cửa hàng kinh\r\ndoanh xe máy tại TP. Hồ Chí Minh, bên cạnh đó Cửa hàng xe\r\nmáy Thành Nam còn là hệ thống đầu tiên có chuỗi cung ứng \r\nhoàn thiện xe máy chính hãng từ các nhà sản xuất trong và\r\nngoài Việt Nam. ");
		txtrCaHngXe.setBounds(751, 99, 706, 169);
		contentPane.add(txtrCaHngXe);
		
		JLabel lbAnh1 = new JLabel("New label");
		lbAnh1.setBounds(751, 278, 405, 232);
		ImageIcon icon1 = new ImageIcon("img//them.png");
		Image img1 = icon1.getImage();
		Image imgScale1 = img1.getScaledInstance(lbAnh1.getWidth(), lbAnh1.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledIcon1 = new ImageIcon(imgScale1);
		lbAnh1.setIcon(scaledIcon1);
		contentPane.add(lbAnh1);
		
		JCalendar cld = new JCalendar();
		cld.setBounds(1166, 278, 298, 198);
		contentPane.add(cld);
		
		lbClock = new JLabel("New label");
		lbClock.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbClock.setBounds(1166, 479, 335, 38);
		contentPane.add(lbClock);
		clock();
		
		Timer timer = new Timer(1500,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int n = (int) Math.floor(Math.random() * 3);
				String image = list[n];
				ImageIcon icon1 = new ImageIcon("img//"+image+"");
				Image img1 = icon1.getImage();
				Image imgScale1 = img1.getScaledInstance(lblanh.getWidth(), lblanh.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon scaledIcon1 = new ImageIcon(imgScale1);
				lblanh.setIcon(scaledIcon1);

			}
		});
		timer.start();
		
	}
	public void clock() {
	    Thread clock = new Thread() {
	        public void run() {
	            try {
	                while (true) {
	                    Calendar cal = new GregorianCalendar();
	                    int second = cal.get(Calendar.SECOND);
	                    int minute = cal.get(Calendar.MINUTE);
	                    int hour = cal.get(Calendar.HOUR_OF_DAY);
	                    String thu;
	                    int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
	                    if (dayOfWeek == 1) {
	                        thu = "Chủ nhật";
	                    } else {
	                        thu = "Thứ " + Integer.toString(dayOfWeek);
	                    }
	                    int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
	                    int month = cal.get(Calendar.MONTH)+1;
	                    int year = cal.get(Calendar.YEAR);

	                    lbClock.setText(hour + "h:" + minute + "p:" + second +"s "+thu+" Ngày "+dayOfMonth+" Tháng "+month+" Năm "+year);
	                    sleep(1000);
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    };
	    clock.start();
	}
}


