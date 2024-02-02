import { Component, OnInit } from '@angular/core';
import { TableModule } from 'primeng/table';


@Component({
  standalone: true,
  selector: 'app-visualizzaDipendenti',
  templateUrl: './visualizzaDipendenti.component.html',
  styleUrls: ['./visualizzaDipendenti.component.css'],
  imports: [
    TableModule
  ]
})
export class VisualizzaDipendentiComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
