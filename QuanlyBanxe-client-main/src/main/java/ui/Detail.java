package ui;

import java.awt.EventQueue;


import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import entity.HangSanXuat;
import entity.LoaiXe;
import entity.NhaCungCap;
import entity.Xe;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.TitledBorder;

import businesslogic.facade.XeFacade;

public class Detail extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	//private Dao_QuanLyXe dao_qlLyXe= new Dao_QuanLyXe();

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
		
		 EventQueue.invokeLater(new Runnable() { public void run() { try { Detail
		 frame = new Detail("aa"); frame.setVisible(true); } catch (Exception e) {
		 e.printStackTrace(); } } });
		
	}

	/**
	 * Create the frame.
	 * @throws RemoteException 
	 * @throws NotBoundException 
	 * @throws MalformedURLException 
	 */
	public Detail(String id) throws RemoteException, MalformedURLException, NotBoundException {
//		try {
//			ConnectDB.getInstance().connect();
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		setUndecorated(true);
		XeFacade xeFacade = (XeFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/xeFacade");
		Xe listXe= xeFacade.getInfoXe("maXe",id);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(320, 80, 896, 681);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lbImg = new JLabel();
		lbImg.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbImg.setHorizontalAlignment(SwingConstants.CENTER);
		lbImg.setBounds(48, 76, 348, 486);
		if(listXe.getImg1().toString().length()<1) {
			lbImg.setText("Chưa có hình ảnh");
		}
		else {
			BufferedImage img = null;
			String img1= listXe.getImg1();
			try {
			    img = ImageIO.read(new File(img1));
			} catch (IOException e) {
				   e.printStackTrace();
			}
			Image dimg = img.getScaledInstance(lbImg.getWidth(), lbImg.getHeight(),
			        Image.SCALE_SMOOTH);
			ImageIcon imageIcon = new ImageIcon(dimg);
			lbImg.setIcon(imageIcon);
		}	
		contentPane.add(lbImg);
		
		JLabel lbten = new JLabel("Tên xe");
		lbten.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbten.setBounds(450, 76, 130, 14);
		contentPane.add(lbten);
		
		JLabel lbMau = new JLabel("Màu xe");
		lbMau.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbMau.setBounds(450, 115, 130, 19);
		contentPane.add(lbMau);
		
		JLabel lbSoKhung = new JLabel("Số khung");
		lbSoKhung.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbSoKhung.setBounds(450, 159, 130, 19);
		contentPane.add(lbSoKhung);
		
		JLabel lbPhanKhoi = new JLabel("Phân khối");
		lbPhanKhoi.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbPhanKhoi.setBounds(450, 271, 130, 19);
		contentPane.add(lbPhanKhoi);
		
		JLabel lbNcc = new JLabel("Nhà cung cấp");
		lbNcc.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbNcc.setBounds(450, 320, 88, 19);
		contentPane.add(lbNcc);
		
		JLabel lbHang = new JLabel("Hãng sản xuất");
		lbHang.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbHang.setBounds(450, 367, 130, 19);
		contentPane.add(lbHang);
		
		JLabel lbLoai = new JLabel("Loại xe");
		lbLoai.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbLoai.setBounds(450, 451, 130, 19);
		contentPane.add(lbLoai);
		
		JLabel lbGia = new JLabel("Giá nhập");
		lbGia.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbGia.setBounds(450, 494, 130, 19);
		contentPane.add(lbGia);
		
		JLabel lbNgay = new JLabel("Ngày nhập");
		lbNgay.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbNgay.setBounds(450, 539, 130, 14);
		contentPane.add(lbNgay);
		
		JLabel lbTrangThai = new JLabel("Trạng thái");
		lbTrangThai.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbTrangThai.setBounds(450, 580, 130, 19);
		contentPane.add(lbTrangThai);
		
		JLabel lbChuThic = new JLabel("Chú thích");
		lbChuThic.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbChuThic.setBounds(450, 620, 130, 19);
		contentPane.add(lbChuThic);
		
		JLabel lbQuocGia = new JLabel("Quốc gia sản xuất");
		lbQuocGia.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbQuocGia.setBounds(450, 410, 109, 19);
		contentPane.add(lbQuocGia);
		
		JLabel lbEditten = new JLabel("...");
		lbEditten.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbEditten.setBounds(609, 76, 188, 14);
		contentPane.add(lbEditten);
		
		lbEditten.setText(listXe.getTenXe());
		
		
		JLabel lbEditMau = new JLabel("...");
		lbEditMau.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbEditMau.setBounds(609, 115, 188, 19);
		contentPane.add(lbEditMau);
		lbEditMau.setText(listXe.getMauXe());
		
		JLabel lbEditSoKhung = new JLabel("...");
		lbEditSoKhung.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbEditSoKhung.setBounds(609, 159, 188, 19);
		contentPane.add(lbEditSoKhung);
		lbEditSoKhung.setText(listXe.getSoKhung());
		
		JLabel lbEditPhanKhoi = new JLabel("...");
		lbEditPhanKhoi.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbEditPhanKhoi.setBounds(609, 271, 188, 19);
		contentPane.add(lbEditPhanKhoi);
		String phanKhoi= Integer.toString(listXe.getPhanKhoi());
		lbEditPhanKhoi.setText(phanKhoi);
		
		String id1= listXe.getNhaCungCap().getMaNhaCungCap();
		String id2=listXe.getLoaiXe().getMaLoaiXe();
		String id3=listXe.getHangSanXuat().getMaHangSX();
		ArrayList<LoaiXe> dsLoai= xeFacade.getAllLoaiXe(id2);
		ArrayList<NhaCungCap> dsncc= xeFacade.getAllNCC(id1);
		ArrayList<HangSanXuat> dshsx= xeFacade.getAllHangSX(id3);
		
		JLabel lbeditNcc = new JLabel("...");
		lbeditNcc.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbeditNcc.setBounds(609, 320, 225, 19);
		contentPane.add(lbeditNcc);
		lbeditNcc.setText(dsncc.get(0).getTenNhaCungCap());
		
		JLabel lbEditHang = new JLabel("...");
		lbEditHang.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbEditHang.setBounds(609, 367, 188, 19);
		contentPane.add(lbEditHang);
		
		lbEditHang.setText(dshsx.get(0).getMaHangSX());
		
		JLabel lbeditQuocGia = new JLabel("...");
		lbeditQuocGia.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbeditQuocGia.setBounds(609, 410, 188, 19);
		contentPane.add(lbeditQuocGia);
		lbeditQuocGia.setText(dshsx.get(0).getQuocGia());
		
		JLabel lbEditLoai = new JLabel("...");
		lbEditLoai.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbEditLoai.setBounds(609, 451, 188, 19);
		contentPane.add(lbEditLoai);
		lbEditLoai.setText(dsLoai.get(0).getTenLoaiXe());
		
		JLabel lbEditGia = new JLabel("...");
		lbEditGia.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbEditGia.setBounds(609, 494, 188, 19);
		contentPane.add(lbEditGia);
		DecimalFormat df = new DecimalFormat("###,###,###,### VNĐ");
		String gia= df.format(listXe.getGiaNhap());
		lbEditGia.setText(gia);
		
		JLabel lbeditNgay = new JLabel("...");
		lbeditNgay.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbeditNgay.setBounds(609, 539, 188, 14);
		contentPane.add(lbeditNgay);
		lbeditNgay.setText(listXe.getNgayNhap().toString());
		
		JLabel lbEditTt = new JLabel("...");
		lbEditTt.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbEditTt.setBounds(609, 580, 188, 19);
		contentPane.add(lbEditTt);
		lbEditTt.setText(listXe.getTrangThai());
		
		JLabel lbEditChuThich = new JLabel("...");
		lbEditChuThich.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbEditChuThich.setBounds(609, 620, 188, 19);
		contentPane.add(lbEditChuThich);
		lbEditChuThich.setText(listXe.getChuThich());
		
		JLabel lbeditdetail = new JLabel("...");
		lbeditdetail.setHorizontalAlignment(SwingConstants.CENTER);
		lbeditdetail.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbeditdetail.setBounds(172, 10, 523, 35);
		lbeditdetail.setText("Thông tin chi tiết xe "+listXe.getTenXe());
		contentPane.add(lbeditdetail);
		
		JLabel lblNewLabel = new JLabel("X");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				dispose();
			}
		});
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(855, 0, 41, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lbSoMay = new JLabel("Số máy");
		lbSoMay.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbSoMay.setBounds(450, 213, 130, 19);
		contentPane.add(lbSoMay);
		
		JLabel lbEditSoMay = new JLabel((String) null);
		lbEditSoMay.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbEditSoMay.setBounds(609, 213, 188, 19);
		lbEditSoMay.setText(listXe.getSoMay());
		contentPane.add(lbEditSoMay);
	}
}
