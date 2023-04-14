import {Component, OnInit} from '@angular/core';
import * as Chart from 'chart.js';

@Component({
  selector: 'app-chart-js',
  templateUrl: './chart-js.component.html',
  styleUrls: ['./chart-js.component.css']
})
export class ChartJsComponent implements OnInit {
  formccc: any;
  createForm: any;

  constructor() {
  }

  ngOnInit(): void {
    this.renderChart();
  }

  renderChart() {
    const myChart = new Chart('myChart', {
      type: 'bar',
      data: {
        labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'June'],
        datasets: [
          {
            label: 'PHP Activities',
            data: [80, 30, 63, 20, 110, 3],
            backgroundColor: 'rgba(0, 128, 128, 0.3)',
            borderColor: 'rgba(0, 128, 128, 0.7)',
            borderWidth: 1
          },
          {
            label: 'Ruby Activities',
            data: [18, 72, 10, 39, 19, 75],
            backgroundColor: 'rgba(0, 128, 128, 0.7)',
            borderColor: 'rgba(0, 128, 128, 1)',
            borderWidth: 1
          }
        ]
      },
      options: {
        scales: {
          yAxes: [{
            ticks: {
              beginAtZero: true
            }
          }]
        },
      }
    });
  }
}
