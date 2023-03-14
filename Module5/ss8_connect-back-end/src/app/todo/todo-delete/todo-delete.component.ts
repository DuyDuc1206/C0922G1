import {Component, OnInit} from '@angular/core';
import {TodoService} from '../../service/todo.service';
import {ActivatedRoute, Router} from '@angular/router';
import {FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-todo-delete',
  templateUrl: './todo-delete.component.html',
  styleUrls: ['./todo-delete.component.css']
})
export class TodoDeleteComponent implements OnInit {
  id: number;
  deleteForm: FormGroup;

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
      this.deleteForm = new FormGroup({
        title: new FormControl(todo.title),
        completed: new FormControl(todo.completed)
      });
    });

  }

  onSubmit() {
    this.todoService.deleteTodo(this.id).subscribe(todo => {
      this.router.navigateByUrl('todo');
    });
  }
}
