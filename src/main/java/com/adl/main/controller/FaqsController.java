package com.adl.main.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.adl.main.model.CommonQAModel;
import com.adl.main.model.PreventionModel;
import com.adl.main.repository.CommonQARepository;
import com.adl.main.utility.FileUtility;

@Controller
public class FaqsController {
	@Autowired
	CommonQARepository qaRepo;

	@GetMapping("/faqs")
	public String faqs(Model model) {
		List<CommonQAModel> lstQA = qaRepo.findAll();

		model.addAttribute("lstQA",lstQA);
		
		return "faqs";
	}
	
	@GetMapping("/faqs/input")
	public String faqsInput(Model model) {
		model.addAttribute("qaModel", new CommonQAModel());
		
		return "input_qa";
	}
	

	
	@PostMapping("/faqs/input")
	public String inputPrevention(
			@ModelAttribute("qaModel") CommonQAModel data,
			Model model,
			@RequestParam("file") MultipartFile file) throws IOException {
		
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		String type =file.getContentType();
		if(type.equalsIgnoreCase("image/png") || type.equalsIgnoreCase("image/jpeg")) {
			String uploadDir = "qa-images/";
			
			FileUtility.saveFile(file, uploadDir, fileName);
			data.setImage(fileName);
			this.qaRepo.save(data);
		}else {
			System.out.println("Bukan format yang benar");
		}
		
		return "redirect:/faqs/input";
	}
}
