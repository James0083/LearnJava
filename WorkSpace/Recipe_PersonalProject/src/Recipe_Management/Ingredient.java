package Recipe_Management;
/**
 * @author Jaewon You
 * <br>
 * 재료 클래스<br>
 * 재료명, 양, 단위 포함<br>
 *  */
public class Ingredient {
	private String ingre;
	private int quantity;
	private String unit;
	/** 기본생성자 */
	public Ingredient() {
		// TODO Auto-generated constructor stub
	}
	/** 기본생성자 - 재료이름, 양, 단위를 입력받아 초기화 */
	public Ingredient(String ingre, int quantity, String unit) {
		this.ingre = ingre;
		this.quantity = quantity;
		this.unit = unit;
	}
	/** 초기화 메서드 - 재료이름, 양, 단위를 입력받아 초기화  */
	public void setIngredient(String ingre, int quantity, String unit) {
		this.ingre = ingre;
		this.quantity = quantity;
		this.unit = unit;
	}
	/** 재료이름 getter */
	public String getIngre() {
		return this.ingre;
	}
	/** 재료양 getter */
	public int getQuantity() {
		return this.quantity;
	}
	/** 재료 단위 getter */
	public String getUnit() {
		return this.unit;
	}
}
