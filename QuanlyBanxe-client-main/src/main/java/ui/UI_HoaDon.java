package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import businesslogic.facade.HangSanXuatFacade;
import businesslogic.facade.HoaDonFacade;
import businesslogic.facade.HopDongFacade;
import businesslogic.facade.KhachHangFacade;
import businesslogic.facade.LoaiXeFacade;
import businesslogic.facade.NhaCungCapFacade;
import businesslogic.facade.NhanVienFacade;
import businesslogic.facade.ThongkeFacade;
import businesslogic.facade.XeFacade;
import entity.HangSanXuat;
import entity.KhachHang;
import entity.LoaiXe;
import entity.NhaCungCap;
import entity.Xe;
import others.Bill;
import others.PrintSupport;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JComboBox;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class UI_HoaDon extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTable table;
	public static JTextField txtTotal = new JTextField();
	public static JTextField txtTotalVAT = new JTextField();
	public static JTextField txtBillNum;
	public static JTextField txtEmployeeNum_Bill;
	public static JTextField txtDateBill;
	public static DefaultTableModel tableModel;
	public static JTextField txtCMND_Bill;
    public static JTextField txtNumPhone_Bill;
    public static JTextField txtCustomerName_Bill;
    public static JTextField txtNoteCustomer_Bill;
    @SuppressWarnings("rawtypes")
	public static JComboBox cbbVehicleName_Bill;
    @SuppressWarnings("rawtypes")
	private JComboBox  cbbVehicleColor_Bill, cbbVersion, cbbChasisNumber;
    private JTextField txtVehicleEngineNum;
    public static String maKhachHang;
	public static double thueVAT;
	private DefaultTableModel tableModel1, tableModel2;
	private JTextField txtMaHD, txtMaKH, txtTenKH;
	private JDateChooser dcNgayLHD;
	
    

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
					UI_HoaDon frame = new UI_HoaDon();
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
	public UI_HoaDon() throws RemoteException, MalformedURLException, NotBoundException {
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
//		try {
//			ConnectDB.getInstance().connect();
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		DecimalFormat df = new DecimalFormat("#,###,###,### VNĐ");
		HangSanXuatFacade hangSanXuatFacade = (HangSanXuatFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/hangSanXuatFacade");
		HoaDonFacade hoaDonFacade = (HoaDonFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/hoaDonFacade");
		KhachHangFacade khachHangFacade = (KhachHangFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/khachHangFacade");
		LoaiXeFacade loaiXeFacade = (LoaiXeFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/loaiXeFacade");
		NhaCungCapFacade nhaCungCapFacade = (NhaCungCapFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/nhaCungCapFacade");
		NhanVienFacade nhanVienFacade = (NhanVienFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/nhanVienFacade");
		XeFacade xeFacade = (XeFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/xeFacade");
//		Dao_KhachHang dao_kh = new Dao_KhachHang();
//		Dao_HangSanXuat dao_Hsx = new Dao_HangSanXuat();
//		Dao_QuanLyXe dao_Xe = new Dao_QuanLyXe();
//		Dao_NhaCungCap dao_ncc = new Dao_NhaCungCap();
//		Dao_HoaDon dao_hd = new Dao_HoaDon();
//		Dao_NhanVien dao_nv = new Dao_NhanVien();
//		Dao_LoaiXe dao_lx = new Dao_LoaiXe();
		
		List<String> list_CMND = khachHangFacade.getListCMND();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();
		//setBounds(0, 0, 1113, 614);
		setBounds(0, 0, width, height);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pTab1 = new JPanel();
		pTab1.setBounds(10, 101, 1513, 687);
		contentPane.add(pTab1);
		pTab1.setLayout(null);
		
		/*String a = "MHD0005";
		String[] parts = a.split("D");
		System.out.println(parts[1]);*/
		
		String maHD = hoaDonFacade.getMaHDTail("maHoaDon", "HoaDon");
		/*JLabel lblBillNum1 = new JLabel();
		lblBillNum1.setText(maHD);
		lblBillNum1.setBackground(Color.WHITE);
		lblBillNum1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBillNum1.setBounds(140, 43, 168, 23);
		pEmployeeInfo_Bill.add(lblBillNum1);*/
		
		/*JLabel lblDateBill1 = new JLabel();
		lblDateBill1.setBackground(Color.WHITE);
		lblDateBill1.setText(LocalDate.now().toString());
		lblDateBill1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDateBill1.setBounds(414, 43, 150, 22);
		pEmployeeInfo_Bill.add(lblDateBill1);*/
		
		//FillCombo combo = new FillCombo();
		String[] header = {"Mã Xe", "Tên Xe", "Loại Xe", "Phiên Bản", "Màu xe", "Phân Khối", "Hãng Sản Xuất", "Số Khung", "Số Máy", "Đơn Giá", "Thuế VAT", "Thành tiền"};
		tableModel = new DefaultTableModel(header, 0){
	       @Override
	       public boolean isCellEditable(int i, int i1) {
	           return false; //To change body of generated methods, choose Tools | Templates.
	       }
		};
		
		JPanel panelTab = new JPanel();
		panelTab.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panelTab.setBackground(Color.WHITE);
		panelTab.setBounds(0, 0, 1530, 78);
		contentPane.add(panelTab);
		panelTab.setLayout(null);
		
		JButton btn1 = new JButton("");
		btn1.setBackground(new Color(240, 230, 140));
		btn1.setFocusable(false);
		btn1.setIcon(new ImageIcon("img1\\Shopping-basket-add-icon.png"));
		btn1.setBorderPainted(false);
		btn1.setBounds(10, 10, 93, 43);
		panelTab.add(btn1);
		
		JLabel lbl1 = new JLabel("Hóa Đơn");
		lbl1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl1.setBounds(25, 55, 77, 23);
		panelTab.add(lbl1);
		
		JButton btn2 = new JButton("");
		btn2.setBounds(135, 10, 93, 43);
		btn2.setBackground(Color.WHITE);
		btn2.setFocusable(false);
		btn2.setIcon(new ImageIcon("img1\\Order-history-icon.png"));
		btn2.setBorderPainted(false);
		panelTab.add(btn2);
		
		JLabel lblNewLabel = new JLabel("Danh sách HD");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(133, 55, 115, 23);
		panelTab.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("QUẢN LÝ THÔNG TIN HÓA ĐƠN");
		lblNewLabel_1.setBounds(606, 0, 526, 72);
		panelTab.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(184, 134, 11));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JPanel pGenInfo_Bill = new JPanel();
		pGenInfo_Bill.setBounds(0, 5, 905, 141);
		pTab1.add(pGenInfo_Bill);
		TitledBorder t= new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Thông Tin Chung", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK);
		t.setTitleFont(new Font("Tahoma", Font.PLAIN, 13));
		pGenInfo_Bill.setBorder(t);
		pGenInfo_Bill.setBackground(SystemColor.control);
		pGenInfo_Bill.setLayout(null);
		
		JPanel pCustomerInfo_Bill = new JPanel();
		pCustomerInfo_Bill.setBounds(10, 22, 890, 104);
		pCustomerInfo_Bill.setBackground(SystemColor.control);
		pGenInfo_Bill.add(pCustomerInfo_Bill);
		pCustomerInfo_Bill.setLayout(null);
		
		JLabel lblCustomerNum_Bill = new JLabel("CMND");
		lblCustomerNum_Bill.setBounds(10, 12, 87, 28);
		lblCustomerNum_Bill.setFont(new Font("Tahoma", Font.BOLD, 13));
		pCustomerInfo_Bill.add(lblCustomerNum_Bill);
		
		txtCMND_Bill = new JTextField();
		txtCMND_Bill.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCMND_Bill.setBounds(100, 10, 250, 30);
		pCustomerInfo_Bill.add(txtCMND_Bill);
		
		JLabel lblNumPhone_Bill = new JLabel("SĐT");
		lblNumPhone_Bill.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNumPhone_Bill.setBounds(10, 52, 45, 25);
		pCustomerInfo_Bill.add(lblNumPhone_Bill);
		
		txtNumPhone_Bill = new JTextField();
		txtNumPhone_Bill.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNumPhone_Bill.setBounds(100, 50, 250, 27);
		txtNumPhone_Bill.setEditable(false);
		pCustomerInfo_Bill.add(txtNumPhone_Bill);
		
		JLabel lblCustomerName_Bill = new JLabel("Tên Khách Hàng");
		lblCustomerName_Bill.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCustomerName_Bill.setBounds(405, 12, 128, 28);
		pCustomerInfo_Bill.add(lblCustomerName_Bill);
		
		txtCustomerName_Bill = new JTextField();
		txtCustomerName_Bill.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCustomerName_Bill.setBounds(570, 10, 310, 30);
		txtCustomerName_Bill.setEditable(false);
		pCustomerInfo_Bill.add(txtCustomerName_Bill);
		
		JLabel lblNote_Bill = new JLabel("Chú Thích");
		lblNote_Bill.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNote_Bill.setBounds(405, 52, 87, 25);
		pCustomerInfo_Bill.add(lblNote_Bill);
		
		txtNoteCustomer_Bill = new JTextField();
		txtNoteCustomer_Bill.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNoteCustomer_Bill.setBounds(570, 50, 310, 27);
		txtNoteCustomer_Bill.setEditable(false);
		pCustomerInfo_Bill.add(txtNoteCustomer_Bill);
		
		JPanel pOtherInfo_Bill = new JPanel();
		pOtherInfo_Bill.setBounds(925, 5, 598, 141);
		pTab1.add(pOtherInfo_Bill);
		TitledBorder t2=new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Thông Tin Khác", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK);
		t2.setTitleFont(new Font("Tahoma", Font.PLAIN, 13));
		pOtherInfo_Bill.setBorder(t2);
		pOtherInfo_Bill.setBackground(SystemColor.control);
		pOtherInfo_Bill.setLayout(null);
		
		JPanel pEmployeeInfo_Bill = new JPanel();
		pEmployeeInfo_Bill.setBounds(10, 20, 574, 111);
		pOtherInfo_Bill.add(pEmployeeInfo_Bill);
		pEmployeeInfo_Bill.setLayout(null);
		
		JLabel lblEmployee_Bill = new JLabel("Nhân Viên");
		lblEmployee_Bill.setBackground(new Color(230, 230, 250));
		lblEmployee_Bill.setBounds(10, 12, 87, 26);
		lblEmployee_Bill.setFont(new Font("Tahoma", Font.BOLD, 13));
		pEmployeeInfo_Bill.add(lblEmployee_Bill);	
		
		txtEmployeeNum_Bill = new JTextField();
		txtEmployeeNum_Bill.setEditable(false);
		//txtEmployeeNum_Bill.setText(Login.txtuser.getText());
		txtEmployeeNum_Bill.setText("NV_0001");
		//txtEmployeeNum_Bill.setBackground(Color.WHITE);
		txtEmployeeNum_Bill.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmployeeNum_Bill.setBounds(140, 10, 168, 28);
		pEmployeeInfo_Bill.add(txtEmployeeNum_Bill);
		
		JTextField txtEmployeeName_Bill = new JTextField();
		txtEmployeeName_Bill.setEditable(false);
		txtEmployeeName_Bill.setText(nhanVienFacade.getTenNhanVienById(txtEmployeeNum_Bill.getText()));
		//txtEmployeeName_Bill.setBackground(Color.WHITE);
		txtEmployeeName_Bill.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmployeeName_Bill.setBounds(320, 10, 244, 28);
		pEmployeeInfo_Bill.add(txtEmployeeName_Bill);
		
		JLabel lblBillNum = new JLabel("Mã Hóa Đơn");
		lblBillNum.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBillNum.setBounds(10, 60, 92, 24);
		pEmployeeInfo_Bill.add(lblBillNum);
		
		txtBillNum = new JTextField();
		txtBillNum.setEditable(false);
		txtBillNum.setText(maHD);
		//txtBillNum.setBackground(Color.WHITE);
		txtBillNum.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtBillNum.setBounds(140, 58, 168, 26);
		pEmployeeInfo_Bill.add(txtBillNum);
		
		JLabel lblBillDate = new JLabel("Ngày LHD");
		lblBillDate.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBillDate.setBounds(320, 60, 86, 24);
		pEmployeeInfo_Bill.add(lblBillDate);
		
		txtDateBill = new JTextField();
		txtDateBill.setEditable(false);
		//txtDateBill.setBackground(Color.WHITE);
		txtDateBill.setText(LocalDate.now().toString());
		txtDateBill.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDateBill.setBounds(414, 58, 150, 26);
		pEmployeeInfo_Bill.add(txtDateBill);
		
		JPanel pProduct_Bill = new JPanel();
		pProduct_Bill.setBounds(0, 156, 905, 169);
		pTab1.add(pProduct_Bill);
		TitledBorder t3=new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Thông Tin Xe", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK);
		t3.setTitleFont(new Font("Tahoma", Font.PLAIN, 13));
		pProduct_Bill.setBorder(t3);
		pProduct_Bill.setBackground(SystemColor.control);
		pProduct_Bill.setLayout(null);
		
		JPanel pAddVehicle_Bill = new JPanel();
		pAddVehicle_Bill.setToolTipText("");
		pAddVehicle_Bill.setBounds(10, 21, 890, 142);
		pProduct_Bill.add(pAddVehicle_Bill);
		pAddVehicle_Bill.setLayout(null);
		
		JLabel lblVehicleNum_Bill = new JLabel("Mã Xe");
		lblVehicleNum_Bill.setBounds(10, 12, 44, 25);
		lblVehicleNum_Bill.setFont(new Font("Tahoma", Font.BOLD, 13));
		pAddVehicle_Bill.add(lblVehicleNum_Bill);
		
		JLabel lblVehicleName_Bill = new JLabel("Tên Xe");
		lblVehicleName_Bill.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblVehicleName_Bill.setBounds(405, 12, 60, 25);
		pAddVehicle_Bill.add(lblVehicleName_Bill);
		
		
		cbbVehicleName_Bill = new JComboBox<String>();
		cbbVehicleName_Bill.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbbVehicleName_Bill.setBackground(Color.WHITE);
		cbbVehicleName_Bill.setBounds(570, 10, 290, 27);
		cbbVehicleName_Bill.setSelectedIndex(-1);
		pAddVehicle_Bill.add(cbbVehicleName_Bill);

		ArrayList<String> listname =xeFacade.getXeByTrangThai("select DISTINCT tenXe from Xe where trangThai = N'Còn hàng' order by tenXe", "tenXe");
		for (String string : listname) {
			cbbVehicleName_Bill.addItem(string);
		}
		cbbVehicleColor_Bill = new JComboBox();
		cbbVehicleColor_Bill.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbbVehicleColor_Bill.setBackground(Color.WHITE);
		cbbVehicleColor_Bill.setBounds(570, 47, 145, 27);
		cbbVehicleColor_Bill.setSelectedIndex(-1);
		pAddVehicle_Bill.add(cbbVehicleColor_Bill);
		
		JLabel lblVehicleColor_Bill = new JLabel("Màu Xe");
		lblVehicleColor_Bill.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblVehicleColor_Bill.setBounds(405, 47, 68, 25);
		pAddVehicle_Bill.add(lblVehicleColor_Bill);
		
		JTextField txtVehicleNum_Bill = new JTextField();
		txtVehicleNum_Bill.setBackground(Color.white);
		txtVehicleNum_Bill.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtVehicleNum_Bill.setBounds(115, 10, 203, 27);
		pAddVehicle_Bill.add(txtVehicleNum_Bill);
		
		JLabel lblManufacturerName_Bill = new JLabel("Phiên bản");
		lblManufacturerName_Bill.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblManufacturerName_Bill.setBounds(10, 49, 68, 25);
		pAddVehicle_Bill.add(lblManufacturerName_Bill);
		
		cbbVersion = new JComboBox();
		cbbVersion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbbVersion.setBackground(Color.WHITE);
		cbbVersion.setBounds(115, 47, 203, 27);
		cbbVersion.setSelectedIndex(-1);
		pAddVehicle_Bill.add(cbbVersion);
		
		JLabel lblChasisNumber_Bill = new JLabel("Số Khung");
		lblChasisNumber_Bill.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblChasisNumber_Bill.setBounds(10, 84, 95, 25);
		pAddVehicle_Bill.add(lblChasisNumber_Bill);
		
		cbbChasisNumber = new JComboBox();
		cbbChasisNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbbChasisNumber.setBounds(115, 84, 203, 25);
		cbbChasisNumber.setSelectedIndex(-1);
		pAddVehicle_Bill.add(cbbChasisNumber);
		
//		ArrayList<String> listNumber =xeFacade.getXeByTrangThai("select soKhung from Xe where trangThai = N'Còn hàng'","soKhung");
//		for (String string : listNumber) {
//			cbbChasisNumber.addItem(string);
//		}
		JLabel lblVehicleEngineNumber = new JLabel("Số Máy");
		lblVehicleEngineNumber.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblVehicleEngineNumber.setBounds(405, 82, 70, 23);
		pAddVehicle_Bill.add(lblVehicleEngineNumber);
		
		txtVehicleEngineNum = new JTextField();
		txtVehicleEngineNum.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtVehicleEngineNum.setBounds(570, 84, 145, 25);
		txtVehicleEngineNum.setEditable(false);
		pAddVehicle_Bill.add(txtVehicleEngineNum);
		txtVehicleEngineNum.setColumns(10);
		
		JPanel pImageVehicle_Bill = new JPanel();
		pImageVehicle_Bill.setBounds(925, 162, 352, 159);
		pTab1.add(pImageVehicle_Bill);
		pImageVehicle_Bill.setBorder(new LineBorder(SystemColor.controlShadow));
		pImageVehicle_Bill.setLayout(null);
		
		JLabel lblImage = new JLabel("                          Chưa có hình ảnh");
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblImage.setForeground(Color.red);
		lblImage.setBounds(0, 0, 350, 159);
		pImageVehicle_Bill.add(lblImage);
		
		JPanel panelFunction1 = new JPanel();
		panelFunction1.setBorder(new LineBorder(SystemColor.controlShadow));
		panelFunction1.setBounds(1287, 162, 215, 159);
		pTab1.add(panelFunction1);
		panelFunction1.setBackground(SystemColor.controlHighlight);
		panelFunction1.setLayout(null);
		
		JButton btnEmptyDelete_Bill = new JButton("Xóa Trống");
		btnEmptyDelete_Bill.setBackground(Color.RED);
		btnEmptyDelete_Bill.setIcon(new ImageIcon(UI_HoaDon.class.getResource("/image/Recycle-Bin-Full-icon.png")));
		btnEmptyDelete_Bill.setBounds(27, 24, 160, 51);
		btnEmptyDelete_Bill.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelFunction1.add(btnEmptyDelete_Bill);
		
		JButton btnAddVehicle_Bill = new JButton("Th\u00EAm Xe");
		btnAddVehicle_Bill.setIcon(new ImageIcon(UI_HoaDon.class.getResource("/image/sign-add-icon.png")));
		btnAddVehicle_Bill.setBackground(new Color(0, 153, 0));
		btnAddVehicle_Bill.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAddVehicle_Bill.setBounds(27, 90, 160, 51);
		panelFunction1.add(btnAddVehicle_Bill);
		
		JPanel pBillDetailsList = new JPanel();
		pBillDetailsList.setBounds(-1, 331, 1513, 245);
		pTab1.add(pBillDetailsList);
		TitledBorder t4=new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh Sách Xe Bán", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK);
		t4.setTitleFont(new Font("Tahoma", Font.PLAIN, 13));
		pBillDetailsList.setBorder(t4);
		pBillDetailsList.setBackground(SystemColor.control);
		pBillDetailsList.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 25, 1498, 210);
		pBillDetailsList.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		//DefaultTableModel tableModel = new DefaultTableModel();
		table.setModel(tableModel);
		scrollPane.setViewportView(table);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 14));
		table.setRowHeight(20);
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(SystemColor.controlShadow));
		panel.setBounds(925, 586, 580, 61);
		pTab1.add(panel);
		panel.setLayout(null);
		
		JPanel panelFunction2 = new JPanel();
		panelFunction2.setBorder(new LineBorder(SystemColor.controlShadow));
		
		panelFunction2.setBounds(0, 0, 580, 61);
		panel.add(panelFunction2);
		panelFunction2.setBackground(SystemColor.control);
		panelFunction2.setLayout(null);
		
		JButton btnDeleteRowTableCTHD = new JButton("Xóa Xe CTHD");	
		btnDeleteRowTableCTHD.setBackground(new Color(255, 69, 0));
		btnDeleteRowTableCTHD.setIcon(new ImageIcon(UI_HoaDon.class.getResource("/image/delete-icon.png")));
		btnDeleteRowTableCTHD.setBounds(10, 6, 191, 45);
		btnDeleteRowTableCTHD.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelFunction2.add(btnDeleteRowTableCTHD);
		
		JButton btnRemoveCTHD = new JButton("Hủy CTHD");
		btnRemoveCTHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRemoveCTHD.setIcon(new ImageIcon(UI_HoaDon.class.getResource("/image/Status-dialog-error-icon.png")));
		btnRemoveCTHD.setBackground(Color.RED);
		btnRemoveCTHD.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRemoveCTHD.setBounds(211, 6, 175, 45);
		panelFunction2.add(btnRemoveCTHD);
		
		JButton btnPayments = new JButton("Thanh Toán");
		btnPayments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPayments.setBackground(Color.ORANGE);
		btnPayments.setIcon(new ImageIcon(UI_HoaDon.class.getResource("/image/coin-icon.png")));
		btnPayments.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnPayments.setBounds(396, 6, 175, 45);
		panelFunction2.add(btnPayments);
		
		//>>>>>>>>>>> DELETE Vehicle
				btnDeleteRowTableCTHD.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int row = table.getSelectedRow();
						if (row < 0)
							JOptionPane.showMessageDialog(null, "Vui lòng chọn Xe cần xóa khỏi CTHD");
						else {
							double tien;
							double thue;
							try {
								tien = df.parse(table.getValueAt(row, 11).toString()).doubleValue();
								thue = df.parse(table.getValueAt(row, 10).toString()).doubleValue();
								double total = df.parse(txtTotal.getText()).doubleValue();
								double totalThue = df.parse(txtTotalVAT.getText()).doubleValue();
								total -= tien;
								totalThue -= thue;
								txtTotal.setText(df.format(total));
								txtTotalVAT.setText(df.format(totalThue));
								tableModel.removeRow(row);
							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
				});
				
				//>>>>>>>>>>> REMOVE CTHD
				btnRemoveCTHD.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if(tableModel.getRowCount()<=0)
							JOptionPane.showMessageDialog(null, "Không có xe nào trong danh sách xe bán");
						else {
							tableModel.getDataVector().removeAllElements();
							tableModel.fireTableDataChanged();
							txtTotal.setText(df.format(0));
							txtTotalVAT.setText(df.format(0));
						}
					}
				});
				
				//>>>>>>>>>>> PAYMENTS
				btnPayments.addMouseListener(new MouseAdapter() {
					public boolean CheckPayment() throws HeadlessException, ParseException {
						if (txtCMND_Bill.getText().equalsIgnoreCase("")) {
							JOptionPane.showMessageDialog(null, "Vui lòng chọn Khách Hàng!");
							return false;
						} else
							try {
								if(khachHangFacade.getKhachHangById("CMND",txtCMND_Bill.getText()) == null) {
									KhachHang kh = khachHangFacade.getKhachHangById("CMND",txtCMND_Bill.getText());
									JOptionPane.showMessageDialog(null, "Thông tin Khách Hàng không hợp lệ!");
									return false;
								}				
								else if(df.parse(txtTotal.getText()).doubleValue() == 0) {
									JOptionPane.showMessageDialog(null, "Chưa có sản phẩm");
									return false;
								}
							} catch (HeadlessException | RemoteException | ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						if(txtCMND_Bill.getText().length()==0) 
							maKhachHang = "";
						else
							try {
								maKhachHang = khachHangFacade.getKhachHangById("CMND",txtCMND_Bill.getText()).getMaKhachHang();
							} catch (RemoteException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						return true;
					}
					@Override
					public void mouseClicked(MouseEvent e) {
						try {
							if (CheckPayment()) {
								UI_ThanhToan thanhToan = new UI_ThanhToan();
								thanhToan.setVisible(true);
								thanhToan.txtCusMoney.requestFocus();
							}
						} catch (HeadlessException | ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (MalformedURLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (NotBoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
		//table.setBorder(BorderFactory.createLineBorder(Color.white));
		
		JPanel panelTotal = new JPanel();
		panelTotal.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelTotal.setBounds(443, 586, 473, 61);
		pTab1.add(panelTotal);
		panelTotal.setBackground(SystemColor.control);
		panelTotal.setLayout(null);
		
		JLabel lblTotalBill = new JLabel("Tổng Tiền");
		lblTotalBill.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotalBill.setBounds(10, 12, 111, 28);
		lblTotalBill.setForeground(new Color(255, 0, 0));
		lblTotalBill.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTotalBill.setVerticalAlignment(SwingConstants.BOTTOM);
		panelTotal.add(lblTotalBill);
		txtTotal.setForeground(Color.RED);
		txtTotal.setBackground(Color.WHITE);
		txtTotal.setEditable(false);
		
		//txtTotal = new TextField();
		txtTotal.setText("0 VNĐ");
		txtTotal.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtTotal.setBounds(142, 12, 297, 36);
		panelTotal.add(txtTotal);
		
		JPanel pTotalVAT = new JPanel();
		pTotalVAT.setBorder(new LineBorder(SystemColor.controlShadow));
		pTotalVAT.setBounds(0, 586, 433, 61);
		pTotalVAT.setBackground(SystemColor.control);
		pTab1.add(pTotalVAT);
		pTotalVAT.setLayout(null);
		
		JLabel lblTotalVAT = new JLabel("Tổng Thuế VAT");
		lblTotalVAT.setForeground(Color.RED);
		lblTotalVAT.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTotalVAT.setBounds(22, 11, 165, 41);
		pTotalVAT.add(lblTotalVAT);
		
		txtTotalVAT.setText("0 VNĐ");
		txtTotalVAT.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtTotalVAT.setForeground(new Color(50, 205, 50));
		txtTotalVAT.setBackground(Color.WHITE);
		txtTotalVAT.setBounds(207, 15, 207, 31);
		pTotalVAT.add(txtTotalVAT);
		txtTotalVAT.setColumns(10);
		
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		JPanel pTab2 = new JPanel();
		pTab2.setVisible(false);
		pTab2.setBounds(10, 101, 1513, 687);
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
		
		dcNgayLHD = new JDateChooser();		
		dcNgayLHD.setBounds(589, 70, 141, 21);
		dcNgayLHD.setDateFormatString("yyyy-MM-dd");
		dcNgayLHD.setDate(Date.valueOf(LocalDate.now()));
		pSearchInfo.add(dcNgayLHD);
		
		JPanel pChucNang = new JPanel();
		pChucNang.setBorder(new TitledBorder(null, "Chức năng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pChucNang.setBounds(829, 5, 369, 124);
		pTab2.add(pChucNang);
		pChucNang.setLayout(null);
		
		JButton btnXoaTrong = new JButton("Xóa Trống");
		btnXoaTrong.setIcon(new ImageIcon("/image/Recycle-Bin-Full-icon.png"));
		btnXoaTrong.setBackground(Color.ORANGE);
		btnXoaTrong.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnXoaTrong.setBounds(20, 22, 153, 40);
		pChucNang.add(btnXoaTrong);
		
		JButton btnXuatHD = new JButton("Xuất Hóa Đơn");
		btnXuatHD.setBackground(new Color(169, 169, 169));
		btnXuatHD.setIcon(new ImageIcon("/image/Printer-icon.png"));
		btnXuatHD.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnXuatHD.setBounds(20, 75, 330, 37);
		pChucNang.add(btnXuatHD);
		
		JButton btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.setBackground(new Color(255, 160, 122));
		btnLamMoi.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnLamMoi.setIcon(new ImageIcon("/image/Refresh-icon (1).png"));
		btnLamMoi.setBounds(190, 22, 160, 40);
		pChucNang.add(btnLamMoi);
		
		JPanel pHinhAnh = new JPanel();
		pHinhAnh.setBounds(1215, 10, 288, 119);
		pHinhAnh.setBorder(new LineBorder(new Color(0, 0, 0)));
		pTab2.add(pHinhAnh);
		pHinhAnh.setLayout(null);
		
		JLabel lblHinhAnh = new JLabel("         Chưa có hình ảnh");
		lblHinhAnh.setBounds(10, 5, 268, 104);
		pHinhAnh.add(lblHinhAnh);
		lblHinhAnh.setForeground(Color.RED);
		
		JPanel pHoaDon = new JPanel();
		pHoaDon.setBorder(new TitledBorder(null, "Thông tin hóa đơn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pHoaDon.setBounds(0, 139, 1503, 241);
		pTab2.add(pHoaDon);
		pHoaDon.setLayout(null);
		
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(10, 20, 1483, 211);
		pHoaDon.add(scrollPane1);
		
		JTable table1 = new JTable();
		scrollPane1.setViewportView(table1);
		String[] header1 = {"Mã Hóa Đơn", "Mã Khách Hàng", "Tên Khách Hàng", "CMND/TCC", "Mã Nhân Viên", "Tên Nhân viên", "Ngày LHD", "Tổng Tiền"};
		tableModel1 = new DefaultTableModel(header1, 0){
	       @Override
	       public boolean isCellEditable(int i, int i1) {
	           return false; //To change body of generated methods, choose Tools | Templates.
	       }
		};
		scrollPane1.setViewportView(table1);
		table1.setModel(tableModel1);
		try {
			tableModel1 = hoaDonFacade.getAllOrder();
		} catch (RemoteException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		table1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table1.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 13));
		table1.setRowHeight(20);
		table1.setAutoCreateRowSorter(true);
		table1.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		
		JPanel pCTHD = new JPanel();
		pCTHD.setBorder(new TitledBorder(null, "Thông tin chi tiết hóa đơn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pCTHD.setBounds(0, 395, 1503, 234);
		pTab2.add(pCTHD);
		pCTHD.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 24, 1483, 200);
		pCTHD.add(scrollPane_1);
		
		JTable table2 = new JTable();
		scrollPane_1.setViewportView(table2);
		String[] header2 = {"Mã Hóa Đơn", "Mã Xe", "Tên Xe", "Loại Xe", "Phiên Bản", "Màu xe", "Phân Khối", "Hãng Sản Xuất", "Số Khung", "Số Máy", "Đơn Giá", "Thuế VAT", "Thành tiền"};
		tableModel2 = new DefaultTableModel(header2, 0){
	       @Override
	       public boolean isCellEditable(int i, int i1) {
	           return false; //To change body of generated methods, choose Tools | Templates.
	       }
		};
		scrollPane_1.setViewportView(table2);
		table2.setModel(tableModel2);
		table2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table2.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 13));
		table2.setRowHeight(20);
		table2.setAutoCreateRowSorter(true);
		table2.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		
//==============================================================================================================================================================
		
		
//====================Xử lý button=============================================================================
		//>>>>>>>>>>>>>>>>>>>TAb
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn1.setBackground(new Color(240, 230, 140));
				btn2.setBackground(Color.white);
				pTab1.setVisible(true);
				pTab2.setVisible(false);
			}
		});
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn2.setBackground(new Color(240, 230, 140));
				btn1.setBackground(Color.white);
				pTab1.setVisible(false);
				pTab2.setVisible(true);
			}
		});
		
		
		//>>>>>>>>>>> Xóa rỗng
		btnEmptyDelete_Bill.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cbbVehicleName_Bill.setSelectedIndex(-1);
				cbbVersion.setSelectedIndex(-1);
				cbbChasisNumber.setSelectedIndex(-1);
				cbbVehicleColor_Bill.setSelectedIndex(-1);
				txtVehicleEngineNum.setText("");
				txtVehicleNum_Bill.setText("");
				lblImage.setIcon(null);
				lblImage.setText("                          Chưa có hình ảnh");
			}
		});
				
				btnXoaTrong.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						txtMaHD.setText("");
						txtTenKH.setText("");
						txtMaKH.setText("");
						//dcNgayLHD.setDate(Date.valueOf(LocalDate.now()));
						dcNgayLHD.setCalendar(null);
						dcNgayLHD.setToolTipText("");
						SearchHD(header1);
					}
				});
				
				btnLamMoi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dcNgayLHD.setDate(Date.valueOf(LocalDate.now()));
						SearchHD(header1);
					}
				});
				
				btnXuatHD.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int row = table1.getSelectedRow();
						if(row < 0) 
							JOptionPane.showMessageDialog(null, "Vui lòng chọn hóa đơn");
						else {
							Bill.maHD = table1.getValueAt(row, 0).toString();
							Bill.kt = 1;
							try {
								Bill bill = new Bill();
							} catch (RemoteException | MalformedURLException | NotBoundException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							//bill.setVisible(true);
							PrintSupport.printComponent(Bill.textArea);
							String cmds[] = new String[] {"cmd", "/c", "C:\\Users\\hoais\\OneDrive\\Desktop\\a.pdf"};
							try {
							    Runtime.getRuntime().exec(cmds);
							}catch (Exception e1) {
								// TODO: handle exception
							}
						}
					}
				});
				
				//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> tbl Table
				
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						 int viTriDongVuaBam = table.getSelectedRow();
						 txtVehicleNum_Bill.setText(table.getValueAt(viTriDongVuaBam, 0).toString());
						 Xe xe;
						try {
							xe = xeFacade.getInfoXe("maXe",table.getValueAt(viTriDongVuaBam, 0).toString());
							int sl = cbbVehicleName_Bill.getItemCount();
							 for (int i = 0; i<sl; i++) {
								 if(cbbVehicleName_Bill.getItemAt(i).toString().equalsIgnoreCase(xe.getTenXe())) {
									 cbbVehicleName_Bill.setSelectedIndex(i);
									 break;
								 }
							 }
							 sl = cbbVersion.getItemCount();
							 for (int i = 0; i<sl; i++) {
								 if(cbbVersion.getItemAt(i).toString().equalsIgnoreCase(xe.getPhienBan())) {
									 cbbVersion.setSelectedIndex(i);
									 break;
								 }
							 }
							 sl = cbbVehicleColor_Bill.getItemCount();
							 for (int i = 0; i<sl; i++) {
								 if(cbbVehicleColor_Bill.getItemAt(i).toString().equalsIgnoreCase(xe.getMauXe())) {
									 cbbVehicleColor_Bill.setSelectedIndex(i);
									 break;
								 }
							 }
							 sl = cbbChasisNumber.getItemCount();
							 for (int i = 0; i<sl; i++) {
								 if(cbbChasisNumber.getItemAt(i).toString().equalsIgnoreCase(xe.getSoKhung())) {
									 cbbChasisNumber.setSelectedIndex(i);
									 break;
								 }
							 }
							 txtVehicleEngineNum.setText(xe.getSoMay());
							 if (xe.getImg1() =="") {
									lblImage.setIcon(null);
									lblImage.setText("                          Chưa có hình ảnh");
								} else {
									BufferedImage img = null;
									try {
										img = ImageIO.read(new File(xe.getImg1()));
									} catch (IOException e1) {
										e1.printStackTrace();
									}
									Image dimg = img.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);
									ImageIcon imageIcon = new ImageIcon(dimg);
									lblImage.setIcon(imageIcon);
								}
						} catch (RemoteException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
					}
				});
				
				table1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int row = table1.getSelectedRow();
						try {
							tableModel2 = hoaDonFacade.getOrderDetails( table1.getValueAt(row, 0).toString());
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				
//				table2.addMouseListener(new MouseAdapter() {
//					@Override
//					public void mouseClicked(MouseEvent e) {
//						int row = table2.getSelectedRow();
//						try {
//							boolean check = xeFacade.getImage(lblHinhAnh, table2.getValueAt(row, 1).toString());
//						} catch (RemoteException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}
//					}
//				});
				
		
		//>>>>>>>>>>> ADD Vehicle
		btnAddVehicle_Bill.addMouseListener(new MouseAdapter() {
			public String CheckValueVehicle() {
				if (txtVehicleNum_Bill.getText() == null) 
					return "Vui lòng chọn xe";
				int sl = table.getRowCount();
				if(sl > 0)
					for(int i = 0; i<sl ; i++)
						if(txtVehicleNum_Bill.getText().equalsIgnoreCase(table.getValueAt(i, 0).toString()))
							return "Xe đã tồn tại trong chi tiết hóa đơn!";
				return null;
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if (CheckValueVehicle()!= null)
					JOptionPane.showMessageDialog(null, CheckValueVehicle());
				else {
					try {
						double total =0;
						double totalThue = 0;
						try {
							total = df.parse(txtTotal.getText()).doubleValue();
							totalThue = df.parse(txtTotalVAT.getText()).doubleValue();
							Xe xe = xeFacade.getInfoXe("maXe", txtVehicleNum_Bill.getText());
							LoaiXe lx = loaiXeFacade.layLoaiXeById(xe.getLoaiXe().getMaLoaiXe());
							HangSanXuat hsx = hangSanXuatFacade.getHangSanXuatById(xe.getHangSanXuat().getMaHangSX());
							double thanhTien = xe.getDonGia() + xe.getThueVAT();
							total += thanhTien;
							totalThue += xe.getThueVAT();
							tableModel.addRow(new Object[] {xe.getMaXe(), xe.getTenXe(), lx.getTenLoaiXe(), xe.getPhienBan(), xe.getMauXe(), xe.getPhanKhoi()+"", hsx.getTenHangSX(), xe.getSoKhung(), xe.getSoMay(), df.format(xe.getDonGia()), df.format(xe.getThueVAT()), df.format(thanhTien)});
							txtTotal.setText(df.format(total));
							txtTotalVAT.setText(df.format(totalThue));
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Mã xe không tồn tại!!!");
						} 
						cbbVehicleName_Bill.removeAllItems();
						ArrayList<String> listName4 = xeFacade.getXeByTrangThai("select DISTINCT tenXe from Xe where trangThai = N'Còn hàng' order by tenXe", "tenXe");
						for (String string : listName4) {
							cbbVehicleName_Bill.addItem(string);
						}
						cbbVehicleColor_Bill.removeAllItems();
						cbbVersion.removeAllItems();
						cbbChasisNumber.removeAllItems();
						txtVehicleNum_Bill.setText("");
						txtVehicleEngineNum.setText("");
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		});
		
		//>>>>>>>>>>> txt vehicle num
		txtVehicleNum_Bill.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					Xe xe = xeFacade.getInfoXe22("maXe", txtVehicleNum_Bill.getText());
					if(xe != null) {
						getTenXe(xe);
						if (xe.getImg1() =="") {
							lblImage.setIcon(null);
							lblImage.setText("                          Chưa có hình ảnh");
						} else {
							BufferedImage img = null;
							try {
								img = ImageIO.read(new File(xe.getImg1()));
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							Image dimg = img.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);
							ImageIcon imageIcon = new ImageIcon(dimg);
							lblImage.setIcon(imageIcon);
						}
					}
					else {
						String temp = txtVehicleNum_Bill.getText();
						cbbVehicleName_Bill.setSelectedIndex(-1);
						cbbVersion.setSelectedIndex(-1);
						cbbChasisNumber.setSelectedIndex(-1);
						txtVehicleNum_Bill.setText(temp);
						txtVehicleEngineNum.setText("");
						lblImage.setIcon(null);
						lblImage.setText("                          Chưa có hình ảnh");
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}				
			}
		});
		//>>>>>>>>>>> cbb Vehicle Name
		cbbVehicleName_Bill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(cbbVehicleName_Bill.getSelectedIndex() != -1) {
						if (cbbVersion.getItemCount() > 0)
							cbbVersion.removeAllItems();
						String tenXe = cbbVehicleName_Bill.getSelectedItem().toString();
						ArrayList<String> listVersion  = xeFacade.getListVersion(tenXe);
						for (String string : listVersion) {
							cbbVersion.addItem(string);
						}
						boolean check = xeFacade.getImage(lblImage, txtVehicleNum_Bill.getText());
					} else {
						cbbVersion.setSelectedIndex(-1);
						txtVehicleNum_Bill.setText("");
						txtVehicleEngineNum.setText("");
						ArrayList<String> listNumber = xeFacade.getXeByTrangThai("select soKhung from Xe where trangThai = N'Còn hàng'", "soKhung");
						for (String string : listNumber) {
							cbbChasisNumber.addItem(string);
						}
						cbbVehicleName_Bill.setSelectedIndex(-1);
					}
					
				} catch (RemoteException e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}	
			}
		});	
		//>>>>>>>>>>> cbb  Vehicle Color
		cbbVehicleColor_Bill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (cbbChasisNumber.getItemCount() > 0)
						cbbChasisNumber.removeAllItems();
					String tenXe = "";
					String version = "";
					if(cbbVehicleName_Bill.getSelectedIndex() != -1) 
						tenXe = cbbVehicleName_Bill.getSelectedItem().toString();
					if(cbbVersion.getSelectedIndex() != -1)
						version = cbbVersion.getSelectedItem().toString();
					if (cbbVehicleColor_Bill.getSelectedIndex() != -1) {
						String mauXe = cbbVehicleColor_Bill.getSelectedItem().toString();
						ArrayList<String> listNumber = xeFacade.getListChassisNumber(tenXe, version, mauXe);
						for (String string : listNumber) {
							cbbChasisNumber.addItem(string);
						}
					}
					
				} catch (RemoteException e2) {
					// TODO: handle exception
				}
			}
		});
//		//>>>>>>>>>>> cbb Version Vehicle
		cbbVersion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (cbbVehicleColor_Bill.getItemCount() > 0)
						cbbVehicleColor_Bill.removeAllItems();
					String tenXe = "";
					String version = "";
					if(cbbVehicleName_Bill.getSelectedIndex() != -1) 
						tenXe = cbbVehicleName_Bill.getSelectedItem().toString();
					if(cbbVersion.getSelectedIndex() != -1) {
						version = cbbVersion.getSelectedItem().toString();
						ArrayList<String> listColor= xeFacade.getListColor(tenXe, version);
						for (String string : listColor) {
							cbbVehicleColor_Bill.addItem(string);
						}
					}
					
				} catch (RemoteException e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}	
			}
		});
//		
//		//>>>>>>>>>>> cbb Chassis Number
		cbbChasisNumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tenXe, version, mauXe, soKhung;
				if (cbbChasisNumber.getSelectedIndex() != -1) {
					try {
						soKhung = cbbChasisNumber.getSelectedItem().toString();
						Xe xe = xeFacade.getInfoXe("soKhung", soKhung);
						txtVehicleNum_Bill.setText(xe.getMaXe());
						txtVehicleEngineNum.setText(xe.getSoMay());		
						getTenXe(xe);
						if (xe.getImg1() =="") {
							lblImage.setIcon(null);
							lblImage.setText("                          Chưa có hình ảnh");
						} else {
							BufferedImage img = null;
							try {
								img = ImageIO.read(new File(xe.getImg1()));
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							Image dimg = img.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);
							ImageIcon imageIcon = new ImageIcon(dimg);
							lblImage.setIcon(imageIcon);
						}
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
				else {
					txtVehicleNum_Bill.setText("");
					txtVehicleEngineNum.setText("");
				}
			}
		}); 

//====================Xử lý eventAction==========================================================================

		//>>>>>>>>>>> txt CMND
		txtCMND_Bill.addKeyListener(new KeyAdapter() {
			public boolean isNumeric(String str) {
				  return str.matches("\\d*");  //match a number with optional '-' and decimal. "-?\\d+(\\.\\d+)?"
				}
			    @Override
			public void keyReleased(KeyEvent e) {
				if(!isNumeric(txtCMND_Bill.getText())) 
					txtCMND_Bill.setForeground(Color.red);
				else
					txtCMND_Bill.setForeground(Color.BLACK);
				if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE||e.getKeyCode()==KeyEvent.VK_DELETE)
		        {
		           
		        }
		        else
		        {   
		            String to_check=txtCMND_Bill.getText();
		            int to_check_len=to_check.length();
		            for(String data:list_CMND)
		            {
		                String check_from_data="";
		                for(int i=0;i<to_check_len;i++)
		                {
		                    if(to_check_len<=data.length())
		                    {
		                        check_from_data = check_from_data+data.charAt(i);
		                    }
		                }
		                //System.out.print(check_from_data);
		                if(check_from_data.equals(to_check))
		                {
		                    //System.out.print("Found");
		                    txtCMND_Bill.setText(data);
		                    txtCMND_Bill.setSelectionStart(to_check_len);
		                    txtCMND_Bill.setSelectionEnd(data.length());
		                    break;
		                }
		            }
		        }

				KhachHang kh;
				try {
					kh = khachHangFacade.getKhachHangById("CMND", txtCMND_Bill.getText());
					if(kh != null) {
						txtCustomerName_Bill.setText(kh.getTenKhachHang());
						txtNumPhone_Bill.setText(kh.getSoDienThoai());
						txtNoteCustomer_Bill.setText(kh.getChuThich());
					}
					else {
						txtCustomerName_Bill.setText("");
						txtNumPhone_Bill.setText("");
						txtNoteCustomer_Bill.setText("");
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		txtMaHD.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				SearchHD(header1);
			}
		});
		
		txtTenKH.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				SearchHD(header1);
			}
		});
		
		txtMaKH.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				SearchHD(header1);
			}
		});
		
		dcNgayLHD.addPropertyChangeListener(new PropertyChangeListener() {
			public int calculateAge(LocalDate birthDate, LocalDate currentDate) {
		        if ((birthDate != null) && (currentDate != null)) {
		            return Period.between(birthDate, currentDate).getYears();
		        } else {  
		            return 0;
		        }
		    }
			public void propertyChange(PropertyChangeEvent evt) {
				SearchHD(header1);
			}
		});
		
//====================UPDATE DATA===============================================================================
			
			// update CMND Customer
			pCustomerInfo_Bill.addAncestorListener(new AncestorListener() {
				public void ancestorAdded(AncestorEvent event) {
					String cmndKHTail = list_CMND.get(list_CMND.size()-1);
					KhachHang kh;
					try {
						kh = khachHangFacade.getKhachHangTail();
						if (list_CMND.get(list_CMND.size()-1).equalsIgnoreCase(kh.getCMND())) {
							
						} else {
							list_CMND.add(kh.getCMND());
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
	}
	public void SearchHD(String[] header1) {
		HoaDonFacade hoaDonFacade;
		try {
			hoaDonFacade = (HoaDonFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/hoaDonFacade");
			String ngay = ((JTextField) dcNgayLHD.getDateEditor().getUiComponent()).getText();
			try {
				tableModel1 = hoaDonFacade.getAllOrderById (txtMaHD.getText().trim(), txtMaKH.getText().trim(), txtTenKH.getText().trim(), ngay);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Dao_HoaDon dao_hd = new Dao_HoaDon();
	}
	
	public void getTenXe(Xe xe) {
		int slName = cbbVehicleName_Bill.getItemCount();
		for (int i = 0; i<slName; i++)
			if (cbbVehicleName_Bill.getItemAt(i).toString().equalsIgnoreCase(xe.getTenXe())) {
				cbbVehicleName_Bill.setSelectedIndex(i);
			}
		
		int slversion = cbbVersion.getItemCount();
		for(int i = 0; i<slversion; i++)
			if (cbbVersion.getItemAt(i).toString().equalsIgnoreCase(xe.getPhienBan())){
				cbbVersion.setSelectedIndex(i);
			}
		
		int slColor = cbbVehicleColor_Bill.getItemCount();
		for(int i = 0; i<slColor; i++)
			if (cbbVehicleColor_Bill.getItemAt(i).toString().equalsIgnoreCase(xe.getMauXe())){
				cbbVehicleColor_Bill.setSelectedIndex(i);
			}
		
		int slnumber = cbbChasisNumber.getItemCount();
		for(int i = 0; i<slnumber; i++)
			if (cbbChasisNumber.getItemAt(i).toString().equalsIgnoreCase(xe.getSoKhung())){
				cbbChasisNumber.setSelectedIndex(i);
			}
			txtVehicleEngineNum.setText(xe.getSoMay());
		
	}
}
