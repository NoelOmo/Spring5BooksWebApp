package ke.co.noel.spring5webapp.bootstrap;

import ke.co.noel.spring5webapp.model.Author;
import ke.co.noel.spring5webapp.model.Book;
import ke.co.noel.spring5webapp.model.Publisher;
import ke.co.noel.spring5webapp.repositories.AuthorRepository;
import ke.co.noel.spring5webapp.repositories.BookRepository;
import ke.co.noel.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    public void initDummyDate() {
        Publisher publisher = new Publisher();
        publisher.setName("The Great Publisher");
        Author noel = new Author("Noel", "Omondi");
        Book book1 = new Book("A book about Nothing", "1111", publisher);
        noel.getBooks().add(book1);
        book1.getAuthors().add(noel);

        authorRepository.save(noel);
        publisherRepository.save(publisher);
        bookRepository.save(book1);

        Author noel2 = new Author("Noel", "Omondi");
        Publisher publisher2 = new Publisher();
        publisher2.setName("No So Great Publisher");
        Book book2 = new Book("A Sequel to book about Nothing", "2222", publisher2);
        noel2.getBooks().add(book2);
        book2.getAuthors().add(noel2);


        authorRepository.save(noel2);
        publisherRepository.save(publisher2);
        bookRepository.save(book2);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initDummyDate();
    }
}
