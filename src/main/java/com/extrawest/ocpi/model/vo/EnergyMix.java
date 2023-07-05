package com.extrawest.ocpi.model.vo;

import com.extrawest.ocpi.validation.*;
import com.extrawest.ocpi.validation.*;
import com.extrawest.ocpi.validation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;

@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class EnergyMix implements Validatable {

    @JsonIgnore
    private final Validator supplier_nameValidator =
            new ValidatorBuilder()
                    .addRule(ValidationRules.string64())
                    .build();
    @JsonIgnore
    private final Validator energy_product_nameValidator =
            new ValidatorBuilder()
                    .addRule(ValidationRules.string64())
                    .build();
    @JsonIgnore
    private final Validator requiredValidator = new RequiredValidator();

    /**
     * True if 100% from regenerative sources. (CO2 and nuclear waste is zero)
     */
    private boolean is_green_energy;
    /**
     * Key-value pairs (enum + percentage) of energy sources of this location’s tariff.
     */
    private List<EnergySource> energy_sources;
    /**
     * Key-value pairs (enum + percentage) of nuclear waste and CO2 exhaust of this location’s tariff.
     */
    private List<EnvironmentalImpact> environ_impact;
    /**
     * Name of the energy supplier, delivering the energy for this location or tariff.
     */
    private String supplier_name;
    /**
     * Name of the energy suppliers product/tariff plan used at this location.
     */
    private String energy_product_name;

    public EnergyMix(boolean is_green_energy) {
        requiredValidator.validate(is_green_energy);
        this.is_green_energy = is_green_energy;
    }

    public void setIs_green_energy(boolean is_green_energy) {
        requiredValidator.validate(is_green_energy);
        this.is_green_energy = is_green_energy;
    }

    public void setEnergy_sources(List<EnergySource> energy_sources) {
        this.energy_sources = energy_sources;
    }

    public void setEnviron_impact(List<EnvironmentalImpact> environ_impact) {
        this.environ_impact = environ_impact;
    }

    public void setSupplier_name(String supplier_name) {
        supplier_nameValidator.validate(supplier_name);
        this.supplier_name = supplier_name;
    }

    public void setEnergy_product_name(String energy_product_name) {
        energy_product_nameValidator.validate(energy_product_name);
        this.energy_product_name = energy_product_name;
    }

    @Override
    public boolean validate() {
        return requiredValidator.safeValidate(is_green_energy);
    }
}
