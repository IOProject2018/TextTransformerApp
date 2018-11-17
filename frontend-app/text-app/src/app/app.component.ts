import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {ListIteam} from "./shared/drag-drop-list/drag-drop-list.component";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'TextTransformer IO Project 2018';
  textForm: FormGroup;
  transformationList: ListIteam[];



  ngOnInit() {
    this.initForm();
  }

  onSubmit() {

  }

  readTransformationList(list: ListIteam[]){
    this.transformationList = list;
  }

  private initForm() {
    this.textForm = new FormGroup({
      text: new FormControl(),
      transformation: new FormControl()
    });
  }

}
