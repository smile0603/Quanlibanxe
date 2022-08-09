package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;



import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JSplitPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import businesslogic.facade.NhanVienFacade;

import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.Font;

public class Menu extends JFrame {
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private JButton btnQLKho;
	private JButton btnQLKH;
	private JButton btnQLNV;
	private JButton btnQuanLyNCC;
	private JButton btnQLHD;
	private JButton btnThongKe;
	private JButton btnQLHoaDon;
	private JPanel panelMain;
	private JPanel pnQuanLyKho;
	private JPanel pnQuanLyNCC;
	private JPanel pnHelp;
	private JPanel pProfile;
	private UI_QuanLyXe ui_QuanLyXe;
	private UI_NhaCungCap ui_NhaCungCap;
	private UI_KhachHang ui_KhachHang;
	private UI_HoaDon ui_HoaDon;
	private UI_HopDong ui_HopDong;
	private UI_NhanVien ui_NhanVien;
	private UI_TaiKhoan ui_TaiKhoan;
	private UI_ThongKe1 ui_ThongKe1;
	private HomePage home;
	private JPanel pnQuanLyKH;
	private JPanel pnQuanLyNV;
	private JPanel pnQLHoaDon;
	private JPanel pnQuanLyHopDong;
	private JPanel pnThongKe;
	private JButton btnTrangChu;
	private JPanel pnTrangChu;
	private JButton btnQuanLyTaiKhoan;
	private JPanel pnTaiKhoan;
	private JMenuBar menuBar;
	private JMenuBar menuBarUser;
	private JMenu help;
	private JMenu User;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		SecurityManager securityManager = System.getSecurityManager();
//		if(securityManager == null)
//		{
//			System.setProperty("java.security.policy", "policy/policy.policy");
//			System.setSecurityManager(new SecurityManager());
//		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Menu frame = new Menu();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws NotBoundException 
	 * @throws RemoteException 
	 * @throws MalformedURLException 
	 */
	public Menu() throws SQLException, MalformedURLException, RemoteException, NotBoundException {
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
		home= new HomePage();
		ui_QuanLyXe= new UI_QuanLyXe();
		ui_NhaCungCap = new UI_NhaCungCap();
		ui_KhachHang= new UI_KhachHang();
		ui_HoaDon =new UI_HoaDon();
		ui_HopDong= new UI_HopDong();
		ui_NhanVien= new UI_NhanVien();
		ui_TaiKhoan= new UI_TaiKhoan();
		ui_ThongKe1= new UI_ThongKe1();
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(100, 100, screen.width, screen.height);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new CardLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setEnabled(false);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setDividerSize(0);
		getContentPane().add(splitPane, "name_9617081772200");
		panelMain = new JPanel();
		panelMain.setBackground(Color.WHITE);
		splitPane.setRightComponent(panelMain);
		panelMain.setLayout(new CardLayout(0, 0));
		
		//Giao Dien Quan Ly Kho
		pnQuanLyKho = new JPanel();
		panelMain.add(pnQuanLyKho, "name_7046289087700");
		pnQuanLyKho.setLayout(null);
		ui_QuanLyXe.setVisible(true);
		pnQuanLyKho.add(ui_QuanLyXe.getContentPane());
		ui_QuanLyXe.setVisible(false);
		
		//Giao Dien Quan Ly Nha Cung Cap
		pnQuanLyNCC = new JPanel();
		panelMain.add(pnQuanLyNCC, "name_7054596857300");
		pnQuanLyNCC.setLayout(null);
		ui_NhaCungCap.setVisible(true);
		pnQuanLyNCC.add(ui_NhaCungCap.getContentPane());
		ui_NhaCungCap.setVisible(false);
		
		//Giao Dien Quan Ly Khach Hang
		pnQuanLyKH = new JPanel();
		panelMain.add(pnQuanLyKH, "name_3755726204700");
		pnQuanLyKH.setLayout(null);
		ui_KhachHang.setVisible(true);
		pnQuanLyKH.add(ui_KhachHang.getContentPane());
		ui_KhachHang.setVisible(false);
		
		//Giao Dien Quan Ly Nhan Vien
		pnQuanLyNV = new JPanel();
		panelMain.add(pnQuanLyNV, "name_3759579047400");
		pnQuanLyNV.setLayout(null);
		ui_NhanVien.setVisible(true);
		pnQuanLyNV.add(ui_NhanVien.getContentPane());
		ui_NhanVien.setVisible(false);
		
		//Giao Dien Quan Ly Hoa Don
		pnQLHoaDon = new JPanel();
		panelMain.add(pnQLHoaDon, "name_3761516368600");
		pnQLHoaDon.setLayout(null);
		ui_HoaDon.setVisible(true);
		pnQLHoaDon.add(ui_HoaDon.getContentPane());
		ui_HoaDon.setVisible(false);
		
		//Giao Dien Quan Ly Hop Dong
		pnQuanLyHopDong = new JPanel();
		panelMain.add(pnQuanLyHopDong, "name_3763305576000");
		pnQuanLyHopDong.setLayout(null);
		ui_HopDong.setVisible(true);
		pnQuanLyHopDong.add(ui_HopDong.getContentPane());
		ui_HopDong.setVisible(false);
		
		//Giao Dien Quan Ly Thong Ke
		pnThongKe = new JPanel();
		panelMain.add(pnThongKe, "name_3836959492400");
		pnThongKe.setLayout(null);
		ui_ThongKe1.setVisible(true);
		pnThongKe.add(ui_ThongKe1.getContentPane());
		ui_ThongKe1.setVisible(false);
		
		//Home
		pnTrangChu = new JPanel();
		panelMain.add(pnTrangChu, "name_3887874348900");
		pnTrangChu.setLayout(null);
		home.setVisible(true);
		pnTrangChu.add(home.getContentPane());
		home.setVisible(false);
		
		//Giao diện quản lý tài khoản
		pnTaiKhoan = new JPanel();
		panelMain.add(pnTaiKhoan, "name_1832465809800");
		pnTaiKhoan.setLayout(null);
		ui_TaiKhoan.setVisible(true);
		pnTaiKhoan.add(ui_TaiKhoan.getContentPane());
		ui_TaiKhoan.setVisible(false);
		
		//Giao dien Help
		pnHelp = new JPanel();
		panelMain.add(pnHelp);
		pnHelp.setLayout(null);
		
		//Giao dien Help
		pProfile = new JPanel();
		panelMain.add(pProfile);
		pProfile.setLayout(null);
		
		//
		pnQuanLyKho.setVisible(false);
		pnTrangChu.setVisible(true);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(43,87,154));
		splitPane.setLeftComponent(panel);
		
		
		btnQLKH = new JButton("Quản Lý Khách Hàng");
		btnQLKH.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnQLKH.setForeground(Color.WHITE);
		btnQLKH.setBorderPainted(false);
		btnQLKH.setBackground(new Color(43, 87, 154));
		btnQLKH.setFocusable(false);
		btnQLKH.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnQLKH.setBackground(Color.white);
				btnQLKH.setForeground(Color.black);
				btnQLKH.setFocusable(false);
				btnQLHD.setBackground(new Color(43, 87, 154));
				btnQLKho.setBackground(new Color(43, 87, 154));
				btnQLNV.setBackground(new Color(43, 87, 154));
				btnQuanLyNCC.setBackground(new Color(43, 87, 154));
				btnThongKe.setBackground(new Color(43, 87, 154));
				btnQLHoaDon.setBackground(new Color(43, 87, 154));
				btnQLHD.setForeground(Color.white);
				btnQLKho.setForeground(Color.white);
				btnQLNV.setForeground(Color.white);
				btnQuanLyNCC.setForeground(Color.white);
				btnThongKe.setForeground(Color.white);
				btnQLHoaDon.setForeground(Color.white);
				btnTrangChu.setBackground(new Color(43, 87, 154));
				btnTrangChu.setForeground(Color.white);
				btnQuanLyTaiKhoan.setBackground(new Color(43, 87, 154));
				btnQuanLyTaiKhoan.setForeground(Color.white);
				help.setBackground(new Color(43, 87, 154));
				help.setForeground(Color.white);
				help.setOpaque(true);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				pnTaiKhoan.setVisible(false);
				pnQuanLyKho.setVisible(false);
				pnQLHoaDon.setVisible(false);
				pnQuanLyNCC.setVisible(false);
				pnQuanLyHopDong.setVisible(false);
				pnQuanLyNV.setVisible(false);
				pnThongKe.setVisible(false);
				pnTrangChu.setVisible(false);
				pnQuanLyKH.setVisible(true);
			}
		});
		
		btnQLKho = new JButton("Quản Lý Kho Hàng");
		btnQLKho.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnQLKho.setFocusable(false);
		btnQLKho.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnQLKho.setBackground(Color.white);
				btnQLKho.setForeground(Color.black);
				btnQLKho.setFocusable(false);
				btnQLHD.setBackground(new Color(43, 87, 154));
				btnQLKH.setBackground(new Color(43, 87, 154));
				btnQLNV.setBackground(new Color(43, 87, 154));
				btnQuanLyNCC.setBackground(new Color(43, 87, 154));
				btnThongKe.setBackground(new Color(43, 87, 154));
				btnQLHoaDon.setBackground(new Color(43, 87, 154));
				btnQLHD.setForeground(Color.white);
				btnQLKH.setForeground(Color.white);
				btnQLNV.setForeground(Color.white);
				btnQuanLyNCC.setForeground(Color.white);
				btnThongKe.setForeground(Color.white);
				btnQLHoaDon.setForeground(Color.white);
				btnTrangChu.setBackground(new Color(43, 87, 154));
				btnTrangChu.setForeground(Color.white);
				btnQuanLyTaiKhoan.setBackground(new Color(43, 87, 154));
				btnQuanLyTaiKhoan.setForeground(Color.white);
				help.setBackground(new Color(43, 87, 154));
				help.setForeground(Color.white);
				help.setOpaque(true);
				User.setBackground(new Color(43, 87, 154));
				User.setForeground(Color.white);
				User.setOpaque(true);
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
//				try {
//					ConnectDB.getInstance().connect();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
				pnTaiKhoan.setVisible(false);
				pnQuanLyNV.setVisible(false);
				pnQLHoaDon.setVisible(false);
				pnQuanLyNCC.setVisible(false);
				pnQuanLyKH.setVisible(false);
				pnQuanLyHopDong.setVisible(false);
				pnThongKe.setVisible(false);
				pnTrangChu.setVisible(false);
				pnQuanLyKho.add(ui_QuanLyXe.getContentPane());
				pnQuanLyKho.setVisible(true);
				
			}
		});
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		btnTrangChu = new JButton("Trang Chủ");
		btnTrangChu.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTrangChu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pnTaiKhoan.setVisible(false);
				pnQuanLyKho.setVisible(false);
				pnQLHoaDon.setVisible(false);
				pnQuanLyNCC.setVisible(false);
				pnQuanLyKH.setVisible(false);
				pnQuanLyHopDong.setVisible(false);
				pnQuanLyNV.setVisible(false);
				pnThongKe.setVisible(false);
				pnTrangChu.setVisible(true);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				btnTrangChu.setBackground(Color.white);
				btnTrangChu.setForeground(Color.black);
				btnQLHD.setBackground(new Color(43, 87, 154));
				btnQLKho.setBackground(new Color(43, 87, 154));
				btnQLKH.setBackground(new Color(43, 87, 154));
				btnQuanLyNCC.setBackground(new Color(43, 87, 154));
				btnThongKe.setBackground(new Color(43, 87, 154));
				btnQLHoaDon.setBackground(new Color(43, 87, 154));
				btnQLHD.setForeground(Color.white);
				btnQLKho.setForeground(Color.white);
				btnQLKH.setForeground(Color.white);
				btnQuanLyNCC.setForeground(Color.white);
				btnThongKe.setForeground(Color.white);
				btnQLHoaDon.setForeground(Color.white);
				btnQLNV.setBackground(new Color(43, 87, 154));
				btnQLNV.setForeground(Color.white);
				btnQuanLyTaiKhoan.setBackground(new Color(43, 87, 154));
				btnQuanLyTaiKhoan.setForeground(Color.white);
				help.setBackground(new Color(43, 87, 154));
				help.setForeground(Color.white);
				help.setOpaque(true);
				User.setBackground(new Color(43, 87, 154));
				User.setForeground(Color.white);
				User.setOpaque(true);
			}
		});
		btnTrangChu.setForeground(Color.WHITE);
		btnTrangChu.setFocusable(false);
		btnTrangChu.setBorderPainted(false);
		btnTrangChu.setBackground(new Color(43, 87, 154));
		panel.add(btnTrangChu);
		btnQLKho.setForeground(Color.white);
		btnQLKho.setBackground(new Color(43, 87, 154));
		btnQLKho.setBorderPainted(false);
		
		panel.add(btnQLKho);
		panel.add(btnQLKH);
		
		btnQLNV = new JButton("Quản Lý Nhân Viên");
		btnQLNV.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnQLNV.setFocusable(false);
		btnQLNV.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnQLNV.setBackground(Color.white);
				btnQLNV.setForeground(Color.black);
				btnTrangChu.setBackground(new Color(43, 87, 154));
				btnTrangChu.setForeground(Color.white);
				btnQLHD.setBackground(new Color(43, 87, 154));
				btnQLKho.setBackground(new Color(43, 87, 154));
				btnQLKH.setBackground(new Color(43, 87, 154));
				btnQuanLyNCC.setBackground(new Color(43, 87, 154));
				btnThongKe.setBackground(new Color(43, 87, 154));
				btnQLHoaDon.setBackground(new Color(43, 87, 154));
				btnQLHD.setForeground(Color.white);
				btnQLKho.setForeground(Color.white);
				btnQLKH.setForeground(Color.white);
				btnQuanLyNCC.setForeground(Color.white);
				btnThongKe.setForeground(Color.white);
				btnQLHoaDon.setForeground(Color.white);
				btnQuanLyTaiKhoan.setBackground(new Color(43, 87, 154));
				btnQuanLyTaiKhoan.setForeground(Color.white);
				help.setBackground(new Color(43, 87, 154));
				help.setForeground(Color.white);
				help.setOpaque(true);
				User.setBackground(new Color(43, 87, 154));
				User.setForeground(Color.white);
				User.setOpaque(true);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				pnTaiKhoan.setVisible(false);
				pnQuanLyKho.setVisible(false);
				pnQLHoaDon.setVisible(false);
				pnQuanLyNCC.setVisible(false);
				pnQuanLyKH.setVisible(false);
				pnQuanLyHopDong.setVisible(false);
				pnThongKe.setVisible(false);
				pnTrangChu.setVisible(false);
				pnQuanLyNV.add(ui_NhanVien.getContentPane());
				pnQuanLyNV.setVisible(true);
			}
		});
		btnQLNV.setForeground(Color.WHITE);
	
		btnQLNV.setBorderPainted(false);
		btnQLNV.setBackground(new Color(43, 87, 154));
		panel.add(btnQLNV);

		btnQLHoaDon = new JButton("Quản Lý Hóa Đơn");
		btnQLHoaDon.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnQLHoaDon.setFocusable(false);
		btnQLHoaDon.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnQLHoaDon.setBackground(Color.white);
				btnQLHoaDon.setForeground(Color.black);
				btnQLNV.setBackground(new Color(43, 87, 154));
				btnQLKho.setBackground(new Color(43, 87, 154));
				btnQLKH.setBackground(new Color(43, 87, 154));
				btnQuanLyNCC.setBackground(new Color(43, 87, 154));
				btnThongKe.setBackground(new Color(43, 87, 154));
				btnQLHD.setBackground(new Color(43, 87, 154));
				btnQLHD.setForeground(Color.white);
				btnQLKho.setForeground(Color.white);
				btnQLKH.setForeground(Color.white);
				btnQuanLyNCC.setForeground(Color.white);
				btnThongKe.setForeground(Color.white);
				btnQLNV.setForeground(Color.white);
				btnTrangChu.setBackground(new Color(43, 87, 154));
				btnTrangChu.setForeground(Color.white);
				btnQuanLyTaiKhoan.setBackground(new Color(43, 87, 154));
				btnQuanLyTaiKhoan.setForeground(Color.white);
				help.setBackground(new Color(43, 87, 154));
				help.setForeground(Color.white);
				help.setOpaque(true);
				User.setBackground(new Color(43, 87, 154));
				User.setForeground(Color.white);
				User.setOpaque(true);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				pnTaiKhoan.setVisible(false);
				pnQuanLyKho.setVisible(false);
				pnQuanLyNV.setVisible(false);
				pnQuanLyNCC.setVisible(false);
				pnQuanLyKH.setVisible(false);
				pnQuanLyHopDong.setVisible(false);
				pnThongKe.setVisible(false);
				pnTrangChu.setVisible(false);
				pnQLHoaDon.add(ui_HoaDon.getContentPane());
				pnQLHoaDon.setVisible(true);
			}
		});
		btnQLHoaDon.setForeground(Color.WHITE);
		btnQLHoaDon.setBorderPainted(false);
		btnQLHoaDon.setBackground(new Color(43, 87, 154));
		panel.add(btnQLHoaDon);
		
		btnQLHD = new JButton("Quản Lý Hợp Đồng");
		btnQLHD.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnQLHD.setFocusable(false);
		btnQLHD.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnQLHD.setBackground(Color.white);
				btnQLHD.setForeground(Color.black);
				btnQuanLyNCC.setBackground(new Color(43, 87, 154));
				btnQLKho.setBackground(new Color(43, 87, 154));
				btnQLKH.setBackground(new Color(43, 87, 154));
				btnQLNV.setBackground(new Color(43, 87, 154));
				btnThongKe.setBackground(new Color(43, 87, 154));
				btnQLHoaDon.setBackground(new Color(43, 87, 154));
				btnQuanLyNCC.setForeground(Color.white);
				btnQLKho.setForeground(Color.white);
				btnQLKH.setForeground(Color.white);
				btnQLHoaDon.setForeground(Color.white);
				btnThongKe.setForeground(Color.white);
				btnQLNV.setForeground(Color.white);
				btnTrangChu.setBackground(new Color(43, 87, 154));
				btnTrangChu.setForeground(Color.white);
				btnQuanLyTaiKhoan.setBackground(new Color(43, 87, 154));
				btnQuanLyTaiKhoan.setForeground(Color.white);
				help.setBackground(new Color(43, 87, 154));
				help.setForeground(Color.white);
				help.setOpaque(true);
				User.setBackground(new Color(43, 87, 154));
				User.setForeground(Color.white);
				User.setOpaque(true);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				pnTaiKhoan.setVisible(false);
				pnQuanLyKho.setVisible(false);
				pnQLHoaDon.setVisible(false);
				pnQuanLyNCC.setVisible(false);
				pnQuanLyKH.setVisible(false);
				pnQuanLyNV.setVisible(false);
				pnThongKe.setVisible(false);
				pnTrangChu.setVisible(false);
				pnQuanLyHopDong.add(ui_HopDong.getContentPane());
				pnQuanLyHopDong.setVisible(true);
			}
		});
		btnQLHD.setForeground(Color.WHITE);
		btnQLHD.setBorderPainted(false);
		btnQLHD.setBackground(new Color(43, 87, 154));
		panel.add(btnQLHD);
		
		btnThongKe = new JButton("Thống Kê");
		btnThongKe.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnThongKe.setFocusable(false);
		btnThongKe.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnThongKe.setBackground(Color.white);
				btnThongKe.setForeground(Color.black);
				btnQuanLyNCC.setBackground(new Color(43, 87, 154));
				btnQLKho.setBackground(new Color(43, 87, 154));
				btnQLKH.setBackground(new Color(43, 87, 154));
				btnQLNV.setBackground(new Color(43, 87, 154));
				btnQLHD.setBackground(new Color(43, 87, 154));
				btnQLHoaDon.setBackground(new Color(43, 87, 154));
				btnQuanLyNCC.setForeground(Color.white);
				btnQLKho.setForeground(Color.white);
				btnQLKH.setForeground(Color.white);
				btnQLHoaDon.setForeground(Color.white);
				btnQLNV.setForeground(Color.white);
				btnQLHD.setForeground(Color.white);
				btnTrangChu.setBackground(new Color(43, 87, 154));
				btnTrangChu.setForeground(Color.white);
				btnQuanLyTaiKhoan.setBackground(new Color(43, 87, 154));
				btnQuanLyTaiKhoan.setForeground(Color.white);
				help.setBackground(new Color(43, 87, 154));
				help.setForeground(Color.white);
				help.setOpaque(true);
				User.setBackground(new Color(43, 87, 154));
				User.setForeground(Color.white);
				User.setOpaque(true);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				pnTaiKhoan.setVisible(false);
				pnQuanLyKho.setVisible(false);
				pnQLHoaDon.setVisible(false);
				pnQuanLyNCC.setVisible(false);
				pnQuanLyKH.setVisible(false);
				pnQuanLyHopDong.setVisible(false);
				pnQuanLyNV.setVisible(false);
				pnTrangChu.setVisible(false);
				pnThongKe.add(ui_ThongKe1.getContentPane());
				pnThongKe.setVisible(true);
				ui_ThongKe1.LoadTong();
			}
		});
		

		btnQuanLyNCC = new JButton("Quản Lý Nhà Cung Cấp");
		btnQuanLyNCC.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnQuanLyNCC.setFocusable(false);
		btnQuanLyNCC.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnQuanLyNCC.setBackground(Color.white);
				btnQuanLyNCC.setForeground(Color.black);
				btnQLHoaDon.setBackground(new Color(43, 87, 154));
				btnQLKho.setBackground(new Color(43, 87, 154));
				btnQLKH.setBackground(new Color(43, 87, 154));
				btnQLHD.setBackground(new Color(43, 87, 154));
				btnThongKe.setBackground(new Color(43, 87, 154));
				btnQLNV.setBackground(new Color(43, 87, 154));
				btnQLHD.setForeground(Color.white);
				btnQLKho.setForeground(Color.white);
				btnQLKH.setForeground(Color.white);
				btnQLHoaDon.setForeground(Color.white);
				btnThongKe.setForeground(Color.white);
				btnQLNV.setForeground(Color.white);
				btnTrangChu.setBackground(new Color(43, 87, 154));
				btnTrangChu.setForeground(Color.white);
				btnQuanLyTaiKhoan.setBackground(new Color(43, 87, 154));
				btnQuanLyTaiKhoan.setForeground(Color.white);
				help.setBackground(new Color(43, 87, 154));
				help.setForeground(Color.white);
				help.setOpaque(true);
				User.setBackground(new Color(43, 87, 154));
				User.setForeground(Color.white);
				User.setOpaque(true);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				pnQuanLyKho.setVisible(false);
				pnQLHoaDon.setVisible(false);
				pnQuanLyKH.setVisible(false);
				pnQuanLyHopDong.setVisible(false);
				pnQuanLyNV.setVisible(false);
				pnTrangChu.setVisible(false);
				pnThongKe.setVisible(false);
				pnQuanLyNCC.add(ui_NhaCungCap.getContentPane());
				pnQuanLyNCC.setVisible(true);
				
			}
		});
		btnQuanLyNCC.setForeground(Color.WHITE);
		btnQuanLyNCC.setBorderPainted(false);
		btnQuanLyNCC.setBackground(new Color(43, 87, 154));
		panel.add(btnQuanLyNCC);
		btnThongKe.setForeground(Color.WHITE);
		btnThongKe.setBorderPainted(false);
		btnThongKe.setBackground(new Color(43, 87, 154));
		panel.add(btnThongKe);
		
		btnQuanLyTaiKhoan = new JButton("Quản Lý Tài Khoản");
		btnQuanLyTaiKhoan.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnQuanLyTaiKhoan.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnQuanLyTaiKhoan.setBackground(Color.white);
				btnQuanLyTaiKhoan.setForeground(Color.black);
				btnQLHoaDon.setBackground(new Color(43, 87, 154));
				btnQLKho.setBackground(new Color(43, 87, 154));
				btnQLKH.setBackground(new Color(43, 87, 154));
				btnQLHD.setBackground(new Color(43, 87, 154));
				btnThongKe.setBackground(new Color(43, 87, 154));
				btnQLNV.setBackground(new Color(43, 87, 154));
				btnQLHD.setForeground(Color.white);
				btnQLKho.setForeground(Color.white);
				btnQLKH.setForeground(Color.white);
				btnQLHoaDon.setForeground(Color.white);
				btnThongKe.setForeground(Color.white);
				btnQLNV.setForeground(Color.white);
				btnTrangChu.setBackground(new Color(43, 87, 154));
				btnQuanLyNCC.setForeground(Color.white);
				btnQuanLyNCC.setBackground(new Color(43, 87, 154));
				help.setBackground(new Color(43, 87, 154));
				help.setForeground(Color.white);
				help.setOpaque(true);
				User.setBackground(new Color(43, 87, 154));
				User.setForeground(Color.white);
				User.setOpaque(true);
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				pnQuanLyKho.setVisible(false);
				pnQLHoaDon.setVisible(false);
				pnQuanLyKH.setVisible(false);
				pnQuanLyHopDong.setVisible(false);
				pnQuanLyNV.setVisible(false);
				pnTrangChu.setVisible(false);
				pnThongKe.setVisible(false);
				pnQuanLyNCC.setVisible(false);
				pnTaiKhoan.add(ui_TaiKhoan.getContentPane());
				pnTaiKhoan.setVisible(true);
				
			}
		});
		btnQuanLyTaiKhoan.setForeground(Color.WHITE);
		btnQuanLyTaiKhoan.setFocusable(false);
		btnQuanLyTaiKhoan.setBorderPainted(false);
		btnQuanLyTaiKhoan.setBackground(new Color(43, 87, 154));
		panel.add(btnQuanLyTaiKhoan);
		
		btnTrangChu.setBackground(Color.white);
		btnTrangChu.setForeground(Color.black);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);	
		pnHelp.add(menuBar);
		help = new JMenu("Help");
		menuBar.setBackground(new Color(43, 87, 154));
		menuBar.setBackground(new Color(43, 87, 154));
		menuBar.add(help);

		JMenuItem about = new JMenuItem("Thông tin phần mềm");
		JMenuItem document = new JMenuItem("Tài Liệu hướng dẫn");
		help.setFont(new Font("Tahoma", Font.BOLD, 11));
		help.add(about);
		about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				About dc = new About();
				dc.setVisible(true);
			}
		});
		help.add(document);
		document.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmds[] = new String[] {"cmd", "/c", "D:\\QuanLyBanXe\\branches\\Develop\\TaiLieuHuongDan\\tlhd.docx"};
				try {
				    Runtime.getRuntime().exec(cmds);
				}catch (Exception e1) {
					// TODO: handle exception
				}
			}
		});
		help.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				help.setBackground(Color.white);
				help.setForeground(Color.black);
				help.setOpaque(true);
				btnQLKH.setBackground(new Color(43, 87, 154));
			//	btnQLKH.setForeground(Color.black);
				btnQLKH.setFocusable(false);
				btnQLHD.setBackground(new Color(43, 87, 154));
				btnQLKho.setBackground(new Color(43, 87, 154));
				btnQLNV.setBackground(new Color(43, 87, 154));
				btnQuanLyNCC.setBackground(new Color(43, 87, 154));
				btnThongKe.setBackground(new Color(43, 87, 154));
				btnQLHoaDon.setBackground(new Color(43, 87, 154));
				btnQLHD.setForeground(Color.white);
				btnQLKho.setForeground(Color.white);
				btnQLNV.setForeground(Color.white);
				btnQuanLyNCC.setForeground(Color.white);
				btnThongKe.setForeground(Color.white);
				btnQLHoaDon.setForeground(Color.white);
				btnTrangChu.setBackground(new Color(43, 87, 154));
				btnTrangChu.setForeground(Color.white);
				btnQuanLyTaiKhoan.setBackground(new Color(43, 87, 154));
				btnQuanLyTaiKhoan.setForeground(Color.white);
				User.setBackground(new Color(43, 87, 154));
				User.setForeground(Color.white);
				User.setOpaque(true);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		help.setForeground(Color.WHITE);
		help.setFocusable(false);
		help.setBorderPainted(false);
		help.setBackground(new Color(43, 87, 154));
		help.setOpaque(true);
		panel.add(menuBar);
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(43, 87, 154));
		menuBarUser = new JMenuBar();
		setJMenuBar(menuBarUser);	
		panel1.add(menuBarUser, BorderLayout.EAST);
		NhanVienFacade nhanVienFacade = (NhanVienFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/nhanVienFacade");
		//Dao_NhanVien dao_nv = new Dao_NhanVien();
		String ten = nhanVienFacade.getTenNhanVienById("NV_0001");
		User = new JMenu(ten);
		menuBarUser.add(User);
		User.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				User.setBackground(Color.white);
				User.setForeground(Color.black);
				User.setOpaque(true);
				help.setBackground(new Color(43, 87, 154));
				help.setForeground(Color.white);
				help.setOpaque(true);
				btnQLKH.setBackground(new Color(43, 87, 154));
			//	btnQLKH.setForeground(Color.black);
				btnQLKH.setFocusable(false);
				btnQLHD.setBackground(new Color(43, 87, 154));
				btnQLKho.setBackground(new Color(43, 87, 154));
				btnQLNV.setBackground(new Color(43, 87, 154));
				btnQuanLyNCC.setBackground(new Color(43, 87, 154));
				btnThongKe.setBackground(new Color(43, 87, 154));
				btnQLHoaDon.setBackground(new Color(43, 87, 154));
				btnQLHD.setForeground(Color.white);
				btnQLKho.setForeground(Color.white);
				btnQLNV.setForeground(Color.white);
				btnQuanLyNCC.setForeground(Color.white);
				btnThongKe.setForeground(Color.white);
				btnQLHoaDon.setForeground(Color.white);
				btnTrangChu.setBackground(new Color(43, 87, 154));
				btnTrangChu.setForeground(Color.white);
				btnQuanLyTaiKhoan.setBackground(new Color(43, 87, 154));
				btnQuanLyTaiKhoan.setForeground(Color.white);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		User.setFont(new Font("Tahoma", Font.BOLD, 11));
		User.setForeground(Color.WHITE);
		User.setBorderPainted(false);
		User.setBackground(new Color(43, 87, 154));
		User.setOpaque(true);
		
		//panel1.setBackground(new Color(43, 87, 154));
		panel.add(panel1, BorderLayout.EAST);
		JMenuItem profile = new JMenuItem("Hồ sơ");
		JMenuItem logOut = new JMenuItem("Đăng xuất");
		User.add(profile);
		profile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Profile pf;
				try {
					pf = new Profile();
					pf.setVisible(true);
				} catch (MalformedURLException | RemoteException | NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});	
		User.add(logOut);
		logOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login lg;
				try {
					setVisible(false);
					try {
						lg = new Login();
						lg.setVisible(true);
						lg.btndangNhap.setForeground(Color.black);
					} catch (MalformedURLException | RemoteException | NotBoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
		});	
	}
}
