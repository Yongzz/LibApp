package za.ac.cput.libapp.app.services.Impl;

import za.ac.cput.libapp.app.domain.Impl.Book;
import za.ac.cput.libapp.app.respositories.RestAPI;
import za.ac.cput.libapp.app.respositories.rest.RestBookAPI;
import za.ac.cput.libapp.app.services.BookService;

import java.util.List;

/**
 * Created by Yongama on 2015/10/01.
 */
public class BookServiceImpl implements BookService{
    final RestAPI<Book,Long> rest = new RestBookAPI();
    @Override
    public Book findById(Long id) {
        return rest.get(id);
    }

    @Override
    public String save(Book entity) {

        return rest.post(entity);
    }

    @Override
    public String update(Book entity) {
        return rest.put(entity);
    }

    @Override
    public String delete(Book entity) {
        return rest.delete(entity);
    }

    @Override
    public List<Book> findAll() {
        return rest.getAll();
    }
}
