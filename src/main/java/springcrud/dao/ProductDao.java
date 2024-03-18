package springcrud.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

import springcrud.model.ProductModel;

@Repository
public class ProductDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public ProductDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductDao(HibernateTemplate hibernateTemplate) {
		super();
		this.hibernateTemplate = hibernateTemplate;
	}

	// insert
	
	public int insert(ProductModel product) {
		Integer r = (Integer) this.hibernateTemplate.save(product);
		return r;
	}


	// update
	
	public void update(ProductModel product) {
		this.hibernateTemplate.update(product);
		

	}

	// get single product
	public ProductModel fetchSingleProduct(int productId) {
		return (ProductModel) this.hibernateTemplate.get(ProductModel.class, productId);
	}

	// get all product
	public List<ProductModel> fetchAllProduct() {
		return this.hibernateTemplate.loadAll(ProductModel.class);
	}

	// delete
	
	public boolean delete(int productId) {
		ProductModel product = this.hibernateTemplate.load(ProductModel.class, productId);
		if (null != product) {
			this.hibernateTemplate.delete(product);
			return true;
		}
		return false;
	}

}
