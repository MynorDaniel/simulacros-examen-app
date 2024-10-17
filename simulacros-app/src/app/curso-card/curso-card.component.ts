import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';

@Component({
    selector: 'app-curso-card',
    standalone: true,
    imports: [],
    templateUrl: './curso-card.component.html',
  })
  export class CursoCard {
    @Input({required: true}) curso: string = "";
    @Input({required: true}) tipo: string = "";

    constructor(private router: Router) {}

    navigateTo(curso: string, tipo: string) {
        this.router.navigate(['examen', curso, tipo]);
      }
  }