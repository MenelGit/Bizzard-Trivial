import { routing } from './app.routing';
import { MenuComponent } from './../menu/menu.component';
import { AppComponent } from './../app.component';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { MainComponent } from '../main/main.component';
import { NewQuestionComponent } from '../newquestion/newquestion.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RankingComponent } from '../ranking/ranking.component';
import { SocialComponent } from '../social/social.component';
import { WaitingTurnComponent } from '../waitingturn/waitingturn.component'
import { QuestionComponent } from '../question/question.component';

@NgModule({
  declarations: [
    AppComponent, MenuComponent, MainComponent, NewQuestionComponent, RankingComponent, SocialComponent, WaitingTurnComponent, QuestionComponent
  ],
  imports: [
    BrowserModule, routing, FormsModule, ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
