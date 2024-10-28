import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { NgFor } from '@angular/common';
import { ProblemasService } from '../../../services/problemas/problemas.service';
import { Problema } from '../../../entities/problema';
import { ProblemaComponent } from '../problema/problema.component';
import { problemasTest } from '../../../entities/tests/problemas-test';
import { TemporizadorComponent } from "../../temporizador/temporizador.component";

@Component({
  imports: [NgFor, ProblemaComponent, TemporizadorComponent],
  selector: 'app-examen',
  standalone: true,
  templateUrl: './examen.component.html',
  styleUrl: './examen.component.css'
})
export class ExamenComponent {
  problemas: Problema[] = problemasTest;
  respuestas: string[] = new Array(this.problemas.length);
  resultados: string[] = ["8", "kladnalksd", "P₂, 0.72 s", "8asd"];
  finalizado: boolean = false;
  correctas: number = 0;
  incorrectas: number = 0;
  vacias: number = 0;
  
  constructor(private route: ActivatedRoute, private problemasService: ProblemasService) {}

  addResponse(number: number, response: string) {
    this.respuestas[number] = response;
  }

  onCountdownFinish() {
    this.finalizarExamen();
  }

  finalizarExamen(){
    for (let index = 0; index < this.respuestas.length; index++) {
      if(this.respuestas[index] == null){
        this.vacias++;
      } else {
        if (this.respuestas[index] == this.resultados[index]){
          this.correctas++;
        } else{
          this.incorrectas++;
        }
      }
    }
    this.finalizado = true;
    this.scrollToTop();
  }

  scrollToTop() {
    document.documentElement.scrollTop = 0;
  document.body.scrollTop = 0;
  }

}
