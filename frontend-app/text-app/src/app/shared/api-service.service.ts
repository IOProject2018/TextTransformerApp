import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs/internal/Observable";
import {map} from "rxjs/operators";

export class TransformerRequest {
  text: string;
  transforms: string;
}

@Injectable({
  providedIn: 'root'
})
export class ApiServiceService {
  endpoint = 'http://localhost:9000/';
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Methods': 'GET, POST, PATCH, PUT, DELETE, OPTIONS',
      'Access-Control-Allow-Headers': 'Origin, Content-Type, X-Auth-Token'
    })
  };

  constructor(private http: HttpClient) {
  }

  getTransformedText(req: TransformerRequest): Observable<any> {
    return this.http.get(this.endpoint + req.text + '?transforms=' + req.transforms).pipe(map(this.extractData));
  }

  private extractData(res: Response) {
    let body = res;
    return body || { };
  }
}
