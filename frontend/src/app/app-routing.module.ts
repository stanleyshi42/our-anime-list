import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ListComponent } from './list/list.component';
import { SearchComponent } from './search/search.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { EntryEditFormComponent } from './entry-edit-form/entry-edit-form.component';
import { UserDetailsComponent } from './user-details/user-details.component';
import { AnimeDetailsComponent } from './anime-details/anime-details.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'users/:id', component: UserDetailsComponent },
  { path: 'users/:id/list', component: ListComponent },
  { path: 'edit', component: EntryEditFormComponent },
  { path: 'anime/:id', component: AnimeDetailsComponent },
  { path: 'anime/:id', component: AnimeComponent },
  { path: 'search/:anime', component:SearchComponent},
  { path: '', component: HomeComponent },
  { path: '**', redirectTo: '' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
