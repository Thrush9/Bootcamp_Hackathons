import { Component, OnInit } from '@angular/core';
import { CourserouteService } from '../courseroute.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor(private routeService : CourserouteService) { }

  ngOnInit(): void {
    this.getGridView();
  }

  getListView(){
    this.routeService.openListView();
  }

  getGridView(){
    this.routeService.openGridView();
  }

}
