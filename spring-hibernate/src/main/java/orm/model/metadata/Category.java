package orm.model.metadata;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name="category_mapping",uniqueConstraints=@UniqueConstraint(columnNames = { "site","external" }))
public class Category {
	@Id
	@Column(name="id") //can be used to map variable and db column with different names
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NaturalId
	private int site;
	
	@NaturalId
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
	
	 @OneToMany(mappedBy = "category",orphanRemoval = true,fetch = FetchType.EAGER)
	 private Set<Attribute> attributes = new HashSet<>();
	 
	 public Set<Attribute> getAttributes() {
		 return attributes;
	 }
	 void setAttributes(Set<Attribute> attribute) {
		 this.attributes = attribute;
	 }
	 public void addAttribute(Attribute attribute) {
		 attribute.setCategory(this);
		 getAttributes().add(attribute);
	    }
	 
	 public void removeAttribute(Attribute address) {
	    	getAttributes().remove(address);
	 }
	@Override
	public String toString() {
		return "Category [id=" + id + ", site=" + site + ", external="
				+ external + ", attribute=" + attributes + "]";
	}
	
}
