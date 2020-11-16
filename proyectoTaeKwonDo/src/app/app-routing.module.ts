import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TipoEventoComponent} from './components/tipo-evento/tipo-evento.component';
const routes: Routes = [
  {path: '', component: TipoEventoComponent},
  {path: 'tipo_evento', component: TipoEventoComponent},

  {path: '**', redirectTo: ''}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
