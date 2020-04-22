package hh.swd20.todosovellus;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.todosovellus.domain.Todo;
import hh.swd20.todosovellus.domain.TodoRepository;
import hh.swd20.todosovellus.domain.Category;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TodoRepositoryTest {

	@Autowired
	private TodoRepository repository;
	
	@Test
	public void findByTitleShouldReturnTodo() {
		List<Todo> todos = repository.findByTitleContaining("Veroilmoitus");
		
		assertThat(todos).hasSize(1);
		assertThat(todos.get(0).getDescription()).isEqualTo("Tarkista lainan määrä");
	}
	
	@Test
	public void createNewTodo() {
		Todo todo = new Todo("Soita tk", "Luomitarkistus", new Category("Tehtävät puhelut"));
		repository.save(todo);
		assertThat(todo.getId()).isNotNull();
		
	}
	
	@Test
	public void deleteTodo() {
		List<Todo> todoToDelete = repository.deleteByTitle("Soita tk");
		
		assertThat(todoToDelete).isEmpty();
	}
}
