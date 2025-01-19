import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ClientService } from '../../services/client.service';
import { Client } from '../../models/Client';

@Component({
  selector: 'app-client-edit',
  templateUrl: './client-edit.component.html',
   styleUrls: ['./client-edit.component.scss']
})
export class ClientEditComponent implements OnInit {
  client: Client = new Client();
  loading = false;
  errorMessage: string = '';

  constructor(
    private clientService: ClientService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    const id = this.route.snapshot.params['id'];
    this.loading = true;

    // Fetch the client data
    this.clientService.getClient(id).subscribe({
      next: (data) => {
        this.client = data;
        this.loading = false;
      },
      error: (error) => {
        this.errorMessage = 'Error fetching client data';
        console.error(error);
        this.loading = false;
      }
    });
  }

  updateClient(): void {
    if (!this.client.nom || !this.client.prenom || !this.client.tel || !this.client.email || !this.client.password) {
      this.errorMessage = 'All fields are required!';
      return;
    }

    this.loading = true;

    // Update client
    const id = this.route.snapshot.params['id'];
    this.clientService.updateClient(id, this.client).subscribe({
      next: () => {
        this.loading = false;
        this.router.navigate(['/clients']);
      },
      error: (error) => {
        this.errorMessage = 'Error updating client';
        console.error(error);
        this.loading = false;
      }
    });
  }
}
