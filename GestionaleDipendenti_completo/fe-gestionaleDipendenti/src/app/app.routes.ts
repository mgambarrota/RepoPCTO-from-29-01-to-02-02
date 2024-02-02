import { Routes } from '@angular/router';

export const routes: Routes = [
    {
        path: 'viewAll',
        loadComponent: () => import('./components/viewDipendenti/viewDipendenti.component').then(p => p.ViewDipendentiComponent)
    },
    {
        path: 'addDip',
        loadComponent: () => import('./components/addDipendente/addDipendente.component').then(p => p.AddDipendenteComponent)
    },
    {
        path: '',
        loadComponent: () => import('./components/welcomePage/welcomePage.component').then(p => p.WelcomePageComponent)
    }
];
