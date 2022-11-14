package com.api.orangeevolution.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContentController {

	@GetMapping("/trilha")
	public ModelAndView roadmap() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("trilhas_usuario");
		return mv;
	}
}
