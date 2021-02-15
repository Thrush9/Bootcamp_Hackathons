import { Component, OnInit } from '@angular/core';
import { FormGroup,FormControl,Validators } from '@angular/forms';
import { CourserouteService } from '../courseroute.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginform : FormGroup;
  username = new  FormControl('');
  password = new FormControl('');
  error : string='';
  token : string='';
  constructor(private routerService : CourserouteService ) {
   this.loginform = new FormGroup({
      username : new FormControl('',Validators.required),
      password : new FormControl('',Validators.required)
   });
   }

  ngOnInit(): void {
  }

  getDashboard(){
    if(this.loginform.valid){
      let map = this.loginform.value;
      if (map["username"].toString()=='admin' && map["password"].toString()=='password'){
         sessionStorage.setItem("Username","admin")
      } else {
         this.error = "Invalid Login Credentials"
         sessionStorage.setItem("Username","Invalid")
      }
      this.routerService.openDashboard();
    } else{
      this.error = "Invalid Login Credentials"
    }
  }

}
