import { Component, OnInit } from '@angular/core';
import { AtmService } from '../../services/ATM/atm.service';
import { Atm } from '../../models/ATM/atm';

@Component({
  selector: 'app-atm',
  templateUrl: './atm.component.html',
  styleUrl: './atm.component.css'
})
export class ATMComponent implements OnInit{
  atms: Atm[]=[];
  constructor(private atmService: AtmService){}
  ngOnInit(): void {
   this.atmService.getAllATM().subscribe({
    next: (res: Atm[])=>{
      this.atms=res;
    }
   }) 
  }

}
