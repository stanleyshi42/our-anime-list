import { Component, OnInit } from '@angular/core';
import { JikanService } from '../jikan.service';
import { ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrl: './search.component.css'
})
export class SearchComponent implements OnInit{
  search:string|null =''
  anime:any
  constructor(private service: JikanService, private router: ActivatedRoute){}
  ngOnInit():void{
    this.router.paramMap.subscribe(params=>{
      this.search = params.get('anime')
    })
    this.searchAnime();
  }

  searchAnime() {
    console.log(this.search)
    this.anime = [];
    if(this.search!=null){
      this.service.searchAnime(this.search).subscribe((data) => {
      console.log(data);
      this.anime = data;

      });
    }
    
  }
}
