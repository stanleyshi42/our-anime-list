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

  ngOnInit() {
    // Check if already logged in
    if (localStorage.getItem('jwt')) {
      this.router.navigateByUrl('');
    }
  }

  // Authenticate login info and store a JWT
  login() {
    if (this.username == '' || this.password == '') {
      this.invalidLogin = true;
      return;
    }

    this.service.login(this.username, this.password).subscribe(
      (data) => {
        localStorage.setItem('jwt', data);
        this.router.navigateByUrl(''); // Redirect to home
        location.reload();
      },
      (error) => {
        console.log(error);
        this.invalidLogin = true;
      }
    );
  }
}
