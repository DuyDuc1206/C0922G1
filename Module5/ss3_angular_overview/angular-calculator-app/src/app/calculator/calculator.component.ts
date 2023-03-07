import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {
  result = undefined;

  constructor() {
  }

  ngOnInit(): void {
  }

  sum(firstNumber: string, secondNumber: string) {
    this.result = parseInt(firstNumber) + parseInt(secondNumber);
  }

  subtraction(firstNumber: string, secondNumber: string) {
    this.result = parseInt(firstNumber) - parseInt(secondNumber);
  }

  multiplication(firstNumber: string, secondNumber: string) {
    this.result = parseInt(firstNumber) * parseInt(secondNumber);
  }

  division(firstNumber: string, secondNumber: string) {
    if (secondNumber==='0'){
      this.result = "no division for 0";
    }else
    this.result = parseInt(firstNumber) / parseInt(secondNumber);
  }
}
