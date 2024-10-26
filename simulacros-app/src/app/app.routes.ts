import { Routes } from '@angular/router';
import { CursosComponent } from './cursos/cursos.component';
import { ReglasComponent } from './reglas/reglas.component';
import { ExamenComponent } from './examen/examen.component';
import { MainComponent } from './main/main.component';
import { CursoViewComponent } from './curso-view/curso-view.component';
import { DivisionViewComponent } from './division-view/division-view.component';
import { CarreraViewComponent } from './carrera-view/carrera-view.component';

export const routes: Routes = [
    {   path: 'cursos',
        title: 'Divisiones',
        component: DivisionViewComponent
    },
    {   path: 'cursos/:division',
        title: 'Carreras',
        component: CarreraViewComponent
    },
    {   path: 'cursos/:division/:carrera',
        title: 'Cursos',
        component: CursoViewComponent
    },
    {   path: 'cursos/:division/:carrera/:curso',
        title: 'Curso',
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
