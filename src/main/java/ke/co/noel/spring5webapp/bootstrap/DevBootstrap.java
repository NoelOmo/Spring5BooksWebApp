package ke.co.noel.spring5webapp.bootstrap;

import ke.co.noel.spring5webapp.model.Author;
import ke.co.noel.spring5webapp.model.Book;
import ke.co.noel.spring5webapp.repositories.AuthorRepository;
import ke.co.noel.spring5webapp.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public void initDummyDate() {
        Author noel = new Author("Noel", "Omondi");
        Book book1 = new Book("A book about Nothing", "1111", "The Great Publisher");
        noel.getBooks().add(book1);
        book1.getAuthors().add(noel);

        authorRepository.save(noel);
        bookRepository.save(book1);

        Author noel2 = new Author("Noel", "Omondi");
        Book book2 = new Book("A Sequel to book about Nothing", "2222", "The Great Publisher");
        noel2.getBooks().add(book2);
        book2.getAuthors().add(noel2);


        authorRepository.save(noel2);
        bookRepository.save(book2);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initDummyDate();
    }
}
