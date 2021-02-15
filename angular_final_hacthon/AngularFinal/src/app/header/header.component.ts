import { Component, OnInit } from '@angular/core';
import { CourserouteService } from '../courseroute.service';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private routeService : CourserouteService) { }

  ngOnInit(): void {
  }

  getHomePage(){
    sessionStorage.clear();
   this.routeService.openLogin();
  }

}
