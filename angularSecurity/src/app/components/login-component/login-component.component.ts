import { Component } from '@angular/core';
import { AuthServiceService } from '../../services/auth-service.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-login-component',
  templateUrl: './login-component.component.html',
  styleUrl: './login-component.component.css'
})
export class LoginComponentComponent {
  user = { username: '', password: '' };
  loginError: string | null = null; // Declare loginError property

  constructor(private authService: AuthServiceService, private router: Router) {}

  login() {
    this.authService.login(this.user).subscribe(
      token => {
        localStorage.setItem('token', token); // Store JWT token
        this.loginError = null; // Clear any previous error
        this.router.navigate(['/']); // Redirect to home or another page
        this.loginError = 'ok';
        alert('User Logged in successfully!');
        this.router.navigate(['/hello']);
      },
      error => {
        this.loginError = error.error || 'Invalid credentials'; // Set error message
      }
    );
  }
}
