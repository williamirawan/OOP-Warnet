
public class warnet {

	private Integer MemberPrice;
	private String name;
	private String id;
	private String membership;
	private Integer duration;
	private Integer snack;
	private Integer qty;
	private Integer snackPrice;
	private Integer totalPrice;
	
	public warnet(String name, String id, String membership, Integer duration, Integer snack, Integer qty,
			Integer snackPrice, Integer totalPrice) {
		super();
		this.name = name;
		this.id = id;
		this.membership = membership;
		this.duration = duration;
		this.snack = snack;
		this.qty= qty;
		this.snackPrice = snackPrice;
		this.totalPrice = totalPrice;
	}	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMembership() {
		return membership;
	}
	public void setMembership(String membership) {
		this.membership = membership;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	
	public int getMemberPrice() {
		if(membership.equals("Silver")){
			MemberPrice = 10000 * duration;
		}else if(membership.equals("Gold")){
			MemberPrice = 15000 * duration;
		}else if(membership.equals("Diamond")) {
			MemberPrice = 20000 * duration;
		}
		return MemberPrice;
	}
	
	public void setMemberPrice(Integer MemberPrice) {
		this.MemberPrice = MemberPrice;
	}
	
	public Integer getSnack() {
		return snack;
	}
	public void setSnack(Integer snack) {
		this.snack = snack;
	}
	public Integer getqty() {
		return qty;
	}
	public void setQuantity(Integer qty) {
		this.qty = qty;
	}
	public Integer getSnackPrice() {
		if(snack == 1 || snack == 2 || snack == 7 || snack == 8 ) {
			snackPrice = 5000 * qty;
		}else if(snack == 3 || snack == 5 || snack == 6 ) {
			snackPrice = 8000 * qty;
		}else if(snack == 4) {
			snackPrice = 12000 * qty;
		}
		return snackPrice;
	}

	public void setSnackPrice(Integer snackPrice) {
		this.snackPrice = snackPrice;
	}
	
	public Integer getTotalPrice() {
		totalPrice = snackPrice + getMemberPrice();
		return totalPrice;
	}
	
	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}
