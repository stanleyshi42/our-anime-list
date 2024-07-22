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
    // Use JWT for authorization
    let jwt = localStorage.getItem('jwt');
    let headers = new HttpHeaders();
    headers = headers.set('Authorization', 'Bearer ' + jwt);

    return this.http.put<any>(this.uri + 'entry', entry, { headers: headers });
  }

  deleteEntryById(id: number): Observable<any> {
    return this.http.delete<any>(this.uri + 'entry/' + id);
  }
}
