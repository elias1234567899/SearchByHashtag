import { Component, OnInit } from '@angular/core';
import {Poste} from '../../model/model.poste';
import {ActivatedRoute, Router} from '@angular/router';
import {PosteService} from '../../service/poste.service';

@Component({
  selector: 'app-poste-details',
  templateUrl: './poste-details.component.html',
  styleUrls: ['./poste-details.component.css']
})
export class PosteDetailsComponent implements OnInit {
  mode:number=1;
  poste:Poste= new Poste;
  idPoste:string;

  constructor(public activatedRoute:ActivatedRoute,public posteSerivce:PosteService,public router:Router) {
    this.idPoste=activatedRoute.snapshot.params['id'];
  }

  ngOnInit() {
    this.posteSerivce.getPoste(this.idPoste)
      .subscribe(data =>{
        this.poste=data;
      },err=>{
        console.log(err);
      })
  }

}
