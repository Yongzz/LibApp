package za.ac.cput.libapp.app.domain;

import java.io.Serializable;

/**
 * Created by Yongama on 2015-05-06.
 */
public abstract class LibraryItem implements Serializable {

    protected Long id;
    protected String tittle;
    protected String subject;


    public String getTittle() {
        return tittle;
    }

    public String getSubject() {
        return subject;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LibraryItem)) return false;

        LibraryItem item = (LibraryItem) o;

        return !(id != null ? !id.equals(item.id) : item.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "LibraryItem{" +
                "id=" + id +
                ", tittle='" + tittle + '\'' +
                '}';
    }
}
