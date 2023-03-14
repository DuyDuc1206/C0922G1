import {Component, OnInit} from '@angular/core';
import {ITodo} from '../../model/itodo';
import {TodoService} from '../../service/todo.service';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {
  todoList: ITodo[] = [];

  constructor(private todoService: TodoService) {
  }

  ngOnInit(): void {
    this.getAllTodo();
  }

  getAllTodo() {
    this.todoService.getAllTodo().subscribe(items => {
      this.todoList = items;
    });
  }

}
