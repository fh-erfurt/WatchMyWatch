package de.watchmywatch.classes;

import java.util.Date;
import java.util.List;

public class Account
{
    private String id;
    private Customer customer;
    private String securePassword;
    private String salt;
    private String billingAddress;
    private Date opened;
    private Enum defaultPaymentMethod;
    private Enum accountStatus;
    private Shoppingcart shoppingCart;
    private List<String> orders;

    public String getId()
    {
        return id;
    }
}
