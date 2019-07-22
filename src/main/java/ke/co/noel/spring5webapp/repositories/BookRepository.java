package ke.co.noel.spring5webapp.repositories;

import ke.co.noel.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;


public interface BookRepository extends CrudRepository<Book, Long> {
}
