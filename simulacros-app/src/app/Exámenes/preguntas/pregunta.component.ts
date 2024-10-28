import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Pregunta } from '../../../entities/pregunta';
import { DomSanitizer, SafeUrl } from '@angular/platform-browser';
import { Respuesta } from '../../../entities/respuesta';

@Component({
  selector: 'app-pregunta',
  standalone: true,
  imports: [],
  templateUrl: './pregunta.component.html',
  styleUrl: './pregunta.component.css'
})
export class PreguntaComponent implements OnInit{
  @Input({required: true}) pregunta!: Pregunta;
  @Output() addResponse = new EventEmitter<Respuesta>();
  
  imagenUrl!: SafeUrl;
  id!: number;
  respuestas!: string[];
  
  constructor(private sanitizer: DomSanitizer) {}

  ngOnInit(): void {
    this.respuestas = [
      this.pregunta.respuestaIncorrecta1,
      this.pregunta.respuestaCorrecta,
      this.pregunta.respuestaIncorrecta2,
      this.pregunta.respuestaIncorrecta3
    ]
    this.id = this.pregunta.id;
    this.shuffleArray();
  }

  ngOnChanges() {
    if (this.pregunta) {
      this.imagenUrl = this.sanitizer.bypassSecurityTrustUrl(
        `data:image/png;base64,${this.pregunta.imagen}`
      );
    }
  }

  selectResponse(respuesta: string) {
    const seleccionado: Respuesta = {
      id: this.id,
      valor: respuesta,
    }
    this.addResponse.emit(seleccionado);
  }

  shuffleArray() {
    for (let i = this.respuestas.length - 1; i > 0; i--) {
      const j = Math.floor(Math.random() * (i + 1));
      [this.respuestas[i], this.respuestas[j]] = [this.respuestas[j], this.respuestas[i]];
    }
  }
   
}
