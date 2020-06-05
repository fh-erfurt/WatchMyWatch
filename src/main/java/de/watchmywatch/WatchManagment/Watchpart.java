package de.watchmywatch.WatchManagment;

import de.watchmywatch.Helper.DatabaseEntity;
import de.watchmywatch.WatchManagment.Validator.Validatable;

import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import java.util.logging.Logger;

/**
 * abstract class which represents a watchpart (used for bracelet,casing etc.)
 */
@MappedSuperclass
public abstract class Watchpart extends DatabaseEntity implements Validatable
{
    Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @ManyToOne
    private Manufacturer manufacturer;
    //contains the ID which was given by the original manufacturer so we could order it directly when we are out of stock
    private String manufacturerPartID;
    //contains the main material of which the part consists
    private Material material;
    //contains the stock we currently have
    private int amountAvailable;
    //contains price which the part alone costs
    private double price;

    /**
     * abstract class which is used for bracelet, casing, clockwork
     *
     * @author Tom Käppler
     * @param manufacturer object of the manufacturer
     * @param manufacturerPartID ID which was given by the manufacturer itself
     * @param material material which the part consists of
     * @param price price of the part itself
     */
    public Watchpart(Manufacturer manufacturer, String manufacturerPartID,
                        Material material, double price)
    {
        this.manufacturer = manufacturer;
        this.manufacturerPartID = manufacturerPartID;
        this.material = material;
        this.price = price;
    }

    protected Watchpart(){

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
