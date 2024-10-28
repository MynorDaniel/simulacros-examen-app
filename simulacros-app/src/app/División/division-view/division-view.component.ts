import { Component } from '@angular/core';
import { Division } from '../../../entities/Division';
import { divisionTest } from '../../../entities/tests/division-test';
import { DivisionCardComponent } from '../division-card/division-card.component';

@Component({
  selector: 'app-division-view',
  standalone: true,
  imports: [DivisionCardComponent],
  templateUrl: './division-view.component.html',
  styleUrl: './division-view.component.css'
})
export class DivisionViewComponent {
  divisiones: Division[] = divisionTest;
}
