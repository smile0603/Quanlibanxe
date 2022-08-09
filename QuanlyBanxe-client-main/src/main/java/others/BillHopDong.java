package others;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ui.UI_XuatHopDong;

import javax.swing.JTextArea;
public class BillHopDong extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTextArea textArea;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	public BillHopDong() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 927, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		textArea = new JTextArea();
		textArea.setBounds(5, 5, 864, 700);
		textArea.append("\n 		CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM");
		textArea.append("\n		       Độc Lập - Tự Do - Hạnh Phúc");
		textArea.append("\n\n		          HỢP ĐỒNG MUA BÁN XE ");		
		textArea.append("\n 1.Bên Bán");
		textArea.append("\n   Công ty mua bán xe Thành Nam");
		textArea.append("\n   Tên nhân viên: " +UI_XuatHopDong.lbl_edit_tenNV.getText());
		textArea.append("\n 2.Bên Mua");				
		textArea.append("\n	Tên khách hàng          		: " +UI_XuatHopDong.label_edit_tenKH.getText());
		textArea.append("\n	Số chứng minh nhân dân  		: " +UI_XuatHopDong.label_edit_cmnd.getText());
		textArea.append("\n	Số điện thoại           		: " +UI_XuatHopDong.label_edit_sdt.getText());
		textArea.append("\n Thông tin xe");		
		textArea.append("\n	Loại xe                 		: " +UI_XuatHopDong.label_edit_loaixe.getText());
		textArea.append("\n	Tên xe                  		: " +UI_XuatHopDong.label_edit_tenxe.getText());
		textArea.append("\n	Phân khối               		: " +UI_XuatHopDong.label_edit_phankhoi.getText());
		textArea.append("\n	Số khung                  		: " +UI_XuatHopDong.label_edit_sokhung.getText());
		textArea.append("\n	Số máy                    		: " +UI_XuatHopDong.label_edit_somay.getText());
		textArea.append("\n	Màu xe                  		: " +UI_XuatHopDong.label_edit_mauxe.getText());
		textArea.append("\n	Đơn giá 	               		: " +UI_XuatHopDong.label_edit_dongia.getText());
		textArea.append("\n	Thuế                          	 	: " +UI_XuatHopDong.label_edit_thue.getText()+"năm");
		textArea.append("\n	Thời gian bảo hành             		: " +UI_XuatHopDong.label_edit_tgbh.getText());
		textArea.append("\n 3.Cam đoan");
		textArea.append("\n    3.1.Bến bán cam đoan");
		textArea.append("\n      Khi đem bán theo bản hợp đồng này, chiếc xe nói trên thuộc quyền sở hữu và sử dụng hợp pháp của Bên bán,\n chưa đem cầm cố, thế chấp hoặc cho bất kỳ nghĩa vụ tài sản nào"); 
		textArea.append("\n    3.2.Bên mua cam đoan");
		textArea.append("\n      Bên mua đã tự mình xem xét kỹ, biết rõ về nguồn gốc sở hữu và hiện trạng chiếc xe nói trên của Bên bán,\n bằng lòng mua và không có điều gì thắc mắc.");
		textArea.append("\n 4.Điều khoản cuối cùng");
		textArea.append("\n    Hai bên đã tự đọc lại nguyên văn bản hợp đồng này, đều hiểu và chấp thuận toàn bộ nội dung của hợp đồng, \nkhông có điều gì vướng mắc. Hai bên cùng ký tên dưới đây để làm bằng chứng.");
		textArea.append("\n                       		                                                                            Ngày     Tháng    Năm    ");
		textArea.append("\n 	Bên bán                          			Người mua");
		contentPane.add(textArea);
	}
}
