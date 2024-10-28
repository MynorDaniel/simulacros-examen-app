import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NgFor } from '@angular/common';
import { PreguntaComponent } from '../preguntas/pregunta.component';
import { TemporizadorComponent } from "../../temporizador/temporizador.component";
import { Title } from '@angular/platform-browser';
import { Pregunta } from '../../../entities/pregunta';
import { Respuesta } from '../../../entities/respuesta';
import { PreguntasService } from '../../../services/preguntas/preguntas.service';

@Component({
  imports: [NgFor, PreguntaComponent, TemporizadorComponent],
  selector: 'app-examen',
  standalone: true,
  templateUrl: './examen.component.html',
  styleUrl: './examen.component.css'
})
export class ExamenComponent implements OnInit {
  preguntas: Pregunta[] = [];
  respuestas: Respuesta[] = [];

  finalizado: boolean = false;
  correctas: number = 0;
  incorrectas: number = 0;
  vacias!: number;
  total!: number;
  
  curso!: string;
  tipo!: string;

  constructor(private route: ActivatedRoute, private titleService: Title, private preguntasService: PreguntasService, private router: Router) {}

  ngOnInit() {
    this.scrollToTop();
    const paramCurso = this.route.snapshot.paramMap.get('curso');
    const paramTipo = this.route.snapshot.paramMap.get('tipo');
    if (paramCurso && paramTipo){
      this.curso = paramCurso;
      this.tipo = paramTipo;
    } else {
      this.returnNotFound();
      return;
    }
    this.titleService.setTitle(paramTipo!);
    
    this.preguntasService.obtenerProblemas(this.curso, this.tipo).subscribe(
      {
        next: (preguntasHalladas: Pregunta[]) => {
          this.preguntas = preguntasHalladas;
          this.total = this.preguntas.length;
          this.vacias = this.total;
        },
        error: (error: any) => {
          console.log("Error al obtener las preguntas");
          if (error.status == 400){
            this.returnNotFound();
            console.log("No se hallaron preguntas");
          }
        }
      }
    )
  }

  addResponse(respuesta: Respuesta) {
    for (let index = 0; index < this.respuestas.length; index++) {
      if(this.respuestas[index].id == respuesta.id){
        this.respuestas[index] == respuesta;
        return;
      }
    }
    this.respuestas.push(respuesta);
  }

  onCountdownFinish() {
    this.finalizarExamen();
  }

  finalizarExamen(){
    for (let index = 0; index < this.respuestas.length; index++) {
      this.preguntasService.evaluarRespuesta(this.respuestas[index]).subscribe(
        {
          next: () => {
            this.correctas++;
            this.vacias--;
          },
          error: (error: any) => {
            if (error.status == 400){
              this.incorrectas++;
              this.vacias--;
            }
          }
        }
      )
    }
    this.finalizado = true;
    this.scrollToTop();
  }

  scrollToTop() {
    document.documentElement.scrollTop = 0;
    document.body.scrollTop = 0;
  }

  returnNotFound(){
    this.router.navigate(['/404']);
  }
}
