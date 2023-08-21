package com.ryan.DojoOverFlow.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ryan.DojoOverFlow.models.AnswerModel;
import com.ryan.DojoOverFlow.services.MainService;

import jakarta.validation.Valid;

@Controller
public class AnswerController {

	
	private final MainService mainServ;
	public AnswerController(MainService mainServ) {
		this.mainServ = mainServ;
	}
	
	@PostMapping("/questions/{questId}")
	public String sendAnswer(@Valid @ModelAttribute("answerStr") AnswerModel theAnswer, @PathVariable("questId") Long id, BindingResult result) {
		
		if(result.hasErrors()) {
			return "showinfo.jsp";
		}
		
		mainServ.createAnswer(theAnswer);
		
		ArrayList<AnswerModel> answerArray = new ArrayList<>();
		answerArray.add(theAnswer);
		
		mainServ.findQuestionById(id).setAnswers(answerArray);
		return "redirect:/questions/"+id;
	}
}
