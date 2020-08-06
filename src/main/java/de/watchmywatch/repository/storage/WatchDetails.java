package de.watchmywatch.repository.storage;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class WatchDetails {
    @NotNull
    @Size(min = 1, max = 32, message = "Watch name cant be empty and has to be between 1 and 32 characters")
    private String name;
    @NotBlank(message = "Please enter a particularity")
    private String particularity;
    @NotNull(message = "You have to choose a bracelet")
    private int braceletId;
    @NotNull(message = "You have to choose a casing")
    private int casingId;
    @NotNull(message = "You have to choose a clockwork")
    private int clockworkId;

    public WatchDetails() {
    }

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
