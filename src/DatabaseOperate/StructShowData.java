package DatabaseOperate;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * �Ա����ʽչʾ����
 * @author Xinhai Cao
 *
 */
public class StructShowData extends JScrollPane {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public DefaultTableModel model;
	private String[] title = {"ѧ��","����","�Ա�","����","�꼶","רҵ","�༶","����","סַ","ѧԺ"};
	
	public StructShowData(ResultSet rs) {
		model = new DefaultTableModel();
		model.setRowCount(0);
		model.fireTableDataChanged();
		model.setColumnIdentifiers(title);
		try {
			while(rs.next()) {
				model.addRow(new Object[] {rs.getString("number"),rs.getString("name"),rs.getString("sex"),rs.getString("race"),
						rs.getString("grade"),rs.getString("profession"),rs.getString("classes"),rs.getString("address"),
						rs.getString("schoolAddress"),rs.getString("schoolName")});
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.fireTableDataChanged();
		JTable table = new JTable(model);
		this.setViewportView(table);
	}
}
