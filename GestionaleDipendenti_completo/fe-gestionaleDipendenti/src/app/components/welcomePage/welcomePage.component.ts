import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ButtonModule } from 'primeng/button';
import { CardModule } from 'primeng/card';

@Component({
  selector: 'app-welcomePage',
  templateUrl: './welcomePage.component.html',
  styleUrls: ['./welcomePage.component.css'],
  standalone: true,
  imports: [
    ButtonModule,
    CardModule
  ]
})
export class WelcomePageComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }

  navigateTo(route: string): void {
    if (route === 'visualizza') {
      this.router.navigate(['/viewAll']);
    } else if (route === 'assumi') {
      this.router.navigate(['/addDip']);
    }
  }

}
