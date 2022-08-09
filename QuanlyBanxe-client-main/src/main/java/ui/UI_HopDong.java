package ui;

import java.awt.BorderLayout;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PageFormat;
import java.awt.print.Pageable;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
//import java.lang.FdLibm.Cbrt;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.OptionPaneUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import businesslogic.facade.HangSanXuatFacade;
import businesslogic.facade.HoaDonFacade;
import businesslogic.facade.HopDongFacade;
import businesslogic.facade.KhachHangFacade;
import businesslogic.facade.LoaiXeFacade;
import businesslogic.facade.NhaCungCapFacade;
import businesslogic.facade.NhanVienFacade;
import businesslogic.facade.XeFacade;

import java.time.LocalDate;

import entity.ChucVu;
import entity.HangSanXuat;
import entity.HopDong;
import entity.NhanVien;
import entity.KhachHang;
import entity.LoaiXe;
import entity.NhaCungCap;
import entity.Xe;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.beans.PropertyChangeListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.beans.PropertyChangeEvent;

public class UI_HopDong extends JFrame {

	protected static final String HopDong = null;
	protected static final String Xe = null;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private DecimalFormat df = new DecimalFormat("###,###,###,### VNĐ");

		//ArrayList<KhachHang> tableModel;
	private DefaultTableModel tableModel1,tableModel;
	HangSanXuatFacade hangSanXuatFacade = (HangSanXuatFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/hangSanXuatFacade");
	HopDongFacade hopDongFacade = (HopDongFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/hopDongFacade");
	KhachHangFacade khachHangFacade = (KhachHangFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/khachHangFacade");
	LoaiXeFacade loaiXeFacade = (LoaiXeFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/loaiXeFacade");
	NhanVienFacade nhanVienFacade = (NhanVienFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/nhanVienFacade");
	XeFacade xeFacade = (XeFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/xeFacade");
//	private Dao_HopDong dao_hd = new Dao_HopDong();
//	private Dao_QuanLyXe dao_qlXe = new Dao_QuanLyXe();
//	private Dao_KhachHang dao_kh = new Dao_KhachHang();
//	private Dao_NhanVien dao_nv = new Dao_NhanVien();
//	private Dao_LoaiXe dao_lx = new Dao_LoaiXe();
//	private Dao_HangSanXuat dao_hsx = new Dao_HangSanXuat();
	
	private JTable table_1;
	private JTextField txtcmnd;
	private JTextField txttenKH;
	private JTextField textField_4;
	private JDateChooser dateChooser;

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
					UI_HopDong frame = new UI_HopDong();
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
	 * @throws NotBoundException 
	 * @throws RemoteException 
	 * @throws MalformedURLException 
	 */
	public UI_HopDong() throws MalformedURLException, RemoteException, NotBoundException {
//		try {
//			ConnectDB.getInstance().connect();
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1312, 735);
		List<String> list_CMND = khachHangFacade.getListCMND();
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		
		setBounds(0, 0, screen.width, (screen.height-50));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.control);
		panel.setBounds(0, 0, 1512, 695);
		getContentPane().add(panel);
		panel.setLayout(null);
		
	
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Quản lý thông tin hợp đồng");
		lblNewLabel_1.setForeground(new Color(184, 134, 11));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setBounds(10, 10, 439, 72);
		panel.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 92, 1084, 240);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		String [] header1 = {"Mã hợp đồng","CMND","Tên khách hàng","Số điện thoại","Địa chỉ","Mã nhân viên", "Tên nhân viên","Mã xe","Tên xe","Loại xe","Phiên bản","Màu xe","Phân khối","Số khung","Số máy","Đơn giá","Thuế","Ngày lập hợp đồng","Thời gian bảo hành"};
		tableModel1 = new DefaultTableModel(header1,0);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=table_1.getSelectedRow();
				txtcmnd.setText(tableModel1.getValueAt(i, 1).toString());
			//	txtMa.setText(tableModel.getValueAt(i, 0).toString());
			}
		});
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1084, 240);
		panel_2.add(scrollPane);
		
		table_1 = new JTable();
		
		table_1.setModel(hopDongFacade.getAllHD());
		
		String [] header = {"Mã xe","Tên xe","Loại xe", "Hãng sản xuất", "Phiên bản","Màu xe","Phân khối","Số khung","Số máy","Thành tiền","Trạng thái"};
		tableModel = new DefaultTableModel(header,0);
		scrollPane_2.setBounds(10, 342, 1084, 237);
		panel.add(scrollPane_2);
		
		table = new JTable(tableModel);
		setSizeColumn(table_1);
		table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		//table_1.getColumnModel().getColumn(2).setPreferredWidth(100);
		scrollPane_2.setViewportView(table_1);
		scrollPane.setViewportView(table);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Thông tin khách hàng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(1104, 92, 398, 240);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNgyChn = new JLabel("Ngày chọn");
		lblNgyChn.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNgyChn.setBounds(40, 26, 93, 28);
		panel_3.add(lblNgyChn);
		
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy-MM-dd");
	//	dateChooser.setDate(Date.valueOf(LocalDate.now()));
		
		dateChooser.setBounds(182, 26, 180, 28);
	
	//	String ngayLap =  dateChooser.getDate().toString();
		panel_3.add(dateChooser);
		
		
		JLabel lblCmnd = new JLabel("CMND");
		lblCmnd.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCmnd.setBounds(40, 71, 80, 20);
		panel_3.add(lblCmnd);
		
		
		txtcmnd = new JTextField();	
		txtcmnd.setDocument(new JTextFieldLimit(12));
		txtcmnd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtcmnd.setBounds(182, 64, 180, 27);
		panel_3.add(txtcmnd);
		txtcmnd.setColumns(10);
		
		JLabel lblTnKhchHng = new JLabel("Tên khách hàng");
		lblTnKhchHng.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTnKhchHng.setBounds(40, 102, 132, 25);
		panel_3.add(lblTnKhchHng);
		
	
		txttenKH = new JTextField();
		txttenKH.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txttenKH.setBounds(182, 101, 180, 26);
		txttenKH.setEditable(false);
		panel_3.add(txttenKH);
		txttenKH.setColumns(10);
	

		JButton btnTaoMoi = new JButton("Tạo mới");		
		HoaDonFacade hoaDonFacade = (HoaDonFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/hoaDonFacade");
		//Dao_HoaDon dao_hoadon = new Dao_HoaDon();
		btnTaoMoi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {				
//				tableModel1.addRow(header1);
//				String col1 = tableModel1.getValueAt(i, 0).toString().trim();
				int row = table.getSelectedRow();
				if(row < 0) {
					JOptionPane.showMessageDialog(null, "Bạn chưa chọn xe!");
				}
				else {
					try {
						String maHD = hoaDonFacade.getMaHDTail("maHD", "HopDong");
						KhachHang kh = khachHangFacade.getKhachHangById("CMND", txtcmnd.getText());
						//String maNV = Login.txtuser.getText();
						String maxe = table.getValueAt(row, 0).toString();
						String tenxe = table.getValueAt(row, 1).toString();
						String loaixe = table.getValueAt(row, 2).toString();
						String mauxe = table.getValueAt(row, 5).toString();
						String phienban = table.getValueAt(row, 4).toString();
						String phankhoi = table.getValueAt(row, 6).toString();
						String sokhung = table.getValueAt(row, 7).toString();
						String somay = table.getValueAt(row, 8).toString();
						Xe xe =xeFacade.getInfoXe("maXe",maxe);
						NhanVien nv = nhanVienFacade.getNhanVienById("maNhanVien", Login.txtuser.getText());
						
						Date  ngay = Date.valueOf(LocalDate.now());
						//HopDong hdg = dao_hd.getInfoHDG("maHopDong", "HopDong");
						HopDong hd = new HopDong(maHD,kh,nv,xe,ngay,3);
						System.out.println(table.getValueAt(row, 10).toString());
					
						if(!table.getValueAt(row, 10).toString().equalsIgnoreCase("Đã Lập HD")) {
						try {
							boolean kq =hopDongFacade.themHD(hd);
							if(kq) {
								//tableModel1.addRow(new Object [] {maHD ,txtcmnd.getText(), txttenKH.getText(), kh.getSoDienThoai(), nv.getMaNhanVien(), nv.getTenNhanVien(), maxe,tenxe,loaixe,phienban,phankhoi,sokhung,somay,xe.getDonGia()+"",xe.getThueVAT()+"",LocalDate.now()+"",3+""});
								tableModel.setValueAt("Đã Lập HD", row, 10);
								JOptionPane.showMessageDialog(null, "Lập hợp đồng thành công");
								
							}else
								JOptionPane.showMessageDialog(null, "Thêm không thành công");
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						}else
							JOptionPane.showMessageDialog(null, "Xe đã được tạo hợp đồng");
						
						table_1.setModel(hopDongFacade.getAllHD());
					} catch (Exception e2) {
						e2.printStackTrace();
					}
					
				}
				
				}
		});
		
		btnTaoMoi.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnTaoMoi.setBackground(Color.ORANGE);
		btnTaoMoi.setBounds(40, 148, 132, 52);
		btnTaoMoi.setIcon(new ImageIcon("img1/add.png"));
		panel_3.add(btnTaoMoi);
		
		JButton btnLamSach = new JButton("Làm sạch");
		btnLamSach.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLamSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dateChooser.setDate(null);
				txtcmnd.setText("");
				txttenKH.setText("");
				dateChooser.requestFocus();
				tableModel.getDataVector().removeAllElements();
				tableModel.fireTableDataChanged();
				/*try {
/////					//loadHD();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
			}
		});
		btnLamSach.setBackground(Color.ORANGE);
		btnLamSach.setBounds(223, 148, 139, 52);
		btnLamSach.setIcon(new ImageIcon("img1/refresh.png"));
		panel_3.add(btnLamSach);
		

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Chức năng	", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(1104, 342, 398, 240);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNhapCmnd = new JLabel("Nhập số CMND");
		lblNhapCmnd.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNhapCmnd.setBounds(33, 48, 131, 31);
		panel_4.add(lblNhapCmnd);
		
		textField_4 = new JTextField();
		textField_4.setDocument(new JTextFieldLimit(12));
		textField_4.setBounds(174, 48, 189, 31);
		panel_4.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnTimKiem = new JButton("Tìm");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTimKiem.addMouseListener(new MouseAdapter() {
				@Override
			public void mouseClicked(MouseEvent e) {
				if(textField_4.getText().length()==0) {
					tableModel1.getDataVector().removeAllElements();
					tableModel1.fireTableDataChanged();
					try {
						table_1.setModel(hopDongFacade.getAllHD());
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(textField_4.getText().length()>0) {
					try {
						timKiemHD();
					 
						//timXe();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
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
			}
		});
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnTimKiem.setBackground(Color.ORANGE);
		btnTimKiem.setBounds(235, 115, 124, 57);
		btnTimKiem.setIcon(new ImageIcon("img1/search2.png"));
		panel_4.add(btnTimKiem);
		
		JButton btnXuatHD = new JButton("Xuất");
		btnXuatHD.addMouseListener(new MouseAdapter() {
			@Override
			
			public void mouseClicked(MouseEvent e) {
				int row=table_1.getSelectedRow();
				int i=table_1.getSelectedRow();
				try {
					if(row!=-1) {
						
						UI_XuatHopDong frame = new UI_XuatHopDong();
						frame.setVisible(true);
						frame.label_edit_tenKH.setText(table_1.getValueAt(i, 2).toString());
						frame.label_edit_cmnd.setText(table_1.getValueAt(i, 1).toString());
						frame.label_edit_dongia.setText(table_1.getValueAt(i, 15).toString());
						frame.label_edit_loaixe.setText(table_1.getValueAt(i, 9).toString());
						frame.label_edit_mauxe.setText(table_1.getValueAt(i,11).toString());
						frame.label_edit_phankhoi.setText(table_1.getValueAt(i, 12).toString());
						frame.label_edit_sokhung.setText(table_1.getValueAt(i, 13).toString());
						frame.label_edit_somay.setText(table_1.getValueAt(i, 14).toString());
						frame.label_edit_tgbh.setText(table_1.getValueAt(i, 17).toString());
						frame.label_edit_sdt.setText(table_1.getValueAt(i, 3).toString());
						frame.label_edit_tenxe.setText(table_1.getValueAt(i, 8).toString());
						frame.lbl_edit_tenNV.setText(table_1.getValueAt(i, 6).toString());
						frame.label_edit_diachi.setText(table_1.getValueAt(i, 4).toString());
						frame.label_edit_thue.setText(table_1.getValueAt(i, 16).toString());
						
						
					}
					else
						JOptionPane.showMessageDialog(null, "Vui lòng chọn hợp đồng  để xem thông tin chi tiết !!!");
				} catch (Exception e2) {
					// TODO: handle exception
				}
			
				
			}
		});
//		btnXuatHD.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				PrinterJob printjob =  PrinterJob.getPrinterJob();
//				printjob.setJobName("Hãng mua bán xe");
//				printjob.setPrintable(new Printable() {
//					
//					@Override
//					public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
//						if(pageIndex > 0){
//							return Printable.NO_SUCH_PAGE;
//						}
//						return Printable.PAGE_EXISTS;
//					}
//				});
//				boolean returningResult = printjob.printDialog();
//				if(returningResult) {
//					try {
//						printjob.print();
//					}catch (PrinterException printException) {
//						JOptionPane.showMessageDialog(null, "Print Error" + printException.getMessage());
//						// TODO: handle exception
//					}
//				}
//			}
//		});
		
		btnXuatHD.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnXuatHD.setBackground(Color.ORANGE);
		btnXuatHD.setBounds(33, 115, 131, 57);
		btnXuatHD.setIcon(new ImageIcon("img1/update.png"));
		panel_4.add(btnXuatHD);
		
		
		
//		JButton btnInHD = new JButton("In");
//		btnInHD.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			//	PrinterException printer = new PrinterException();
//				
//				}
//			
//		});
//		btnInHD.setFont(new Font("Tahoma", Font.BOLD, 10));
//		btnInHD.setBackground(Color.ORANGE);
//		btnInHD.setBounds(142, 115, 99, 41);
//		btnInHD.setIcon(new ImageIcon("img1/print-icon.png"));
//		panel_4.add(btnInHD);
		
//========================================= XU LI ============================================================================
		txtcmnd.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE||e.getKeyCode()==KeyEvent.VK_DELETE)
			        {
			           
			        }
			        else
			        {   
			            String to_check=txtcmnd.getText();
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
			                    txtcmnd.setText(data);
			                    txtcmnd.setSelectionStart(to_check_len);
			                    txtcmnd.setSelectionEnd(data.length());
			                    break;
			                }
			            }
			        }
					loadXe();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(txtcmnd.getText().length()==0) {
					txttenKH.setText(null);
				}
			}
			
			public boolean cmnd(String str) {
				  return str.matches("\\d*");  //match a number with optional '-' and decimal. "-?\\d+(\\.\\d+)?"
				}
			@Override
			public void keyPressed(KeyEvent e) {
				if(!cmnd(txtcmnd.getText())) 
					txtcmnd.setForeground(Color.red);
				else
					txtcmnd.setForeground(Color.BLACK);
				if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE||e.getKeyCode()==KeyEvent.VK_DELETE)
		        {
		           
		        }
		        else
		        {   
		            String to_check=txtcmnd.getText();
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
		                    txtcmnd.setText(data);
		                    txtcmnd.setSelectionStart(to_check_len);
		                    txtcmnd.setSelectionEnd(data.length());
		                    break;
		                }
		            }
		        }
			}
		});
		
		dateChooser.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				try {
					loadXe();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE||e.getKeyCode()==KeyEvent.VK_DELETE) {
		           
		        }
		        else
		        {   
		            String to_check=textField_4.getText();
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
		                	textField_4.setText(data);
		                	textField_4.setSelectionStart(to_check_len);
		                	textField_4.setSelectionEnd(data.length());
		                    break;
		                }
		            }
		        }
			}
		});
		
		table.setRowHeight(20);
		table_1.setRowHeight(20);
		table.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table_1.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 14));
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
	}

//	private void loadHD() throws SQLException {
//		Dao_HopDong dao_hd = new Dao_HopDong();		
//		String [] header1 = null ;
//		tableModel1 = dao_hd.getAllHD(header1, tableModel1);
//		table_1.setModel(tableModel1);
//	}
	private void loadXe() throws SQLException, RemoteException{
		tableModel.getDataVector().removeAllElements();
		tableModel.fireTableDataChanged();
		KhachHang kh = khachHangFacade.getKhachHangById("CMND", txtcmnd.getText());
		String ngay = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
		if(kh!=null) {
			txttenKH.setText(kh.getTenKhachHang());
			List<String> listXe = hopDongFacade.getListXeByCustomer(kh.getMaKhachHang(), ngay);
			Xe xe = null;
			LoaiXe lx;
			HangSanXuat hsx ;
			double dongia = 0;
			String trangthai= "";
			for(String maXe : listXe) {
				xe = xeFacade.getInfoXe("maXe", maXe);
				lx = loaiXeFacade.layLoaiXeById(xe.getLoaiXe().getMaLoaiXe());
				hsx = hangSanXuatFacade.getHangSanXuatById(xe.getHangSanXuat().getMaHangSX());
				dongia = xe.getDonGia() + xe.getThueVAT();
				if(hopDongFacade.getHopDongByVehicleNum(xe.getMaXe()) != null)
					trangthai = "Đã Lập HD";
				else
					trangthai = "";
				tableModel.addRow(new Object[] {xe.getMaXe(), xe.getTenXe(), lx.getTenLoaiXe(), hsx.getTenHangSX(), xe.getPhienBan(),xe.getMauXe(), xe.getPhanKhoi()+"", xe.getSoKhung(), xe.getSoMay(), df.format(dongia),trangthai});
			}
		}
	}
	private void timHD() throws SQLException, MalformedURLException, RemoteException, NotBoundException{
		HopDongFacade hopDongFacade = (HopDongFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/hopDongFacade");
		//dao_hd = new Dao_HopDong();
		tableModel1 = hopDongFacade.timKiem("%"+txtcmnd.getText()+"%");
		table_1.setModel(tableModel1);
	}
	private void timKiemHD() throws SQLException, RemoteException, MalformedURLException, NotBoundException{
		HopDongFacade hopDongFacade = (HopDongFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/hopDongFacade");
		//dao_hd = new Dao_HopDong();
		tableModel1 = hopDongFacade.timKiem("%"+textField_4.getText()+"%");
		table_1.setModel(tableModel1);
	}
	private void timXe() throws SQLException, RemoteException, MalformedURLException, NotBoundException{
		HopDongFacade hopDongFacade = (HopDongFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/hopDongFacade");
		//dao_hd = new Dao_HopDong();
		tableModel = hopDongFacade.timKiemXe(txtcmnd.getText());
		table.setModel(tableModel);
	}
	private void timNgay() throws SQLException, RemoteException, MalformedURLException, NotBoundException{	
		HopDongFacade hopDongFacade = (HopDongFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/hopDongFacade");
		//dao_hd = new Dao_HopDong();		
		tableModel1 = hopDongFacade.timKiemNgay(dateChooser.getDate().toString());
		table_1.setModel(tableModel1);
		
	}
	
	private void locData() throws SQLException, MalformedURLException, RemoteException, NotBoundException{
		JDateChooser dateChooser = new JDateChooser();
		//String ngayLap =  dateChooser.getDate().toString();
		HopDongFacade hopDongFacade = (HopDongFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/hopDongFacade");
		//dao_hd = new Dao_HopDong();
		tableModel1 = hopDongFacade.locData("%"+txtcmnd.getText()+"%","%"+dateChooser.getDate().toString()+"%");
		table_1.setModel(tableModel1);
	}
	
	private void setSizeColumn(JTable table) {
		TableColumn column = null;
		int sl = table.getColumnCount();
		for (int i = 0; i< sl; i++) {
			column = table.getColumnModel().getColumn(i);
			if( i == 2 || i == 5 || i == 9 || i == 11 || i == 13 || i == 14 || i == 15)
				column.setPreferredWidth(120);
		}
	}
}


