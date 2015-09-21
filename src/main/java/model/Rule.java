package model;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlTransient;

import org.apache.log4j.Logger;

@Comment("An authorization rule")
@SuppressWarnings("serial")
@Entity
@Table(name = "RULE_")
@NamedQueries({
		@NamedQuery(name = "Rule.CreateQuery", query = "SELECT DISTINCT r.crudJPQL FROM Rule r LEFT JOIN r.grouping g LEFT JOIN g.userGroups ug LEFT JOIN ug.user u WHERE (u.name = :member OR g IS NULL) AND r.bean = :bean AND r.c = TRUE"),
		@NamedQuery(name = "Rule.ReadQuery", query = "SELECT DISTINCT r.crudJPQL FROM Rule r LEFT JOIN r.grouping g LEFT JOIN g.userGroups ug LEFT JOIN ug.user u WHERE (u.name = :member OR g IS NULL) AND r.bean = :bean AND r.r = TRUE"),
		@NamedQuery(name = "Rule.IncludeQuery", query = "SELECT DISTINCT r.includeJPQL FROM Rule r LEFT JOIN r.grouping g LEFT JOIN g.userGroups ug LEFT JOIN ug.user u WHERE (u.name = :member OR g IS NULL) AND r.bean = :bean AND r.r = TRUE"),
		@NamedQuery(name = "Rule.UpdateQuery", query = "SELECT DISTINCT r.crudJPQL FROM Rule r LEFT JOIN r.grouping g LEFT JOIN g.userGroups ug LEFT JOIN ug.user u WHERE (u.name = :member OR g IS NULL) AND r.bean = :bean AND r.u = TRUE"),
		@NamedQuery(name = "Rule.DeleteQuery", query = "SELECT DISTINCT r.crudJPQL FROM Rule r LEFT JOIN r.grouping g LEFT JOIN g.userGroups ug LEFT JOIN ug.user u WHERE (u.name = :member OR g IS NULL) AND r.bean = :bean AND r.d = TRUE"),
		@NamedQuery(name = "Rule.SearchQuery", query = "SELECT DISTINCT r          FROM Rule r LEFT JOIN r.grouping g LEFT JOIN g.userGroups ug LEFT JOIN ug.user u WHERE (u.name = :member OR g IS NULL) AND r.bean = :bean AND r.r = TRUE"),
		@NamedQuery(name = "Rule.PublicQuery", query = "SELECT DISTINCT r.bean     FROM Rule r LEFT JOIN r.grouping g WHERE r.restricted = FALSE AND g IS NULL") })
public class Rule extends EntityBaseBean implements Serializable {


	private final static Logger logger = Logger.getLogger(Rule.class);

	public static final String CREATE_QUERY = "Rule.CreateQuery";
	public static final String DELETE_QUERY = "Rule.DeleteQuery";
	public static final String READ_QUERY = "Rule.ReadQuery";
	public static final String INCLUDE_QUERY = "Rule.IncludeQuery";
	public static final String SEARCH_QUERY = "Rule.SearchQuery";
	public static final String UPDATE_QUERY = "Rule.UpdateQuery";
	public static final String PUBLIC_QUERY = "Rule.PublicQuery";

	@XmlTransient
	private String bean;

	@XmlTransient
	private boolean c;

	@Comment("Contains letters from the set \"CRUD\"")
	@Column(nullable = false, length = 4)
	private String crudFlags;

	@XmlTransient
	@Column(length = 1024)
	private String crudJPQL;

	@XmlTransient
	private boolean d;

	@XmlTransient
	@Column(length = 1024)
	private String fromJPQL;

	@ManyToOne(fetch = FetchType.LAZY)
	private Grouping grouping;

	@XmlTransient
	private boolean r;

	@XmlTransient
	private boolean restricted;

	@XmlTransient
	private boolean u;

	@XmlTransient
	private int varCount;

	@Comment("To what the rules applies")
	@Column(nullable = false, length = 1024)
	private String what;

	@XmlTransient
	@Column(length = 1024)
	private String whereJPQL;

	@XmlTransient
	@Column(length = 1024)
	private String includeJPQL;

	// Needed for JPA
	public Rule() {
	}


	@XmlTransient
	public String getBean() {
		return bean;
	}

	public String getCrudFlags() {
		return crudFlags;
	}

	@XmlTransient
	public String getCrudJPQL() {
		return crudJPQL;
	}

	@XmlTransient
	public String getFromJPQL() {
		return fromJPQL;
	}

	public Grouping getGrouping() {
		return grouping;
	}

	@XmlTransient
	public int getVarCount() {
		return varCount;
	}

	public String getWhat() {
		return what;
	}

	@XmlTransient
	public String getWhereJPQL() {
		return whereJPQL;
	}

	@XmlTransient
	public boolean isC() {
		return c;
	}

	@XmlTransient
	public boolean isD() {
		return d;
	}

	@XmlTransient
	public boolean isR() {
		return r;
	}

	@XmlTransient
	public boolean isRestricted() {
		return restricted;
	}

	@XmlTransient
	public boolean isU() {
		return this.u;
	}


	public void setBean(String bean) {
		this.bean = bean;
	}

	public void setC(boolean c) {
		this.c = c;
	}

	public void setCrudFlags(String crudFlags) {
		this.crudFlags = crudFlags;
	}

	public void setCrudJPQL(String crudJPQL) {
		this.crudJPQL = crudJPQL;
	}

	public void setD(boolean d) {
		this.d = d;
	}

	public void setFromJPQL(String fromJPQL) {
		this.fromJPQL = fromJPQL;
	}

	public void setGrouping(Grouping grouping) {
		this.grouping = grouping;
	}

	public void setR(boolean r) {
		this.r = r;
	}

	public void setRestricted(boolean restricted) {
		this.restricted = restricted;
	}

	public void setU(boolean u) {
		this.u = u;
	}

	public void setVarCount(int varCount) {
		this.varCount = varCount;
	}

	public void setWhat(String what) {
		this.what = what;
	}

	public void setWhereJPQL(String whereJPQL) {
		this.whereJPQL = whereJPQL;
	}

}
