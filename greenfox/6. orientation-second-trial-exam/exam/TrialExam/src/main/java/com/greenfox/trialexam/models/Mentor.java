package com.greenfox.trialexam.models;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name = "mentors")
public class Mentor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@ManyToOne
	@JoinColumn(name="classroom_id") // same as owning side
	private Classroom classroom;

	public Mentor(String name) {
		this.name = name;
	}

	public Mentor() {}
}