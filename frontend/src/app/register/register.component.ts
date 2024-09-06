import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrl: './register.component.css',
})
export class RegisterComponent {
  username = '';
  password = '';
  invalidUsername = false;

  constructor(private router: Router, private service: UserService) {}

  ngOnInit() {
    // Check if already logged in
    if (localStorage.getItem('jwt')) {
      this.router.navigateByUrl('');
    }
  }

  register() {
    if (this.username == '' || this.password == '') return;

    // POST request for new user
    this.service.register(this.username, this.password).subscribe(
      (data) => {
        // After registering, log the user in
        this.service.login(this.username, this.password).subscribe(
          (jwt) => {
            localStorage.setItem('jwt', jwt);
            this.router.navigateByUrl(''); // Redirect to home
            location.reload();
          },
          (error) => {
            console.log(error);
          }
        );
      },
      (error) => {
        console.log(error);
        this.invalidUsername = true;
      }
    );
  }
}
