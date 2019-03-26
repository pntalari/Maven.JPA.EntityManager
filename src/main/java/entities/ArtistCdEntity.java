package entities;

import javax.persistence.*;

@Entity
@Table(name = "artist_cd", schema = "jpaManager", catalog = "")
public class ArtistCdEntity {
    private Integer cdId;
    private Integer artistId;

    @Basic
    @Column(name = "cd_id")
    public Integer getCdId() {
        return cdId;
    }

    public void setCdId(Integer cdId) {
        this.cdId = cdId;
    }

    @Basic
    @Column(name = "artist_id")
    public Integer getArtistId() {
        return artistId;
    }

    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArtistCdEntity that = (ArtistCdEntity) o;

        if (cdId != null ? !cdId.equals(that.cdId) : that.cdId != null) return false;
        if (artistId != null ? !artistId.equals(that.artistId) : that.artistId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cdId != null ? cdId.hashCode() : 0;
        result = 31 * result + (artistId != null ? artistId.hashCode() : 0);
        return result;
    }

    private String id;

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
