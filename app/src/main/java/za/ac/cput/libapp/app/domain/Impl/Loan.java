package za.ac.cput.libapp.app.domain.Impl;

import java.io.Serializable;

/**
 * Created by student on 2015/04/17.
 */
public class Loan implements Serializable {
    private Long Id;
    private String loanDate;
    private String dueDate;

    private Member member;
    private Librarian librarian;
    private Copy copy;

    private Loan(){}
    public Loan(Builder builder){

        Id = builder.Id;
        loanDate = builder.loanDate;
        member = builder.member;
        librarian= builder.librarian;
        copy = builder.copy;
        dueDate = builder.dueDate;


    }
    public Long getId() {
        return Id;
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

        Long Id;
        private String loanDate;
        private String dueDate;
        private Member member;
        private Librarian librarian;
        private Copy copy;

        public Builder(Member member, Librarian librarian){
            this.librarian = librarian;
            this.member = member;
        }

        public Builder Id(Long value){
            this.Id = value;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Loan loan = (Loan) o;

        return !(Id != null ? !Id.equals(loan.Id) : loan.Id != null);

    }

    @Override
    public int hashCode() {
        return Id != null ? Id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + Id +
                ", LoanDate='" + loanDate + '\'' +
                '}';
    }
}
