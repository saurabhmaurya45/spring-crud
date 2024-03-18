package springcrud.controller;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springcrud.model.ProductModel;
import springcrud.service.ProductService;

@Controller
@RequestMapping("/")
public class HomeController {
	private ProductService productService;

	public HomeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HomeController(ProductService productService) {
		super();
		this.productService = productService;
	}

	public ProductService getProductService() {
		return productService;
	}

	@Autowired
	@Qualifier(value = "productService")
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("product", new ProductModel());
		model.addAttribute("listProducts", this.productService.listProduct());
		return "index";
	}

	// For add and update person both
	@RequestMapping(value = "product/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("product") ProductModel p) {
		System.out.println(p);
		if (p.getId() == 0) {
			// new person, add it
			this.productService.addProduct(p);
		} else {
			// existing person, call update
			this.productService.updateProduct(p);
		}

		return "redirect:/home";

	}

	@RequestMapping("remove/{id}")
	public String removePerson(@PathVariable("id") int id) {
		this.productService.removeProduct(id);
		return "redirect:/home";
	}

	@RequestMapping("edit/{id}")
	public String editPerson(@PathVariable("id") int id, Model model) {
		model.addAttribute("product", this.productService.getProductById(id));
		model.addAttribute("listProducts", this.productService.listProduct());
		return "index";
	}

}
