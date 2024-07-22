import { Component, inject, Input } from '@angular/core';
import { EntryService } from '../entry.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Entry } from '../entry.model';
import { UserService } from '../user.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrl: './list.component.css',
})
export class ListComponent {
  private route = inject(ActivatedRoute);
  id!: number;
  username!: any;
  jwt = localStorage.getItem('jwt');
  authorized: boolean = false; // Check if logged in user matches this list's user
  animeList: any[] = [];

  constructor(
    private router: Router,
    private entryService: EntryService,
    private userService: UserService
  ) {}

  ngOnInit() {
    this.id = Number(this.route.snapshot.paramMap.get('id')); // Get user ID from URL route
    this.username = this.getUserById(this.id);
    this.getListByUserId(this.id);
  }

  // Returns JSON of a JWT's contents
  parseJwt(token: any) {
    return JSON.parse(atob(token.split('.')[1]));
  }

  addEntry(entry: Entry) {
    this.entryService.addEntry(entry);
  }

  getListByUserId(id: number) {
    this.entryService.getListByUserId(id).subscribe((data) => {
      this.animeList = data;
    });
  }

  // Get this list's user
  getUserById(id: number) {
    this.userService.getUserById(id).subscribe((data) => {
      this.username = data.username;

      // Check if logged in user matches this list's user
      const parsedJwt = this.parseJwt(this.jwt);
      if (parsedJwt.sub == this.username) this.authorized = true;
    });
  }

  // Given an index in animeList[], increment that entry's episodes watched count
  incrementEpisodesWatched(index: number) {
    let entry = this.animeList[index];

    if (entry.episodesWatched >= entry.totalEpisodes) return;
    else entry.episodesWatched += 1;

    this.entryService.updateEntry(entry).subscribe();
  }

  deleteEntry(index: number) {
    let entry = this.animeList[index];
    this.entryService.deleteEntryById(entry.id).subscribe();
  }
}
