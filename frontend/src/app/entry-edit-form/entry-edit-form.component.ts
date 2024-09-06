import { Component } from '@angular/core';
import { Location } from '@angular/common';
import { Entry } from '../entry.model';
import { EntryService } from '../entry.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-entry-edit-form',
  templateUrl: './entry-edit-form.component.html',
  styleUrl: './entry-edit-form.component.css',
})
export class EntryEditFormComponent {
  entry!: Entry;

  constructor(
    private router: Router,
    private location: Location,
    private entryService: EntryService
  ) {}

  ngOnInit() {
    // Get entry to be edited
    const currentState = this.router.lastSuccessfulNavigation;
    this.entry = currentState?.extras.state!['data'];
    if (this.entry == null) this.router.navigateByUrl(''); // Redirect if no entry
  }

  cancel() {
    this.location.back();
  }

  updateEntry() {
    this.entryService.updateEntry(this.entry).subscribe(() => {
      // After request, go back to user's list
      this.location.back();
    });
  }
}
