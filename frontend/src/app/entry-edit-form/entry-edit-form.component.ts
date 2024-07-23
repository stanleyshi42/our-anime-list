import { Component, Input } from '@angular/core';
import { Entry } from '../entry.model';
import { EntryService } from '../entry.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-entry-edit-form',
  templateUrl: './entry-edit-form.component.html',
  styleUrl: './entry-edit-form.component.css',
})
export class EntryEditFormComponent {
  @Input() entry!: Entry;

  constructor(private router: Router, private entryService: EntryService) {}

  ngOnInit() {
    //if (this.entry == null) {this.router.navigateByUrl(''); // Redirect to home
  }

  updateEntry() {
    this.entryService.updateEntry(this.entry).subscribe();
  }
}
