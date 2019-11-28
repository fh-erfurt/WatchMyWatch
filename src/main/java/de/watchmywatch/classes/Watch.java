package de.watchmywatch.classes;

import java.math.BigDecimal;

public class Watch
{
    private int id;
    private String name;
    private BigDecimal price;
    private String particularity;
    private BigDecimal maxFee;
    private int surchargePercentage;
    private Watchpart[] parts = new Watchpart[3];
    private static int idCounter = 0;

    public Watch()
    {
        id = idCounter;
        ++idCounter;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public BigDecimal getPrice()
    {
        return price;
    }

    public String getParticularity()
    {
        return particularity;
    }

    public BigDecimal getMaxFee()
    {
        return maxFee;
    }

    public int getSurchargePercentage()
    {
        return surchargePercentage;
    }

    public Watchpart[] getParts()
    {
        return parts;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setPrice(BigDecimal price)
    {
        this.price = price;
    }

    public void setParticularity(String particularity)
    {
        this.particularity = particularity;
    }

    public void setMaxFee(BigDecimal maxFee)
    {
        this.maxFee = maxFee;
    }

    public void setSurchargePercentage(int surchargePercentage)
    {
        this.surchargePercentage = surchargePercentage;
    }

    public void setParts(Watchpart[] parts)
    {
        this.parts = parts;
    }
}
