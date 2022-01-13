package com.phucle.spring.jpa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.phucle.spring.jpa.entity.Customer;
import com.phucle.spring.jpa.entity.Hobby;
import com.phucle.spring.jpa.entity.Province;
import com.phucle.spring.jpa.service.BaseService;

@Controller
@RequestMapping("/hobby")
public class HobbyController {
	@Autowired
	private BaseService<Customer> customerService;
	
	@Autowired
    private BaseService<Province> provinceService;
	
	@Autowired
	private BaseService<Hobby> hobbyService;
	
	@ModelAttribute("provinces")
	public List<Province> provinces(){
	        return provinceService.getAll();
	}
	
	@ModelAttribute("customers")
	public List<Customer> customers(){
	        return customerService.getAll();
	}
	
	@GetMapping("/list")
	public String listHobbies(Model theModel) {
		List<Hobby> theHobbies = hobbyService.getAll();
		theModel.addAttribute("hobbies", theHobbies);
	
		
		return "list-hobbies";
	}
	
	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		//LOG.debug("inside show customer-form handler method");
		Hobby theHobby = new Hobby();
		theModel.addAttribute("hobby", theHobby);
		
		return "hobby-form";
	}
	
	@PostMapping("/saveHobby")
	public String saveHobby(@Valid@ModelAttribute("hobby") Hobby theHobby,BindingResult theBindingResult) {

		 if(theBindingResult.hasErrors()) 
			 return "hobby-form"; 
		 else
		 
		hobbyService.save(theHobby);	
		return "redirect:/hobby/list";
	}
	
	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("hobbiesId") int theId,
									Model theModel)  {
		Hobby theHobby = hobbyService.getByID(theId);	
		theModel.addAttribute("hobby", theHobby);
		return "hobby-form";
	}
	
	@GetMapping("/delete")
	public String deleteHobby(@RequestParam("hobbiesId") int theId)  {
		hobbyService.deleteById(theId);
		return "redirect:/hobby/list";
	}

}
