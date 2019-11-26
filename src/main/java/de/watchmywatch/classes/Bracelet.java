package de.watchmywatch.classes;

public class Bracelet extends Watchpart
{
    private double scope;
    private ConnectionType connection;

    public double getScope()
    {
        return scope;
    }

    public ConnectionType getConnection()
    {
        return connection;
    }

    public void setScope(double scope)
    {
        this.scope = scope;
    }

    public void setConnection(ConnectionType connection)
    {
        this.connection = connection;
    }
}
