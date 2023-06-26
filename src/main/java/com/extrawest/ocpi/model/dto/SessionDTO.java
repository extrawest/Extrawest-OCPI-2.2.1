package com.extrawest.ocpi.model.dto;

import com.extrawest.ocpi.model.enums.AuthMethod;
import com.extrawest.ocpi.model.enums.SessionStatus;
import com.extrawest.ocpi.model.vo.CdrToken;
import com.extrawest.ocpi.model.vo.ChargingPeriod;
import com.extrawest.ocpi.model.vo.Price;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Digits;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessionDTO {
    @JsonProperty("country_code")
    private String countryCode;
    @JsonProperty("party_id")
    private String partyId;
    @JsonProperty("id")
    private String id;
    @JsonProperty("start_date_time")
    private LocalDateTime startDateTime;
    @JsonProperty("end_date_time")
    private LocalDateTime endDateTime;
    @JsonProperty("kwh")
    @Digits(integer = Integer.MAX_VALUE, fraction = 4)
    private Float kwh;
    @JsonProperty("cdr_token")
    private CdrToken cdrToken;
    @JsonProperty("auth_method")
    private AuthMethod authMethod;
    @JsonProperty("authorization_reference")
    private String authorizationReference;
    @JsonProperty("location_id")
    private String locationId;
    @JsonProperty("evse_uid")
    private String evseUid;
    @JsonProperty("connector_id")
    private String connectorId;
    @JsonProperty("meter_id")
    private String meterId;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("charging_periods")
    private List<ChargingPeriod> chargingPeriods;
    @JsonProperty("total_cost")
    private Price totalCost;
    @JsonProperty("status")
    private SessionStatus status;
    @JsonProperty("last_updated")
    private LocalDateTime lastUpdated;
}
