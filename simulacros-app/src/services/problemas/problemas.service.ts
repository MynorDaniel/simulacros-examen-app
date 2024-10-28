import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Problema } from '../../entities/problema';
import { RestConstants } from '../rest-constants';

@Injectable({
  providedIn: 'root'
})
export class ProblemasService {
  restConstants: RestConstants;

  constructor(private httpClient: HttpClient) {
    this.restConstants = new RestConstants();
  }

  
  public obtenerProblema(id: string): Observable<Problema> {
    return this.httpClient.get<Problema>(this.restConstants.getApiURL() + "problema");
  }

  public obtenerProblemas(curso: string, carrera: string): Observable<Problema[]> {
    return this.httpClient.get<Problema[]>(this.restConstants.getApiURL() + "problema/" + carrera + "/" + curso);
  }

}
