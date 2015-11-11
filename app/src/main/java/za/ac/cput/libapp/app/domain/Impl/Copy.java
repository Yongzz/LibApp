package za.ac.cput.libapp.app.domain.Impl;

import java.io.Serializable;

/**
 * Created by Yongama on 2015-04-25.
 */
public class Copy implements Serializable {
    private Long Id;
    private String accessionNumber;
    private String datePurchased;
    private String copy_Notes;
    private Copy(){}

    public Copy(Builder builder){
        accessionNumber = builder.accessionNumber;
        datePurchased = builder.datePurchased;
        copy_Notes = builder.copy_Notes;
    }


    public Long getId() {
        return Id;
    }

    public String getAccessionNumber() {
        return accessionNumber;
    }

    public String getDatePurchased() {
        return datePurchased;
    }

    public String getCopy_Notes() {
        return copy_Notes;
    }


    public static class Builder{
        private String accessionNumber;
        private String datePurchased;
        private String copy_Notes;

        public Builder(String accessionNumber){
            this.accessionNumber = accessionNumber;
        }
/*
        public Builder accessionNumber(String value){
            this.accessionNumber = value;
            return this;
        }
*/
        public Builder datePurchased(String value){
            this.datePurchased = value;
            return this;
        }

        public Builder copy_Notes(String value){
            this.copy_Notes = value;
            return this;
        }

        public Builder copy(Copy copy){
            this.accessionNumber = copy.accessionNumber;
            this.datePurchased = copy.datePurchased;
            this.copy_Notes = copy.copy_Notes;
            return this;
        }

        public Copy build() {
            return new Copy(this);
        }
    }
}
