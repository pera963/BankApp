import { Component, OnInit } from '@angular/core';
import { Client } from '../../models/Client/client';
import { ClientService } from '../../services/Client/client.service';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';


@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrl: './registration.component.css'
})
export class RegistrationComponent implements OnInit{
  client: Client = new Client();
  constructor(private clientService: ClientService,private toastr: ToastrService, private router:Router){}
  ngOnInit(): void {
    
  }

  registration(){
    console.log(this.client)
    this.clientService.registration(this.client).subscribe({
      next: (res: any)=>{
        this.toastr.success("Uspešna registracija na aplikaciju");
        setTimeout(() => {
        this.router.navigate(['/login']);
        }, 500);
      },
      error: (err: HttpErrorResponse)=>{
        this.toastr.error("Došlo je do greške prilikom registracije");
      }
    })
  }

}
