package view.form;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import decode.ImageEncoder;
import model.Model_User;
import service.Service;
import view.Main;
import javax.swing.border.MatteBorder;

public class Panel_Register extends JPanel{
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
	private JButton bt_save;
	
	private String imagePath;
	private JDialog dialog;

	public Panel_Register(JDialog dialog, String userName) {
		setBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(0, 64, 128)));
		this.dialog = dialog;
		setSize(1390, 585);
		setLayout(null);
		
		label_user_avatar = new JLabel("");
		label_user_avatar.setIcon(new ImageIcon((new ImageIcon((Main.class.getResource("/images/background/avatar.jpg"))).getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH))));
		label_user_avatar.setBounds(83, 90, 350, 350);
		add(label_user_avatar);
		
		lblTnTiKhon = new JLabel("Tên tài khoản:");
		lblTnTiKhon.setForeground(new Color(0, 64, 128));
		lblTnTiKhon.setFont(new Font("Segoe UI", Font.BOLD, 26));
		lblTnTiKhon.setBounds(503, 100, 217, 48);
		add(lblTnTiKhon);
		
		lblHVTn = new JLabel("Họ và tên:");
		lblHVTn.setForeground(new Color(0, 64, 128));
		lblHVTn.setFont(new Font("Segoe UI", Font.BOLD, 26));
		lblHVTn.setBounds(503, 165, 217, 48);
		add(lblHVTn);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setForeground(new Color(0, 64, 128));
		lblEmail.setFont(new Font("Segoe UI", Font.BOLD, 26));
		lblEmail.setBounds(503, 230, 217, 48);
		add(lblEmail);
		
		lblSinThoi = new JLabel("Số điện thoại:");
		lblSinThoi.setForeground(new Color(0, 64, 128));
		lblSinThoi.setFont(new Font("Segoe UI", Font.BOLD, 26));
		lblSinThoi.setBounds(503, 295, 217, 48);
		add(lblSinThoi);
		
		lblaCh = new JLabel("Địa chỉ:");
		lblaCh.setForeground(new Color(0, 64, 128));
		lblaCh.setFont(new Font("Segoe UI", Font.BOLD, 26));
		lblaCh.setBounds(503, 360, 217, 48);
		add(lblaCh);
		
		tf_user_TenTaiKhoan = new JTextField(userName);
		tf_user_TenTaiKhoan.setFont(new Font("Segoe UI", Font.PLAIN, 26));
		tf_user_TenTaiKhoan.setColumns(10);
		tf_user_TenTaiKhoan.setBounds(745, 100, 575, 48);
		add(tf_user_TenTaiKhoan);
		
		tf_user_HoVaTen = new JTextField();
		tf_user_HoVaTen.setFont(new Font("Segoe UI", Font.PLAIN, 26));
		tf_user_HoVaTen.setColumns(10);
		tf_user_HoVaTen.setBounds(745, 165, 575, 48);
		add(tf_user_HoVaTen);
		
		tf_user_email = new JTextField();
		tf_user_email.setFont(new Font("Segoe UI", Font.PLAIN, 26));
		tf_user_email.setColumns(10);
		tf_user_email.setBounds(745, 230, 575, 48);
		add(tf_user_email);
		
		tf_user_sdt = new JTextField();
		tf_user_sdt.setFont(new Font("Segoe UI", Font.PLAIN, 26));
		tf_user_sdt.setColumns(10);
		tf_user_sdt.setBounds(745, 295, 575, 48);
		add(tf_user_sdt);
		
		scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		scrollPane.setBounds(745, 360, 575, 121);
		add(scrollPane);
		
		JTextArea ta_DiaChi = new JTextArea();
		ta_DiaChi.setWrapStyleWord(true);
		ta_DiaChi.setLineWrap(true);
		ta_DiaChi.setFont(new Font("Segoe UI", Font.PLAIN, 26));
		scrollPane.setViewportView(ta_DiaChi);
		
		lblNewLabel = new JLabel("INFORMATION USER");
		lblNewLabel.setForeground(new Color(255, 128, 0));
		lblNewLabel.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(518, 30, 550, 48);
		add(lblNewLabel);
		
		bt_chonAnh = new JButton("");
		bt_chonAnh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imagePath = ImageEncoder.encodeImageToString(label_user_avatar);
			}
		});
		bt_chonAnh.setIcon(new ImageIcon(Panel_Register.class.getResource("/images/icon/icon_camera.png")));
		bt_chonAnh.setBounds(83, 440, 350, 36);
		add(bt_chonAnh);
		
		bt_save = new JButton("SAVE");
		bt_save.setBackground(new Color(0, 64, 0));
		bt_save.setForeground(new Color(0, 128, 0));
		bt_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Model_User user = new Model_User(999, tf_user_TenTaiKhoan.getText(), tf_user_HoVaTen.getText(), tf_user_email.getText(), tf_user_sdt.getText(), ta_DiaChi.getText(), imagePath, true);
				Service.getInstance().registerInfo(user.toJsonObject("registerInfo"));
				dialog.dispose();
			}
		});
		bt_save.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 30));
		bt_save.setBounds(596, 500, 167, 51);
		add(bt_save);
		
		this.setBackground(new Color(186, 222, 222));
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
