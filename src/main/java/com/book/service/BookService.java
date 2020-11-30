package com.book.service;

import com.book.service.domain.BookView;
import com.book.service.domain.PageBookDto;
import com.book.service.repo.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import static org.springframework.util.StringUtils.hasText;

@Service
public class BookService {

    private final BookRepository repo;

    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    public PageBookDto getAllBooks(final int pageNumber, final int pageSize, final String sortBy) {
        int page = pageNumber < 1 ? 0 : pageNumber - 1;
        int size = pageSize < 1 ? 5 : pageSize;
        String sortField = hasText(sortBy) ? sortBy : "publishedDate";

        Pageable pageable = PageRequest.of(page, size, Sort.by(sortField));
        Page<BookView> pageBooks = repo.findAllBy(pageable);

        return PageBookDto.from(pageBooks);
    }

    public BookView getBookById(final Long id) {
        return repo.findBookById(id);
    }
}
