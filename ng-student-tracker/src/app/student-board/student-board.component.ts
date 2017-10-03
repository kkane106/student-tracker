import { Contact } from './../model/contact';
import { Address } from './../model/address';
import { User } from './../model/user';
import { Student } from './../model/student';
import { Component, OnInit } from '@angular/core';


const testStudents: Student[] = [
  new Student(1, 'Kris', 'Kane', true),
  new Student(2, 'Cole', 'Frock', true),
  new Student(3, 'Andrew', 'Conlin', true),
  new Student(1, 'Kris', 'Kane', true),
  new Student(2, 'Cole', 'Frock', true),
  new Student(3, 'Andrew', 'Conlin', true),
  new Student(1, 'Kris', 'Kane', true),
  new Student(2, 'Cole', 'Frock', true),
  new Student(3, 'Andrew', 'Conlin', true),
  new Student(1, 'Kris', 'Kane', true),
  new Student(2, 'Cole', 'Frock', true),
  new Student(3, 'Andrew', 'Conlin', true),
  new Student(1, 'Kris', 'Kane', true),
  new Student(2, 'Cole', 'Frock', true),
  new Student(3, 'Andrew', 'Conlin', true),
  new Student(1, 'Kris', 'Kane', true),
  new Student(2, 'Cole', 'Frock', true),
  new Student(3, 'Andrew', 'Conlin', true),
  new Student(1, 'Kris', 'Kane', true),
  new Student(2, 'Cole', 'Frock', true),
  new Student(3, 'Andrew', 'Conlin', true),
  new Student(1, 'Kris', 'Kane', true),
  new Student(2, 'Cole', 'Frock', true),
  new Student(3, 'Andrew', 'Conlin', true),
  new Student(1, 'Kris', 'Kane', true),
  new Student(2, 'Cole', 'Frock', true),
  new Student(3, 'Andrew', 'Conlin', true),
  new Student(1, 'Kris', 'Kane', true),
  new Student(2, 'Cole', 'Frock', true),
  new Student(3, 'Andrew', 'Conlin', true),
  new Student(1, 'Kris', 'Kane', true),
  new Student(2, 'Cole', 'Frock', true),
  new Student(3, 'Andrew', 'Conlin', true),
  new Student(1, 'Kris', 'Kane', true),
  new Student(2, 'Cole', 'Frock', true),
  new Student(3, 'Andrew', 'Conlin', true),
  new Student(1, 'Kris', 'Kane', true),
  new Student(2, 'Cole', 'Frock', true),
  new Student(3, 'Andrew', 'Conlin', true),
  new Student(1, 'Kris', 'Kane', true),
  new Student(2, 'Cole', 'Frock', true),
  new Student(3, 'Andrew', 'Conlin', true),

];

@Component({
  selector: 'app-student-board',
  templateUrl: './student-board.component.html',
  styleUrls: ['./student-board.component.css']
})
export class StudentBoardComponent implements OnInit {

  private students: Student[];

  constructor() {
    this.students = testStudents;
  }

  ngOnInit() {
  }

}
