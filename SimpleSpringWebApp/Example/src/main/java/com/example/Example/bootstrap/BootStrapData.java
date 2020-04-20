package com.example.Example.bootstrap;

import com.example.Example.model.Author;
import com.example.Example.model.Book;
import com.example.Example.model.Publisher;
import com.example.Example.repositories.AuthorRepository;
import com.example.Example.repositories.BookRepository;
import com.example.Example.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap.");
        Publisher publisher = new Publisher();
        publisher.setName("Papiros");
        publisher.setCityName("Thessaloniki");
        publisher.setState("Central Macedonia");

        publisherRepository.save(publisher);


        Author eric = new Author("Eric", "Evans");
        Book add = new Book("Domain Driven Design", "1234=678");

        eric.getBooks().add(add);
        add.getAuthors().add(eric);

        add.setPublisher(publisher);
        publisher.getBooks().add(add);

        authorRepository.save(eric);
        bookRepository.save(add);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book spring = new Book("Spring Framework", "23123-242");

        rod.getBooks().add(spring);
        spring.getAuthors().add(rod);

        spring.setPublisher(publisher);
        publisher.getBooks().add(spring);

        authorRepository.save(rod);
        bookRepository.save(spring);
        publisherRepository.save(publisher);


        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of publishers: " + publisherRepository.count());
        System.out.println("Number of publisher's books: " + publisher.getBooks().size());
    }
}
