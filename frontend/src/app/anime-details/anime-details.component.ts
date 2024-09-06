import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { JikanService } from '../jikan.service';
import { AnimeStatService } from '../anime-stat.service';
import { EntryService } from '../entry.service';
import { Entry } from '../entry.model';
import { UserService } from '../user.service';

@Component({
  selector: 'app-anime-details',
  templateUrl: './anime-details.component.html',
  styleUrl: './anime-details.component.css',
})
export class AnimeDetailsComponent {
  malId!: any;
  animeDetails!: any;
  animeStats!: any;
  user!: any;

  constructor(
    private route: ActivatedRoute,
    private jikanService: JikanService,
    private animeStatService: AnimeStatService,
    private userService: UserService,
    private entryService: EntryService
  ) {}

  ngOnInit() {
    this.malId = String(this.route.snapshot.paramMap.get('id')); // Get MAL ID from URL route

    this.jikanService.getAnimeById(this.malId).subscribe((data) => {
      this.animeDetails = data;
    });

    this.animeStatService.getAnimeStatsById(this.malId).subscribe((data) => {
      this.animeStats = data;
    });

    let parsedJwt = this.parseJwt(localStorage.getItem('jwt'));
    if (parsedJwt) {
      this.userService.getUserByUsername(parsedJwt.sub).subscribe((data) => {
        this.user = data;
      });
    }
  }

  // Returns JSON of a JWT's contents
  parseJwt(token: any) {
    if (token == null) return token;
    return JSON.parse(atob(token.split('.')[1]));
  }

  addEntry() {
    let entry = new Entry(
      this.user.id,
      this.malId,
      this.animeDetails.data.title,
      this.animeDetails.data.episodes,
      this.animeDetails.data.duration.replace(/[^0-9]/g, ''), // Remove all non-digits from this string
      this.animeDetails.data.images.jpg.image_url
    );
    this.entryService.addEntry(entry).subscribe((data) => {
      console.log(entry);
      console.log(data);
    });
  }
}
