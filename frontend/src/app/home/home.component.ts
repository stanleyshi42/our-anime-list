import { Component } from '@angular/core';
import { JikanService } from '../jikan.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css',
})
export class HomeComponent {
  anime: any[] = ['5114', '16498', '21'];  // Anime to display; iniitalized with default IDs
  data:any[] = []
  constructor(private service: JikanService, private router: Router) {}

  ngOnInit() {
    for (const id of this.anime) {
      this.service.getAnimeById(id).subscribe((data) => {
        console.log(data);
        this.data.push(data);
      });
    }
  }

  searchAnime(anime: string) {
    this.anime = [];
    this.service.searchAnime(anime).subscribe((data) => {
      console.log(data);
      this.anime.push(data);
    });
  }
}
