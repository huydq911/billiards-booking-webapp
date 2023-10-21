package com.example.BBP_Backend.Controller;

import com.example.BBP_Backend.Response.ResponeObject;
import com.example.BBP_Backend.Service.BookingStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bookingStatus")
public class BookingStatusController {
    private final BookingStatusService service;

    @GetMapping("/getAll")
    public ResponseEntity<ResponeObject> getAll() {
        try {
            return ResponseEntity.ok(
                    new ResponeObject(
                            "Ok",
                            "All booking status",
                            service.getAll()
                    )
            );
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponeObject(
                            "Not Found",
                            ex.getMessage(),
                            null
                    )
            );
        }
    }
}
