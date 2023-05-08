package com.extrawest.ocpi_emsp_prototype.service;

import com.extrawest.ocpi_emsp_prototype.model.Tariff;

import java.util.List;

public interface ITariffService {
    List<Tariff> getAll();
    Tariff getById(String id);
    boolean save (Tariff tariff);

}
