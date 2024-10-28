import { Injectable } from '@angular/core';
import { RestConstants } from '../rest-constants';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Examen } from '../../entities/examen';

@Injectable({
  providedIn: 'root'
})
export class ExamenesService {
  restConstants: RestConstants;
  constructor(private httpClient: HttpClient) { 
    this.restConstants = new RestConstants();
  }

  getExamenes(curso: string): Observable<Examen[]> {
    return this.httpClient.get<Examen[]>(this.restConstants.getApiURL() + "examen/" + curso);
  }
  
}
