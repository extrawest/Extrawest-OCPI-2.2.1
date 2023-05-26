package com.extrawest.ocpi_emsp_prototype.model;

import com.extrawest.ocpi_emsp_prototype.model.dataTypes.DisplayText;
import com.extrawest.ocpi_emsp_prototype.model.dataTypes.EnergyMix;
import com.extrawest.ocpi_emsp_prototype.model.dataTypes.Price;
import com.extrawest.ocpi_emsp_prototype.model.dataTypes.TariffElement;
import com.extrawest.ocpi_emsp_prototype.model.enums.TariffType;
import com.extrawest.ocpi_emsp_prototype.validation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Tariff implements Validatable {

    @JsonIgnore
    private final transient Validator country_codeValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string2())
                    .build();

    @JsonIgnore
    private final transient Validator party_idValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string3())
                    .build();

    @JsonIgnore
    private final transient Validator idValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string36())
                    .build();

    @JsonIgnore
    private final transient Validator currencyValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string3())
                    .build();

    @JsonIgnore
    private final transient Validator elementsValidator = new ListOfAtLeastOneObjects();

    @JsonIgnore
    private final transient Validator requiredValidator = new RequiredValidator();

    /**
     *ISO-3166 alpha-2 country code of the CPO that owns this Tariff.
     */
    private String country_code;
    /**
     * ID of the CPO that 'owns' this Tariff (following the ISO-15118 standard).
     */
    private String party_id;
    /**
     * Uniquely identifies the tariff within the CPO’s platform (and suboperatorplatforms).
     */
    private String id;
    /**
     * Uniquely identifies the tariff within the CPO’s platform (and suboperatorplatforms).
     */
    private String currency;
    /**
     * Defines the type of the tariff. This allows for distinction in case of given Charging Preferences.
     * When omitted, this tariff is valid for all sessions.
     */
    private TariffType type;
    /**
     * List of multi-language alternative tariff info texts
     */
    private List<DisplayText> tariff_alt_text;
    /**
     * URL to a web page that contains an explanation of the tariff information in human readable form.
     */
    private String tariff_alt_url;
    /**
     *  When this field is set, a Charging Session with this tariff will at least cost this
     * amount. This is different from a FLAT fee (Start Tariff, Transaction Fee), as a
     * FLAT fee is a fixed amount that has to be paid for any Charging Session. A
     * minimum price indicates that when the cost of a Charging Session is lower than
     * this amount, the cost of the Session will be equal to this amount.
     */
    private Price min_price;
    /**
     * When this field is set, a Charging Session with this tariff will NOT cost more than this amount.
     */
    private Price max_price;
    /**
     * List of Tariff Elements.
     */
    private List<TariffElement> elements;
    /**
     * The time when this tariff becomes active, in UTC, time_zone field of the Location can be used to convert
     * to local time. Typically used for a new tariff that is already given with the location, before it becomes active.
     */
    private LocalDateTime start_date_time;
    /**
     * The time after which this tariff is no longer valid, in UTC, time_zone field if the Location can be used
     * to convert to local time. Typically used when this tariff is going to be replaced with a different tariff
     * in the near future.
     */
    private LocalDateTime end_date_time;
    /**
     * Details on the energy supplied with this tariff.
     */
    private EnergyMix energy_mix;
    /**
     * Timestamp when this Tariff was last updated (or created).
     */
    private LocalDateTime last_updated;

    public Tariff(String country_code,
                  String party_id,
                  String id,
                  String currency,
                  List<TariffElement> elements,
                  LocalDateTime last_updated) {
        country_codeValidator.validate(country_code);
        party_idValidator.validate(party_id);
        idValidator.validate(id);
        currencyValidator.validate(currency);
        elementsValidator.validate(elements);
        requiredValidator.validate(last_updated);
        this.country_code = country_code;
        this.party_id = party_id;
        this.id = id;
        this.currency = currency;
        this.elements = elements;
        this.last_updated = last_updated;
    }

    public void setCountry_code(String country_code) {
        country_codeValidator.validate(country_code);
        this.country_code = country_code;
    }

    public void setParty_id(String party_id) {
        party_idValidator.validate(party_id);
        this.party_id = party_id;
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

    public void setTariff_alt_text(List<DisplayText> tariff_alt_text) {
        this.tariff_alt_text = tariff_alt_text;
    }

    public void setTariff_alt_url(String tariff_alt_url) {
        this.tariff_alt_url = tariff_alt_url;
    }

    public void setMin_price(Price min_price) {
        this.min_price = min_price;
    }

    public void setMax_price(Price max_price) {
        this.max_price = max_price;
    }

    public void setElements(List<TariffElement> elements) {
        elementsValidator.validate(elements);
        this.elements = elements;
    }

    public void setStart_date_time(LocalDateTime start_date_time) {
        this.start_date_time = start_date_time;
    }

    public void setEnd_date_time(LocalDateTime end_date_time) {
        this.end_date_time = end_date_time;
    }

    public void setEnergy_mix(EnergyMix energy_mix) {
        this.energy_mix = energy_mix;
    }

    public void setLast_updated(LocalDateTime last_updated) {
        requiredValidator.validate(last_updated);
        this.last_updated = last_updated;
    }

    @Override
    public boolean validate() {
        return country_codeValidator.safeValidate(country_code)
                &&party_idValidator.safeValidate(party_id)
                &&idValidator.safeValidate(id)
                &&currencyValidator.safeValidate(currency)
                &&elementsValidator.safeValidate(elements)
                &&requiredValidator.safeValidate(last_updated);
    }
}
