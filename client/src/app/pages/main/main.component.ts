import {Component, OnInit} from '@angular/core';
import {ApiService} from '../../shared/api/service/api.service';
import {MapService} from '../../shared/api/util/mapper';
import {WaitingComponent} from '../waiting/waiting.component';
import {ResultComponent} from '../result/result.component';
import {BehaviorSubject} from 'rxjs';
import {Bet, CurbResponse, GameStatistics} from '../../shared/types/response';
import {StatisticsComponent} from '../statistics/statistics.component';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

  allBets$: BehaviorSubject<Bet[]> = new BehaviorSubject(null);

  curbResponse$: BehaviorSubject<CurbResponse> = new BehaviorSubject(null);

  statResponse$: BehaviorSubject<GameStatistics[]> = new BehaviorSubject(null);

  userChoice: Bet;

  constructor(private apiService: ApiService,
              private mapService: MapService,
              private waitingComponent:WaitingComponent,
              private resultComponent:ResultComponent,
              private statisticsComponent: StatisticsComponent) {
    this.apiService.get(`bet`, this.mapService.simpleResponse).subscribe((data) => {
      this.allBets$.next(data.valueOf().data);
    },(error) => {
      console.error(error);
    });
  }

  ngOnInit() {
  }

  onSelectBet(content: any, loader:any, bet:Bet): void {
    this.userChoice = bet;
    this.waitingComponent.openVerticallyCentered(loader);
    this.apiService.get(`bet/${bet.name}`, this.mapService.mapResponse).subscribe((data) => {
     this.waitingComponent.dismiss();
     this.curbResponse$.next(data);
     this.resultComponent.openVerticallyCentered(content);
    }, (error) => {
      console.error(error);
    });
  }

  onStatistics(content: any):void{
    this.apiService.get(`statistics`, this.mapService.simpleResponse).subscribe((data) => {
      this.statResponse$.next(data.valueOf().data);
      this.statisticsComponent.openVerticallyCentered(content);
    },(error) => {
      console.error(error);
    });
  }

}

