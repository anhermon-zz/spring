package orm.model.metadata;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="value", uniqueConstraints=@UniqueConstraint(columnNames = { "attribute_id","value_name" }))
public class Value {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable=false)
	private String value_name;
	
	@ManyToOne
	@JoinColumn(name = "attribute_id" ,foreignKey=@ForeignKey(name = "fk_attribute_id"),nullable=false)
	private Attribute attribute_id;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getValue_name() {
		return value_name;
	}

	public void setValue_name(String value_name) {
		this.value_name = value_name;
	}

	public Attribute getAttribute() {
		return attribute_id;
	}

	public void setAttribute(Attribute attribute) {
		this.attribute_id = attribute;
	}

	@Override
	public String toString() {
		return "Value [id=" + id + ", value_name=" + value_name
				+ ", attribute_id=" + attribute_id.getName()+ "]";
	}

}
