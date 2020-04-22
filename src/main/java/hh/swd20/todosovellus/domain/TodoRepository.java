package hh.swd20.todosovellus.domain;

import hh.swd20.todosovellus.domain.Todo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TodoRepository extends CrudRepository<Todo, Long> {
	
	List<Todo> findByTitleContaining(String title);
	
	List<Todo> findByAddition(@Param("addition") String addition);
	
	List<Todo> deleteByTitle(String title);

}
