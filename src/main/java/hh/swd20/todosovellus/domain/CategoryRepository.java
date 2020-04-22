package hh.swd20.todosovellus.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import hh.swd20.todosovellus.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

	List<Category> findByName(String name);

	List<Category> deleteByName(String name);
}

