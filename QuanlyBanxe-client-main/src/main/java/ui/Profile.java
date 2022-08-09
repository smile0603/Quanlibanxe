package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;

import businesslogic.facade.NhanVienFacade;
import entity.NhanVien;

import java.awt.Font;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;

public class Profile extends JFrame {

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
					Profile frame = new Profile();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws NotBoundException 
	 * @throws RemoteException 
	 * @throws MalformedURLException 
	 */
	public Profile() throws MalformedURLException, RemoteException, NotBoundException {
//		try {
//			ConnectDB.getInstance().connect();
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 451, 580);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Profile.class.getResource("/image/person-icon.png")));
		lblNewLabel.setBounds(163, 24, 133, 157);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Th\u00F4ng tin c\u00E1 nh\u00E2n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(21, 216, 393, 310);
		contentPane.add(panel);
		panel.setLayout(null);
		int x = 28;
		int y = 27;
		int width = 138;
		int height = 28;
		NhanVienFacade nhanVienFacade = (NhanVienFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/nhanVienFacade");
		//Dao_NhanVien dao_nv = new Dao_NhanVien();
		NhanVien nv = nhanVienFacade.getNhanVienById("maNhanVien", Login.txtuser.getText().trim());
		
		JLabel lblMaNV = new JLabel("Mã Nhân Viên");
		lblMaNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMaNV.setBounds(x,y,width, height);
		panel.add(lblMaNV);
		
		JLabel lblMaNVText = new JLabel(nv.getMaNhanVien());
		lblMaNVText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMaNVText.setBounds(x+186, y, width+31, 28);
		panel.add(lblMaNVText);
		
		y += 30;
		
		JLabel lblCMND = new JLabel("CMND/Thẻ Căn Cước");
		lblCMND.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCMND.setBounds(x, y, width, height);
		panel.add(lblCMND);
		
		
		JLabel lblCMNDText = new JLabel(nv.getCMND());
		lblCMNDText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCMNDText.setBounds(x+186, y, width+31, 28);
		panel.add(lblCMNDText);
		
		y += 30;
		
		JLabel lblGioiTinh = new JLabel("Giới Tính");
		lblGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGioiTinh.setBounds(x, y, width, height);
		panel.add(lblGioiTinh);
		
		JLabel lblGioiTinhText = new JLabel(nv.getGioiTinh());
		lblGioiTinhText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGioiTinhText.setBounds(x+186, y, width+31, 28);
		panel.add(lblGioiTinhText);
		
		y += 30;
		
		JLabel lblNgaySinh = new JLabel("Ngày Sinh");
		lblNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNgaySinh.setBounds(x, y, width, height);
		panel.add(lblNgaySinh);
		
		JLabel lblNgaySinhText = new JLabel(nv.getNgaySinh().toString());
		lblNgaySinhText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNgaySinhText.setBounds(x+186, y, width+31, 28);
		panel.add(lblNgaySinhText);
		
		y += 30;
		
		JLabel lblSDT = new JLabel("Số Điện Thoại");
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSDT.setBounds(x, y, width, height);
		panel.add(lblSDT);
		
		JLabel lblSDTText = new JLabel(nv.getSdt());
		lblSDTText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSDTText.setBounds(x+186, y, width+31, 28);
		panel.add(lblSDTText);
		
		y += 30;
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(x, y, width, height);
		panel.add(lblEmail);
		
		JLabel lblEmailText = new JLabel(nv.getEmail().trim());
		lblEmailText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmailText.setBounds(x+186, y, width+31, 28);
		panel.add(lblEmailText);
		
		y += 30;
		
		JLabel lblChucVu = new JLabel("Chức Vụ");
		lblChucVu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblChucVu.setBounds(x, y, width, height);
		panel.add(lblChucVu);
		
		JLabel lblChucVuText = new JLabel(nv.getChucVu().getMaChucVu());
		lblChucVuText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblChucVuText.setBounds(x+186, y, width+31, 28);
		panel.add(lblChucVuText);

		y += 30;
		
		JLabel lblNgayVaoLam = new JLabel("Ngày Vào Làm");
		lblNgayVaoLam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNgayVaoLam.setBounds(x, y, width, height);
		panel.add(lblNgayVaoLam);
		
		JLabel lblNVLText = new JLabel(nv.getNgayVaoLam().toString());
		lblNVLText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNVLText.setBounds(x+186, y, width+31, 28);
		panel.add(lblNVLText);
		
		y += 30;
		
		JLabel lblDiaChi = new JLabel("Địa Chỉ");
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDiaChi.setBounds(x, y, width, height);
		panel.add(lblDiaChi);
		
		JLabel lblDiaChiText = new JLabel(nv.getDiaChi());
		lblDiaChiText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDiaChiText.setBounds(x+186, y, width+31, 28);
		panel.add(lblDiaChiText);
		
		JLabel txtTenNhanVien = new JLabel(nv.getTenNhanVien());
		txtTenNhanVien.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtTenNhanVien.setBounds(173, 179, 164, 27);
		contentPane.add(txtTenNhanVien);
	}
}
