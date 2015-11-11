package za.ac.cput.libapp.app.domain.Impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/04/17.
 */
public class Publisher implements Serializable{

    private String publisherName;
    private String placeOfPublication;
    private Publisher(){

    }

    public String getPublisherName() {
        return publisherName;
    }

    public String getPlaceOfPublication() {
        return placeOfPublication;
    }

    public Publisher(Builder builder){
        this.publisherName = builder.publisherName;
        this.placeOfPublication = builder.placeOfPublication;
    }

    public static class Builder{
        String publisherName;
        String placeOfPublication;
        private List<Book> books = new ArrayList<Book>();


        public Builder publisherName(String value){
            this.publisherName = value;
            return this;
        }

        public Builder placeOfPublication(String value){
            this.placeOfPublication = value;
            return this;
        }
        public Publisher build(){
            return new Publisher(this);
        }

        public Builder copy(Publisher value){
            this.publisherName = value.publisherName;
            this.placeOfPublication= value.placeOfPublication;
            return this;
        }

    }

}
