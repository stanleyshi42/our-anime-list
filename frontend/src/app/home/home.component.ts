import { Component } from '@angular/core';
import { JikanService } from '../jikan.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css',
})
export class HomeComponent {
  animeIds: any[] = [5114, 16498, 21, 10087, 11061]; // Anime to display; iniitalized with default IDs
  data: any[] = [];
  constructor(private jikanService: JikanService, private router: Router) {}

  ngOnInit() {
    for (const id of this.animeIds) {
      this.jikanService.getAnimeById(id).subscribe((data) => {
        this.data.push(data);
      });
    }
  }

  searchAnime(anime: string) {
    this.animeIds = [];
    this.jikanService.searchAnime(anime).subscribe((data) => {
      console.log(data);
      this.animeIds.push(data);
    });
    console.log(anime.length)
  }
}
