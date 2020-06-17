package data;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class VehicleIdentity {
    private String registration;
    private String make;
    private String model;
    private String colour;
    private int year;

    public String getRegistration() {
        return registration;
    }

    public VehicleIdentity setRegistration(String registration) {
        this.registration = registration;
        return this;
    }

    public String getMake() {
        return make;
    }

    public VehicleIdentity setMake(String make) {
        this.make = make;
        return this;
    }

    public String getModel() {
        return model;
    }

    public VehicleIdentity setModel(String model) {
        this.model = model;
        return this;
    }

    public String getColour() {
        return colour;
    }

    public VehicleIdentity setColour(String colour) {
        this.colour = colour;
        return this;
    }

    public int getYear() {
        return year;
    }

    public VehicleIdentity setYear(int year) {
        this.year = year;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        VehicleIdentity that = (VehicleIdentity) o;

        return new EqualsBuilder()
                .append(year, that.year)
                .append(registration, that.registration)
                .append(make, that.make)
                .append(model, that.model)
                .append(colour, that.colour)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(registration)
                .append(make)
                .append(model)
                .append(colour)
                .append(year)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("Registration", registration)
                .append("Make", make)
                .append("Colour", colour)
                .append("Year", year)
                .toString();
    }
}
