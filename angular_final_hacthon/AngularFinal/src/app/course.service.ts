import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Course } from './course';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  courseul : string = 'http://localhost:3000/courses';

  constructor(private httpclient : HttpClient) { }

  getAllCourses() : Observable<Course[]> {
    return this.httpclient.get<Course[]>(this.courseul);
  }

}
