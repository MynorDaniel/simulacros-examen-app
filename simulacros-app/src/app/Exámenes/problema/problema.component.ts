import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Problema } from '../../../entities/problema';

@Component({
  selector: 'app-problema',
  standalone: true,
  imports: [],
  templateUrl: './problema.component.html',
  styleUrl: './problema.component.css'
})
export class ProblemaComponent implements OnInit{
  @Input({required: true}) problema!: Problema;
  @Output() addResponse = new EventEmitter<string>();

  respuestas!: string[];

  ngOnInit(): void {
    this.respuestas = [
      this.problema.respuesta1,
      this.problema.respuesta2,
      this.problema.respuesta3,
      this.problema.respuesta4
  ]
  }

  selectResponse(response: string) {
    this.addResponse.emit(response);
  }
   
}
