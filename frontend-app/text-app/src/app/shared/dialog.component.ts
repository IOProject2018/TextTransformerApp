import { Component } from '@angular/core';
import {MAT_DIALOG_DATA} from '@angular/material';
import { Inject } from '@angular/core';
@Component({
  template: `
    <p>Tekst:</p>
    <p><b>{{orginalString}}</b></p>
    <p>Transformowany:</p>
    <p><b>{{transformedString}}</b></p>
    <p>Zmiany:</p>
    <pre diff [left]="orginalString" [right]="transformedString"></pre>
  ` 
})

export class DialogComponent {
  orginalString: String;
  transformedString: String;

constructor(  @Inject(MAT_DIALOG_DATA) public data: any){
  this.orginalString=data.orginalString;
  this.transformedString=data.transformedString;
  console.log(this)
}
}
