import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {TodoService} from '../../service/todo.service';
import {ActivatedRoute, Router} from '@angular/router';
import {ITodo} from '../../model/itodo';

@Component({
  selector: 'app-todo-edit',
  templateUrl: './todo-edit.component.html',
  styleUrls: ['./todo-edit.component.css']
})
export class TodoEditComponent implements OnInit {
  editForm: FormGroup;
  id: number;

  constructor(private todoService: TodoService,
              private router: Router,
              private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(paraMap => {
      this.id = +paraMap.get('id');
      this.getTodo(this.id);
    });
  }

  getTodo(id: number) {
    return this.todoService.findById(id).subscribe(todo => {
      this.editForm = new FormGroup({
        title: new FormControl(todo.title),
        completed: new FormControl(todo.completed)
      });
    });
  }

  onSubmit() {
    const todo = this.editForm.value;
    this.todoService.editTodo(this.id, todo).subscribe(next => {
      this.router.navigateByUrl('/todo');
    });
  }
}
