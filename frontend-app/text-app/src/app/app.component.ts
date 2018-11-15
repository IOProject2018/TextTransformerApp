import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, ReactiveFormsModule} from "@angular/forms";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'TextTransformer IO Project 2018';
  textForm: FormGroup;



  ngOnInit() {
    this.initForm();
  }

  onSubmit() {

  }

  private initForm() {
    this.textForm = new FormGroup({
      text: new FormControl(),
      transformation: new FormControl()
    });
  }

}
