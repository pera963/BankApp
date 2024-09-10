import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Client } from '../../models/Client/client';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  readonly apiUrl="http://localhost:8080/api/client";
  constructor(private http: HttpClient) { }

  login(mail: string,password: string){
    const params=new HttpParams().set("mail",mail).set("password",password);
    return this.http.get(this.apiUrl+"/login",{params});
  }

  registration(client:Client){
    return this.http.post(this.apiUrl + "/registration",client);
  }
}
