package com.relationship;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
@Entity 
@Data
public class Details implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5045191395177408892L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	
	private int id;
	private String youtube;
	private String twitter;
	@OneToOne(mappedBy="details", cascade = CascadeType.ALL)
	private Instructor instructor;
}
