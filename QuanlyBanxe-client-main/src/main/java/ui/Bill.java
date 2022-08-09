package ui;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import javax.swing.JTextArea;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Bill extends JFrame {

	private JPanel contentPane;
	public static JTextArea textArea;
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
					Bill frame = new Bill();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Bill() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 712, 577);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 11));
		textArea.setBounds(5, 5, 693, 535);
		textArea.append("\n 		CỬA HÀNG XE MÁY NAM THÀNH 		Ngày LHD  : " + LocalDate.now() + "\n");
		textArea.append("	    ---------------------------------------------------------------------\n\n");
		textArea.append("			Tên khách hàng      :  " + UI_HoaDon.txtCustomerName_Bill.getText() + "\n");
		textArea.append("			Chứng minh nhân dân :  " + UI_HoaDon.txtCMND_Bill.getText() + "\n");
		textArea.append("			Số điện thoại       :  " + UI_HoaDon.txtNumPhone_Bill.getText() + "\n");
		textArea.append("\n      ----------------------------------------------------------------------------------------\n");
		//"   |    Tên xe    |      Màu xe ở   |Phân Khối|     Số khung      |  Số máy  |   Thành tiền    |\n"
		textArea.append(String.format("   |%-14s|%-16s|%-9s|%-19s|%-10s|%-17s|\n", "    Tên xe    ", "      Màu xe    ", "Phân Khối", "     Số khung      ", "  Số máy  ", "   Thành tiền    "));
		textArea.append("      ----------------------------------------------------------------------------------------\n");
		
		int tableRowCount  = UI_HoaDon.table.getRowCount();
		String tenXe, mauXe, phanKhoi, soKhung, soMay, thanhTien;
		for(int i = 0; i<tableRowCount; i++) {
			tenXe = UI_HoaDon.table.getValueAt(i, 1).toString();
			mauXe = UI_HoaDon.table.getValueAt(i, 4).toString();
			phanKhoi = UI_HoaDon.table.getValueAt(i, 5).toString();
			soKhung = UI_HoaDon.table.getValueAt(i, 7).toString();
			soMay = UI_HoaDon.table.getValueAt(i, 8).toString();
			thanhTien = UI_HoaDon.table.getValueAt(i, 11).toString();
			textArea.append(String.format("   |%-14s|%-16s|%-9s|%-19s|%-10s|%-17s|\n",tenXe, mauXe, phanKhoi, soKhung, soMay, thanhTien));
			textArea.append("      ----------------------------------------------------------------------------------------\n");
		}
		DecimalFormat df = new DecimalFormat("#,###,###,### VNĐ");
		NumberFormat num = NumberFormat.getNumberInstance();
		double cusMoney = 0;
		try {
			cusMoney = num.parse(UI_ThanhToan.txtCusMoney.getText()).doubleValue();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		textArea.append(String.format("\n							Total          : %20s" , UI_HoaDon.txtTotal.getText()));
		textArea.append(String.format("\n							Tiền khách trả : %20s" , df.format(cusMoney)));
		textArea.append(String.format("\n							Tiền thừa      : %20s" , UI_ThanhToan.txtRefunds.getText()));
		contentPane.add(textArea);
	}

	private void setViewportView(JTable table) {
		// TODO Auto-generated method stub
		
	}
}
