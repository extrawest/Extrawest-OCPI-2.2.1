package com.extrawest.ocpi.model.dto;

import com.extrawest.ocpi.model.Tariff;
import com.extrawest.ocpi.model.enums.AuthMethod;
import com.extrawest.ocpi.model.vo.*;
import com.extrawest.ocpi.model.vo.*;
import com.extrawest.ocpi.model.vo.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CdrDTO {
    @JsonProperty("country_code")
    private String countryCode;
    @JsonProperty("party_id")
    private String partyId;
    private String id;
    @JsonProperty("start_date_time")
    private LocalDateTime startDateTime;
    @JsonProperty("end_date_time")
    private LocalDateTime endDateTime;
    @JsonProperty("session_id")
    private String sessionId;
    @JsonProperty("cdr_token")
    private CdrToken cdrToken;
    @JsonProperty("auth_method")
    private AuthMethod authMethod;
    @JsonProperty("authorization_reference")
    private String authorizationReference;
    @JsonProperty("cdr_location")
    private CdrLocation cdrLocation;
    @JsonProperty("meter_id")
    private String meterId;
    private String currency;
    private List<Tariff> tariffs;
    @JsonProperty("charging_periods")
    private List<ChargingPeriod> chargingPeriods;
    @JsonProperty("signed_data")
    private SignedData signedData;
    @JsonProperty("total_cost")
    private Price totalCost;
    @JsonProperty("total_fixed_cost")
    private Price totalFixedCost;
    @JsonProperty("total_energy")
    private Float totalEnergy;
    @JsonProperty("total_energy_cost")
    private Price totalEnergyCost;
    @JsonProperty("total_time")
    private Float totalTime;
    @JsonProperty("total_time_cost")
    private Price totalTimeCost;
    @JsonProperty("total_parking_time")
    private Float totalParkingTime;
    @JsonProperty("total_parking_cost")
    private Price totalParkingCost;
    @JsonProperty("total_reservation_cost")
    private Price totalReservationCost;
    private String remark;
    @JsonProperty("invoice_reference_id")
    private String invoiceReferenceId;
    private Boolean credit;
    @JsonProperty("credit_reference_id")
    private String creditReferenceId;
    @JsonProperty("home_charging_compensation")
    private Boolean homeChargingCompensation;
    @JsonProperty("last_updated")
    private LocalDateTime lastUpdated;
}
