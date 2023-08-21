package com.ryan.DojoOverFlow.controllers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ryan.DojoOverFlow.models.AnswerModel;
import com.ryan.DojoOverFlow.models.QuestionModel;
import com.ryan.DojoOverFlow.models.QuestionTagModel;
import com.ryan.DojoOverFlow.models.TagModel;
import com.ryan.DojoOverFlow.services.MainService;

import jakarta.validation.Valid;


@Controller
public class QuestionController {
	
	private final MainService mainServ;
	public QuestionController(MainService service) {
		this.mainServ = service;
	}
	
	
	@GetMapping("/questions")
	public String index(Model viewModel) {
		
		List<QuestionModel> object = mainServ.allQuestion();
		viewModel.addAttribute("quest", object);
		return "index.jsp";
	}
	
	
	@GetMapping("/questions/new")
	public String renderInfo(@ModelAttribute("questionTag") QuestionTagModel questionTag) {
		return "newquestion.jsp";
	}
	
	@GetMapping("/questions/{questionId}")
	public String showQuestion(@ModelAttribute("answerStr") AnswerModel answer,@PathVariable("questionId") Long id, Model viewModel) {
		viewModel.addAttribute("question", mainServ.findQuestionById(id));
		viewModel.addAttribute("tags", mainServ.findQuestionById(id).getTags());
		viewModel.addAttribute("answer", mainServ.findQuestionById(id).getAnswers());
		return "showinfo.jsp";
	}
	
	@PostMapping("/questions/new")
	public String sendForm(@Valid @ModelAttribute("questionTag") QuestionTagModel questionTag, BindingResult result,
			RedirectAttributes rAtt) {

		if (result.hasErrors()) {
			return "newquestion.jsp";
		}
		
		// AGARRA LOS TAGS Y LO PARTE EN PALABRAS SEPARADAS POR COMAS
		String[] tags = questionTag.getTag().getSubject().split(",");

		if(tags.length > 3) {
			rAtt.addFlashAttribute("error", "no agregues mas de 3 tags");
			return "redirect:/questions/new";
		}

		// CREA ARRAY DE TAGS VACIO
		ArrayList<TagModel> arrayTag = new ArrayList<>();

		//AGARRO LA PREGUNTA
		QuestionModel quest = questionTag.getQuestion();
		
		// AÑADIR VALORES AL ARRAY
		for (String tag : tags) {

			String check = tag.trim().toLowerCase();

			TagModel tagIsHere = mainServ.checkTag(check);

			// SI NO EXISTE CREA
			if (tagIsHere == null) {
				TagModel newTag = new TagModel();
				newTag.setSubject(check);
				arrayTag.add(newTag);
			} else {
				arrayTag.add(tagIsHere);
			}

		}
		
		// GUARDA LA PREGUNTA CON LOS TAGS
		for (TagModel etiqueta : arrayTag) {
			mainServ.createTag(etiqueta);
		}
		quest.setTags(arrayTag);
		
		mainServ.createQuestion(quest);

		return "redirect:/";

	}
	
}












