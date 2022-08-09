package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class UI_Color extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
					UI_Color frame = new UI_Color();
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
	public UI_Color() {
		dispose();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 673, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JTextArea txtrAds = new JTextArea();
		txtrAds.setEditable(false);
		txtrAds.setForeground(java.awt.Color.BLACK);
		txtrAds.setLineWrap(true);
		txtrAds.setToolTipText("");
		txtrAds.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtrAds.setBounds(10, 35, 437, 35);
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "B\u1EA3ng ch\u1ECDn m\u00E0u", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 104, 639, 350);
		contentPane.add(panel);
		panel.setLayout(null);
		JButton btnDo = new JButton("Đỏ");
		btnDo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtrAds.getText().length()>0) {
					txtrAds.append(" - Đỏ");
				}
				else {
					txtrAds.append("Đỏ");
				}
			}
		});
		
		
		btnDo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDo.setBackground(java.awt.Color.RED);
		btnDo.setBounds(25, 35, 113, 66);
		panel.add(btnDo);
		
		JButton btnXanhL = new JButton("Xanh Lá");
		btnXanhL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtrAds.getText().length()>0) {
					txtrAds.append(" - Xanh lá");
				}
				else {
					txtrAds.append("Xanh lá");
				}
			}
		});
		btnXanhL.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnXanhL.setBackground(java.awt.Color.GREEN);
		btnXanhL.setBounds(189, 35, 117, 66);
		panel.add(btnXanhL);
		
		JButton btnXanhDng = new JButton("Xanh Dương ");
		btnXanhDng.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtrAds.getText().length()>0) {
					txtrAds.append(" - Xanh dương");
				}
				else {
					txtrAds.append("Xanh dương");
				}
			}
		});
		btnXanhDng.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnXanhDng.setBackground(java.awt.Color.BLUE);
		btnXanhDng.setBounds(348, 35, 116, 66);
		panel.add(btnXanhDng);
		
		JButton btnXanhLam = new JButton("Xanh Lam");
		btnXanhLam.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtrAds.getText().length()>0) {
					txtrAds.append(" - Xanh lam");
				}
				else {
					txtrAds.append("Xanh lam");
				}
			}
		});
		btnXanhLam.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnXanhLam.setBackground(java.awt.Color.CYAN);
		btnXanhLam.setBounds(502, 35, 111, 66);
		panel.add(btnXanhLam);
		
		JButton btnVng = new JButton("Vàng");
		btnVng.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtrAds.getText().length()>0) {
					txtrAds.append(" - Vàng");
				}
				else {
					txtrAds.append("Vàng");
				}
			}
		});
		btnVng.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVng.setBackground(java.awt.Color.YELLOW);
		btnVng.setBounds(25, 134, 113, 62);
		panel.add(btnVng);
		
		JButton btnHngm = new JButton("Hồng");
		btnHngm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtrAds.getText().length()>0) {
					txtrAds.append(" - Hồng");
				}
				else {
					txtrAds.append("Hồng");
				}
			}
		});
		btnHngm.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnHngm.setBackground(java.awt.Color.PINK);
		btnHngm.setBounds(189, 134, 117, 62);
		panel.add(btnHngm);
		
		JButton btnTm = new JButton("Tím");
		btnTm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtrAds.getText().length()>0) {
					txtrAds.append(" - Tím");
				}
				else {
					txtrAds.append("Tím");
				}
			}
		});
		btnTm.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTm.setBackground(java.awt.Color.MAGENTA);
		btnTm.setBounds(348, 134, 116, 62);
		panel.add(btnTm);
		
		JButton btnCam = new JButton("Cam");
		btnCam.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(txtrAds.getText().length()>0) {
					txtrAds.append(" - Cam");
				}
				else {
					txtrAds.append("Cam");
				}
			}
		});
		btnCam.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCam.setBackground(java.awt.Color.ORANGE);
		btnCam.setBounds(502, 134, 111, 62);
		panel.add(btnCam);
		
		JButton btnDen = new JButton("Đen");
		btnDen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtrAds.getText().length()>0) {
					txtrAds.append(" - Đen");
				}
				else {
					txtrAds.append("Đen");
				}
			}
		});
		btnDen.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDen.setBackground(java.awt.Color.BLACK);
		btnDen.setBounds(25, 239, 113, 64);
		panel.add(btnDen);
		
		JButton btnTrng = new JButton("Trắng");
		btnTrng.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtrAds.getText().length()>0) {
					txtrAds.append(" - Trắng");
				}
				else {
					txtrAds.append("Trắng");
				}
			}
		});
		btnTrng.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTrng.setBackground(java.awt.Color.WHITE);
		btnTrng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnTrng.setBounds(189, 239, 117, 64);
		panel.add(btnTrng);
		
		JButton btnNu = new JButton("Nâu");
		btnNu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtrAds.getText().length()>0) {
					txtrAds.append(" - Nâu");
				}
				else {
					txtrAds.append("Nâu");
				}
			}
		});
		btnNu.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNu.setBackground(new java.awt.Color(205, 133, 63));
		btnNu.setBounds(502, 239, 111, 64);
		panel.add(btnNu);
		
		JButton btnBc = new JButton("Bạc");
		btnBc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtrAds.getText().length()>0) {
					txtrAds.append(" - Bạc");
				}
				else {
					txtrAds.append("Bạc");
				}
			}
		});
		btnBc.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBc.setBackground(SystemColor.controlHighlight);
		btnBc.setBounds(348, 239, 116, 64);
		panel.add(btnBc);
		
		JButton btnNewButton_1 = new JButton("Xóa");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String color= txtrAds.getText();
				int start=0;
				for (int i = color.length()-1;  i>0; --i) {
					if(color.charAt(i)=='-') {
						start=i;
						break;
					}
				}
				if(start==0) {
					txtrAds.setText("");
				}else {
				txtrAds.replaceRange(null, start-1, color.length());
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(481, 35, 77, 35);
		contentPane.add(btnNewButton_1);
		
		
		contentPane.add(txtrAds);
		
		JButton btnNewButton_1_1 = new JButton("Chọn");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtrAds.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn màu");
				}
				UI_QuanLyXe.txtMau.setText(txtrAds.getText());
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1_1.setBounds(572, 35, 77, 35);
		contentPane.add(btnNewButton_1_1);
	}
}
