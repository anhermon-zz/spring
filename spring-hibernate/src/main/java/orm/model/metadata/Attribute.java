package orm.model.metadata;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="attribute_type", uniqueConstraints=@UniqueConstraint(columnNames = { "category","name" }))
public class Attribute {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable=false)
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "category" ,foreignKey=@ForeignKey(name = "fk_category"),nullable=false)
	private Category category;
	
	@OneToMany(mappedBy = "attribute_id",orphanRemoval = true)
	 private Set<Value> values = new HashSet<>();
	 	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	 Set<Value> getValues() {
		 return values;
	 }
	 void setAttribute(Set<Value> values) {
		 this.values = values;
	 }
	 public void addValue(Value value) {
		 value.setAttribute(this);
		 values.add(value);
	    }
	 
	 public void removeValues(Value value) {
	    	getValues().remove(value);
	 }

	@Override
	public String toString() {
		return "Attribute [id=" + id + ", name=" + name + ", category="
				+ category.getExternal() + ", values=" + values + "]";
	}
}
