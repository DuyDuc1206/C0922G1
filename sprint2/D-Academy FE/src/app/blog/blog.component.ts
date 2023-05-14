import {Component, OnInit} from '@angular/core';
import {Title} from '@angular/platform-browser';

declare var particlesJS: any;

@Component({
  selector: 'app-blog',
  templateUrl: './blog.component.html',
  styleUrls: ['./blog.component.css']
})
export class BlogComponent implements OnInit {

  constructor(private tile: Title) {
  }

  ngOnInit(): void {
    this.tile.setTitle('D Academy-Blog');
    // tslint:disable-next-line:only-arrow-functions
    particlesJS.load('particles-js', 'assets/particles.json', function() {
      console.log('callback - particles.js config loaded');
    });
  }

}
