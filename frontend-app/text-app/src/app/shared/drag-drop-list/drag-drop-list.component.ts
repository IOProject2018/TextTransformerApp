import {Component, EventEmitter, Output} from '@angular/core';
import {CdkDragDrop, moveItemInArray, transferArrayItem} from '@angular/cdk/drag-drop';

export class ListIteam {
  key: string;
  text: string;
}

@Component({
  selector: 'app-drag-drop-list',
  templateUrl: './drag-drop-list.component.html',
  styleUrls: ['./drag-drop-list.component.css']
})
export class DragDropListComponent {

  @Output() transformationList = new EventEmitter<ListIteam[]>();

  used: ListIteam[] = [];

  notUsed: ListIteam[] = [
    {
      key: 'upper',
      text: 'Na duże litery'
    },
    {
      key: 'lower',
      text: 'Na małe litery'
    },
    {
      key: 'capitalize',
      text: 'Pierwsze litery wielkie'
    },
    {
      key: 'delete',
      text: 'Usun PL znaki'
    },
    {
      key: 'inverse',
      text: 'Obróc tekst'
    },
    {
      key: 'duplicate',
      text: 'Usuń powtorzenia'
    },
    {
      key: 'latex',
      text: 'Formatuj do formatu latex'
    },
    {
      key: 'verbal',
      text: 'Zmien liczby na slowa'
    },
    {
      key: 'no-shortcut',
      text: 'Usun skroty'
    },
    {
      key: 'translate',
      text: 'Przetlumacz'
    }
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
    const newKey = this.used.map(el => el.key).join(',');
    const newText = this.used.map(el => el.text).join(',');
    this.notUsed.push({key: newKey, text: newText})
  }
}
