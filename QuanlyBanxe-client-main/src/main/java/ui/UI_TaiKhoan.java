package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import java.awt.Panel;
import javax.swing.JTextField;
import java.awt.TextField;
import java.awt.Label;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

import java.awt.Component;
import java.awt.Choice;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Button;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import businesslogic.facade.NhanVienFacade;
import entity.TaiKhoan;
import entity.ChucVu;
import entity.NhanVien;

import javax.swing.JScrollPane;
import java.awt.TextArea;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.TitledBorder;

public class UI_TaiKhoan extends JFrame {

	private JPanel pAccount;
	private JTable table;

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
					UI_TaiKhoan frame = new UI_TaiKhoan();
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
	 * @throws RemoteException 
	 * @throws NotBoundException 
	 * @throws MalformedURLException 
	 */
	public UI_TaiKhoan() throws SQLException, RemoteException, MalformedURLException, NotBoundException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();
		setBounds(0, 0, width, height);
		pAccount = new JPanel();
		pAccount.setBackground(SystemColor.control);
		pAccount.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pAccount);
		pAccount.setLayout(null);
		NhanVienFacade nhanVienFacade = (NhanVienFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/nhanVienFacade");

		List<String> list_MaNV = nhanVienFacade.getListMaNV();
		JPanel pAccountInfo = new JPanel();
		pAccountInfo.setBorder(new TitledBorder(null, "Th\u00F4ng tin t\u00E0i kho\u1EA3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pAccountInfo.setBackground(SystemColor.control);
		pAccountInfo.setBounds(5, 106, 910, 165);
		pAccount.add(pAccountInfo);
		pAccountInfo.setLayout(null);
		
		JPanel pAccountInfoDetails = new JPanel();
		pAccountInfoDetails.setBackground(SystemColor.control);
		pAccountInfoDetails.setBounds(10, 26, 890, 123);
		pAccountInfo.add(pAccountInfoDetails);
		pAccountInfoDetails.setLayout(null);
			
		JLabel lblEmployeeName_Acc = new JLabel("Mã Nhân Viên");
		lblEmployeeName_Acc.setBounds(5, 10, 120, 21);
		pAccountInfoDetails.add(lblEmployeeName_Acc);
		lblEmployeeName_Acc.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmployeeName_Acc.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JTextField txtEmployeeNum_Acc = new JTextField();
		txtEmployeeNum_Acc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmployeeNum_Acc.setEditable(false);
		txtEmployeeNum_Acc.setBounds(148, 10, 220, 23);
		pAccountInfoDetails.add(txtEmployeeNum_Acc);
		
		JLabel lblNewLabel = new JLabel("Tên Nhân Viên");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(396, 10, 120, 20);
		pAccountInfoDetails.add(lblNewLabel);
		
		JTextField txtEmployeeName_Acc = new JTextField();
		txtEmployeeName_Acc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmployeeName_Acc.setEditable(false);
		txtEmployeeName_Acc.setBounds(535, 10, 345, 25);
		pAccountInfoDetails.add(txtEmployeeName_Acc);
		
		JLabel lblPassword_Acc = new JLabel("Mật Khẩu");
		lblPassword_Acc.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPassword_Acc.setBounds(5, 50, 103, 21);
		pAccountInfoDetails.add(lblPassword_Acc);
		
		JTextField txtPassword_Acc = new JTextField();
		txtPassword_Acc.setBounds(148, 48, 220, 25);
		txtPassword_Acc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pAccountInfoDetails.add(txtPassword_Acc);
		
		JLabel lblPower_Acc = new JLabel("Quyền");
		lblPower_Acc.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPower_Acc.setBounds(5, 90, 115, 21);
		pAccountInfoDetails.add(lblPower_Acc);
		
		JComboBox cbbQuyen = new JComboBox();
		cbbQuyen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbbQuyen.setBackground(Color.WHITE);
		cbbQuyen.setModel(new DefaultComboBoxModel(new String[] {"Quản Lý", "Nhân Viên"}));
		cbbQuyen.setBounds(148, 88, 220, 25);
		pAccountInfoDetails.add(cbbQuyen);
		
		JLabel lblNote_Acc = new JLabel("Chú Thích");
		lblNote_Acc.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNote_Acc.setBounds(396, 50, 107, 21);
		pAccountInfoDetails.add(lblNote_Acc);
		
		JTextArea txtChuThich = new JTextArea();
		txtChuThich.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtChuThich.setBounds(535, 48, 345, 55);
		pAccountInfoDetails.add(txtChuThich);
		
		JPanel pAccountList = new JPanel();
		pAccountList.setBounds(5, 281, 1525, 473);
		pAccount.add(pAccountList);
		pAccountList.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1525, 473);
		pAccountList.add(scrollPane);
		
		String[] header = {"STT", "Mã Nhân Viên", "Tên Nhân Viên", "Mật Khẩu", "Quyền", "Chú Thích"};
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		table = new JTable(tableModel);
		//table.setColumnSelectionAllowed(true);
		table.setForeground(Color.BLACK);
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		scrollPane.setViewportView(table);
		table.setModel(nhanVienFacade.getAllAccount(header, tableModel));
		table.setRowHeight(25);
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		table.getTableHeader().setBackground(new Color(50,205,50));
		table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JPanel pSearchAccount = new JPanel();
		pSearchAccount.setBorder(new TitledBorder(null, "Tìm kiếm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pSearchAccount.setBackground(SystemColor.control);
		pSearchAccount.setBounds(925, 106, 367, 165);
		pAccount.add(pSearchAccount);
		pSearchAccount.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.control);
		panel_1.setBounds(10, 26, 347, 121);
		pSearchAccount.add(panel_1);
		panel_1.setLayout(null);
		
		ButtonGroup group = new ButtonGroup();
		
		JRadioButton radEmployeeNumSearch = new JRadioButton("Mã Nhân Viên");
		radEmployeeNumSearch.setBounds(16, 6, 123, 25);
		group.add(radEmployeeNumSearch);
		panel_1.add(radEmployeeNumSearch);
		radEmployeeNumSearch.setSelected(true);
		radEmployeeNumSearch.setBackground(SystemColor.control);
		radEmployeeNumSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JRadioButton radEmpployeeNameSearch = new JRadioButton("Tên Nhân Viên");
		radEmpployeeNameSearch.setBounds(183, 8, 148, 25);
		group.add(radEmpployeeNameSearch);
		panel_1.add(radEmpployeeNameSearch);
		radEmpployeeNameSearch.setBackground(SystemColor.control);
		radEmpployeeNameSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblSearch_Acc = new JLabel("Nhập nội dung tìm kiếm");
		lblSearch_Acc.setBounds(88, 37, 175, 21);
		panel_1.add(lblSearch_Acc);
		lblSearch_Acc.setForeground(new Color(0, 128, 128));
		lblSearch_Acc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JTextField txtSearch_Acc = new JTextField();
		txtSearch_Acc.setBounds(16, 75, 321, 25);
		panel_1.add(txtSearch_Acc);
		
		JPanel pAccountFunction = new JPanel();
		pAccountFunction.setBorder(new TitledBorder(null, "Chức năng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pAccountFunction.setBackground(SystemColor.control);
		pAccountFunction.setBounds(1302, 106, 228, 165);
		pAccount.add(pAccountFunction);
		pAccountFunction.setLayout(null);
		
		JButton btnAdd_Acc = new JButton("Cấp Tài Khoản");
		btnAdd_Acc.setBackground(new Color(60, 179, 113));
		btnAdd_Acc.setBounds(19, 23, 193, 40);
		pAccountFunction.add(btnAdd_Acc);
		btnAdd_Acc.setFont(new Font("Dialog", Font.BOLD, 16));
	//	btnAdd_Acc.setIcon(new ImageIcon(UI_TaiKhoan.class.getResource("/image/add-user-icon.png")));
		
		JButton btnDelete_Acc = new JButton("Xóa Tài Khoản");
		btnDelete_Acc.setBackground(new Color(255, 0, 0));
		btnDelete_Acc.setBounds(19, 68, 193, 40);
		pAccountFunction.add(btnDelete_Acc);
		btnDelete_Acc.setFont(new Font("Dialog", Font.BOLD, 16));
	//	btnDelete_Acc.setIcon(new ImageIcon(UI_TaiKhoan.class.getResource("/image/remove-user-icon.png")));
		
		JButton btnResetPassword_Acc = new JButton("Đặt Lại Mật Khẩu");
		btnResetPassword_Acc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();				
				if(row < 0)
					JOptionPane.showMessageDialog(null, "Vui lòng chọn tài khoản!");
				else {
					String maNhanVien = table.getValueAt(row, 1).toString();
					String quyen = cbbQuyen.getSelectedItem().toString();
					String chuThich = txtChuThich.getText();
					try {
						NhanVien nhanvienaaa = nhanVienFacade.getNhanVienById("maNhanVien", maNhanVien);
						TaiKhoan taikhoan = new TaiKhoan(maNhanVien, "123456", quyen, chuThich);
						nhanvienaaa.setTaiKhoan(taikhoan);
						if(nhanVienFacade.capnhatNhanVien(nhanvienaaa)) {
							txtPassword_Acc.setText("12346");
							table.setValueAt("123456", row, 3);
							JOptionPane.showMessageDialog(null, "Đặt lại mật khẩu thành công");
						}
						else {
							JOptionPane.showMessageDialog(null, "Đặt lại mật khẩu không thành công!");
						}
					} catch (Exception e2) {
						e2.printStackTrace();
					}
					
				}
			}
		});
		btnResetPassword_Acc.setBackground(new Color(30, 144, 255));
		btnResetPassword_Acc.setBounds(19, 113, 193, 40);
		pAccountFunction.add(btnResetPassword_Acc);
		btnResetPassword_Acc.setFont(new Font("Dialog", Font.BOLD, 16));
//		btnResetPassword_Acc.setIcon(new ImageIcon(UI_TaiKhoan.class.getResource("/image/Reset-icon.png")));
		
		JLabel lblNewLabel_1 = new JLabel("Quản lý tài khoản");
		lblNewLabel_1.setForeground(new Color(184, 134, 11));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setBounds(5, 10, 439, 72);
		pAccount.add(lblNewLabel_1);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int viTriDongVuaBam = table.getSelectedRow();
				txtEmployeeNum_Acc.setText(table.getValueAt(viTriDongVuaBam, 1).toString());
				txtEmployeeName_Acc.setText(table.getValueAt(viTriDongVuaBam, 2).toString());
				if(table.getValueAt(viTriDongVuaBam, 3) == null) {
					txtPassword_Acc.setText("");
				}else {
					txtPassword_Acc.setText(table.getValueAt(viTriDongVuaBam, 3).toString());
				}
				if(table.getValueAt(viTriDongVuaBam, 5) ==null) {
					txtChuThich.setText("");
				}else {
					txtChuThich.setText(table.getValueAt(viTriDongVuaBam, 5).toString());
				}
				if(table.getValueAt(viTriDongVuaBam, 4) == null) {
					cbbQuyen.setSelectedIndex(-1);
				}else {
					String item = table.getValueAt(viTriDongVuaBam, 4).toString();
					int i;
					if (item.equalsIgnoreCase("Quản Lý"))
						i = 0;
					else 
						i = 1;
					cbbQuyen.setSelectedIndex(i);
				}
			}
		});
		
		txtEmployeeNum_Acc.addKeyListener(new KeyAdapter() {
			public boolean isNumeric(String str) {
				  return str.matches("^[N][V]_\\d+");  //match a number with optional '-' and decimal. "-?\\d+(\\.\\d+)?"
				}
			@Override
			public void keyReleased(KeyEvent e) {
				//char temp =  Character.toUpperCase(e.getKeyChar());
				//String employeeNum = txtEmployeeNum_Acc.getText() + temp;
				//txtEmployeeNum_Acc.setText(employeeNum);
				//txtEmployeeNum_Acc.setText(txtEmployeeNum_Acc.getText().toUpperCase());	
				if (isNumeric(txtEmployeeNum_Acc.getText())) {
					txtEmployeeNum_Acc.setForeground(Color.black);
					//Connection con = ConnectDB.getCon();
					//String sql = "select * from NhanVien where maNhanVien = ?";
					try {
						NhanVien nhanVien = nhanVienFacade.getNhanVienById("maNhanVien", txtEmployeeNum_Acc.getText());
						if(nhanVien !=null) {
							txtEmployeeName_Acc.setText(nhanVien.getTenNhanVien());
						}
						else {
							txtEmployeeName_Acc.setText("");
							txtPassword_Acc.setText("");
							txtChuThich.setText("");
						}
					} catch (Exception e3) {
						e3.printStackTrace();
					}
					
//						PreparedStatement pst = con.prepareStatement(sql);
//						pst.setString(1, txtEmployeeNum_Acc.getText());
//						ResultSet rs = pst.executeQuery();
//						if(rs.next()) {
//							txtEmployeeName_Acc.setText(rs.getString("tenNhanVien"));
//						}
//						else {
//							txtEmployeeName_Acc.setText("");
//							txtPassword_Acc.setText("");
//							txtChuThich.setText("");
//						}
				}
				else {
					txtEmployeeNum_Acc.setForeground(Color.red);
				}		
			}
		});
		
		// Thêm Tài Khoản
		
		btnAdd_Acc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtEmployeeName_Acc.getText().equalsIgnoreCase(""))
					JOptionPane.showMessageDialog(null, "Nhân viên không tồn tại");
				else {
					try {
						String maNhanVien = txtEmployeeNum_Acc.getText();
						String matKhau = txtPassword_Acc.getText();
						if (matKhau.equalsIgnoreCase(""))
							matKhau = "123456";
						String quyen = cbbQuyen.getSelectedItem().toString();
						String chuThich = txtChuThich.getText();
						//TaiKhoan taiKhoan = new TaiKhoan(new NhanVien(maNhanVien), matKhau, quyen, chuThich);
						TaiKhoan taikhoan = new TaiKhoan(maNhanVien, matKhau, quyen, chuThich);
						String tenNhanVien = txtEmployeeName_Acc.getText();
						//ChucVu chucVu = nhanVienFacade.getMaChucVu("CV_0002");
						//NhanVien nhanVien = new NhanVien(maNhanVien, "aa", "23232424", "Nam", new Date(2000, 12, 1), "Gò Vấp", "aa@gmail.com", chucVu, "0359943227", new Date(2020, 12, 1));
						NhanVien nhanVien = nhanVienFacade.layNhanVienById(maNhanVien);
						NhanVien nhanVien1 = nhanVienFacade.layNhanVienById(maNhanVien);
						nhanVien.setTaiKhoan(taikhoan);
						int stt = nhanVienFacade.getListMaNV().size();
						try {
							if(nhanVien1.getTaiKhoan() == null) {
								nhanVienFacade.capnhatNhanVien(nhanVien);
								//tableModel.addRow(new Object[] {stt+"",nhanVien.getMaNhanVien(), tenNhanVien,nhanVien.getTaiKhoan().getMatKhau(), nhanVien.getTaiKhoan().getQuyen(), nhanVien.getTaiKhoan().getChuThich()});
								table.setModel(nhanVienFacade.getAllAccount(header, tableModel));
								JOptionPane.showMessageDialog(null, "Tạo tài khoản thành công");
							}
							else {
								JOptionPane.showMessageDialog(null, "Nhân viên này đã có tài khoản");
							}
						} catch(Exception e1) {
							//JOptionPane.showMessageDialog(this, "Trung");
							System.out.println("Wrong!");
						}
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		});
		
		
		//Xóa tài khoản
		btnDelete_Acc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();	
				if (row < 0)
					JOptionPane.showMessageDialog(null, "Vui lòng chọn Tài Khoản cần xóa!");
				else {
					int luaChon = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa tài khoản này?", "Chú ý", JOptionPane.YES_NO_OPTION);
					if(luaChon==JOptionPane.YES_OPTION) {
						String maNhanVien = table.getValueAt(row, 1).toString();
						if(maNhanVien.equalsIgnoreCase(Login.txtuser.getText()))
							JOptionPane.showMessageDialog(null, "Tài khoản này đang thực thi không thể xóa!");
						else {
							try {
								NhanVien nhanVien = nhanVienFacade.layNhanVienById(maNhanVien);
								nhanVien.setTaiKhoan(null);
								if(nhanVienFacade.capnhatNhanVien(nhanVien)) {
									//tableModel.removeRow(row);
									table.setModel(nhanVienFacade.getAllAccount(header, tableModel));
									JOptionPane.showMessageDialog(null, "Xóa thành công!");
								}
								else {
									System.out.println("Wrong!");
								}
							} catch (HeadlessException | RemoteException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						
					}
					
				}
			}
		});
		
		//Tìm kiếm
		
		txtSearch_Acc.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(txtSearch_Acc.getText().equalsIgnoreCase(""))
					try {
						tableModel.getDataVector().removeAllElements();
						tableModel.fireTableDataChanged();
						table.setModel(nhanVienFacade.getAllAccount(header, tableModel));
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				else if (radEmployeeNumSearch.isSelected()) {
					tableModel.getDataVector().removeAllElements();
					tableModel.fireTableDataChanged();
					try {
						table.setModel(nhanVienFacade.getAccountById(header, tableModel, txtSearch_Acc.getText()));
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					tableModel.getDataVector().removeAllElements();
					tableModel.fireTableDataChanged();
					try {
						table.setModel(nhanVienFacade.getAccountByName(header, tableModel, txtSearch_Acc.getText()));
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
	}
}
