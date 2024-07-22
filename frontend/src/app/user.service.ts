import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  private uri = 'http://localhost:8080/users';

  constructor(private http: HttpClient) {}

  // Authenticate login details and return a JWT
  login(username: string, password: string): Observable<any> {
    return this.http.post(
      this.uri + '/auth',
      { username, password },
      { responseType: 'text' } // Specify that the response body is a string, not JSON
    );
  }

  register(username: string, password: string) {
    return this.http.post(this.uri, { username, password });
  }

  getUserById(id: number): Observable<any> {
    return this.http.get<any>(this.uri + '/id/' + id);
  }
}
