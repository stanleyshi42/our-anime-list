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

  constructor(private router: Router) {}
}
