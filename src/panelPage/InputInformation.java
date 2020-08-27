package panelPage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DatabaseOperate.ConnectionDB;
import paramer.InputParamer;
/**
 * ��Ϣ¼�����
 * @author Xinhai Cao
 *
 */
public class InputInformation extends JPanel implements ActionListener,ItemListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField number;
	private JTextField name;
	private JTextField profession;
	private JTextField schoolAddress;
	private JTextField address;
	JComboBox<String> classes;
	JComboBox<String> sex;
	JComboBox<String> race;
	JComboBox<String> grade;
	
	/**����InputParamer���󱣴�������Ϣ*/
	InputParamer ip = new InputParamer();
	private JTextField schoolName;
	
	
	public InputInformation() {
//		setBackground(Color.CYAN);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u751F\u4FE1\u606F\u5F55\u5165");
		lblNewLabel.setBounds(354, 42, 252, 48);
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 42));
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5B66\u53F7");
		lblNewLabel_1.setBounds(288, 172, 37, 18);
		add(lblNewLabel_1);
		/**ѧ��*/
		number = new JTextField();
		number.setBounds(335, 169, 157, 24);
		add(number);
		number.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u59D3\u540D");
		lblNewLabel_2.setBounds(288, 231, 37, 18);
		add(lblNewLabel_2);
		/**����*/
		name = new JTextField();
		name.setBounds(335, 228, 157, 24);
		add(name);
		name.setColumns(10);
		/**�Ա�*/
		sex = new JComboBox<String>();
		sex.setBounds(612, 169, 87, 25);
		add(sex);
		sex.addItemListener(this);
		sex.addItem("��");
		sex.addItem("Ů");
		sex.addItem("δ֪");
		
		
		JLabel label = new JLabel("\u6027\u522B");
		label.setBounds(569, 172, 37, 18);
		add(label);
		
		JLabel lblNewLabel_3 = new JLabel("\u6C11\u65CF");
		lblNewLabel_3.setBounds(569, 231, 41, 18);
		add(lblNewLabel_3);
		/**����*/
		race = new JComboBox<String>();
		race.setBounds(612, 228, 87, 25);
		add(race);
		race.addItemListener(this);
		race.addItem("����");
		race.addItem("����");
		race.addItem("����");
		race.addItem("δ֪");
		
		JLabel label_1 = new JLabel("\u5E74\u7EA7");
		label_1.setBounds(569, 289, 37, 18);
		add(label_1);
		/**�꼶*/
		grade = new JComboBox<String>();
		grade.setBounds(612, 283, 87, 25);
		add(grade);
		grade.addItemListener(this);
		grade.addItem("2015");
		grade.addItem("2016");
		grade.addItem("2017");
		grade.addItem("2018");
		grade.addItem("δ֪");
		
		JLabel label_2 = new JLabel("\u4E13\u4E1A");
		label_2.setBounds(288, 286, 37, 18);
		add(label_2);
		/**רҵ*/
		profession = new JTextField();
		profession.setBounds(335, 283, 157, 24);
		add(profession);
		profession.setColumns(10);
		
		JLabel label_3 = new JLabel("\u4F4F\u5740");
		label_3.setBounds(288, 337, 37, 18);
		add(label_3);
		/**סַ*/
		schoolAddress = new JTextField();
		schoolAddress.setBounds(336, 334, 156, 24);
		add(schoolAddress);
		schoolAddress.setColumns(10);
		
		JLabel label_4 = new JLabel("\u73ED\u7EA7");
		label_4.setBounds(569, 337, 37, 18);
		add(label_4);
		/**�༶*/
		classes = new JComboBox<String>();
		classes.setBounds(612, 334, 87, 25);
		add(classes);
		classes.addItemListener(this);
		classes.addItem("1");
		classes.addItem("2");
		classes.addItem("3");
		classes.addItem("4");
		classes.addItem("δ֪");
		
		
		JLabel label_5 = new JLabel("\u7C4D\u8D2F");
		label_5.setBounds(288, 424, 37, 18);
		add(label_5);
		/**����*/
		address = new JTextField();
		address.setBounds(335, 421, 364, 24);
		add(address);
		address.setColumns(10);
		/**�ύ��ť*/
		JButton btnNewButton = new JButton("\u63D0\u4EA4");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(403, 528, 131, 48);
		add(btnNewButton);	
		btnNewButton.addActionListener(this);
		
		JLabel label_6 = new JLabel("\u5B66\u9662");
		label_6.setBounds(288, 387, 37, 18);
		add(label_6);
		
		schoolName = new JTextField();
		schoolName.setBounds(335, 384, 364, 24);
		add(schoolName);
		schoolName.setColumns(10);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(number.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this,"ѧ�Ų���Ϊ�գ�");
			return;
		}else {
			ip.setNumber(number.getText());
		}
		
		if(name.getText().isEmpty()) {
			ip.setName("");
		}else {
			ip.setName(name.getText());
		}
		
		if(profession.getText().isEmpty()) {
			ip.setProfession("");
		}else {
			ip.setProfession(profession.getText());
		}
		
		if(address.getText().isEmpty()) {
			ip.setAddress("");
		}else {
			ip.setAddress(address.getText());
		}
		
		if(schoolAddress.getText().isEmpty()) {
			ip.setSchoolAddress("");
		}else {
			ip.setSchoolAddress(schoolAddress.getText());
		}
		
		if(schoolName.getText().isEmpty()) {
			ip.setSchoolName("");
		}else {
			ip.setSchoolName(schoolName.getText());
		}
		Connection con = null;
		String ssql;
		PreparedStatement ps = null;
		try {
			con = ConnectionDB.getConnection();
			ssql = "INSERT INTO t_student VALUES(?,?,?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(ssql);
			ps.setString(1, ip.getNumber());
			ps.setString(2, ip.getName());
			ps.setString(3, ip.getSex());
			ps.setString(4, ip.getRace());
			ps.setString(5, ip.getGrade());
			ps.setString(6, ip.getProfession());
			ps.setString(7, ip.getClasses());
			ps.setString(8, ip.getAddress());
			ps.setString(9, ip.getSchoolAddress());
			ps.setString(10, ip.getSchoolName());
			ps.executeUpdate();
			JOptionPane.showMessageDialog(this,"д��ɹ���");
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}catch(Exception e2) {
			JOptionPane.showMessageDialog(this,"д��ʧ�ܣ�");
		}
		finally {
			try {
				con.close();
				ps.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}	
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource()==sex) {
			ip.setSex(e.getItem().toString());
		}else if(e.getSource()==classes) {
			ip.setClasses(e.getItem().toString());
		}else if(e.getSource()==race) {
			ip.setRace(e.getItem().toString());
		}else if(e.getSource()==grade) {
			ip.setGrade(e.getItem().toString());
		}
	}
}
