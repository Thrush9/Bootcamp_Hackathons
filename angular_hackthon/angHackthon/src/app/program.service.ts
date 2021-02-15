import { Injectable } from '@angular/core';
import { Program } from './program';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ProgramService {

  pgmArray : Program[] = [];

  url : string = 'http://localhost:3000/programs';
  
  constructor(private httpclient : HttpClient) { }

  registerProgram(program : Program) : Observable<Program>
  {
   return  this.httpclient.post<Program>(this.url,program);
  }

  getPrograms() : Observable<Program[]>
  {
    return this.httpclient.get<Program[]>(this.url);
  }

}
