import {Component, Input, OnInit, ViewEncapsulation} from '@angular/core';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {Bet} from '../../shared/types/response';

@Component({
  selector: 'app-waiting',
  templateUrl: './waiting.component.html',
    encapsulation: ViewEncapsulation.None,
  styleUrls: ['./waiting.component.css']
})


export class WaitingComponent implements OnInit {

  @Input() userChoice: Bet;

  constructor(private modalService: NgbModal) { }

  ngOnInit() {
  }

  openVerticallyCentered(content) {
    this.modalService.open(content, { centered: true, size: 'lg' });
  }

  dismiss(){
    this.modalService.dismissAll();
  }

}
