import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';

import {
  provideHttpClient,
  withInterceptorsFromDi,
} from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { ListComponent } from './list/list.component';
import { SearchComponent } from './search/search.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { EntryEditFormComponent } from './entry-edit-form/entry-edit-form.component';
import { AnimeDetailsComponent } from './anime-details/anime-details.component';
import { UserDetailsComponent } from './user-details/user-details.component'; 

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ListComponent,
    SearchComponent,
    LoginComponent,
    RegisterComponent,
    EntryEditFormComponent,
    AnimeDetailsComponent,
    UserDetailsComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, FormsModule],
  providers: [provideHttpClient(withInterceptorsFromDi())],
  bootstrap: [AppComponent],
})
export class AppModule {}
