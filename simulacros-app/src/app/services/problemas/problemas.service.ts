import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { Problema } from '../../../entities/problema';

@Injectable({
  providedIn: 'root'
})
export class ProblemasService {

  constructor(private http: HttpClient) {}

  public getExamen(url: string): Observable<Problema[]> {
    return this.http.get(url, { responseType: 'text' }).pipe(
      map((data: string) => {
        // Separar el contenido del archivo .txt en problemas individuales
        const problemasTexto = data.split('////');

        // Convertir cada bloque de texto en un objeto JSON
        return problemasTexto.map(problemaTexto => {
          try {
            return JSON.parse(problemaTexto.trim()); // Convertir a objeto JSON
          } catch (error) {
            console.error('Error al convertir el problema en JSON:', problemaTexto, error);
          }
        }).filter(problema => problema !== null);
      })
    );
  }

  //this.examenService.getExamen('assets/series.txt').subscribe((problemas: Problema[]) => {
    //console.log(problemas);
  //});
}
