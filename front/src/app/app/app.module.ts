import { routing } from './app.routing';
import { MenuComponent } from './../menu/menu.component';
import { AppComponent } from './../app.component';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { MainComponent } from '../main/main.component';
import { NewQuestionComponent } from '../question/newquestion.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AuthGuard } from './guards/auth.guard';
import { AuthService } from '../services/auth.service';
import { HttpModule } from '@angular/http';

@NgModule({
  declarations: [
    AppComponent, MenuComponent, MainComponent, NewQuestionComponent
  ],
  imports: [
    BrowserModule, routing, FormsModule, ReactiveFormsModule, HttpModule
  ],
  providers: [AuthGuard, AuthService],
  bootstrap: [AppComponent]
})
export class AppModule { }
