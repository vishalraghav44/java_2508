package one2one;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "BOOK")
public class Book {
	@Id
	@Column(name = "BOOK_ID")
	@GeneratedValue

	private long id;
private String title;
private String description;
private Date publishedDate;
@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "AUTHOR_ID")
private Author author;
public Book() {
}
public void setId(long id) {
	this.id = id;
}

public void setDescription(String description) {
	this.description = description;
}
public long getId() {
	return id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getDescription() {
	return description;
}

public Author getAuthor() {
	return author;
}

public Date getPublishedDate() {
	return publishedDate;
}
//@Temporal(TemporalType.DATE)
@Column(name = "PUBLISHED")
public void setPublishedDate(Date publishedDate) {
	this.publishedDate = publishedDate;
}
public void setAuthor(Author author) {
	this.author = author;
}



}