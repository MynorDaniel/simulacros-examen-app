import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Input, OnDestroy, OnInit, Output } from '@angular/core';
import { interval, Subscription } from 'rxjs';

@Component({
  selector: 'app-temporizador',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './temporizador.component.html',
  styleUrl: './temporizador.component.css'
})
export class TemporizadorComponent implements OnInit, OnDestroy {
  @Input() duration: number = 1; 
  @Output() countdownFinished = new EventEmitter<void>(); 

  remainingTime!: number;
  formattedTime!: string;
  private subscription!: Subscription;

  ngOnInit() {
    this.remainingTime = this.duration * 60;
    this.updateFormattedTime();
    this.subscription = interval(1000).subscribe(() => {
      this.remainingTime--;
      this.updateFormattedTime();
      if (this.remainingTime <= 0) {
        this.countdownFinished.emit();
        this.subscription.unsubscribe();
      }
    });
  }

  ngOnDestroy() {
    if (this.subscription) {
      this.subscription.unsubscribe();
    }
  }

  private updateFormattedTime() {
    const minutes = Math.floor(this.remainingTime / 60);
    const seconds = this.remainingTime % 60;
    this.formattedTime = `${this.pad(minutes)}:${this.pad(seconds)}`;
  }

  private pad(value: number): string {
    return value < 10 ? `0${value}` : value.toString();
  }
}
