package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Comment("Used to represent an arbitrary relationship between data files")
@SuppressWarnings("serial")
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "SOURCE_DATAFILE_ID",
		"DEST_DATAFILE_ID" }) })
public class RelatedDatafile extends EntityBaseBean implements Serializable {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SOURCE_DATAFILE_ID", nullable = false)
	private Datafile sourceDatafile;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DEST_DATAFILE_ID", nullable = false)
	private Datafile destDatafile;

	public Datafile getSourceDatafile() {
		return sourceDatafile;
	}

	public void setSourceDatafile(Datafile sourceDatafile) {
		this.sourceDatafile = sourceDatafile;
	}

	public Datafile getDestDatafile() {
		return destDatafile;
	}

	public void setDestDatafile(Datafile destDatafile) {
		this.destDatafile = destDatafile;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	@Comment("Identifies the type of relationship between the two datafiles - e.g. \"COPY\"")
	@Column(name = "RELATION", nullable = false)
	private String relation;

	/* Needed for JPA */
	public RelatedDatafile() {
	}

}
