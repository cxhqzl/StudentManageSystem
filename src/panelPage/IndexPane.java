package panelPage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import main.MainClass;
import paramer.AdminParamer;
/**
 * 系统登录界面
 * @author Xinhai Cao
 *
 */
public class IndexPane extends JPanel implements ActionListener,PropertyChangeListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField username;
	private JPasswordField password;
	/**管理员参数类对象*/
	AdminParamer ap = new AdminParamer();
	/**主类*/
	MainClass mc;
	
	public IndexPane(MainClass mc) {
		this.mc = mc;
//		setBackground(Color.CYAN);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u751F\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 42));
		lblNewLabel.setBounds(346, 40, 349, 63);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u8D26\u53F7");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(369, 179, 58, 28);
		add(lblNewLabel_1);
		
		username = new JTextField();
		username.setBounds(441, 174, 180, 33);
		add(username);
		username.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6\u7801");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(369, 252, 58, 28);
		add(lblNewLabel_2);
		
		password = new JPasswordField();
		password.setBounds(441, 247, 180, 33);
		add(password);
		password.setColumns(10);
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 25));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(369, 401, 113, 45);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u9000\u51FA");
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 25));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(565, 401, 113, 45);
		add(btnNewButton_1);
		
		btnNewButton.addActionListener(this);
		btnNewButton_1.addActionListener(this);
		addPropertyChangeListener("管理员参数", mc);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("登录")) {
			ap.username = username.getText();
			ap.password = String.valueOf(password.getPassword());
			ap.btn = e.getActionCommand();
		}else {
			ap.btn = e.getActionCommand();
		}
		firePropertyChange("管理员参数", null, ap);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		
	}

}
