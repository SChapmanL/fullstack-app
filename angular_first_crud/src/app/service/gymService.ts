import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { GymModel } from '../model/Gym';

@Injectable({
  providedIn: 'root'
})
export class GymService {
  private apiUrl = 'http://localhost:8080/api/v1/gym';

  constructor(private http: HttpClient) { }

  /*READ*/
  getGyms(): Observable<GymModel[]> {
    return this.http.get<GymModel[]>(this.apiUrl);
  }
  /*CREATE*/
  createGym(gym: GymModel): Observable<GymModel> {
    const { codigoUnico, ...gymData } = gym;
    return this.http.post<GymModel>(this.apiUrl, gymData);
  }
  /*UPDATE*/
  updateGym(gym: GymModel): Observable<GymModel> {
    return this.http.put<GymModel>(this.apiUrl, gym);
  }
  /*DELETE*/
  deleteGym(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}