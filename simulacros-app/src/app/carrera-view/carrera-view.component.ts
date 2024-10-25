import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Carrera } from '../../entities/Carrera';
import { carrerasTest } from '../../entities/tests/carrera-test';
import { CarreraCardComponent } from '../carrera-card/carrera-card.component';
import { Title } from '@angular/platform-browser';

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

  constructor(private route: ActivatedRoute, private titleService: Title) {}

  ngOnInit() {
    const param = this.route.snapshot.paramMap.get('division');
    if (param){
      this.division = param;
    }
    this.titleService.setTitle(param!);
    //Traer carreras en base a la division
 }
}
