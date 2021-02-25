package com.gamestore.GameStore.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "tb_category")
@NoArgsConstructor
public class Category {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Getter
	private long id;
	
	@NotNull
	@Size (min = 3, max = 50)
	@Getter @Setter
	private String type; //Action, Fight, Run (...)
	
	@NotNull
	@Size (min = 3, max = 50)
	@Getter @Setter
	private String videogame; //XBox, Nintendo (...)
	
	@NotNull
	@Size (min = 3, max = 255)
	@Getter @Setter
	private String description;
	
	@OneToMany(mappedBy="category", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("category")
		private List<Game> game;
}
