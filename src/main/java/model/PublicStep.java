package model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.apache.log4j.Logger;

@Comment("An allowed step for an INCLUDE identifed by the origin entity and the field name for navigation. "
		+ "Including an entry here is much more efficient than having to use the authorization rules.")
@SuppressWarnings("serial")
@Entity
@NamedQuery(name = "AllowedStep.GetAllQuery", query = "SELECT ps FROM PublicStep ps")
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "ORIGIN", "FIELD" }) })
public class PublicStep extends EntityBaseBean implements Serializable {

	public static final String GET_ALL_QUERY = "AllowedStep.GetAllQuery";
	private static final Logger logger = Logger.getLogger(PublicStep.class);


	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	@Comment("The origin entity")
	@Column(name = "ORIGIN", nullable = false, length = 32)
	private String origin;

	@Comment("The field used to represent the relationship on the origin side")
	@Column(name = "FIELD", nullable = false, length = 32)
	private String field;

	// Needed for JPA
	public PublicStep() {
	}

}
