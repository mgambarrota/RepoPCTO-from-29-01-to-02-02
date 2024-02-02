import { Component, OnInit } from '@angular/core';
import { CardModule } from 'primeng/card';
import { ButtonModule } from 'primeng/button';
import { Router } from '@angular/router';


@Component({
  selector: 'app-welcomePage',
  templateUrl: './welcomePage.component.html',
  styleUrls: ['./welcomePage.component.css'],
  standalone: true,
  imports: [
    CardModule,
    ButtonModule
  ]
})
export class WelcomePageComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }

  navigateTo(azione: string){
    if(azione == "visualizza") this.router.navigate(['/visualizza']);
    else this.router.navigate(['/assumi']);
  }

}
