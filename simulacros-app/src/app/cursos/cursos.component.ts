import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CursoCard } from "../curso-card/curso-card.component";

@Component({
  selector: 'app-cursos',
  standalone: true,
  templateUrl: './cursos.component.html',
  styleUrls: ['./cursos.component.css'],
  imports: [CursoCard]
})
export class CursosComponent {

  constructor(private router: Router) {}

  navigateTo(curso: string, tipo: string) {
    this.router.navigate(['examen', curso, tipo]);
  }
}
