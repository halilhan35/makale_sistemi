package com.makale_sistemi.controller;

import com.makale_sistemi.dto.AnahtarKelimeAlanDto;
import com.makale_sistemi.model.response.ServiceResponse;
import com.makale_sistemi.service.IAnahtarKelimeAlanService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/crud/anahtar-kelime-alan")
@RequiredArgsConstructor
public class AnahtarKelimeAlanController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final IAnahtarKelimeAlanService alanService;

    @GetMapping(value = "/find-all")
    @Operation(summary = "List All", description = "Find All Records")
    public ResponseEntity<ServiceResponse> findAll() {
        try {
            List<AnahtarKelimeAlanDto> dtoList = alanService.findAll();
            return ResponseEntity.ok(ServiceResponse
                    .builder()
                    .success(true)
                    .statusCode(200)
                    .message(null)
                    .data(dtoList)
                    .timestamp(LocalDateTime.now())
                    .build());
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.ok(ServiceResponse
                    .builder()
                    .success(false)
                    .statusCode(500)
                    .message(e.getMessage())
                    .data(null)
                    .timestamp(LocalDateTime.now())
                    .build());
        }
    }

    @GetMapping(value = "/find-all-with-pageable")
    @Operation(summary = "List All Records With Pageable", description = "Find All Records With Paging Parameters")
    public ResponseEntity<ServiceResponse> findAllWithPageable(Pageable pageable) {
        try {
            Page<AnahtarKelimeAlanDto> dtoPage = alanService.findAllWithPageable(pageable);
            return ResponseEntity.ok(ServiceResponse
                    .builder()
                    .success(true)
                    .statusCode(200)
                    .message(null)
                    .data(dtoPage)
                    .timestamp(LocalDateTime.now())
                    .build());
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.ok(ServiceResponse
                    .builder()
                    .success(false)
                    .statusCode(500)
                    .message(e.getMessage())
                    .data(null)
                    .timestamp(LocalDateTime.now())
                    .build());
        }
    }

    @GetMapping(value = "/find/{id}")
    @Operation(summary = "List For ID", description = "Find Record By ID")
    public ResponseEntity<ServiceResponse> findById(@PathVariable Long id) {
        try {
            AnahtarKelimeAlanDto dto = alanService.findById(id, true);
            return ResponseEntity.ok(ServiceResponse
                    .builder()
                    .success(true)
                    .statusCode(200)
                    .message(null)
                    .data(dto)
                    .timestamp(LocalDateTime.now())
                    .build());
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.ok(ServiceResponse
                    .builder()
                    .success(false)
                    .statusCode(500)
                    .message(e.getMessage())
                    .data(null)
                    .timestamp(LocalDateTime.now())
                    .build());
        }
    }

    @PostMapping(value = "/save-or-update")
    @Operation(summary = "Save or Update Record", description = "Save or Update Record by Request Body")
    public ResponseEntity<ServiceResponse> saveOrUpdate(@RequestBody AnahtarKelimeAlanDto dto) {
        try {
            AnahtarKelimeAlanDto responseDto = alanService.saveOrUpdate(dto);
            return ResponseEntity.ok(ServiceResponse
                    .builder()
                    .success(true)
                    .statusCode(200)
                    .message(null)
                    .data(responseDto)
                    .timestamp(LocalDateTime.now())
                    .build());
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.ok(ServiceResponse
                    .builder()
                    .statusCode(500)
                    .success(false)
                    .message(e.getMessage())
                    .data(null)
                    .timestamp(LocalDateTime.now())
                    .build());
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    @Operation(summary = "Delete Record", description = "Delete Record By ID")
    public ResponseEntity<ServiceResponse> deleteById(@PathVariable Long id) {
        try {
            alanService.deleteById(id);
            return ResponseEntity.ok(ServiceResponse
                    .builder()
                    .success(true)
                    .statusCode(200)
                    .message(null)
                    .data(true)
                    .timestamp(LocalDateTime.now())
                    .build());
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.ok(ServiceResponse
                    .builder()
                    .success(false)
                    .statusCode(500)
                    .message(e.getMessage())
                    .data(null)
                    .timestamp(LocalDateTime.now())
                    .build());
        }
    }
}