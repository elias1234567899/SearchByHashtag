import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { PostesComponent } from './postes/postes.component';
import {RouterModule, Routes} from '@angular/router';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {PosteService} from '../service/poste.service';
import { PosteDetailsComponent } from './poste-details/poste-details.component';

const appRoutes: Routes = [
  {path: 'postes' , component: PostesComponent},
  {path: 'postesDetails/:id' , component: PosteDetailsComponent},
  {path: '', redirectTo: '/postes', pathMatch: 'full'}
];

@NgModule({
  declarations: [
    AppComponent,
    PostesComponent,
    PosteDetailsComponent
  ],
  imports: [
    BrowserModule,RouterModule.forRoot(appRoutes), HttpModule, FormsModule
  ],
  providers: [PosteService],
  bootstrap: [AppComponent]
})
export class AppModule { }
