package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;


@Comment("A parameter associated with a sample")
@SuppressWarnings("serial")
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "SAMPLE_ID", "PARAMETER_TYPE_ID" }) })
@XmlRootElement
public class SampleParameter extends Parameter implements Serializable {

	@Comment("The associated sample")
	@JoinColumn(name = "SAMPLE_ID", nullable = false)
	@ManyToOne
	private Sample sample;

	/* Needed for JPA */
	public SampleParameter() {
	}

	public Sample getSample() {
		return this.sample;
	}
	public void setSample(Sample sample) {
		this.sample = sample;
	}

}