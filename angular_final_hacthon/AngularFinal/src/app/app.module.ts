import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HeaderComponent } from './header/header.component';
import { LoginComponent } from './login/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { CourseComponent } from './course/course.component';

import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule,FormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatToolbarModule } from '@angular/material/toolbar';
import { CourseGuard } from './course.guard';
import { RouterModule,Routes,Router } from '@angular/router';
import { ListviewComponent } from './listview/listview.component';
import { GridviewComponent } from './gridview/gridview.component';

const myRoutes : Routes = [{
  path : 'login',
  component : LoginComponent
},
{
  path : 'dashboard',
  component : DashboardComponent,
  canActivate:[ CourseGuard ],
  children : [
    {
      path : 'listview',
      component : ListviewComponent
    },
    {
      path : 'gridview',
      component : GridviewComponent
    }
  ]
},
{
  path : '',
  redirectTo : 'login',
  pathMatch : 'full'
}]


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LoginComponent,
    DashboardComponent,
    CourseComponent,
    ListviewComponent,
    GridviewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
    MatFormFieldModule,
    MatInputModule,
    MatCardModule,
    MatIconModule,
    MatButtonModule,
    MatExpansionModule,
    MatToolbarModule,
    RouterModule,
    RouterModule.forRoot(myRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
