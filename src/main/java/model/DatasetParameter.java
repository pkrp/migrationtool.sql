package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;


@Comment("A parameter associated with a data set")
@SuppressWarnings("serial")
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "DATASET_ID", "PARAMETER_TYPE_ID" }) })
@XmlRootElement
public class DatasetParameter extends Parameter implements Serializable {

	@Comment("The associated data set")
	@JoinColumn(name = "DATASET_ID", nullable = false)
	@ManyToOne
	private Dataset dataset;

	/* Needed for JPA */
	public DatasetParameter() {
	}

	public Dataset getDataset() {
		return this.dataset;
	}

}