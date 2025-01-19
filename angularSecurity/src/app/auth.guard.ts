import { CanActivateFn } from '@angular/router';
import { CanActivate, Router } from '@angular/router';
import { AuthServiceService } from './services/auth-service.service';
import {Injectable} from '@angular/core';
// export const authGuard: CanActivateFn = (route, state) => {
//   return true;
// };

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(private authService: AuthServiceService, private router: Router) { }

  // This function determines whether the route can be activated
  canActivate(): boolean {
    if (this.authService.isLoggedIn()) {
      return true; // Allow access to the route if the user is authenticated
    } else {
      this.router.navigate(['/login']); // Redirect to login if not authenticated
      return false;
    }
  }
}
