package DatabaseOperate;

import java.io.File;

import javax.swing.JTable;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class LeadingOut {
	/**
	 * ����������Excel��
	 * @param model DefaultTableModel����
	 * @param url ����·�����ļ���
	 */
	public LeadingOut(JTable table,String url) {
		String[] title = {"ѧ��","����","�Ա�","����","�꼶","רҵ","�༶","����","סַ","ѧԺ"};
		//����Excel�ļ�
		File file = new File(url);
		try {
			file.createNewFile();
			//����������
			WritableWorkbook workbook = Workbook.createWorkbook(file);
			//����sheet
			WritableSheet sheet = workbook.createSheet("sheet1", 0);
			int x = table.getRowCount();
			int y = table.getColumnCount();
			Label label = null;
			//��һ����������
			for (int i = 0; i < y; i++) {
				label = new Label(i,0,title[i]);
				sheet.addCell(label);	
			}
			//׷������
			for (int i = 1; i <= x; i++) {
				label = new Label(0,i,table.getValueAt(i-1, 0).toString());
				sheet.addCell(label);
				label = new Label(1,i,table.getValueAt(i-1, 1).toString());
				sheet.addCell(label);
				label = new Label(2,i,table.getValueAt(i-1, 2).toString());
				sheet.addCell(label);
				label = new Label(3,i,table.getValueAt(i-1, 3).toString());
				sheet.addCell(label);
				label = new Label(4,i,table.getValueAt(i-1, 4).toString());
				sheet.addCell(label);
				label = new Label(5,i,table.getValueAt(i-1, 5).toString());
				sheet.addCell(label);
				label = new Label(6,i,table.getValueAt(i-1, 6).toString());
				sheet.addCell(label);
				label = new Label(7,i,table.getValueAt(i-1, 7).toString());
				sheet.addCell(label);
				label = new Label(8,i,table.getValueAt(i-1, 8).toString());
				sheet.addCell(label);
				label = new Label(9,i,table.getValueAt(i-1, 9).toString());
				sheet.addCell(label);
			}
			//д������
			workbook.write();
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}