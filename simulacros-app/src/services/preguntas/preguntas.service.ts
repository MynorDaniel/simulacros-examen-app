import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Pregunta } from '../../entities/pregunta';
import { RestConstants } from '../rest-constants';
import { Respuesta } from '../../entities/respuesta';

@Injectable({
  providedIn: 'root'
})
export class PreguntasService {
  restConstants: RestConstants;

  constructor(private httpClient: HttpClient) {
    this.restConstants = new RestConstants();
  }

  public obtenerProblemas(curso: string, tipo: string): Observable<Pregunta[]> {
    return this.httpClient.get<Pregunta[]>(this.restConstants.getApiURL() + "examen/" + curso + "/" + tipo);
  }

  public evaluarRespuesta(respuesta: Respuesta): Observable<void> {
    return this.httpClient.get<void>(this.restConstants.getApiURL() + "respuesta/" + respuesta.id + "/" + respuesta.valor);
  }

}
