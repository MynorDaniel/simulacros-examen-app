import { Component, Input } from '@angular/core';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { CursoCard } from "../curso-card/curso-card.component";
import { Curso } from '../../entities/Curso';
import { cursoTest } from '../../entities/curso-tst';

@Component({
  selector: 'app-cursos',
  standalone: true,
  templateUrl: './cursos.component.html',
  styleUrls: ['./cursos.component.css'],
  imports: [CursoCard, RouterLink]
})
export class CursosComponent {
  carrera!: string;
  division!: string;
  curso!: string;
  currentCurso: Curso = cursoTest;

  constructor(private route: ActivatedRoute) {}
  
  ngOnInit() {
    const paramDivision = this.route.snapshot.paramMap.get('division');
    const paramCarrera = this.route.snapshot.paramMap.get('carrera');
    const paramCurso = this.route.snapshot.paramMap.get('curso');
    if (paramDivision){
      this.division = paramDivision;
    }
    if (paramCarrera){
      this.carrera = paramCarrera;
    }
    if (paramCurso){
      this.curso = paramCurso;
    }
    //Traer carreras en base a la division
 }
}
