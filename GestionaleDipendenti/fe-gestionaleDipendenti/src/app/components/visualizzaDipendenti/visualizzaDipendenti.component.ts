import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ButtonModule } from 'primeng/button';
import { TableModule } from 'primeng/table';


@Component({
  standalone: true,
  selector: 'app-visualizzaDipendenti',
  templateUrl: './visualizzaDipendenti.component.html',
  styleUrls: ['./visualizzaDipendenti.component.css'],
  imports: [
    TableModule, ButtonModule
  ]
})
export class VisualizzaDipendentiComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }

  navigateTo(azione: string){
    if(azione == "assumi") this.router.navigate(['/assumi']);
    else this.router.navigate(['/']);
  }

}
