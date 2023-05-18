package com.extrawest.ocpi_emsp_prototype.controller.emsp;

import com.extrawest.ocpi_emsp_prototype.dto.TariffRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/emsp/api/tariffs")
public abstract class EMSPTariffController {

    @PutMapping("/pushModel")
    public abstract ResponseEntity<String> saveTariff(@RequestBody List<TariffRequestDTO> tariffRequestDTOList);
}
