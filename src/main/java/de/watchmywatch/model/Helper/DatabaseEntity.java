package de.watchmywatch.model.Helper;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
/**
 * Parent Class that contains general fields for classes that are stored in a Database
 * @author Michael Hopp
 */
@MappedSuperclass
//@Entity
//@Inheritance( strategy = InheritanceType.TABLE_PER_CLASS )
public abstract class DatabaseEntity
{
    @ApiModelProperty(notes = "The database generated ID.")
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    protected Integer id;

    @ApiModelProperty(notes = "The date of creation.")
    @Temporal( TemporalType.TIMESTAMP )
    protected Date created;

    @ApiModelProperty(notes = "The date of the last update.")
    @Temporal( TemporalType.TIMESTAMP )
    protected Date modified;

    @PrePersist
    void onCreate() { this.setCreated( new Date() ); }

    @PreUpdate
    void onUpdate() { this.setModified( new Date() ); }


    public Integer getId() {
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
