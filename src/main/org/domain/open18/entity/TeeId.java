package org.domain.open18.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class TeeId implements java.io.Serializable{

	private long teeSetId;
	private long holeId;

	public TeeId() {
	}

	public TeeId(long teeSetId, long holeId) {
		this.teeSetId = teeSetId;
		this.holeId = holeId;
	}

	@Column(name = "TEE_SET_ID", nullable = false)
	@NotNull
	public long getTeeSetId() {
		return this.teeSetId;
	}

	public void setTeeSetId(long teeSetId) {
		this.teeSetId = teeSetId;
	}

	@Column(name = "HOLE_ID", nullable = false)
	@NotNull
	public long getHoleId() {
		return this.holeId;
	}

	public void setHoleId(long holeId) {
		this.holeId = holeId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TeeId))
			return false;
		TeeId castOther = (TeeId) other;

		return (this.getTeeSetId() == castOther.getTeeSetId())
				&& (this.getHoleId() == castOther.getHoleId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getTeeSetId();
		result = 37 * result + (int) this.getHoleId();
		return result;
	}
}
