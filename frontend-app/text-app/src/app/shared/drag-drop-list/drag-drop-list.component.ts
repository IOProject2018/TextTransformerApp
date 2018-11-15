import {Component, EventEmitter, Output} from '@angular/core';
import {CdkDragDrop, moveItemInArray, transferArrayItem} from '@angular/cdk/drag-drop';

@Component({
  selector: 'app-drag-drop-list',
  templateUrl: './drag-drop-list.component.html',
  styleUrls: ['./drag-drop-list.component.css']
})
export class DragDropListComponent {

  @Output() transformationList = new EventEmitter<String[]>();

  used = [
  ];

  notUsed = [
    'upper',
    'lower',
    'capitalize',
    'delete',
    'inverse',
    'duplicate',
    'latex',
    'verbal',
    'no-shortcut'
  ];

  drop(event: CdkDragDrop<string[]>) {
    if (event.previousContainer === event.container) {
      moveItemInArray(event.container.data, event.previousIndex, event.currentIndex);
    } else {
      transferArrayItem(event.previousContainer.data,
        event.container.data,
        event.previousIndex,
        event.currentIndex);
    }
    this.transformationList.emit(this.used);
  }

  onSave() {
    // note: dodajemy nasze sklejone transformacje do notUsed
      this.notUsed.push(this.used.join(','));
  }
}
