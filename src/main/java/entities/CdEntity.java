package entities;

import javax.persistence.*;
import java.security.AllPermission;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "cd", schema = "jpaManager")
public class CdEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
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

    public CdEntity(String title, String desc, Integer year, Float price, Set<ArtistEntity> artists) {
        this.title = title;
        this.description = desc;
        this.year = year;
        this.price = price;
        this.artists = artists;
    }

    @ManyToMany(mappedBy = "cDs",cascade = CascadeType.ALL)
    public Set<ArtistEntity> artists = new HashSet<>();


    public Long getId() {
        return id;
    }

    public void setId(Long cd_id) {
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
        return Objects.equals(title, cdEntity.title) &&
                Objects.equals(year, cdEntity.year) &&
                Objects.equals(price, cdEntity.price) &&
                Objects.equals(description, cdEntity.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, year, price, description);
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
