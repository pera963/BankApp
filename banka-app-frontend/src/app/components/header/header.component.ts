import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent implements OnInit{
  constructor(private router: Router){}

  ngOnInit(): void {
    
  }

  logout(){
    localStorage.clear();
    this.router.navigate(['/login']);

  }

}
