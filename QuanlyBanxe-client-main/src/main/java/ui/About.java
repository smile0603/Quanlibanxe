package ui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;

public class About extends JFrame {

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
					About frame = new About();
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
	public About() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 641, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 605, 298);
		contentPane.add(panel);
		panel.setLayout(null);
			
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(41, 100, 61, 81);
		lblNewLabel.setIcon(new ImageIcon("img1//moto.png"));
		panel.add(lblNewLabel);
		
		JLabel lblQlbxL = new JLabel("QLBX for Java Developers");
		lblQlbxL.setBounds(246, 5, 163, 17);
		lblQlbxL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblQlbxL);
		
		JLabel lblNewLabel_1 = new JLabel("Version : 2020-27(1.1)");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(190, 57, 316, 13);
		panel.add(lblNewLabel_1);
		
		JLabel lblVersion = new JLabel("BuildID : 2022711");
		lblVersion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblVersion.setBounds(190, 79, 219, 13);
		panel.add(lblVersion);
		
//		JLabel lblNewLabel_2 = new JLabel("QLBX và biểu trừng của QLBX là thương hiệu của QLBX NHHK.Không thể thay đổi biểu trưng mà chưa có sự cho phêp của QLBX.Biểu trưng của QLBX được cung cấp để sử dụng theo nguyên tắc nhãn hiệu và biểu trưng QLBX");
//		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		lblNewLabel_2.setBounds(190, 113, 386, 81);
//		panel.add(lblNewLabel_2);
		
		String data ="QLBX và biểu trừng của QLBX là thương hiệu của QLBX NHHK.\n"
				+ "Không thể thay đổi biểu trưng mà chưa có sự cho phêp của QLBX.\n"
				+ "Biểu trưng của QLBX được cung cấp để sử dụng theo nguyên tắc nhãn hiệu và biểu trưng QLBX\n"
				+ "Những tên khác có thể là thương hiệu của chủ sở hữu tương ứng";
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(190, 121, 370, 81);
		panel.add(scrollPane);
		JTextArea textArea = new JTextArea(data);
		scrollPane.setViewportView(textArea);
		
		
		
	}
}
