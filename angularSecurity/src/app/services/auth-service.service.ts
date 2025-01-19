import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {
  private baseUrl = 'http://localhost:8080/serviceSecurity/auth'; // Base URL for your backend API
  private jwtToken: string | null = null; // Store JWT token

  constructor(private http: HttpClient) {}

  register(user: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/register`, user).pipe(
      catchError((error) => {
        // Handle registration error
        const registrationError = error.error?.message || 'An error occurred during registration. Please try again.';
        return throwError(() => new Error(registrationError));
      })
    );
  }

  login(user: any): Observable<any> {
    // Specify responseType as 'text' to avoid JSON parsing errors
    return this.http.post(`${this.baseUrl}/login`, user, { responseType: 'text' as 'json' }).pipe(
      catchError((error) => {
        // Handle login error
        console.error('Login error:', error);
        return throwError(() => new Error(error.error?.message || 'Login failed'));
      })
    );
  }

  setToken(token: string): void {
    this.jwtToken = token; // Store the JWT token
    localStorage.setItem('token', token); // Optionally store it in local storage
  }

  getToken(): string | null {
    return this.jwtToken || localStorage.getItem('token'); // Retrieve the token
  }

  logout(): void {
    this.jwtToken = null; // Clear the stored token
    localStorage.removeItem('token'); // Remove it from local storage
    console.log('User logged out successfully!');
  }

  isLoggedIn(): boolean {
    const token = this.getToken();
    // Check if the token exists and is not expired (you can implement additional checks here)
    return !!token;
  }

}
