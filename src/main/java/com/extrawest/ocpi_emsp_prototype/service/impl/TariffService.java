package com.extrawest.ocpi_emsp_prototype.service.impl;

import com.extrawest.ocpi_emsp_prototype.dataTypes.PriceComponent;
import com.extrawest.ocpi_emsp_prototype.dataTypes.TariffElement;
import com.extrawest.ocpi_emsp_prototype.dataTypes.enums.TariffDimensionType;
import com.extrawest.ocpi_emsp_prototype.model.Tariff;
import com.extrawest.ocpi_emsp_prototype.service.ITariffService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TariffService implements ITariffService {

    @Override
    public boolean save (Tariff tariff) {
        return tariff.validate();
    }

    @Override
    public List<Tariff> getAll() {
        return getTariffList();
    }

    @Override
    public Tariff getById(String id) {
        return getTariff(id);
    }

    private Tariff getTariff() {
        return new Tariff(
                "0542",
                "7878",
                UUID.randomUUID().toString(),
                "UAH",
                getTariffElementList(),
                LocalDateTime.now()
        );
    }

    private Tariff getTariff(String id) {
        return new Tariff(
                "0542",
                "7878",
                id,
                "UAH",
                getTariffElementList(),
                LocalDateTime.now()
        );
    }

    private List<Tariff> getTariffList() {
        List<Tariff> tariffs = new ArrayList<>();
        tariffs.add(getTariff());
        tariffs.add(getTariff());
        tariffs.add(getTariff());
        tariffs.add(getTariff());
        tariffs.add(getTariff());
        tariffs.add(getTariff());
        return tariffs;
    }

    private List<TariffElement> getTariffElementList() {
        PriceComponent priceComponent1 = new PriceComponent(
                TariffDimensionType.ENERGY,
                2.52f,
                1
        );
        PriceComponent priceComponent2 = new PriceComponent(
                TariffDimensionType.FLAT,
                1.1243f,
                2
        );
        PriceComponent priceComponent3 = new PriceComponent(
                TariffDimensionType.PARKING_TIME,
                9f,
                3
        );
        List<PriceComponent> priceComponentList = new ArrayList<>();
        priceComponentList.add(priceComponent1);
        priceComponentList.add(priceComponent2);
        priceComponentList.add(priceComponent3);
        TariffElement tariffElement1 = new TariffElement(priceComponentList);
        TariffElement tariffElement2 = new TariffElement(priceComponentList);
        TariffElement tariffElement3 = new TariffElement(priceComponentList);
        List<TariffElement> tariffElements = new ArrayList<>();
        tariffElements.add(tariffElement1);
        tariffElements.add(tariffElement2);
        tariffElements.add(tariffElement3);
        return tariffElements;
    }
}
