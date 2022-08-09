package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

import businesslogic.facade.HoaDonFacade;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class a extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaHD;
	private JTextField txtMaKH;
	private JTextField txtTenKH;

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
					a frame = new a();
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
	 * @throws RemoteException 
	 * @throws NotBoundException 
	 * @throws MalformedURLException 
	 */
	public a() throws RemoteException, MalformedURLException, NotBoundException {
//		try {
//			ConnectDB.getInstance().connect();
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1262, 691);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();
		//setBounds(0, 0, 1113, 614);
		setBounds(0, 0, width, height);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pTab2 = new JPanel();
		pTab2.setBounds(10, 0, 1513, 644);
		contentPane.add(pTab2);
		pTab2.setLayout(null);
		
		JPanel pSearchInfo = new JPanel();
		pSearchInfo.setBorder(new TitledBorder(null, "Thông tin tìm kiếm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pSearchInfo.setBounds(0, 5, 814, 124);
		pTab2.add(pSearchInfo);
		pSearchInfo.setLayout(null);
		
		JLabel lblmaHD = new JLabel("Mã Hóa Đơn");
		lblmaHD.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblmaHD.setBounds(10, 31, 82, 27);
		pSearchInfo.add(lblmaHD);
		
		JLabel lblMaKH = new JLabel("Mã Khách Hàng");
		lblMaKH.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMaKH.setBounds(10, 70, 107, 27);
		pSearchInfo.add(lblMaKH);
		
		txtMaHD = new JTextField();
		
		txtMaHD.setBounds(146, 31, 208, 21);
		pSearchInfo.add(txtMaHD);
		txtMaHD.setColumns(10);
		
		txtMaKH = new JTextField();
		txtMaKH.setBounds(146, 70, 208, 21);
		pSearchInfo.add(txtMaKH);
		txtMaKH.setColumns(10);
		
		JLabel lblTenKH = new JLabel("Tên Khách Hàng");
		lblTenKH.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTenKH.setBounds(441, 31, 118, 19);
		pSearchInfo.add(lblTenKH);
		
		JLabel lblNgayLHD = new JLabel("Ngày Lập Hóa Đơn");
		lblNgayLHD.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNgayLHD.setBounds(441, 70, 133, 19);
		pSearchInfo.add(lblNgayLHD);
		
		txtTenKH = new JTextField();
		txtTenKH.setBounds(589, 31, 208, 21);
		pSearchInfo.add(txtTenKH);
		txtTenKH.setColumns(10);
		
		JDateChooser dcNgayLHD = new JDateChooser();		
		dcNgayLHD.setBounds(589, 70, 141, 21);
		dcNgayLHD.setDateFormatString("yyy/MM/dd");
		pSearchInfo.add(dcNgayLHD);
		
		JPanel pChucNang = new JPanel();
		pChucNang.setBorder(new TitledBorder(null, "Chức năng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pChucNang.setBounds(829, 5, 369, 124);
		pTab2.add(pChucNang);
		pChucNang.setLayout(null);
		
		JButton btnXoaTrong = new JButton("Xóa Trống");
		btnXoaTrong.setBackground(Color.ORANGE);
		btnXoaTrong.setIcon(new ImageIcon(a.class.getResource("/image/Recycle-Bin-Full-icon.png")));
		btnXoaTrong.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnXoaTrong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXoaTrong.setBounds(20, 22, 153, 40);
		pChucNang.add(btnXoaTrong);
		
		JButton btnXuatHD = new JButton("Xuất Hóa Đơn");
		btnXuatHD.setBackground(new Color(169, 169, 169));
		btnXuatHD.setIcon(new ImageIcon(a.class.getResource("/image/Printer-icon.png")));
		btnXuatHD.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnXuatHD.setBounds(20, 75, 330, 37);
		pChucNang.add(btnXuatHD);
		
		JButton btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.setBackground(new Color(255, 160, 122));
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLamMoi.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnLamMoi.setIcon(new ImageIcon(a.class.getResource("/image/Refresh-icon (1).png")));
		btnLamMoi.setBounds(190, 22, 160, 40);
		pChucNang.add(btnLamMoi);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Thông tin hóa đơn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(0, 139, 1503, 241);
		pTab2.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 20, 1483, 211);
		panel.add(scrollPane);
		
		JTable table1 = new JTable();
		scrollPane.setViewportView(table1);
		DefaultTableModel tableModel1;
		String[] header1 = {"Mã Hóa Đơn", "Mã Khách Hàng", "Tên Khách Hàng", "CMND/TCC", "Mã Nhân Viên", "Tên Nhân viên", "Ngày LHD", "Tổng Tiền"};
		tableModel1 = new DefaultTableModel(header1, 0){
	       @Override
	       public boolean isCellEditable(int i, int i1) {
	           return false; //To change body of generated methods, choose Tools | Templates.
	       }
		};
		scrollPane.setViewportView(table1);
		HoaDonFacade hoaDonFacade = (HoaDonFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/hoaDonFacade");
		tableModel1 = hoaDonFacade.getAllOrder();
		table1.setModel(tableModel1);
		table1.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 13));
		table1.setRowHeight(25);
		table1.setAutoCreateRowSorter(true);
		table1.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Thông tin chi tiết hóa đơn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(0, 395, 1503, 234);
		pTab2.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 24, 1483, 200);
		panel_1.add(scrollPane_1);
		
		JTable table2 = new JTable();
		scrollPane_1.setViewportView(table2);
		DefaultTableModel tableModel2;
		String[] header2 = {"Mã Hóa Đơn", "Mã Xe", "Tên Xe", "Loại Xe", "Phiên Bản", "Màu xe", "Phân Khối", "Hãng Sản Xuất", "Số Khung", "Số Máy", "Đơn Giá", "Thuế VAT", "Thành tiền"};
		tableModel1 = new DefaultTableModel(header2, 0){
	       @Override
	       public boolean isCellEditable(int i, int i1) {
	           return false; //To change body of generated methods, choose Tools | Templates.
	       }
		};
		scrollPane_1.setViewportView(table2);

		table2.setModel(tableModel1);
		table2.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 13));
		table2.setRowHeight(25);
		table2.setAutoCreateRowSorter(true);
		table2.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(1215, 10, 288, 119);
		pTab2.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblHinhAnh = new JLabel("         Chưa có hình ảnh");
		lblHinhAnh.setBounds(10, 5, 268, 104);
		panel_2.add(lblHinhAnh);
		lblHinhAnh.setForeground(Color.RED);

		//
		txtMaHD.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		
		txtTenKH.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		
		txtMaKH.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		
		
	}
}
