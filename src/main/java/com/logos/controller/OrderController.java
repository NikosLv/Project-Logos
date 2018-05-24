package com.logos.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.logos.entity.Order;
import com.logos.entity.Product;
import com.logos.entity.User;
import com.logos.service.BrandService;
import com.logos.service.OrderService;
import com.logos.service.ProductService;
import com.logos.service.UserService;


@Controller
@RequestMapping("/order")
public class OrderController {
	
	
	private OrderService orderService;
	private ProductService productService;
	private UserService userService;
	
	
	@Autowired 
	public OrderController(OrderService orderService, ProductService productService, UserService userService) {
		this.userService=userService;
		this.orderService=orderService;
		this.productService=productService;
	}
	
	@GetMapping("/add-order/{productId}")
	public String showAddOrder(Model model,  @PathVariable("productId") int produtId) {  //Principal principal
		
		//String email = principal.getName();
	//	User user = userService.findUserByEmail(email);
		
		model.addAttribute("orderModel", new Order());
		//model.addAttribute("productList", productService.findAllProducts());
		model.addAttribute("productModel", productService.findProductById(produtId));
		return "order/add-order";
	}
	
	@PostMapping("/add-order")
	public String saveOrder(
			@ModelAttribute("orderModel") Order order, Principal principal, BindingResult br) {
		if(br.hasErrors()) {
			return "order/add-order";
		}
		String email = principal.getName();
		User user = userService.findUserByEmail(email);
		order.setUser(user);
		orderService.saveOrder(order);
		return "redirect:/product/productsall";                               
	} 
	
	@GetMapping("/user-order")
	public String showOrder(Model model, @PathVariable("orderId")int orderId) {
		
		
		Order order = orderService.findOrderById(orderId);
		model.addAttribute("userOrder", order);
		
		return "order/user-order";
	}
	
	
	@GetMapping("/all-order")
	public String showAllProductsall(Model model) {
		model.addAttribute("orderList", orderService.findAllOrders());
		return "order/all-order";
	}
	
	@GetMapping("/orderId/{orderId}")
	public String showProduct(Model model, @PathVariable("orderId") int orderId) {
		
		model.addAttribute("title", "Order Details");
		Order order = orderService.findOrderById(orderId);
		model.addAttribute("orderModel", order);
		return "order/orderId";
	}

	
	
	
	

}
