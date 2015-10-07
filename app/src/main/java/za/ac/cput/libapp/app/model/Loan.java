package za.ac.cput.libapp.app.model;

import java.io.Serializable;

/**
 * Created by Yongama on 2015-05-19.
 */
public class Loan implements Serializable{
    private Long ID;
    private String loanDate;
    private String dueDate;
    private Member member;
    private Librarian librarian;
    private Copy copy;

    private Loan(){}
    public Loan(Builder builder){

        ID = builder.ID;
        loanDate = builder.loanDate;
        member = builder.member;
        librarian= builder.librarian;
        copy = builder.copy;
        dueDate = builder.dueDate;


    }
    public Long getresID() {
        return ID;
    }

    public String getLoanDate() {
        return loanDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public Librarian getLibrarian() {
        return librarian;
    }

    public Member getMember() {
        return member;
    }

    public Copy getCopy() {
        return copy;
    }

    public static class Builder{

        Long ID;
        private String loanDate;
        private String dueDate;
        private Member member;
        private Librarian librarian;
        private Copy copy;

        public Builder(Member member, Librarian librarian){
            this.librarian = librarian;
            this.member = member;
        }

        public Builder resID(Long value){
            this.ID = value;
            return this;
        }

        public Builder loanDate(String value){
            this.loanDate = value;
            return this;
        }
        public Builder dueDate(String value){
            this.dueDate = value;
            return this;
        }

        public Builder member(Member value){
            this.member = value;
            return this;
        }

        public Builder copy(Copy  value){
            this.copy = value;
            return this;
        }

        public Builder librarian(Librarian value){
            this.librarian = value;
            return this;
        }
        public Builder copy(Loan loan){
            this.copy = loan.copy;
            this.loanDate = loan.loanDate;
            this.member = loan.member;
            this.librarian = loan.librarian;
            return this;
        }

        public Loan build() {
            return new Loan(this);
        }

    }
}
