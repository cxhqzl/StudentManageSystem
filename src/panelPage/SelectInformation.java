package panelPage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import DatabaseOperate.ConnectionDB;
import DatabaseOperate.DeletData;
import DatabaseOperate.LeadingOut;
import DatabaseOperate.Updata;
import main.MainClass;
import paramer.SelectParamer;
/**
 * ��Ϣ��ѯ����
 * @author Xinhai Cao
 *
 */
public class SelectInformation extends JPanel implements ActionListener,ItemListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField SelectKey = new JTextField();;
	JComboBox<String> comboBox;
	JComboBox<String> profession = new JComboBox<String>();
	JComboBox<String> schoolName = new JComboBox<String>();
	/**ѡ�е���*/
	int selectRow;
	/**��ѯ���ı�*/
	JTable table;
	/**����*/
	MainClass mc;
	/**��ѯ������*/
	SelectParamer sp = new SelectParamer();
	/**����ģ�͹���*/
	DefaultTableModel model = new DefaultTableModel();;
	/**��ͷ*/
	private String[] title = {"ѧ��","����","�Ա�","����","�꼶","רҵ","�༶","����","סַ","ѧԺ"};
	
	public SelectInformation(MainClass mc) {
		this.mc = mc;
//		setBackground(Color.CYAN);
		setLayout(null);
		
		JLabel label = new JLabel("\u5B66\u751F\u4FE1\u606F\u67E5\u8BE2");
		label.setFont(new Font("����", Font.PLAIN, 42));
		label.setBounds(353, 13, 262, 90);
		add(label);
		
		JLabel label_1 = new JLabel("\u9009\u62E9\u67E5\u8BE2\u7C7B\u522B");
		label_1.setFont(new Font("����", Font.PLAIN, 22));
		label_1.setBounds(330, 129, 152, 24);
		add(label_1);
		
		JLabel lblNewLabel = new JLabel("\u67E5\u8BE2\u5173\u952E\u5B57");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 22));
		lblNewLabel.setBounds(330, 183, 152, 24);
		add(lblNewLabel);
		
		SelectKey.setBounds(488, 186, 127, 24);
		SelectKey.setColumns(10);
		add(SelectKey);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.setFont(new Font("����", Font.PLAIN, 20));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(125, 250, 132, 47);
		add(btnNewButton);
		btnNewButton.addActionListener(this);
		
		JButton btnNewButton_1 = new JButton("\u5BFC\u51FA");
		btnNewButton_1.setFont(new Font("����", Font.PLAIN, 20));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(737, 250, 132, 47);
		add(btnNewButton_1);
		btnNewButton_1.addActionListener(this);
		
		JButton delet = new JButton("\u5220\u9664");
		delet.setFont(new Font("����", Font.PLAIN, 20));
		delet.setBackground(Color.WHITE);
		delet.setBounds(535, 250, 132, 47);
		delet.addActionListener(this);
		add(delet);
		
		JButton save = new JButton("\u4FDD\u5B58");
		save.setFont(new Font("����", Font.PLAIN, 20));
		save.setBackground(Color.WHITE);
		save.setBounds(330, 250, 132, 47);
		save.addActionListener(this);
		add(save);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(488, 132, 127, 24);
		add(comboBox);
		comboBox.addItemListener(this);
		comboBox.addItem("ȫ��");
		comboBox.addItem("ѧ��");
		comboBox.addItem("����");
		comboBox.addItem("רҵ");
		comboBox.addItem("ѧԺ");
		
		
		profession.setBounds(488, 186, 127, 24);
		profession.addItemListener(this);
		profession.addItem("��������");
		profession.addItem("����������");
		profession.addItem("������Ϣ��");
		profession.addItem("���繤��");
		profession.addItem("�������ѧ�뼼��");
		profession.addItem("�������");
				
		profession.addItem("Ӧ������ѧ");
		profession.addItem("������ʽ���");
		profession.addItem("��������ѧ");
		profession.addItem("��ѧ");
		profession.addItem("��Ṥ��");
		
		profession.addItem("ũѧ");
		profession.addItem("���ӿ�ѧ�빤��");
		profession.addItem("��ҵ��ѧ");
		
		profession.addItem("����ҽѧ");
		profession.addItem("�����ѧ");
		profession.addItem("ˮ����ֳѧ");
		
		profession.addItem("԰��");
		profession.addItem("��ʩũҵ��ѧ�빤��");
		
		profession.addItem("����Ӣ��");
		profession.addItem("����");
		profession.addItem("����");
		profession.addItem("Ӣ��");
		
		profession.addItem("ũҵ��е�������Զ���");
		profession.addItem("ũҵˮ������");
		profession.addItem("��ľ����");
		profession.addItem("�������̼����Զ���");
		profession.addItem("��������");
		
		profession.addItem("԰��");
		profession.addItem("����滮");
		profession.addItem("ľ�Ŀ�ѧ�빤��");
		profession.addItem("���Ͽ�ѧ�빤��");
		profession.addItem("��ѧ");
		
		profession.addItem("��ֲ�����");
		profession.addItem("ֲ�ﱣ��");
		
		profession.addItem("��Ϣ������ѧ");
		profession.addItem("Ӧ�û�ѧ");
		profession.addItem("��湤��");
		profession.addItem("��ͳ��ѧ");
		
		profession.addItem("Ӧ�������ѧ");
		profession.addItem("������ҩ");
		profession.addItem("�����ѧ��");
		
		profession.addItem("��Ϣ��������Ϣϵͳ");
		profession.addItem("����������");
		profession.addItem("ũ�־��ù���");
		profession.addItem("���ʾ�����ó��");
		profession.addItem("���̹�����");
		profession.addItem("�г�Ӫ��");
		profession.addItem("���ι���");
		profession.addItem("����ѧ");
		profession.addItem("����ѧ");
		
		profession.addItem("��ѧ");
		profession.addItem("ʳƷ������Ӫ��ѧ");
		profession.addItem("ʳƷ��ѧ�빤��");
		profession.addItem("ʳƷ�����밲ȫ");
		
		profession.addItem("ũҵ��Դ�뻷��");
		profession.addItem("������Ϣ��ѧ");
		profession.addItem("��������");
		profession.addItem("������ѧ");
		profession.addItem("��̬ѧ");
		
		profession.addItem("��Ʒ���");
		profession.addItem("��װ����");
		profession.addItem("��װ��������");
		profession.addItem("��װ����빤��");
		profession.addItem("�������");
		profession.addItem("��֯����");
		profession.addItem("�Ӿ��������");
		
		schoolName.setBounds(488, 186, 127, 24);
		schoolName.addItemListener(this);
		
		schoolName.addItem("��Ϣ������ѧԺ");
		schoolName.addItem("��������ѧѧԺ");
		schoolName.addItem("ũѧԺ");
		schoolName.addItem("����Ƽ�ѧԺ");
		schoolName.addItem("԰��ѧԺ");
		schoolName.addItem("�����ѧԺ");
		schoolName.addItem("��ѧԺ");
		schoolName.addItem("��ѧ��԰��ѧԺ");
		schoolName.addItem("ֲ�ﱣ��ѧԺ");
		schoolName.addItem("��ѧԺ");
		schoolName.addItem("������ѧѧԺ");
		schoolName.addItem("���ù���ѧԺ");
		schoolName.addItem("����ʳƷ�Ƽ�ѧԺ");
		schoolName.addItem("��Դ�뻷��ѧԺ");
		schoolName.addItem("��Ĺ���������ѧԺ");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand()=="��ѯ") {
			model.setRowCount(0);
			model.fireTableDataChanged();
			model.setColumnIdentifiers(title);
			Connection con = null;
			Statement stmt = null;
			ResultSet rs = null;
			String sql = null;
			try {
				con = ConnectionDB.getConnection();
				stmt = con.createStatement();
				switch(sp.getSelectClass()) {
				case "ȫ��":
					sql = "SELECT * FROM t_student WHERE 1=1";
					break;
				case "ѧ��":
					sp.setSelectKey(SelectKey.getText());
					sql = "SELECT * FROM t_student WHERE number="+sp.getSelectKey();
					break;
				case "����":
					sp.setSelectKey(SelectKey.getText());
					sql = "SELECT * FROM t_student WHERE name ='"+sp.getSelectKey()+"'";
					break;
				case "רҵ":
					sql = "SELECT * FROM t_student WHERE profession ='"+sp.getChoiceKey()+"'";
					break;
				case "ѧԺ":
					sql = "SELECT * FROM t_student WHERE schoolName ='"+sp.getChoiceKey()+"'";
					break;
				default:
					break;
				}
				
				rs = stmt.executeQuery(sql);
				try {
					while(rs.next()) {
						model.addRow(new Object[] {rs.getString("number"),rs.getString("name"),rs.getString("sex"),rs.getString("race"),
								rs.getString("grade"),rs.getString("profession"),rs.getString("classes"),rs.getString("address"),
								rs.getString("schoolAddress"),rs.getString("schoolName")});
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				model.fireTableDataChanged();
				table = new JTable(model);
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				ListSelectionModel rowSM = table.getSelectionModel();
				rowSM.addListSelectionListener(new ListSelectionListener() {
					
					@Override
					public void valueChanged(ListSelectionEvent e) {
						if(e.getValueIsAdjusting()) {
							return;
						}
						ListSelectionModel lsm = (ListSelectionModel) e.getSource();
						if(lsm.isSelectionEmpty()) {
							selectRow = -1;
						}else {
							selectRow = lsm.getAnchorSelectionIndex();
						}
					}
				});
				JScrollPane jp = new JScrollPane();
				jp.setViewportView(table);
				jp.setBounds(50, 300, 900, 300);
				jp.setBackground(Color.cyan);
				add(jp);
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}finally {
				try {
					con.close();
					rs.close();
					stmt.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
			
		}else if(e.getActionCommand().equals("����")) {
			ConfirmDlgTest cd = new ConfirmDlgTest(mc.frame,"ȷ�ϱ�����ģ�","ȷ�ϲ���");
			if(cd.ans) {
				new Updata(selectRow,table);
			}
		}else if(e.getActionCommand().equals("ɾ��")) {
			ConfirmDlgTest cd = new ConfirmDlgTest(mc.frame,"ȷ��ɾ����","ȷ�ϲ���");
			if(cd.ans) {
				new DeletData(selectRow,table);
				model.removeRow(selectRow);
				table = new JTable(model);
				JScrollPane jp = new JScrollPane();
				jp.setViewportView(table);
				jp.setBounds(50, 300, 900, 300);
				jp.setBackground(Color.CYAN);;
				add(jp);
			}
			
		}else if(e.getActionCommand()=="����") {
			if(model==null) {
				JOptionPane.showMessageDialog(this,"��ѡ�񵼳��");
			}else {
				FileDialog saveFile = new FileDialog(mc.frame, "�����ļ�", FileDialog.SAVE);
				saveFile.setVisible(true);
				
				String path = saveFile.getDirectory();
				String name = saveFile.getFile();
				if (path == null || name == null)
					JOptionPane.showMessageDialog(this,"��ѡ���ļ�λ�ã�");
				else {
					new LeadingOut(table,path+"/"+name+".xls");
					JOptionPane.showMessageDialog(this,"�����ɹ���");
				}
			}
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource()==comboBox) {
			sp.setSelectClass(e.getItem().toString());
			if(e.getItem().toString().equals("ȫ��")) {
				this.remove(SelectKey);
				this.remove(profession);
				this.remove(schoolName);
			}else if(e.getItem().toString().equals("ѧ��")||e.getItem().toString().equals("����")) {
				this.remove(profession);
				this.remove(schoolName);
				this.add(SelectKey);
			}else if(e.getItem().toString().equals("רҵ")) {
				this.remove(SelectKey);
				this.remove(schoolName);
				this.add(profession);
			}else if(e.getItem().toString().equals("ѧԺ")) {
				this.remove(SelectKey);
				this.remove(profession);
				this.add(schoolName);
			}
		}else if(e.getSource()==profession||e.getSource()==schoolName) {
			sp.setChoiceKey(e.getItem().toString());
		}
	}
}
/*
 * ��������
 */
class ConfirmDlgTest implements ActionListener{

	JDialog dlg;
	JButton btnY = new JButton("��");
	JButton btnN = new JButton("��");
	Panel p1 = new Panel();
	Panel p2 = new Panel();
	boolean ans;
	/**
	 * �Ի���
	 * @param own ����
	 * @param str1 ��ʾ��Ϣ
	 * @param str2 �Ի�������
	 */
	ConfirmDlgTest(Frame own,String str1,String str2){
		Label message = new Label(str1);
		btnY.addActionListener(this);
		btnN.addActionListener(this);
		dlg = new JDialog(own,str2,true);
		p1.add(message);
		p2.add(btnY);
		p2.add(btnN);
		dlg.add(p1,BorderLayout.NORTH);
		dlg.add(p2,BorderLayout.SOUTH);
		dlg.setBounds(500, 500, 300, 150);;
		dlg.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		dlg.dispose();
		if(e.getSource()==btnY)
			ans=true;
		else
			ans=false;
	}
	
}