import { Component, OnInit } from '@angular/core';
import { Curso } from '../../../entities/Curso';
import { CursoCard } from '../curso-card/curso-card.component';
import { ActivatedRoute, Router } from '@angular/router';
import { Title } from '@angular/platform-browser';
import { CursosService } from '../../../services/cursos/cursos.service';

@Component({
  selector: 'app-curso-view',
  standalone: true,
  imports: [CursoCard],
  templateUrl: './curso-view.component.html',
  styleUrl: './curso-view.component.css'
})
export class CursoViewComponent implements OnInit{
  cursos!: Curso[];
  carrera!: string;
  division!: string;

  constructor(private route: ActivatedRoute, private titleService: Title, private cursosService: CursosService, private router: Router) {}

  ngOnInit() {
    this.scrollToTop();
    const paramDivision = this.route.snapshot.paramMap.get('division');
    const paramCarrera = this.route.snapshot.paramMap.get('carrera');
    if (paramDivision && paramCarrera){
      this.division = paramDivision;
      this.carrera = paramCarrera;
    } else {
      this.returnNotFound();
      return;
    }
    this.titleService.setTitle(paramCarrera!);
    
    this.cursosService.getCursos(this.carrera).subscribe(
      {
        next: (cursosHallados: Curso[]) => {
          this.cursos = cursosHallados;
        },
        error: (error: any) => {
          console.log("Error al obtener los cursos");
          if (error.status == 400){
            this.returnNotFound();
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
