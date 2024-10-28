import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Problema } from '../../entities/problema';
import { Api_URL } from '../rest-constants';

@Injectable({
  providedIn: 'root'
})
export class ProblemasService {

  constructor(private httpClient: HttpClient) {}

  
  public obtenerProblema(id: string): Observable<Problema> {
    return this.httpClient.get<Problema>(Api_URL + "problema");
  }

  public obtenerProblemas(curso: string, carrera: string): Observable<Problema[]> {
    return this.httpClient.get<Problema[]>(Api_URL + "problema/" + carrera + "/" + curso);
  }

}
