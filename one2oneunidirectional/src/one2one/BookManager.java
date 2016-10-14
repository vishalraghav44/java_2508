package one2one;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

class BookManager {
	
public static void main(String[] args) {

	System.out.println("Hibernate One-To-One example (Annotation)");
	
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Session session = sf.openSession();
	session.beginTransaction();
	Book newBook = new Book();
	newBook.setTitle("Hibernate Made Easy");

	newBook.setDescription("Simplified Data Persistence with Hibernate and JPA");
	newBook.setPublishedDate(new Date());

newBook.setAuthor(new Author("Cameron Wallace McKenzie", "Cameron@gmail.com"));
Long bookId = (Long) session.save(newBook);
Book book = (Book) session.get(Book.class, bookId);
System.out.println("Book's Title: " + book.getTitle());
System.out.println("Book's Description: " + book.getTitle());
Author author = book.getAuthor();
System.out.println("Author's Name: " + author.getName());
System.out.println("Author's Email: " + author.getEmail());
session.getTransaction().commit();
session.close();
}}
