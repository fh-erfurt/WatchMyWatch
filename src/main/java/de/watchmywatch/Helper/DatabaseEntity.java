package de.watchmywatch.Helper;

import java.time.LocalDateTime;

/**
 * Parent Class that contains general fields for classes that are stored in a Database
 * @author Michael Hopp
 */
@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public abstract class DatabaseEntity
{
    @Id
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)
    protected long id;

    @Temporal( TemporalType.TIMESTAMP )
    protected LocalDateTime created;

    @Temporal( TemporalType.TIMESTAMP )
    protected LocalDateTime modified;


    public DatabaseEntity() {
    }

    public DatabaseEntity(long id) {
        this.id = id;
    }

    @PrePersist
    void onCreate() { this.setCreated( new Date() ); }

    @PreUpdate
    void onUpdate() { this.setModified( new Date() ); }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

}
