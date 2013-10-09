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
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.Length;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "TEE_SET", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"POS", "COURSE_ID"}),
		@UniqueConstraint(columnNames = {"COLOR", "COURSE_ID"})})
public class TeeSet implements Serializable
{
	private Long id;
	private Course course;
	private String name;
	private String color;
	private Double ladiesCourseRating;
	private Double ladiesSlopeRating;
	private Double mensCourseRating;
	private Double mensSlopeRating;
	private Integer position;
	private Set<Tee> tees = new HashSet<Tee>(0);

	public TeeSet() {
	}

	public TeeSet(Course course, String color) {
		this.course = course;
		this.color = color;
	}
	public TeeSet(Course course, String name, String color,
			Double ladiesCourseRating, Double ladiesSlopeRating,
			Double mensCourseRating, Double mensSlopeRating, Integer position,
			Set<Tee> tees) {
		this.course = course;
		this.name = name;
		this.color = color;
		this.ladiesCourseRating = ladiesCourseRating;
		this.ladiesSlopeRating = ladiesSlopeRating;
		this.mensCourseRating = mensCourseRating;
		this.mensSlopeRating = mensSlopeRating;
		this.position = position;
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

	@Column(name = "COLOR", nullable = false, length = 10)
	@NotNull
	@Length(max = 10)
	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Column(name = "L_COURSE_RATING", precision = 17, scale = 0)
	public Double getLadiesCourseRating() {
		return this.ladiesCourseRating;
	}

	public void setLadiesCourseRating(Double ladiesCourseRating) {
		this.ladiesCourseRating = ladiesCourseRating;
	}

	@Column(name = "L_SLOPE_RATING", precision = 17, scale = 0)
	public Double getLadiesSlopeRating() {
		return this.ladiesSlopeRating;
	}

	public void setLadiesSlopeRating(Double ladiesSlopeRating) {
		this.ladiesSlopeRating = ladiesSlopeRating;
	}

	@Column(name = "M_COURSE_RATING", precision = 17, scale = 0)
	public Double getMensCourseRating() {
		return this.mensCourseRating;
	}

	public void setMensCourseRating(Double mensCourseRating) {
		this.mensCourseRating = mensCourseRating;
	}

	@Column(name = "M_SLOPE_RATING", precision = 17, scale = 0)
	public Double getMensSlopeRating() {
		return this.mensSlopeRating;
	}

	public void setMensSlopeRating(Double mensSlopeRating) {
		this.mensSlopeRating = mensSlopeRating;
	}

	@Column(name = "POS")
	public Integer getPosition() {
		return this.position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "teeSet")
	public Set<Tee> getTees() {
		return this.tees;
	}

	public void setTees(Set<Tee> tees) {
		this.tees = tees;
	}

	// The following is extra code specified in the hbm.xml files

	@javax.persistence.Transient
	public String getNameOrColor() {
		return name != null ? name : color;
	}

	@javax.persistence.Transient
	public int getDistanceOut() {
		int distance = 0;
		for (Tee tee : tees) {
			if (tee.getHole().getNumber() <= 9) {
				distance += tee.getDistance();
			}
		}
		return distance;
	}

	@javax.persistence.Transient
	public int getDistanceIn() {
		int distance = 0;
		for (Tee tee : tees) {
			if (tee.getHole().getNumber() > 9) {
				distance += tee.getDistance();
			}
		}
		return distance;
	}

	@javax.persistence.Transient
	public int getTotalDistance() {
		return getDistanceOut() + getDistanceIn();
	}

}
