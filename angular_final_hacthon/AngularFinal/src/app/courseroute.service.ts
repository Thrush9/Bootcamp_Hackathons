import { Injectable } from '@angular/core';
import { Router } from '@angular/router'

@Injectable({
  providedIn: 'root'
})
export class CourserouteService {

  constructor(private routerObj : Router) { }

  openLogin(){
    this.routerObj.navigate(['login']);
  }

  openDashboard(){
    this.routerObj.navigate(['dashboard']);
  }

  openListView(){
    this.routerObj.navigate(['dashboard/listview']);
  }

  openGridView(){
    this.routerObj.navigate(['dashboard/gridview']);
  }
}
