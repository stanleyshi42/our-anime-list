import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class JikanService {
  private uri = 'https://api.jikan.moe/v4/';

  constructor(private http: HttpClient) {}

  getAnimeById(id: string): Observable<any> {
    return this.http.get<any>(this.uri + 'anime/' + id);
  }

  searchAnime(anime: string): Observable<any> {
    return this.http.get<any>(this.uri + 'anime?q=' + anime);
  }
}
