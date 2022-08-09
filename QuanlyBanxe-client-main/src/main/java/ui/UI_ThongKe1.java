package ui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.MatteBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import businesslogic.facade.HopDongFacade;
import businesslogic.facade.KhachHangFacade;
import businesslogic.facade.ThongkeFacade;
import businesslogic.facade.XeFacade;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.CardLayout;

import others.TableHeaderRenderer;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UI_ThongKe1 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultTableModel tableModel;
	private DefaultTableModel tableModelKH;
	private DefaultTableModel tableModelNV;
	private DefaultTableModel tableModelCTNV;
	@SuppressWarnings("unused")
	private JTextField txtTen;
	@SuppressWarnings("unused")
	private JTextField txtSl;
	@SuppressWarnings("unused")
	private JTextField txtTongTien;
	private JRadioButton rdThang;
	private JRadioButton rdNgay;
	private JRadioButton rdNam;
	private JLabel lbChiTiet;
	private ThongkeFacade thongkeFacade = (ThongkeFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/thongkeFacade");
	private JTable table;
	private JTable tableKH;
	private JPanel pnChartXeMuaBan;
	private JPanel pnChartKKhachHang;
	private JPanel pnNhanVien;
	private DefaultCategoryDataset dcd;
	private DefaultCategoryDataset dcdKH;
	private DefaultCategoryDataset dcdDT;
	@SuppressWarnings("rawtypes")
	private JComboBox cbNam= new JComboBox<>();
	@SuppressWarnings("rawtypes")
	private JComboBox cbThang= new JComboBox<>();;
	private JComboBox<Object> cbNgay= new JComboBox<>();
	private JTable tbNhanVien;
	private JTable tbCTNV;
	private JLabel lbSTDB;
	private JLabel lbSLXeMoi;
	private JLabel lbSLXeBan;
	private JLabel lbSLKhachHang;
	private JLabel lbSLTienBan;
	private JLabel lbTKXB;
	private JLabel lbTKXM;
	private JLabel lbSLKH;
	private JLabel lblBieuDoXe;
	private JLabel lbXeTrongThang;
	private XeFacade xeFacade = (XeFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/xeFacade");
	private KhachHangFacade khachHangFacade = (KhachHangFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/khachHangFacade");
	private JLabel txtTuoi;
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
					UI_ThongKe1 frame = new UI_ThongKe1();
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
	@SuppressWarnings({ "unchecked" })
	public UI_ThongKe1() throws RemoteException, MalformedURLException, NotBoundException {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(100, 100, screen.width, (screen.height-50));
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
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1532, 78);
		contentPane.add(panel);
		
		JButton btnLoai = new JButton("");
		btnLoai.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pnNhanVien.setVisible(true);
				pnChartKKhachHang.setVisible(false);
				pnChartXeMuaBan.setVisible(false);
			}
		});
		btnLoai.setIcon(new ImageIcon("img1\\em.png"));
		btnLoai.setFocusable(false);
		btnLoai.setBorderPainted(false);
		btnLoai.setBackground(Color.WHITE);
		btnLoai.setBounds(157, 10, 120, 43);
		panel.add(btnLoai);
		
		JButton btnHang = new JButton("");
		btnHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pnChartXeMuaBan.setVisible(false);
				pnChartKKhachHang.setVisible(true);
				pnNhanVien.setVisible(false);
			}
		});
		btnHang.setIcon(new ImageIcon("img1\\Customer.png"));
		btnHang.setFocusable(false);
		btnHang.setBorderPainted(false);
		btnHang.setBackground(Color.WHITE);
		btnHang.setBounds(326, 10, 120, 43);
		panel.add(btnHang);
		
		JButton btnXe = new JButton("");
		btnXe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pnChartKKhachHang.setVisible(false);
				pnChartXeMuaBan.setVisible(true);
				pnNhanVien.setVisible(false);
			}
		});
		btnXe.setIcon(new ImageIcon("img1\\cruise-bike-icon.png"));
		btnXe.setFocusable(false);
		btnXe.setBorderPainted(false);
		btnXe.setBackground(Color.WHITE);
		btnXe.setBounds(10, 10, 93, 43);
		panel.add(btnXe);
		
		JLabel lbXe = new JLabel("Thống Kê Xe");
		lbXe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbXe.setHorizontalAlignment(SwingConstants.CENTER);
		lbXe.setBounds(10, 55, 93, 23);
		panel.add(lbXe);
		
		JLabel lblNhanVien = new JLabel("Thống Kê Nhân Viên");
		lblNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
		lblNhanVien.setBounds(144, 55, 148, 23);
		panel.add(lblNhanVien);
		
		JLabel lblHngSnXut = new JLabel("Thống Kê Khách Hàng");
		lblHngSnXut.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHngSnXut.setHorizontalAlignment(SwingConstants.CENTER);
		lblHngSnXut.setBounds(313, 55, 148, 23);
		panel.add(lblHngSnXut);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(25, 88, 349, 176);
		
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		//Thống kê số lượng xe mới
		JLabel lbThongKeXeMoi = new JLabel("");
		lbThongKeXeMoi.setBackground(Color.BLACK);
		lbThongKeXeMoi.setForeground(Color.WHITE);
		
		lbThongKeXeMoi.setBounds(0, 0, 349, 176);
		BufferedImage img = null;
		String imgURL= "img\\1.png";
		try {
		    img = ImageIO.read(new File(imgURL));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		Image dimg = img.getScaledInstance(lbThongKeXeMoi.getWidth(), lbThongKeXeMoi.getHeight(),
		        Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(dimg);
		
		lbTKXM = new JLabel("Tổng Số Lượng Xe Mới Trong Tháng "+ LocalDate.now().getMonthValue()+"-"+LocalDate.now().getYear());
		lbTKXM.setForeground(Color.WHITE);
		lbTKXM.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbTKXM.setHorizontalAlignment(SwingConstants.CENTER);
		lbTKXM.setBounds(0, 2, 349, 34);
		panel_1.add(lbTKXM);
		
		JLabel lbSLXeMoi = new JLabel("...");
		
		lbSLXeMoi.setForeground(Color.WHITE);
		lbSLXeMoi.setHorizontalAlignment(SwingConstants.CENTER);
		lbSLXeMoi.setFont(new Font("Tahoma", Font.BOLD, 30));
		lbSLXeMoi.setBounds(10, 46, 317, 63);
		panel_1.add(lbSLXeMoi);
		lbThongKeXeMoi.setIcon(imageIcon);
		panel_1.add(lbThongKeXeMoi);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(409, 88, 349, 176);
		contentPane.add(panel_2);
		
		//Thống kê số lượng xe bán
		JLabel lbThongKeSoLuongXeBan = new JLabel("");
		lbThongKeSoLuongXeBan.setBounds(0, 0, 349, 176);
		BufferedImage img1 = null;
		String imgURL1= "img\\2.png";
		try {
		    img1 = ImageIO.read(new File(imgURL1));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		Image dimg1 = img1.getScaledInstance(lbThongKeXeMoi.getWidth(), lbThongKeXeMoi.getHeight(),
		        Image.SCALE_SMOOTH);
		ImageIcon imageIcon1 = new ImageIcon(dimg1);
		
		JLabel lbTKXB = new JLabel("Tổng Số Lượng Xe Bán Trong Tháng "+ LocalDate.now().getMonthValue());
		lbTKXB.setHorizontalAlignment(SwingConstants.CENTER);
		lbTKXB.setForeground(Color.WHITE);
		lbTKXB.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbTKXB.setBounds(0, 0, 337, 34);
		panel_2.add(lbTKXB);
		
		lbSLXeBan = new JLabel("...");
		
		lbSLXeBan.setHorizontalAlignment(SwingConstants.CENTER);
		lbSLXeBan.setForeground(Color.WHITE);
		lbSLXeBan.setFont(new Font("Tahoma", Font.BOLD, 30));
		lbSLXeBan.setBounds(10, 46, 317, 63);
		panel_2.add(lbSLXeBan);
		lbThongKeSoLuongXeBan.setIcon(imageIcon1);
		panel_2.add(lbThongKeSoLuongXeBan);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(800, 88, 349, 176);
		contentPane.add(panel_3);
		
		//Thống kê doanh thu
		JLabel lbThongKeSoTienDaBan = new JLabel("");
		lbThongKeSoTienDaBan.setBounds(0, 0, 350, 176);
		BufferedImage img2 = null;
		String imgURL2= "img\\3.png";
		try {
		    img2 = ImageIO.read(new File(imgURL2));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		Image dimg2 = img2.getScaledInstance(lbThongKeXeMoi.getWidth(), lbThongKeXeMoi.getHeight(),
		        Image.SCALE_SMOOTH);
		ImageIcon imageIcon2 = new ImageIcon(dimg2);
		
		lbSTDB = new JLabel("Tổng Doanh Thu Trong Tháng "+ LocalDate.now().getMonthValue());
		lbSTDB.setHorizontalAlignment(SwingConstants.CENTER);
		lbSTDB.setForeground(Color.WHITE);
		lbSTDB.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbSTDB.setBounds(0, 0, 337, 34);
		panel_3.add(lbSTDB);
		
		lbSLTienBan = new JLabel("...");
		lbSLTienBan.setHorizontalAlignment(SwingConstants.CENTER);
		lbSLTienBan.setForeground(Color.WHITE);
		lbSLTienBan.setFont(new Font("Tahoma", Font.BOLD, 30));
		lbSLTienBan.setBounds(0, 47, 350, 63);
		panel_3.add(lbSLTienBan);
		lbThongKeSoTienDaBan.setIcon(imageIcon2);
		panel_3.add(lbThongKeSoTienDaBan);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBounds(1175, 88, 337, 176);
		contentPane.add(panel_4);
		
		//Thống kê khách hàng 
		JLabel lbThongKeKH = new JLabel("");
		lbThongKeKH.setBounds(0, 0, 337, 176);
		BufferedImage img3 = null;
		String imgURL3= "img\\4.png";
		try {
		    img3 = ImageIO.read(new File(imgURL3));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		Image dimg3 = img3.getScaledInstance(lbThongKeXeMoi.getWidth(), lbThongKeXeMoi.getHeight(),
		        Image.SCALE_SMOOTH);
		ImageIcon imageIcon3 = new ImageIcon(dimg3);
		
		lbSLKH = new JLabel("Số Khách Hàng Mới Trong Tháng "+ LocalDate.now().getMonthValue());
		lbSLKH.setHorizontalAlignment(SwingConstants.CENTER);
		lbSLKH.setForeground(Color.WHITE);
		lbSLKH.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbSLKH.setBounds(0, 0, 337, 34);
		panel_4.add(lbSLKH);
		
		lbSLKhachHang = new JLabel("...");
		lbSLKhachHang.setHorizontalAlignment(SwingConstants.CENTER);
		lbSLKhachHang.setForeground(Color.WHITE);
		lbSLKhachHang.setFont(new Font("Tahoma", Font.BOLD, 30));
		lbSLKhachHang.setBounds(0, 46, 323, 63);
		panel_4.add(lbSLKhachHang);
		lbThongKeKH.setIcon(imageIcon3);
		panel_4.add(lbThongKeKH);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(25, 308, 1492, 429);
		//Thống kê bằng biểu đồ
		dcd= new DefaultCategoryDataset();
		Calendar calendar = Calendar.getInstance();
		calendar.set(LocalDate.now().getYear(), LocalDate.now().getMonthValue(), 0);
		int maxDay =calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		for (int i = 1; i <=maxDay; i++) {
			dcd.addValue(thongkeFacade.BieuDoXeNhap(i, LocalDate.now().getMonthValue(), LocalDate.now().getYear()), "Số lượng Nhập", String.valueOf(i));
			dcd.addValue(thongkeFacade.BieuDoXeBan(i,  LocalDate.now().getMonthValue(),LocalDate.now().getYear()), "Số lượng Bán", String.valueOf(i));
		}
		

		JFreeChart jchart= ChartFactory.createBarChart(null, null, "Số lượng", dcd, PlotOrientation.VERTICAL, true, true, false);
		CategoryPlot plot= jchart.getCategoryPlot();
		jchart.setBackgroundPaint(Color.white);
		BarRenderer renderer = (BarRenderer) plot.getRenderer();
		Color color = new Color(0, 192, 0);
		renderer.setSeriesPaint(0, color);
		plot.setRangeGridlinePaint(Color.black);
		panel_5.setLayout(new CardLayout(0, 0));
		
		pnChartXeMuaBan = new JPanel();
		pnChartXeMuaBan.setBorder(new MatteBorder(1, 1, 1, 1, (Color) SystemColor.controlShadow));
		pnChartXeMuaBan.setBackground(Color.WHITE);
		pnChartXeMuaBan.setLayout(null);
		ChartPanel chartPanel= new ChartPanel(jchart);
		chartPanel.setBounds(10, 125, 933, 295);
		chartPanel.setBackground(Color.white);
		chartPanel.setLayout(null);
		pnChartXeMuaBan.add(chartPanel);
		panel_5.add(pnChartXeMuaBan, "name_6412416537300");
		//Hàm đọc số lượng
		int ngay=LocalDate.now().getDayOfMonth();
		int thang1=LocalDate.now().getMonthValue();
		int nam1=LocalDate.now().getYear();
		lbTKXB.setText("Tổng Số Lượng Xe Bán Trong Ngày "+ngay+"-"+thang1+"-"+nam1);
		lbTKXM.setText("Tổng Số Lượng Xe Mới Trong Ngày "+ngay+"-"+thang1+"-"+nam1);
		lbSTDB.setText("Tổng Doanh Thu Trong Ngày "+ngay+"-"+thang1+"-"+nam1);
		lbSLKH.setText("Số Khách Hàng Mới Trong Ngày "+ngay+"-"+thang1+"-"+nam1);
		int t=LocalDate.now().getMonthValue();
		int n=LocalDate.now().getYear();
		int d=LocalDate.now().getDayOfMonth();
		lbSLXeMoi.setText(String.valueOf(thongkeFacade.BieuDoXeBan(d, t, n)));
		
		lbSLXeBan.setText(String.valueOf(thongkeFacade.BieuDoXeBan(d, t, n)));
		
		lbSLKhachHang.setText(String.valueOf(thongkeFacade.BieuDoKhachHangTheoNgay(d, t, n)));
		DecimalFormat df = new DecimalFormat("###,###,###,### VNĐ");
		lbSLTienBan.setText(df.format(thongkeFacade.TongTienTheoNgay(d, t, n)));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(962, 46, 527, 374);
		pnChartXeMuaBan.add(scrollPane);
		
		String header[]= {"Tên Xe","Số Lượng","Tổng tiền thu được"};
		tableModel= new DefaultTableModel(header,0);
		table = new JTable(tableModel);
		table.setEnabled(false);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 15));
		try {
			loadThongKeNgay(LocalDate.now().getDayOfMonth(), LocalDate.now().getMonthValue(), LocalDate.now().getYear());
		} catch (SQLException e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}
		table.setModel(tableModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
	    table.getColumnModel().getColumn(1).setPreferredWidth(5);
	    table.setRowHeight(30);
	    table.setShowGrid(false);
	    table.getColumnModel().getColumn(1).setPreferredWidth(5);
		scrollPane.setViewportView(table);
		Border border = new LineBorder(Color.white);
		scrollPane.setBorder(new LineBorder(Color.WHITE));
		table.getTableHeader().setBorder(border);
		DefaultTableCellRenderer renderer1 = (DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer();
		renderer1.setHorizontalAlignment(SwingConstants.LEFT);
		table.getTableHeader().setBackground(Color.white);
		table.setBackground(Color.WHITE);
		
		JLabel lbTongXe = new JLabel("Tổng số xe còn lại trong kho");
		lbTongXe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbTongXe.setBounds(10, 10, 239, 31);
		pnChartXeMuaBan.add(lbTongXe);
		
		JLabel lbTinhTong = new JLabel("New label");
		lbTinhTong.setForeground(new Color(220, 20, 60));
		lbTinhTong.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbTinhTong.setBounds(224, 2, 137, 44);
		lbTinhTong.setText(xeFacade.XeConLai()+" xe");
		pnChartXeMuaBan.add(lbTinhTong);
		
		JLabel lblTngSXe = new JLabel("Tổng số xe đã từng bán");
		lblTngSXe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTngSXe.setBounds(10, 51, 239, 31);
		pnChartXeMuaBan.add(lblTngSXe);
		
		JLabel lbTinhXeBan = new JLabel("0 xe");
		lbTinhXeBan.setForeground(new Color(34, 139, 34));
		lbTinhXeBan.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbTinhXeBan.setBounds(224, 43, 137, 44);
		lbTinhXeBan.setText(xeFacade.XeDaBan()+" xe");
		pnChartXeMuaBan.add(lbTinhXeBan);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(SystemColor.control);
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_6.setBounds(953, 0, 1, 463);
		pnChartXeMuaBan.add(panel_6);
		
		JLabel lbXeBanNhieu = new JLabel("Xe đã bán nhiều nhất");
		lbXeBanNhieu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbXeBanNhieu.setBounds(426, 11, 148, 31);
		pnChartXeMuaBan.add(lbXeBanNhieu);
		
		JLabel lbNhieu = new JLabel("0 xe");
		lbNhieu.setForeground(new Color(0, 0, 153));
		lbNhieu.setText(thongkeFacade.XeNhieuNhat().getTenXe());
		lbNhieu.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbNhieu.setBounds(597, 3, 294, 44);
		pnChartXeMuaBan.add(lbNhieu);
		
		JLabel lblXeBn = new JLabel("Xe chưa từng được bán");
		lblXeBn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblXeBn.setBounds(426, 51, 161, 31);
		pnChartXeMuaBan.add(lblXeBn);
		
		JLabel lbIt = new JLabel("0 xe");
		lbIt.setForeground(new Color(255, 153, 0));
		lbIt.setText(thongkeFacade.XeItNhat() +" xe");
		lbIt.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbIt.setBounds(597, 43, 111, 44);
		pnChartXeMuaBan.add(lbIt);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(0, 102, 51));
		panel_8.setBounds(928, 10, 26, 49);
		pnChartXeMuaBan.add(panel_8);
		
		JPanel panel_8_1 = new JPanel();
		panel_8_1.setBackground(new Color(204, 0, 0));
		panel_8_1.setBounds(954, 0, 54, 41);
		pnChartXeMuaBan.add(panel_8_1);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(160, 160, 160)));
		panel_9.setBackground(Color.WHITE);
		panel_9.setBounds(981, 4, 510, 37);
		pnChartXeMuaBan.add(panel_9);
		panel_9.setLayout(null);
		
		lbXeTrongThang = new JLabel("Những xe đã được bán trong tháng");
		lbXeTrongThang.setText("Những xe đã được bán trong ngày "+LocalDate.now().getDayOfMonth()+" - "+LocalDate.now().getMonthValue()+" - "+LocalDate.now().getYear());
		lbXeTrongThang.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbXeTrongThang.setBounds(42, 0, 461, 33);
		panel_9.add(lbXeTrongThang);
		
		lblBieuDoXe = new JLabel("Biểu đồ xe bán trong");
		lblBieuDoXe.setText("Biểu đồ xe bán các ngày trong tháng " +LocalDate.now().getMonthValue()+" - "+LocalDate.now().getYear());
		lblBieuDoXe.setHorizontalAlignment(SwingConstants.CENTER);
		lblBieuDoXe.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblBieuDoXe.setBounds(10, 92, 933, 33);
		pnChartXeMuaBan.add(lblBieuDoXe);
		scrollPane.getViewport().setBackground(Color.WHITE);
		contentPane.add(panel_5);
		//Chart Khách hàng
		dcdKH= new DefaultCategoryDataset();
		for (int i = 1; i <=maxDay; i++) {
			dcdKH.addValue(thongkeFacade.BieuDoKhachHangTheoNgay(i, LocalDate.now().getYear(), LocalDate.now().getMonthValue()), "Số lượng Khách Hàng Mới", String.valueOf(i));
		}

		JFreeChart jchartKH= ChartFactory.createBarChart(null, null, "Số lượng", dcdKH, PlotOrientation.VERTICAL, true, true, false);
		CategoryPlot plotKH= jchartKH.getCategoryPlot();
		jchartKH.setBackgroundPaint(Color.white);
		BarRenderer rendererKH = (BarRenderer) plotKH.getRenderer();
		rendererKH.setSeriesPaint(0, color);
		plotKH.setRangeGridlinePaint(Color.black);
		
		pnChartKKhachHang = new JPanel();
		pnChartKKhachHang.setBorder(new LineBorder(SystemColor.controlShadow));
		pnChartKKhachHang.setBackground(Color.WHITE);
		pnChartKKhachHang.setLayout(null);
		ChartPanel chartPanelKH= new ChartPanel(jchartKH);
		chartPanelKH.setBounds(10, 153, 933, 266);
		chartPanelKH.setBackground(Color.white);
		chartPanelKH.setLayout(null);
		//Table
		JScrollPane scrollPaneKH = new JScrollPane();
		scrollPaneKH.setBounds(977, 48, 504, 371);
		pnChartKKhachHang.add(scrollPaneKH);
		
		
		String headerKH[]= {"Tên Khách Hàng","Giới tính","Số điện thoại"};
		tableModelKH= new DefaultTableModel(headerKH,0);
		tableKH = new JTable(tableModelKH);
		tableKH.setEnabled(false);
		tableKH.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tableKH.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		tableKH.setModel(tableModelKH);
		try {
			loadKHNgay(ngay, t, n);
		} catch (SQLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		tableKH.getColumnModel().getColumn(0).setPreferredWidth(100);
	    tableKH.getColumnModel().getColumn(1).setPreferredWidth(5);
	    tableKH.setRowHeight(30);
	    tableKH.setShowGrid(false);
	    tableKH.getColumnModel().getColumn(1).setPreferredWidth(5);
		scrollPaneKH.setViewportView(tableKH);
		scrollPaneKH.setBorder(border);
		tableKH.getTableHeader().setBorder(border);
		DefaultTableCellRenderer rendererKH1 = (DefaultTableCellRenderer) tableKH.getTableHeader().getDefaultRenderer();
		rendererKH1.setHorizontalAlignment(SwingConstants.LEFT);
		tableKH.getTableHeader().setBackground(Color.white);
		tableKH.setBackground(Color.WHITE);
		scrollPaneKH.getViewport().setBackground(Color.WHITE);
		pnChartKKhachHang.add(chartPanelKH);
		panel_5.add(pnChartKKhachHang, "name_3671978065000");
		
		JLabel lblTngKhchHng = new JLabel("Tổng Số Khách Hàng");
		lblTngKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTngKhchHng.setBounds(10, 10, 145, 25);
		pnChartKKhachHang.add(lblTngKhchHng);
		
		JLabel txtTongkh = new JLabel("0");
		txtTongkh.setForeground(new Color(0, 0, 205));
		txtTongkh.setText(khachHangFacade.TongKhachHang()+"");
		txtTongkh.setFont(new Font("Tahoma", Font.BOLD, 17));
		txtTongkh.setBounds(196, 8, 118, 27);
		pnChartKKhachHang.add(txtTongkh);
		
		JLabel lblTngKhchHng_1 = new JLabel("Tổng Số Khách Hàng Nam");
		lblTngKhchHng_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTngKhchHng_1.setBounds(398, 12, 179, 25);
		pnChartKKhachHang.add(lblTngKhchHng_1);
		
		JLabel txtTongkhnam = new JLabel("0");
		txtTongkhnam.setForeground(new Color(220, 20, 60));
		txtTongkhnam.setText(khachHangFacade.TongKhachNam()+"");
		txtTongkhnam.setFont(new Font("Tahoma", Font.BOLD, 17));
		txtTongkhnam.setBounds(584, 10, 118, 25);
		pnChartKKhachHang.add(txtTongkhnam);
		
		JLabel lblTngKhchHng_2 = new JLabel("Tổng Số Khách Hàng Nữ");
		lblTngKhchHng_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTngKhchHng_2.setBounds(398, 47, 167, 25);
		pnChartKKhachHang.add(lblTngKhchHng_2);
		
		JLabel txttongkhnu = new JLabel("0");
		txttongkhnu.setForeground(new Color(0, 128, 0));
		txttongkhnu.setText(khachHangFacade.TongKhachNu()+"");
		txttongkhnu.setFont(new Font("Tahoma", Font.BOLD, 17));
		txttongkhnu.setBounds(584, 46, 118, 29);
		pnChartKKhachHang.add(txttongkhnu);
		
		JLabel lblTngKhchHng_2_1 = new JLabel("Tuổi trung bình");
		lblTngKhchHng_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTngKhchHng_2_1.setBounds(10, 46, 167, 25);
		pnChartKKhachHang.add(lblTngKhchHng_2_1);
		
		txtTuoi = new JLabel("0");
		txtTuoi.setForeground(new Color(255, 102, 0));
		
		txtTuoi.setFont(new Font("Tahoma", Font.BOLD, 17));
		txtTuoi.setBounds(196, 45, 118, 29);
		txtTuoi.setText(thongkeFacade.TuoiTrungBinh()+" tuổi");
		pnChartKKhachHang.add(txtTuoi);
		
		JPanel panel_6_1 = new JPanel();
		panel_6_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_6_1.setBackground(SystemColor.menu);
		panel_6_1.setBounds(967, 0, 1, 463);
		pnChartKKhachHang.add(panel_6_1);
		
		JPanel panel_9_1 = new JPanel();
		panel_9_1.setLayout(null);
		panel_9_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(160, 160, 160)));
		panel_9_1.setBackground(Color.WHITE);
		panel_9_1.setBounds(994, 1, 510, 37);
		pnChartKKhachHang.add(panel_9_1);
		
		JLabel lbKHMoi = new JLabel("Những khách hàng mới trong");
		lbKHMoi.setText("Những khách hàng mới trong ngày " +LocalDate.now().getDayOfMonth()+" - "+LocalDate.now().getMonthValue()+" - "+LocalDate.now().getYear());
		lbKHMoi.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbKHMoi.setBounds(10, 0, 493, 33);
		panel_9_1.add(lbKHMoi);
		
		JPanel panel_8_1_1 = new JPanel();
		panel_8_1_1.setBackground(new Color(204, 0, 0));
		panel_8_1_1.setBounds(967, -3, 26, 41);
		pnChartKKhachHang.add(panel_8_1_1);
		
		JPanel panel_8_2 = new JPanel();
		panel_8_2.setBackground(new Color(0, 102, 51));
		panel_8_2.setBounds(941, 35, 26, 37);
		pnChartKKhachHang.add(panel_8_2);
		
		JLabel lblTngKhchHng_2_1_1 = new JLabel("Tỉ lệ độ tuổi mua xe :");
		lblTngKhchHng_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTngKhchHng_2_1_1.setBounds(10, 79, 145, 25);
		pnChartKKhachHang.add(lblTngKhchHng_2_1_1);
		
		JLabel lblTngKhchHng_2_1_2 = new JLabel("18 - 30 Tuổi ");
		lblTngKhchHng_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTngKhchHng_2_1_2.setBounds(154, 80, 98, 25);
		pnChartKKhachHang.add(lblTngKhchHng_2_1_2);
		
		JLabel txt1830 = new JLabel("0 tuổi");
		txt1830.setForeground(new Color(128, 0, 128));
		if(khachHangFacade.TongKhachHang()==0) {
			txt1830.setText("0 %");
		}else
			txt1830.setText(Math.round(thongkeFacade.SoLuongTuoi(18, 30)*100/khachHangFacade.TongKhachHang())+" %");
		txt1830.setFont(new Font("Tahoma", Font.BOLD, 17));
		txt1830.setBounds(255, 77, 118, 29);
		pnChartKKhachHang.add(txt1830);
		
		JLabel lb3060 = new JLabel("31 - 60 Tuổi ");
		lb3060.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb3060.setBounds(398, 79, 98, 25);
		pnChartKKhachHang.add(lb3060);
		
		JLabel txt3060 = new JLabel("0 tuổi");
		txt3060.setForeground(new Color(128, 128, 0));
		if(khachHangFacade.TongKhachHang()==0) {
			txt3060.setText("0 %");
		}else
			txt3060.setText(Math.round(thongkeFacade.SoLuongTuoi(30, 60)*100/khachHangFacade.TongKhachHang())+" %");
		txt3060.setFont(new Font("Tahoma", Font.BOLD, 17));
		txt3060.setBounds(506, 76, 118, 29);
		pnChartKKhachHang.add(txt3060);
		
		JLabel lb60tr = new JLabel("Trên 60 Tuổi ");
		lb60tr.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb60tr.setBounds(662, 79, 98, 25);
		pnChartKKhachHang.add(lb60tr);
		
		JLabel txtTren60 = new JLabel("0 tuổi");
		txtTren60.setForeground(new Color(255, 0, 255));
		
		txtTren60.setFont(new Font("Tahoma", Font.BOLD, 17));
		txtTren60.setBounds(787, 76, 118, 29);
		if(khachHangFacade.TongKhachHang()==0) {
			txtTren60.setText("0 %");
		}else
			txtTren60.setText(Math.round((thongkeFacade.SoLuongTuoi(60, 200)*100/khachHangFacade.TongKhachHang()*100.00)/100.00)+" %");
		pnChartKKhachHang.add(txtTren60);
		
		JLabel lbBieudoKH = new JLabel("Biểu đồ thống kê số lượng khách hàng mới trong tháng "+LocalDate.now().getMonthValue()+" - "+LocalDate.now().getYear());
		lbBieudoKH.setHorizontalAlignment(SwingConstants.CENTER);
		lbBieudoKH.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbBieudoKH.setBounds(10, 122, 933, 33);
		pnChartKKhachHang.add(lbBieudoKH);
		
		//Chart Doanh thu
		dcdDT= new DefaultCategoryDataset();
		for (int i = 1; i <=maxDay; i++) {
			dcdDT.addValue(thongkeFacade.BieuDoKhachHangTheoNgay(i, LocalDate.now().getYear(), LocalDate.now().getMonthValue()), "Tổng số doanh thu", String.valueOf(i));
		}

		JFreeChart jchartDT= ChartFactory.createBarChart("Thống kê doanh thu ", null, "Doanh thu", dcdDT, PlotOrientation.VERTICAL, true, true, false);
		CategoryPlot plotDT= jchartDT.getCategoryPlot();
		jchartDT.setBackgroundPaint(Color.white);
		BarRenderer rendererDT = (BarRenderer) plotDT.getRenderer();
		rendererDT.setSeriesPaint(0, color);
		plotDT.setRangeGridlinePaint(Color.black);
		
		pnNhanVien = new JPanel();
		pnNhanVien.setBackground(Color.WHITE);
		panel_5.add(pnNhanVien, "name_8997609095800");
		pnNhanVien.setLayout(null);
		
		JScrollPane scrollPaneNV = new JScrollPane();
		
		scrollPaneNV.setBounds(0, 0, 1492, 193);
		pnNhanVien.add(scrollPaneNV);
		
		String headerNV[]= {"Tên công ty","Mã nhân viên","Tên nhân viên","Giới tính","Số lượng", "Doanh thu"};
		tableModelNV= new DefaultTableModel(headerNV,0);
		tbNhanVien = new JTable(tableModelNV);
		tbNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tbNhanVien.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 14));
		tbNhanVien.setRowHeight(30);
		tableModelNV = thongkeFacade.getAllNV(ngay,t,n);
		tbNhanVien.setModel(tableModelNV);	
		scrollPaneNV.setViewportView(tbNhanVien);
		
		String headerCTNV[]= {"Tên Xe","Số Lượng","Phiên Bản","Phân Khối", "Doanh thu"};
		tableModelCTNV= new DefaultTableModel(headerCTNV,0);
		tbCTNV = new JTable(tableModelCTNV);
		tbCTNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tbCTNV.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 14));
		JScrollPane scrollPaneCTNV = new JScrollPane();
		tbCTNV.setRowHeight(30);
		tbCTNV.setModel(tableModelCTNV);
		tbNhanVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int ngay1= (int) cbNgay.getSelectedItem();
				int t1=(int) cbThang.getSelectedItem();
				int n1=(int) cbNam.getSelectedItem();
				int i=tbNhanVien.getSelectedRow();
				String ma= tableModelNV.getValueAt(i, 1).toString();
				String ten= tableModelNV.getValueAt(i, 2).toString();
				lbChiTiet.setText("Chi tiết thông tin xe đã bán của nhân viên "+ ten );
				if(rdNam.isSelected()) {
					try {
						loadCTNhanVienTheoNam(n1, ma);
					} catch (SQLException e1) {
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
				if(rdNgay.isSelected()) {
					try {
						loadCTNhanVienTheoNgay(ngay1,t1,n1,ma);
					} catch (SQLException e1) {
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
				if(rdThang.isSelected()) {
					try {
						loadCTNhanVienTheoThang(t1,n1,ma);
					} catch (SQLException e1) {
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
			}
		});
		scrollPaneCTNV.setBounds(0, 234, 1492, 185);
		pnNhanVien.add(scrollPaneCTNV);
		scrollPaneCTNV.setViewportView(tbCTNV);
		
		lbChiTiet = new JLabel("Chi tiết thông tin xe đã bán của nhân viên");
		lbChiTiet.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbChiTiet.setBounds(0, 203, 519, 21);
		pnNhanVien.add(lbChiTiet);
		
		JLabel lbLoc = new JLabel("Lọc ");
		lbLoc.setBounds(25, 274, 42, 24);
		contentPane.add(lbLoc);
		lbLoc.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lbThang = new JLabel("Tháng");
		lbThang.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbThang.setBounds(257, 274, 45, 24);
		contentPane.add(lbThang);
		cbThang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbThang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					cbNgay.removeAllItems();
					int thang=(int) cbThang.getSelectedItem();
					int nam=(int) cbNam.getSelectedItem();
					Calendar calendarNgay = Calendar.getInstance();
					calendarNgay.set(nam, thang, 0);
					int ngayLonNhat =calendarNgay.getActualMaximum(Calendar.DAY_OF_MONTH);
					for (int i = 1; i <= ngayLonNhat; i++) {
						cbNgay.addItem(i);
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
		});
		
		cbThang.setBounds(312, 277, 85, 25);
		contentPane.add(cbThang);
		cbThang.setBackground(Color.WHITE);
		cbThang.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		cbThang.setSelectedItem(LocalDate.now().getMonthValue());
		
		JLabel lbNam = new JLabel("Năm");
		lbNam.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbNam.setBounds(412, 274, 45, 24);
		contentPane.add(lbNam);
		cbNam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		cbNam.setBounds(458, 277, 85, 25);
		contentPane.add(cbNam);
		cbNam.setBackground(Color.WHITE);
		cbNam.setSelectedItem(LocalDate.now().getYear());
		
		for (int i = 1; i <= 12; i++) {
			cbThang.addItem(i);
		}
		for (int i = 2019; i <= LocalDate.now().getYear(); i++) {
			cbNam.addItem(i);
		}
		cbThang.setSelectedItem(LocalDate.now().getMonthValue());
		cbNam.setSelectedItem(LocalDate.now().getYear());
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(SystemColor.control);
		panel_7.setBounds(610, 274, 359, 28);
		contentPane.add(panel_7);
		panel_7.setBorder(null);
		panel_7.setLayout(new GridLayout(1, 0, 0, 0));
		
		rdNgay = new JRadioButton("Theo Ngày");
		rdNgay.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdNgay.setSelected(true);
		rdNgay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(rdNgay.isSelected()) {
					rdThang.setSelected(false);
					rdNam.setSelected(false);
				}
			}
		});
		panel_7.add(rdNgay);
		rdNgay.setBackground(SystemColor.control);
		
		rdThang = new JRadioButton("Theo Tháng");
		rdThang.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdThang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(rdThang.isSelected()) {
					rdNgay.setSelected(false);
					rdNam.setSelected(false);
				}
			}
		});
		panel_7.add(rdThang);
		rdThang.setBackground(SystemColor.control);
		
		rdNam = new JRadioButton("Theo Năm");
		rdNam.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdNam.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(rdNam.isSelected()) {
					rdNgay.setSelected(false);
					rdThang.setSelected(false);
				}
			}
		});
		panel_7.add(rdNam);
		rdNam.setBackground(SystemColor.control);
		//Bộ lọc quyền năng
		JButton txtLoc = new JButton("Lọc");
		txtLoc.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtLoc.setBounds(991, 274, 85, 28);
		contentPane.add(txtLoc);
		
		JLabel lblNgy = new JLabel("Ngày");
		lblNgy.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNgy.setBounds(95, 274, 45, 24);
		contentPane.add(lblNgy);
		
		cbNgay = new JComboBox<Object>();
		cbNgay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbNgay.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		cbNgay.setBackground(Color.WHITE);
		cbNgay.setBounds(150, 277, 85, 25);
		int thang=(int) cbThang.getSelectedItem();
		int nam=(int) cbNam.getSelectedItem();
		Calendar calendarNgay = Calendar.getInstance();
		calendarNgay.set(nam, thang, 0);
		int ngayLonNhat =calendarNgay.getActualMaximum(Calendar.DAY_OF_MONTH);
		for (int i = 1; i <= ngayLonNhat; i++) {
			cbNgay.addItem(i);
		}
		cbNgay.setSelectedItem(LocalDate.now().getDayOfMonth());;
		contentPane.add(cbNgay);
		txtLoc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					 
					int rows = tableModelCTNV.getRowCount(); 
					for(int i = rows - 1; i >=0; i--)
					{
					   tableModelCTNV.removeRow(i); 
					}
					int ngay1= (int) cbNgay.getSelectedItem();
					int t1=(int) cbThang.getSelectedItem();
					int n1=(int) cbNam.getSelectedItem();
					System.out.println(n1);
					DecimalFormat df = new DecimalFormat("###,###,###,### VNĐ");
					if (rdThang.isSelected()) {
						loadThongKeThang();
						lbSLXeMoi.setText(String.valueOf(thongkeFacade.BieuDoXeNhap(t1, n1)));
						lbSLXeBan.setText(String.valueOf(thongkeFacade.BieuDoXeBan(t1, n1)));
						lbSLKhachHang.setText(String.valueOf(thongkeFacade.SoLuongKhachHangTrongThang(t1, n1)));
						lbSLTienBan.setText(df.format(thongkeFacade.TongTienTheoThang(t1, n1)));
						lbTKXB.setText("Tổng Số Lượng Xe Bán Trong Tháng "+t1+"-"+n1);
						lbTKXM.setText("Tổng Số Lượng Xe Mới Trong Tháng "+t1+"-"+n1);
						lbSTDB.setText("Tổng Doanh Thu Trong Tháng "+t1+"-"+n1);
						lbSLKH.setText("Số Khách Hàng Mới Trong Tháng "+t1+"-"+n1);
						lblBieuDoXe.setText("Biểu đồ xe nhập, bán trong các tháng năm "+n1);
						lbXeTrongThang.setText("Những xe đã được bán trong tháng "+t1+" - "+n1);
						lbBieudoKH.setText("Biểu đồ thống kê số lượng khách hàng mới trong các tháng năm "+n1);
						lbKHMoi.setText("Những khách hàng mới trong tháng " +t1+" - "+n1);
						loadKHThang(t1, n1);
						//Biểu đồ
						int t2=(int) cbThang.getSelectedItem();
						int n2=(int) cbNam.getSelectedItem();
						Calendar calendar = Calendar.getInstance();
						calendar.set(n2, t2, 0);
						loadNhanVienTheoThang(t1, n1);
						int maxDay =calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
						//Biểu đồ xe Nhập - Bán
						for (int i = 1; i <=31; i++) {
							dcd.addValue(thongkeFacade.BieuDoXeNhap(i, t2,n2), "Số lượng Nhập", String.valueOf(i));
							dcd.addValue(thongkeFacade.BieuDoXeBan(i, t2,n2), "Số lượng Bán", String.valueOf(i));
						}
						for (int i = 1; i <=31; i++) {
							dcd.removeValue("Số lượng Nhập", String.valueOf(i));
							dcd.removeValue("Số lượng Bán", String.valueOf(i));
							dcd.removeColumn("Số lượng Nhập");
							dcd.removeColumn("Số lượng Bán");
						}
						for (int i = 2019; i <= LocalDate.now().getYear(); i++) {
							dcd.addValue(thongkeFacade.SoLuongXeBanTrongNam(i), "Số lượng Nhập", String.valueOf(i));
							dcd.addValue(thongkeFacade.SoLuongXeNhapTrongNam(i), "Số lượng Bán", String.valueOf(i));
						}
						for (int i = 2019; i <=LocalDate.now().getYear(); i++) {
							dcd.removeValue("Số lượng Nhập", String.valueOf(i));
							dcd.removeValue("Số lượng Bán", String.valueOf(i));
							dcd.removeColumn("Số lượng Nhập");
							dcd.removeColumn("Số lượng Bán");
						}
						for (int i = 1; i <=maxDay; i++) {
							dcd.addValue(thongkeFacade.BieuDoXeNhap(i, t2,n2), "Số lượng Nhập", String.valueOf(i));
							dcd.addValue(thongkeFacade.BieuDoXeBan(i, t2,n2), "Số lượng Bán", String.valueOf(i));
						}
						for (int i = 1; i <=maxDay; i++) {
							dcd.removeValue("Số lượng Nhập", String.valueOf(i));
							dcd.removeValue("Số lượng Bán", String.valueOf(i));
							dcd.removeColumn("Số lượng Nhập");
							dcd.removeColumn("Số lượng Bán");
						}
						for (int i = 1; i <= 12; i++) {
							dcd.addValue(thongkeFacade.BieuDoXeNhap(i, n2), "Số lượng Nhập", "Tháng "+i);
							dcd.addValue(thongkeFacade.BieuDoXeBan(i, n2), "Số lượng Bán", "Tháng "+i);
						}
						//Biểu đồ khách hàng mới
						for (int i = 1; i <=31; i++) {
							dcdKH.addValue(thongkeFacade.BieuDoKhachHangTheoNgay(i, t2,n2), "Số lượng Khách Hàng Mới", String.valueOf(i));
						}
						for (int i = 1; i <=31; i++) {
							dcdKH.removeValue("Số lượng Khách Hàng Mới", String.valueOf(i));
							dcdKH.removeColumn("Số lượng Khách Hàng Mới");
						}
						for (int i = 2019; i <= LocalDate.now().getYear(); i++) {
							dcdKH.addValue(thongkeFacade.SoLuongKhachHangTrongNam(i), "Số lượng Khách Hàng Mới", String.valueOf(i));
						}
						for (int i = 2019; i <=LocalDate.now().getYear(); i++) {
							dcdKH.removeValue("Số lượng Khách Hàng Mới", String.valueOf(i));
							dcdKH.removeColumn("Số lượng Khách Hàng Mới");
						}
						for (int i = 1; i <=maxDay; i++) {
							dcdKH.addValue(thongkeFacade.BieuDoKhachHangTheoNgay(i, t2,n2), "Số lượng Khách Hàng Mới", String.valueOf(i));
						}
						for (int i = 1; i <=maxDay; i++) {
							dcdKH.removeValue("Số lượng Khách Hàng Mới", String.valueOf(i));
							dcdKH.removeColumn("Số lượng Khách Hàng Mới");
						}
						for (int i = 1; i <= 12; i++) {
							dcdKH.addValue(thongkeFacade.SoLuongKhachHangTrongThang(i, n2), "Số lượng Khách Hàng Mới", "Tháng "+i);
						}
					}
					if(rdNam.isSelected()) {
						lbSLXeMoi.setText(String.valueOf(thongkeFacade.SoLuongXeNhapTrongNam(n1)));
						lbSLXeBan.setText(String.valueOf(thongkeFacade.SoLuongXeBanTrongNam(n1)));
						lbSLKhachHang.setText(String.valueOf(thongkeFacade.SoLuongKhachHangTrongNam(n1)));				
						lbSLTienBan.setText(df.format(thongkeFacade.TongTienTheoNam(n1)));
						lbTKXB.setText("Tổng Số Lượng Xe Bán Trong Năm "+n1);
						lbTKXM.setText("Tổng Số Lượng Xe Mới Trong Năm "+n1);
						lbSTDB.setText("Tổng Doanh Thu Trong Năm "+n1);
						lbSLKH.setText("Số Khách Hàng Mới Trong Năm "+n1);
						lblBieuDoXe.setText("Biểu đồ xe nhập, bán trong giai đoạn năm 2019 - "+ LocalDate.now().getYear());
						lbXeTrongThang.setText("Những xe đã được bán trong năm "+n1);
						lbBieudoKH.setText("Biểu đồ thống kê số lượng khách hàng mới trong giai đoạn năm 2019 - "+LocalDate.now().getYear());
						lbKHMoi.setText("Những khách hàng mới trong năm "+n1);
						loadThongKeNam();
						loadNhanVienTheoNam(n1);
						loadKHNam(n1);
						//Biểu đồ xe Nhập - Bán
						for (int i = 1; i <= 12; i++) {
							dcd.addValue(thongkeFacade.BieuDoXeNhap(i, LocalDate.now().getYear()), "Số lượng Nhập", "Tháng "+i);
							dcd.addValue(thongkeFacade.BieuDoXeBan(i, LocalDate.now().getYear()), "Số lượng Bán", "Tháng "+i);
						}
						for (int i = 1; i <=12; i++) {
							dcd.removeValue("Số lượng Nhập", "Tháng "+i);
							dcd.removeValue("Số lượng Bán", "Tháng "+i);
							dcd.removeColumn("Số lượng Nhập");
							dcd.removeColumn("Số lượng Bán");
						}
						int t2=(int) cbThang.getSelectedItem();
						int n2=(int) cbNam.getSelectedItem();
						Calendar calendar = Calendar.getInstance();
						calendar.set(n2, t2, 0);
						int maxDay =calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
						for (int i = 1; i <=31; i++) {
							dcd.addValue(thongkeFacade.BieuDoXeNhap(i, t2,n2), "Số lượng Nhập", String.valueOf(i));
							dcd.addValue(thongkeFacade.BieuDoXeBan(i, t2,n2), "Số lượng Bán", String.valueOf(i));
						}
						for (int i = 1; i <=31; i++) {
							dcd.removeValue("Số lượng Nhập", String.valueOf(i));
							dcd.removeValue("Số lượng Bán", String.valueOf(i));
							dcd.removeColumn("Số lượng Nhập");
							dcd.removeColumn("Số lượng Bán");
						}
						for (int i = 1; i <=maxDay; i++) {
							dcd.addValue(thongkeFacade.BieuDoXeNhap(i, t2,n2), "Số lượng Nhập", String.valueOf(i));
							dcd.addValue(thongkeFacade.BieuDoXeBan(i, t2,n2), "Số lượng Bán", String.valueOf(i));
	
						}
						for (int i = 1; i <=maxDay; i++) {
							dcd.removeValue("Số lượng Nhập", String.valueOf(i));
							dcd.removeValue("Số lượng Bán",  String.valueOf(i));
							dcd.removeColumn("Số lượng Nhập");
							dcd.removeColumn("Số lượng Bán");
						}
						for (int i = 2019; i <= LocalDate.now().getYear(); i++) {
							dcd.addValue(thongkeFacade.SoLuongXeNhapTrongNam(i), "Số lượng Nhập", String.valueOf(i));
							dcd.addValue(thongkeFacade.SoLuongXeBanTrongNam(i), "Số lượng Bán", String.valueOf(i));
						}
						//Biểu đồ khách hàng mới
						for (int i = 1; i <=31; i++) {
							dcdKH.addValue(thongkeFacade.BieuDoKhachHangTheoNgay(i, t2,n2), "Số lượng Khách Hàng Mới", String.valueOf(i));
						}
						for (int i = 1; i <=31; i++) {
							dcdKH.removeValue("Số lượng Khách Hàng Mới", String.valueOf(i));
							dcdKH.removeColumn("Số lượng Khách Hàng Mới");
						}
						for (int i = 1; i <=maxDay; i++) {
							dcdKH.addValue(thongkeFacade.BieuDoKhachHangTheoNgay(i, t2,n2), "Số lượng Khách Hàng Mới", String.valueOf(i));
						}
						for (int i = 1; i <=maxDay; i++) {
							dcdKH.removeValue("Số lượng Khách Hàng Mới", String.valueOf(i));
							dcdKH.removeColumn("Số lượng Khách Hàng Mới");
						}
						for (int i = 1; i <= 12; i++) {
							dcdKH.addValue(thongkeFacade.SoLuongKhachHangTrongThang(i, n2), "Số lượng Khách Hàng Mới", "Tháng "+i);
						}
						for (int i = 1; i <=12; i++) {
							dcdKH.removeValue("Số lượng Khách Hàng Mới", "Tháng "+i);
							dcdKH.removeColumn("Số lượng Khách Hàng Mới");
						}
						for (int i = 2019; i <= LocalDate.now().getYear(); i++) {
							dcdKH.addValue(thongkeFacade.SoLuongKhachHangTrongNam(i), "Số lượng Khách Hàng Mới", String.valueOf(i));
						}
					}
					
					if(rdNgay.isSelected()) {
						int ngay= (int) cbNgay.getSelectedItem();
						loadThongKeNgay(ngay, t1, n1);
						loadKHNgay(ngay1, t1, n1);
						lblBieuDoXe.setText("Biểu đồ xe nhập, bán các ngày trong tháng " +t1+" - "+n1);
						lbXeTrongThang.setText("Những xe đã được bán trong ngày "+ngay1+" - "+t1+" - "+n1);
						lbBieudoKH.setText("Biểu đồ thống kê số lượng khách hàng mới trong tháng " +t1+" - "+n1);
						lbKHMoi.setText("Những khách hàng mới trong ngày " +ngay1+" - "+t1+" - "+n1);
						lbSLXeMoi.setText(String.valueOf(thongkeFacade.BieuDoXeNhap(ngay,t1, n1)));
						lbSLXeBan.setText(String.valueOf(thongkeFacade.BieuDoXeBan(ngay,t1, n1)));
						lbSLKhachHang.setText(String.valueOf(thongkeFacade.BieuDoKhachHangTheoNgay(ngay,t1, n1)));
						lbSLTienBan.setText(df.format(thongkeFacade.TongTienTheoNgay(ngay,t1, n1)));
						lbTKXB.setText("Tổng Số Lượng Xe Bán Trong Ngày "+ngay+"-"+t1+"-"+n1);
						lbTKXM.setText("Tổng Số Lượng Xe Mới Trong Ngày "+ngay+"-"+t1+"-"+n1);
						lbSTDB.setText("Tổng Doanh Thu Trong Ngày "+ngay+"-"+t1+"-"+n1);
						lbSLKH.setText("Số Khách Hàng Mới Trong Ngày "+ngay+"-"+t1+"-"+n1);
						
						int t2=(int) cbThang.getSelectedItem();
						int n2=(int) cbNam.getSelectedItem();
						loadNhanVienTheoNgay(ngay1, t1, n1);
						Calendar calendar = Calendar.getInstance();
						calendar.set(n2, t2, 0);
						int maxDay =calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
						
						//Biểu đồ xe Nhập - Bán
						for (int i = 1; i <=31; i++) {
							dcd.addValue(thongkeFacade.BieuDoXeNhap(i, t2,n2), "Số lượng Nhập", String.valueOf(i));
							dcd.addValue(thongkeFacade.BieuDoXeBan(i, t2,n2), "Số lượng Bán", String.valueOf(i));
						}
						for (int i = 1; i <=31; i++) {
							dcd.removeValue("Số lượng Nhập", String.valueOf(i));
							dcd.removeValue("Số lượng Bán", String.valueOf(i));
							dcd.removeColumn("Số lượng Nhập");
							dcd.removeColumn("Số lượng Bán");
						}
						for (int i = 1; i <=maxDay; i++) {
							dcd.addValue(thongkeFacade.BieuDoXeNhap(i, t2,n2), "Số lượng Nhập", String.valueOf(i));
							dcd.addValue(thongkeFacade.BieuDoXeBan(i, t2,n2), "Số lượng Bán", String.valueOf(i));
						}
						for (int i = 2019; i <= LocalDate.now().getYear(); i++) {
							dcd.addValue(thongkeFacade.SoLuongXeBanTrongNam(i), "Số lượng Nhập", String.valueOf(i));
							dcd.addValue(thongkeFacade.SoLuongXeNhapTrongNam(i), "Số lượng Bán", String.valueOf(i));
						}
						for (int i = 2019; i <=LocalDate.now().getYear(); i++) {
							dcd.removeValue("Số lượng Nhập", String.valueOf(i));
							dcd.removeValue("Số lượng Bán", String.valueOf(i));
							dcd.removeColumn("Số lượng Nhập");
							dcd.removeColumn("Số lượng Bán");
						}
						for (int i = 1; i <= 12; i++) {
							dcd.addValue(thongkeFacade.BieuDoXeNhap(i, LocalDate.now().getYear()), "Số lượng Nhập", "Tháng "+i);
							dcd.addValue(thongkeFacade.BieuDoXeBan(i, LocalDate.now().getYear()), "Số lượng Bán", "Tháng "+i);
						}
						for (int i = 1; i <=12; i++) {
							dcd.removeValue("Số lượng Nhập", "Tháng "+i);
							dcd.removeValue("Số lượng Bán", "Tháng "+i);
							dcd.removeColumn("Số lượng Nhập");
							dcd.removeColumn("Số lượng Bán");
						}
						//Biểu đồ khách hàng mới
						for (int i = 1; i <=31; i++) {
							dcdKH.addValue(thongkeFacade.BieuDoKhachHangTheoNgay(i, t2,n2), "Số lượng Khách Hàng Mới", String.valueOf(i));
						}
						for (int i = 1; i <=31; i++) {
							dcdKH.removeValue("Số lượng Khách Hàng Mới", String.valueOf(i));
							dcdKH.removeColumn("Số lượng Khách Hàng Mới");
						}
						for (int i = 1; i <= 12; i++) {
							dcdKH.addValue(thongkeFacade.SoLuongKhachHangTrongThang(i, n2), "Số lượng Khách Hàng Mới", "Tháng "+i);
						}
						for (int i = 1; i <=12; i++) {
							dcdKH.removeValue("Số lượng Khách Hàng Mới", "Tháng "+i);
							dcdKH.removeColumn("Số lượng Khách Hàng Mới");
						}
						for (int i = 2019; i <= LocalDate.now().getYear(); i++) {
							dcdKH.addValue(thongkeFacade.SoLuongKhachHangTrongNam(i), "Số lượng Khách Hàng Mới", String.valueOf(i));
						}
						for (int i = 1; i <=LocalDate.now().getYear(); i++) {
							dcdKH.removeValue("Số lượng Khách Hàng Mới",String.valueOf(i));
							dcdKH.removeColumn("Số lượng Khách Hàng Mới");
						}
						for (int i = 1; i <=maxDay; i++) {
							dcdKH.addValue(thongkeFacade.BieuDoKhachHangTheoNgay(i, t2,n2), "Số lượng Khách Hàng Mới", String.valueOf(i));
						}
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		TableCellRenderer baseRenderer = table.getTableHeader().getDefaultRenderer();
		table.getTableHeader().setDefaultRenderer(new TableHeaderRenderer(baseRenderer));
	}
	private void loadThongKeThang() throws SQLException, MalformedURLException, RemoteException, NotBoundException {
		int n=(int) cbNam.getSelectedItem();
		int t=(int) cbThang.getSelectedItem();
		ThongkeFacade thongkeFacade = (ThongkeFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/thongkeFacade");
		//Dao_ThongKe dao_thongKe= new Dao_ThongKe();
		//tableModel = thongkeFacade.getAllCTHD(t, n);
		table.setModel(thongkeFacade.getAllCTHD(t, n));
	}
	private void loadThongKeNam() throws SQLException, MalformedURLException, RemoteException, NotBoundException {
		int n=(int) cbNam.getSelectedItem();
		ThongkeFacade thongkeFacade = (ThongkeFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/thongkeFacade");
		//Dao_ThongKe dao_thongKe= new Dao_ThongKe();
		//tableModel = thongkeFacade.getAllYear(n);
		table.setModel(thongkeFacade.getAllYear(n));
	}
	private void loadThongKeNgay(int ngay, int thang, int nam) throws SQLException, MalformedURLException, RemoteException, NotBoundException {
		ThongkeFacade thongkeFacade = (ThongkeFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/thongkeFacade");
		//Dao_ThongKe dao_thongKe= new Dao_ThongKe();
		//tableModel = thongkeFacade.getAllCTHD(ngay, thang,nam);
		table.setModel(thongkeFacade.getAllCTHD(ngay, thang,nam));
	}
	private void loadNhanVienTheoNam(int n) throws SQLException, MalformedURLException, RemoteException, NotBoundException {
		ThongkeFacade thongkeFacade = (ThongkeFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/thongkeFacade");
		//Dao_ThongKe dao_thongKe= new Dao_ThongKe();
		tableModelNV = thongkeFacade.getAllNV(n);
		tbNhanVien.setModel(tableModelNV);		
	}
	private void loadNhanVienTheoNgay(int ngay,int t,int nam) throws SQLException, MalformedURLException, RemoteException, NotBoundException {
		ThongkeFacade thongkeFacade = (ThongkeFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/thongkeFacade");
		//Dao_ThongKe dao_thongKe= new Dao_ThongKe();
		tableModelNV = thongkeFacade.getAllNV(ngay,t,nam);
		tbNhanVien.setModel(tableModelNV);		
	}
	private void loadNhanVienTheoThang(int t,int nam) throws SQLException, MalformedURLException, RemoteException, NotBoundException {
		ThongkeFacade thongkeFacade = (ThongkeFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/thongkeFacade");
		//Dao_ThongKe dao_thongKe= new Dao_ThongKe();
		tableModelNV = thongkeFacade.getAllNV(t,nam);
		tbNhanVien.setModel(tableModelNV);		
	}
	private void loadCTNhanVienTheoNam(int nam, String ma) throws SQLException, MalformedURLException, RemoteException, NotBoundException {
		ThongkeFacade thongkeFacade = (ThongkeFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/thongkeFacade");
		//Dao_ThongKe dao_thongKe= new Dao_ThongKe();
		tableModelCTNV = thongkeFacade.getAllCTNV(nam,ma);
		tbCTNV.setModel(tableModelCTNV);		
	}
	private void loadCTNhanVienTheoNgay(int ngay,int t,int nam, String ma) throws SQLException, MalformedURLException, RemoteException, NotBoundException {
		ThongkeFacade thongkeFacade = (ThongkeFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/thongkeFacade");
		//Dao_ThongKe dao_thongKe= new Dao_ThongKe();
		tableModelCTNV = thongkeFacade.getAllCTNV(ngay,t,nam, ma);
		tbCTNV.setModel(tableModelCTNV);		
	}
	private void loadCTNhanVienTheoThang(int t,int nam, String ma) throws SQLException, MalformedURLException, RemoteException, NotBoundException {
		ThongkeFacade thongkeFacade = (ThongkeFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/thongkeFacade");
		//Dao_ThongKe dao_thongKe= new Dao_ThongKe();
		tableModelCTNV = thongkeFacade.getAllCTNV(t,nam, ma);
		tbCTNV.setModel(tableModelCTNV);	
	}
	private void loadKHThang(int t,int nam) throws SQLException, MalformedURLException, RemoteException, NotBoundException {
		ThongkeFacade thongkeFacade = (ThongkeFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/thongkeFacade");
		//Dao_ThongKe dao_thongKe= new Dao_ThongKe();
		tableModelKH= thongkeFacade.getAllKH(t,nam);
		tableKH.setModel(tableModelKH);	
	}
	private void loadKHNam(int nam) throws SQLException, MalformedURLException, RemoteException, NotBoundException {
		ThongkeFacade thongkeFacade = (ThongkeFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/thongkeFacade");
		//Dao_ThongKe dao_thongKe= new Dao_ThongKe();
		tableModelKH= thongkeFacade.getAllKH(nam);
		tableKH.setModel(tableModelKH);	
	}
	private void loadKHNgay(int ngay,int t,int nam) throws SQLException, MalformedURLException, RemoteException, NotBoundException {
		ThongkeFacade thongkeFacade = (ThongkeFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/thongkeFacade");
		//Dao_ThongKe dao_thongKe= new Dao_ThongKe();
		tableModelKH= thongkeFacade.getAllKH(ngay,t,nam);
		tableKH.setModel(tableModelKH);	
	}
	public void LoadTong() {
		try {
			int ngay= (int) cbNgay.getSelectedItem();
			loadThongKeThang();
			int ngay1=LocalDate.now().getDayOfMonth();
			int t1= LocalDate.now().getMonthValue();
			int n1= LocalDate.now().getYear();
			DecimalFormat df = new DecimalFormat("###,###,###,### VNĐ");
			loadKHNgay(ngay1, t1, n1);
			lbSLXeMoi.setText(String.valueOf(thongkeFacade.BieuDoXeNhap(ngay,t1, n1)));
			lbSLXeBan.setText(String.valueOf(thongkeFacade.BieuDoXeBan(ngay,t1, n1)));
			lbSLKhachHang.setText(String.valueOf(thongkeFacade.BieuDoKhachHangTheoNgay(ngay,t1, n1)));
			lbSLTienBan.setText(df.format(thongkeFacade.TongTienTheoNgay(ngay,t1, n1)));
			lbTKXB.setText("Tổng Số Lượng Xe Bán Trong Ngày "+ngay);
			lbTKXM.setText("Tổng Số Lượng Xe Mới Trong Ngày "+ngay);
			lbSTDB.setText("Tổng Doanh Thu Trong Ngày "+ngay);
			lbSLKH.setText("Số Khách Hàng Mới Trong Ngày "+ngay);

			int t2=(int) cbThang.getSelectedItem();
			int n2=(int) cbNam.getSelectedItem();
			loadNhanVienTheoNgay(ngay1, t1, n1);
			Calendar calendar = Calendar.getInstance();
			calendar.set(n2, t2, 0);
			int maxDay =calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
			
			//Biểu đồ xe Nhập - Bán
			for (int i = 1; i <=31; i++) {
				dcd.addValue(thongkeFacade.BieuDoXeNhap(i, t2,n2), "Số lượng Nhập", String.valueOf(i));
				dcd.addValue(thongkeFacade.BieuDoXeBan(i, t2,n2), "Số lượng Bán", String.valueOf(i));
			}
			for (int i = 1; i <=31; i++) {
				dcd.removeValue("Số lượng Nhập", String.valueOf(i));
				dcd.removeValue("Số lượng Bán", String.valueOf(i));
				dcd.removeColumn("Số lượng Nhập");
				dcd.removeColumn("Số lượng Bán");
			}
			for (int i = 1; i <=maxDay; i++) {
				dcd.addValue(thongkeFacade.BieuDoXeNhap(i, t2,n2), "Số lượng Nhập", String.valueOf(i));
				dcd.addValue(thongkeFacade.BieuDoXeBan(i, t2,n2), "Số lượng Bán", String.valueOf(i));
			}
			for (int i = 2019; i <= LocalDate.now().getYear(); i++) {
				dcd.addValue(thongkeFacade.SoLuongXeBanTrongNam(i), "Số lượng Nhập", String.valueOf(i));
				dcd.addValue(thongkeFacade.SoLuongXeNhapTrongNam(i), "Số lượng Bán", String.valueOf(i));
			}
			for (int i = 2019; i <=LocalDate.now().getYear(); i++) {
				dcd.removeValue("Số lượng Nhập", String.valueOf(i));
				dcd.removeValue("Số lượng Bán", String.valueOf(i));
				dcd.removeColumn("Số lượng Nhập");
				dcd.removeColumn("Số lượng Bán");
			}
			for (int i = 1; i <= 12; i++) {
				dcd.addValue(thongkeFacade.BieuDoXeNhap(i, LocalDate.now().getYear()), "Số lượng Nhập", "Tháng "+i);
				dcd.addValue(thongkeFacade.BieuDoXeBan(i, LocalDate.now().getYear()), "Số lượng Bán", "Tháng "+i);
			}
			for (int i = 1; i <=12; i++) {
				dcd.removeValue("Số lượng Nhập", "Tháng "+i);
				dcd.removeValue("Số lượng Bán", "Tháng "+i);
				dcd.removeColumn("Số lượng Nhập");
				dcd.removeColumn("Số lượng Bán");
			}
			//Biểu đồ khách hàng mới
			for (int i = 1; i <=31; i++) {
				dcdKH.addValue(thongkeFacade.BieuDoKhachHangTheoNgay(i, t2,n2), "Số lượng Khách Hàng Mới", String.valueOf(i));
			}
			for (int i = 1; i <=31; i++) {
				dcdKH.removeValue("Số lượng Khách Hàng Mới", String.valueOf(i));
				dcdKH.removeColumn("Số lượng Khách Hàng Mới");
			}
			for (int i = 1; i <= 12; i++) {
				dcdKH.addValue(thongkeFacade.SoLuongKhachHangTrongThang(i, n2), "Số lượng Khách Hàng Mới", "Tháng "+i);
			}
			for (int i = 1; i <=12; i++) {
				dcdKH.removeValue("Số lượng Khách Hàng Mới", "Tháng "+i);
				dcdKH.removeColumn("Số lượng Khách Hàng Mới");
			}
			for (int i = 2019; i <= LocalDate.now().getYear(); i++) {
				dcdKH.addValue(thongkeFacade.SoLuongKhachHangTrongNam(i), "Số lượng Khách Hàng Mới", String.valueOf(i));
			}
			for (int i = 1; i <=LocalDate.now().getYear(); i++) {
				dcdKH.removeValue("Số lượng Khách Hàng Mới",String.valueOf(i));
				dcdKH.removeColumn("Số lượng Khách Hàng Mới");
			}
			for (int i = 1; i <=maxDay; i++) {
				dcdKH.addValue(thongkeFacade.BieuDoKhachHangTheoNgay(i, t2,n2), "Số lượng Khách Hàng Mới", String.valueOf(i));
			}
			loadThongKeNgay(ngay1, t1, n1);
			loadNhanVienTheoNgay(ngay1, t1, n1);
			loadKHNgay(ngay1, t1, n1);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
