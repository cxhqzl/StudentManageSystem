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
 * 信息查询界面
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
	/**选中的行*/
	int selectRow;
	/**查询出的表*/
	JTable table;
	/**主类*/
	MainClass mc;
	/**查询参数类*/
	SelectParamer sp = new SelectParamer();
	/**数据模型构造*/
	DefaultTableModel model = new DefaultTableModel();;
	/**表头*/
	private String[] title = {"学号","姓名","性别","民族","年级","专业","班级","籍贯","住址","学院"};
	
	public SelectInformation(MainClass mc) {
		this.mc = mc;
//		setBackground(Color.CYAN);
		setLayout(null);
		
		JLabel label = new JLabel("\u5B66\u751F\u4FE1\u606F\u67E5\u8BE2");
		label.setFont(new Font("宋体", Font.PLAIN, 42));
		label.setBounds(353, 13, 262, 90);
		add(label);
		
		JLabel label_1 = new JLabel("\u9009\u62E9\u67E5\u8BE2\u7C7B\u522B");
		label_1.setFont(new Font("宋体", Font.PLAIN, 22));
		label_1.setBounds(330, 129, 152, 24);
		add(label_1);
		
		JLabel lblNewLabel = new JLabel("\u67E5\u8BE2\u5173\u952E\u5B57");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 22));
		lblNewLabel.setBounds(330, 183, 152, 24);
		add(lblNewLabel);
		
		SelectKey.setBounds(488, 186, 127, 24);
		SelectKey.setColumns(10);
		add(SelectKey);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(125, 250, 132, 47);
		add(btnNewButton);
		btnNewButton.addActionListener(this);
		
		JButton btnNewButton_1 = new JButton("\u5BFC\u51FA");
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(737, 250, 132, 47);
		add(btnNewButton_1);
		btnNewButton_1.addActionListener(this);
		
		JButton delet = new JButton("\u5220\u9664");
		delet.setFont(new Font("宋体", Font.PLAIN, 20));
		delet.setBackground(Color.WHITE);
		delet.setBounds(535, 250, 132, 47);
		delet.addActionListener(this);
		add(delet);
		
		JButton save = new JButton("\u4FDD\u5B58");
		save.setFont(new Font("宋体", Font.PLAIN, 20));
		save.setBackground(Color.WHITE);
		save.setBounds(330, 250, 132, 47);
		save.addActionListener(this);
		add(save);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(488, 132, 127, 24);
		add(comboBox);
		comboBox.addItemListener(this);
		comboBox.addItem("全部");
		comboBox.addItem("学号");
		comboBox.addItem("姓名");
		comboBox.addItem("专业");
		comboBox.addItem("学院");
		
		
		profession.setBounds(488, 186, 127, 24);
		profession.addItemListener(this);
		profession.addItem("物流工程");
		profession.addItem("物联网工程");
		profession.addItem("电子信息类");
		profession.addItem("网络工程");
		profession.addItem("计算机科学与技术");
		profession.addItem("计算机类");
				
		profession.addItem("应用心理学");
		profession.addItem("汉语国际教育");
		profession.addItem("汉语言文学");
		profession.addItem("法学");
		profession.addItem("社会工作");
		
		profession.addItem("农学");
		profession.addItem("种子科学与工程");
		profession.addItem("草业科学");
		
		profession.addItem("动物医学");
		profession.addItem("动物科学");
		profession.addItem("水产养殖学");
		
		profession.addItem("园艺");
		profession.addItem("设施农业科学与工程");
		
		profession.addItem("商务英语");
		profession.addItem("日语");
		profession.addItem("法语");
		profession.addItem("英语");
		
		profession.addItem("农业机械化及其自动化");
		profession.addItem("农业水利工程");
		profession.addItem("土木工程");
		profession.addItem("电气工程及其自动化");
		profession.addItem("车辆工程");
		
		profession.addItem("园林");
		profession.addItem("城乡规划");
		profession.addItem("木材科学与工程");
		profession.addItem("材料科学与工程");
		profession.addItem("林学");
		
		profession.addItem("动植物检疫");
		profession.addItem("植物保护");
		
		profession.addItem("信息与计算科学");
		profession.addItem("应用化学");
		profession.addItem("测绘工程");
		profession.addItem("用统计学");
		
		profession.addItem("应用生物科学");
		profession.addItem("生物制药");
		profession.addItem("生物科学类");
		
		profession.addItem("信息管理与信息系统");
		profession.addItem("公共管理类");
		profession.addItem("农林经济管理");
		profession.addItem("国际经济与贸易");
		profession.addItem("工商管理类");
		profession.addItem("市场营销");
		profession.addItem("旅游管理");
		profession.addItem("经济学");
		profession.addItem("金融学");
		
		profession.addItem("茶学");
		profession.addItem("食品卫生与营养学");
		profession.addItem("食品科学与工程");
		profession.addItem("食品质量与安全");
		
		profession.addItem("农业资源与环境");
		profession.addItem("地理信息科学");
		profession.addItem("环境工程");
		profession.addItem("环境科学");
		profession.addItem("生态学");
		
		profession.addItem("产品设计");
		profession.addItem("包装工程");
		profession.addItem("服装与服饰设计");
		profession.addItem("服装设计与工程");
		profession.addItem("环境设计");
		profession.addItem("纺织工程");
		profession.addItem("视觉传达设计");
		
		schoolName.setBounds(488, 186, 127, 24);
		schoolName.addItemListener(this);
		
		schoolName.addItem("信息与计算机学院");
		schoolName.addItem("人文社会科学学院");
		schoolName.addItem("农学院");
		schoolName.addItem("动物科技学院");
		schoolName.addItem("园艺学院");
		schoolName.addItem("外国语学院");
		schoolName.addItem("工学院");
		schoolName.addItem("林学与园林学院");
		schoolName.addItem("植物保护学院");
		schoolName.addItem("理学院");
		schoolName.addItem("生命科学学院");
		schoolName.addItem("经济管理学院");
		schoolName.addItem("茶与食品科技学院");
		schoolName.addItem("资源与环境学院");
		schoolName.addItem("轻纺工程与艺术学院");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand()=="查询") {
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
				case "全部":
					sql = "SELECT * FROM t_student WHERE 1=1";
					break;
				case "学号":
					sp.setSelectKey(SelectKey.getText());
					sql = "SELECT * FROM t_student WHERE number="+sp.getSelectKey();
					break;
				case "姓名":
					sp.setSelectKey(SelectKey.getText());
					sql = "SELECT * FROM t_student WHERE name ='"+sp.getSelectKey()+"'";
					break;
				case "专业":
					sql = "SELECT * FROM t_student WHERE profession ='"+sp.getChoiceKey()+"'";
					break;
				case "学院":
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
			
		}else if(e.getActionCommand().equals("保存")) {
			ConfirmDlgTest cd = new ConfirmDlgTest(mc.frame,"确认保存更改？","确认操作");
			if(cd.ans) {
				new Updata(selectRow,table);
			}
		}else if(e.getActionCommand().equals("删除")) {
			ConfirmDlgTest cd = new ConfirmDlgTest(mc.frame,"确认删除？","确认操作");
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
			
		}else if(e.getActionCommand()=="导出") {
			if(model==null) {
				JOptionPane.showMessageDialog(this,"请选择导出项！");
			}else {
				FileDialog saveFile = new FileDialog(mc.frame, "保存文件", FileDialog.SAVE);
				saveFile.setVisible(true);
				
				String path = saveFile.getDirectory();
				String name = saveFile.getFile();
				if (path == null || name == null)
					JOptionPane.showMessageDialog(this,"请选择文件位置！");
				else {
					new LeadingOut(table,path+"/"+name+".xls");
					JOptionPane.showMessageDialog(this,"导出成功！");
				}
			}
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource()==comboBox) {
			sp.setSelectClass(e.getItem().toString());
			if(e.getItem().toString().equals("全部")) {
				this.remove(SelectKey);
				this.remove(profession);
				this.remove(schoolName);
			}else if(e.getItem().toString().equals("学号")||e.getItem().toString().equals("姓名")) {
				this.remove(profession);
				this.remove(schoolName);
				this.add(SelectKey);
			}else if(e.getItem().toString().equals("专业")) {
				this.remove(SelectKey);
				this.remove(schoolName);
				this.add(profession);
			}else if(e.getItem().toString().equals("学院")) {
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
 * 弹出窗口
 */
class ConfirmDlgTest implements ActionListener{

	JDialog dlg;
	JButton btnY = new JButton("是");
	JButton btnN = new JButton("否");
	Panel p1 = new Panel();
	Panel p2 = new Panel();
	boolean ans;
	/**
	 * 对话框
	 * @param own 窗体
	 * @param str1 提示信息
	 * @param str2 对话框名称
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