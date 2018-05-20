package com.logos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.logos.domain.AddUserRequest;
import com.logos.entity.User;
import com.logos.mail.Mail;
import com.logos.mapper.UserMapper;

import com.logos.service.EmailService;
import com.logos.service.UserService;
import com.logos.service.utils.RandomToken;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;
	@Autowired
	private EmailService emailService;

	@GetMapping("/")
	public ModelAndView showHome() {
		return new ModelAndView("home");
	}

	@GetMapping("/login")
	public ModelAndView showLogin() {
		return new ModelAndView("login");
	}
	
	@GetMapping("/register")
	public String showRegisterPage(Model model) {
		model.addAttribute("registerModel", new AddUserRequest());
		return "/register";
	}

	@PostMapping("/register")
	public String registerUser(@ModelAttribute("registerModel") AddUserRequest request, Model model) {

		if (request.getPassword().equals(request.getPasswordConfirmation())) {

			User user = UserMapper.registerRequestToUser(request);
			String token = RandomToken.generateToken();

			System.out.println("Token" + token);
			user.setToken(token);

			userService.saveUser(user);

//			Mail mail = new Mail();
//			mail.setTo(request.getEmail());
//			mail.setSubject("You are registrired in our shop <<Detal Auto>>!");
//			mail.setContent("Please verify your email adress by link: " + "http://localhost:8080/verify?token=" + token
//					+ "&userid=" + user.getId());
//			emailService.sendMessage(mail);

		} else {
			model.addAttribute("registerModel", new AddUserRequest());
			return "/register";
		}
		return "redirect:/";
	}

	@GetMapping("/verify")
	public String verifyEmail(@RequestParam("token") String token, @RequestParam("userid") String userId) {

		User user = userService.findUserById(Integer.valueOf(userId));
		if (user.getToken().equals(token)) {
			user.setToken(null);
			userService.updateUser(user);
		} else {
			return "redirect:/validate=false";
		}
		return "home";
	}

	@GetMapping("/contact")
	public String showContact() {
		return "contact";
	}

	@GetMapping("/payment-shipping")
	public String showPayment() {
		return "payment-shipping";
	}
	
	@GetMapping("/dashboard")
	public ModelAndView showDash() {
		return new ModelAndView("dashboard");
	}

}
