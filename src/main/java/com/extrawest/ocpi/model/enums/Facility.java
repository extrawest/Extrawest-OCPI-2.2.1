package com.extrawest.ocpi.model.enums;

import com.extrawest.ocpi.util.EnumUtil;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Facility {
    /**
     * A hotel.
     */
    HOTEL("HOTEL"),
    /**
     * A restaurant.
     */
    RESTAURANT("RESTAURANT"),
    /**
     * A cafe.
     */
    CAFE("CAFE"),
    /**
     * A mall or shopping center.
     */
    MALL("MALL"),
    /**
     * A mall or shopping center.
     */
    SUPERMARKET("SUPERMARKET"),
    /**
     * Sport facilities: gym, field etc.
     */
    SPORT("SPORT"),
    /**
     * A recreation area.
     */
    RECREATION_AREA("RECREATION_AREA"),
    /**
     * Located in, or close to, a park, nature reserve etc.
     */
    NATURE("NATURE"),
    /**
     * A museum.
     */
    MUSEUM("MUSEUM"),
    /**
     * A bike/e-bike/e-scooter sharing location.
     */
    BIKE_SHARING("BIKE_SHARING"),
    /**
     * A bus stop.
     */
    BUS_STOP("BUS_STOP"),
    /**
     * A taxi stand.
     */
    TAXI_STAND("TAXI_STAND"),
    /**
     * A tram stop/station.
     */
    TRAM_STOP("TRAM_STOP"),
    /**
     * A tram stop/station.
     */
    METRO_STATION("METRO_STATION"),
    /**
     * A tram stop/station.
     */
    TRAIN_STATION("TRAIN_STATION"),
    /**
     * An airport.
     */
    AIRPORT("AIRPORT"),
    /**
     * An airport.
     */
    PARKING_LOT("PARKING_LOT"),
    /**
     * An airport.
     */
    CARPOOL_PARKING("CARPOOL_PARKING"),
    /**
     * An airport.
     */
    FUEL_STATION("FUEL_STATION"),
    /**
     * Wifi or other type of internet available.
     */
    WIFI("WIFI");
    private final String value;

    Facility(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    @JsonValue
    public String value() {
        return this.value;
    }

    @JsonCreator
    public static Facility fromValue(String value) {
        return EnumUtil.findByField(
                Facility.class,
                Facility::value,
                value
        );
    }
}
