package entities;

import javax.management.relation.Role;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "artist", schema = "jpaManager")
public class ArtistEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name = "first_name")
    private String firstName;
    @Basic
    @Column(name = "last_name")
    private String lastName;
    @Basic
    @Column(name = "instrument")
    private String instrument;

    public ArtistEntity() {
        this.cDs = new HashSet<>();
    }

    public ArtistEntity(String firstName, String lastName, String instrument) {
   //     this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.instrument = instrument;
        this.cDs = new HashSet<>();
    }

    public ArtistEntity(String firstName, String lastName, String instrument, Set<CdEntity> cDs) {
     //   this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.instrument = instrument;
        this.cDs = cDs;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,targetEntity = CdEntity.class)
    @JoinTable(name = "artist_cd",
            joinColumns = @JoinColumn(name = "artist_id"),
            inverseJoinColumns = @JoinColumn(name = "cd_id"))
    public Set<CdEntity> cDs;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArtistEntity that = (ArtistEntity) o;
        return  Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(instrument, that.instrument);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, instrument);
    }

    public Set<CdEntity> getcDs() {
        return cDs;
    }

    public void setcDs(Set<CdEntity> cDs) {
        this.cDs = cDs;
    }

    @Override
    public String toString() {
        return "ArtistEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", instrument='" + instrument + '\'' +
                '}';
    }
}
