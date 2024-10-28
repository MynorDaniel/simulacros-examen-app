import { Routes } from '@angular/router';
import { CursosComponent } from './Cursos/cursos/cursos.component';
import { MainComponent } from './includes/main/main.component';
import { CursoViewComponent } from './Cursos/curso-view/curso-view.component';
import { DivisionViewComponent } from './División/division-view/division-view.component';
import { CarreraViewComponent } from './Carrera/carrera-view/carrera-view.component';
import { ExamenComponent } from './Exámenes/examen/examen.component';
import { NotFoundComponent } from './not-found/not-found.component';

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
    {   path: 'examen/:curso/:tipo',
        title: 'Examen',
        component: ExamenComponent
    },
    {   path: '404',
        title: 'No encontrado',
        component: NotFoundComponent  
    },
    {   path: '',
        redirectTo: 'main',
        pathMatch: 'full'  
    },
    {   path: '**', redirectTo: '404'},
];
