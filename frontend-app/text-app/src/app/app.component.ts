import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {ListIteam} from "./shared/drag-drop-list/drag-drop-list.component";
import {ApiServiceService, TransformerRequest} from "./shared/api-service.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'TextTransformer IO Project 2018';
  textForm: FormGroup;
  transformationList: ListIteam[];

  constructor(private apiService: ApiServiceService) {
  }

  ngOnInit() {
    this.initForm();
  }

  onSubmit() {
    const text = this.textForm.get('text').value;
    const transformation = this.transformationList.map(el => el.text).join(',');
    const request = AppComponent.toNewRequest(text, transformation);
    this.apiService.getTransformedText(request).subscribe(resp => {
      // logowanie odpowiedzi w konsoli
      console.log(resp);
    });
  }

  readTransformationList(list: ListIteam[]) {
    this.transformationList = list;
  }

  private initForm() {
    this.textForm = new FormGroup({
      text: new FormControl()
    });
  }

  private static toNewRequest(text: string, transformation: string): TransformerRequest {
    return {
      text: text,
      transforms: transformation.split(',')
    }
  }

}
