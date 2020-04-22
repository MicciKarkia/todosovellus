package hh.swd20.todosovellus;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.todosovellus.domain.Category;
import hh.swd20.todosovellus.domain.CategoryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {
	
	@Autowired
	private CategoryRepository repository;
	
	@Test
	public void findByNameShouldReturnCategory() {
		List<Category> categories = repository.findByName("Ostettavaa");
		
		assertThat(categories).hasSize(1);
		assertThat(categories.get(0).getName()).isEqualTo("Ostettavaa");
	}
	
	@Test
	public void createNewCategory() {
		Category category = new Category("Syntymäpäivät");
		repository.save(category);
		assertThat(category.getCategoryid()).isNotNull();
	}
	
	@Test
	public void deleteCategory() {
		List<Category> categoryToDelete = repository.deleteByName("Syntymäpäivät");
		
		
		
		assertThat(categoryToDelete).isEmpty();
		
	}
	

}
