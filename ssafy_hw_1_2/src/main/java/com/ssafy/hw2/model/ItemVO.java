package com.ssafy.hw2.model;

public class ItemVO {
	
	private int seq;
	private String item_code;
	private String item_name;
	private int item_price;
	private String item_corp;
	private Character item_stat;
	private String dt_reg;
	private int cate_seq;
	
	public ItemVO() {};
	
	public ItemVO(int seq, String item_code, String item_name, int item_price, String item_corp, Character item_stat,
			String dt_reg, int cate_seq) {
		super();
		this.seq = seq;
		this.item_code = item_code;
		this.item_name = item_name;
		this.item_price = item_price;
		this.item_corp = item_corp;
		this.item_stat = item_stat;
		this.dt_reg = dt_reg;
		this.cate_seq = cate_seq;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getItem_code() {
		return item_code;
	}

	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public int getItem_price() {
		return item_price;
	}

	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}

	public String getItem_corp() {
		return item_corp;
	}

	public void setItem_corp(String item_corp) {
		this.item_corp = item_corp;
	}

	public Character getItem_stat() {
		return item_stat;
	}

	public void setItem_stat(Character item_stat) {
		this.item_stat = item_stat;
	}

	public String getDt_reg() {
		return dt_reg;
	}

	public void setDt_reg(String dt_reg) {
		this.dt_reg = dt_reg;
	}

	public int getCate_seq() {
		return cate_seq;
	}

	public void setCate_seq(int cate_seq) {
		this.cate_seq = cate_seq;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ItemVO [seq=").append(seq).append(", item_code=").append(item_code).append(", item_name=")
				.append(item_name).append(", item_price=").append(item_price).append(", item_corp=").append(item_corp)
				.append(", item_stat=").append(item_stat).append(", dt_reg=").append(dt_reg).append(", cate_seq=")
				.append(cate_seq).append("]");
		return builder.toString();
	}
	

}