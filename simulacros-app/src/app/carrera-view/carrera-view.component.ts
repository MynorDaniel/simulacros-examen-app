import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Carrera } from '../../entities/Carrera';
import { carrerasTest } from '../../entities/carrera-test';
import { CarreraCardComponent } from '../carrera-card/carrera-card.component';

@Component({
  selector: 'app-carrera-view',
  standalone: true,
  imports: [CarreraCardComponent],
  templateUrl: './carrera-view.component.html',
  styleUrl: './carrera-view.component.css'
})
export class CarreraViewComponent implements OnInit{
  division!: string;
  carreras: Carrera[] = carrerasTest;

  constructor(private route: ActivatedRoute) {}

  ngOnInit() {
    const param = this.route.snapshot.paramMap.get('division');
    if (param){
      this.division = param;
    }
    //Traer carreras en base a la division
 }
}
