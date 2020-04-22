package hh.swd20.todosovellus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import hh.swd20.todosovellus.domain.User;
import hh.swd20.todosovellus.domain.UserRepository;
import hh.swd20.todosovellus.domain.Todo;
import hh.swd20.todosovellus.domain.TodoRepository;
import hh.swd20.todosovellus.domain.Category;
import hh.swd20.todosovellus.domain.CategoryRepository;

@SpringBootApplication
public class TodosovellusApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(TodosovellusApplication.class);
	}
	
	private static final Logger log = LoggerFactory.getLogger(TodosovellusApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TodosovellusApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(CategoryRepository cRepository, TodoRepository tRepository, UserRepository uRepository) {
		return (args) -> {
			
			log.info("some categories saved");
			cRepository.save(new Category("Ostettavaa"));
			cRepository.save(new Category("Muistettavaa"));
			cRepository.save(new Category("Lasten kokotiedot"));
			cRepository.save(new Category("Hoidettavat asiat"));
			cRepository.save(new Category("Koira"));
			
			log.info("all categories fetched:");
			for (Category category : cRepository.findAll()) {
				log.info(category.toString());
			}
			
			log.info("some todos saved");
			tRepository.save(new Todo("Ravintolisät", "Magneesiumsitraattia", cRepository.findByName("Ostettavaa").get(0)));
			tRepository.save(new Todo("Veroilmoitus", "Tarkista lainan määrä", cRepository.findByName("Muistettavaa").get(0)));
			tRepository.save(new Todo("Alexandran kengänkoko", "29 ilman kasvuvaraa, 31 kasvuvaralla", cRepository.findByName("Lasten kokotiedot").get(0)));
			tRepository.save(new Todo("Alexandran tanssi", "Odottaa kunnes Martha tietää", cRepository.findByName("Hoidettavat asiat").get(0)));
			tRepository.save(new Todo("Osta ruokaa", "Joku muu tällä kertaa", cRepository.findByName("Koira").get(0)));
			
			log.info("fetching all todos:");
			for(Todo todo : tRepository.findAll()) {
				log.info(todo.toString());
			}
			
			User user1 = new User("user", "$2a$12$EImQ2TArtJLedQ0YLlxwFe15m4fm3cL7l1vb32cnDQ2hDhqmYlIlK", "user@user.com", "USER");
			User user2 = new User("admin", "$2a$12$vAgpxFLOCFnpUQRY9aBfAOQpEwiztf48qqZUxmqG4ciRWZFVASbj.", "admin@admin.com", "ADMIN");
			uRepository.save(user1);
			uRepository.save(user2);
		};
	}

}
