package springcrud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="master_product")
public class ProductModel {
	@Id
	@Column(name="product_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String product_name;
	private String description;
	private int stock;
	private int rate;
	private String product_image;
	
	
	public ProductModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductModel(int id, String product_name, String description, int stock, int rate, String product_image) {
		super();
		this.id = id;
		this.product_name = product_name;
		this.description = description;
		this.stock = stock;
		this.rate = rate;
		this.product_image = product_image;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public String getProduct_image() {
		return product_image;
	}
	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}
	@Override
	public String toString() {
		return "ProductModel [id=" + id + ", product_name=" + product_name + ", description=" + description + ", stock="
				+ stock + ", rate=" + rate + ", product_image=" + product_image + "]";
	}
	
	
	
	
}
