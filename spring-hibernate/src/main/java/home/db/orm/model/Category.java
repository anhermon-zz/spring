package home.db.orm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="category_mapping", schema="dictionary")
public class Category {
	@Id
	private long id;
	@Column
	private short site;
	@Column
	private int external;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public short getSite() {
		return site;
	}
	public void setSite(short site) {
		this.site = site;
	}
	public int getExternal() {
		return external;
	}
	public void setExternal(int external) {
		this.external = external;
	}
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", site=" + site + ", external="
				+ external + "]";
	}
}
