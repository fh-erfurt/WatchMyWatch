package de.watchmywatch.Uhrenverwaltung;

public class Watch
{
    private String name;
    private double price;
    private String particularity;
    //parts in the following order: Bracelet, Casing, Clockwork (if adding manually)
    private Watchpart[] parts = new Watchpart[3];

    //contains the maximum Fee we would charge
    private static double maxFee = 200.00;
    //the percentage which is added as surcharge
    private static double surchargePercentage = 0.1;

    //Watchparts will be null->must be set by addWatchpart Method
    public Watch(String name, double price, String particularity)
    {
        this.name = name;
        this.price = price;
        this.particularity = particularity;
        this.parts[0] = null;
        this.parts[1] = null;
        this.parts[2] = null;
    }

    public Watch(String name, double price, String particularity, Bracelet bracelet, Casing casing, Clockwork clockwork)
    {
        this.name = name;
        this.price = price;
        this.particularity = particularity;
        this.parts[0] = bracelet;
        this.parts[1] = casing;
        this.parts[2] = clockwork;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getPriceWithFee()
    {
        if (this.price < 2000.00)
        {
            return this.price + this.price * 0.1;
        } else
        {
            return this.price + 200.00;
        }
    }

    public double getPriceWithoutFee()
    {
        return this.price;
    }

    public void setPrice(double price)
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

    public Watchpart[] getParts()
    {
        return parts;
    }

    //TODO decide if we really need add and changePart, is changePart not enough

    //will add watchparts into the right positin but WONT change the value if its already present
    public void addPart(Watchpart part)
    {
        //return if all Parts are already set
        if (parts[0] != null && parts[1] != null && parts[2] != null)
        {
            // TODO throw Exception and log
            return;
        }

        if (part.getClass() == Bracelet.class && parts[0] == null)
        {
            this.parts[0] = part;
        } else if (part.getClass() == Casing.class && parts[1] == null)
        {
            this.parts[1] = part;
        } else if (part.getClass() == Clockwork.class && parts[2] == null)
        {
            this.parts[2] = part;
        }
    }

    public void changePart(Watchpart part)
    {
        if (part.getClass() == Bracelet.class)
        {
            this.parts[0] = part;
        } else if (part.getClass() == Casing.class)
        {
            this.parts[1] = part;
        } else if (part.getClass() == Clockwork.class)
        {
            this.parts[2] = part;
        }
    }
}