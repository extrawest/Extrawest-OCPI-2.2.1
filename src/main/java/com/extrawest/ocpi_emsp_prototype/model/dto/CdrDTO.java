package com.extrawest.ocpi_emsp_prototype.model.dto;

import com.extrawest.ocpi_emsp_prototype.model.Tariff;
import com.extrawest.ocpi_emsp_prototype.model.enums.AuthMethod;
import com.extrawest.ocpi_emsp_prototype.model.vo.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CdrDTO {
    private String countryCode;
    private String partyId;
    private String id;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private String sessionId;
    private CdrToken cdrToken;
    private AuthMethod authMethod;
    private String authorizationReference;
    private CdrLocation cdrLocation;
    private String meterId;
    private String currency;
    private List<Tariff> tariffs;
    private List<ChargingPeriod> chargingPeriods;
    private SignedData signedData;
    private Price totalCost;
    private Price totalFixedCost;
    private Float totalEnergy;
    private Price totalEnergyCost;
    private Float totalTime;
    private Price totalTimeCost;
    private Float totalParkingTime;
    private Price totalParkingCost;
    private Price totalReservationCost;
    private String remark;
    private String invoiceReferenceId;
    private Boolean credit;
    private String creditReferenceId;
    private Boolean homeChargingCompensation;
    private LocalDateTime lastUpdated;
}
