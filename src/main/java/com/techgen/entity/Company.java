package com.techgen.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "company")
public class Company {

	@EmbeddedId
	private CompanyPrimaryKey companyPrimaryKey;

	private String city;

	private boolean status;

	public Company(CompanyPrimaryKey companyPrimaryKey) {
		super();
		this.companyPrimaryKey = companyPrimaryKey;
	}

}
