import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Curso } from '../../entities/Curso';

@Injectable({
  providedIn: 'root'
})
export class CursosService {
  url!: string;

  constructor(private httpClient: HttpClient) { }

  getCursos(): Observable<Curso[]> {
    return this.httpClient.get<Curso[]>(this.url + "cursos");
  }
}
