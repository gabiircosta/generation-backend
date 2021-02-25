package com.gamestore.GameStore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "tb_game")
@NoArgsConstructor
public class Game {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Getter
	private long id;
	
	@NotNull
	@Size (min = 3, max = 50)
	@Getter @Setter
	private String name;
	
	@NotNull
	@Size (min = 1, max = 3)
	@Getter @Setter
	private int age;
	
	@ManyToOne
	@JsonIgnoreProperties("game")
	@Getter @Setter
	private Category category;
}
