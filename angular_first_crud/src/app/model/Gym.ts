export class GymModel {
    codigoUnico : number
    nombre : string
    distrito : string
    tarifa_regular_soles : string
    membresia_premium_soles : string
    capacidad_maxima : number
    horario : string
    servicios : string
    telefono : string
    email : string

    constructor() {
        this.codigoUnico = 1;
        this.nombre = '';
        this.distrito = '';
        this.tarifa_regular_soles = '';
        this.membresia_premium_soles = '';
        this.capacidad_maxima = 0;
        this.horario = '';
        this.servicios = '';
        this.telefono = '';
        this.email = '';
    }

    
}