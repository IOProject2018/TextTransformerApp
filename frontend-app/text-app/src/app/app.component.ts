import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {ListIteam} from "./shared/drag-drop-list/drag-drop-list.component";
import {ApiServiceService, TransformerRequest} from "./shared/api-service.service";
import { MatDialogRef, MatDialog } from '@angular/material';
import { DialogComponent } from './shared/dialog.component';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['app.component.css']
})
export class AppComponent implements OnInit {
  title = 'TextTransformer IO Project 2018';
  textForm: FormGroup;
  transformationList: ListIteam[];
  orginalString: String;
  transformedString: String;

  fileNameDialogRef: MatDialogRef<DialogComponent>;

  constructor(private apiService: ApiServiceService,private dialog: MatDialog) {
  }

  ngOnInit() {
    this.initForm();
  }

  onSubmit() {
    const text = this.textForm.get('text').value;
    this.orginalString=text;
    const transformation = this.transformationList.map(el => el.key).join(',');
    const request = AppComponent.toNewRequest(text, transformation);
    this.apiService.getTransformedText(request).subscribe(resp => {
      this.transformedString=resp.transformed
      this.openAddFileDialog();
    });
  }
  openAddFileDialog() {
    this.fileNameDialogRef = this.dialog.open(DialogComponent, {
      data: {
        orginalString: this.orginalString,
        transformedString: this.transformedString
      }
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
      transforms: transformation
    }
  }

}
