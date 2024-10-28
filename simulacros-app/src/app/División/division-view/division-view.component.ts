import { Component, OnInit } from '@angular/core';
import { Division } from '../../../entities/Division';
import { DivisionCardComponent } from '../division-card/division-card.component';
import { DivisionesService } from '../../../services/divisiones/divisiones.service';
import { Router } from '@angular/router';
import { HttpStatusCode } from '@angular/common/http';

@Component({
  selector: 'app-division-view',
  standalone: true,
  imports: [DivisionCardComponent],
  templateUrl: './division-view.component.html',
  styleUrl: './division-view.component.css'
})
export class DivisionViewComponent implements OnInit {
  divisiones!: Division[];

  constructor (private divisionesService: DivisionesService, private router: Router) {}

  ngOnInit(): void {
    this.scrollToTop();
    this.divisionesService.getDivisiones().subscribe(
      {
        next: (divisionesHalladas: Division[]) => {
          this.divisiones = divisionesHalladas;
        },
        error: (error: any) => {
          console.log("Error al obtener divisiones");
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
