package entities;

import javax.persistence.*;
import java.security.AllPermission;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CdEn", schema = "jpaManager", catalog = "")
public class CdEntity {
    private int id;
    private String title;
    private String desc;
    private Integer year;
    private Float price;

    public CdEntity() {

    }

    public CdEntity(int id, String title, String desc, Integer year, Float price, Set<ArtistEntity> artists) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.year = year;
        this.price = price;
        this.artists = artists;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int cd_id) {
        this.id = cd_id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "desc")
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Basic
    @Column(name = "year")
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Basic
    @Column(name = "price")
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

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<ArtistEntity> artists = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CdEntity cdEntity = (CdEntity) o;

        if (id != cdEntity.id) return false;
        if (title != null ? !title.equals(cdEntity.title) : cdEntity.title != null) return false;
        if (desc != null ? !desc.equals(cdEntity.desc) : cdEntity.desc != null) return false;
        if (year != null ? !year.equals(cdEntity.year) : cdEntity.year != null) return false;
        if (artists != null ? !artists.equals(cdEntity.artists) : cdEntity.artists != null) return false;
        if (price != null ? !price.equals(cdEntity.price) : cdEntity.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (artists != null ? artists.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}
