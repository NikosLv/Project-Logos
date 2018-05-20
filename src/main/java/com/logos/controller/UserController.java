package com.logos.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.logos.domain.EditRequest;
import com.logos.entity.User;
import com.logos.mapper.UserMapper;
import com.logos.service.UserService;


@Controller
@RequestMapping("/user")
@SessionAttributes("editModel")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/profile")
	public String showProfile(Model model, Principal principal) {
		
		String email = principal.getName();
		User user = userService.findUserByEmail(email);
		model.addAttribute("userProfile", user);
		
		return "user/profile";
	}
	
	@GetMapping("/users")
		public String showAllUsers(Model model) {
		model.addAttribute("usersList", userService.findAllUsers());
		return "user/users";
	}
		
//*****************EDIT*******************************	

	@GetMapping("/edit")
	public String showEdit(Model model, Principal principal) {
		
		String email = principal.getName();
		User user = userService.findUserByEmail(email);
		
		model.addAttribute("editModel", UserMapper.userToEditRequest(user));
		return "user/edit";
	}

	@PostMapping("/edit")
	public ModelAndView saveEditedUser(@ModelAttribute("editModel") EditRequest editRequest) {

		try {
			userService.updateUser(UserMapper.editReuqestToUser(editRequest));
		} catch (Exception e) {
			return new ModelAndView("user/edit", "error", "Oops ..Can't edit user");
		}
		return new ModelAndView("redirect:/user/profile");

	}	
	
	@GetMapping("/delete/{userId}")
	public String deleteUserById(
			@PathVariable("userId") int id
			) {
		userService.deleteUser(id);
		return "redirect:/user/users";
	}

}
