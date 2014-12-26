package home.db.orm.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="category_mapping", schema="dictionary",uniqueConstraints=@UniqueConstraint(columnNames = { "site","external" }))
public class Category {
	@Id
	@Column(name="id") //can be used to map variable and db column with different names
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable=false)
	private int site;
	
	@Column(nullable=false)
	private int external;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getSite() {
		return site;
	}
	public void setSite(int site) {
		this.site = site;
	}
	public int getExternal() {
		return external;
	}
	public void setExternal(int external) {
		this.external = external;
	}
	
	 @OneToMany(fetch = FetchType.EAGER, mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
	 private Set<Attribute> attribute = new HashSet<>();
	 
	 Set<Attribute> getAttribute() {
		 return attribute;
	 }
	 void setAttribute(Set<Attribute> attribute) {
		 this.attribute = attribute;
	 }
	 public void addAttribute(Attribute attribute) {
		 attribute.setCategory(this);
		 getAttribute().add(attribute);
	    }
	 
	 public void removeAttribute(Attribute address) {
	    	getAttribute().remove(address);
	 }
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", site=" + site + ", external="
				+ external + "]";
	}
}
