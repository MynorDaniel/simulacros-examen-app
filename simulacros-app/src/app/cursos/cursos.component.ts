import { Component } from '@angular/core';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { CursoCard } from "../curso-card/curso-card.component";
import { Curso } from '../../entities/Curso';
import { cursoTest } from '../../entities/tests/curso-tst';
import { DropdownExamenComponent } from "../dropdown-examen/dropdown-examen.component";
import { Examen } from '../../entities/examen';
import { examenesTest } from '../../entities/tests/examenes-test';
import { Title } from '@angular/platform-browser';

@Component({
  selector: 'app-cursos',
  standalone: true,
  templateUrl: './cursos.component.html',
  styleUrls: ['./cursos.component.css'],
  imports: [CursoCard, RouterLink, DropdownExamenComponent]
})
export class CursosComponent {
  carrera!: string;
  division!: string;
  curso!: string;
  currentCurso: Curso = cursoTest;
  examenes: Examen[] = examenesTest;

  constructor(private route: ActivatedRoute, private titleService: Title) {}
  
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
    this.titleService.setTitle(paramCurso!);
    //Traer carreras en base a la division
 }
}
