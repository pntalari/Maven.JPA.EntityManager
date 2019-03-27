package entities;

import javax.management.relation.Role;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "artist", schema = "jpaManager", catalog = "")
public class ArtistEntity {
    private int id;
    private String firstName;
    private String lastName;
    private String instrument;

    public ArtistEntity() {
    }

    public ArtistEntity(int id, String firstName, String lastName, String instrument) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.instrument = instrument;
    }

    public ArtistEntity(int id, String firstName, String lastName, String instrument, Set<CdEntity> cDs) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.instrument = instrument;
        this.cDs = cDs;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "instrument")
    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,targetEntity = CdEntity.class)
    @JoinTable(name = "artist_cd",
    joinColumns = @JoinColumn(name = "artist_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "cd_id", referencedColumnName = "id"))
    private Set<CdEntity> cDs = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArtistEntity that = (ArtistEntity) o;

        if (id != that.id) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (instrument != null ? !instrument.equals(that.instrument) : that.instrument != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (instrument != null ? instrument.hashCode() : 0);
        return result;
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
