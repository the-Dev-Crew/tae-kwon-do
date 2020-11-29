import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AlumnoComponent } from './components/alumno/alumno.component';
import { TipoEventoComponent } from './components/tipo-evento/tipo-evento.component';
import { EventoComponent } from './components/evento/evento.component'

const routes: Routes = [
  { path: '', component: AlumnoComponent},
  { path: 'alumno', component: AlumnoComponent},
  { path: 'tipo_evento', component: TipoEventoComponent},
  { path: 'evento', component: EventoComponent},

  { path: '**', redirectTo: ''}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
