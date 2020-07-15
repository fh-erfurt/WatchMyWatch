package de.watchmywatch.model.WatchManagment;

import de.watchmywatch.model.Helper.DatabaseEntity;
import de.watchmywatch.model.WatchManagment.Validator.Validatable;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.logging.Logger;

/**
 * abstract class which represents a watchpart (used for bracelet,casing etc.)
 */
@MappedSuperclass
@Inheritance( strategy = InheritanceType.TABLE_PER_CLASS )
public abstract class Watchpart extends DatabaseEntity implements Validatable
{
    private transient  Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @ApiModelProperty(notes = "The name of the part.")
    private String name;

    @ApiModelProperty(notes = "The manufacturer of the part.")
    @ManyToOne(cascade= CascadeType.PERSIST)
    private Manufacturer manufacturer;

    //contains the ID which was given by the original manufacturer so we could order it directly when we are out of stock
    @ApiModelProperty(notes = "The manufacturerPartId which was given originally by the manufacturer.")
    private String manufacturerPartID;

    //contains the main material of which the part consists
    @ApiModelProperty(notes = "The main material of which the part consists.")
    @Enumerated(EnumType.STRING)
    private Material material;

    //contains the stock we currently have
    @ApiModelProperty(notes = "The current stock of this part.")
    private int amountAvailable;
    
    //contains price which the part alone costs
    @ApiModelProperty(notes = "The price of this part.")
    private double price;

    /**
     * abstract class which is used for bracelet, casing, clockwork
     *
     * @author Tom Käppler
     * @param name name of the part
     * @param manufacturer object of the manufacturer
     * @param manufacturerPartID ID which was given by the manufacturer itself
     * @param material material which the part consists of
     *
     * @param price price of the part itself
     */
    public Watchpart(String name, Manufacturer manufacturer, String manufacturerPartID,
                        Material material, double price, int amountAvailable)
    {
        this.name = name;
        this.manufacturer = manufacturer;
        this.manufacturerPartID = manufacturerPartID;
        this.material = material;
        this.price = price;
        this.amountAvailable = amountAvailable;
    }

    protected Watchpart(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmountAvailable() {
        return amountAvailable;
    }

    public void setAmountAvailable(int amountAvailable) {
        this.amountAvailable = amountAvailable;
    }

    public Manufacturer getManufacturer()
    {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer)
    {
        this.manufacturer = manufacturer;
    }

    public String getManufacturerPartID()
    {
        return manufacturerPartID;
    }

    public void setManufacturerPartID(String manufacturerPartId)
    {
        this.manufacturerPartID = manufacturerPartId;
    }

    public Material getMaterial()
    {
        return material;
    }

    public void setMaterial(Material material)
    {
        this.material = material;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        if(price < 0){
            logger.warning("price should not be smaller 0");
        }
        this.price = price;
    }
}
