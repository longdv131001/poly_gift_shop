package com.poly.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "authorities")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Authority implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "username")
	private Account account;

	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;
}
