package springcrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springcrud.dao.ProductDao;
import springcrud.model.ProductModel;

@Service
public class ProductService {
	@Autowired
	private ProductDao productDao;

	public ProductService(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	public ProductService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	@Transactional
	public int addProduct(ProductModel p) {
		int insert = this.productDao.insert(p);
		return insert;
	}
	
	@Transactional
	public void updateProduct(ProductModel p) {
		this.productDao.update(p);
	} 
	
	public List<ProductModel> listProduct() {
		return this.productDao.fetchAllProduct();
	}

	
	@Transactional
	public ProductModel getProductById(int id) {
		return this.productDao.fetchSingleProduct(id);
	}

	
	@Transactional
	public boolean removeProduct(int id) {
		return this.productDao.delete(id);
	}
	
	
}
