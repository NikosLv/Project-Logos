package com.logos.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.logos.domain.EditRequestProduct;
import com.logos.domain.SimpleFilter;
import com.logos.entity.Product;
import com.logos.mapper.ProductMapper;
import com.logos.entity.Brand;
import com.logos.service.ProductService;
import com.logos.service.cloudinary.CloudinaryService;
import com.logos.service.BrandService;


@Controller
@SessionAttributes({ "brandList", "editProdModel" })
@RequestMapping("/product")
public class ProductController {

	private BrandService brandService;
	private ProductService productService;
	private CloudinaryService cloudinaryService;


	@Autowired
	public ProductController(CloudinaryService cloudinaryService, BrandService brandService,
			ProductService productService) {
		this.cloudinaryService = cloudinaryService;
		this.brandService = brandService;
		this.productService = productService;

	}

	@GetMapping("/add-brand")
	public String showAddBrand(Model model) {
		model.addAttribute("brandModel", new Brand());
		return "product/add-brand";
	}

	@PostMapping("/add-brand")
	public String saveBrand(@Valid @ModelAttribute("brandModel") Brand brand, BindingResult br) {
		if (br.hasErrors()) {
			return "product/add-brand";
		}
		brandService.saveBrand(brand);
		return "redirect:/product/add-brand";
	}

	@GetMapping("/add-product")
	public String showAddProduct(Model model) {

		model.addAttribute("productModel", new com.logos.entity.Product());
		model.addAttribute("brandList", brandService.findAllBrands());

		return "product/add-product";
	}

	@PostMapping("/add-product")
	public ModelAndView saveProduct(@Valid @ModelAttribute("productModel") com.logos.entity.Product product,
			@RequestParam("productImage") MultipartFile file, BindingResult br) {
		if (br.hasErrors() || file.getOriginalFilename().length() <= 0) {
			return new ModelAndView("product/add-product", "errors", "Check the correct data entry");
		}
		;
		productService.saveProduct(product);
		String imageUrl = cloudinaryService.uploadFile(file, "product/" + product.getId());
		product.setImageUrl(imageUrl);
		productService.saveProduct(product);
		return new ModelAndView("admin/dashboard");
	}

	@GetMapping("/productsall")
	public String showAllProductsall(Model model, @PageableDefault Pageable pageable) {
		model.addAttribute("brandList", brandService.findAllBrands());

		Page<Brand> page = brandService.findBrandsByPage(pageable);
		int currentPage = page.getNumber();
		int begin = Math.max(1, currentPage - 5);
		int end = Math.min(begin + 5, page.getNumber());

		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", currentPage);

		model.addAttribute("brandList", page);
		model.addAttribute("brandListByPage", page.getContent());

		return "product/productsall";
	}

	@GetMapping("/productsall/search")
	public String showBrandsByFilter(Model model, @RequestParam(value = "search", required = false) String search) {

		SimpleFilter filter = null;
		if (search != null) {
			filter = new SimpleFilter(search);
		}
		model.addAttribute("brandListByPage", brandService.findAllBrandsByFilter(filter));
		return "product/productsall";
	}

	@GetMapping("/products-by-page")
	public String showProductsPageble(Model model, @PageableDefault Pageable pageable) {

		Page<Brand> page = brandService.findBrandsByPage(pageable);
		int currentPage = page.getNumber();
		int begin = Math.max(1, currentPage - 5);
		int end = Math.min(begin + 5, page.getNumber());

		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", currentPage);

		model.addAttribute("brandList", page);
		model.addAttribute("brandListByPage", page.getContent());
		return "product/product-pages";
	}

	@GetMapping("/delete/{productId}")
	public String deleteProductById(@PathVariable("productId") int id) {
		productService.deleteProductById(id);
		return "redirect:/product/products-by-page";
	}

	@GetMapping("/edit-prod/{productId}")
	public String showEditProd(@PathVariable("productId") int productId, Model model, Principal principal) {

		Product product = productService.findProductById(productId);

		model.addAttribute("editProdModel", ProductMapper.productToEditRequest(product));
		return "product/edit-prod";
	}

	@PostMapping("/edit-prod")
	public ModelAndView saveEditedProduct(@RequestParam("productImage") MultipartFile file,
			@ModelAttribute("editProdModel") EditRequestProduct editRequestProduct, BindingResult br) {
		if (br.hasErrors()) {
			return new ModelAndView("product/edit-prod");
		}
		productService.updateProduct(ProductMapper.editReuqestToProduct(editRequestProduct));
		String imageUrl = cloudinaryService.uploadFile(file, "product/" + editRequestProduct.getId());
		editRequestProduct.setImageUrl(imageUrl);

		productService.updateProduct(ProductMapper.editReuqestToProduct(editRequestProduct));

		return new ModelAndView("redirect:/product/products-by-page");

	}

	@GetMapping("/prodId/{productId}")
	public String showProduct(Model model, @PathVariable("productId") int productId) {

		model.addAttribute("title", "Product Details");
		Product product = productService.findProductById(productId);
		model.addAttribute("productModel", product);
		return "product/prodId";
	}

}
