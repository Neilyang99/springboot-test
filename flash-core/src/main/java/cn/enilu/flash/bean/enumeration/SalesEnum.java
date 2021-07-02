package cn.enilu.flash.bean.enumeration;

public class SalesEnum {
	
	
	public enum HouseEnum {
		/**
		 * 銷售房屋狀態
		 */
		NOT_SALES("A"), DEAL("B"), CANCEL("C"), CONTRACT("D"), CHECK("E"), HANDOVER("F"), KEEP("G");
		
		private String value;
		
		private HouseEnum(String value) {
			this.value = value;
		}
	
		public String getValue() {
			return value;
		}
	
		
	
	}
	
	 public static void main(String[] args) {
		 
		 System.out.println(HouseEnum.NOT_SALES.getValue());
		 
	 }

}
