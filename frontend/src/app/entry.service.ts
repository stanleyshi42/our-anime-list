import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Entry } from './entry.model';

@Injectable({
  providedIn: 'root',
})
export class EntryService {
  private uri = 'http://localhost:8080/';

  constructor(private http: HttpClient) {}

  // Returns a request header with authorization using JWT
  jwtHeader(): HttpHeaders {
    let jwt = localStorage.getItem('jwt');
    let headers = new HttpHeaders();
    return headers.set('Authorization', 'Bearer ' + jwt);
  }

  addEntry(entry: Entry): Observable<any> {
    return this.http.post<any>(this.uri + 'entry', entry);
  }

  getListByUserId(id: number): Observable<any> {
    return this.http.get<any>(this.uri + 'users/' + id + '/list');
  }

  getFavoritesByUserId(id: number): Observable<any> {
    return this.http.get<any>(this.uri + 'users/' + id + '/favorites');
  }

  updateEntry(entry: Entry): Observable<any> {
    return this.http.put<any>(this.uri + 'entry', entry, { headers: this.jwtHeader() });
  }

  deleteEntryById(id: number): Observable<any> {
    return this.http.delete<any>(this.uri + 'entry/' + id, { headers: this.jwtHeader() });
  }
}
