package com.api.orangeevolution.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.api.orangeevolution.entities.User;
import com.api.orangeevolution.repositories.UserRepository;

@Controller
public class LoginController {
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
	
	@GetMapping("/cadastro")
	public ModelAndView signIn() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", new User());
		mv.setViewName("cadastro");
		return mv;
	}
	
	@PostMapping("saveUser")
	public ModelAndView signIn(User user) {
		ModelAndView mv = new ModelAndView();
		user.setIs_admin("N");
		userRepository.save(user);
		mv.setViewName("redirect:/dashboard_usuario");
		return mv;
	}
}
