import { Pipe, PipeTransform } from '@angular/core';
import { DomSanitizer, SafeHtml } from '@angular/platform-browser';

declare var MathJax: any;

@Pipe({
  name: 'mathjax',
  standalone: true
})
export class MathjaxPipe implements PipeTransform {

  constructor(private sanitizer: DomSanitizer) {}

  transform(value: string): SafeHtml {
    const sanitizedValue = this.sanitizer.bypassSecurityTrustHtml(value);
    
    setTimeout(() => {
      if (typeof MathJax !== 'undefined') {
        MathJax.typesetPromise();
      } else {
        console.error('MathJax no está definido');
      }
    }, 0);
  
    return sanitizedValue;
  }
  

}
