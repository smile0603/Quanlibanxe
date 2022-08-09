
package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import com.toedter.calendar.JDateChooser;

import businesslogic.facade.HangSanXuatFacade;
import businesslogic.facade.HoaDonFacade;
import businesslogic.facade.LoaiXeFacade;
import businesslogic.facade.NhaCungCapFacade;
import businesslogic.facade.XeFacade;
import entity.HangSanXuat;
import entity.LoaiXe;
import entity.NhaCungCap;
import entity.Xe;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static ui.UI_HoaDon.cbbVehicleName_Bill;

import java.awt.CardLayout;
import javax.swing.border.MatteBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JRadioButton;
import java.awt.GridLayout;
import javax.swing.DefaultComboBoxModel;


public class UI_QuanLyXe extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel getContentPane;
	private JTextField txtMa;
	private JTextField txtTen;
	public static JTextField txtMau;
	private JTextField txtSoKhung;
	private JTextField txtPhanKhoi;
	private JTextField txtGiaNhap;
	private JTextField txtSoMay;
	private JTextField txtImg1;
	private JTextField txtTrangThai;
	private JTable table;
	private JTextField txtTim;
	private JTextField txtPhienBan;
	private JTextArea txtCt;
	private JComboBox<String> cbLoaiXe;
	private JComboBox<String> cbHangSx;
	private JComboBox<String> cbNhaCC;
	private JDateChooser dtNgayNhap;
	private DefaultTableModel tableModel;
	private DefaultTableModel tableModelLoai;
	XeFacade xeFacade = (XeFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/xeFacade");
	LoaiXeFacade loaiXeFacade = (LoaiXeFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/loaiXeFacade");
//	private Dao_QuanLyXe dao_qlXe = new Dao_QuanLyXe();
//	private Dao_LoaiXe dao_loai = new Dao_LoaiXe();
	private JTextField txtMaLoai;
	private JTextField txtTenLoai;
	private JTable tableLoai;
	private JTextField txtTim_1;
	private JTextField txtmaHang;
	private JTextField txttenHang;
	private JTextField txttimHang;
	private JTable table_hang;
	private JTextField txtquocGia;
	private DefaultTableModel tableModelHang;
	private ArrayList<String> tenHang;
	public static  JLabel lbXeConLai,lbXeDaBan;
	private JLabel lblAnh;

	HangSanXuatFacade hangSanXuatFacade = (HangSanXuatFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/hangSanXuatFacade");
	//private Dao_HangSanXuat dao_hsx = new Dao_HangSanXuat();
	public static int check = 0;

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
					UI_QuanLyXe frame = new UI_QuanLyXe();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public UI_QuanLyXe() throws RemoteException, MalformedURLException, NotBoundException {
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
//		try {
//			ConnectDB.getInstance().connect();
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		NhaCungCapFacade nhaCungCapFacade = (NhaCungCapFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/nhaCungCapFacade");
		//Dao_NhaCungCap dao_Ncc = new Dao_NhaCungCap();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(100, 100, screen.width, (screen.height - 50));
		getContentPane = new JPanel();
		getContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(getContentPane);
		getContentPane.setLayout(null);

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(10, 88, 1522, 660);
		panel_5.setLayout(new CardLayout(0, 0));

		JPanel panelXe = new JPanel();

		panel_5.add(panelXe, "name_24132246182000");

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 41, 1502, 255);
		TitledBorder t = new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Th\u00F4ng tin xe", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK);
		t.setTitleFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_4.setBorder(t);

		JLabel lbMaXe = new JLabel("Mã Xe");
		lbMaXe.setBounds(10, 19, 130, 25);
		lbMaXe.setFont(new Font("Tahoma", Font.BOLD, 13));

		txtMa = new JTextField();
		txtMa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMa.setBackground(SystemColor.control);
		txtMa.setEditable(false);
		txtMa.setBounds(144, 20, 208, 23);
		txtMa.setColumns(10);
		String ma = xeFacade.getMaXeTail();
		txtMa.setText(ma);
		

		JLabel lbTenXe = new JLabel("Tên xe");
		lbTenXe.setBounds(10, 63, 130, 25);
		lbTenXe.setFont(new Font("Tahoma", Font.BOLD, 13));

		txtTen = new JTextField();
		txtTen.setDocument(new JTextFieldLimit(30));
		txtTen.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if ((txtTen.getText().length() < 0)) {
					txtTen.setForeground(Color.red);
				}
				if (!(txtTen.getText().matches("^[a-zA-Z0-9 ]+$"))) {
					txtTen.setForeground(Color.red);
				} else {
					txtTen.setForeground(Color.black);
				}
			}
		});
		txtTen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTen.setBounds(144, 61, 208, 23);
		txtTen.setColumns(10);

		JLabel lbMau = new JLabel("Màu xe");
		lbMau.setBounds(10, 102, 130, 25);
		lbMau.setFont(new Font("Tahoma", Font.BOLD, 13));

		txtMau = new JTextField();
		txtMau.setBackground(Color.WHITE);
		txtMau.setEditable(false);
		txtMau.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMau.setBounds(144, 102, 170, 23);
		txtMau.setColumns(10);

		txtSoKhung = new JTextField();
		txtSoKhung.setDocument(new JTextFieldLimit(18));
		txtSoKhung.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (txtSoKhung.getText().length() > 18) {
					return;
				}
				if (txtSoKhung.getText().length() < 18) {
					txtSoKhung.setForeground(Color.red);
				}
				if (!(txtSoKhung.getText().matches("^[a-zA-Z0-9]+$"))) {
					txtTen.setForeground(Color.red);
				} else {
					txtSoKhung.setForeground(Color.black);
				}
			}
		});
		txtSoKhung.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSoKhung.setBounds(144, 145, 208, 23);
		txtSoKhung.setColumns(10);

		JLabel lbSoKhung = new JLabel("Số khung");
		lbSoKhung.setBounds(10, 145, 130, 25);
		lbSoKhung.setFont(new Font("Tahoma", Font.BOLD, 13));

		txtPhanKhoi = new JTextField();
		txtPhanKhoi.setDocument(new JTextFieldLimit(3));
		txtPhanKhoi.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (!(txtPhanKhoi.getText().matches("\\d+"))) {
					txtPhanKhoi.setForeground(Color.red);
				} else
					txtPhanKhoi.setForeground(Color.black);
			}
		});
		txtPhanKhoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPhanKhoi.setBounds(557, 187, 208, 23);
		txtPhanKhoi.setColumns(10);

		JLabel lbPhanKhoi = new JLabel("Phân khối");
		lbPhanKhoi.setBounds(417, 189, 130, 25);
		lbPhanKhoi.setFont(new Font("Tahoma", Font.BOLD, 13));

		JLabel lbNhaCungCap = new JLabel("Nhà cung cấp");
		lbNhaCungCap.setBounds(417, 19, 130, 25);
		lbNhaCungCap.setFont(new Font("Tahoma", Font.BOLD, 13));

		ArrayList<NhaCungCap> listNCC = xeFacade.getAllNCC();
		cbNhaCC = new JComboBox(nhaCungCapFacade.getListSuppilerName().toArray());
		cbNhaCC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbNhaCC.setBackground(Color.WHITE);

		panel_4.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				List<String> listSupplierName;
				try {
					listSupplierName = nhaCungCapFacade.getListSuppilerName();
					int soLuongCBB = cbNhaCC.getItemCount();
					int soLuongListSupperlier = listSupplierName.size();
					if (soLuongCBB < soLuongListSupperlier)
						cbNhaCC.addItem(listSupplierName.get(soLuongListSupperlier - 1));
					else if (soLuongCBB > soLuongListSupperlier) {
						cbNhaCC.removeAllItems();
						Collections.sort(listSupplierName);
						for (String ncc : listSupplierName)
							cbNhaCC.addItem(ncc);
					}
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}

			public void ancestorMoved(AncestorEvent event) {
			}

			public void ancestorRemoved(AncestorEvent event) {
			}
		});

		cbNhaCC.setBounds(557, 22, 206, 23);
		JLabel lbHang = new JLabel("Hãng sản xuất");
		lbHang.setBounds(417, 63, 130, 25);
		lbHang.setFont(new Font("Tahoma", Font.BOLD, 13));

		cbHangSx = new JComboBox<String>();
		cbHangSx.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbHangSx.setBackground(Color.WHITE);
		cbHangSx.setBounds(557, 62, 206, 23);
		ArrayList<HangSanXuat> listHang = xeFacade.getAllHangSX();
		for (HangSanXuat hangSanXuat : listHang) {
			cbHangSx.addItem(hangSanXuat.getTenHangSX());
		}

		JLabel lbLoai = new JLabel("Loại xe");
		lbLoai.setBounds(417, 102, 130, 25);
		lbLoai.setFont(new Font("Tahoma", Font.BOLD, 13));

		ArrayList<LoaiXe> dsLoai = xeFacade.getAllLoaiXe();
		cbLoaiXe = new JComboBox<String>();
		cbLoaiXe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbLoaiXe.setBackground(Color.WHITE);
		cbLoaiXe.setBounds(557, 101, 206, 23);
		for (LoaiXe loaiXe : dsLoai) {
			cbLoaiXe.addItem(loaiXe.getTenLoaiXe());
		}

		txtGiaNhap = new JTextField();
		txtGiaNhap.setDocument(new JTextFieldLimit(15));
		txtGiaNhap.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				double money;
				NumberFormat num = NumberFormat.getNumberInstance();
				if (txtGiaNhap.getText().equalsIgnoreCase("")) {

				} else if (isNumeric(txtGiaNhap.getText().substring(txtGiaNhap.getText().length() - 1)) == true) {
					txtGiaNhap.setForeground(Color.black);
					try {
						money = num.parse(txtGiaNhap.getText()).doubleValue();
						txtGiaNhap.setText(num.format(money));
					} catch (NumberFormatException | ParseException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
						txtGiaNhap.setForeground(Color.red);
					}
				} else
					txtGiaNhap.setForeground(Color.red);
				;
			}
		});

		txtGiaNhap.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtGiaNhap.setBounds(557, 145, 170, 23);
		txtGiaNhap.setColumns(10);

		JLabel lbGia = new JLabel("Giá nhập");
		lbGia.setBounds(417, 145, 130, 25);
		lbGia.setFont(new Font("Tahoma", Font.BOLD, 13));

		JLabel lbTrangThai = new JLabel("Trạng thái");
		lbTrangThai.setBounds(828, 24, 130, 25);
		lbTrangThai.setFont(new Font("Tahoma", Font.BOLD, 13));

		JLabel lbNgay = new JLabel("Ngày nhập");
		lbNgay.setBounds(828, 145, 130, 25);
		lbNgay.setFont(new Font("Tahoma", Font.BOLD, 13));

		JLabel lbHinhAnh1 = new JLabel("Hình ảnh 1");
		lbHinhAnh1.setBounds(828, 102, 130, 25);
		lbHinhAnh1.setFont(new Font("Tahoma", Font.BOLD, 13));

		JLabel lbSoMay = new JLabel("Số Máy");
		lbSoMay.setBounds(10, 189, 130, 25);
		lbSoMay.setFont(new Font("Tahoma", Font.BOLD, 13));

		JLabel lbChuThich = new JLabel("Chú thích");
		lbChuThich.setBounds(828, 189, 130, 25);
		lbChuThich.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtSoMay = new JTextField();
		txtSoMay.setDocument(new JTextFieldLimit(7));
		txtSoMay.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (txtSoMay.getText().length() < 7) {
					txtSoMay.setForeground(Color.red);
				}
				if (!(txtSoMay.getText().matches("^[a-zA-Z0-9]+$"))) {
					txtSoMay.setForeground(Color.red);
				} else {
					txtSoMay.setForeground(Color.black);
				}
			}
		});
		txtSoMay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSoMay.setBackground(Color.WHITE);
		txtSoMay.setBounds(144, 189, 208, 25);
		txtSoMay.setColumns(10);

		txtImg1 = new JTextField();
		txtImg1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtImg1.setEditable(false);
		txtImg1.setBackground(Color.WHITE);
		txtImg1.setBounds(962, 104, 170, 23);
		txtImg1.setColumns(10);
		panelXe.setLayout(null);
		panelXe.add(panel_4);
		panel_4.setLayout(null);

		lblAnh = new JLabel("Chưa có hình ảnh");
		lblAnh.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAnh.setBackground(Color.WHITE);
		lblAnh.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnh.setBounds(1202, 10, 291, 218);
		panel_4.add(lblAnh);
		panel_4.add(lbMaXe);
		panel_4.add(txtMa);
		panel_4.add(lbTenXe);
		panel_4.add(txtTen);
		panel_4.add(lbMau);
		panel_4.add(txtMau);
		panel_4.add(lbSoKhung);
		panel_4.add(txtSoKhung);
		panel_4.add(lbPhanKhoi);
		panel_4.add(txtPhanKhoi);
		panel_4.add(lbTrangThai);
		panel_4.add(lbGia);
		panel_4.add(lbLoai);
		panel_4.add(txtGiaNhap);
		panel_4.add(cbLoaiXe);
		panel_4.add(lbHang);
		panel_4.add(cbHangSx);
		panel_4.add(lbNhaCungCap);
		panel_4.add(cbNhaCC);
		panel_4.add(lbNgay);
		panel_4.add(lbHinhAnh1);
		panel_4.add(txtImg1);
		panel_4.add(lbSoMay);
		panel_4.add(txtSoMay);
		panel_4.add(lbChuThich);

		txtTrangThai = new JTextField();
		txtTrangThai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTrangThai.setEditable(false);
		txtTrangThai.setText("Còn hàng");
		txtTrangThai.setColumns(10);
		txtTrangThai.setBounds(962, 20, 208, 23);
		panel_4.add(txtTrangThai);
		txtCt = new JTextArea();
		txtCt.setFont(new Font("Courier New", Font.PLAIN, 14));
		txtCt.setBounds(962, 194, 208, 34);
		panel_4.add(txtCt);
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
		JButton btnImg1 = new JButton("...");
		btnImg1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnImg1.setBackground(Color.LIGHT_GRAY);
		btnImg1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser fileChooser = new JFileChooser("D:\\nam4ky1\\LapTrinhPhanTan\\BAITAPDOAN\\QuanLyBanXe_Client\\HinhAnhXe");
				fileChooser.setBackground(Color.gray);
				FileNameExtensionFilter filter = new FileNameExtensionFilter(".png .jpg", "png", "jpg", "Img");
				fileChooser.setFileFilter(filter);
				int result = fileChooser.showSaveDialog(getParent());

				if (result == JFileChooser.APPROVE_OPTION) {
					File selectFile = fileChooser.getSelectedFile();
					String file = selectFile.toString();
					String[] link = file.split("(?=HinhAnhXe)");
					txtImg1.setText(link[1]);
					BufferedImage img = null;
					try {
						img = ImageIO.read(new File(txtImg1.getText()));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					Image dimg = img.getScaledInstance(lblAnh.getWidth(), lblAnh.getHeight(), Image.SCALE_SMOOTH);
					ImageIcon imageIcon = new ImageIcon(dimg);
					lblAnh.setIcon(imageIcon);
				}
			}
		});
		btnImg1.setBounds(1135, 102, 34, 25);
		panel_4.add(btnImg1);

		dtNgayNhap = new JDateChooser();
		dtNgayNhap.setBounds(962, 144, 208, 23);
		dtNgayNhap.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_4.add(dtNgayNhap);
		dtNgayNhap.setDate(Date.valueOf(LocalDate.now()));
		String[] header = { "Mã Xe", "Tên Xe", "Màu xe", "Loại xe", "Hãng sản xuất", "Nhà cung cấp", "Quốc gia",
				"Phân khối", "Số lượng", "Giá nhập", "Ngày nhập", "Trạng thái", "Chú thích", "Tổng tiền" };
		tableModel = new DefaultTableModel(header, 0);
		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setBounds(0, 442, 1502, 219);
		panelXe.add(scrollPane);

		table = new JTable(tableModel);
//		ArrayList<Xe> listXe= dao_qlXe.getInfoXe("Xetest");
//		txtImg1.setText(listXe.get(0).getImg1());
		table.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtMa.setForeground(Color.black);
				txtTen.setForeground(Color.black);
				txtMau.setForeground(Color.black);
				cbLoaiXe.setForeground(Color.black);
				cbHangSx.setForeground(Color.black);
				cbNhaCC.setForeground(Color.black);
				txtPhanKhoi.setForeground(Color.black);
				txtSoKhung.setForeground(Color.black);
				txtGiaNhap.setForeground(Color.black);
				dtNgayNhap.setForeground(Color.black);
				txtTrangThai.setForeground(Color.black);
				txtCt.setForeground(Color.black);
				txtPhienBan.setForeground(Color.black);
				txtImg1.setForeground(Color.black);
				txtSoMay.setForeground(Color.black);
				txtTen.requestFocus();
				int i = table.getSelectedRow();
				txtMa.setText(tableModel.getValueAt(i, 0).toString());
				txtTen.setText(tableModel.getValueAt(i, 1).toString());
				txtMau.setText(tableModel.getValueAt(i, 2).toString());
				cbLoaiXe.setSelectedItem(tableModel.getValueAt(i, 3));
				cbHangSx.setSelectedItem(tableModel.getValueAt(i, 4));
				cbNhaCC.setSelectedItem(tableModel.getValueAt(i, 5));
				txtPhanKhoi.setText(tableModel.getValueAt(i, 7).toString());
				String giaNhap11 = tableModel.getValueAt(i, 8).toString();
				for (String w : giaNhap11.split("\\s", 1)) {
				txtGiaNhap.setText(w);
					  }
				dtNgayNhap.setDate(Date.valueOf(LocalDate.parse(tableModel.getValueAt(i, 9).toString())));
				txtTrangThai.setText(tableModel.getValueAt(i, 10).toString());
				txtPhienBan.setText(tableModel.getValueAt(i, 11).toString());
				txtSoKhung.setText(tableModel.getValueAt(i, 12).toString());
				txtSoMay.setText(tableModel.getValueAt(i, 13).toString());
				txtCt.setText(tableModel.getValueAt(i, 14).toString());
				txtImg1.setText(tableModel.getValueAt(i, 16).toString());

				if (tableModel.getValueAt(i, 16).toString().length() == 0) {
					lblAnh.setIcon(null);
					lblAnh.setText("Chưa có hình ảnh");
				} else {
					BufferedImage img = null;
					try {
						img = ImageIO.read(new File(txtImg1.getText()));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					Image dimg = img.getScaledInstance(lblAnh.getWidth(), lblAnh.getHeight(), Image.SCALE_SMOOTH);
					ImageIcon imageIcon = new ImageIcon(dimg);
					lblAnh.setIcon(imageIcon);
				}
			}
		});
		scrollPane.setViewportView(table);
		try {
			loadXe();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JPanel panel_6 = new JPanel();
		TitledBorder ttimkiemxe=new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"T\u00ECm Ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0));
		ttimkiemxe.setTitleFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_6.setBorder(ttimkiemxe);
		panel_6.setBackground(SystemColor.control);
		panel_6.setBounds(0, 298, 700, 70);
		panelXe.add(panel_6);
		panel_6.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Nhập mã xe hoặc tên xe cần tìm");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(10, 10, 251, 40);
		panel_6.add(lblNewLabel_3);

		txtTim = new JTextField();
		txtTim.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTim.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (txtTim.getText().length() >= 1) {
					try {
						timXe();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if (txtTim.getText().length() < 1) {
					try {
						loadXe();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		txtTim.setBounds(309, 20, 321, 26);
		panel_6.add(txtTim);
		txtTim.setColumns(10);

		JPanel panel_7 = new JPanel();
		TitledBorder tChucNangXe=new TitledBorder(null, "Ch\u1EE9c N\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0));
		tChucNangXe.setTitleFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_7.setBorder(tChucNangXe);
		
		panel_7.setBackground(SystemColor.control);
		panel_7.setBounds(710, 298, 792, 69);
		panelXe.add(panel_7);
		panel_7.setLayout(null);
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnThem.setBackground(new Color(154, 205, 50));
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 13));
		dtNgayNhap.setDateFormatString("yyy-MM-dd");

		txtPhienBan = new JTextField();
		txtPhienBan.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (!(txtPhienBan.getText()
						.matches("^[a-zA-Z0-9_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ\" +\r\n"
								+ "            \"ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ\" +\r\n"
								+ "            \"ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\\\s]+$"))) {
					txtPhienBan.setForeground(Color.red);
				} else {
					txtPhienBan.setForeground(Color.black);
				}
			}
		});
		txtPhienBan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPhienBan.setColumns(10);
		txtPhienBan.setBounds(962, 63, 208, 23);
		panel_4.add(txtPhienBan);

		JLabel lbPhienBan = new JLabel("Phiên Bản");
		lbPhienBan.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbPhienBan.setBounds(828, 63, 130, 25);
		panel_4.add(lbPhienBan);

		JLabel lblNewLabel = new JLabel("VND");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(737, 145, 28, 25);
		panel_4.add(lblNewLabel);

		JButton btnColor = new JButton("New button");
		btnColor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UI_Color ui = new UI_Color();
				ui.setVisible(true);
				ui.setLocationRelativeTo(null);
			}
		});
		btnColor.setBounds(319, 100, 34, 26);
		panel_4.add(btnColor);
		btnThem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if (validDataXe() && KiemTraSoMay() == true) {
						try {
							NhaCungCap ncc = null;
							LoaiXe loai = null;
							HangSanXuat hsx = null;
							String ma = txtMa.getText();
							String ten = txtTen.getText();
							String mau = txtMau.getText();
							String soKhung = txtSoKhung.getText();
							for (int i = 0; i < listNCC.size(); i++) {
								if (cbNhaCC.getSelectedItem().toString()
										.equalsIgnoreCase(listNCC.get(i).getTenNhaCungCap())) {
									ncc = listNCC.get(i);
								}
							}

							for (int i = 0; i < listHang.size(); i++) {
								if (cbHangSx.getSelectedItem().toString()
										.equalsIgnoreCase(listHang.get(i).getTenHangSX())) {
									hsx = listHang.get(i);
								}
							}
							for (int i = 0; i < dsLoai.size(); i++) {
								if (cbLoaiXe.getSelectedItem().toString()
										.equalsIgnoreCase(dsLoai.get(i).getTenLoaiXe())) {
									loai = dsLoai.get(i);
								}
							}
							int phankhoi = Integer.parseInt(txtPhanKhoi.getText());
							String soMay = txtSoMay.getText();
							NumberFormat num = NumberFormat.getNumberInstance();
							double giaNhap = num.parse(txtGiaNhap.getText()).doubleValue();
							String date = ((JTextField) dtNgayNhap.getDateEditor().getUiComponent()).getText();
							Date ngay = Date.valueOf(LocalDate.parse(date));
							String trangThai = txtTrangThai.getText();
							String chuThich = txtCt.getText();
							String img1 = txtImg1.getText();
							String phienBan = txtPhienBan.getText();

							Xe xe = new Xe(ma, ten, phienBan, mau, phankhoi, soKhung, soMay, giaNhap, ngay, trangThai, chuThich, img1);
							xe.setLoaiXe(loai);
							xe.setNhaCungCap(ncc);
							xe.setHangSanXuat(hsx);
							
							boolean kq =xeFacade.themXe(xe);
							if(kq) {
								JOptionPane.showMessageDialog(null, "Thêm thành công !!!");
							}else {
								JOptionPane.showMessageDialog(null, "Thêm that bai !!!");
							}
							lbXeConLai.setText(xeFacade.XeConLai()+" xe");
							lbXeDaBan.setText(xeFacade.XeDaBan()+" xe");
							loadXe();
							Reset();
							cbbVehicleName_Bill.addItem(xe.getTenXe());
						} catch (Exception s) {
							s.printStackTrace();
						}
					} else {
//					JOptionPane("Trùng")
					}
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnThem.setIcon(new ImageIcon("img1\\add.png"));
		btnThem.setToolTipText("");
		btnThem.setBackground(new Color(255, 190, 87));
		btnThem.setBounds(48, 23, 125, 36);
		panel_7.add(btnThem);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnXoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				try {
					if (row != -1) {
						JFrame f = new JFrame();
						int hoi = JOptionPane.showConfirmDialog(f, "Xe " + txtTen.getText() + " sẽ bị xóa", "Cảnh báo",
								JOptionPane.YES_NO_OPTION);
						if (hoi == JOptionPane.YES_OPTION) {
							int r = table.getSelectedRow();
							if (xoaXe()) {
								tableModel.removeRow(r);
								//FillCombo combo = new FillCombo();
//								try {
//									combo.fill(
//											"select DISTINCT tenXe from Xe where trangThai = N'Còn hàng' order by tenXe",
//											cbbVehicleName_Bill, "tenXe");
//								} catch (SQLException e2) {
//									e2.printStackTrace();
//								}
								Reset();
								lbXeConLai.setText(xeFacade.XeConLai()+" xe");
								lbXeDaBan.setText(xeFacade.XeDaBan()+" xe");
							} else
								JOptionPane.showMessageDialog(null, "Bạn Không thể xóa xe này!");
						}
					} else
						JOptionPane.showMessageDialog(null, "Vui lòng chọn xe để xóa !!!");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Bạn không thể xóa xe này!");
				}
			}
		});
		btnXoa.setIcon(new ImageIcon("img1\\Close-2-icon.png"));
		btnXoa.setBackground(Color.RED);
		btnXoa.setBounds(225, 23, 125, 36);
		panel_7.add(btnXoa);

		JButton btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCapNhat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				try {
					if (row != -1) {
						if (validDataUpdateXe()) {
							JFrame f = new JFrame();
							int hoi = JOptionPane.showConfirmDialog(f,
									"Xe '" + txtTen.getText() + "' sẽ được cập nhật !!!", "Chú ý ",
									JOptionPane.YES_NO_OPTION);
							if (hoi == JOptionPane.YES_OPTION) {
								NhaCungCap ncc = null;
								LoaiXe loai = null;
								HangSanXuat hsx = null;
								String ma = txtMa.getText();
								String ten = txtTen.getText();
								String mau = txtMau.getText();
								String soKhung = txtSoKhung.getText();
								for (int i = 0; i < listNCC.size(); i++) {
									if (cbNhaCC.getSelectedItem().toString()
											.equalsIgnoreCase(listNCC.get(i).getTenNhaCungCap())) {
										ncc = listNCC.get(i);
									}
								}

								for (int i = 0; i < listHang.size(); i++) {
									if (cbHangSx.getSelectedItem().toString()
											.equalsIgnoreCase(listHang.get(i).getTenHangSX())) {
										hsx = listHang.get(i);
									}
								}
								for (int i = 0; i < dsLoai.size(); i++) {
									if (cbLoaiXe.getSelectedItem().toString()
											.equalsIgnoreCase(dsLoai.get(i).getTenLoaiXe())) {
										loai = dsLoai.get(i);
									}
								}
								int phankhoi = Integer.parseInt(txtPhanKhoi.getText());
								String soMay = txtSoMay.getText();
								NumberFormat num = NumberFormat.getNumberInstance();
								double giaNhap = num.parse(txtGiaNhap.getText()).doubleValue();
								String date = ((JTextField) dtNgayNhap.getDateEditor().getUiComponent()).getText();
								Date ngay = Date.valueOf(LocalDate.parse(date));
								String trangThai = txtTrangThai.getText();
								String chuThich = txtCt.getText();
								String img1 = txtImg1.getText();
								String phienBan = txtPhienBan.getText();
//								Xe xe = new Xe(ma, ten, new LoaiXe(loai), phienBan, mau, new NhaCungCap(ncc),
//										new HangSanXuat(hsx), phankhoi, soKhung, soMay, giaNhap, ngay, trangThai,
//										chuThich, img1);
								Xe xe = new Xe(ma, ten, phienBan, mau, phankhoi, soKhung, soMay, giaNhap, ngay, trangThai, chuThich, img1);
								xe.setHangSanXuat(hsx);
								xe.setNhaCungCap(ncc);
								xe.setLoaiXe(loai);
								xeFacade.capnhatXe(xe);
								try {
									loadXe();
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								Reset();
								JOptionPane.showMessageDialog(null, "Thay đổi thông tin thành công !!!");
								try {
									loadXe();
								} catch (Exception e2) {
									// TODO: handle exception
									e2.printStackTrace();

								}
							}
						}
					} else
						JOptionPane.showMessageDialog(null, "Vui lòng chọn xe cần cập nhật");
				} catch (ParseException e2) {

				} catch (RemoteException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
			}
		});
		btnCapNhat.setIcon(new ImageIcon("img1\\update.png"));
		btnCapNhat.setBackground(Color.BLUE);
		btnCapNhat.setBounds(423, 23, 125, 36);
		panel_7.add(btnCapNhat);

		JButton btnXoaTrang = new JButton("Làm mới ");
		btnXoaTrang.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnXoaTrang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Reset();
			}
		});

		btnXoaTrang.setIcon(new ImageIcon("img1\\refresh.png"));
		btnXoaTrang.setBackground(new Color(0, 153, 51));
		btnXoaTrang.setBounds(608, 23, 125, 36);
		panel_7.add(btnXoaTrang);

		JPanel panelLoai = new JPanel();

		panelLoai.setLayout(null);

		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBounds(0, 10, 1512, 82);
		panelLoai.add(panel_1_2);

		JLabel lblNewLabel_1_2 = new JLabel("DANH SÁCH LOẠI XE");
		lblNewLabel_1_2.setForeground(new Color(184, 134, 11));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_2.setBounds(57, 0, 329, 72);
		panel_1_2.add(lblNewLabel_1_2);

		JLabel lbMaLoai = new JLabel("Mã Loại Xe");
		lbMaLoai.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbMaLoai.setBounds(10, 102, 130, 25);
		panelLoai.add(lbMaLoai);

		txtMaLoai = new JTextField();
		txtMaLoai.setEditable(false);
		txtMaLoai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMaLoai.setColumns(10);
		txtMaLoai.setBounds(144, 102, 287, 25);
		panelLoai.add(txtMaLoai);

		JLabel lbTenLoai = new JLabel("Tên Loại Xe");
		lbTenLoai.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbTenLoai.setBounds(10, 139, 130, 23);
		panelLoai.add(lbTenLoai);

		txtTenLoai = new JTextField();
		txtTenLoai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTenLoai.setColumns(10);
		txtTenLoai.setBounds(144, 137, 287, 25);
		panelLoai.add(txtTenLoai);

		JPanel pnChucNangLoai = new JPanel();
		TitledBorder t1= new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Ch\u1EE9c n\u0103ng", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0));
		t1.setTitleFont(new Font("Tahoma", Font.PLAIN, 13));
		pnChucNangLoai.setBorder(t1);
		
		pnChucNangLoai.setLayout(null);
		pnChucNangLoai.setBackground(SystemColor.control);
		pnChucNangLoai.setBounds(451, 93, 548, 83);
		panelLoai.add(pnChucNangLoai);

		JButton btnThem_1 = new JButton("Thêm");
		btnThem_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThem_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (validDataLoai()) {
					String ma = txtMaLoai.getText();
					String ten = txtTenLoai.getText();
					LoaiXe loai = new LoaiXe(ma, ten);
					tableModel.addRow(new Object[] { loai.getMaLoaiXe(), loai.getTenLoaiXe() });
					try {
						loaiXeFacade.themLoaiXe(loai);
					} catch (RemoteException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}

					try {
						loadLoai();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					ResetLoai();
					JFrame f = new JFrame();
					JOptionPane.showMessageDialog(f, "Thêm Thành Công Loại Xe " + txtTenLoai.getText());
				}

			}
		});
		btnThem_1.setIcon(new ImageIcon("img1\\add.png"));
		btnThem_1.setToolTipText("");
		btnThem_1.setBackground(Color.GREEN);
		btnThem_1.setBounds(10, 22, 125, 51);
		pnChucNangLoai.add(btnThem_1);

		JButton btnXoa_1 = new JButton("Xóa");
		btnXoa_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXoa_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tableLoai.getSelectedRow();
				try {
					if (row != -1) {
						JFrame f = new JFrame();
						int hoi = JOptionPane.showConfirmDialog(f, "Loại xe này này sẽ bị xóa", "Chú ý",
								JOptionPane.YES_NO_OPTION);
						if (hoi == JOptionPane.YES_OPTION) {
							int r = tableLoai.getSelectedRow();
							tableModel.removeRow(r);
							xoaLoaiXe();
							loadLoai();
							ResetLoai();
						}
					} else
						JOptionPane.showMessageDialog(null, "Vui lòng chọn loại xe để xóa");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Loại xe này không thể xóa");
				}
			}
		});
		btnXoa_1.setIcon(new ImageIcon("img1\\Close-2-icon.png"));
		btnXoa_1.setBackground(Color.RED);
		btnXoa_1.setBounds(145, 22, 125, 51);
		pnChucNangLoai.add(btnXoa_1);

		JButton btnCapNhat_1 = new JButton("Cập nhật");
		btnCapNhat_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCapNhat_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tableLoai.getSelectedRow();
				try {
					if (row != -1) {
						if (ValidateUpdateLoai()) {
							Frame f = new JFrame();
							int hoi = JOptionPane.showConfirmDialog(f, "Loại xe này sẽ bị thay đôi !!!", "Chú ý",
									JOptionPane.YES_NO_OPTION);
							if (hoi == JOptionPane.YES_OPTION) {
								String ma = txtMaLoai.getText();
								String ten = txtTenLoai.getText();
								LoaiXe loai = new LoaiXe(ma, ten);
								tableModel.addRow(new Object[] { loai.getMaLoaiXe(), loai.getTenLoaiXe() });
								loaiXeFacade.capnhatLoaiXe(loai);
								ResetLoai();
								try {
									loadLoai();
								} catch (Exception e2) {
									// TODO: handle exception
									e2.printStackTrace();
								}
							}
						}

					} else
						JOptionPane.showMessageDialog(null, "Vui lòng chọn loại xe cần thay đổi !!!");
				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "Mã xe không thể thay đổi");
				}
			}
		});
		btnCapNhat_1.setIcon(new ImageIcon("img1\\update.png"));
		btnCapNhat_1.setBackground(Color.BLUE);
		btnCapNhat_1.setBounds(280, 22, 125, 51);
		pnChucNangLoai.add(btnCapNhat_1);

		JButton btnXoaTrang_1 = new JButton("Làm mới ");
		btnXoaTrang_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ResetLoai();
			}
		});
		btnXoaTrang_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXoaTrang_1.setIcon(new ImageIcon("img1\\refresh.png"));
		btnXoaTrang_1.setBackground(UIManager.getColor("Button.focus"));
		btnXoaTrang_1.setBounds(415, 22, 125, 51);
		pnChucNangLoai.add(btnXoaTrang_1);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(11, 186, 1470, 359);
		panelLoai.add(scrollPane_1);

		String[] headerLoai = { "Mã Loại Xe", "Tên Loại Xe" };
		tableModelLoai = new DefaultTableModel(headerLoai, 0);
		tableLoai = new JTable(tableModelLoai);
		tableLoai.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 14));
		tableLoai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tableLoai.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = tableLoai.getSelectedRow();
				txtMaLoai.setText(tableModelLoai.getValueAt(i, 0).toString());
				txtTenLoai.setText(tableModelLoai.getValueAt(i, 1).toString());
			}
		});
		scrollPane_1.setViewportView(tableLoai);
		try {
			loadLoai();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		JPanel pnTimKiemLoai = new JPanel();
		TitledBorder t2=new TitledBorder(null, "Nh\u1EADp m\u00E3 lo\u1EA1i xe ho\u1EB7c t\u00EAn lo\u1EA1i xe c\u1EA7n t\u00ECm", TitledBorder.LEADING, TitledBorder.TOP, null, null);
		t2.setTitleFont(new Font("Tahoma", Font.PLAIN, 14));
		pnTimKiemLoai.setBorder(t2);
		pnTimKiemLoai.setLayout(null);
		pnTimKiemLoai.setBackground(SystemColor.control);
		pnTimKiemLoai.setBounds(1009, 93, 472, 82);
		panelLoai.add(pnTimKiemLoai);

		txtTim_1 = new JTextField();
		txtTim_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTim_1.setColumns(10);
		txtTim_1.setBounds(10, 31, 303, 29);
		pnTimKiemLoai.add(txtTim_1);

		JButton btn_Tim1 = new JButton("Tìm Kiếm");
		btn_Tim1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btn_Tim1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					timLoai();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn_Tim1.setIcon(new ImageIcon("img1\\search2.png"));
		btn_Tim1.setBackground(new Color(255, 190, 87));
		btn_Tim1.setBounds(337, 23, 125, 49);
		pnTimKiemLoai.add(btn_Tim1);

		JPanel panelHang = new JPanel();
		panelHang.setLayout(null);

		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBounds(0, 0, 1522, 716);
		panelHang.add(panel_3_1);

		JPanel panel_1_2_1 = new JPanel();
		panel_1_2_1.setLayout(null);
		panel_1_2_1.setBounds(0, 10, 1512, 82);
		panel_3_1.add(panel_1_2_1);

		// Hãng Sản Xuất

		JLabel lblNewLabel_1_2_1 = new JLabel("DANH SÁCH HÃNG SẢN XUẤT");
		lblNewLabel_1_2_1.setForeground(new Color(184, 134, 11));
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_2_1.setBounds(57, 0, 384, 72);
		panel_1_2_1.add(lblNewLabel_1_2_1);

		JLabel lblmaHang = new JLabel("Mã Hãng Sản Xuất");
		lblmaHang.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblmaHang.setBounds(0, 102, 130, 27);
		panel_3_1.add(lblmaHang);
		HoaDonFacade hoaDonFacade = (HoaDonFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/hoaDonFacade");
		//Dao_HoaDon dao_hd = new Dao_HoaDon();
		//
		String maHDTail = hoaDonFacade.getMaHDTail("maHangSX", "HangSanXuat");
		String[] parts = maHDTail.split("_");
		int soHD = Integer.parseInt(parts[1]) + 1;
		String makh = "HSX_" + String.format("%04d", soHD);
		txtmaHang = new JTextField();
		txtmaHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtmaHang.setText(makh);
		txtmaHang.setEditable(false);
		txtmaHang.setColumns(10);
		txtmaHang.setBounds(153, 102, 268, 27);
		panel_3_1.add(txtmaHang);

		JLabel lbltenHang = new JLabel("Tên Hãng Sản Xuất");
		lbltenHang.setBackground(new Color(240, 240, 240));
		lbltenHang.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbltenHang.setBounds(0, 139, 130, 17);
		panel_3_1.add(lbltenHang);

		txttenHang = new JTextField();
		txttenHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txttenHang.setColumns(10);
		txttenHang.setBounds(153, 137, 268, 27);
		panel_3_1.add(txttenHang);

		JPanel pnChucNangHang = new JPanel();
		TitledBorder t3= new TitledBorder(null, "Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null);
		t3.setTitleFont(new Font("Tahoma", Font.PLAIN, 13));
		pnChucNangHang.setBorder(t3);
		pnChucNangHang.setLayout(null);
		pnChucNangHang.setBackground(SystemColor.control);
		pnChucNangHang.setBounds(443, 97, 548, 104);
		panel_3_1.add(pnChucNangHang);
		txtmaHang.setText(xeFacade.getHangXeTail());
		JButton btnthemHang = new JButton("Thêm");
		btnthemHang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnthemHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (validData() == true && xetTenHang(txttenHang.getText()) == false) {
					try {
						String maHang = txtmaHang.getText();
						String tenHang = txttenHang.getText();
						String quocGia = txtquocGia.getText();
						HangSanXuat hsx = new HangSanXuat(maHang, tenHang, quocGia);
						hangSanXuatFacade.themHSX(hsx);
						JFrame f = new JFrame();
						loadHSX();
						JOptionPane.showMessageDialog(f, "Thêm hãng sản xuất thành công");
						ResetHang();
					} catch (SQLException e1) {
						e1.getMessage();
						JOptionPane.showConfirmDialog(null, "Thêm không thành công");
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					JOptionPane.showMessageDialog(null, "Hãng này đã tồn tại");
				}
			}
		});
		btnthemHang.setIcon(new ImageIcon("img1\\add.png"));
		btnthemHang.setToolTipText("");
		btnthemHang.setBackground(Color.GREEN);
		btnthemHang.setBounds(10, 29, 125, 52);
		pnChucNangHang.add(btnthemHang);

		JButton btnxoaHang = new JButton("Xóa");
		btnxoaHang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnxoaHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table_hang.getSelectedRow();
				try {
					if (row != -1) {
						JFrame f = new JFrame();
						int hoi = JOptionPane.showConfirmDialog(f, "Hãng sãn xuất này sẽ bị xóa", "Chú ý",
								JOptionPane.YES_NO_OPTION);
						if (hoi == JOptionPane.YES_OPTION) {
							xoaHangSX();
							ResetHang();
						}
					} else
						JOptionPane.showMessageDialog(null, "Vui lòng chọn hãng sản xuất để xóa");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Hãng sản xuất này không thể xóa");
				}
			}
		});
		btnxoaHang.setIcon(new ImageIcon("img1\\Close-2-icon.png"));
		btnxoaHang.setBackground(Color.RED);
		btnxoaHang.setBounds(145, 29, 125, 52);
		pnChucNangHang.add(btnxoaHang);

		JButton btncapNhatHang = new JButton("Cập nhật");
		btncapNhatHang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btncapNhatHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (validData()) {
					int row = table_hang.getSelectedRow();
					try {
						if (row != -1) {
							if (validData()) {
								JFrame f = new JFrame();
								int hoi = JOptionPane.showConfirmDialog(f,
										"Hãng Sản Xuất '" + txttenHang.getText() + "' sẽ được cập nhật !!!", "Chú ý ",
										JOptionPane.YES_NO_OPTION);
								if (hoi == JOptionPane.YES_OPTION) {
									String maHang = txtmaHang.getText();
									String tenHang = txttenHang.getText();
									String quocGia = txtquocGia.getText();
									HangSanXuat hsx = new HangSanXuat(maHang, tenHang, quocGia);
									hangSanXuatFacade.update(hsx);
									loadHSX();
									JOptionPane.showMessageDialog(null, "Thay đổi thông tin thành công !!!");
									ResetHang();
									try {
										loadHSX();
									} catch (Exception e2) {
										e2.printStackTrace();
									}
								}
							}
						} else
							JOptionPane.showMessageDialog(null, "Vui lòng chọn hãng sản xuất cần cập nhật");
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}

			}
		});
		btncapNhatHang.setIcon(new ImageIcon("img1\\update.png"));
		btncapNhatHang.setBackground(new Color(0, 153, 51));
		btncapNhatHang.setBounds(280, 29, 125, 52);
		pnChucNangHang.add(btncapNhatHang);

		JButton btnlamMoiHang = new JButton("Làm mới ");
		btnlamMoiHang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnlamMoiHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ResetHang();
			}
		});
		btnlamMoiHang.setIcon(new ImageIcon("img1\\refresh.png"));
		btnlamMoiHang.setBackground(new Color(0, 0, 255));
		btnlamMoiHang.setBounds(415, 29, 125, 52);
		pnChucNangHang.add(btnlamMoiHang);

		JPanel pnTimKiemHang = new JPanel();
		TitledBorder t5=new TitledBorder(null, "Nh\u1EADp th\u00F4ng tin c\u1EA7n t\u00ECm", TitledBorder.LEADING, TitledBorder.TOP, null, null);
		t5.setTitleFont(new Font("Tahoma", Font.PLAIN, 13));
		pnTimKiemHang.setBorder(t5);
		pnTimKiemHang.setLayout(null);
		pnTimKiemHang.setBackground(SystemColor.control);
		pnTimKiemHang.setBounds(1001, 97, 472, 104);
		panel_3_1.add(pnTimKiemHang);

		txttimHang = new JTextField();
		txttimHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txttimHang.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				if (txttimHang.getText().length() == 0) {
					try {
						loadHSX();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (txttimHang.getText().length() > 0) {
					try {
						timHangSanXuat();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		txttimHang.setColumns(10);
		txttimHang.setBounds(10, 38, 317, 32);
		pnTimKiemHang.add(txttimHang);

		JButton btnTimHang = new JButton("Tìm ");
		btnTimHang.setFont(new Font("Tahoma", Font.PLAIN, 15));

		btnTimHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (txttimHang.getText().length() > 0) {
					try {
						timHangSanXuat();
						// timKhachHang();
					} catch (SQLException e1) {
						e1.printStackTrace();

					}
				} else {
					try {
						loadHSX();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnTimHang.setIcon(new ImageIcon("img1\\search2.png"));
		btnTimHang.setBackground(new Color(255, 190, 87));
		btnTimHang.setBounds(337, 28, 125, 51);
		pnTimKiemHang.add(btnTimHang);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(1, 237, 1472, 366);
		panel_3_1.add(scrollPane_2);
		String[] header_1 = { "Mã Hãng Sản Xuất", "Tên Hãng Sản Xuất", "Quốc Gia" };
		tableModelHang = new DefaultTableModel(header_1, 0);

		table_hang = new JTable(tableModelHang);
		table_hang.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 14));
		table_hang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table_hang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table_hang.getSelectedRow();
				txtmaHang.setText(table_hang.getValueAt(i, 0).toString());
				txttenHang.setText(table_hang.getValueAt(i, 1).toString());
				txtquocGia.setText(table_hang.getValueAt(i, 2).toString());
			}
		});

		scrollPane_2.setViewportView(table_hang);

		try {
			loadHSX();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		JLabel label = new JLabel("New label");
		panel_5.add(label, "name_10324158553300");
		JLabel lblquocGia = new JLabel("Quốc Gia");
		lblquocGia.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblquocGia.setBounds(0, 176, 130, 14);
		panel_3_1.add(lblquocGia);

		txtquocGia = new JTextField();
		txtquocGia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtquocGia.setColumns(10);
		txtquocGia.setBounds(153, 174, 268, 27);
		panel_3_1.add(txtquocGia);
		txtMaLoai.setText(loaiXeFacade.getLoaiXeTail());
		panel_5.add(panelHang, "name_24132267128600");
		panel_5.add(panelLoai, "name_24132287226400");
		getContentPane.add(panel_5);

		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1532, 78);
		getContentPane.add(panel);
		panel.setLayout(null);

		JButton btnLoai = new JButton("");
		btnLoai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLoai.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnLoai.setBackground(Color.white);
				panelLoai.setVisible(true);
				panelHang.setVisible(false);
				panelXe.setVisible(false);
			}
		});
		btnLoai.setBackground(Color.WHITE);
		btnLoai.setFocusable(false);
		btnLoai.setIcon(new ImageIcon("img1\\motorbikes-icon.png"));
		btnLoai.setBounds(133, 10, 93, 43);
		btnLoai.setBorderPainted(false);
		panel.add(btnLoai);

		JButton btnHang = new JButton("");
		btnHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnHang.setBackground(Color.white);
				panelHang.setVisible(true);
				panelLoai.setVisible(false);
				panelXe.setVisible(false);
			}
		});
		btnHang.setBackground(Color.WHITE);
		btnHang.setFocusable(false);
		btnHang.setIcon(new ImageIcon("img1\\company-building-icon.png"));
		btnHang.setBounds(268, 10, 93, 43);
		btnHang.setBorderPainted(false);
		panel.add(btnHang);

		JButton btnXe = new JButton("");
		btnXe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnHang.setBackground(Color.white);
				panelXe.setVisible(true);
				panelHang.setVisible(false);
				panelLoai.setVisible(false);
				ArrayList<HangSanXuat> listHang;
				try {
					listHang = xeFacade.getAllHangSX();
					cbHangSx.removeAllItems();
					for (HangSanXuat hangSanXuat : listHang) {
						cbHangSx.addItem(hangSanXuat.getTenHangSX());
					}
				} catch (RemoteException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				ArrayList<LoaiXe> listLoai;
				try {
					listLoai = xeFacade.getAllLoaiXe();
					cbLoaiXe.removeAllItems();
					for (LoaiXe lx : listLoai) {
						cbLoaiXe.addItem(lx.getTenLoaiXe());
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnXe.setBackground(Color.WHITE);
		btnXe.setBorderPainted(false);
		btnXe.setFocusable(false);
		btnXe.setIcon(new ImageIcon("img1\\moto1.png"));
		btnXe.setBounds(10, 10, 93, 43);
		panel.add(btnXe);

		JLabel lbXe = new JLabel("Xe");
		lbXe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbXe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelXe.setVisible(true);
				panelHang.setVisible(false);
				panelLoai.setVisible(false);
			}
		});
		lbXe.setHorizontalAlignment(SwingConstants.CENTER);
		lbXe.setBounds(10, 55, 93, 23);
		panel.add(lbXe);

		JLabel lblLoiXe = new JLabel("Loại Xe");
		lblLoiXe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLoiXe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelLoai.setVisible(true);
				panelHang.setVisible(false);
				panelXe.setVisible(false);
			}
		});
		lblLoiXe.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoiXe.setBounds(133, 55, 93, 23);
		panel.add(lblLoiXe);

		JLabel lblHngSnXut = new JLabel("Hãng Sản Xuất");
		lblHngSnXut.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHngSnXut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnHang.setBackground(Color.white);
				panelHang.setVisible(true);
				panelLoai.setVisible(false);
				panelXe.setVisible(false);
			}
		});
		lblHngSnXut.setHorizontalAlignment(SwingConstants.CENTER);
		lblHngSnXut.setBounds(255, 55, 127, 23);
		panel.add(lblHngSnXut);
		table.setRowHeight(20);
		
		JLabel lblNewLabel_1 = new JLabel("Sắp xếp");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(16, 389, 72, 29);
		panelXe.add(lblNewLabel_1);
		
		JPanel pnSapXep = new JPanel();
		pnSapXep.setBounds(322, 387, 202, 31);
		panelXe.add(pnSapXep);
		pnSapXep.setLayout(new GridLayout(0, 2, 0, 0));
		
		JRadioButton rdTang = new JRadioButton("Tăng dần ");
		JRadioButton rdGiam = new JRadioButton("Giảm dần");
		rdTang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rdGiam.setSelected(false);
			}
		});
		rdTang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnSapXep.add(rdTang);
		
		
		rdGiam.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rdTang.setSelected(false);
			}
		});
		rdGiam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnSapXep.add(rdGiam);
		JComboBox<String> cbSapXep = new JComboBox<String>();
		cbSapXep.setModel(new DefaultComboBoxModel(new String[] {"Tên Xe", "Giá Nhập"}));
		cbSapXep.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbSapXep.setBackground(Color.WHITE);
		cbSapXep.setBounds(90, 388, 206, 29);
		JButton btnSapXep = new JButton("Sắp xếp");
		btnSapXep.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(rdGiam.isSelected()==false &&rdTang.isSelected()==false) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn kiểu sắp xêp");
				}
				else {
					try {
						if(rdGiam.isSelected()) {
							if(cbSapXep.getSelectedItem().toString().equalsIgnoreCase("Tên xe")) {
								tableModel = xeFacade.SapXepGiamDanTen();
								table.setModel(xeFacade.SapXepGiamDanTen());
							}
							if(cbSapXep.getSelectedItem().toString().equalsIgnoreCase("Giá nhập")) {
								tableModel=xeFacade.SapXepGiamDanGia();
								table.setModel(xeFacade.SapXepGiamDanGia());
							}
						}
						if(rdTang.isSelected()) {
							if(cbSapXep.getSelectedItem().toString().equalsIgnoreCase("Tên xe")) {
								tableModel=xeFacade.SapXepTangDanTen();
								table.setModel(xeFacade.SapXepTangDanTen());
							}
							if(cbSapXep.getSelectedItem().toString().equalsIgnoreCase("Giá nhập")) {
								tableModel=xeFacade.SapXepTangDanGia();
								table.setModel(xeFacade.SapXepTangDanGia());
							}
						}
					} catch (Exception e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}
				}
			}
		});
		btnSapXep.setIcon(new ImageIcon("img1\\filter.png"));
		btnSapXep.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSapXep.setBounds(564, 384, 132, 35);
		panelXe.add(btnSapXep);
		
		JLabel lbQuanLyXe = new JLabel("QUẢN LÝ XE");
		lbQuanLyXe.setForeground(new Color(184, 134, 11));
		lbQuanLyXe.setFont(new Font("Tahoma", Font.BOLD, 25));
		lbQuanLyXe.setBounds(0, -4, 475, 35);
		panelXe.add(lbQuanLyXe);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) SystemColor.controlShadow));
		panel_1.setBounds(711, 377, 788, 55);
		panelXe.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Tổng số xe còn lại trong kho :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(25, 11, 207, 30);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Tổng số xe đã bán :");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(419, 11, 157, 30);
		panel_1.add(lblNewLabel_2_1);
		
		lbXeConLai = new JLabel("1000");
		lbXeConLai.setForeground(new Color(204, 0, 0));
		lbXeConLai.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbXeConLai.setBounds(242, 11, 157, 30);
		lbXeConLai.setText(xeFacade.XeConLai()+" xe");
		panel_1.add(lbXeConLai);
		
		lbXeDaBan = new JLabel("1000");
		lbXeDaBan.setForeground(new Color(0, 102, 0));
		lbXeDaBan.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbXeDaBan.setBounds(603, 11, 175, 30);
		lbXeDaBan.setText(xeFacade.XeDaBan()+" xe");
		panel_1.add(lbXeDaBan);
		
		
		panelXe.add(cbSapXep);
		table_hang.setRowHeight(20);
		tableLoai.setRowHeight(20);
		table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 13));
	}

//Hàm load database
	private void loadXe() throws SQLException {
		//Dao_QuanLyXe dao_xe = new Dao_QuanLyXe();
		try {
			tableModel = xeFacade.getAllXe();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table.setModel(tableModel);
	}
	private void loadLoai() throws SQLException {
		//Dao_LoaiXe dao_lx = new Dao_LoaiXe();
		try {
			tableModelLoai = loaiXeFacade.getAllLX();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tableLoai.setModel(tableModelLoai);
	}

//Xóa xe
	private boolean xoaXe() throws SQLException {
		//Dao_QuanLyXe dao_qlXe = new Dao_QuanLyXe();
		try {
			if (xeFacade.xoaXe(txtMa.getText())) {
				// loadXe();
				return true;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	private void xoaLoaiXe() throws SQLException {
		//Dao_LoaiXe dao_loai = new Dao_LoaiXe();
		try {
			loaiXeFacade.xoaLoaiXe(txtMaLoai.getText());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loadLoai();
	}

	public boolean KiemTraMa() {
		ArrayList<Xe> dsxe;
		try {
			dsxe = xeFacade.getSoKhung();
			for (Xe xe : dsxe) {
				if (xe.getMaXe().equalsIgnoreCase(txtMa.getText())) {
					return false;
				}
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public boolean KiemTraSoKhung() {
		ArrayList<Xe> dsxe;
		try {
			dsxe = xeFacade.getSoKhung();
			for (Xe xe : dsxe) {
				if (xe.getSoKhung().equalsIgnoreCase(txtSoKhung.getText())) {
					return false;
				}
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}

	public boolean KiemTraSoMay() {
		ArrayList<Xe> dsxe;
		try {
			dsxe = xeFacade.getSoKhung();
			for (Xe xe : dsxe) {
				if (xe.getSoMay().equalsIgnoreCase(txtSoMay.getText())) {
					return false;
				}
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}

//Validate dataXe
	private boolean validDataUpdateXe() {
		if (!(txtTen.getText().length() > 0)) {
			JOptionPane.showMessageDialog(null, "Tên xe không được để trống ");
			return false;
		}
		if (!(txtTen.getText().matches("^[a-zA-Z0-9 ]+$"))) {
			JOptionPane.showMessageDialog(null, "Tên xe không chứa kí tự đặc biệt");
			return false;
		}
		if (txtSoKhung.getText().length() != 18) {
			JOptionPane.showMessageDialog(null, "Số khung gồm 18 kí tự");
			return false;
		}
		if (!(txtSoKhung.getText().matches("^[a-zA-Z0-9 ]+$"))) {
			JOptionPane.showMessageDialog(null, "Số khung không chứa kí tự đặc biệt");
			return false;
		}
		if (txtSoMay.getText().length() != 7) {
			JOptionPane.showMessageDialog(null, "Số máy gồm 7 kí tự");
			return false;
		}
		if (!(txtSoMay.getText().matches("^[a-zA-Z0-9 ]+$"))) {
			JOptionPane.showMessageDialog(null, "Số máy không chứa kí tự đặc biệt");
			return false;
		}
		NumberFormat num = NumberFormat.getNumberInstance();
		if (!(isNumeric(txtGiaNhap.getText().substring(txtGiaNhap.getText().length() - 1)) == true)) {
			JOptionPane.showMessageDialog(null, "Giá nhập là số không phải kí tự");
			return false;
		}
		double giaNhap1;
		try {
			giaNhap1 = num.parse(txtGiaNhap.getText()).doubleValue();
			if (giaNhap1 < 1000000) {
				JOptionPane.showMessageDialog(null, "Giá nhập không chính xác");
				return false;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (!(txtPhanKhoi.getText().length() > 0)) {
			JOptionPane.showMessageDialog(null, "Phân khối không được để rỗng ");
			return false;
		}
		if (!(txtPhanKhoi.getText().matches("\\d+"))) {
			JOptionPane.showMessageDialog(null, "Phân khối là số không phải kí tự");
			return false;
		}
		int phanKhoi = Integer.parseInt(txtPhanKhoi.getText());
		if (phanKhoi < 50 || phanKhoi > 180) {
			JOptionPane.showMessageDialog(null, "Phân khối không được nhỏ hơn 50cc hoặc lớn hơn 180cc ");
			return false;
		}
		if (!(txtPhienBan.getText().length() > 0)) {
			JOptionPane.showMessageDialog(null, "Phiên bản không được để rỗng ");
			return false;
		}
		if (!(txtPhienBan.getText()
				.matches("^[a-zA-Z0-9_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ\" +\r\n"
						+ "            \"ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ\" +\r\n"
						+ "            \"ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\\\s]+$"))) {
			JOptionPane.showMessageDialog(null, "Phiên bản không chứa kí tự đặc biệt");
			return false;
		}
		String date = ((JTextField) dtNgayNhap.getDateEditor().getUiComponent()).getText();
		Date ngay = Date.valueOf(LocalDate.parse(date));
		if (ngay.after(Date.valueOf(LocalDate.now()))) {

			JOptionPane.showMessageDialog(null, "Ngày nhập phải trước ngày hôm nay");
			return false;
		}

		return true;
	}

	private boolean validDataXe() throws ParseException {
		if (KiemTraMa() == false) {
			JOptionPane.showMessageDialog(null, "Mã xe này đã tồn tại");
			return false;
		}
		if (!(txtTen.getText().length() > 0)) {
			JOptionPane.showMessageDialog(null, "Tên xe không được để trống ");
			return false;
		}
		if (!(txtTen.getText().matches("^[a-zA-Z0-9 ]+$"))) {
			JOptionPane.showMessageDialog(null, "Tên xe không chứa kí tự đặc biệt");
			return false;
		}
		if (!(txtMau.getText().length() > 0)) {
			JOptionPane.showMessageDialog(null, "Màu không được để trống ");
			return false;
		}
		if (txtSoKhung.getText().length() != 18) {
			JOptionPane.showMessageDialog(null, "Số khung gồm 18 kí tự");
			return false;
		}
		if (!(txtSoKhung.getText().matches("^[a-zA-Z0-9 ]+$"))) {
			JOptionPane.showMessageDialog(null, "Số khung không chứa kí tự đặc biệt");
			return false;
		}
		if (KiemTraSoKhung() == false) {
			JOptionPane.showMessageDialog(null, "Số khung này đã tồn tại");
			return false;
		}
		if (txtSoMay.getText().length() != 7) {
			JOptionPane.showMessageDialog(null, "Số máy gồm 7 kí tự");
			return false;
		}
		if (!(txtSoMay.getText().matches("^[a-zA-Z0-9 ]+$"))) {
			JOptionPane.showMessageDialog(null, "Tên xe không chứa kí tự đặc biệt");
			return false;
		}
		if (KiemTraSoMay() == false) {
			JOptionPane.showMessageDialog(null, "Số máy này đã tồn tại");
			return false;
		}
		if (!(txtGiaNhap.getText().length() > 0)) {
			JOptionPane.showMessageDialog(null, "Giá nhập không được để rỗng ");
			return false;
		}
		NumberFormat num = NumberFormat.getNumberInstance();
		if (!(isNumeric(txtGiaNhap.getText().substring(txtGiaNhap.getText().length() - 1)) == true)) {
			JOptionPane.showMessageDialog(null, "Giá nhập là số không phải kí tự");
			return false;
		}
		double giaNhap1 = num.parse(txtGiaNhap.getText()).doubleValue();
		if (giaNhap1 < 1000000) {
			JOptionPane.showMessageDialog(null, "Giá nhập không chính xác");
			return false;
		}
		if (!(txtPhanKhoi.getText().length() > 0)) {
			JOptionPane.showMessageDialog(null, "Phân khối không được để rỗng ");
			return false;
		}
		if (!(txtPhanKhoi.getText().matches("\\d+"))) {
			JOptionPane.showMessageDialog(null, "Phân khối là số không phải kí tự");
			return false;
		}
		int phanKhoi = Integer.parseInt(txtPhanKhoi.getText());
		if (phanKhoi < 50 || phanKhoi > 180) {
			JOptionPane.showMessageDialog(null, "Phân khối không được nhỏ hơn 50cc hoặc lớn hơn 180cc ");
			return false;
		}
		if (!(txtPhienBan.getText().length() > 0)) {
			JOptionPane.showMessageDialog(null, "Phiên bản không được để rỗng ");
			return false;
		}
		if (!(txtPhienBan.getText()
				.matches("^[a-zA-Z0-9_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ\" +\r\n"
						+ "            \"ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ\" +\r\n"
						+ "            \"ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\\\s]+$"))) {
			JOptionPane.showMessageDialog(null, "Phiên bản không chứa kí tự đặc biệt");
			return false;
		}
		String date = ((JTextField) dtNgayNhap.getDateEditor().getUiComponent()).getText();
		Date ngay = Date.valueOf(LocalDate.parse(date));
		if (ngay.after(Date.valueOf(LocalDate.now()))) {

			JOptionPane.showMessageDialog(null, "Ngày nhập phải trước ngày hôm nay");
			return false;
		}

		return true;
	}

//Tìm xe theo tên và mã 
	private void timXe() throws SQLException {
		//Dao_QuanLyXe dao_qlXe = new Dao_QuanLyXe();
		try {
			tableModel = xeFacade.timKiem("%" + txtTim.getText() + "%");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table.setModel(tableModel);
	}

	private void timLoai() throws SQLException {
		//Dao_LoaiXe dao_loai = new Dao_LoaiXe();
		try {
			tableModelLoai = loaiXeFacade.timKiem("%" + txtTim_1.getText() + "%");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tableLoai.setModel(tableModelLoai);
	}

	private void loadHSX() throws SQLException {
		//dao_hsx = new Dao_HangSanXuat();
		try {
			tableModelHang = hangSanXuatFacade.getAllHSX();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table_hang.setModel(tableModelHang);
	}

	private void xoaHangSX() throws SQLException {
		//dao_hsx = new Dao_HangSanXuat();
		try {
			hangSanXuatFacade.xoaHSX(txtmaHang.getText());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loadHSX();
	}

	private void timHangSanXuat() throws SQLException {
		//dao_hsx = new Dao_HangSanXuat();
		try {
			tableModelHang = hangSanXuatFacade.timKiem("%" + txttimHang.getText() + "%");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table_hang.setModel(tableModelHang);
	}

	private boolean validData() {
		// String maHang = txtmaHang.getText();
		String tenHang = txttenHang.getText();
		String quocGia = txtquocGia.getText();
		if (!(tenHang.length() > 0)) {
			JOptionPane.showMessageDialog(null, "Tên hãng không được để trống");
			return false;
		}
		if (!(tenHang.matches("^[a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ\" +\r\n"
				+ "            \"ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ\" +\r\n"
				+ "            \"ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\\\s]+$"))) {
			JOptionPane.showMessageDialog(null, "Tên hãng không chứa kí tự đặc biệt ");
			return false;
		}
		if (!(quocGia.length() > 0)) {
			JOptionPane.showMessageDialog(null, "Quốc gia không được để trống");
			return false;
		}
		if (!(quocGia.matches("^[a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ\" +\r\n"
				+ "            \"ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ\" +\r\n"
				+ "            \"ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\\\s]+$"))) {
			JOptionPane.showMessageDialog(null, "Quốc gia không chứa kí tự đặc biệt ");
			return false;
		}
		return true;
	}

	private boolean validDataLoai() {
		if (!(txtTenLoai.getText()
				.matches("^[a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ\" +\r\n"
						+ "            \"ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ\" +\r\n"
						+ "            \"ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\\\s]+$"))) {
			JOptionPane.showMessageDialog(null,
					"Tên loại xe không trống và không chứa kí tự đặc biệt không chứa kí tự số");
			return false;
		}
		if (!(txtTenLoai.getText().length() > 0)) {
			JOptionPane.showMessageDialog(null, "Tên loại xe không được trống");
			return false;
		}
		if (xetMaLoai(txtMaLoai.getText()) == true) {
			JOptionPane.showMessageDialog(null, "Mã loại xe này đã tồn tại");
			return false;
		}
		if (xetTenLoai(txtTenLoai.getText()) == true) {
			JOptionPane.showMessageDialog(null, "Tên loại xe này đã tồn tại");
			return false;
		}
		return true;
	}

	private boolean ValidateUpdateLoai() {
		if (!(txtTenLoai.getText().length() > 0)) {
			JOptionPane.showMessageDialog(null, "Tên loại xe không được trống");
			return false;
		}
		if (!(txtTenLoai.getText()
				.matches("^[a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ\" +\r\n"
						+ "            \"ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ\" +\r\n"
						+ "            \"ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\\\s]+$"))) {
			JOptionPane.showMessageDialog(null,
					"Tên loại xe không trống và không chứa kí tự đặc biệt không chứa kí tự số");
			return false;
		}
		return true;
	}

	public ArrayList<String> xettenHang() {
		tenHang = new ArrayList<String>();
		try {
			tenHang = hangSanXuatFacade.getListTenHangSX();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		try {
//			ConnectDB.getInstance();
//			Connection con = ConnectDB.getCon();
//			String sql = "Select tenHangSanXuat from HangSanXuat";
//			Statement statement = con.createStatement();
//			ResultSet rs = statement.executeQuery(sql);
//			while (rs.next()) {
//				String ten;
//				ten = rs.getString(1);
//				tenHang.add(ten);
//			}
//		} catch (SQLException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
		return tenHang;
	}

	public ArrayList<String> xetTenLoai() {
		ArrayList<String> tenLoai = new ArrayList<String>();
		try {
			tenLoai = loaiXeFacade.getListTenLoaiXe();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		try {
//			ConnectDB.getInstance();
//			Connection con = ConnectDB.getCon();
//			String sql = "Select tenLoaiXe from LoaiXe";
//			Statement statement = con.createStatement();
//			ResultSet rs = statement.executeQuery(sql);
//			while (rs.next()) {
//				String ten;
//				ten = rs.getString(1);
//				tenLoai.add(ten);
//			}
//		} catch (SQLException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
		return tenLoai;
	}

	public ArrayList<String> xetMaLoai() {
		ArrayList<String> ma = new ArrayList<String>();
		
		try {
			ma = loaiXeFacade.getListMaLoaiXe();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		try {
//			ConnectDB.getInstance();
//			Connection con = ConnectDB.getCon();
//			String sql = "Select maLoaiXe from LoaiXe";
//			Statement statement = con.createStatement();
//			ResultSet rs = statement.executeQuery(sql);
//			while (rs.next()) {
//				String ten;
//				ten = rs.getString(1);
//				ma.add(ten);
//			}
//		} catch (SQLException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
		return ma;
	}

	public boolean xetTenLoai(String ten) {
		List<String> list = xetTenLoai();
		for (String i : list) {
			if (i.equalsIgnoreCase(ten))
				return true;
		}
		return false;
	}

	public boolean xetMaLoai(String ten) {
		List<String> list = xetMaLoai();
		for (String i : list) {
			if (i.equalsIgnoreCase(ten))
				return true;
		}
		return false;
	}

	public boolean xetTenHang(String ten) {
		List<String> list = xettenHang();
		for (String i : list) {
			if (i.equalsIgnoreCase(ten))
				return true;
		}
		return false;
	}

	public void Reset() {
		String s;
		try {
			s = xeFacade.getMaXeTail();
			txtMa.setText(s);
			txtTen.setText("");
			txtMau.setText("");
			cbLoaiXe.setSelectedIndex(0);
			cbHangSx.setSelectedIndex(0);
			cbNhaCC.setSelectedIndex(0);
			txtPhanKhoi.setText("");
			txtSoKhung.setText("");
			txtGiaNhap.setText("");
			dtNgayNhap.setDate(Date.valueOf(LocalDate.now()));
			txtTrangThai.setText("Còn hàng");
			txtCt.setText("");
			txtPhienBan.setText("");
			txtImg1.setText("");
			txtSoMay.setText("");
			lblAnh.setIcon(null);
			lblAnh.setText("Chưa có hình ảnh");
			txtTen.requestFocus();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void ResetHang() {
		try {
			txtmaHang.setText(xeFacade.getHangXeTail());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		txttenHang.setText("");
		txtquocGia.setText("");
	}

	public void ResetLoai() {
		try {
			txtMaLoai.setText(loaiXeFacade.getLoaiXeTail());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		txtTenLoai.setText("");
	}

	public boolean isNumeric(String str) {
		return str.matches("\\d"); // match a number with optional '-' and decimal. "-?\\d+(\\.\\d+)?"
	}
}
