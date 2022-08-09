package ui;





import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import businesslogic.facade.HopDongFacade;
import businesslogic.facade.LoaiXeFacade;
import others.BillHopDong;
import others.PrintSupport;


import javax.swing.JLabel;


import java.awt.Font;



import java.sql.SQLException;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class UI_XuatHopDong extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private HopDongFacade hopDongFacade = (HopDongFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/hopDongFacade");
	public static JLabel label_edit_tenKH;
	public static JLabel label_edit_diachi;
	public static JLabel label_edit_phankhoi;
	public static JLabel label_edit_sdt;
	public static JLabel label_edit_somay;
	public static JLabel label_edit_tgbh;
	public static JLabel label_edit_dongia ;
	public static JLabel label_edit_sokhung;
	public static JLabel label_edit_cmnd;
	public static JLabel label_edit_mauxe;
	public static JLabel label_edit_tenxe;
	public static JLabel label_edit_loaixe;
	public static JLabel lbl_edit_tenNV;
	public static JLabel label_edit_thue;
	
	public static JDateChooser dateChooser;

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
					UI_XuatHopDong frame = new UI_XuatHopDong();
					frame.setVisible(true);
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
	public UI_XuatHopDong() throws MalformedURLException, RemoteException, NotBoundException {

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setBounds(320, 0, 718, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblHpngMua = new JLabel("Hợp đồng mua bán xe");
		lblHpngMua.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblHpngMua.setBounds(255, 57, 232, 32);
		contentPane.add(lblHpngMua);
		LoaiXeFacade loaiXeFacade = (LoaiXeFacade) Naming.lookup("rmi://DESKTOP-1NNGN4I:9999/loaiXeFacade");
		//Dao_LoaiXe dao_lx = new Dao_LoaiXe();
		
		JLabel lblCngHaX = new JLabel("CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM");
		lblCngHaX.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCngHaX.setBounds(202, 10, 353, 23);
		contentPane.add(lblCngHaX);
		
		JLabel lblcLp = new JLabel("Độc lập - Tự do - Hạnh phúc");
		lblcLp.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblcLp.setBounds(266, 43, 188, 13);
		contentPane.add(lblcLp);
		
		JLabel lblBnBn = new JLabel("Bên bán");
		lblBnBn.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBnBn.setBounds(23, 87, 77, 13);
		contentPane.add(lblBnBn);
		
		JLabel lblCngTyMua = new JLabel("Công ty mua bán xe máy Thành Nam");
		lblCngTyMua.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCngTyMua.setBounds(54, 108, 220, 13);
		contentPane.add(lblCngTyMua);
		
		JLabel lblTnNhnVin = new JLabel("Tên nhân viên");
		lblTnNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTnNhnVin.setBounds(54, 131, 93, 13);
		contentPane.add(lblTnNhnVin);
		
		lbl_edit_tenNV = new JLabel("...");
		lbl_edit_tenNV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl_edit_tenNV.setBounds(176, 131, 232, 13);
		contentPane.add(lbl_edit_tenNV);
		
		JLabel lblBnMua = new JLabel("Bên mua");
		lblBnMua.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBnMua.setBounds(23, 151, 77, 13);
		contentPane.add(lblBnMua);
		
		JLabel lblTnKhchHng = new JLabel("Tên khách hàng");
		lblTnKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTnKhchHng.setBounds(54, 174, 93, 13);
		contentPane.add(lblTnKhchHng);
		
		label_edit_tenKH = new JLabel("...");
		label_edit_tenKH.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_edit_tenKH.setBounds(176, 174, 278, 13);
		contentPane.add(label_edit_tenKH);
		
		
		JLabel lblCmnd = new JLabel("CMND");
		lblCmnd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCmnd.setBounds(54, 197, 46, 13);
		contentPane.add(lblCmnd);
		
		label_edit_cmnd = new JLabel("...");
		label_edit_cmnd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_edit_cmnd.setBounds(176, 197, 278, 13);
		contentPane.add(label_edit_cmnd);

		
		JLabel lblSinThoi = new JLabel("Số điện thoại");
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSinThoi.setBounds(54, 220, 93, 13);
		contentPane.add(lblSinThoi);
		
		label_edit_sdt = new JLabel("...");
		label_edit_sdt.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_edit_sdt.setBounds(176, 220, 277, 13);
		contentPane.add(label_edit_sdt);
		
		
		JLabel lblaCh = new JLabel("Địa chỉ");
		lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblaCh.setBounds(54, 243, 46, 13);
		contentPane.add(lblaCh);
		
		label_edit_diachi = new JLabel("...");
		label_edit_diachi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_edit_diachi.setBounds(176, 243, 277, 13);
		contentPane.add(label_edit_diachi);
		
		
		JLabel lblThngTinXe = new JLabel("Thông tin xe ");
		lblThngTinXe.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThngTinXe.setBounds(23, 258, 102, 23);
		contentPane.add(lblThngTinXe);
		
		JLabel lblLoiXe = new JLabel("Loại xe");
		lblLoiXe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLoiXe.setBounds(54, 280, 46, 13);
		contentPane.add(lblLoiXe);
		
		label_edit_loaixe = new JLabel("...");
		label_edit_loaixe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_edit_loaixe.setBounds(176, 280, 278, 13);
		contentPane.add(label_edit_loaixe);
	
		
		JLabel lblTnXe = new JLabel("Tên xe");
		lblTnXe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTnXe.setBounds(54, 299, 46, 13);
		contentPane.add(lblTnXe);
		
		label_edit_tenxe = new JLabel("...");
		label_edit_tenxe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_edit_tenxe.setBounds(176, 303, 278, 13);
		contentPane.add(label_edit_tenxe);

		
		JLabel lblHngSnXut = new JLabel("Phân khối");
		lblHngSnXut.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHngSnXut.setBounds(54, 322, 93, 13);
		contentPane.add(lblHngSnXut);
		
		label_edit_phankhoi = new JLabel("...");
		label_edit_phankhoi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_edit_phankhoi.setBounds(176, 326, 278, 13);
		contentPane.add(label_edit_phankhoi);
		
		
		
		JLabel lblSKhung = new JLabel("Số khung");
		lblSKhung.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSKhung.setBounds(54, 345, 71, 13);
		contentPane.add(lblSKhung);
		
		
		label_edit_sokhung = new JLabel("...");
		label_edit_sokhung.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_edit_sokhung.setBounds(176, 349, 278, 13);
		contentPane.add(label_edit_sokhung);
	
		
		JLabel lblSMy = new JLabel("Số máy");
		lblSMy.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSMy.setBounds(54, 368, 46, 13);
		contentPane.add(lblSMy);
	
		
		label_edit_somay = new JLabel("...");
		label_edit_somay.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_edit_somay.setBounds(176, 372, 278, 13);
		contentPane.add(label_edit_somay);
		
		
		JLabel lblMuXe = new JLabel("Màu xe");
		lblMuXe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMuXe.setBounds(54, 391, 46, 13);
		contentPane.add(lblMuXe);
		
		label_edit_mauxe = new JLabel("...");
		label_edit_mauxe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_edit_mauxe.setBounds(176, 395, 278, 13);
		contentPane.add(label_edit_mauxe);

		
		JLabel lblnGi = new JLabel("Đơn giá");
		lblnGi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblnGi.setBounds(54, 414, 46, 13);
		contentPane.add(lblnGi);
		
		label_edit_dongia = new JLabel("...");
		label_edit_dongia.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_edit_dongia.setBounds(176, 418, 278, 13);
		contentPane.add(label_edit_dongia);
		
		JLabel lblThiGianBo = new JLabel("Thời gian bảo hành");
		lblThiGianBo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblThiGianBo.setBounds(54, 460, 116, 13);
		contentPane.add(lblThiGianBo);
		
		label_edit_tgbh = new JLabel("...");
		label_edit_tgbh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_edit_tgbh.setBounds(176, 460, 278, 13);
		contentPane.add(label_edit_tgbh);
		
		JLabel lblThu = new JLabel("Thuế");
		lblThu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblThu.setBounds(54, 437, 46, 13);
		contentPane.add(lblThu);
		
		label_edit_thue = new JLabel("...");
		label_edit_thue.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_edit_thue.setBounds(176, 437, 278, 13);
		contentPane.add(label_edit_thue);
		
		JLabel lblCamoan = new JLabel("Cam đoan");
		lblCamoan.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCamoan.setBounds(23, 483, 93, 13);
		contentPane.add(lblCamoan);
		
		JLabel lblBnBnCam = new JLabel("Bên bán cam đoan");
		lblBnBnCam.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBnBnCam.setBounds(54, 506, 116, 13);
		contentPane.add(lblBnBnCam);
		
		JTextPane txtpnKhiemBn = new JTextPane();
		txtpnKhiemBn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnKhiemBn.setText("Khi đem bán theo bản hợp đồng này, chiếc xe nói trên thuộc quyền sở hữu và sử dụng hợp pháp của Bên bán; chưa đem cầm cố, thế chấp hoặc dùng để đảm bảo cho bất kỳ nghĩa vụ tài sản nào");
		txtpnKhiemBn.setBounds(64, 529, 623, 39);
		contentPane.add(txtpnKhiemBn);
		
		JLabel lblBnMuaCam = new JLabel("Bên mua cam đoan");
		lblBnMuaCam.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBnMuaCam.setBounds(54, 578, 116, 13);
		contentPane.add(lblBnMuaCam);
		
		JTextPane txtpnBnMua = new JTextPane();
		txtpnBnMua.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnBnMua.setText("Bên mua đã tự mình xem xét kỹ, biết rõ về nguồn gốc sở hữu và hiện trạng chiếc xe nói trên của Bên bán, bằng lòng mua và không có điều gì thắc mắc.");
		txtpnBnMua.setBounds(64, 601, 623, 39);
		contentPane.add(txtpnBnMua);
		
		JLabel lbliuKhonCui = new JLabel("Điều khoản cuối cùng");
		lbliuKhonCui.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbliuKhonCui.setBounds(23, 650, 180, 13);
		contentPane.add(lbliuKhonCui);
		
		JTextPane txtpnHaiBn = new JTextPane();
		txtpnHaiBn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnHaiBn.setText("Hai bên đã tự đọc lại nguyên văn bản hợp đồng này, đều hiểu và chấp thuận toàn bộ nội dung của hợp đồng, không có điều gì vướng mắc. Hai bên cùng ký tên dưới đây để làm bằng chứng.");
		txtpnHaiBn.setBounds(64, 673, 623, 32);
		contentPane.add(txtpnHaiBn);
		
		JLabel lblNgyThngNm = new JLabel("Ngày      Tháng      Năm ");
		lblNgyThngNm.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNgyThngNm.setBounds(526, 719, 142, 13);
		contentPane.add(lblNgyThngNm);
		
		JLabel lblBnBn_1 = new JLabel("Bên bán");
		lblBnBn_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBnBn_1.setBounds(82, 742, 65, 13);
		contentPane.add(lblBnBn_1);
		
		JLabel lblBnMua_1 = new JLabel("Bên mua");
		lblBnMua_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBnMua_1.setBounds(566, 742, 65, 13);
		contentPane.add(lblBnMua_1);
		
		JButton btnXut = new JButton("Xuất");
		btnXut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BillHopDong bill = new BillHopDong();
				PrintSupport.printComponent(bill.textArea);
				String cmds[] = new String[] {"cmd", "/d", "D:\\nam4ky1\\LapTrinhPhanTan\\BAITAPDOAN\\HopDong\\a.pdf"};
				try {
				    Runtime.getRuntime().exec(cmds);
				}catch (Exception e1) {
					// TODO: handle exception
				}
			}
		});
		btnXut.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXut.setBounds(417, 782, 85, 21);
		contentPane.add(btnXut);
		
		JButton btnng = new JButton("Đóng");
		btnng.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnng.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnng.setBounds(602, 782, 85, 21);
		contentPane.add(btnng);
	}
}
