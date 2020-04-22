package hh.swd20.todosovellus.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Todo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Size(min=1, max=450)
	private String title;
	private String description;
	private String addition;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "categoryid")
	private Category category;
	
	public Todo() {
		this.title = "";
		this.description = "";
		this.addition = "";
	}
	
	public Todo(String title, String description, Category category) {
		super();
		this.title = title;
		this.description = description;
		this.addition = "";
		this.category = category;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getAddition() {
		return addition;
	}
	
	public void setAddition(String addition) {
		this.addition = addition;
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		if (this.category != null)
			return "Todo [id=" + id + ", title=" + title + ", description=" + description + ", addition=" + addition + " category =" + this.getCategory() +  "]";
		else
			return "Todo [id=" + id + ", title=" + title + ", description=" + description + ", addition=" + addition + "]";
	}
		
}
