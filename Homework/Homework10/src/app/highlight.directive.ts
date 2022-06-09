import { Directive, ElementRef, HostListener, Input } from '@angular/core';

@Directive({
  selector: '[appHighlight]'
})
export class HighlightDirective {

  constructor(private el: ElementRef) { }

  @Input('appHighlight')
  highlightColor: any;
  @Input()
  textColor: any;
  @HostListener('mouseenter')
  onMouseEnter(){
    this.highlight(this.highlightColor || 'red');
    this.color(this.textColor || 'blue');
  }
  @HostListener('mouseleave')
  onMouseLeave(){
    this.highlight(null);
    this.color(null);
  }
  private highlight(color: any){
    this.el.nativeElement.style.backgroundColor = color;
  }
  private color(color: any){
    this.el.nativeElement.style.color = color;
  }
}
