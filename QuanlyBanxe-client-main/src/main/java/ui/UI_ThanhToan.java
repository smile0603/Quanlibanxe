package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import businesslogic.facade.HoaDonFacade;
import businesslogic.facade.KhachHangFacade;
import businesslogic.facade.NhanVienFacade;
import businesslogic.facade.XeFacade;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.Xe;
import others.Bill;
import others.PrintSupport;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static ui.UI_HoaDon.cbbVehicleName_Bill;
import static ui.UI_QuanLyXe.lbXeConLai;
import static ui.UI_QuanLyXe.lbXeDaBan;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Color;
import java.awt.TextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.Date;
import java.sql.SQLException;

public class UI_ThanhToan extends JFrame {

	private JPanel contentPane;
	public static JFormattedTextField txtCusMoney;
	public static TextField txtRefunds;

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
					UI_ThanhToan frame = new UI_ThanhToan();
					frame.setVisible(true);
					//txtCusMoney.requestFocus();
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
	public UI_ThanhToan() throws MalformedURLException, RemoteException, NotBoundException {
		DecimalFormat df = new DecimalFormat("###,###,### VNĐ");
		HoaDonFacade hoaDonFacade = (HoaDonFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/hoaDonFacade");
		KhachHangFacade khachHangFacade = (KhachHangFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/khachHangFacade");
		NhanVienFacade nhanVienFacade = (NhanVienFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/nhanVienFacade");
		setForeground(new Color(255, 69, 0));
		setFont(new Font("Dialog", Font.BOLD, 12));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setUndecorated(true);
		setBounds(500, 120, 712, 470);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 196, 222));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(154, 205, 50));
		panel.setBounds(0, 0, 712, 361);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thông tin thanh toán");
		lblNewLabel.setForeground(new Color(255, 69, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(15, 8, 297, 43);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 248, 255));
		panel_1.setBounds(0, 54, 712, 306);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblSumTotal = new JLabel("Tổng thanh toán");
		lblSumTotal.setForeground(new Color(34, 139, 34));
		lblSumTotal.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSumTotal.setBounds(43, 12, 220, 30);
		panel_1.add(lblSumTotal);
		
		TextField txtSumTotal = new TextField();
		txtSumTotal.setEditable(false);
		txtSumTotal.setBackground(Color.WHITE);
		txtSumTotal.setForeground(new Color(34, 139, 34));
		txtSumTotal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSumTotal.setBounds(354, 10, 322, 34);
		panel_1.add(txtSumTotal);
		txtSumTotal.setText(UI_HoaDon.txtTotal.getText());
		
		JLabel lblPaymentsType = new JLabel("Hình thức TT");
		lblPaymentsType.setForeground(new Color(128, 0, 128));
		lblPaymentsType.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPaymentsType.setBounds(43, 65, 144, 30);
		panel_1.add(lblPaymentsType);
		
		JComboBox cbbPaymentsType = new JComboBox();
		cbbPaymentsType.setForeground(new Color(128, 0, 128));
		cbbPaymentsType.setModel(new DefaultComboBoxModel(new String[] {"Tiền mặt"}));
		cbbPaymentsType.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cbbPaymentsType.setBackground(Color.WHITE);
		cbbPaymentsType.setBounds(354, 63, 176, 34);
		panel_1.add(cbbPaymentsType);
		
		JLabel lblCurrency = new JLabel("Loại tiền");
		lblCurrency.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCurrency.setBounds(43, 118, 102, 30);
		panel_1.add(lblCurrency);
		
		JComboBox cbbCurrency = new JComboBox();
		cbbCurrency.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cbbCurrency.setModel(new DefaultComboBoxModel(new String[] {"VND"}));
		cbbCurrency.setBounds(354, 116, 176, 34);
		panel_1.add(cbbCurrency);
		
		JLabel lblCusMoney = new JLabel("Tiền khách đưa");
		lblCusMoney.setForeground(new Color(0, 0, 255));
		lblCusMoney.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCusMoney.setBounds(43, 171, 193, 25);
		panel_1.add(lblCusMoney);
		
		NumberFormat num = NumberFormat.getNumberInstance();
		txtCusMoney = new JFormattedTextField(num);
		txtCusMoney.requestFocus();
		txtCusMoney.setForeground(new Color(0, 0, 255));
		txtCusMoney.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtCusMoney.setBounds(354, 169, 322, 34);
		panel_1.add(txtCusMoney);
		
		JLabel lblRegex = new JLabel("");
		lblRegex.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRegex.setForeground(new Color(255, 0, 0));
		lblRegex.setBounds(354, 205, 322, 25);
		panel_1.add(lblRegex);
		
		JLabel lblRefunds = new JLabel("Tiền trả lại");
		lblRefunds.setForeground(new Color(255, 69, 0));
		lblRefunds.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRefunds.setBounds(43, 253, 136, 25);
		panel_1.add(lblRefunds);
		
		txtRefunds = new TextField();
		txtRefunds.setBackground(Color.WHITE);
		txtRefunds.setForeground(new Color(255, 69, 0));
		txtRefunds.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtRefunds.setEditable(false);
		txtRefunds.setBounds(354, 251, 322, 34);
		panel_1.add(txtRefunds);
		
		JButton btnClose = new JButton("Đóng");
		btnClose.setIcon(new ImageIcon(UI_ThanhToan.class.getResource("/image/Button-exit-icon.png")));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnClose.setBounds(538, 371, 136, 48);
		contentPane.add(btnClose);
		
		JButton btnCompleted = new JButton("Hoàn Tất");
		btnCompleted.setIcon(new ImageIcon(UI_ThanhToan.class.getResource("/image/Save-icon.png")));
		btnCompleted.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCompleted.setBounds(352, 371, 169, 48);
		contentPane.add(btnCompleted);
		
		txtCusMoney.addKeyListener(new KeyAdapter() {		
			public boolean isNumeric(String str) {
				  return str.matches("\\d");  //match a number with optional '-' and decimal. "-?\\d+(\\.\\d+)?"
				}
			@Override
			public void keyReleased(KeyEvent e) {
				double money;
				NumberFormat num = NumberFormat.getNumberInstance();
				if (txtCusMoney.getText().equalsIgnoreCase("")) {
					lblRegex.setText("");
				}
				else if(isNumeric(txtCusMoney.getText().substring(txtCusMoney.getText().length()-1))==true)
					try {
						money = num.parse(txtCusMoney.getText()).doubleValue();
						txtCusMoney.setText(num.format(money));
						lblRegex.setText("");	
						double cusMoney = 0;
						if (!txtCusMoney.getText().equalsIgnoreCase(""))		
								cusMoney = num.parse(txtCusMoney.getText()).doubleValue();
						double total;
						
						total = df.parse(txtSumTotal.getText()).doubleValue();
						double tamp = 0;
						if(cusMoney >= total) {
							tamp = cusMoney - total;
							txtRefunds.setText(String.valueOf(df.format(tamp)));
						}
						else
							txtRefunds.setText("");
					} catch (NumberFormatException | ParseException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
						lblRegex.setText("Vui lòng nhập ký tự số!");
					}
				else
					lblRegex.setText("Vui lòng nhập ký tự số!");
			}
		});
		
		btnCompleted.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Thông tin hóa đơn
				if (txtRefunds.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Số tiền khách đưa không hợp lệ!");
					return;
				}
				String maHoaDon = UI_HoaDon.txtBillNum.getText();
				String maKhachHang = UI_HoaDon.maKhachHang;
				String maNhanVien = UI_HoaDon.txtEmployeeNum_Bill.getText();
				String ngay = UI_HoaDon.txtDateBill.getText();
				Date ngayLHD = Date.valueOf(LocalDate.parse(ngay));

				
				try {
					double tongTien = df.parse(UI_HoaDon.txtTotal.getText()).doubleValue();
					HoaDon hd = new HoaDon(maHoaDon, new KhachHang(maKhachHang), new NhanVien(maNhanVien), ngayLHD, df.parse(txtSumTotal.getText()).doubleValue());
					//HoaDon hoaDon = new 
					if (hoaDonFacade.createHD(hd)) {
						String maHD = hoaDonFacade.getMaHDTail("maHoaDon", "HoaDon");
						UI_HoaDon.txtBillNum.setText(maHD);
					}		
					else 
						JOptionPane.showMessageDialog(null, "Thêm Hóa Đơn không thành công!");
					} catch (ParseException e1) {
						
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (HeadlessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
				
				//Xử lý chi tiết hóa đơn
				String maXe;
				double donGia;
				double thueVAT;
				int tableRowCount  = UI_HoaDon.table.getRowCount();
				ChiTietHoaDon cthd;
				
				int i;
				for(i = 0; i<tableRowCount; i++) {
					maXe = UI_HoaDon.table.getValueAt(i, 0).toString();
					try {
						donGia = df.parse(UI_HoaDon.table.getValueAt(i, 9).toString()).doubleValue();
						thueVAT = df.parse(UI_HoaDon.table.getValueAt(i, 10).toString()).doubleValue();
						cthd = new ChiTietHoaDon(new HoaDon(maHoaDon), new Xe(maXe), donGia, thueVAT);
						if (!hoaDonFacade.createCTHD(cthd))
							JOptionPane.showMessageDialog(null, "Dòng " + String.valueOf(i) + " bị lỗi!");
						else {
							//Dao_QuanLyXe dao_xe = new Dao_QuanLyXe();
							XeFacade xeFacade = (XeFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/xeFacade");
							if(xeFacade.updateTrangThai(maXe, "Hết hàng")==false)
								JOptionPane.showMessageDialog(null, "Cập nhật trạng thái xe không thành công");
							lbXeConLai.setText(xeFacade.XeConLai()+" xe");
							lbXeDaBan.setText(xeFacade.XeDaBan()+" xe");
							cbbVehicleName_Bill.removeAllItems();
							ArrayList<String> nameName=xeFacade.getXeByTrangThai("select DISTINCT tenXe from Xe where trangThai = N'Còn hàng' order by tenXe","tenXe");
							for (String string : nameName) {
								cbbVehicleName_Bill.addItem(string);
							}	 
						}
					} catch (ParseException e1) {
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
				//Bill bill= new Bill();
				
				Bill.maHD = maHoaDon;
				try {
					Bill bill = new Bill();
				} catch (Exception e2) {
					// TODO: handle exception
				}
					
					//bill.setVisible(true);
					PrintSupport.printComponent(Bill.textArea);
					String cmds[] = new String[] {"cmd", "/d", "D:\\nam4ky1\\LapTrinhPhanTan\\BAITAPDOAN\\HopDong\\a.pdf"};
					try {
					    Runtime.getRuntime().exec(cmds);
					}catch (Exception e1) {
						// TODO: handle exception
					}
					if(i == tableRowCount) {
						UI_HoaDon.tableModel.getDataVector().removeAllElements();
						UI_HoaDon.tableModel.fireTableDataChanged();
						UI_HoaDon.txtCMND_Bill.setText("");
						UI_HoaDon.txtCustomerName_Bill.setText("");
						UI_HoaDon.txtNumPhone_Bill.setText("");
						UI_HoaDon.txtNoteCustomer_Bill.setText("");
						UI_HoaDon.txtTotal.setText("0 VNĐ");
						UI_HoaDon.txtTotalVAT.setText("0 VNĐ");
						setVisible(false);
					}
			
					
			}
		});
		
	}
}
