package com.extrawest.ocpi.model.vo;

import com.extrawest.ocpi.validation.Validatable;
import com.extrawest.ocpi.validation.ListOfAtLeastOneObjects;
import com.extrawest.ocpi.validation.Validator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;

@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class TariffElement implements Validatable {

    @JsonIgnore
    private final Validator price_componentsValidator = new ListOfAtLeastOneObjects();

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
        return price_componentsValidator.safeValidate(price_components)
                && price_components.stream().filter(PriceComponent::validate).count() == price_components.size();
    }
}
