import {Component, Input, OnInit} from '@angular/core';
import {GameStatistics} from '../../shared/types/response';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-statistics',
  templateUrl: './statistics.component.html',
  styleUrls: ['./statistics.component.css']
})
export class StatisticsComponent implements OnInit {

  page = 1;
  pageSize = 4;
  @Input() games: GameStatistics[];
  constructor(private modalService: NgbModal) { }

  ngOnInit() {
  }

  openVerticallyCentered(content) {
    this.modalService.open(content, { centered: true, size: 'lg'});
  }

  get pgGames(): GameStatistics[] {
    return this.games
      .map((game, i) => ({id: i + 1, ...game}))
      .slice((this.page - 1) * this.pageSize, (this.page - 1) * this.pageSize + this.pageSize);
  }

  dismiss(){
    this.modalService.dismissAll();
  }

}
