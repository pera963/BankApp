import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Atm } from '../../models/ATM/atm';

@Injectable({
  providedIn: 'root'
})
export class AtmService {

  readonly apiUrl="http://localhost:8080/api/atm";
  constructor(private http: HttpClient) { }

  getAllATM(): Observable<Atm[]>{          //Observable- znači da upravlja asinhronim podacima i događajima,čeka na upućeni zahtev iz bekenda da vrati niz ATM-ova
    return this.http.get<Atm[]>(this.apiUrl);
  }
}
