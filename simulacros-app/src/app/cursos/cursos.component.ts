import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cursos',
  standalone: true,
  templateUrl: './cursos.component.html',
  styleUrls: ['./cursos.component.css']
})
export class CursosComponent {

  constructor(private router: Router) {}

  navigateTo(curso: string, tipo: string) {
    this.router.navigate(['examen', curso, tipo]);
  }
}
