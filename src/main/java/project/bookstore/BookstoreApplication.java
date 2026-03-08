package project.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import project.bookstore.domain.Book;
import project.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository repository) {
		return (args) -> {
			log.info("save a couple of books");
			repository.save(new Book("Tuntematon sotilas", "Väinö Linna", 1954, "9789510433587", 14.90));
			repository.save(new Book("Sinuhe egyptiläinen", "Mika Waltari", 1945, "9789510416429", 16.90));
			repository.save(new Book("Seitsemän veljestä", "Aleksis Kivi", 1870, "9789510428408", 13.90));
			repository.save(new Book("Juoksuhaudantie", "Kari Hotakainen", 2002, "9789510391290", 12.90));
			repository.save(new Book("Puhdistus", "Sofi Oksanen", 2008, "9789520103319", 15.50));

			log.info("fetch all books");
			for(Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}
}
