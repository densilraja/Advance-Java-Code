package com.jsp.library_management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.library_management.entity.Books;
import com.jsp.library_management.exception.DataNotFound;
import com.jsp.library_management.repository.BookRepo;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    // Insert Single
    public Books insert(Books book) {
        return bookRepo.save(book);
    }

    // Insert Multiple
    public List<Books> insertAll(List<Books> books) {
        return bookRepo.saveAll(books);
    }

    // Find All
    public List<Books> findAll() {
        return bookRepo.findAll();
    }

    // Find By Id
    public Books find(int id) {
        Optional<Books> book = bookRepo.findById(id);

        if (book.isPresent()) {
            return book.get();
        } else {
            throw new DataNotFound();
        }
    }

    // Entire Update (PUT)
    public Books update(int id, Books updatedBook) {

        Optional<Books> optional = bookRepo.findById(id);

        if (optional.isPresent()) {

            Books existingBook = optional.get();

            existingBook.setBook_Name(updatedBook.getBook_Name());
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setPrice(updatedBook.getPrice());
            existingBook.setQuantituy(updatedBook.getQuantituy());

            return bookRepo.save(existingBook);
        }

        return null;
    }

    // Partial Update (PATCH)
    public Books partialUpdate(int id, Books updatedBook) {

        Optional<Books> optional = bookRepo.findById(id);

        if (optional.isPresent()) {

            Books existingBook = optional.get();

            if (updatedBook.getBook_Name() != null)
                existingBook.setBook_Name(updatedBook.getBook_Name());

            if (updatedBook.getAuthor() != null)
                existingBook.setAuthor(updatedBook.getAuthor());

            return bookRepo.save(existingBook);
        }

        return null;
    }

    // Delete Single
    public String delete(int id) {

        Optional<Books> optional = bookRepo.findById(id);

        if (optional.isPresent()) {
            bookRepo.deleteById(id);
            return "Book Deleted Successfully";
        }

        return "Book Not Found";
    }

    // Delete All
    public String deleteAll() {

        if (bookRepo.count() == 0) {
            return "No Records Found";
        }

        bookRepo.deleteAll();
        return "All Books Deleted Successfully";
    }
    
    //find by name
    public Books findByPrice(double price) {
    	return bookRepo.findByPrice(price);
    }

}