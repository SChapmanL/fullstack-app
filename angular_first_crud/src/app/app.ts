import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { RouterOutlet } from '@angular/router';

import { GymModel } from './model/Gym';
import { GymService } from './service/gymService';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, ReactiveFormsModule],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App implements OnInit {
  gymForm : FormGroup = new FormGroup({});
  gymObj : GymModel = new GymModel();
  gymList : GymModel[] = [];

  constructor(private gymService: GymService) { }

  ngOnInit(): void {
    this.createForm();
    this.loadGyms();
  }

  loadGyms(): void {
    this.gymService.getGyms().subscribe({
      next: (data) => {
        this.gymList = data;
        console.log('Gyms cargados', data);
      },
      error: (err) => {
        console.error('Error al cargar', err);
      }
    });
  }

  createForm() {
    this.gymForm = new FormGroup({
      codigoUnico : new FormControl(this.gymObj.codigoUnico),
      nombre : new FormControl(this.gymObj.nombre, [Validators.required]),
      distrito : new FormControl(this.gymObj.distrito),
      tarifa_regular_soles : new FormControl(this.gymObj.tarifa_regular_soles),
      membresia_premium_soles : new FormControl(this.gymObj.membresia_premium_soles),
      capacidad_maxima : new FormControl(this.gymObj.capacidad_maxima),
      horario : new FormControl(this.gymObj.horario),
      servicios : new FormControl(this.gymObj.servicios),
      telefono : new FormControl(this.gymObj.telefono, [Validators.minLength(9)]),
      email : new FormControl(this.gymObj.email),
    });
  }

  reset() {
    this.gymObj = new GymModel();
    this.createForm();
  }

  onSave = () => {
    this.gymService.createGym(this.gymForm.value).subscribe({
      next: (newGymFromApi) => {
        this.gymList.unshift(newGymFromApi);
        this.reset();
        console.log('Gym guardado', newGymFromApi);
      },
      error: (err) => console.error('Error en guardado:', err)
    });
  }

  onEdit = (item: GymModel) => {
    this.gymObj = item;
    this.createForm();
  }

  onUpdate = () => {
    const gymToUpdate = this.gymForm.value;
    const gymId = gymToUpdate.codigoUnico;

    this.gymService.updateGym(gymToUpdate).subscribe({
      next: (updatedGymFromApi) => {
        const index = this.gymList.findIndex(g => g.codigoUnico == gymId);
        if (index !== -1) {
          this.gymList[index] = updatedGymFromApi;
        }
        this.reset();
        console.log('Gym actualizado!', updatedGymFromApi);
      },
      error: (err) => console.error('Error actualizando', err)
    });
  }

  onDelete = (id : number) => {
    const isDelete = confirm("Eliminar registro?");
    if (isDelete) {
      this.gymService.deleteGym(id).subscribe({
        next: () => {
          this.gymList = this.gymList.filter(g => g.codigoUnico !== id);
          console.log(`Gym con codigo ${id} eliminado`);
        },
        error: (err) => console.error('No se pudo eliminar:', err)
      });
    }
  }
}