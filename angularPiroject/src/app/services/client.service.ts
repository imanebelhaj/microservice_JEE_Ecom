import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Client } from '../models/Client';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  private baseUrl = 'http://localhost:8080/clientService/api/clients';

  // Create HTTP headers if necessary (e.g., for authorization)
  // private httpOptions = {
  //   headers: new HttpHeaders({
  //     'Content-Type': 'application/json',
  //     // Add any other headers if necessary, e.g., Authorization: 'Bearer token'
  //   })
  // };
  constructor(private http: HttpClient) { }

  getClients(): Observable<any> {
    return this.http.get(this.baseUrl);
  }

  // Fetch a single client by ID
  getClient(id: number): Observable<Client> {
    return this.http.get<Client>(`${this.baseUrl}/${id}`);
  }

  // Create a new client
  createClient(client: Client): Observable<Client> {
    return this.http.post<Client>(this.baseUrl, client);
  }

  // Update a client
  updateClient(id: number, client: Client): Observable<any> {
    return this.http.put<Client>(`${this.baseUrl}/${id}`, client);
  }

  // Delete a client
  deleteClient(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }
}
