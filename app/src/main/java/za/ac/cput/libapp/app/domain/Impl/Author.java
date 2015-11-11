package za.ac.cput.libapp.app.domain.Impl;

import java.io.Serializable;

/**
 * Created by student on 2015/04/17.
 */
public class Author implements  Serializable {
    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;*/
    private String lName;
    private String fName;

    private Author(){

    }

    public Author(Builder builder){
        lName = builder.lName;
        fName = builder.fName;
    }

    public String getLName() {
        return lName;
    }

    public String getFName() {
        return fName;
    }

    public static class Builder{

        private String lName;
        private String fName;
        /*public Builder(String lName, String fName){
            this.lName = lName;
            this.fName = fName;
        }*/
        public Builder lName(String value){
            this.lName = value;
            return this;
        }

        public Builder fName(String value){
            this.fName = value;
            return this;
        }

        public Builder copy(Author value){
            this.fName = value.fName;
            this.lName = value.lName;
            return this;
        }

        public Author build(){
            return new Author(this);
        }

    }

  /*  @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        if (id != null ? !id.equals(author.id) : author.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id='" + id + '\'' +
                ", lName='" + lName + '\'' +
                ", fName='" + fName + '\'' +
                '}';
    }*/
}
