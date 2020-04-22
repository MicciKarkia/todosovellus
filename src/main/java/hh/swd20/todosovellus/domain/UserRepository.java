package hh.swd20.todosovellus.domain;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.CrudRepository;

import hh.swd20.todosovellus.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}
