package paramer;

public class SelectParamer {
	/**查询类别选择结果*/
	private String selectClass;
	/**查询关键字输入结果*/
	private String selectKey;
	/**查询关键字选择结果*/
	private String choiceKey;
	
	public SelectParamer() {
		
	}

	public String getSelectClass() {
		return selectClass;
	}

	public void setSelectClass(String selectClass) {
		this.selectClass = selectClass;
	}

	public String getSelectKey() {
		return selectKey;
	}

	public void setSelectKey(String selectKey) {
		this.selectKey = selectKey;
	}

	public String getChoiceKey() {
		return choiceKey;
	}

	public void setChoiceKey(String choiceKey) {
		this.choiceKey = choiceKey;
	}
	
	
}
