import { Component, OnInit } from '@angular/core';
import {Title} from '@angular/platform-browser';
declare var particlesJS: any;

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {

  constructor(private title: Title) { }

  ngOnInit(): void {
    this.title.setTitle('D Academy-Contact')
    // tslint:disable-next-line:only-arrow-functions
    particlesJS.load('particles-js', 'assets/particles.json', function() {
      console.log('callback - particles.js config loaded');
    });
  }

}
