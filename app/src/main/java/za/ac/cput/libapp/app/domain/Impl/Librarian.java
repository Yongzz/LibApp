package za.ac.cput.libapp.app.domain.Impl;

import java.io.Serializable;
import java.util.List;

/**
 * Createisgetd by student on 2015/04/17.
 */
public class Librarian implements Serializable {

    private Long ID;
    private String lName;
    private String fName;
    private String librarianID;
    private String passoword;
    private Librarian(){

    }
    Librarian(Builder builder){
        ID = builder.ID;
        librarianID = builder.librarianID;
        lName = builder.lName;
        fName = builder.fName;
        passoword = builder.password;
    }
    public Long getID() {
        return ID;
    }

    public String getLName() {
        return lName;
    }

    public String getFName() {
        return fName;
    }

    public String getLibrarianID() {
        return librarianID;
    }

    public String getPassoword() {
        return passoword;
    }

    public static class Builder{
        private Long ID;
        private String librarianID;
        private String lName;
        private String fName;
        private String password;
        private List<Loan> loans;


        public Builder (String librarianID){
            this.librarianID = librarianID;
        }
        public Builder ID(Long value){
            this.ID = value;
            return this;
        }

        public Builder passoword(String value)
        {
            this.password = value;
            return this;
        }
        public Builder lName(String value){
            this.lName = value;
            return this;
        }

        public Builder fName(String value){
            this.fName = value;
            return this;
        }
        public Builder loans(List<Loan> value){
            this.loans = value;
            return this;
        }

        public Builder copy(Librarian librarian){
            this.librarianID = librarian.librarianID;
            this.fName = librarian.fName;
            this.lName = librarian.lName;
            this.password = librarian.passoword;
            return this;
        }
        public Librarian build(){
            return new Librarian(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Librarian librarian = (Librarian) o;

        if (ID != null ? !ID.equals(librarian.ID) : librarian.ID != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return ID != null ? ID.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Librarian{" +
                "id=" + ID +
                ", LName='" + lName + '\'' +
                '}';
    }
}
