import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
})
export class LoginComponent {
  username = '';
  password = '';
  invalidLogin = false;

  constructor(private router: Router, private service: UserService) {}

  ngOnInit() {}

  // Authenticate login info and store a JWT
  login() {
    this.service.login(this.username, this.password).subscribe(
      (data) => {
        console.log(data);
        localStorage.setItem('jwt', data);
        this.router.navigateByUrl(''); // Redirect to home
      },
      (error) => {
        console.log(error);
        this.invalidLogin = true;
      }
    );
  }
}
