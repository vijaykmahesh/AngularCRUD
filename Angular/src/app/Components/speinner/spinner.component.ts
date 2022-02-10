import { Component, OnInit,Input } from '@angular/core';

@Component({
  selector: 'app-spinner',
  templateUrl: './spinner.component.html',
  styleUrls: ['./spinner.component.css']
})
export class SpeinnerComponent implements OnInit {

  @Input() data:string;

  constructor() { }

  ngOnInit(): void {
  }

}
