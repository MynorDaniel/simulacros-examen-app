import { Routes } from '@angular/router';
import { CursosComponent } from './cursos/cursos.component';
import { ReglasComponent } from './reglas/reglas.component';
import { ExamenComponent } from './examen/examen.component';
import { MainComponent } from './main/main.component';

export const routes: Routes = [
    {   path: 'cursos',
        title: 'Cursos',
        component: CursosComponent
    },
    {   path: 'main',
        title: 'Home',
        component: MainComponent
    },
    {   path: 'reglas',
        title: 'Reglas',
        component: ReglasComponent
    },
    {   path: '',
        redirectTo: 'main',
        pathMatch: 'full'  
    },
    {   path: 'examen/:curso/:tipo',
        component: ExamenComponent
    },
    {   path: '**', redirectTo: 'main'},
];
