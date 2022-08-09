

package ui;
/*
* (C) Copyright 2020 IUH. All rights reserved.
*
* @author: nhathung
* @date: Nov 22, 2020
* @version: 1.0
*/


import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import AppPackage.AnimationClass;
import businesslogic.facade.NhanVienFacade;
import entity.NhanVien;
import entity.TaiKhoan;

import javax.swing.JLabel;
import javax.swing.JOptionPane;


import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;






public class Login extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane; 
	private JLabel lblAnh;
	private JLabel lbltieuDe;
	private JLabel lbluser,lblbackground;
	private JLabel lblpass;
	private JPanel paneluser;
	private JPanel panelpass;
	private JLabel imageuser;
	private JLabel imagepass;
	public static JButton btndangNhap;
	public static JTextField txtuser;
	private JPasswordField txtpass;
	private JLabel lblxoauser,lblxoapass;
	AnimationClass AC = new AnimationClass();
	private JLabel lblanh1,lblanh2;
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
					Login frame = new Login();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws InterruptedException 
	 * @throws NotBoundException 
	 * @throws RemoteException 
	 * @throws MalformedURLException 
	 */
//	
	public Login() throws InterruptedException, MalformedURLException, RemoteException, NotBoundException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/img/secrecy-icon.png")));
		
//		try {
//			ConnectDB.getInstance().connect();
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//Dao_TaiKhoan dao_tk = new Dao_TaiKhoan();
		NhanVienFacade nhanVienFacade = (NhanVienFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/nhanVienFacade");
		setBounds(-10, 0, 1430, 750);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelRight = new JPanel();
		panelRight.setBounds(27, 68, 840, 559);
		contentPane.add(panelRight);
		panelRight.setLayout(null);
		
		lblanh1 = new JLabel("");
		lblanh1.setBounds(0, 0, 840, 561);
		ImageIcon icon1 = new ImageIcon("img1//1.png");
		Image img1 = icon1.getImage();
		Image imgScale1 = img1.getScaledInstance(lblanh1.getWidth(), lblanh1.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledIcon1 = new ImageIcon(imgScale1);
		lblanh1.setIcon(scaledIcon1);
		
		panelRight.add(lblanh1);
		
		lblanh2 = new JLabel("");
		lblanh2.setBounds(840, 11, 840, 550);
		ImageIcon icon2 = new ImageIcon("img1//2.png");
		Image img2 = icon2.getImage();
		Image imgScale2 = img2.getScaledInstance(lblanh2.getWidth(), lblanh2.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledIcon2 = new ImageIcon(imgScale2);
		lblanh2.setIcon(scaledIcon2);

		
		panelRight.add(lblanh2);
		
		JPanel panelLeft = new JPanel();
		panelLeft.setBackground(new Color(255, 255, 255));
		panelLeft.setBounds(877, 68, 507, 559);
		contentPane.add(panelLeft);
		panelLeft.setLayout(null);
		
		lblAnh = new JLabel("");
		lblAnh.setIcon(new ImageIcon(Login.class.getResource("/img/User-Administrator-Red-icon.png")));
		lblAnh.setBounds(186, 80, 172, 136);
		panelLeft.add(lblAnh);
		
		lbltieuDe = new JLabel("Đăng Nhập");
		lbltieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lbltieuDe.setFont(new Font("Tahoma", Font.BOLD, 30));
		lbltieuDe.setBounds(155, 10, 221, 40);
		panelLeft.add(lbltieuDe);
		
		lbluser = new JLabel("Mã nhân viên");
		lbluser.setFont(new Font("Tahoma", Font.BOLD, 25));
		lbluser.setBounds(106, 256, 202, 31);
		panelLeft.add(lbluser);
		
		lblpass = new JLabel("Mật khẩu");
		lblpass.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblpass.setBounds(106, 359, 161, 31);
		panelLeft.add(lblpass);
		
		paneluser = new JPanel();
		paneluser.setBackground(Color.BLACK);
		paneluser.setBounds(106, 333, 283, 4);
		panelLeft.add(paneluser);
		
		panelpass = new JPanel();
		panelpass.setBackground(Color.BLACK);
		panelpass.setBounds(106, 429, 283, 4);
		panelLeft.add(panelpass);
		
		imageuser = new JLabel("");
		imageuser.setIcon(new ImageIcon(Login.class.getResource("/img/User-icon.png")));
		imageuser.setBounds(106, 298, 32, 40);
		panelLeft.add(imageuser);
		
		imagepass = new JLabel("");
		imagepass.setIcon(new ImageIcon(Login.class.getResource("/img/lock-icon.png")));
		imagepass.setBounds(106, 393, 46, 40);
		panelLeft.add(imagepass);
		
		txtuser = new JTextField();
		txtuser.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				if(txtuser.getText().length()>0) {
					lblxoauser.setVisible(true);
				}
				else {
					lblxoauser.setVisible(false);
				}
			}
		});
		txtuser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtuser.setBackground(Color.WHITE);
		txtuser.setBounds(143, 298, 215, 31);
		txtuser.setBorder(null);
		panelLeft.add(txtuser);
		txtuser.setColumns(10);
		
		btndangNhap = new JButton("Đăng nhập");
		btndangNhap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String username = txtuser.getText();
				@SuppressWarnings("deprecation")
				String password = txtpass.getText();
				try {
					NhanVien tk = nhanVienFacade.Login(username, password);
					if(tk != null) {
						//txtuser.setText("");
						//txtpass.setText("");
						//close();

						Menu m = null;
					
						try {
							try {
								m = new Menu();
								m.setExtendedState(JFrame.MAXIMIZED_BOTH);
							} catch (MalformedURLException | NotBoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						m.setVisible(true);
						close();
					}
					else {
						JOptionPane.showMessageDialog(null, "Sai Tài khoản hoặc Mật khẩu ", "Wrong !", JOptionPane.ERROR_MESSAGE, null);
					}
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btndangNhap.setForeground(SystemColor.inactiveCaptionBorder);
		btndangNhap.setBackground(new Color(0, 153, 255));
		btndangNhap.setFont(new Font("Tahoma", Font.BOLD, 25));
		btndangNhap.setBounds(155, 469, 202, 49);
		panelLeft.add(btndangNhap);
		
		txtpass = new JPasswordField();
		txtpass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode()==KeyEvent.VK_ENTER) {
					String username = txtuser.getText();
					@SuppressWarnings("deprecation")
					String password = txtpass.getText();
					try {
						NhanVien tk = nhanVienFacade.Login(username, password);
						if(tk != null) {
							//txtuser.setText("");
							//txtpass.setText("");
							//close();
							Menu m = null;
							try {
								try {
									m = new Menu();
									m.setExtendedState(JFrame.MAXIMIZED_BOTH);
								} catch (MalformedURLException | NotBoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							m.setVisible(true);
							close();
						}
						else {
							JOptionPane.showMessageDialog(null, "Mật khẩu không hợp lệ ", "Wrong !", JOptionPane.ERROR_MESSAGE, null);
						}
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
			@SuppressWarnings("deprecation")
			@Override
			public void keyReleased(KeyEvent e) {
				if(txtpass.getText().length()>0) {
					lblxoapass.setVisible(true);
				}
				else {
					lblxoapass.setVisible(false);
				}
			}
		});
		txtpass.setBounds(146, 398, 215, 31);
		txtpass.setBorder(null);
		
		panelLeft.add(txtpass);
		
		lblxoauser = new JLabel("");
		
		lblxoauser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtuser.setText("");
				txtuser.requestFocus();
				lblxoauser.setVisible(false);
			}
		});
		lblxoauser.setIcon(new ImageIcon(Login.class.getResource("/img/delete-1-icon.png")));
		lblxoauser.setBounds(372, 315, 17, 16);
		lblxoauser.setVisible(false);
		panelLeft.add(lblxoauser);
		
		lblxoapass = new JLabel("");
		
		lblxoapass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtpass.setText("");
				txtpass.requestFocus();
				lblxoapass.setVisible(false);
			}
		});
		lblxoapass.setIcon(new ImageIcon(Login.class.getResource("/img/delete-1-icon.png")));
		lblxoapass.setBounds(371, 410, 17, 16);
		lblxoapass.setVisible(false);
		panelLeft.add(lblxoapass);
		
		
//		BufferedImage img = null;
//		try {
//		    img = ImageIO.read(new File("/img1/Banner_CB300R-1024x453.jpg"));
//		} catch (IOException e) {
//		    e.printStackTrace();
//		}
//		
		
		lblbackground = new JLabel("");
		lblbackground.setBounds(0, 0, 1416, 711);
		ImageIcon icon = new ImageIcon("src/img1/dark.png");
		Image img = icon.getImage();
		Image imgScale = img.getScaledInstance(lblbackground.getWidth(), lblbackground.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(imgScale);
		lblbackground.setIcon(scaledIcon);
		//lblbackground.setIcon(new ImageIcon(Login.class.getResource("/img1/Banner_CB300R-1024x453.jpg")));
		contentPane.add(lblbackground);
		slideshow();
	}
	private void close() {
		WindowEvent winClosing = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosing);
	}
	public void slideshow() {
		new Thread() {
			int count;
			public void run() {
				try {
					while(true)
					{
						switch(count)
						{
							case 0:
								
								Thread.sleep(3000);
								AC.jLabelXLeft(0, -840, 5, 5, lblanh1);
								AC.jLabelXLeft(840, 0, 5, 5, lblanh2);
						
								count = 1;
								break;
							case 1:
								
								Thread.sleep(3000);
								AC.jLabelXRight(-840, 0, 5, 5, lblanh1);
								AC.jLabelXRight(0,840, 5, 5, lblanh2);
								
								count = 2;
								break;	
							case 2:
								
								Thread.sleep(3000);
								AC.jLabelXLeft(0, -840, 5, 5, lblanh1);
								AC.jLabelXLeft(840, 0, 5, 5, lblanh2);
								
								count = 3;
								break;		
							case 3:
								
								Thread.sleep(3000);
								AC.jLabelXRight(-840, 0, 5, 5, lblanh1);
								AC.jLabelXRight(0,840, 5, 5, lblanh2);
								
								count = 0;
								break;			
						}
					}
				}catch(Exception e) {
					
				}
			}
		}.start();
		txtuser.setText("NV_0001");
		txtpass.setText("111111");
	}
	
}


