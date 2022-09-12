package com.exchangeRate.exchangeApplication.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Entity
public class Users  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Size(min = 1, message = "{validation.name.size.too_short}")
	@Size(max = 100, message = "{validation.name.size.too_long}")
	@Column(name="serial_number")
	private int serialNumber;

	@Column(name="user_name")
	private String userName;
	@Column(name="password")
	private String password;
	
	

}