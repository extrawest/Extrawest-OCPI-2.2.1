package com.extrawest.ocpi.model.dto;

import com.extrawest.ocpi.model.enums.AuthMethod;
import com.extrawest.ocpi.model.enums.SessionStatus;
import com.extrawest.ocpi.model.vo.CdrToken;
import com.extrawest.ocpi.model.vo.ChargingPeriod;
import com.extrawest.ocpi.model.vo.Price;
import com.extrawest.ocpi.util.Constants;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessionDTO {
    @NotBlank
    @Size(min = 1, max = 2)
    @Pattern(regexp = Constants.ASCII_REGEXP)
    @JsonProperty("country_code")
    private String countryCode;
    @NotBlank
    @Size(min = 1, max = 3)
    @Pattern(regexp = Constants.ASCII_REGEXP)
    @JsonProperty("party_id")
    private String partyId;
    @NotBlank
    @Size(min = 1, max = 36)
    @Pattern(regexp = Constants.ASCII_REGEXP)
    @JsonProperty("id")
    private String id;
    @NotBlank
    @JsonProperty("start_date_time")
    private LocalDateTime startDateTime;
    @JsonProperty("end_date_time")
    private LocalDateTime endDateTime;
    @NotBlank
    @Digits(integer = Integer.MAX_VALUE, fraction = 4)
    @JsonProperty("kwh")
    private Float kwh;
    @NotBlank
    @JsonProperty("cdr_token")
    private CdrToken cdrToken;
    @NotBlank
    @JsonProperty("auth_method")
    private AuthMethod authMethod;
    @Size(min = 1, max = 36)
    @Pattern(regexp = Constants.ASCII_REGEXP)
    @JsonProperty("authorization_reference")
    private String authorizationReference;
    @NotBlank
    @Size(min = 1, max = 36)
    @Pattern(regexp = Constants.ASCII_REGEXP)
    @JsonProperty("location_id")
    private String locationId;
    @NotBlank
    @Size(min = 1, max = 36)
    @Pattern(regexp = Constants.ASCII_REGEXP)
    @JsonProperty("evse_uid")
    private String evseUid;
    @NotBlank
    @Size(min = 1, max = 36)
    @Pattern(regexp = Constants.ASCII_REGEXP)
    @JsonProperty("connector_id")
    private String connectorId;
    @Size(min = 1, max = 255)
    @JsonProperty("meter_id")
    private String meterId;
    @NotBlank
    @Size(min = 1, max = 3)
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("charging_periods")
    private List<ChargingPeriod> chargingPeriods;
    @JsonProperty("total_cost")
    private Price totalCost;
    @NotBlank
    @JsonProperty("status")
    private SessionStatus status;
    @NotBlank
    @JsonProperty("last_updated")
    private LocalDateTime lastUpdated;
}
