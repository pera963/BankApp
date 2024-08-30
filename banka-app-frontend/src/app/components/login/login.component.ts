import { Component, OnInit } from '@angular/core';
import { ClientService } from '../../services/Client/client.service';
import { HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';




@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit{
  mail: string="";
  password: string="";
  constructor(private clientService: ClientService, private router: Router){}
  ngOnInit(): void {
  }

  prijava(){
    if(this.mail=="" || this.password==""){
     alert("potrebno je dea unesete podatke za mail i password");
     return; 
    }
    this.clientService.login(this.mail,this.password).subscribe((res: any)=>{
     console.log(res);
     alert ("uspešno");
     this.router.navigate(['/home']);
    }, (err: HttpErrorResponse)=>{
      alert("došlo je do greške prilikom logovanja: "+this.mail+" "+this.password);
    })
      
  }

}
