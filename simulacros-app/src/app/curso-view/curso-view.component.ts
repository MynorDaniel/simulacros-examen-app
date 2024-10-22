import { Component, OnInit } from '@angular/core';
import { cursosTest } from '../../entities/curso-test';
import { Curso } from '../../entities/Curso';
import { CursoCard } from '../curso-card/curso-card.component';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-curso-view',
  standalone: true,
  imports: [CursoCard],
  templateUrl: './curso-view.component.html',
  styleUrl: './curso-view.component.css'
})
export class CursoViewComponent implements OnInit{
  cursos: Curso[] = cursosTest;
  carrera!: string;
  division!: string;

  constructor(private route: ActivatedRoute) {}

  ngOnInit() {
    const paramDivision = this.route.snapshot.paramMap.get('division');
    const paramCarrera = this.route.snapshot.paramMap.get('carrera');
    if (paramDivision){
      this.division = paramDivision;
    }
    if (paramCarrera){
      this.carrera = paramCarrera;
    }
    //Traer carreras en base a la division
 }
}
