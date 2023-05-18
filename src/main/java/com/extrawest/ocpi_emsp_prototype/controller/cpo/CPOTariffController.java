package com.extrawest.ocpi_emsp_prototype.controller.cpo;

import com.extrawest.ocpi_emsp_prototype.dto.TariffResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cpo/api/tariffs")
@AllArgsConstructor
public abstract class CPOTariffController {

    @GetMapping("/pullModel")
    public abstract ResponseEntity<List<TariffResponseDTO>> saveTariff();
}
