package com.extrawest.ocpi_emsp_prototype.dataTypes;

import com.extrawest.ocpi_emsp_prototype.validation.ListOfAtLeastOneObjects;
import com.extrawest.ocpi_emsp_prototype.validation.Validatable;
import com.extrawest.ocpi_emsp_prototype.validation.Validator;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class TariffElement implements Validatable {

    private final transient Validator price_componentsValidator = new ListOfAtLeastOneObjects();

    /**
     * List of price components that describe the pricing of a tariff.
     */
    private List<PriceComponent> price_components;
    /**
     * Restrictions that describe the applicability of a tariff.
     */
    private TariffRestrictions restrictions;

    public TariffElement(List<PriceComponent> price_components) {
        price_componentsValidator.validate(price_components);
        this.price_components = price_components;
    }

    public void setPrice_components(List<PriceComponent> price_components) {
        price_componentsValidator.validate(price_components);
        this.price_components = price_components;
    }

    public void setRestrictions(TariffRestrictions restrictions) {
        this.restrictions = restrictions;
    }

    @Override
    public boolean validate() {
        return price_componentsValidator.safeValidate(price_components);
    }
}
