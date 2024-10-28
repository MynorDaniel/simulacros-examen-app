import { Component, Input } from '@angular/core';
import { Division } from '../../../entities/Division';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-division-card',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './division-card.component.html',
  styleUrl: './division-card.component.css'
})
export class DivisionCardComponent {
  @Input({required: true}) division!: Division;
}
