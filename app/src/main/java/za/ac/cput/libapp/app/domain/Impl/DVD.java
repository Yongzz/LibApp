package za.ac.cput.libapp.app.domain.Impl;


import za.ac.cput.libapp.app.domain.LibraryItem;

/**
 * Created by student on 2015/04/17.
 */
public class DVD extends LibraryItem {

    private String code;
    private int duration;
    private String distributor;

    private DVD(){}

    public DVD(Builder builder){
        id = builder.ID;
        tittle= builder.tittle;
        subject = builder.subject;
        code = builder.code;
        duration = builder.duration;
        distributor = builder.distributor;
    }

    public static class Builder{
        Long ID;
        String tittle;
        String subject;
        String type;
        String code;
        int duration;
        String distributor;

        public Builder(String code){this.code = code;}

        public Builder ID(Long value){
            this.ID = value;
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

        public Builder type(String value){
            this.type = value;
            return this;
        }

        public Builder duration(int value){
            this.duration = value;
            return this;
        }

        public Builder distributor(String value){
            this.distributor = value;
            return this;
        }

        public Builder copy(DVD dvd){
            this.code = dvd.code;
            this.duration = dvd.duration;
            this.tittle = dvd.getTittle();
            this.subject = dvd.subject;
            this.distributor = dvd.distributor;
            return this;
        }

        public DVD build(){return new DVD(this);}
    }

    public String getCode() {
        return code;
    }

    public int getDuration() {
        return duration;
    }

    public String getDistributor() {
        return distributor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DVD dvd = (DVD) o;

        if (id != null ? !id.equals(dvd.id) : dvd.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "DVD{" +
                "id=" + id +
                ", tittle='" + tittle + '\'' +
                '}';
    }
}
