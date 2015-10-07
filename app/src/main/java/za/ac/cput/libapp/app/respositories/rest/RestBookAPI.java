package za.ac.cput.libapp.app.respositories.rest;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.libapp.app.model.Book;
import za.ac.cput.libapp.app.respositories.RestAPI;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hashcode on 2015/09/01.
 */
public class RestBookAPI implements RestAPI<Book,Long> {
    final String BASE_URL="http://librarysystem-librarysystem.rhcloud.com/library/";

    final HttpHeaders requestHeaders = RestMethods.getHeaders();
    final RestTemplate restTemplate = RestMethods.getRestTemplate();

    @Override
    public Book get(Long id) {
        final String url = BASE_URL+"book/"+id.toString();
        HttpEntity<Book> requestEntity = new HttpEntity<Book>(requestHeaders);
        ResponseEntity<Book> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Book.class);
        Book subject = responseEntity.getBody();
        return subject;
    }

    @Override
    public String post(Book entity) {
        final String url = BASE_URL+"book/create";
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Book> httpEntity = new HttpEntity<>(entity,headers);
        String result = rest.postForObject(url, httpEntity, String.class);


/*
        HttpEntity<Book> requestEntity = new HttpEntity<Book>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        String result = responseEntity.getBody();*/
        return result;
    }

    @Override
    public String put(Book entity) {
        final String url = BASE_URL+"book/update/"+entity.getID().toString();
        HttpEntity<Book> requestEntity = new HttpEntity<Book>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String delete(Book entity) {
        final String url = BASE_URL+"book/delete/"+entity.getID().toString();
        HttpEntity<Book> requestEntity = new HttpEntity<Book>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        return responseEntity.getBody();
    }

    @Override
    public List<Book> getAll() {
        List<Book> books = new ArrayList<>();
        final String url = BASE_URL+"books/";
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        ResponseEntity<Book[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Book[].class);
        Book[] results = responseEntity.getBody();

        for (Book b : results) {
            books.add(b);
        }
        return books;
    }
}
