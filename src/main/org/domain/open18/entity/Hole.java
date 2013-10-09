package org.domain.open18.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "HOLE", uniqueConstraints = @UniqueConstraint(columnNames = {
		"NUMBER", "COURSE_ID" }))
public class Hole implements Serializable {
	private Long id;
	private Course course;
	private String name;
	private int number;
	private int mensPar;
	private Integer mensHandicap;
	private int ladiesPar;
	private Integer ladiesHandicap;
	private Set<Tee> tees = new HashSet<Tee>(0);

	public Hole() {
	}

	public Hole(Course course, int number, int mensPar, int ladiesPar) {
		this.course = course;
		this.number = number;
		this.mensPar = mensPar;
		this.ladiesPar = ladiesPar;
	}
	public Hole(Course course, String name, int number, int mensPar,
			Integer mensHandicap, int ladiesPar, Integer ladiesHandicap,
			Set<Tee> tees) {
		this.course = course;
		this.name = name;
		this.number = number;
		this.mensPar = mensPar;
		this.mensHandicap = mensHandicap;
		this.ladiesPar = ladiesPar;
		this.ladiesHandicap = ladiesHandicap;
		this.tees = tees;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COURSE_ID", nullable = false)
	@NotNull
	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Column(name = "NAME", length = 25)
	@Length(max = 25)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "NUMBER", nullable = false)
	@NotNull
	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Column(name = "M_PAR", nullable = false)
	@NotNull
	public int getMensPar() {
		return this.mensPar;
	}

	public void setMensPar(int mensPar) {
		this.mensPar = mensPar;
	}

	@Column(name = "M_HANDICAP")
	public Integer getMensHandicap() {
		return this.mensHandicap;
	}

	public void setMensHandicap(Integer mensHandicap) {
		this.mensHandicap = mensHandicap;
	}

	@Column(name = "L_PAR", nullable = false)
	@NotNull
	public int getLadiesPar() {
		return this.ladiesPar;
	}

	public void setLadiesPar(int ladiesPar) {
		this.ladiesPar = ladiesPar;
	}

	@Column(name = "L_HANDICAP")
	public Integer getLadiesHandicap() {
		return this.ladiesHandicap;
	}

	public void setLadiesHandicap(Integer ladiesHandicap) {
		this.ladiesHandicap = ladiesHandicap;
	}
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "hole")
	public Set<Tee> getTees() {
		return this.tees;
	}

	public void setTees(Set<Tee> tees) {
		this.tees = tees;
	}

}
