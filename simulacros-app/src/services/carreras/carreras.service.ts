import { Injectable } from '@angular/core';
import { RestConstants } from '../rest-constants';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Carrera } from '../../entities/Carrera';

@Injectable({
  providedIn: 'root'
})
export class CarrerasService {
  restConstants: RestConstants;
  constructor(private httpClient: HttpClient) { 
    this.restConstants = new RestConstants();
  }

  getCarreras(division: string): Observable<Carrera[]> {
    return this.httpClient.get<Carrera[]>(this.restConstants.getApiURL() + "carrera/" + division);
  }
}
