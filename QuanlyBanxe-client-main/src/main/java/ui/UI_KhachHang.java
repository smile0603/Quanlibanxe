package ui;
/*
* (C) Copyright 2020 IUH. All rights reserved.
*
* @author: nhathung
* @date: Nov 7, 2020
* @version: 1.0
*/

import java.awt.EventQueue;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;


import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.SystemColor;

import entity.KhachHang;

import com.toedter.calendar.JDateChooser;

import businesslogic.facade.HoaDonFacade;
import businesslogic.facade.KhachHangFacade;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.beans.PropertyChangeEvent;
import javax.swing.border.LineBorder;

public class UI_KhachHang extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtmaKh;
	private JTextField txttenKh;
	private JTextField txtdiaChi;
	private JTextField txtEmail;
	private JTextField txtchuThich;
	private JTextField txtsoDt;
	private JTable table;
	private JButton btnThem,btnXoa,btncapNhat,btnlamMoi;
	private JTextField txttimKiem;
	private DefaultTableModel tableModel;
	private JDateChooser dcngaySinh,dcngayGiaNhap;
	
	
	private KhachHangFacade khachHangFacade = (KhachHangFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/khachHangFacade");
	//private Dao_KhachHang dao_kh;
	private ArrayList<String> cmnd ;
	private JTextField txtCmnd;
	@SuppressWarnings("rawtypes")
	private JComboBox cbgioiTinh;
	private JLabel lblTngKhchHng;
	private JLabel lblTngKhchHng_1;
	private JLabel lblTngKhchHng_2;
	private JLabel txtTongkh;
	private JLabel txtTongkhnam;
	private JLabel txttongkhnu;
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
					UI_KhachHang frame = new UI_KhachHang();
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public UI_KhachHang() throws RemoteException, MalformedURLException, NotBoundException {
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
//		try {
//			ConnectDB.getInstance().connect();
//			
//		}catch(SQLException e1) {
//			e1.printStackTrace();
//		}
		setIconImage(Toolkit.getDefaultToolkit().getImage(UI_KhachHang.class.getResource("/image/customer.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(5, 5, screen.width, screen.height);
		contentPane = new JPanel();
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelTimkiem = new JPanel();
		panelTimkiem.setBorder(new LineBorder(SystemColor.controlShadow));
		panelTimkiem.setBackground(SystemColor.control);
		panelTimkiem.setBounds(793, 37, 715, 53);
		contentPane.add(panelTimkiem);
		panelTimkiem.setLayout(null);
		

		JLabel lbltimKiem = new JLabel("Nhập tên, số điện thoại, số CMND hoặc mã khách hàng cần tìm\r\n");
		lbltimKiem.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbltimKiem.setForeground(new Color(0, 0, 0));
		lbltimKiem.setBounds(10, 14, 403, 26);
		panelTimkiem.add(lbltimKiem);
		
		txttimKiem = new JTextField();
		txttimKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txttimKiem.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				if(txttimKiem.getText().length()==0) {
					try {
						loadKH();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NotBoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(txttimKiem.getText().length()>0) {
					try {
						timKhachHang();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NotBoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		txttimKiem.setBounds(423, 14, 270, 25);
		panelTimkiem.add(txttimKiem);
		txttimKiem.setColumns(10);
		
		JPanel panelthongTin = new JPanel();
		panelthongTin.setBorder(new TitledBorder(null, "Thông tin chi tiết", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelthongTin.setBackground(SystemColor.control);
		panelthongTin.setBounds(10, 483, 1055, 235);
		contentPane.add(panelthongTin);
		panelthongTin.setLayout(null);
		

		JLabel lbltenKh = new JLabel("Tên Khách Hàng");
		lbltenKh.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbltenKh.setBounds(524, 27, 104, 32);
		panelthongTin.add(lbltenKh);



		JLabel lblgioiTinh = new JLabel("Giới Tính");
		lblgioiTinh.setBackground(new Color(255, 248, 220));
		lblgioiTinh.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblgioiTinh.setHorizontalAlignment(SwingConstants.LEFT);
		lblgioiTinh.setBounds(20, 65, 88, 32);
		panelthongTin.add(lblgioiTinh);



		JLabel lblngaySinh = new JLabel("Ngày Sinh");
		lblngaySinh.setHorizontalAlignment(SwingConstants.LEFT);
		lblngaySinh.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblngaySinh.setBounds(20, 150, 104, 29);
		panelthongTin.add(lblngaySinh);



		JLabel lbldiaChi = new JLabel("Địa Chỉ");
		lbldiaChi.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbldiaChi.setBounds(524, 72, 63, 25);
		panelthongTin.add(lbldiaChi);


		
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(524, 115, 63, 30);
		panelthongTin.add(lblEmail);
		

		JLabel lblsoDt = new JLabel("Số Điện Thoại");
		lblsoDt.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblsoDt.setBounds(20, 114, 104, 19);
		panelthongTin.add(lblsoDt);

		JLabel lblchuThich = new JLabel("Chú Thích");
		lblchuThich.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblchuThich.setBounds(524, 155, 88, 30);
		panelthongTin.add(lblchuThich);
		HoaDonFacade hoaDonFacade = (HoaDonFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/hoaDonFacade");
		//Dao_HoaDon dao_hd = new Dao_HoaDon();
		
		String maKH = hoaDonFacade.getMaHDTail("maKhachHang", "KhachHang");
		txtmaKh = new JTextField();
		txtmaKh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtmaKh.setText(maKH);
		txtmaKh.setEditable(false);
		txtmaKh.setBounds(127, 26, 276, 31);
		panelthongTin.add(txtmaKh);
		txtmaKh.setColumns(10);
		
		txttenKh = new JTextField();
		txttenKh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txttenKh.setBounds(638, 26, 342, 31);
		panelthongTin.add(txttenKh);
		txttenKh.setColumns(10);
		

		cbgioiTinh = new JComboBox();
		cbgioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbgioiTinh.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
		cbgioiTinh.setBounds(127, 71, 145, 31);
		panelthongTin.add(cbgioiTinh);

		
		txtdiaChi = new JTextField();
		txtdiaChi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtdiaChi.setBounds(638, 71, 342, 31);
		panelthongTin.add(txtdiaChi);
		txtdiaChi.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtEmail.setBounds(638, 113, 342, 30);
		panelthongTin.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtchuThich = new JTextField();
		txtchuThich.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtchuThich.setForeground(Color.BLACK);
		txtchuThich.setBackground(new Color(255, 255, 255));
		txtchuThich.setBounds(638, 154, 342, 31);
		panelthongTin.add(txtchuThich);
		txtchuThich.setColumns(10);
		
		txtsoDt = new JTextField();
		txtsoDt.setDocument(new JTextFieldLimit(12));
		txtsoDt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				if(!(txtsoDt.getText().matches("^[0][1-9][0-9]{8}$"))) {
					txtsoDt.setForeground(Color.red);
				}
				else {
					txtsoDt.setForeground(Color.black);
				}
			}
		});
		txtsoDt.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtsoDt.setBounds(127, 113, 276, 29);
		panelthongTin.add(txtsoDt);
		txtsoDt.setColumns(10);
		

		JLabel lblmaKh = new JLabel("Mã Khách Hàng");
		lblmaKh.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblmaKh.setBounds(20, 28, 98, 29);
		panelthongTin.add(lblmaKh);
		
		dcngaySinh = new JDateChooser();
		
		dcngaySinh.setBounds(127, 153, 145, 28);
		dcngaySinh.setDateFormatString("yyy/MM/dd");
		
		
		panelthongTin.add(dcngaySinh);
		
		JLabel lblCmnd = new JLabel("CMND");
		lblCmnd.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCmnd.setBounds(20, 199, 88, 25);
		panelthongTin.add(lblCmnd);
		
		txtCmnd = new JTextField();
		txtCmnd.setDocument(new JTextFieldLimit(13));
		txtCmnd.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
		
				if(!(txtCmnd.getText().matches("\\d{9}|\\d{12}") )) {
					txtCmnd.setForeground(Color.red);
				}
				else {
					txtCmnd.setForeground(Color.black);
				}
				
				
//				if(!(cmnd.length()>0 && cmnd.matches("\\d{9}|\\d{12}") )) {
//					JOptionPane.showMessageDialog(null, "Chứng minh nhân dân không để trống và phải có 9 chữ số và không được trùng " );
//					return false;
//				}
			}
		});
		txtCmnd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCmnd.setBounds(127, 196, 276, 28);
		panelthongTin.add(txtCmnd);
		txtCmnd.setColumns(10);
		
		JPanel panelchucNang = new JPanel();
		panelchucNang.setBorder(new TitledBorder(null, "Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelchucNang.setBackground(SystemColor.control);
		panelchucNang.setBounds(1094, 483, 414, 235);
		contentPane.add(panelchucNang);
		panelchucNang.setLayout(null);

		btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnXoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = table.getSelectedRow();
				try {
					if(row!=-1) {
						JFrame f= new JFrame();
						int hoi=JOptionPane.showConfirmDialog(f, "Khách hàng này sẽ bị xóa","Chú ý", JOptionPane.YES_NO_OPTION);
						if(hoi==JOptionPane.YES_OPTION) {
							int r = table.getSelectedRow();
							if(xoaKhachHang()) {
								tableModel.removeRow(r);
								txtmaKh.setText(maKH);
								txtchuThich.setText("");
								txtdiaChi.setText("");
								txtEmail.setText("");
								txtsoDt.setText("");
								txttenKh.setText("");
								txttimKiem.setText("");
								txtCmnd.setText("");
								cbgioiTinh.setSelectedIndex(0);
								dcngaySinh.setCalendar(null);
								txtTongkh.setText(String.valueOf(Integer.parseInt(txtTongkh.getText())-1));
								KhachHang kh = khachHangFacade.getKhachHangById("maKhachHang", txtmaKh.getText());
								if(kh.getGioiTinh().equalsIgnoreCase("Nam"))
									txtTongkhnam.setText(String.valueOf(Integer.parseInt(txtTongkhnam.getText())-1));
								else
									txttongkhnu.setText(String.valueOf(Integer.parseInt(txttongkhnu.getText())-1));
								txttenKh.requestFocus();
							}
							else
								JOptionPane.showMessageDialog(null, "Xóa khách hàng không thành công");
							
						}
					}
					else
						JOptionPane.showMessageDialog(null, "Vui lòng chọn khách hàng để xóa");
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnXoa.setIcon(new ImageIcon(UI_KhachHang.class.getResource("/image/Delete-group-icon.png")));
		btnXoa.setBackground(new Color(220, 20, 60));
		btnXoa.setBounds(225, 49, 137, 49);
		panelchucNang.add(btnXoa);
		
		
		btncapNhat = new JButton("Cập Nhật");
		btncapNhat.setFont(new Font("Tahoma", Font.BOLD, 13));
		btncapNhat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {; 
				int row = table.getSelectedRow();
				if(validData()) {
				try {
					if(row !=-1) {
						JFrame f = new JFrame();
						int hoi=JOptionPane.showConfirmDialog(f, "Khách Hàng '"+txttenKh.getText()+"' sẽ được cập nhật !!!","Chú ý ",JOptionPane.YES_NO_OPTION);
						if(hoi==JOptionPane.YES_OPTION) {
							String makH = txtmaKh.getText();
				    		String tenkH = txttenKh.getText();
				    		String cmnd = txtCmnd.getText();
				    		String gioiTinh = cbgioiTinh.getSelectedItem().toString();
				    		String date = ((JTextField) dcngaySinh.getDateEditor().getUiComponent()).getText();
				    		Date ngay = Date.valueOf(LocalDate.parse(date));
				    		String ngaygianhap = ((JTextField) dcngayGiaNhap.getDateEditor().getUiComponent()).getText();
				    		Date ngaygiaNhap = Date.valueOf(LocalDate.parse(ngaygianhap));
				    		
				    		String diachi = txtdiaChi.getText();
				    		String email = txtEmail.getText();
				    		String sodt = txtsoDt.getText();
				    		String ghiChu = txtchuThich.getText();
				    		KhachHang kh = new KhachHang(makH,tenkH,cmnd,gioiTinh,ngay,ngaygiaNhap,diachi,email,sodt,ghiChu);
				    		if(khachHangFacade.capnhatKhachHang(kh)) {
				    			//loadKH();
				    			update();
					    		JOptionPane.showMessageDialog(null, "Thay đổi thông tin thành công !!!");
				    		}
				    		txtmaKh.setText("");
							txtchuThich.setText("");
							txtdiaChi.setText("");
							txtEmail.setText("");
							txtsoDt.setText("");
							txttenKh.setText("");
							txttimKiem.setText("");
							txtCmnd.setText("");
							dcngaySinh.setCalendar(null);
							//dcngayGiaNhap.setCalendar(null);
							cbgioiTinh.setSelectedIndex(0);
							txttenKh.requestFocus();
//				    		try {
//				    			loadKH();
//				    		}catch(Exception e2) {
//				    			e2.printStackTrace();
//				    		}
						}
					}
					else
						JOptionPane.showMessageDialog(null, "Vui lòng chọn khách hàng cần cập nhật");
				}catch(Exception e2) {
					e2.printStackTrace();
					}
				}
			}
		});
		btncapNhat.setIcon(new ImageIcon(UI_KhachHang.class.getResource("/image/Male-user-edit-icon.png")));
		btncapNhat.setBackground(new Color(0, 0, 205));
		btncapNhat.setBounds(36, 126, 141, 49);
		panelchucNang.add(btncapNhat);
		
		btnlamMoi = new JButton("Làm Mới");
		btnlamMoi.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnlamMoi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtmaKh.setText(maKH);
				txtchuThich.setText("");
				txtdiaChi.setText("");
				txtEmail.setText("");
				txtsoDt.setText("");
				txttenKh.setText("");
				txttimKiem.setText("");
				txtCmnd.setText("");
				cbgioiTinh.setSelectedIndex(0);
				dcngaySinh.setCalendar(null);
				//dcngayGiaNhap.setCalendar(null);
				Date ngayhientai = Date.valueOf(LocalDate.now());
				((JTextField) dcngayGiaNhap.getDateEditor().getUiComponent()).setText(ngayhientai.toString());
				txttenKh.requestFocus();
			}
		});
		
		btnlamMoi.setIcon(new ImageIcon(UI_KhachHang.class.getResource("/image/refresh-icon.png")));
		btnlamMoi.setBackground(new Color(255, 127, 80));
		btnlamMoi.setBounds(225, 126, 137, 49);
		panelchucNang.add(btnlamMoi);
//		
		dcngaySinh.setDateFormatString("yyyy-MM-dd");		
		JLabel lblngayGiaNhap = new JLabel("Ngày Gia Nhập");
		lblngayGiaNhap.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblngayGiaNhap.setBounds(524, 196, 104, 28);
		panelthongTin.add(lblngayGiaNhap);
		//dcngaySinh.setDate(Date.valueOf(LocalDate.now()));
		dcngaySinh.addPropertyChangeListener(new PropertyChangeListener() {
			public int calculateAge(LocalDate birthDate, LocalDate currentDate) {
		        if ((birthDate != null) && (currentDate != null)) {
		            return Period.between(birthDate, currentDate).getYears();
		        } else {
		            return 0;
		        }
			}
			public void propertyChange(PropertyChangeEvent arg0) {
				String date = ((JTextField) dcngaySinh.getDateEditor().getUiComponent()).getText();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				if(!date.equalsIgnoreCase("")) {
					if(calculateAge(LocalDate.parse(date, formatter), LocalDate.now()) < 18) {
						JOptionPane.showMessageDialog(null, "Khách hàng chưa đủ 18 tuôi!");
						dcngaySinh.setDate(null);
					}
						
				}
			}
		});
		dcngayGiaNhap = new JDateChooser();
		dcngayGiaNhap.setBounds(638, 193, 183, 31);
		dcngayGiaNhap.setDateFormatString("yyyy-MM-dd");
		Date ngayhientai = Date.valueOf(LocalDate.now());
		((JTextField) dcngayGiaNhap.getDateEditor().getUiComponent()).setText(ngayhientai.toString());
		dcngayGiaNhap.setForeground(Color.RED);
//		
		//dcngayGiaNhap.setEnabled(false);
		dcngayGiaNhap.setFont(new Font("",Font.BOLD,12));
		panelthongTin.add(dcngayGiaNhap);
		
	    btnThem = new JButton("Thêm");
	    btnThem.setFont(new Font("Tahoma", Font.BOLD, 13));
	    btnThem.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent arg0) {
	    	 if(txttenKh.getText().trim().length()<=0) {
	    		 JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
	    	 }
	    	 if(validData()) {
	    		
	   
	    		String makH = txtmaKh.getText();
	    		String tenkH = txttenKh.getText();
	    		String cmnd = txtCmnd.getText();
	    		String gioiTinh = cbgioiTinh.getSelectedItem().toString();
	    		String date = ((JTextField) dcngaySinh.getDateEditor().getUiComponent()).getText();
	    		if(date.equalsIgnoreCase(""))
	    			JOptionPane.showMessageDialog(null, "Ngày sinh không được để trống!");
	    		else {
	    			try {
	    				Date ngay = Date.valueOf(LocalDate.parse(date));
			    		String dategn = ((JTextField) dcngayGiaNhap.getDateEditor().getUiComponent()).getText();
			    		Date ngaygiaNhap = Date.valueOf(LocalDate.parse(dategn));
			    		String diachi = txtdiaChi.getText();
			    		String email = txtEmail.getText();
			    		String sodt = txtsoDt.getText();
			    		String ghiChu = txtchuThich.getText();
			    		KhachHang kh1 = khachHangFacade.getKhachHangById("CMND", txtCmnd.getText());
			    		KhachHang kh = new KhachHang(makH,tenkH,cmnd,gioiTinh,ngay,ngaygiaNhap,diachi,email,sodt,ghiChu);
			    		if(kh1!=null)
			    			JOptionPane.showMessageDialog(null, "Trùng chứng minh nhân dân với khách hàng có mã số là " + kh1.getMaKhachHang());
			    			
			    		else {
			    			if(khachHangFacade.themKhachHang(kh))
				    		{
				    			String maKH = hoaDonFacade.getMaHDTail("maKhachHang", "KhachHang");
					    		JOptionPane.showMessageDialog(null, "Thêm khách hàng thành công");
					    		txtmaKh.setText(maKH);
								txtchuThich.setText("");
								txtdiaChi.setText("");
								txtEmail.setText("");
								txtsoDt.setText("");
								txttenKh.setText("");
								txtCmnd.setText("");
								txttimKiem.setText("");
								dcngaySinh.setCalendar(null);
								cbgioiTinh.setSelectedIndex(0);
								txtTongkh.setText(String.valueOf(Integer.parseInt(txtTongkh.getText())+1));
								if(kh.getGioiTinh().equalsIgnoreCase("Nam"))
									txtTongkhnam.setText(String.valueOf(Integer.parseInt(txtTongkhnam.getText())+1));
								else
									txttongkhnu.setText(String.valueOf(Integer.parseInt(txttongkhnu.getText())+1));
								txtmaKh.requestFocus();
								tableModel.addRow(new Object[] {kh.getMaKhachHang(),kh.getTenKhachHang(),kh.getCMND(),kh.getGioiTinh(),kh.getNgaySinh()+"",kh.getNgaygiaNhap()+"",kh.getDiaChi(),kh.getEmail(),kh.getSoDienThoai(),kh.getChuThich()});
				    		}
				    		else {
					    		 JOptionPane.showMessageDialog(null, "Thêm khách hàng không thành công!");
					    	 }
			    		}
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
		    		
	    		
	    		}
	    	 }
	    		     		
	    	}
	    });
		btnThem.setForeground(new Color(0, 0, 0));
		btnThem.setBackground(new Color(0, 128, 0));
		btnThem.setIcon(new ImageIcon(UI_KhachHang.class.getResource("/image/Male-user-add-icon.png")));
		btnThem.setBounds(36, 49, 141, 49);
		panelchucNang.add(btnThem);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 115, 1502, 310);
		contentPane.add(scrollPane);
		String[] header = {
				"Mã Khách Hàng", "Tên Khách Hàng","CMND", "Giới Tính", "Ngày Sinh", "Ngày Gia Nhập","Địa Chỉ", "Email", "Số Điện Thoại","Chú Thích"
		};
		tableModel = new DefaultTableModel(header,0);
		table = new JTable(tableModel);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				txtmaKh.setText(tableModel.getValueAt(i, 0).toString());
				txttenKh.setText(tableModel.getValueAt(i, 1).toString());
				txtCmnd.setText(tableModel.getValueAt(i, 2).toString());
				cbgioiTinh.setSelectedItem(tableModel.getValueAt(i, 3).toString());
				dcngaySinh.setDate(Date.valueOf(LocalDate.parse(tableModel.getValueAt(i, 4).toString())));
				dcngayGiaNhap.setDate(Date.valueOf(LocalDate.parse(tableModel.getValueAt(i, 5).toString())));
				txtdiaChi.setText(tableModel.getValueAt(i, 6).toString());
				txtEmail.setText(tableModel.getValueAt(i, 7).toString());
				txtsoDt.setText(tableModel.getValueAt(i, 8).toString());
				txtchuThich.setText(tableModel.getValueAt(i, 9).toString());
			}
		});
		
		//table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("QUẢN LÝ THÔNG TIN KHÁCH HÀNG");
		lblNewLabel_1.setForeground(new Color(184, 124, 12));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setBounds(10, 11, 497, 72);
		contentPane.add(lblNewLabel_1);
		try {
			loadKH();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		table.getColumnModel().getColumn(0).setPreferredWidth(31);
		table.getColumnModel().getColumn(3).setPreferredWidth(63);
		table.getColumnModel().getColumn(4).setPreferredWidth(74);
		table.setRowHeight(20);
		table.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblTngKhchHng = new JLabel("Tổng Số Khách Hàng");
		lblTngKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTngKhchHng.setBounds(21, 447, 145, 25);
		contentPane.add(lblTngKhchHng);
		
		lblTngKhchHng_1 = new JLabel("Tổng Số Khách Hàng Nam");
		lblTngKhchHng_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTngKhchHng_1.setBounds(408, 447, 187, 25);
		contentPane.add(lblTngKhchHng_1);
		
		lblTngKhchHng_2 = new JLabel("Tổng Số Khách Hàng Nữ");
		lblTngKhchHng_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTngKhchHng_2.setBounds(805, 447, 167, 25);
		contentPane.add(lblTngKhchHng_2);
		
		txtTongkh = new JLabel("");
		txtTongkh.setForeground(Color.BLUE);
		txtTongkh.setFont(new Font("Tahoma", Font.BOLD, 24));
		txtTongkh.setText(khachHangFacade.TongKhachHang()+"");
		txtTongkh.setBounds(176, 449, 189, 25);
		contentPane.add(txtTongkh);
		
		txtTongkhnam = new JLabel("");
		txtTongkhnam.setForeground(Color.RED);
		txtTongkhnam.setFont(new Font("Tahoma", Font.BOLD, 24));
		txtTongkhnam.setText(khachHangFacade.TongKhachNam()+"");
		txtTongkhnam.setBounds(605, 447, 141, 25);
		contentPane.add(txtTongkhnam);
		
		txttongkhnu = new JLabel("");
		txttongkhnu.setForeground(Color.GREEN);
		txttongkhnu.setFont(new Font("Tahoma", Font.BOLD, 24));
		txttongkhnu.setText(khachHangFacade.TongKhachNu()+"");
		txttongkhnu.setBounds(1020, 448, 141, 25);
		contentPane.add(txttongkhnu);
	} 
	//load
	private void loadKH() throws SQLException, MalformedURLException, RemoteException, NotBoundException {
		KhachHangFacade khachHangFacade = (KhachHangFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/khachHangFacade");
		//dao_kh = new Dao_KhachHang();
		tableModel= khachHangFacade.getAllKH();
		table.setModel(tableModel);
	}
	private void update() {
		for(int i =0 ; i<table.getRowCount();i++) {
			if(txtmaKh.getText().equalsIgnoreCase(table.getValueAt(i, 0).toString())) {
				table.setValueAt(txttenKh.getText(),i, 1);
				table.setValueAt(txtCmnd.getText(),i, 2);
				table.setValueAt(cbgioiTinh.getSelectedItem().toString(),i, 3);
				table.setValueAt(((JTextField) dcngaySinh.getDateEditor().getUiComponent()).getText(),i, 4);
				table.setValueAt(((JTextField) dcngayGiaNhap.getDateEditor().getUiComponent()).getText().toString(),i, 5);
				table.setValueAt(txtdiaChi.getText(),i, 6);
				table.setValueAt(txtEmail.getText(),i, 7);
				table.setValueAt(txtsoDt.getText(),i, 8);
				table.setValueAt(txtchuThich.getText(),i, 9);
				
			}
		}
	}
	private boolean xoaKhachHang() throws SQLException, MalformedURLException, RemoteException, NotBoundException{
		KhachHangFacade khachHangFacade = (KhachHangFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/khachHangFacade");
		//dao_kh = new Dao_KhachHang();
		if(khachHangFacade.xoaKhachHang(txtmaKh.getText()))
			return true;
		return false;
		//loadKH();
	}
	
	
	//Đếm số KhachHang
	private void timKhachHang() throws SQLException, MalformedURLException, RemoteException, NotBoundException {
		KhachHangFacade khachHangFacade = (KhachHangFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/khachHangFacade");
		//dao_kh = new Dao_KhachHang();
		tableModel = khachHangFacade.timKiem("%"+txttimKiem.getText()+"%");
		table.setModel(tableModel);
		
	}
	
	public ArrayList<String> xetCMND() throws MalformedURLException, RemoteException, NotBoundException {
		KhachHangFacade khachHangFacade = (KhachHangFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/khachHangFacade");
		cmnd = new ArrayList<String>();
		cmnd = (ArrayList<String>) khachHangFacade.getListCMND();
//		try {
//			ConnectDB.getInstance();
//			Connection con = ConnectDB.getCon();
//			String sql = "Select CMND from KhachHang";
//			Statement statement = con.createStatement();
//			ResultSet rs = statement.executeQuery(sql);
//			while (rs.next()) {
//				String CMND;
//				CMND = rs.getString(1);
//				cmnd.add(CMND);
//			}
//		}catch (SQLException e) { 
//			// TODO: handle exception
//			e.printStackTrace();
//		}
		return cmnd;
	}
	public boolean CMND(String cmnd) throws MalformedURLException, RemoteException, NotBoundException {
		List<String> list = xetCMND();
		for(String i:list) {
			if(i.equalsIgnoreCase(cmnd))
				return true;
		}
		return false;
	}
	
	private boolean validData(){
		
		String tenkh = txttenKh.getText().trim();
		String cmnd = txtCmnd.getText().trim();
		String diachi = txtdiaChi.getText().trim();
		String email = txtEmail.getText().trim();
		String sodt = txtsoDt.getText().trim();
		String ghichu = txtchuThich.getText().trim();
		String timkiem = txttimKiem.getText().trim();
		String ngaysinh = ((JTextField) dcngaySinh.getDateEditor().getUiComponent()).getText();
		//Date ngay = Date.valueOf(LocalDate.parse(ngaysinh));
		String ngaygianhap = ((JTextField) dcngayGiaNhap.getDateEditor().getUiComponent()).getText();
		LocalDate fngaygn = LocalDate.parse(ngaygianhap);

		if(!(tenkh.length()>0 && tenkh.matches("^[a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ\" +\r\n" + 
				"            \"ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ\" +\r\n" + 
				"            \"ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\\\s]+$"))) {
			JOptionPane.showMessageDialog(null, "Tên khách hàng không để trống và không chứa ký tự số hoặc các ký tự đặc biệt" );
			return false;
		}
		if(!(cmnd.length()>0 && cmnd.matches("\\d{9}|\\d{12}") )) {
			JOptionPane.showMessageDialog(null, "Chứng minh nhân dân không để trống và phải có 9 chữ số và không được trùng " );
			return false;
		}
		if(!(diachi.length()>0 && diachi.matches("^[0-9a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ" +
	            "ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ" +
	            "ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s/\\.,]+$"))) {
			JOptionPane.showMessageDialog(null, "Địa chỉ không trống và không chứa kí tự đặc biệt " );
			return false;
		}
		if(!(email.length()>0 && email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))) {
			JOptionPane.showMessageDialog(null, "Email không trống và phải hợp lệ " );
			return false;
		}
		if(!(sodt.length()>0 && sodt.matches("^[0][1-9][0-9]{8}$"))) {
			JOptionPane.showMessageDialog(null, "Số điện thoại không được trống và phải có 10 số " );
			return false;
		}
		if(!(ghichu.length()>0 && ghichu.matches("^[0-9a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ" +
	            "ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ" +
	            "ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s/\\.]+$"))) {
			JOptionPane.showMessageDialog(null, "Ghi chú không được trống và không chứa kí tự đặc biệt " );
			return false;
		}
		
		LocalDate fngaysinh;
		if(!ngaysinh.contentEquals("")) {
			fngaysinh= LocalDate.parse(ngaysinh);
			if(!(ngaysinh.length()>0 && fngaysinh.compareTo(fngaygn)<0)){
				JOptionPane.showMessageDialog(null, "ngày sinh không được trống và trước ngày gia nhập " );
				return false;
			}
		}
	
		
		return true;
	}
}


