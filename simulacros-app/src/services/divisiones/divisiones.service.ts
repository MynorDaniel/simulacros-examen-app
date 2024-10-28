import { Injectable } from '@angular/core';
import { RestConstants } from '../rest-constants';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Division } from '../../entities/Division';

@Injectable({
  providedIn: 'root'
})
export class DivisionesService {
  restConstants: RestConstants;
  constructor(private httpClient: HttpClient) { 
    this.restConstants = new RestConstants();
  }

  getDivisiones(): Observable<Division[]> {
    return this.httpClient.get<Division[]>(this.restConstants.getApiURL() + "division");
  }
}
