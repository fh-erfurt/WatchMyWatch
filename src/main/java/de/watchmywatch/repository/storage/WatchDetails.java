package de.watchmywatch.repository.storage;

public class WatchDetails {
    private String name;
    private String particularity;
    private int braceletId;
    private int casingId;
    private int clockworkId;

    public WatchDetails(){}

    public WatchDetails(String name, String particularity, int braceletId, int casingId, int clockworkId) {
        this.name = name;
        this.particularity = particularity;
        this.braceletId = braceletId;
        this.casingId = casingId;
        this.clockworkId = clockworkId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParticularity() {
        return particularity;
    }

    public void setParticularity(String particularity) {
        this.particularity = particularity;
    }

    public int getBraceletId() {
        return braceletId;
    }

    public void setBraceletId(int braceletId) {
        this.braceletId = braceletId;
    }

    public int getCasingId() {
        return casingId;
    }

    public void setCasingId(int casingId) {
        this.casingId = casingId;
    }

    public int getClockworkId() {
        return clockworkId;
    }

    public void setClockworkId(int clockworkId) {
        this.clockworkId = clockworkId;
    }
}
