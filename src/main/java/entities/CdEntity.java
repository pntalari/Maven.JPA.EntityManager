package entities;

import javax.persistence.*;
import java.security.AllPermission;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cd", schema = "jpaManager", catalog = "")
public class CdEntity {
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "year")
    private Integer year;
    @Basic
    @Column(name = "price")
    private Float price;
    @Basic
    @Column(name = "description")
    private String description;

    public CdEntity() {

    }

    public CdEntity(int id, String title, String desc, Integer year, Float price, Set<ArtistEntity> artists) {
        this.id = id;
        this.title = title;
        this.description = desc;
        this.year = year;
        this.price = price;
        this.artists = artists;
    }

    @ManyToMany(mappedBy = "cDs")
    private Set<ArtistEntity> artists = new HashSet<>();


    public int getId() {
        return id;
    }

    public void setId(int cd_id) {
        this.id = cd_id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }


    public Float getPrice() {
        return price;
    }


    public void setPrice(Float price) {
        this.price = price;
    }

    public Set<ArtistEntity> getArtists() {
        return artists;
    }

    public void setArtists(Set<ArtistEntity> artists) {
        this.artists = artists;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CdEntity cdEntity = (CdEntity) o;

        if (id != cdEntity.id) return false;
        if (title != null ? !title.equals(cdEntity.title) : cdEntity.title != null) return false;
        if (description != null ? !description.equals(cdEntity.description) : cdEntity.description != null)
            return false;
        if (year != null ? !year.equals(cdEntity.year) : cdEntity.year != null) return false;
        if (artists != null ? !artists.equals(cdEntity.artists) : cdEntity.artists != null) return false;
        if (price != null ? !price.equals(cdEntity.price) : cdEntity.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (artists != null ? artists.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CdEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", artists=" + artists +
                '}';
    }
}
