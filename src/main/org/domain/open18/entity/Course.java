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

import org.hibernate.validator.constraints.Length;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "COURSE")
public class Course implements Serializable
{
	private Long id;
	private Facility facility;
	private String name;
	private String description;
	private String designer;
	private String fairways;
	private String greens;
	private Integer yearBuilt;
	private int numHoles;
	private Long signatureHole;
	private Set<TeeSet> teeSets = new HashSet<TeeSet>(0);
	private Set<Hole> holes = new HashSet<Hole>(0);

	public Course() {
	}

	public Course(Facility facility, String fairways, String greens,
			int numHoles) {
		this.facility = facility;
		this.fairways = fairways;
		this.greens = greens;
		this.numHoles = numHoles;
	}
	public Course(Facility facility, String name, String description,
			String designer, String fairways, String greens, Integer yearBuilt,
			int numHoles, Long signatureHole, Set<TeeSet> teeSets,
			Set<Hole> holes) {
		this.facility = facility;
		this.name = name;
		this.description = description;
		this.designer = designer;
		this.fairways = fairways;
		this.greens = greens;
		this.yearBuilt = yearBuilt;
		this.numHoles = numHoles;
		this.signatureHole = signatureHole;
		this.teeSets = teeSets;
		this.holes = holes;
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
	@JoinColumn(name = "FACILITY_ID", nullable = false)
	@NotNull
	public Facility getFacility() {
		return this.facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	@Column(name = "NAME", length = 50)
	@Length(max = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "DESIGNER", length = 50)
	@Length(max = 50)
	public String getDesigner() {
		return this.designer;
	}

	public void setDesigner(String designer) {
		this.designer = designer;
	}

	@Column(name = "FAIRWAYS", nullable = false, length = 15)
	@NotNull
	@Length(max = 15)
	public String getFairways() {
		return this.fairways;
	}

	public void setFairways(String fairways) {
		this.fairways = fairways;
	}

	@Column(name = "GREENS", nullable = false, length = 15)
	@NotNull
	@Length(max = 15)
	public String getGreens() {
		return this.greens;
	}

	public void setGreens(String greens) {
		this.greens = greens;
	}

	@Column(name = "YEAR_BUILT")
	public Integer getYearBuilt() {
		return this.yearBuilt;
	}

	public void setYearBuilt(Integer yearBuilt) {
		this.yearBuilt = yearBuilt;
	}

	@Column(name = "NUM_HOLES", nullable = false)
	@NotNull
	public int getNumHoles() {
		return this.numHoles;
	}

	public void setNumHoles(int numHoles) {
		this.numHoles = numHoles;
	}

	@Column(name = "SIGNATURE_HOLE")
	public Long getSignatureHole() {
		return this.signatureHole;
	}

	public void setSignatureHole(Long signatureHole) {
		this.signatureHole = signatureHole;
	}
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "course")
	public Set<TeeSet> getTeeSets() {
		return this.teeSets;
	}

	public void setTeeSets(Set<TeeSet> teeSets) {
		this.teeSets = teeSets;
	}
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "course")
	public Set<Hole> getHoles() {
		return this.holes;
	}

	public void setHoles(Set<Hole> holes) {
		this.holes = holes;
	}

	// The following is extra code specified in the hbm.xml files

	@javax.persistence.Transient
	public int getMensParOut() {
		int par = 0;
		for (Hole hole : holes) {
			if (hole.getNumber() <= 9) {
				par += hole.getMensPar();
			}
		}
		return par;
	}

	@javax.persistence.Transient
	public int getMensParIn() {
		int par = 0;
		for (Hole hole : holes) {
			if (hole.getNumber() > 9) {
				par += hole.getMensPar();
			}
		}
		return par;
	}

	@javax.persistence.Transient
	public int getTotalMensPar() {
		return getMensParOut() + getMensParIn();
	}

	@javax.persistence.Transient
	public int getLadiesParOut() {
		int par = 0;
		for (Hole hole : holes) {
			if (hole.getNumber() <= 9) {
				par += hole.getLadiesPar();
			}
		}
		return par;
	}

	@javax.persistence.Transient
	public int getLadiesParIn() {
		int par = 0;
		for (Hole hole : holes) {
			if (hole.getNumber() > 9) {
				par += hole.getLadiesPar();
			}
		}
		return par;
	}

	@javax.persistence.Transient
	public int getTotalLadiesPar() {
		return getLadiesParOut() + getLadiesParIn();
	}

	@javax.persistence.Transient
	public boolean isLadiesParUnique() {
		for (Hole hole : holes) {
			if (hole.getMensPar() != hole.getLadiesPar()) {
				return true;
			}
		}

		return false;
	}

	@javax.persistence.Transient
	public boolean isLadiesHandicapUnique() {
		for (Hole hole : holes) {
			if (hole.getLadiesHandicap() != null
					&& !hole.getLadiesHandicap().equals(hole.getMensHandicap())) {
				return true;
			}
		}

		return false;
	}


}
