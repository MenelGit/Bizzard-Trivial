import { MainComponent } from './../main/main.component';
import { MenuComponent } from './../menu/menu.component';
import { Routes, RouterModule } from '@angular/router';
import { NewQuestionComponent } from '../question/newquestion.component';
import { AuthGuard } from './guards/auth.guard';

const appRoutes: Routes = [
	{ path: '', redirectTo: 'menu', pathMatch: 'full' },
	{ path: 'main', component: MainComponent, canActivate: [AuthGuard] },
	{ path: 'menu', component: MenuComponent, canActivate: [AuthGuard] },
	{ path: 'question', component: NewQuestionComponent, canActivate: [AuthGuard]}
];

export const routing = RouterModule.forRoot(appRoutes, { useHash: true });