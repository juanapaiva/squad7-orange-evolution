package com.api.orangeevolution.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
	public ModelAndView index() {
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
	public ModelAndView signIn(@Valid User user, BindingResult br) {
		ModelAndView mv = new ModelAndView();
		if (br.hasErrors()) {
			mv.setViewName("cadastro");
		}
		user.setIs_admin("N");
		userRepository.save(user);
		mv.setViewName("redirect:/");
		return mv;
	}

	public ModelAndView login(User user, BindingResult br, HttpSession session)  {
		ModelAndView mv = new ModelAndView();
		return mv;
	}
}
