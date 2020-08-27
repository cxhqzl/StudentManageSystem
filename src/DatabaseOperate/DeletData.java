package DatabaseOperate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JTable;


/**
 * É¾³ýÊý¾Ý
 * @author Xinhai Cao
 *
 */
public class DeletData {
	
	public DeletData(int selectRow,JTable table) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String number = table.getValueAt(selectRow, 0).toString();
		try {
			con = ConnectionDB.getConnection();
			pstmt = con.prepareStatement("DELETE FROM t_student WHERE number="+number);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}
}
