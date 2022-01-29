import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  isReadMore: boolean = true;
  panelOpenState: boolean = false;


  constructor() { }

  togglePanel() {
    this.panelOpenState = !this.panelOpenState
}

  ngOnInit(): void {
  }


  showText(){
    this.isReadMore = !this.isReadMore
  }
  

}
