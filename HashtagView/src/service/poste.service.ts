import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import "rxjs/add/operator/map"

@Injectable()
export class PosteService{
  constructor(public http:Http){
  }

  getPostes(motCle:string,page:number,size:number ){
    return this.http.get("http://localhost:8080/twitter?hashtag=%23"+motCle)
      .map(resp => resp.json());
  }

  getPostesByTag(motCle:string){
    return this.http.get("http://localhost:8080/findTag?tag=%23"+motCle)
      .map(resp => resp.json());
  }

  getPoste(id:string){
    return this.http.get("http://localhost:8080/postes/"+id)
      .map(resp => resp.json());
  }

}
