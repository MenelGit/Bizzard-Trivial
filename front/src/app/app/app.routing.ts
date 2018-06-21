import { MainComponent } from './../main/main.component';
import { MenuComponent } from './../menu/menu.component';
import { Routes, RouterModule } from '@angular/router';
import { NewQuestionComponent } from '../newquestion/newquestion.component';
import { RankingComponent } from '../ranking/ranking.component';
import { SocialComponent } from '../social/social.component';
import { WaitingTurnComponent } from '../waitingturn/waitingturn.component';
import { QuestionComponent } from '../question/question.component';
import { LoginComponent } from '../login/login.component';
import { SignupComponent } from '../signup/signup.component';

const appRoutes: Routes = [
	{ path: '', redirectTo: 'menu', pathMatch: 'full' },
	{ path: 'main', component: MainComponent },
	{ path: 'menu', component: MenuComponent },
	{ path: 'newquestion', component: NewQuestionComponent },
	{ path: 'ranking', component: RankingComponent },
	{ path: 'social', component: SocialComponent },
	{ path: 'waitingturn', component: WaitingTurnComponent},
	{ path: 'question', component: QuestionComponent},
	{ path: 'login', component: LoginComponent},
	{ path: 'signup', component: SignupComponent}
];

export const routing = RouterModule.forRoot(appRoutes, { useHash: true });