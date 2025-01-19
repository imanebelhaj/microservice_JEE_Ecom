import { Component } from '@angular/core';
import { AuthServiceService } from '../../services/auth-service.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-register-component',
  templateUrl: './register-component.component.html',
  styleUrl: './register-component.component.css'
})
export class RegisterComponentComponent {
  user = { username: '', password: '' };
  registrationError: string | null = null;
  registrationSuccess: string | null = null;

  constructor(private authService: AuthServiceService, private router: Router) {}

  register() {
    if (!this.user.username || !this.user.password) {
      this.registrationError = 'All fields are required.';
      return; // Prevent submission if fields are empty
    }
    this.authService.register(this.user).subscribe(
      response => {
        this.registrationSuccess = response.message;
        console.log(this.registrationSuccess);
        this.registrationError = null;
        alert('User registered successfully!');
        this.router.navigate(['/login']);
      },
      error => {
        alert('Error registering: ' + error.message);
        console.error(error);
        //this.registrationError = error.error.message || 'Registration failed. Please try again.';


      }
    );
  }
}
