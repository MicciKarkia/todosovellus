package hh.swd20.todosovellus;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.todosovellus.webcontroller.TodoController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TodosovellusApplicationTests {
	
	@Autowired
	private TodoController controller;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

}
