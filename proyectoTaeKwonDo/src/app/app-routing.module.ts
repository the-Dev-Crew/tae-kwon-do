import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AlumnoComponent } from './components/alumno/alumno.component';
import { TipoEventoComponent } from './components/tipo-evento/tipo-evento.component';
import { EventoComponent } from './components/evento/evento.component';
import { ExamenComponent } from './components/examen/examen.component';
import { UsuarioComponent } from './components/usuario/usuario.component';
import { IndexComponent } from './components/index/index.component';

const routes: Routes = [
  { path: '', component: IndexComponent},
  { path: 'alumno', component: AlumnoComponent},
  { path: 'tipo_evento', component: TipoEventoComponent},
  { path: 'evento', component: EventoComponent},
  { path: 'examen', component: ExamenComponent},
  { path: 'usuario', component: UsuarioComponent},

  { path: '**', redirectTo: ''}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
