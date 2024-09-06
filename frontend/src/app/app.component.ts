import { Component } from '@angular/core';
import { JikanService } from './jikan.service';
import { Router } from '@angular/router';
import { UserService } from './user.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {
  title = 'our-anime-list';
  jwt = localStorage.getItem('jwt');
  user!: any;
  anime: any = [];
  search: string = '';

  constructor(
    private router: Router,
    private jikanService: JikanService,
    private userService: UserService
  ) {}

  ngOnInit() {
    if (this.jwt) {
      let parsedJwt = this.parseJwt(this.jwt);

      // Check if JWT is expired
      if (Date.now() >= parsedJwt.exp * 1000) {
        console.log('jwt expired');
        // todo redirect to logout page
      }
      // Else, get user info
      else {
        this.userService.getUserByUsername(parsedJwt.sub).subscribe((user) => {
          this.user = user;
        });
      }
    }
  }

  // Returns JSON of a JWT's contents
  parseJwt(token: any) {
    if (token == null) return token;
    return JSON.parse(atob(token.split('.')[1]));
  }

  searchAnime() {
    this.anime = [];
    this.jikanService.searchAnime(this.search).subscribe((data) => {
      console.log(data);
      this.anime = data;
    });
  }

  searchResults() {
    this.router.navigate(['/search/' + this.search]);
    this.search = '';
  }

  logout() {
    localStorage.clear();
    this.jwt = null;
    this.user = null;
    this.ngOnInit();
    this.router.navigateByUrl(''); // Redirect to home
  }
}
