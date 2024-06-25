package view.form;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import decode.ImageDecoder;
import decode.ImageEncoder;
import model.Model_User;
import service.Service;
import view.Main;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.CompoundBorder;

public class Profile extends JPanel{
	private JLabel label_user_avatar;
	private JLabel lblTnTiKhon;
	private JLabel lblHVTn;
	private JLabel lblEmail;
	private JLabel lblSinThoi;
	private JLabel lblaCh;
	private JTextField tf_user_TenTaiKhoan;
	private JTextField tf_user_HoVaTen;
	private JTextField tf_user_email;
	private JTextField tf_user_sdt;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel;
	private JButton bt_chonAnh;
	private JDialog dialog;

	public Profile(JDialog dialog, Model_User user) {
		setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 64, 128)));
		this.dialog = dialog;
		setSize(1390, 585);
		setLayout(null);
		
		lblTnTiKhon = new JLabel("Tên tài khoản:");
		lblTnTiKhon.setForeground(new Color(0, 64, 128));
		lblTnTiKhon.setFont(new Font("Segoe UI", Font.BOLD, 26));
		lblTnTiKhon.setBounds(550, 120, 217, 48);
		add(lblTnTiKhon);
		
		lblHVTn = new JLabel("Họ và tên:");
		lblHVTn.setForeground(new Color(0, 64, 128));
		lblHVTn.setFont(new Font("Segoe UI", Font.BOLD, 26));
		lblHVTn.setBounds(550, 200, 217, 48);
		add(lblHVTn);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setForeground(new Color(0, 64, 128));
		lblEmail.setFont(new Font("Segoe UI", Font.BOLD, 26));
		lblEmail.setBounds(550, 280, 217, 48);
		add(lblEmail);
		
		lblSinThoi = new JLabel("Số điện thoại:");
		lblSinThoi.setForeground(new Color(0, 64, 128));
		lblSinThoi.setFont(new Font("Segoe UI", Font.BOLD, 26));
		lblSinThoi.setBounds(550, 360, 217, 48);
		add(lblSinThoi);
		
		lblaCh = new JLabel("Địa chỉ:");
		lblaCh.setForeground(new Color(0, 64, 128));
		lblaCh.setFont(new Font("Segoe UI", Font.BOLD, 26));
		lblaCh.setBounds(550, 440, 217, 48);
		add(lblaCh);
		
		tf_user_TenTaiKhoan = new JTextField(user.getUserName());
		tf_user_TenTaiKhoan.setBackground(new Color(255, 255, 255));
		tf_user_TenTaiKhoan.setEditable(false);
		tf_user_TenTaiKhoan.setFont(new Font("Segoe UI", Font.PLAIN, 26));
		tf_user_TenTaiKhoan.setColumns(10);
		tf_user_TenTaiKhoan.setBounds(800, 120, 490, 48);
		add(tf_user_TenTaiKhoan);
		
		tf_user_HoVaTen = new JTextField(user.getFullName());
		tf_user_HoVaTen.setBackground(new Color(255, 255, 255));
		tf_user_HoVaTen.setEditable(false);
		tf_user_HoVaTen.setFont(new Font("Segoe UI", Font.PLAIN, 26));
		tf_user_HoVaTen.setColumns(10);
		tf_user_HoVaTen.setBounds(800, 200, 490, 48);
		add(tf_user_HoVaTen);
		
		tf_user_email = new JTextField(user.getEmail());
		tf_user_email.setBackground(new Color(255, 255, 255));
		tf_user_email.setEditable(false);
		tf_user_email.setFont(new Font("Segoe UI", Font.PLAIN, 26));
		tf_user_email.setColumns(10);
		tf_user_email.setBounds(800, 280, 490, 48);
		add(tf_user_email);
		
		tf_user_sdt = new JTextField(user.getPhone());
		tf_user_sdt.setBackground(new Color(255, 255, 255));
		tf_user_sdt.setEditable(false);
		tf_user_sdt.setFont(new Font("Segoe UI", Font.PLAIN, 26));
		tf_user_sdt.setColumns(10);
		tf_user_sdt.setBounds(800, 360, 490, 48);
		add(tf_user_sdt);
		
		scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		scrollPane.setBounds(800, 440, 490, 100);
		add(scrollPane);
		
		JTextArea ta_DiaChi = new JTextArea(user.getAddress());
		ta_DiaChi.setEditable(false);
		scrollPane.setViewportView(ta_DiaChi);
		ta_DiaChi.setWrapStyleWord(true);
		ta_DiaChi.setLineWrap(true);
		ta_DiaChi.setFont(new Font("Segoe UI", Font.PLAIN, 26));
		
		lblNewLabel = new JLabel("INFORMATION USER");
		lblNewLabel.setForeground(new Color(255, 128, 0));
		lblNewLabel.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 27, 1370, 60);
		add(lblNewLabel);
		
		
		this.setBackground(new Color(186, 222, 222));
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 128, 64));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new CompoundBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "AVATAR", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 128, 64)), new MatteBorder(4, 4, 4, 4, (Color) new Color(0, 51, 102))));
		panel.setBounds(100, 120, 370, 390);
		add(panel);
		
		label_user_avatar = new JLabel("");
		panel.add(label_user_avatar);
		label_user_avatar.setIcon(new ImageIcon(ImageDecoder.decodeStringToImageIcon(user.getAvatar_path()).getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH)));
	}
	

	public JTextField getTf_user_TenTaiKhoan() {
		return tf_user_TenTaiKhoan;
	}

	public JTextField getTf_user_HoVaTen() {
		return tf_user_HoVaTen;
	}

	public JTextField getTf_user_email() {
		return tf_user_email;
	}

	public JTextField getTf_user_sdt() {
		return tf_user_sdt;
	}

	public JButton getBt_chonAnh() {
		return bt_chonAnh;
	}
}
