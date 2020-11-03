package com.furkanyilmaz;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Document {

	/**
	 * 
	 */

	@Id
	@GeneratedValue
	private Long id;

	@OneToMany(mappedBy = "parentDocument")
	private List<SubDocument> subDocuments;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<SubDocument> getSubDocuments() {
		return subDocuments;
	}

	public void setSubDocuments(List<SubDocument> subDocuments) {
		this.subDocuments = subDocuments;
	}

}