import { Component } from '@angular/core';
import { UserService } from '../user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
})
export class LoginComponent {
  constructor(private service: UserService) {
    this.login('user1', 'pass');
  }

  login(username: string, password: string) {
    this.service
      .login(username, password)
      .subscribe((data) => console.log(data));
  }

  getUserById(id: number) {
    this.service.getUserById(id).subscribe((data) => console.log(data));
  }
}
