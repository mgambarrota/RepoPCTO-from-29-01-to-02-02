import { Routes } from '@angular/router';

export const routes: Routes = [
    {
        path: '', loadComponent: () => 
        import("./components/welcomePage/welcomePage.component")
        .then(c => c.WelcomePageComponent)
    },
    {
        path: 'visualizza',
        loadComponent: () => import("./components/visualizzaDipendenti/visualizzaDipendenti.component")
        .then(c => c.VisualizzaDipendentiComponent)
    },
    {
        path: 'assumi',
        loadComponent: () => import("./components/assumiDipendenti/assumiDipendenti.component")
        .then(c => c.AssumiDipendentiComponent)
    }
];
