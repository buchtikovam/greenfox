package com.greenfox.trialexam.models;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Set;

@Entity
@Getter @Setter
@Table(name = "classrooms")
public class Classroom {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String className;

	// one classroom can have multiple mentors
	@OneToMany(
		fetch = FetchType.LAZY, // useful when adding data
		cascade = CascadeType.ALL
	)
	@JoinColumn(name = "classroom_id") // always the owning side
	private Set<Mentor> mentors;

	public Classroom(String className) {
		this.className = className;
	}

	public Classroom() {}
}