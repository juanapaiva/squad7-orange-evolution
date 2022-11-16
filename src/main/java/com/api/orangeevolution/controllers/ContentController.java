package com.api.orangeevolution.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.api.orangeevolution.entities.Content;
import com.api.orangeevolution.repositories.ContentRepository;

@Controller
public class ContentController {

	@Autowired
	private ContentRepository contentRepository;

	@GetMapping("/trilha")
	public ModelAndView roadmap() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("trilhas_usuario");
		return mv;
	}

	@PostMapping("saveContent")
	public ModelAndView signIn(Content content) {
		ModelAndView mv = new ModelAndView();
		contentRepository.save(content);
		return mv;
	}

	@GetMapping("/trilhaAdm")
	public ModelAndView roadmapAdm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("trilhas_adm");
		return mv;
	}
}
