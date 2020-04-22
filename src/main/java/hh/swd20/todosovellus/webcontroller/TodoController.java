package hh.swd20.todosovellus.webcontroller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import hh.swd20.todosovellus.domain.Todo;
import hh.swd20.todosovellus.domain.TodoRepository;
import hh.swd20.todosovellus.domain.CategoryRepository;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TodoController {
	@Autowired
	private TodoRepository todorepository;
	@Autowired
	private CategoryRepository categoryrepository;
	
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("todos", todorepository.findAll());
		return "index";
	}
	
	@RequestMapping(value = "/todolist")
	public String getAllTodos(Model model) {
		model.addAttribute("todos", todorepository.findAll());
		return "todolist";
	}
	
	
	@RequestMapping(value="/todos", method = RequestMethod.GET)
	public @ResponseBody List<Todo> todoListRest() {
		return (List<Todo>) todorepository.findAll();
	}
	
	@RequestMapping(value="/todo/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Todo> findTodoRest(@PathVariable("id") Long todoId) {
		return todorepository.findById(todoId);
	}
	
	@RequestMapping(value = "/add")
	public String getNewForm(Model model) {
		model.addAttribute("todo", new Todo());
		model.addAttribute("categories", categoryrepository.findAll());
		return "addtodo";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid Todo todo, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("categories", categoryrepository.findAll());
			return "addtodo";
		}
		todorepository.save(todo);
		return "redirect:todolist";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Long todoId, Model model) {
		todorepository.deleteById(todoId);
		return "redirect:../todolist";	
	}
	
	@RequestMapping(value = "/edit/{id}")
	public String getEditForm(@PathVariable("id") Long todoId, Model model) {
		model.addAttribute("todo", todorepository.findById(todoId));
		model.addAttribute("categories", categoryrepository.findAll());
		return "edittodo";
	}
	
	@RequestMapping(value = "/cancel")
	public String cancel() {
		return "redirect:todolist";
	}
	
}
