package de.watchmywatch.Helper;

import java.time.LocalDateTime;

/**
 * Parent Class that contains general fields for classes that are stored in a Database
 * @author Michael Hopp
 */
public abstract class DatabaseEntity {
    protected long id;
    protected LocalDateTime created;
    protected LocalDateTime modified;


    public DatabaseEntity() {
    }

    public DatabaseEntity(long id) {
        this.id = id;
    }

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
