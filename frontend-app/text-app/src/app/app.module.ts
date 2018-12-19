import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {CommonModule} from "@angular/common";

import {DragDropModule} from '@angular/cdk/drag-drop';
import {DragDropListComponent} from './shared/drag-drop-list/drag-drop-list.component';
import {HttpClientModule} from "@angular/common/http";
import { MatDialogModule } from '@angular/material';
import { DialogComponent } from './shared/dialog.component';
import {NoopAnimationsModule} from '@angular/platform-browser/animations';
import { DiffMatchPatchModule } from 'ng-diff-match-patch';
@NgModule({
  declarations: [
    AppComponent,
    DragDropListComponent,
    DialogComponent

  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    DragDropModule,
    MatDialogModule,
    NoopAnimationsModule,
    DiffMatchPatchModule
  ],
  exports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  entryComponents: [DialogComponent]
})
export class AppModule {
}
