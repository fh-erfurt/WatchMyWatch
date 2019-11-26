package de.watchmywatch.shop;

public class Bracelet extends Watchpart
{
    //TODO rename in UML
    private String scope;
    private ConnectionType connection;

    public String getScope()
    {
        return scope;
    }

    public ConnectionType getConnection()
    {
        return connection;
    }

    public void setScope(String scope)
    {
        this.scope = scope;
    }

    public void setConnection(ConnectionType connection)
    {
        this.connection = connection;
    }
}
