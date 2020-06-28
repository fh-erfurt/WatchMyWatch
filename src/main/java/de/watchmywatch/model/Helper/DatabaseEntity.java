package de.watchmywatch.model.Helper;


import javax.persistence.*;
import java.util.Date;
// TODO: Datumsspalten created und modified werden noch nicht in kind Tabellen übernommen
/**
 * Parent Class that contains general fields for classes that are stored in a Database
 * @author Michael Hopp
 */
//@MappedSuperclass
@Entity
@Inheritance( strategy = InheritanceType.TABLE_PER_CLASS )
public abstract class DatabaseEntity
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Temporal( TemporalType.TIMESTAMP )
    protected Date created;

    @Temporal( TemporalType.TIMESTAMP )
    protected Date modified;

    @PrePersist
    void onCreate() { this.setCreated( new Date() ); }

    @PreUpdate
    void onUpdate() { this.setModified( new Date() ); }

    public long getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

}
