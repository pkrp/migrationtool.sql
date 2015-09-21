package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.log4j.Logger;

@SuppressWarnings("serial")
@MappedSuperclass
@NamedQuery(name = "Parameter.psv", query = "SELECT DISTINCT p.value FROM PermissibleStringValue p LEFT JOIN p.type t WHERE t.id = :tid")
public abstract class Parameter extends EntityBaseBean implements Serializable {

	private static Logger logger = Logger.getLogger(Parameter.class);

	@Comment("The type of the parameter")
	@JoinColumn(name = "PARAMETER_TYPE_ID", nullable = false)
	@ManyToOne
	ParameterType type;

	@Comment("The value if the parameter is a string")
	@Column(name = "STRING_VALUE", length = 4000)
	private String stringValue;

	@Comment("The value if the parameter is numeric")
	@Column(name = "NUMERIC_VALUE", precision = 38, scale = 19)
	private Double numericValue;

	@Comment("The value if the parameter is a date")
	@Column(name = "DATETIME_VALUE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateTimeValue;

	@Comment("The maximum value of the numeric parameter that was observed during the measurement period")
	@Column(precision = 38, scale = 19)
	private Double rangeTop;

	@Comment("The minimum value of the numeric parameter that was observed during the measurement period")
	@Column(precision = 38, scale = 19)
	private Double rangeBottom;

	@Comment("The error of the numeric parameter")
	@Column(precision = 38, scale = 19)
	private Double error;

	public ParameterType getType() {
		return type;
	}

	public void setType(ParameterType type) {
		this.type = type;
	}

	public String getStringValue() {
		return stringValue;
	}

	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}

	public Double getNumericValue() {
		return numericValue;
	}

	public void setNumericValue(Double numericValue) {
		this.numericValue = numericValue;
	}

	public Date getDateTimeValue() {
		return dateTimeValue;
	}

	public void setDateTimeValue(Date dateTimeValue) {
		this.dateTimeValue = dateTimeValue;
	}

	public Double getRangeTop() {
		return rangeTop;
	}

	public void setRangeTop(Double rangeTop) {
		this.rangeTop = rangeTop;
	}

	public Double getRangeBottom() {
		return rangeBottom;
	}

	public void setRangeBottom(Double rangeBottom) {
		this.rangeBottom = rangeBottom;
	}

	public Double getError() {
		return error;
	}

	public void setError(Double error) {
		this.error = error;
	}


}
