import { Component, OnInit } from '@angular/core';
import {Http} from '@angular/http';
import {Router} from '@angular/router';
import {PosteService} from '../../service/poste.service';
import {Poste} from '../../model/model.poste';
import {Subscription} from 'rxjs/Subscription';

@Component({
  selector: 'app-postes',
  templateUrl: './postes.component.html',
  styleUrls: ['./postes.component.css']
})
export class PostesComponent implements OnInit {


  pagePostes:Poste[];
  motCle: string = '';
  currentPage: number = 0;
  size: number = 10;
  pages: Array<number>;
  dataLength:number=0;
  res:number=0;
  constructor(public http: Http, public posteservice: PosteService, public router:Router) {
  }

  ngOnInit() {

  }

  doSearch() {
    this.posteservice.getPostes(this.motCle,this.currentPage,this.size)
      .subscribe(data => {
        this.pagePostes = data;
      }, err => {
        console.log(err);
      });
  }


  search() {

    //this.post();
    this.doSearch();




  }
  post(){

    this.posteservice.getPostesByTag(this.motCle)
      .subscribe(data => {
        this.dataLength=data.length;
        console.log(this.dataLength);
      }, err => {
        console.log(err);
      });
  }
  gotoPage(i: number) {
    this.currentPage = i;
    this.doSearch();
  }

  detailsPoste(id:number){
    this.router.navigate(['postesDetails',id]);
  }


}
