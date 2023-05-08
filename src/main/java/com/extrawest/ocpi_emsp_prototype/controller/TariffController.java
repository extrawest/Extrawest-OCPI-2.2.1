package com.extrawest.ocpi_emsp_prototype.controller;

import com.extrawest.ocpi_emsp_prototype.model.Tariff;
import com.extrawest.ocpi_emsp_prototype.service.ITariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emsp/api/tariffs")
public class TariffController {

    @Autowired
    private ITariffService tariffService;

    @PutMapping("/pushModel")
    public ResponseEntity<String> saveTariff(@RequestBody Tariff tariff) {
        if (tariffService.save(tariff)) {
            return ResponseEntity.status(HttpStatus.OK).body(tariff.toString());
        } else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                "Request is invalid, please check that all of fields are set with correct values"
        );
    }
}
