package view.form;

import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.SwingConstants;

import Mail.GenerateOtp;
import Mail.OtpMessage;
import decode.MD5;
import model.Model_Login;
import model.Model_Register;
import service.Service;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;

public class Login extends JPanel{
	private JTextField tf_userName;
	private JPasswordField tf_password;
	private JTextField tf_userName_register;
	private JPasswordField tf_password_register;
	private JPasswordField tf_confirm_register;
	private CardLayout cardLayout;
	private JPanel panel;
	private JLabel lb_register_message;
	private JLabel lb_login_message;
	private JTextField getOtp;
	private String otpg;
	public Login() {
		setSize(1200, 800);
		setLayout(null);
		setBackground(new Color(0, 119, 238));
		
		panel = new JPanel();
		panel.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 64, 128)));
		panel.setBounds(450, 182, 380, 500);
		panel.setBackground(new Color(255, 255, 255));
		add(panel);
		cardLayout = new CardLayout(0, 0);
		panel.setLayout(cardLayout);
		
		JPanel panel_login = new JPanel();
		panel_login.setBackground(new Color(238, 247, 255));
		panel.add(panel_login, "panel_login");
		panel_login.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setForeground(new Color(0, 64, 128));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Berlin Sans FB", Font.BOLD, 35));
		lblNewLabel.setBounds(25, 50, 315, 39);
		panel_login.add(lblNewLabel);
		
		tf_userName = new JTextField();
		tf_userName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		tf_userName.setBounds(25, 150, 325, 39);
		panel_login.add(tf_userName);
		tf_userName.setColumns(10);
		
		tf_password = new JPasswordField();
		tf_password.setFont(new Font("Tahoma", Font.PLAIN, 25));
		tf_password.setBounds(25, 255, 325, 39);
		panel_login.add(tf_password);
		
		JLabel lblNewLabel_1 = new JLabel("UserName");
		lblNewLabel_1.setForeground(new Color(0, 64, 128));
		lblNewLabel_1.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 22));
		lblNewLabel_1.setBounds(25, 115, 163, 26);
		panel_login.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setForeground(new Color(0, 64, 128));
		lblNewLabel_1_1.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 22));
		lblNewLabel_1_1.setBounds(25, 220, 163, 26);
		panel_login.add(lblNewLabel_1_1);
		
		JButton bt_login = new JButton("LOGIN");
		bt_login.setBackground(new Color(0, 128, 128));
		bt_login.setForeground(new Color(0, 128, 128));
		bt_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tf_userName.getText().isEmpty()) {
					tf_userName.grabFocus();
				}
				else if(tf_password.getText().isEmpty()) {
					tf_password.grabFocus();
				}
				else {
					Model_Login login = new Model_Login(tf_userName.getText(), MD5.getMd5(tf_password.getText()));
					Service.getInstance().login(login.toJsonObject("login"));
				}
			}
		});
		bt_login.setFont(new Font("Berlin Sans FB", Font.BOLD, 25));
		bt_login.setBounds(120, 340, 150, 40);
		panel_login.add(bt_login);
		
		lb_login_message = new JLabel("");
		lb_login_message.setFont(new Font("Tahoma", Font.BOLD, 16));
		lb_login_message.setHorizontalAlignment(SwingConstants.CENTER);
		lb_login_message.setBounds(25, 420, 315, 39);
		panel_login.add(lb_login_message);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panel, "panel_register");
			}
		});
		btnNewButton.setForeground(new Color(255, 128, 0));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 18));
		btnNewButton.setBounds(34, 385, 320, 19);
		panel_login.add(btnNewButton);
		
		JPanel panel_register = new JPanel();
		panel_register.setBackground(new Color(240, 248, 255));
		panel.add(panel_register, "panel_register");
		panel_register.setLayout(null);
		
		JLabel lblRegister = new JLabel("REGISTER");
		lblRegister.setForeground(new Color(255, 128, 0));
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegister.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblRegister.setBounds(22, 20, 330, 39);
		panel_register.add(lblRegister);
		
		tf_userName_register = new JTextField();
		tf_userName_register.setFont(new Font("Tahoma", Font.PLAIN, 25));
		tf_userName_register.setColumns(10);
		tf_userName_register.setBounds(22, 98, 330, 39);
		panel_register.add(tf_userName_register);
		
		tf_password_register = new JPasswordField();
		tf_password_register.setFont(new Font("Tahoma", Font.PLAIN, 25));
		tf_password_register.setBounds(22, 174, 330, 39);
		panel_register.add(tf_password_register);
		
		tf_confirm_register = new JPasswordField();
		tf_confirm_register.setFont(new Font("Tahoma", Font.PLAIN, 25));
		tf_confirm_register.setBounds(22, 250, 330, 39);
		panel_register.add(tf_confirm_register);
		
		JLabel lblNewLabel_1_2 = new JLabel("UserName");
		lblNewLabel_1_2.setForeground(new Color(0, 64, 128));
		lblNewLabel_1_2.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(22, 69, 163, 26);
		panel_register.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Password");
		lblNewLabel_1_3.setForeground(new Color(0, 64, 128));
		lblNewLabel_1_3.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 20));
		lblNewLabel_1_3.setBounds(22, 146, 163, 26);
		panel_register.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Confirm");
		lblNewLabel_1_3_1.setForeground(new Color(0, 64, 128));
		lblNewLabel_1_3_1.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 20));
		lblNewLabel_1_3_1.setBounds(22, 222, 163, 26);
		panel_register.add(lblNewLabel_1_3_1);
		
		JButton but_Send = new JButton("SEND OTP");
		but_Send.setForeground(new Color(185, 0, 0));
		but_Send.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 17));
		
		but_Send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				otpg = GenerateOtp.getOtp();
				if(tf_userName_register.getText().isEmpty()) {
					lb_register_message.setText("CẦN ĐIỀN ĐẦY ĐỦ THÔNG TIN!");
				}
				String email = tf_userName_register.getText();
				OtpMessage otp = new OtpMessage(email,otpg);
				otp.send();				
				lb_register_message.setText("Gửi thành công!");
			}
		});
		but_Send.setBounds(25, 310, 130, 39);
		panel_register.add(but_Send);
		
		JButton bt_register = new JButton("REGISTER");
		bt_register.setBackground(new Color(0, 128, 128));
		bt_register.setForeground(new Color(0, 128, 128));
		bt_register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tf_userName_register.getText().isEmpty()) {
					tf_userName.grabFocus();
				}
				else if(tf_password_register.getText().isEmpty()) {
					tf_password.grabFocus();
				}
				else if(!tf_password_register.getText().equals(tf_confirm_register.getText())) {					
						lb_register_message.setText("Xác nhận mật khẩu chưa chính xác!");
						lb_register_message.setForeground(Color.red);
				}else if(!otpg.equals(getOtp.getText())) {
					lb_register_message.setText("Mã OTP chưa đúng!");
				}
				else {
					Model_Register register = new Model_Register(tf_userName_register.getText(), MD5.getMd5(tf_password_register.getText()));
					Service.getInstance().register(register.toJsonObject("register"));
				}
			}
		});
		bt_register.setFont(new Font("Tahoma", Font.BOLD, 20));
		bt_register.setBounds(120, 375, 150, 39);
		panel_register.add(bt_register);
		
		lb_register_message = new JLabel("");
		lb_register_message.setEnabled(false);
		lb_register_message.setFont(new Font("Tahoma", Font.BOLD, 16));
		lb_register_message.setHorizontalAlignment(SwingConstants.CENTER);
		lb_register_message.setBounds(22, 440, 330, 39);
		panel_register.add(lb_register_message);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panel, "panel_login");
			}
		});
		btnLogin.setForeground(Color.BLUE);
		btnLogin.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 17));
		btnLogin.setContentAreaFilled(false);
		btnLogin.setBounds(22, 415, 330, 25);
		panel_register.add(btnLogin);
		
		
		
		getOtp = new JTextField();
		getOtp.setFont(new Font("Tahoma", Font.PLAIN, 25));
		getOtp.setBounds(170, 310, 180, 39);
		panel_register.add(getOtp);
		getOtp.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setIcon(new ImageIcon(Login.class.getResource("/images/background/pn.jpg")));
		lblNewLabel_2.setBounds(0, 0, 1200, 800);
		add(lblNewLabel_2);
	}
	
	public void checkRegister(boolean check) {
		if(check) {
    		lb_register_message.setForeground(Color.green);
    		lb_register_message.setText("ĐĂNG KÝ THÀNH CÔNG");	
    		
        	JDialog dialog = new JDialog();
        	Panel_Register register = new Panel_Register(dialog, tf_userName_register.getText());
    		dialog.getContentPane().setLayout(new GridLayout(1,1));
    		dialog.setSize(1400, 620);
    		dialog.setLocationRelativeTo(null);
        	dialog.getContentPane().add(register);
        	dialog.setVisible(true);
		}
		else {
    		lb_register_message.setForeground(Color.red);
    		lb_register_message.setText("TÀI KHOẢN ĐÃ TỒN TẠI");
    	}
	}
	
	public void checkLogin(boolean check) {
		if(check) {
    		Service.getInstance().getMain().getLogin().setVisible(false);
    		Service.getInstance().getMain().getHome().setVisible(true);
		}
		else {
    		lb_login_message.setForeground(Color.red);
    		lb_login_message.setText("TÀI KHOẢN HOẶC MẬT KHẨU KHÔNG CHÍNH XÁC");
		}
	}
	
	public JLabel getLb_register_message() {
		return lb_register_message;
	}
	public void setLb_register_message(JLabel lb_register_message) {
		this.lb_register_message = lb_register_message;
	}
	public JLabel getLb_login_message() {
		return lb_login_message;
	}
	public void setLb_login_message(JLabel lb_login_message) {
		this.lb_login_message = lb_login_message;
	}
}
