package com.extrawest.ocpi.model;

import com.extrawest.ocpi.model.vo.EnergyMix;
import com.extrawest.ocpi.model.vo.DisplayText;
import com.extrawest.ocpi.model.vo.Price;
import com.extrawest.ocpi.model.vo.TariffElement;
import com.extrawest.ocpi.model.enums.TariffType;
import com.extrawest.ocpi.validation.*;
import com.extrawest.ocpi.validation.*;
import com.extrawest.ocpi.validation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Tariff implements Validatable {

    @JsonIgnore
    private final Validator countryCodeValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string2())
                    .build();

    @JsonIgnore
    private final Validator partyIdValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string3())
                    .build();

    @JsonIgnore
    private final Validator idValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string36())
                    .build();

    @JsonIgnore
    private final Validator currencyValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string3())
                    .build();

    @JsonIgnore
    private final Validator elementsValidator = new ListOfAtLeastOneObjects();

    @JsonIgnore
    private final Validator requiredValidator = new RequiredValidator();

    /**
     *ISO-3166 alpha-2 country code of the CPO that owns this Tariff.
     */
    @JsonProperty("country_code")
    private String countryCode;
    /**
     * ID of the CPO that 'owns' this Tariff (following the ISO-15118 standard).
     */
    @JsonProperty("party_id")
    private String partyId;
    /**
     * Uniquely identifies the tariff within the CPO’s platform (and suboperatorplatforms).
     */
    @JsonProperty("id")
    private String id;
    /**
     * Uniquely identifies the tariff within the CPO’s platform (and suboperatorplatforms).
     */
    @JsonProperty("currency")
    private String currency;
    /**
     * Defines the type of the tariff. This allows for distinction in case of given Charging Preferences.
     * When omitted, this tariff is valid for all sessions.
     */
    @JsonProperty("type")
    private TariffType type;
    /**
     * List of multi-language alternative tariff info texts
     */
    @JsonProperty("tariff_alt_text")
    private List<DisplayText> tariffAltText;
    /**
     * URL to a web page that contains an explanation of the tariff information in human readable form.
     */
    @JsonProperty("tariff_alt_url")
    private String tariffAltUrl;
    /**
     *  When this field is set, a Charging Session with this tariff will at least cost this
     * amount. This is different from a FLAT fee (Start Tariff, Transaction Fee), as a
     * FLAT fee is a fixed amount that has to be paid for any Charging Session. A
     * minimum price indicates that when the cost of a Charging Session is lower than
     * this amount, the cost of the Session will be equal to this amount.
     */
    @JsonProperty("min_price")
    private Price minPrice;
    /**
     * When this field is set, a Charging Session with this tariff will NOT cost more than this amount.
     */
    @JsonProperty("max_price")
    private Price maxPrice;
    /**
     * List of Tariff Elements.
     */
    @JsonProperty("elements")
    private List<TariffElement> elements;
    /**
     * The time when this tariff becomes active, in UTC, time_zone field of the Location can be used to convert
     * to local time. Typically used for a new tariff that is already given with the location, before it becomes active.
     */
    @JsonProperty("start_date_time")
    private LocalDateTime startDateTime;
    /**
     * The time after which this tariff is no longer valid, in UTC, time_zone field if the Location can be used
     * to convert to local time. Typically used when this tariff is going to be replaced with a different tariff
     * in the near future.
     */
    @JsonProperty("end_date_time")
    private LocalDateTime endDateTime;
    /**
     * Details on the energy supplied with this tariff.
     */
    @JsonProperty("energy_mix")
    private EnergyMix energyMix;
    /**
     * Timestamp when this Tariff was last updated (or created).
     */
    @JsonProperty("last_updated")
    private LocalDateTime lastUpdated;

    public Tariff(String countryCode,
                  String partyId,
                  String id,
                  String currency,
                  List<TariffElement> elements,
                  LocalDateTime lastUpdated) {
        countryCodeValidator.validate(countryCode);
        partyIdValidator.validate(partyId);
        idValidator.validate(id);
        currencyValidator.validate(currency);
        elementsValidator.validate(elements);
        requiredValidator.validate(lastUpdated);
        this.countryCode = countryCode;
        this.partyId = partyId;
        this.id = id;
        this.currency = currency;
        this.elements = elements;
        this.lastUpdated = lastUpdated;
    }

    public void setCountryCode(String countryCode) {
        countryCodeValidator.validate(countryCode);
        this.countryCode = countryCode;
    }

    public void setPartyId(String partyId) {
        partyIdValidator.validate(partyId);
        this.partyId = partyId;
    }

    public void setId(String id) {
        idValidator.validate(id);
        this.id = id;
    }

    public void setCurrency(String currency) {
        currencyValidator.validate(currency);
        this.currency = currency;
    }

    public void setType(TariffType type) {
        this.type = type;
    }

    public void setTariffAltText(List<DisplayText> tariffAltText) {
        this.tariffAltText = tariffAltText;
    }

    public void setTariffAltUrl(String tariffAltUrl) {
        this.tariffAltUrl = tariffAltUrl;
    }

    public void setMinPrice(Price minPrice) {
        this.minPrice = minPrice;
    }

    public void setMaxPrice(Price maxPrice) {
        this.maxPrice = maxPrice;
    }

    public void setElements(List<TariffElement> elements) {
        elementsValidator.validate(elements);
        this.elements = elements;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public void setEnergyMix(EnergyMix energyMix) {
        this.energyMix = energyMix;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        requiredValidator.validate(lastUpdated);
        this.lastUpdated = lastUpdated;
    }

    @Override
    public boolean validate() {
        return countryCodeValidator.safeValidate(countryCode)
                && partyIdValidator.safeValidate(partyId)
                && idValidator.safeValidate(id)
                && currencyValidator.safeValidate(currency)
                && elementsValidator.safeValidate(elements)
                && elements.stream().filter(TariffElement::validate).count() == elements.size()
                && requiredValidator.safeValidate(lastUpdated);
    }
}
