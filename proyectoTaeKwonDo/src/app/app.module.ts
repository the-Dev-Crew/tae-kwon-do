import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AlumnoComponent } from './components/alumno/alumno.component';
import { TipoEventoComponent } from './components/tipo-evento/tipo-evento.component';
import { EventoComponent } from './components/evento/evento.component';
import { ExamenComponent } from './components/examen/examen.component';
import { IndexComponent } from './components/index/index.component';

import { ReactiveFormsModule } from '@angular/forms';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { UsuarioComponent } from './components/usuario/usuario.component';




@NgModule({
  declarations: [
    AppComponent,
    AlumnoComponent,
    TipoEventoComponent,
    EventoComponent,
    ExamenComponent,
    IndexComponent,
    UsuarioComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
