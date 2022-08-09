package ui;



import java.awt.BorderLayout;

import com.toedter.calendar.JDateChooser;

import businesslogic.facade.HoaDonFacade;
import businesslogic.facade.KhachHangFacade;
import businesslogic.facade.NhanVienFacade;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.tools.DocumentationTool.Location;
import entity.ChucVu;
import entity.KhachHang;
import entity.LoaiXe;
import entity.NhaCungCap;
import entity.NhanVien;
import entity.Xe;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.ScrollPane;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import java.lang.FdLibm.Cbrt;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import entity.NhanVien;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import java.beans.PropertyChangeListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
//import java.lang.FdLibm.Cbrt;
import java.beans.PropertyChangeEvent;
import javax.swing.border.TitledBorder;
public class UI_NhanVien extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtmaNV;
	
	private JTextField txtGT;
	private JTextField txtngayVaoLam;


//	private JTextField txtngaySinh;
//	private JTextField txtchucVu;
	private JTextField txtTimKiem;
	private DefaultTableModel tableModel;
	private NhanVienFacade nhanVienFacade = (NhanVienFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/nhanVienFacade");
	//private Dao_NhanVien dao_nv = new Dao_NhanVien();
	private JTextField textField_1;
	private JTextField txttenNV;
	private JTextField txtdiaChi;
//	private JTextField txtsdt;
	private JTextField txtEmail;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField txtSdt;
	private JTextField txtcmnd;
	private JDateChooser datengaySinh,datengayVaoLam;
	private KhachHangFacade khachHangFacade = (KhachHangFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/khachHangFacade");
	//private Dao_KhachHang dao_kh = new Dao_KhachHang();
	

	
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
					UI_NhanVien frame = new UI_NhanVien();
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
	 * @throws SQLException 
	 * @throws RemoteException 
	 * @throws NotBoundException 
	 * @throws MalformedURLException 
	 */
	public UI_NhanVien() throws SQLException, RemoteException, MalformedURLException, NotBoundException {
//		try {
//			ConnectDB.getInstance().connect();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//	setBounds(100, 100, 1296, 732);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		List<String> list_CMND = khachHangFacade.getListCMND();
		setBounds(0, 0, screen.width, (screen.height-50));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.control);
		panel.setBounds(0, 0, 1540, 772);
		contentPane.add(panel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(7, 93, 1492, 228);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(null, "Thông Tin Nhân Viên", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setBounds(0, 10, 1482, 211);
		panel_3.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblmaNV = new JLabel("Mã Nhân Viên");
		lblmaNV.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblmaNV.setBounds(9, 25, 107, 26);
		panel_6.add(lblmaNV);
		
		String maKH = nhanVienFacade.getMaHDTail("maNhanVien", "NhanVien");
		txtmaNV = new JTextField();
		txtmaNV.setEditable(false);
		txtmaNV.setText(maKH);
		txtmaNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtmaNV.setBounds(138, 24, 260, 27);
		panel_6.add(txtmaNV);
		txtmaNV.setColumns(10);
		
		JLabel lbltenNV = new JLabel("Tên Nhân Viên");
		lbltenNV.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbltenNV.setBounds(8, 66, 119, 30);
		panel_6.add(lbltenNV);
		
		txttenNV = new JTextField();
		
		txttenNV.addKeyListener(new KeyAdapter() {
			public boolean tennv(String str) {
				return str.matches("^[a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ\\\" +\\r\\n\" + \r\n" + 
						"				\"            \\\"ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ\\\" +\\r\\n\" + \r\n" + 
						"				\"            \\\"ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\\\\\\\s]+$"); 
			}	
			@Override
			public void keyReleased(KeyEvent e) {
				if(!tennv(txttenNV.getText())) 
					txttenNV.setForeground(Color.red);
				else
					txttenNV.setForeground(Color.BLACK);
				if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE||e.getKeyCode()==KeyEvent.VK_DELETE)
		        {
		           
		        }
		        else
		        {   
		            String to_check=txttenNV.getText();
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
		            }
		        }
			}
		});
//		txttenNV.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyPressed(KeyEvent e) {
//				if ((txttenNV.getText().length() < 0)) {
//					txttenNV.setForeground(Color.red);
//				}
//				if (!(txttenNV.getText().matches("^[a-zA-Z0-9 ]+$"))) {
//					txttenNV.setForeground(Color.red);
//				} else {
//					txttenNV.setForeground(Color.black);
//				}
//			}
//		});
		txttenNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txttenNV.setBounds(137, 69, 260, 27);
		panel_6.add(txttenNV);
		txttenNV.setColumns(10);
		
		JLabel lblngaySinh = new JLabel("Ngày sinh");
		lblngaySinh.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblngaySinh.setBounds(9, 111, 96, 27);
		panel_6.add(lblngaySinh);
		
		JDateChooser datengaySinh = new JDateChooser();


		
		datengaySinh.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 15));
		datengaySinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		datengaySinh.setBounds(138, 111, 260, 27);
		datengaySinh.setDateFormatString("yyy-MM-dd");
		datengaySinh.addPropertyChangeListener(new PropertyChangeListener() {
		public int calculateAge(LocalDate birthDate, LocalDate currentDate) {
	        if ((birthDate != null) && (currentDate != null)) {
	            return Period.between(birthDate, currentDate).getYears();
	        } else {
	            return 0;
	        }
	    }
		public void propertyChange(PropertyChangeEvent arg0) {
			String date = ((JTextField) datengaySinh.getDateEditor().getUiComponent()).getText();
			if(!date.equalsIgnoreCase("")) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				if(calculateAge(LocalDate.parse(date, formatter), LocalDate.now()) < 18) {
					JOptionPane.showMessageDialog(null, "Khách hàng chưa đủ 18 tuôi!");
					datengaySinh.setDate(null);
				}
			}
		}
	});
		panel_6.add(datengaySinh);
		
		JLabel lblgioiTinh = new JLabel("Giới tính");
		lblgioiTinh.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblgioiTinh.setBounds(9, 147, 96, 32);
		panel_6.add(lblgioiTinh);
		
		String GT[] = {"Nam","Nữ"};
		JComboBox cbgioiTinh = new JComboBox(GT);
		cbgioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbgioiTinh.setBounds(138, 152, 156, 29);
		panel_6.add(cbgioiTinh);
		
		JLabel lbldiaChi = new JLabel("Địa chỉ");
		lbldiaChi.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbldiaChi.setBounds(505, 72, 68, 23);
		panel_6.add(lbldiaChi);
		
		txtdiaChi = new JTextField();
		txtdiaChi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtdiaChi.setBounds(638, 71, 275, 24);
		panel_6.add(txtdiaChi);
		
		txtdiaChi.setColumns(10);
		
		JLabel lblemail = new JLabel("Email");
		lblemail.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblemail.setBounds(506, 114, 68, 20);
		panel_6.add(lblemail);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmail.setBounds(639, 113, 275, 27);
		panel_6.add(txtEmail);
		txtEmail.setColumns(20);
		
		JLabel lblchucVu = new JLabel("Chức vụ");
		lblchucVu.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblchucVu.setBounds(505, 158, 96, 21);
		panel_6.add(lblchucVu);
		
		ArrayList<ChucVu> dsCV = nhanVienFacade.getAllChucVus();
		@SuppressWarnings("rawtypes")
		JComboBox cbchucVu = new JComboBox();
		cbchucVu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbchucVu.setBounds(638, 154, 275, 30);
		for (ChucVu cv : dsCV) {
			cbchucVu.addItem(cv.getTenChucVu());
		}
		panel_6.add(cbchucVu);
		
		JLabel lblngayVaoLam = new JLabel("Ngày Vào Làm");
		lblngayVaoLam.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblngayVaoLam.setBounds(1019, 75, 137, 21);
		panel_6.add(lblngayVaoLam);
		
		datengayVaoLam = new JDateChooser();		
		datengayVaoLam.setDate(Date.valueOf(LocalDate.now()));
		datengayVaoLam.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 15));
		datengayVaoLam.setFont(new Font("Tahoma", Font.PLAIN, 15));
		datengayVaoLam.setBounds(1192, 66, 270, 30);
		datengayVaoLam.setDateFormatString("yyy-MM-dd");
		panel_6.add(datengayVaoLam);
		
		JLabel lblsdt = new JLabel("Số Điện Thoại");
		lblsdt.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblsdt.setBounds(1019, 21, 119, 26);
		panel_6.add(lblsdt);
		
		txtSdt = new JTextField();
		txtSdt.setDocument(new JTextFieldLimit(10));
		txtSdt.addKeyListener(new KeyAdapter() {
			public boolean sdt(String str) {
				return str.matches("\\d*");
			}
			@Override
			public void keyReleased(KeyEvent e) {
				if(!sdt(txtSdt.getText())) 
					txtSdt.setForeground(Color.red);
				else
					txtSdt.setForeground(Color.BLACK);
				if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE||e.getKeyCode()==KeyEvent.VK_DELETE)
		        {
		           
		        }
				else
				{   
		            String to_check=txttenNV.getText();
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
		            }
		        }
				  
			}
		});
		txtSdt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSdt.setBounds(1192, 20, 270, 27);
		panel_6.add(txtSdt);
		txtSdt.setColumns(10);
		
		JLabel lblCmnd = new JLabel("CMND");
		lblCmnd.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCmnd.setBounds(506, 22, 68, 25);
		panel_6.add(lblCmnd);
		
		txtcmnd = new JTextField();
		txtcmnd.setDocument(new JTextFieldLimit(12));
		txtcmnd.addKeyListener(new KeyAdapter() {
			public boolean cmnd(String str) {
				  return str.matches("\\d*");  //match a number with optional '-' and decimal. "-?\\d+(\\.\\d+)?"
				}
			@Override
			public void keyReleased(KeyEvent e) {
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
		            }
		        }
				
			}
		});
		txtcmnd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtcmnd.setBounds(639, 21, 275, 27);
		panel_6.add(txtcmnd);
		txtcmnd.setColumns(10);
		
		txtdiaChi.addKeyListener(new KeyAdapter() {
			public boolean sdt(String str) {
				return str.matches("^[0-9a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ\\\" +\\r\\n\" + \r\n" + 
						"				\"	            \\\"ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ\\\" +\\r\\n\" + \r\n" + 
						"				\"	            \\\"ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\\\\\\\s/\\\\\\\\.,]+$");
			}
			@Override
			public void keyReleased(KeyEvent e) {
				if(!sdt(txtdiaChi.getText())) 
					txtdiaChi.setForeground(Color.red);
				else
					txtdiaChi.setForeground(Color.BLACK);
				if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE||e.getKeyCode()==KeyEvent.VK_DELETE)
		        {
		           
		        }
				else
				{   
		            String to_check=txttenNV.getText();
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
		            }
		        }
				  
			}
		});
//		table = new JTable();
//		table.setBackground(new Color(255, 255, 255));
//		scrollPane.setViewportView(table);
//		table.setModel(new DefaultTableModel(
//			new Object[][] {
//				{null, null, null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null, null, null},
//			},
//			new String[] {
//				"M\u00E3 nh\u00E2n vi\u00EAn", "T\u00EAn nh\u00E2n vi\u00EAn", "Ng\u00E0y sinh", "Gi\u1EDBi sinh", "Email", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "\u0110\u1ECBa ch\u1EC9", "Ch\u1EE9c v\u1EE5", "Ng\u00E0y v\u00E0o l\u00E0m"
//			}
//		));
		table = new JTable(){
		       @Override
		       public boolean isCellEditable(int i, int i1) {
		           return false; //To change body of generated methods, choose Tools | Templates.
		       }
			};
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 427, 1482, 285);
		panel.add(scrollPane);
		scrollPane.setViewportView(table);
		String[] header=  {"Mã Nhân Viên","Tên Nhân Viên","CMND","Ngày Sinh","Giới Tính","Địa Chỉ","Email","Số Điện Thoại","Ngày Vào Làm","Chức vụ",};
		tableModel = new DefaultTableModel(header, 0);
		table.setModel(tableModel);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=table.getSelectedRow();
				txtmaNV.setText(tableModel.getValueAt(i, 0).toString().trim());
				txttenNV.setText(tableModel.getValueAt(i, 1).toString().trim());
				txtcmnd.setText(tableModel.getValueAt(i, 2).toString().trim());
				datengaySinh.setDate(Date.valueOf(LocalDate.parse(tableModel.getValueAt(i, 3).toString().trim()))); 
				cbgioiTinh.setSelectedItem(tableModel.getValueAt(i, 4).toString().trim());
				txtdiaChi.setText(tableModel.getValueAt(i, 5).toString().trim());
				txtEmail.setText(tableModel.getValueAt(i, 6).toString().trim());
				txtSdt.setText(tableModel.getValueAt(i, 7).toString().trim());
				cbchucVu.setSelectedItem(tableModel.getValueAt(i, 9).toString().trim());
				datengayVaoLam.setDate(Date.valueOf(LocalDate.parse(tableModel.getValueAt(i, 8).toString())));
			}
		});
		loadNV();
		
	
		table.setRowHeight(20);
		table.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));

		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new TitledBorder(null, "T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_8.setBounds(10, 334, 683, 69);
		panel_8.setBackground(SystemColor.control);
		
		JLabel lblNhpThngTin = new JLabel("Nhập số CMND hoặc số điện thoại của  nhân viên");
		lblNhpThngTin.setBounds(22, 18, 374, 30);
		lblNhpThngTin.setBackground(new Color(255, 228, 225));
		lblNhpThngTin.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		txtTimKiem = new JTextField();
		txtTimKiem.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(txtTimKiem.getText().length()==0) {
					try {
						loadNV();
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
				if(txtTimKiem.getText().length()>0) {
					try {
						timNV();
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
		txtTimKiem.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			//	if ((txtTimKiem.getText().length() < 0)) {
			//		txtTimKiem.setForeground(Color.red);
			//	}
				if (!(txtTimKiem.getText().matches("^[0-9 ]+$"))) {
					txtTimKiem.setForeground(Color.red);
				} else {
					txtTimKiem.setForeground(Color.black);
				}
			}
		});
	
		txtTimKiem.setBounds(433, 21, 240, 30);
		txtTimKiem.setColumns(10);
		panel_3.setLayout(null);
//		txtdiaChi.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyPressed(KeyEvent e) {
//			//	if ((txtTimKiem.getText().length() < 0)) {
//			//		txtTimKiem.setForeground(Color.red);
//			//	}
//				if (!(txtdiaChi.getText().matches("^[0-9a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ\" +\r\n" + 
//						"	            \"ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ\" +\r\n" + 
//						"	            \"ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\\\s/\\\\.,]+$"))) {
//					txtdiaChi.setForeground(Color.red);
//				} else {
//					txtTimKiem.setForeground(Color.black);
//				}
//			}
//		});
		
		//panel_4.setLayout(gl_panel_4);
		panel.setLayout(null);
		panel.add(panel_3);
		panel.add(panel_8);
		panel_8.setLayout(null);
		panel_8.add(lblNhpThngTin);
		panel_8.add(txtTimKiem);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Chức năng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(768, 334, 724, 69);
		panel.add(panel_4);
		panel_4.setBackground(SystemColor.control);
		
		
		
		
		
		
		//Thêm
		JButton btnThem = new JButton("Thêm");
		btnThem.setBackground(Color.GREEN);
		btnThem.setBounds(43, 16, 123, 38);
		btnThem.setIcon(new ImageIcon("img1/add.png"));
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnThem.setToolTipText("");
		btnThem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if(validData()) {
						String cb =null;
						String date1  = ((JTextField)datengaySinh.getDateEditor().getUiComponent()).getText();
						String date2  = ((JTextField)datengayVaoLam.getDateEditor().getUiComponent()).getText();
						
						String ma= txtmaNV.getText();
						String ten=txttenNV.getText();
						String diachi=txtdiaChi.getText();
						String email= txtEmail.getText();
						String sodt= txtSdt.getText();
						String cmnd = txtcmnd.getText();
						//ChucVu AAA= nhanVienFacade.getMaChucVu((String) cbchucVu.getSelectedItem());
						
						if(date1.equalsIgnoreCase(""))
							JOptionPane.showMessageDialog(null, "Ngày sinh không được để trống!");
						else {
							for (ChucVu ss : dsCV) {
								if(ss.getTenChucVu()==(String) cbchucVu.getSelectedItem()) {
									Date ngaySinh=Date.valueOf(LocalDate.parse(date1));
									Date ngayVaoLam =Date.valueOf(LocalDate.parse(date2));
									String gioiTinh = (String) cbgioiTinh.getSelectedItem();
									NhanVien nv= new NhanVien(ma, ten, cmnd, gioiTinh, ngaySinh, diachi, email, sodt, ngayVaoLam);
									nv.setChucVu(ss);
									nhanVienFacade.themNhanVien(nv);
								}
							}
							//NhanVien nhanVien = new NhanVien("NV_0006", "Nam", "123456789227", "Nam", new Date(2000, 10, 10), "Go Vap", "nam@gmail.com" , "0350043229", new Date(2020, 10, 10));
							//nhanVien.setChucVu(VVV);
//							tableModel.addRow(new Object[] {nv.getMaNhanVien(),nv.getTenNhanVien(),nv.getCMND(),nv.getNgaySinh(),nv.getGioiTinh(),nv.getDiaChi(),nv.getEmail(),nv.getSdt()
//									,nv.getNgayVaoLam(),AAA.getTenChucVu()});						
							JFrame f= new JFrame();
							JOptionPane.showMessageDialog(f, "Thêm thành công nhân viên!!!");
							table.setModel(nhanVienFacade.getAllNV());
							}
						//NhanVien nv = dao_nv.getAllNV();
//						ArrayList<NhanVien> dsnv = dao_nv.getListMaNV();
//						for (NhanVien nv : dsnv) {
//							if (nv.getMaNhanVien().equalsIgnoreCase(txtmaNV.getText())) {
//								return false;
//							}
//						}
//						
						}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		
			
			//Xóa
			JButton btnXoa = new JButton("Xóa");
			btnXoa.setBackground(Color.RED);
			btnXoa.setBounds(217, 16, 123, 38);
			btnXoa.setIcon(new ImageIcon("icon/delete.png"));
			btnXoa.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int row=table.getSelectedRow();
					try {
						if(row!=-1) {
							JFrame f= new JFrame();
							int hoi=JOptionPane.showConfirmDialog(f, "Nhân viên sẽ bị xóa","Chú ý",JOptionPane.YES_NO_OPTION);
							if(hoi==JOptionPane.YES_OPTION) {
								try {
									if(xoaNV()){
										txtcmnd.setText("");
										txtdiaChi.setText("");
										txtEmail.setText("");
										cbgioiTinh.setSelectedItem(0);
										txtSdt.setText("");
										cbchucVu.setSelectedItem(0);
										datengaySinh.setCalendar(null);
										txttenNV.setText("");
										txttenNV.requestFocus();
										//tableModel.removeRow(row);
										table.setModel(nhanVienFacade.getAllNV());
									}
									else {
										JOptionPane.showMessageDialog(null, "Không thể xóa nhân viên này !!!");
									}
								} catch (Exception e2) {
									JOptionPane.showMessageDialog(null, "Không thể xóa nhân viên này !!!");
								}
								
								
								
							}
						}
						else
							JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên cấp để xóa");
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Không thể xóa nhân viên này !!!");
					}
				}
			});
			btnXoa.setFont(new Font("Tahoma", Font.BOLD, 15));
			
			JButton btnLamMoi = new JButton("Làm mới");
			btnLamMoi.setBackground(new Color(255,190,87));
			btnLamMoi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			Date ngayhientai = Date.valueOf(LocalDate.now());
			btnLamMoi.setBounds(555, 16, 135, 38);
			btnLamMoi.setIcon(new ImageIcon("img1/refresh.png"));
			btnLamMoi.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						HoaDonFacade hoaDonFacade = (HoaDonFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/hoaDonFacade");
						String maKH = hoaDonFacade.getMaHDTail("maNhanVien", "NhanVien");
						txtmaNV.setText(maKH);
						txttenNV.setText("");
						txtdiaChi.setText("");
						txtEmail.setText("");
						txtSdt.setText("");
					//	cbchucVu.setSelectedIndex(-1);
						datengaySinh.setDate(null);
					
						txtcmnd.setText("");
					//	cbgioiTinh.setSelectedIndex(-1);
						((JTextField) datengayVaoLam.getDateEditor().getUiComponent()).setText(ngayhientai.toString());
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
			btnLamMoi.setFont(new Font("Tahoma", Font.BOLD, 15));
			
			//Sửa
			JButton btnSua = new JButton("Sửa");
			btnSua.setBackground(Color.BLUE);
			btnSua.setBounds(389, 16, 123, 38);
			btnSua.setIcon(new ImageIcon(("img1/update.png")));
			btnSua.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int row=table.getSelectedRow();
					String date1  = ((JTextField)datengaySinh.getDateEditor().getUiComponent()).getText();		
					String date2  = ((JTextField)datengayVaoLam.getDateEditor().getUiComponent()).getText();
					try {
						if(validData()) {
						if(row!=-1) {
							JFrame f= new JFrame();
							int hoi=JOptionPane.showConfirmDialog(f, "Nhân viên này sẽ được cập nhật","Chú ý",JOptionPane.YES_NO_OPTION);
							if(hoi==JOptionPane.YES_OPTION) {
								String ma= txtmaNV.getText();
								String cmnd = txtcmnd.getText();
								String ten=txttenNV.getText();
								String diachi=txtdiaChi.getText();
								String email= txtEmail.getText();
								String sodt= txtSdt.getText();
								String chucVu = (String) cbchucVu.getSelectedItem();
								Date ngaySinh=Date.valueOf(LocalDate.parse(date1));
								Date ngayVaoLam =Date.valueOf(LocalDate.parse(date2));
								String gioiTinh = (String) cbgioiTinh.getSelectedItem();
								String maChucVu="";
								if (chucVu.equalsIgnoreCase("Quản Lý"))
									maChucVu = "CV_0001";
								else
									maChucVu = "CV_0002";
								//NhanVien nv= new NhanVien(ma, ten, cmnd, gioiTinh, ngaySinh, diachi, email, new ChucVu(maChucVu), sodt, ngayVaoLam);
								NhanVien nhanVien = nhanVienFacade.layNhanVienById(ma);
								nhanVien.setTenNhanVien(ten);
								nhanVien.setCMND(cmnd);
								nhanVien.setDiaChi(diachi);
								nhanVien.setEmail(email);
								nhanVien.setSdt(sodt);
								nhanVien.setNgaySinh(ngaySinh);
								nhanVien.setNgayVaoLam(ngayVaoLam);
								nhanVien.setGioiTinh(gioiTinh);
								nhanVienFacade.capnhatNhanVien(nhanVien);
								//loadNV();
								table.setModel(nhanVienFacade.getAllNV());
								JOptionPane.showMessageDialog(null, "Cập nhật nhân viên thành công");
							}
						}
						}
						else
							JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên để chỉnh sửa thông tin");
					} catch (Exception e2) {
						e2.printStackTrace();
					}
					
					
				}
			});
			panel_4.setLayout(null);
			btnSua.setFont(new Font("Tahoma", Font.BOLD, 15));
			panel_4.add(btnSua);
			panel_4.add(btnThem);
			panel_4.add(btnXoa);
			panel_4.add(btnLamMoi);
			
			JLabel lblNewLabel_1 = new JLabel("QUẢN LÝ NHÂN VIÊN");
			lblNewLabel_1.setForeground(new Color(184, 134, 11));
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
			lblNewLabel_1.setBounds(7, 6, 391, 72);
			panel.add(lblNewLabel_1);
	}
	//Hàm Load
	private boolean validNhanVien() {
		if(txtcmnd.getText().length()>0) {
			JOptionPane.showConfirmDialog(null, "Chứng minh nhân dẫn không được để trống");
			return false;
		}
		if(txttenNV.getText().length()>0) {
			JOptionPane.showConfirmDialog(null, "Tên nhân viên khônng được để trống");
			return false;
		}
		if(txtdiaChi.getText().length()>0) {
			JOptionPane.showConfirmDialog(null, "Địa chỉ không được để trống");
			return false;
		}
		if(txtEmail.getText().length()>0) {
			JOptionPane.showConfirmDialog(null, "Email không được để trống");
			return false;
		}
		if(txtSdt.getText().length()>0) {
			JOptionPane.showConfirmDialog(null, "Địa chỉ không được để trống");
			return false;
		}
		if(txtGT.getText().length()>0) {
			JOptionPane.showConfirmDialog(null, "Địa chỉ không được để trống");
			return false;
		}
		String diaChi = txtdiaChi.getText();
		if(! diaChi.matches("^[a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ\" +\r\n" + 
				"            \"ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ\" +\r\n" + 
				"            \"ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\\\s]+$")){
			JOptionPane.showMessageDialog(null, "Địa chỉ không chứa kí tự đặc biệt " );
			return false;
	            }
//		LocalDate ngaysinh;
//		if(!datengaysinh.contentEquals("")) {
//			ngaysinh= LocalDate.parse(ngaysinh);
//			if(!(ngaysinh.length()>0 && fngaysinh.compareTo(fngaygn)<0)){
//				JOptionPane.showMessageDialog(null, "ngày sinh không được trống và trước ngày gia nhập " );
//				return false;
//			}
//		}
		String date  = ((JTextField)datengaySinh.getDateEditor().getUiComponent()).getText();
		Date ngay=Date.valueOf(LocalDate.parse(date));
		if(ngay.after(Date.valueOf(LocalDate.now()))) {
			
			JOptionPane.showMessageDialog(null, "Ngày sinh phải trước ngày hiện tại" );
			return false;
		}
		String date1  = ((JTextField)datengayVaoLam.getDateEditor().getUiComponent()).getText();
		Date datengayVaoLam=Date.valueOf(LocalDate.parse(date));
		if(ngay.after(Date.valueOf(LocalDate.now()))) {
			
			JOptionPane.showMessageDialog(null, "Ngày vào làm  phải trước ngày hiện tại" );
			return false;
		}
	
		return true;
		
	}
	private boolean validData() {
		String tenNV = txttenNV.getText();
		String cmnd = txtcmnd.getText();
		String diaChi = txtdiaChi.getText();
		String email = txtEmail.getText();
		String sdt = txtSdt.getText();
		if(!(tenNV.length()>0)){

			JOptionPane.showMessageDialog(null, "Tên nhân viên không trống " );
		
			return false;
		}
//		}
		if(!(cmnd.length()>0 && cmnd.matches("\\d{12}"))) {
			JOptionPane.showMessageDialog(null, "Chứng minh nhân dân gồm  12 số");
			return false;
		}
		if(!(diaChi.length()>0)) {
			JOptionPane.showMessageDialog(null, "Địa chỉ không được để trống " );
			return false;
		}
		if(! diaChi.matches("^[0-9a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ\" +\r\n" + 
				"	            \"ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ\" +\r\n" + 
				"	            \"ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\\\s/\\\\.,]+$")){
			JOptionPane.showMessageDialog(null, "Địa chỉ không hợp lệ " );
			return false;
	            }
		if(!(email.length()>0 )) {
			JOptionPane.showMessageDialog(null, "Email không được để trống");
			return false;
		}
		if( !email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
			JOptionPane.showMessageDialog(null, "Sai cú pháp");
			return false;
		}
		if(!(sdt.length()>0 )) {
			JOptionPane.showMessageDialog(null, "Số điện thoại không được bỏ trống");
			return false;
		}
		if(!(sdt.matches("^[0][1-9][0-9]{8}$"))) {
			JOptionPane.showMessageDialog(null, "Số điện thoại gồm 10 kí tự số và bắt đầu từ kí tự 0");
			return false;
		}
		return rootPaneCheckingEnabled;
		
	}
	private void loadNV() throws SQLException, MalformedURLException, RemoteException, NotBoundException {
		NhanVienFacade nhanVienFacade = (NhanVienFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/nhanVienFacade");
		//Dao_NhanVien dao_nv = new Dao_NhanVien();
		tableModel = nhanVienFacade.getAllNV();
		table.setModel(tableModel);
	}
	//Hàm Xóa
	private boolean xoaNV() throws SQLException, MalformedURLException, RemoteException, NotBoundException {
		NhanVienFacade nhanVienFacade = (NhanVienFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/nhanVienFacade");
		//dao_nv = new Dao_NhanVien();	
		if(nhanVienFacade.xoaNhanVien(txtmaNV.getText()))
			return true;
		return false;
	//	loadNV();
	}
	//Tìm kiếm
		private void timNV() throws SQLException, MalformedURLException, RemoteException, NotBoundException{
			NhanVienFacade nhanVienFacade = (NhanVienFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/nhanVienFacade");
			//Dao_NhanVien dao_nv= new Dao_NhanVien();
			tableModel = nhanVienFacade.timKiem("%"+txtTimKiem.getText()+"%", "%"+txtTimKiem.getText()+"%");
			table.setModel(tableModel);
		}
//		public boolean KiemTraMa() {
//			ArrayList<NhanVien> dsnv = dao_nv.get;
//			for (Xe xe : dsxe) {
//				if (xe.getMaXe().equalsIgnoreCase(txtMa.getText())) {
//					return false;
//				}
//			}
//			return true;
//		}
//	private void update() {
//		for(int i =0 ; i<table.getRowCount();i++) {
//			if(txtmaNV.getText().equalsIgnoreCase(table.getValueAt(i, 0).toString())) {
//				table.setValueAt(txttenNV.getText(),i, 1);
//				table.setValueAt(txtcmnd.getText(), i, 2);
//				table.setValueAt(txtGT.getText(),i ,3);
//				table.setValueAt(txtdiaChi.getText(), i, 4);
//				table.setValueAt(txtEmail.getText(), i, 5);
//				table.setValueAt(txtSdt.getText(), i, 6);
//				table.setValueAt(cbChuc)
//			}
//	}
//}
}
