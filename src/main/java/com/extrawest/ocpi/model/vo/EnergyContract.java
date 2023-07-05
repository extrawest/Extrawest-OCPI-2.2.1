package com.extrawest.ocpi.model.vo;

import com.extrawest.ocpi.validation.Validatable;
import com.extrawest.ocpi.validation.ValidationRules;
import com.extrawest.ocpi.validation.Validator;
import com.extrawest.ocpi.validation.ValidatorBuilder;
import com.extrawest.ocpi.validation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Information about a energy contract that belongs to a Token so a driver could use his/her own energy contract
 * when charging at a Charge Point.
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class EnergyContract implements Validatable {

    @JsonIgnore
    private final Validator supplierNameValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string64())
                    .build();

    @JsonIgnore
    private final Validator contractIdValidator =
            new ValidatorBuilder()
                    .addRule(ValidationRules.string64())
                    .build();

    /**
     * Name of the energy supplier for this token.
     */
    @JsonProperty("supplier_name")
    private String supplierName;

    @JsonProperty("contract_id")
    private String contractId;

    public void setSupplierName(String supplierName) {
        supplierNameValidator.validate(supplierName);
        this.supplierName = supplierName;
    }

    public void setContractId(String contractId) {
        contractIdValidator.validate(contractId);
        this.contractId = contractId;
    }

    @Override
    public boolean validate() {
        return supplierNameValidator.safeValidate(supplierName);
    }
}
