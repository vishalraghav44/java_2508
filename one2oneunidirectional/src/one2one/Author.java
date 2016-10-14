package one2one;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "AUTHOR")
public class Author {
	@Id
	@Column(name = "AUTHOR_ID")
	@GeneratedValue
	
private long id;
private String name;
private String email;

public Author() {
}



public Author(String name, String email) {
	super();
	
	this.name = name;
	this.email = email;
}



public void setId(long id) {
	this.id = id;
}



public String getName() {
	return name;
}



public long getId() {
	return id;
}






public void setName(String name) {
	this.name = name;
}



public String getEmail() {
	return email;
}

public void setEmail()
{
	this.email = email;
}

}