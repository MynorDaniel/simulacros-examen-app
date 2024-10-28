import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Curso } from '../../entities/Curso';
import { RestConstants } from '../rest-constants';

@Injectable({
  providedIn: 'root'
})
export class CursosService {
  restConstants: RestConstants;
  constructor(private httpClient: HttpClient) { 
    this.restConstants = new RestConstants();
  }

  getCursos(carrera: string): Observable<Curso[]> {
    return this.httpClient.get<Curso[]>(this.restConstants.getApiURL() + "curso/" + carrera);
  }

  getCurso(carrera: string, curso: string): Observable<Curso> {
    return this.httpClient.get<Curso>(this.restConstants.getApiURL() + "curso/" + carrera + "/" + curso);
  }
}
