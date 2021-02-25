package com.drugstore.Drugstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "tb_product")
@NoArgsConstructor
public class Product {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "ID")
	@Getter
	private long id;
	
	@Column (name = "ICD", nullable = false)
	@Size (min = 1, max = 255)
	@Getter @Setter
	private String ICD;
	
	@Column (name = "Name", nullable = false)
	@Size (min = 1, max = 255)
	@Getter @Setter
	private String name;
	
	@Column (name = "Disease", nullable = false)
	@Size (min = 1, max = 255)
	@Getter @Setter
	private String typeDisease;
	
	@Column (name = "Description", nullable = false)
	@Size (min = 1, max = 255)
	@Getter @Setter
	private String description;
		
	@ManyToOne
	@JsonIgnoreProperties("product")
	@Getter @Setter
	private Category category;

	/*public long getId() {
		return id;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getICD() {
		return ICD;
	}
	public void setICD(String iCD) {
		ICD = iCD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTypeDisease() {
		return typeDisease;
	}
	public void setTypeDisease(String typeDisease) {
		this.typeDisease = typeDisease;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}*/
	
}
