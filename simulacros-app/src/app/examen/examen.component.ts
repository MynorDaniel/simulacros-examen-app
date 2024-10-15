import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProblemasService } from '../services/problemas/problemas.service';
import { Problema } from '../../entities/problema';
import { NgFor } from '@angular/common';
import { MathjaxPipe } from '../pipes/latex.pipe';

@Component({
  imports: [NgFor, MathjaxPipe],
  selector: 'app-examen',
  standalone: true,
  templateUrl: './examen.component.html',
  styleUrl: './examen.component.css'
})
export class ExamenComponent implements OnInit {
  curso: string | null = null;
  tipo: string | null = null;
  urlEnunciados: string = 'assets/problemas/basicos/mate/enunciados.txt';
  problemas: Problema[] = [];
  contenidoArchivo: string = '';
  respuestasSeleccionadas: string[] = [];

  constructor(private route: ActivatedRoute, private problemasService: ProblemasService) {}

  ngOnInit(): void {
    this.respuestasSeleccionadas = new Array(this.problemas.length).fill('');
    this.route.params.subscribe(params => {
      this.curso = params['curso'];
      this.tipo = params['tipo'];
    });

    this.problemasService.obtenerContenidoArchivo(this.urlEnunciados)
      .subscribe({
        next: (contenido: string) => {
          this.contenidoArchivo = contenido;
          this.problemas = this.obtenerProblemas(this.contenidoArchivo.split("////"));
          this.problemas.forEach(element => {
            console.log(element);
          });
          
        },
        error: (err: any) => {
          console.error('Error al obtener el contenido del archivo:', err);
        }
      });
  }

  seleccionarRespuesta(indiceProblema: number, respuesta: string): void {
    this.respuestasSeleccionadas[indiceProblema] = respuesta;
  }

  terminarExamen(): void {
    console.log('Respuestas seleccionadas:', this.respuestasSeleccionadas);
  }

  obtenerContenidoDelArchivo(): void {
    this.problemasService.obtenerContenidoArchivo(this.urlEnunciados)
      .subscribe({
        next: (contenido: string) => {
          this.contenidoArchivo = contenido;
        },
        error: (err: any) => {
          console.error('Error al obtener el contenido del archivo:', err);
        }
      });
  }

  obtenerProblemas(problemas: string[]): Problema[] {
    const problemasMezclados = problemas.sort(() => Math.random() - 0.5);
    
    const problemasSeleccionados = problemasMezclados.slice(0, 4);
  
    return problemasSeleccionados.map(problemaTexto => {
      try {
        return JSON.parse(problemaTexto.trim()) as Problema;
      } catch (error) {
        console.error('Error al convertir el problema en JSON:', problemaTexto, error);
        return null; 
      }
    }).filter(problema => problema !== null) as Problema[];
  }
}
