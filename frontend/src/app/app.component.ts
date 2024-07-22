import { Component } from '@angular/core';
import { JikanService } from './jikan.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {
  title = 'our-anime-list';

  constructor(private service: JikanService, private router: Router) {}
  anime:any = []
  search:string = ''
  
  searchAnime() {
    console.log(this.search)
    this.anime = [];
    this.service.searchAnime(this.search).subscribe((data) => {
      console.log(data);
      this.anime = data;

    });
  }
}
