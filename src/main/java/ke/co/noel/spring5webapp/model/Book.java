package ke.co.noel.spring5webapp.model;

import java.util.HashSet;
import java.util.Set;

public class Book {

private String title;
private String isbn;
private String author;

private Set<Author> authors = new HashSet<>();

    public Book() {
    }

    public Book(String title, String isbn, String author) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
    }

    public Book(String title, String isbn, String author, Set<Author> authors) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }
}
