package za.ac.cput.libapp.app.model;

import java.util.List;

/**
 * Created by Yongama on 2015/09/24.
 */
public class Librarian {

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
    public String toString() {
        return "Librarian{" +
                "ID=" + ID +
                ", lName='" + lName + '\'' +
                ", fName='" + fName + '\'' +
                ", librarianID='" + librarianID + '\'' +
                ", passoword='" + passoword + '\'' +
                '}';
    }
}
