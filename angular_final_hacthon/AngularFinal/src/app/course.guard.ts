import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { CourserouteService } from './courseroute.service';

@Injectable({
  providedIn: 'root'
})
export class CourseGuard implements CanActivate {
  
  constructor(private routerService : CourserouteService){

  }
  
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    let flag = sessionStorage.getItem("Username");
    if(flag == 'admin'){
      return true;
    } else {
      this.routerService.openLogin();
      return false;
    }
  }
  
}
