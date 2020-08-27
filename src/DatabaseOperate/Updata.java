package DatabaseOperate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JTable;

public class Updata {
	
	public Updata(int selectRow,JTable table) {
		Connection con = null;
		String sql;
		PreparedStatement ps = null;
		try {
			con = ConnectionDB.getConnection();
			sql = "UPDATE t_student SET name=?,sex=?,race=?,grade=?,profession=?,classes=?,address=?,"
					+ "schoolAddress=?,schoolName=? where number=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, table.getValueAt(selectRow, 1).toString());
			ps.setString(2, table.getValueAt(selectRow, 2).toString());
			ps.setString(3, table.getValueAt(selectRow, 3).toString());
			ps.setString(4, table.getValueAt(selectRow, 4).toString());
			ps.setString(5, table.getValueAt(selectRow, 5).toString());
			ps.setString(6, table.getValueAt(selectRow, 6).toString());
			ps.setString(7, table.getValueAt(selectRow, 7).toString());
			ps.setString(8, table.getValueAt(selectRow, 8).toString());
			ps.setString(9, table.getValueAt(selectRow, 9).toString());
			ps.setString(10, table.getValueAt(selectRow, 0).toString());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
