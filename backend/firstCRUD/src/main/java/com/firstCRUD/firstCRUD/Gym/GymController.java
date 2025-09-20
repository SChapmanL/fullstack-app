package com.firstCRUD.firstCRUD.Gym;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
/*Ya es un controlador*/
@RequestMapping(path = "/api/v1/gym")
@CrossOrigin(origins = "http://localhost:4200")
public class GymController {
    private final GymService gymService;
    @Autowired
    public GymController(GymService gymService) {
        this.gymService = gymService;
    }

    @GetMapping
    public List<Gym> getGyms(@RequestParam(required = false) Integer codigoUnico,
                             @RequestParam(required = false) String nombre,
                             @RequestParam(required = false) String distrito,
                             @RequestParam(required = false) String email
                             ) {
        if (codigoUnico != null) {
            return gymService.getGymsByCodigo(codigoUnico);
        } else if (nombre != null) {
            return gymService.getGymsByName(nombre);
        } else if (distrito != null) {
            return gymService.getGymsByDistrict(distrito);
        } else if (email != null) {
            return gymService.getGymsByEmail(email);
        } else {
            return gymService.getGyms();
        }

    }

    @PostMapping
    public ResponseEntity<Gym> createGym(@RequestBody Gym gym) {
        Gym gymCreado = gymService.addGym(gym);
        return new ResponseEntity<>(gymCreado, HttpStatus.CREATED);
    }


    @PutMapping
    public ResponseEntity<Gym> updateGym(@RequestBody Gym gym) {
        Gym gymUpdate = gymService.updateGym(gym);

        if (gymUpdate != null) {
            return new ResponseEntity<>(gymUpdate, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }

    @DeleteMapping("/{gymCode}")
    public ResponseEntity<Integer> deleteGym(@PathVariable Integer gymCode) {
        gymService.deleteGym(gymCode);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
