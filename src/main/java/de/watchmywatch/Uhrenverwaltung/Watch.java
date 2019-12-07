package de.watchmywatch.Uhrenverwaltung;

import java.math.BigDecimal;

public class Watch
{
    private String name;
    private BigDecimal price;
    private String particularity;
    private BigDecimal maxFee;
    private int surchargePercentage;
    //partIDs in the following order: Bracelet, Casing, Clockwork
    private int[] partIDs = new int[3];

    //partIDs in the following order: Bracelet, Casing, Clockwork
    public Watch(String name, BigDecimal price, String particularity, BigDecimal maxFee,
                 int surchargePercentage, int[] partIDs)
    {
        this.name = name;
        this.price = price;
        this.particularity = particularity;
        this.maxFee = maxFee;
        this.surchargePercentage = surchargePercentage;
        this.partIDs = partIDs;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public BigDecimal getPrice()
    {
        return price;
    }

    public void setPrice(BigDecimal price)
    {
        this.price = price;
    }

    public String getParticularity()
    {
        return particularity;
    }

    public void setParticularity(String particularity)
    {
        this.particularity = particularity;
    }

    public BigDecimal getMaxFee()
    {
        return maxFee;
    }

    public void setMaxFee(BigDecimal maxFee)
    {
        this.maxFee = maxFee;
    }

    public int getSurchargePercentage()
    {
        return surchargePercentage;
    }

    public void setSurchargePercentage(int surchargePercentage)
    {
        this.surchargePercentage = surchargePercentage;
    }

    public int[] getPartIDs()
    {
        return partIDs;
    }
}
