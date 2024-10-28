import { Component } from '@angular/core';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { CursoCard } from "../curso-card/curso-card.component";
import { Curso } from '../../../entities/Curso';
import { DropdownExamenComponent } from "../dropdown-examen/dropdown-examen.component";
import { Examen } from '../../../entities/examen';
import { Title } from '@angular/platform-browser';
import { CursosService } from '../../../services/cursos/cursos.service';
import { ExamenesService } from '../../../services/examenes/examenes.service';

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
  currentCurso!: Curso;
  examenes!: Examen[];

  constructor(private route: ActivatedRoute, private titleService: Title, private cursosService: CursosService, private examenesService: ExamenesService, private router: Router) {}

  
  ngOnInit() {
    this.scrollToTop();
    const paramDivision = this.route.snapshot.paramMap.get('division');
    const paramCarrera = this.route.snapshot.paramMap.get('carrera');
    const paramCurso = this.route.snapshot.paramMap.get('curso');
    if (paramDivision && paramCarrera && paramCurso){
      this.division = paramDivision;
      this.carrera = paramCarrera;
      this.curso = paramCurso;
    } else {
      this.returnNotFound();
      return;
    }
    this.titleService.setTitle(paramCurso!);
    
    this.cursosService.getCurso(this.carrera, this.curso).subscribe(
      {
        next: (cursoHallado: Curso) => {
          this.currentCurso = cursoHallado;
        },
        error: (error: any) => {
          console.log("Error al obtener el curso");
          if (error.status == 400){
            this.returnNotFound();
            return;
          }
        }
      }
    )

    this.examenesService.getExamenes(this.curso).subscribe(
      {
        next: (examanesHallados: Examen[]) => {
          this.examenes = examanesHallados;
        },
        error: (error: any) => {
          console.log("Error al obtener los examenes");
          if (error.status == 400){
            console.log("No se hallaron examenes");
          }
        }
      }
    )
 }
 scrollToTop() {
  document.documentElement.scrollTop = 0;
  document.body.scrollTop = 0;
}

returnNotFound(){
  this.router.navigate(['/404']);
}
}
