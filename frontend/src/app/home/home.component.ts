import { Component } from '@angular/core';
import { JikanService } from '../jikan.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css',
})
export class HomeComponent {
  defaultAnime: any[] = ['5114', '16498', '21'];
  anime: any[] = [];
  search: String = '';

  constructor(private service: JikanService, private router: Router) {}

  ngOnInit() {
    for (const id of this.defaultAnime) {
      this.service.getAnimeById(id).subscribe((data) => {
        console.log(data);
        this.anime.push(data);
      });
    }
  }
}
