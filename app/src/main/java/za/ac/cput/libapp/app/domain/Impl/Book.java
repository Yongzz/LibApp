package za.ac.cput.libapp.app.domain.Impl;



import za.ac.cput.libapp.app.domain.LibraryItem;

import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/04/17.
 */
public class Book extends LibraryItem implements Serializable {

   // @Column(unique = true)
    private String ISBN;
    private Author author;
    private Publisher publisher;
    private List<Copy> copies;

    private Book(){}
    public Book(Builder builder){
        this.id = builder.id;
        tittle = builder.tittle;
        copies = builder.copies;
        subject = builder.subject;
        ISBN = builder.ISBN;
        author = builder.author;
        publisher =builder.publisher;
    }

    public String getISBN() {
        return ISBN;
    }

    public Author getAuthors() {
        return author;
    }

    public List<Copy> getCopies() {
        return copies;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public Author getAuthor() {
        return author;
    }

    public static class Builder{
        private Long id;
        private String tittle;
        private String subject;
        private String ISBN;
        private Author author;
        private List<Copy> copies;
        private Publisher publisher;


        public Builder(String ISBN){
            this.ISBN = ISBN;
        }

        public Builder Id(Long value){
            this.id = value;
            return this;
        }
        public Builder ISBN(String value){
            this.ISBN = value;
            return this;
        }
        public Builder tittle(String value){
            this.tittle = value;
            return this;
        }

        public Builder subject(String value){
            this.subject = value;
            return this;
        }

        public Builder publisher(Publisher value){
            this.publisher = value;
            return this;
        }

        public Builder authors(Author value){
            this.author = value;
            return this;
        }

        public Builder copies(List<Copy> value){
            this.copies = value;
            return this;
        }

        public Builder copy(Book value){
            this.id = value.id;
            this.tittle = value.tittle;
            this.subject = value.subject;
            this.ISBN = value.ISBN;
            this.author = value.author;
            this.publisher = value.publisher;
            this.copies = value.copies;
            return this;
        }

        public Book build(){return new Book(this);}

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (id != null ? !id.equals(book.id) : book.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", tittle='" + tittle + '\'' +
                '}';
    }
}
