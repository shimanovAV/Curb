import {Component, Input, OnInit} from '@angular/core';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {CurbResponse} from '../../shared/types/response';

@Component({
  selector: 'app-result',
  templateUrl: './result.component.html',
  styleUrls: ['./result.component.css']
})
export class ResultComponent implements OnInit {

  @Input() curbResponse: CurbResponse;

  constructor(private modalService: NgbModal) { }

  ngOnInit() {

  }

  openVerticallyCentered(content) {
    this.modalService.open(content, { centered: true});
  }

  dismiss(){
    this.modalService.dismissAll();
  }

}
