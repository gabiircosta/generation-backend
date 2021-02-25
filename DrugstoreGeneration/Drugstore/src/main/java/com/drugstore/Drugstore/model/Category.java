package com.drugstore.Drugstore.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
	@Column (name = "ID")
	@Getter
	private long id;
	
	@Column (name = "Sections", nullable = false)
	@Size (min = 1, max = 255)
	@Getter @Setter
	private String sections;
	//Medicamentos, Estética, Higiene Pessoal, Mamãe & Bebê
	
	@Column (name = "Description", nullable = false)
	@Size (min = 1, max = 255)
	@Getter @Setter
	private String description;
	//breve descrição da categoria

	@OneToMany(mappedBy="category", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("category")
		private List<Product> product;
	
	/*public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSections() {
		return sections;
	}

	public void setSections(String sections) {
		this.sections = sections;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}*/

		
}
