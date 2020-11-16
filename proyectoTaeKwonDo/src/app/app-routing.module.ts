import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TipoEventoComponent} from './components/tipo-evento/tipo-evento.component';
const routes: Routes = [
  {path: 'tipo_evento', component: TipoEventoComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
