import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {TodoService} from '../../service/todo.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-todo-create',
  templateUrl: './todo-create.component.html',
  styleUrls: ['./todo-create.component.css']
})
export class TodoCreateComponent implements OnInit {
  createForm: FormGroup = new FormGroup({
    title: new FormControl(''),
    completed: new FormControl(''),
  });

  constructor(private todoService: TodoService,
              private router: Router) {
  }

  ngOnInit(): void {
  }

  onSubmit() {
    const todo = this.createForm.value;
    this.todoService.saveTodo(todo).subscribe(next => {
      this.router.navigateByUrl('/todo');
    });
  }
}
