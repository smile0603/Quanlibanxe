	package ui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import businesslogic.facade.HoaDonFacade;
import businesslogic.facade.NhaCungCapFacade;
import entity.NhaCungCap;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class UI_NhaCungCap extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMaNCC;
	private JTextField txtDiaChi;
	private JTextField txtEmail;
	private JTextField txtTenNCC;
	private JTable table;
	private JTable table_1;
	private JTextField txtTim;
	private JTextField txtDem;
	private DefaultTableModel tableModel;
	private JTextField txtSDT;
	private JTextArea txtChuThich;
	private NhaCungCapFacade nhaCungCapFacade = (NhaCungCapFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/nhaCungCapFacade");
	//private Dao_NhaCungCap dao_ncc= new Dao_NhaCungCap();
	private ArrayList<String> tenncc;
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
					UI_NhaCungCap frame = new UI_NhaCungCap();
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
	 * @throws NotBoundException 
	 * @throws RemoteException 
	 * @throws MalformedURLException 
	 */
	public UI_NhaCungCap() throws MalformedURLException, RemoteException, NotBoundException {
//		try {
//			ConnectDB.getInstance().connect();
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
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
		setBounds(100, 100, screen.width, screen.height);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlightText);
		contentPane.setForeground(Color.RED);
		contentPane.setBorder(UIManager.getBorder("FormattedTextField.border"));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(SystemColor.control);
		panel_4.setBounds(0, 0, 1610, 777);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 73, 1100, 167);
		panel_4.add(panel);
		panel.setForeground(UIManager.getColor("CheckBox.focus"));
		panel.setBackground(SystemColor.control);
		TitledBorder t= new TitledBorder(null, "Th\u00F4ng Tin Nh\u00E0 Cung C\u1EA5p", TitledBorder.LEADING, TitledBorder.TOP, null, null);
		t.setTitleFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.setBorder(t);
		panel.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(null);
		panel_3.setBackground(SystemColor.control);
		panel_3.setBounds(10, 20, 1080, 137);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("M\u00E3 Nh\u00E0 Cung C\u1EA5p");
		lblNewLabel.setBounds(10, 10, 123, 31);
		panel_3.add(lblNewLabel);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblTnNhCung = new JLabel("T\u00EAn Nh\u00E0 Cung C\u1EA5p");
		lblTnNhCung.setBounds(10, 55, 123, 31);
		panel_3.add(lblTnNhCung);
		lblTnNhCung.setForeground(Color.BLACK);
		lblTnNhCung.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblNewLabel_1 = new JLabel("Ch\u00FA Th\u00EDch");
		lblNewLabel_1.setBounds(571, 96, 89, 31);
		panel_3.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		HoaDonFacade hoaDonFacade = (HoaDonFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/hoaDonFacade");
		//Dao_HoaDon dao_hd = new Dao_HoaDon();
		String maHDTail = hoaDonFacade.getMaHDTail("maNhaCungCap", "NhaCungCap");
		String[] parts = maHDTail.split("_");
		int soHD = Integer.parseInt(parts[1]);
		String maKH = "NCC_" + String.format("%04d", soHD);
		
		txtMaNCC = new JTextField();
		txtMaNCC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		//txtMaNCC.setBackground(Color.WHITE);
		txtMaNCC.setBounds(146, 11, 294, 31);
		txtMaNCC.setText(maKH);
		txtMaNCC.setEditable(false);
		panel_3.add(txtMaNCC);
		txtMaNCC.setColumns(10);
		
		txtTenNCC = new JTextField();
		txtTenNCC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTenNCC.setBounds(146, 56, 294, 31);
		panel_3.add(txtTenNCC);
		txtTenNCC.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmail.setBounds(704, 11, 294, 30);
		panel_3.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDiaChi.setBounds(704, 56, 294, 30);
		panel_3.add(txtDiaChi);
		txtDiaChi.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(571, 10, 123, 31);
		panel_3.add(lblEmail);
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblaCh = new JLabel("\u0110\u1ECBa Ch\u1EC9");
		lblaCh.setBounds(571, 55, 89, 31);
		panel_3.add(lblaCh);
		lblaCh.setForeground(Color.BLACK);
		lblaCh.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		 txtChuThich = new JTextArea();
		txtChuThich.setBounds(704, 100, 294, 27);
		panel_3.add(txtChuThich);
		txtChuThich.setToolTipText("");
		txtChuThich.setBackground(Color.WHITE);
		txtChuThich.setLineWrap(true);
		txtChuThich.setWrapStyleWord(true);
		
		JLabel lblSo = new JLabel("Số điện thoại");
		lblSo.setBounds(10, 97, 123, 30);
		lblSo.setForeground(Color.BLACK);
		lblSo.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_3.add(lblSo);
		
		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSDT.setBounds(146, 98, 294, 29);
		txtSDT.setColumns(10);
		panel_3.add(txtSDT);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(1134, 73, 358, 167);
		panel_4.add(panel_1);
		panel_1.setBackground(SystemColor.control);
		TitledBorder t2=new TitledBorder(null, "Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null);
		t2.setTitleFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_1.setBorder(t2);
		panel_1.setLayout(null);
		
		JButton btnThem = new JButton("Th\u00EAm");
		btnThem.setFont(new Font("Dialog", Font.PLAIN, 14));
		
		// ham them
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnThem.setIcon(new ImageIcon("img1/add.png"));
		btnThem.setToolTipText("");
		btnThem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if(validData() && XetTenNCC(txtTenNCC.getText())==false) {
						  
						String ma= txtMaNCC.getText();
						String ten=txtTenNCC.getText();
						String diachi=txtDiaChi.getText();
						String email= txtEmail.getText();
						String sodt= txtSDT.getText();
						String chuThich=txtChuThich.getText();
						NhaCungCap ncc= new NhaCungCap(ma, ten, diachi, chuThich, sodt, email);
						try {
							if(nhaCungCapFacade.themNCC(ncc)) {
								String maHDTail = hoaDonFacade.getMaHDTail("maNhaCungCap", "NhaCungCap");
					    		String[] parts = maHDTail.split("_");
					    		int soHD = Integer.parseInt(parts[1]) + 1;
					    		@SuppressWarnings("unused")
								String maKH = "KH_" + String.format("%04d", soHD);
					    		JFrame f= new JFrame();
					    		JOptionPane.showMessageDialog(f, "Thêm hãng sản xuất thành công !!!");
					    		txtMaNCC.setText("");
								txtTenNCC.setText("");
								txtDiaChi.setText("");
								txtEmail.setText("");
								txtSDT.setText("");
								txtChuThich.setText("");
								txtTenNCC.requestFocus();
					    		tableModel.addRow(new Object[] {ncc.getMaNhaCungCap(),ncc.getTenNhaCungCap(),ncc.getDiaChi(),ncc.getEmail(),ncc.getSoDienThoai(),ncc.getChuThich()});
					    		dem();
							}	
						} catch (Exception e2) {
							// TODO: handle exception
							e2.printStackTrace();
						}
				
			  }else {
				  JOptionPane.showMessageDialog(null, "Đã trùng tên nhà cung cấp");
			  }
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		/*
		 * Image img = new
		 * ImageIcon(this.getClass().getResource("/add.ico")).getImage();
		 */
		btnThem.setBackground(new Color(0, 100, 0));
		btnThem.setBounds(20, 22, 149, 52);
		panel_1.add(btnThem);
		
		JButton btnXoa = new JButton("X\u00F3a");
		btnXoa.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnXoa.setIcon(new ImageIcon("G:\\HKI-Nam 3\\PTUD\\QuanLyBanXe\\branches\\Develop\\img1\\Close-2-icon.png"));
		
		
		// ham xoa
		btnXoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row=table_1.getSelectedRow();
				try {
					if(row!=-1) {
						JFrame f= new JFrame();
						int hoi=JOptionPane.showConfirmDialog(f, "Nhà cung cấp này sẽ bị xóa","Chú ý", JOptionPane.YES_NO_OPTION);
						if(hoi==JOptionPane.YES_OPTION) {
							int r= table_1.getSelectedRow();
							tableModel.removeRow(r);
							xoaNCC();
							dem();
						}
					}
					else
						JOptionPane.showMessageDialog(null, "Vui lòng chọn nhà cung cấp để xóa");
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnXoa.setBackground(new Color(220, 20, 60));
		btnXoa.setBounds(192, 22, 149, 52);
		panel_1.add(btnXoa);
		
		JButton btnCapNhat = new JButton("C\u1EADp nh\u1EADt");
		btnCapNhat.setFont(new Font("Dialog", Font.PLAIN, 14));
		
		//ham cap nhat
		btnCapNhat.setIcon(new ImageIcon("img1/update.png"));
		btnCapNhat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row=table_1.getSelectedRow();
			 if(validData()) {
				 try {
						if(row!=-1) {
							JFrame f= new JFrame();
							int hoi=JOptionPane.showConfirmDialog(f, "Nhà cung cấp sẽ được cập nhật","",JOptionPane.YES_NO_OPTION);
							if(hoi==JOptionPane.YES_OPTION) {
								String ma= txtMaNCC.getText();
								String ten=txtTenNCC.getText();
								String diachi=txtDiaChi.getText();
								String email= txtEmail.getText();
								String sodt= txtSDT.getText();
								String chuThich=txtChuThich.getText();
								NhaCungCap ncc= new NhaCungCap(ma, ten, diachi, chuThich, sodt, email);
								if(nhaCungCapFacade.update(ncc)) {
									update();
									JOptionPane.showMessageDialog(null, "Thay đổi thông tin thành công !!!");
								}
								txtMaNCC.setText("");
								txtTenNCC.setText("");
								txtDiaChi.setText("");
								txtEmail.setText("");
								txtSDT.setText("");
								txtChuThich.setText("");
								txtTenNCC.requestFocus();
								try {
									loadNCC();
								} catch (Exception e2) {
									// TODO: handle exception
									e2.printStackTrace();
								}
							}
						}
						else
							JOptionPane.showMessageDialog(null, "Vui lòng chọn nhà cung cấp cần cập nhật");
					} catch (Exception e2) {
						// TODO: handle exception
					}
			 }
				
			}
		});
		btnCapNhat.setBackground(new Color(30, 144, 255));
		btnCapNhat.setBounds(20, 94, 149, 52);
		panel_1.add(btnCapNhat);
		
		JButton btnXoaTrang = new JButton("Làm Mới");
		btnXoaTrang.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnXoaTrang.setIcon(new ImageIcon("img1/refresh.png"));
		btnXoaTrang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//HoaDonFacade hoaDonFacade = (HoaDonFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/hoaDonFacade");
				try {
					String maKH = hoaDonFacade.getMaHDTail("maNhaCungCap", "NhaCungCap");
					txtMaNCC.setText(maKH);
					txtTenNCC.setText("");
					txtDiaChi.setText("");
					txtEmail.setText("");
					txtSDT.setText("");
					txtChuThich.setText("");
					txtTenNCC.requestFocus();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnXoaTrang.setBackground(new Color(152, 251, 152));
		btnXoaTrang.setBounds(192, 94, 149, 52);
		panel_1.add(btnXoaTrang);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(SystemColor.control);
		panel_6.setBounds(10, 335, 1494, 313);
		panel_4.add(panel_6);
		panel_6.setLayout(null);
		String[] header= {"Mã Nhà Cung Cấp","Tên Nhà Cung Cấp", "Địa Chỉ", "Email", "Số Điện Thoại","Ghi Chú"};
		tableModel = new DefaultTableModel(header, 0);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		scrollPane.setBounds(0, 0, 1481, 303);
		panel_6.add(scrollPane);
		table_1 = new JTable(tableModel);
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=table_1.getSelectedRow();
				txtMaNCC.setText(tableModel.getValueAt(i, 0).toString());
				txtTenNCC.setText(tableModel.getValueAt(i, 1).toString());
				txtDiaChi.setText(tableModel.getValueAt(i, 2).toString());
				txtEmail.setText(tableModel.getValueAt(i, 3).toString());
				txtSDT.setText(tableModel.getValueAt(i, 4).toString());
				txtChuThich.setText(tableModel.getValueAt(i, 5).toString());
			}
		});
		table_1.setBorder(null);
		table_1.setRowHeight(20);
		table_1.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 14));
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(table_1);
		//Load Dá»¯ liá»‡u lÃªn báº£ng
		try {
			loadNCC();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JPanel panel_7 = new JPanel();
		TitledBorder t1=new TitledBorder(null, "T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, null);
		t1.setTitleFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_7.setBorder(t1);
		panel_7.setBackground(SystemColor.control);
		panel_7.setBounds(10, 250, 1100, 75);
		panel_4.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Nhập mã hoặc tên nhà cung cấp cần tìm");
		lblNewLabel_4.setForeground(Color.BLACK);
		
		JLabel lblNewLabel_5 = new JLabel("Nhập mã nhà cung cấp cần tìm");
		lblNewLabel_5.setForeground(new Color(0, 128, 0));

		JLabel lblNewLabel_6 = new JLabel("Nhập thông tin nhà cung cấp cần tìm");
		lblNewLabel_6.setForeground(Color.BLACK);

		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(10, 26, 309, 27);
		panel_7.add(lblNewLabel_4);
		
		txtTim = new JTextField();
		txtTim.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					if(txtTim.getText().length()>0) {
						timNCC();
					}
					else {
						loadNCC();
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
		});
		txtTim.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTim.setBounds(329, 24, 376, 29);
		panel_7.add(txtTim);
		txtTim.setColumns(10);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new MatteBorder(1, 1, 1, 1, (Color) SystemColor.controlShadow));
		panel_8.setBackground(SystemColor.control);
		panel_8.setBounds(1134, 255, 358, 65);
		panel_4.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel lblNewLabel_7= new JLabel("Số lượng nhà cung cấp :");
		lblNewLabel_7.setForeground(new Color(0, 128, 0));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_7.setBounds(9, 8, 154, 40);
		panel_8.add(lblNewLabel_7);
		
		
		txtDem = new JTextField();
		txtDem.setEditable(false);
		txtDem.setForeground(Color.RED);
		txtDem.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtDem.setBackground(SystemColor.control);
		txtDem.setHorizontalAlignment(SwingConstants.CENTER);
		txtDem.setBounds(179, 12, 165, 40);
		panel_8.add(txtDem);
		txtDem.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("QUẢN LÝ THÔNG TIN NHÀ CUNG CẤP");
		lblNewLabel_1_1.setForeground(new Color(184, 134, 11));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_1.setBounds(10, 10, 611, 53);
		panel_4.add(lblNewLabel_1_1);
		dem();
		table = new JTable();
	
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setCellSelectionEnabled(true);
		table.setBounds(10, 267, 1181, -260);
		
	}
	//
	//HÃ m load database
	private void loadNCC() throws SQLException, MalformedURLException, RemoteException, NotBoundException {
		NhaCungCapFacade nhaCungCapFacade = (NhaCungCapFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/nhaCungCapFacade");
		//Dao_NhaCungCap dao_ncc = new Dao_NhaCungCap();
		tableModel = nhaCungCapFacade.getAllNCC();
		table_1.setModel(tableModel);
	}
	//HÃ m xÃ³a 
	private void xoaNCC() throws SQLException, MalformedURLException, RemoteException, NotBoundException {
		NhaCungCapFacade nhaCungCapFacade = (NhaCungCapFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/nhaCungCapFacade");
		//Dao_NhaCungCap dao_ncc = new Dao_NhaCungCap();
		nhaCungCapFacade.xoaNCC(txtMaNCC.getText());
		//loadNCC();
	}
	
	private void update() {
		for(int i =0 ; i<table.getRowCount();i++) {
			if(txtMaNCC.getText().equalsIgnoreCase(table.getValueAt(i, 0).toString())) {
				table.setValueAt(txtTenNCC.getText(),i, 1);
				table.setValueAt(txtDiaChi.getText(),i, 2);
				table.setValueAt(txtEmail.getText(),i, 3);
				table.setValueAt(txtSDT.getText(),i, 4);
				table.setValueAt(txtChuThich.getText(),i, 5);
			}
		}
	}
	//TÃ¬m kiáº¿m
	private void timNCC() throws SQLException, MalformedURLException, RemoteException, NotBoundException{
		NhaCungCapFacade nhaCungCapFacade = (NhaCungCapFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/nhaCungCapFacade");
		//Dao_NhaCungCap dao_ncc= new Dao_NhaCungCap();
		tableModel = nhaCungCapFacade.timKiem("%"+txtTim.getText()+"%");
		table_1.setModel(tableModel);
	}
	public void dem() throws RemoteException {
		int kq = nhaCungCapFacade.demNhaCungCap();
		String aa = String.valueOf(kq);
		txtDem.setText(aa);
//		try {
//			ConnectDB.getInstance();
//			Connection con = ConnectDB.getCon();
//			String sql = "select count(maNhaCungCap) from nhaCungCap ";
//			PreparedStatement pst=con.prepareStatement(sql);
//			ResultSet rs = pst.executeQuery();
//			if(rs.next()) {
//				String count=rs.getString(1);
//				txtDem.setText(count);
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		
	}
	
	public ArrayList<String> xettenncc() throws RemoteException {
		tenncc = new ArrayList<String>();
		tenncc = nhaCungCapFacade.getListTenNhaCC();
//		try {
//			ConnectDB.getInstance();
//			Connection con = ConnectDB.getCon();
//			String sql = "Select tenNhaCungCap from NhaCungCap";
//			Statement statement = con.createStatement();
//			ResultSet rs = statement.executeQuery(sql);
//			while (rs.next()) {
//				String ten;
//				ten = rs.getString(1);
//				tenncc.add(ten);
//			}
//		}catch (SQLException e) { 
//			// TODO: handle exception
//			e.printStackTrace();
//		}
		return tenncc;
	}
	public boolean XetTenNCC(String ten) throws RemoteException {
		List<String> list = xettenncc();
		for(String i:list) {
			if(i.equalsIgnoreCase(ten))
				return true;
			
		}
		return false;
	}
	
	
	private boolean validData() {
		//String mancc = txtMaNCC.getText();
		String tenncc = txtTenNCC.getText();
		String sodt = txtSDT.getText();
		@SuppressWarnings("unused")
		String email = txtEmail.getText();
		String diaChi = txtDiaChi.getText();
		String chuThich = txtChuThich.getText();
		if(!(tenncc.length()>0 && tenncc.matches("^[0-9a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ\\\" +\\r\\n\" + \r\n" + 
				"				\"            \\\"ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ\\\" +\\r\\n\" + \r\n" + 
				"				\"            \\\"ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\\\\\\\s/\\\\\\\\.]+$"))) {
			JOptionPane.showMessageDialog(null, "Tên nhà cung cấp không để trống và không chứa các ký tự đặc biệt và không trùng" );
			return false;
		}
		if(!(sodt.length()>0 && sodt.matches("\\d{10}"))) {
			JOptionPane.showMessageDialog(null, "Số điện thoại không được trống và phải có 10 số" );
			return false;
		}
		if(!(diaChi.length()>0 && diaChi.matches("^[0-9a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ\\\" +\\r\\n\" + \r\n" + 
				"				\"            \\\"ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ\\\" +\\r\\n\" + \r\n" + 
				"				\"            \\\"ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\\\\\\\s/\\\\\\\\.,]+$"))) {
			JOptionPane.showMessageDialog(null, "Địa chỉ không trống và không chứa kí tự đặc biệt " );
			return false;
		}
		if(!( chuThich.length()>0 &&  chuThich.matches("^[a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ\\\" +\\r\\n\" + \r\n" + 
				"				\"            \\\"ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ\\\" +\\r\\n\" + \r\n" + 
				"				\"            \\\"ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\\\\\\\s]+$"))) {
			JOptionPane.showMessageDialog(null, "Ghi chú không được trống và không chứa kí tự đặc biệt " );
			return false;
		}
		return true;
	}
}
