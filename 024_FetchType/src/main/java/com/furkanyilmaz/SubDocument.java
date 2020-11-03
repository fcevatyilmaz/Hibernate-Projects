package com.furkanyilmaz;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SubDocument {

	/**
	 * 
	 */

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	@ManyToOne(fetch = FetchType.LAZY)
	private Document parentDocument;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Document getParentDocument() {
		return parentDocument;
	}

	public void setParentDocument(Document parentDocument) {
		this.parentDocument = parentDocument;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}