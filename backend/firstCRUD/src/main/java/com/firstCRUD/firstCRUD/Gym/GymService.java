package com.firstCRUD.firstCRUD.Gym;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class GymService {
    private final GymRepository gymRepository;

    @Autowired
    /*CONSTRUCTOR*/
    public GymService(GymRepository gymRepository) {
        this.gymRepository = gymRepository;
    }

    /*La business layer*/
    public List<Gym> getGyms() {
        return gymRepository.findAll();
    }

    public List<Gym> getGymsByCodigo(Integer codigo) {
        return gymRepository.findAll().stream().filter(Gym -> Objects.equals(codigo, Gym.getCodigoUnico())).collect(Collectors.toList());
    }

    public List<Gym> getGymsByName(String name) {
        return gymRepository.findAll().stream().filter(Gym -> name.equals(Gym.getNombre())).collect(Collectors.toList());
    }

    public List<Gym> getGymsByDistrict(String district) {
        return gymRepository.findAll().stream().filter(Gym -> district.equals(Gym.getDistrito())).collect(Collectors.toList());
    }

    public List<Gym> getGymsByEmail(String email) {
        return gymRepository.findAll().stream().filter(Gym -> email.equals(Gym.getEmail())).collect(Collectors.toList());
    }

    /*Operaciones de INSERT*/
    public Gym addGym(Gym gym) {
        gymRepository.save(gym);
        return gym;
    }

    /*Operaciones de UPDATE*/

    public Gym updateGym(Gym gym) {
        /*Manejo si el gym no existe*/
        Optional<Gym> currentGym = gymRepository.findByCodigoUnico(gym.getCodigoUnico());

        if (currentGym.isPresent()) {
            /*Actualizar todos los campos*/
            Gym toUpdate = currentGym.get();
            toUpdate.setNombre(gym.getNombre());
            toUpdate.setDistrito(gym.getDistrito());
            toUpdate.setTarifa_regular_soles(gym.getTarifa_regular_soles());
            toUpdate.setMembresia_premium_soles(gym.getMembresia_premium_soles());
            toUpdate.setCapacidad_maxima(gym.getCapacidad_maxima());
            toUpdate.setHorario(gym.getHorario());
            toUpdate.setServicios(gym.getServicios());
            toUpdate.setTelefono(gym.getTelefono());
            toUpdate.setEmail(gym.getEmail());

            gymRepository.save(toUpdate);
            return toUpdate;

        }
        return null;
    }

    @Transactional
    public void deleteGym(Integer codigo) {
        gymRepository.deleteByCodigoUnico(codigo);
    }
}
