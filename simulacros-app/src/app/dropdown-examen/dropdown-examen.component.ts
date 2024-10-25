import { Component, Input } from '@angular/core';
import { Examen } from '../../entities/examen';

@Component({
  selector: 'app-dropdown-examen',
  standalone: true,
  imports: [],
  templateUrl: './dropdown-examen.component.html',
  styleUrl: './dropdown-examen.component.css'
})
export class DropdownExamenComponent {
  @Input({required: true}) examen!: Examen;
}
