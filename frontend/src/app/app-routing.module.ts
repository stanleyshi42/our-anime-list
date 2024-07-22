import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AnimeComponent } from './anime/anime.component';
import { UserComponent } from './user/user.component';
import { ListComponent } from './list/list.component';
import { SearchComponent } from './search/search.component';

const routes: Routes = [
  { path: 'user/:id', component: UserComponent },
  { path: 'user/:id/list', component: ListComponent },
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
