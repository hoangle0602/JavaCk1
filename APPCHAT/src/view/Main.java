package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import service.Service;
import view.form.Home;
import view.form.Login;

public class Main extends JFrame {

	private JPanel contentPane;
	private Home home;
	private Login login;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0, 1200, 800);
		setLocationRelativeTo(null);
		setTitle("Chat-Client");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(0 ,0, 1200, 760);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		login = new Login();
		contentPane.add(login);
		login.setBounds(0, 0, 1200, 800);
		login.setVisible(true);
		
		home = new Home();
		contentPane.add(home);
		home.setBounds(0,0, 1190, 760);
		home.setVisible(false);
		
		Service.getInstance(this).startClient();;
	}

	public Home getHome() {
		return home;
	}

	public Login getLogin() {
		return login;
	}
	
	
		
}
