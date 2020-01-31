import {Component, Input, OnInit} from '@angular/core';
import {Bet} from '../../types/response';

@Component({
  selector: 'app-icon-card',
  templateUrl: './icon-card.component.html',
  styleUrls: ['./icon-card.component.css']
})
export class IconCardComponent implements OnInit {

  @Input() loaderIcon: boolean;
  @Input() isResult = false;
  @Input() bet: Bet;

  constructor() { }

  ngOnInit() {
  }

}
