import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { JikanService } from '../jikan.service';
import { AnimeStatService } from '../anime-stat.service';

@Component({
  selector: 'app-anime-details',
  templateUrl: './anime-details.component.html',
  styleUrl: './anime-details.component.css',
})
export class AnimeDetailsComponent {
  id!: any;
  animeDetails!: any;
  animeStats!: any;

  constructor(
    private route: ActivatedRoute,
    private jikanService: JikanService,
    private animeStatService: AnimeStatService
  ) {}

  ngOnInit() {
    this.id = String(this.route.snapshot.paramMap.get('id')); // Get MAL ID from URL route

    this.jikanService.getAnimeById(this.id).subscribe((data) => {
      this.animeDetails = data;
    });

    this.animeStatService.getAnimeStatsById(this.id).subscribe((data) => {
      console.log(data);
      this.animeStats = data;
    });
  }
}
