package panelPage;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * 登录成功界面
 * @author Xinhai Cao
 *
 */
public class WelcomPane extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public WelcomPane() {
//		setBackground(Color.CYAN);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u6B22\u8FCE\u4F7F\u7528\u5B66\u751F\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setFont(new Font("隶书", Font.PLAIN, 42));
		lblNewLabel.setBounds(230, 224, 523, 112);
		add(lblNewLabel);
	}
}
