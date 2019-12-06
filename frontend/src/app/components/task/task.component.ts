import { Component, OnInit } from '@angular/core';
import {Observable} from 'rxjs';
import { DataService } from '../../data.service';

@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.css']
})
export class TaskComponent implements OnInit {

  tasks$ : object;

  constructor(private data : DataService) {}

  ngOnInit() {
    this.tasks$ = [{
      id: 1,
      titre: "Revision de cours",
      description: "Je dois réviser le cours de java pour la seance prochaine..",
      dl:"29/09/2019"
    },
    {
      id: 2,
      titre: "Developper une application",
      description: "Je dois réviser le cours de java pour la seance prochaine..",
      dl:"02/02/2019"
    }

    
  
  
  ]
    
    // this.data.getTasks().subscribe(
    //   data => 
    //     this.tasks$ = data
    // )    
  }

}
