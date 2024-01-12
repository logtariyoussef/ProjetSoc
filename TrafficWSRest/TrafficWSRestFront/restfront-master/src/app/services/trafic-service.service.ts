import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Traffic } from '../Entity/Traffic';

@Injectable({
  providedIn: 'root'
})
export class TraficServiceService {
  private baseurl="http://localhost:8082/traffic";

  constructor(private http : HttpClient) { }

  //get all service
  getAllTraffic():Observable<any>{
    return this.http.get(`${this.baseurl}/getAll`);
  }

  //create traffic
  createTraffic(traffic:Traffic):Observable<any>{
     return this.http.post(`${this.baseurl}/create`,traffic);
  }
  //get traffic by gouv 
  getTrafficByGouv(gouv : string):Observable<any>{
    return this.http.get(`${this.baseurl}/getByGouv/{gouv}`);
  }

}
