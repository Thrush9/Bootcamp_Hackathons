import { Component, OnInit } from '@angular/core';
import { Course } from '../course';
import { CourseService } from '../course.service';

@Component({
  selector: 'app-listview',
  templateUrl: './listview.component.html',
  styleUrls: ['./listview.component.css']
})
export class ListviewComponent implements OnInit {

  courseObj: Course[] = [] ;

  constructor(private courseService : CourseService) { }

  ngOnInit(): void {
    this.getCourses();
  }

  getCourses(){
    this.courseService.getAllCourses().subscribe(
      (resp) => this.courseObj = resp )
  }

}
