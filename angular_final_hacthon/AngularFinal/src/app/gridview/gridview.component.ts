import { Component, OnInit } from '@angular/core';
import { Course } from '../course';
import { CourseService } from '../course.service';


@Component({
  selector: 'app-gridview',
  templateUrl: './gridview.component.html',
  styleUrls: ['./gridview.component.css']
})
export class GridviewComponent implements OnInit {

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
