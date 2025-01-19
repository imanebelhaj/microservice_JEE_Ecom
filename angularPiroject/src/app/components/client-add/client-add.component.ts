import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Client } from '../../models/Client';
import { ClientService } from '../../services/client.service';

@Component({
  selector: 'app-client-add',
  templateUrl: './client-add.component.html',
  // Uncomment and specify your stylesheet if needed
   styleUrls: ['./client-add.component.scss']
})
export class ClientAddComponent {
  client: Client = new Client(); // Initialize a new client object

  constructor(private clientService: ClientService, private router: Router) {}

  // Method to add a new client
  addClient(): void {
    if (!this.client.nom || !this.client.prenom || !this.client.email || !this.client.password) {
      alert('Please fill in all required fields.');
      return;
    }

    this.clientService.createClient(this.client).subscribe(
      () => {
        alert('Client successfully added!');
        this.router.navigate(['/clients']); // Navigate back to the client list
      },
      (error) => {
        alert('Error adding client: ' + error.message);
        console.error(error);
      }
    );
  }
}
