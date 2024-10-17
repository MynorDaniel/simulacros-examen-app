import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProblemasService {

  constructor(private http: HttpClient) {}

  public obtenerContenidoArchivo(url: string): Observable<string> {
    return this.http.get(url, { responseType: 'text' });
  }

}
