import { Component, inject, Input } from '@angular/core';
import { EntryService } from '../entry.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Entry } from '../entry.model';
import { UserService } from '../user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrl: './user.component.css'
})
export class UserComponent {
  private route = inject(ActivatedRoute);
  id!: number;
  username!: any;
  jwt = localStorage.getItem('jwt');
  authorized: boolean = false; // Check if logged in user matches this list's user

  constructor(
      private router: Router,
      private entryService: EntryService,
      private userService: UserService
    ) {}

   ngOnInit() {
       this.id = Number(this.route.snapshot.paramMap.get('id')); // Get user ID from URL route
       this.username = this.getUserById(this.id);
     }

   parseJwt(token: any) {
       return JSON.parse(atob(token.split('.')[1]));
     }

  getUserById(id: number) {
      this.userService.getUserById(id).subscribe((data) => {
        this.username = data.username;

        // Check if logged in user matches this list's user
        const parsedJwt = this.parseJwt(this.jwt);
        if (parsedJwt.sub == this.username) this.authorized = true;
      });
    }




}
