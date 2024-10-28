import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CarreraCardComponent } from '../carrera-card/carrera-card.component';
import { Title } from '@angular/platform-browser';
import { Carrera } from '../../../entities/Carrera';
import { CarrerasService } from '../../../services/carreras/carreras.service';
import { HttpStatusCode } from '@angular/common/http';

@Component({
  selector: 'app-carrera-view',
  standalone: true,
  imports: [CarreraCardComponent],
  templateUrl: './carrera-view.component.html',
  styleUrl: './carrera-view.component.css'
})
export class CarreraViewComponent implements OnInit{
  division!: string;
  carreras!: Carrera[];

  constructor(private route: ActivatedRoute, private titleService: Title, private carrerasService: CarrerasService, private router: Router) {}

  ngOnInit() {
    this.scrollToTop();
    const param = this.route.snapshot.paramMap.get('division');
    if (param){
      this.division = param;
    } else {
      this.router.navigate(['/404']);
      return;
    }
    this.titleService.setTitle(param!);
    
    this.carrerasService.getCarreras(param).subscribe(
      {
        next: (carrerasHalladas: Carrera[]) => {
          this.carreras = carrerasHalladas;
        },
        error: (error: any) => {
          console.log("Error al obtener carreras en base a la division: " + this.division)
          if (error.status == 400){
            this.router.navigate(['/404']);
          }
        }
      }
    )
 }

  scrollToTop() {
    document.documentElement.scrollTop = 0;
    document.body.scrollTop = 0;
  }
}
