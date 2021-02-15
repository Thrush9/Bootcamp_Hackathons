import { Component, OnInit } from '@angular/core';
import { Program } from '../program';
import { ProgramService } from '../program.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  pgmObj : Program ;
  pgmList : Program[] =[];
  constructor(private pgmService :ProgramService) { 
    this.pgmObj = new Program();
    this.getpgmList();
  }

  ngOnInit(): void {
  }

  addProgram(){
    this.pgmService.registerProgram(this.pgmObj).subscribe(
      (resp) => console.log(" Registered Program : " + resp.name)
    )
    this.pgmObj = new Program();
    this.getpgmList();
  }

  getpgmList()
  {
    this.pgmService.getPrograms().subscribe(
      (res)=>
      {
        console.log(res);
        this.pgmList=res;
      }
    )
  }



}
