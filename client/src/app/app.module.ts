import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {MainComponent} from './pages/main/main.component';
import { IconCardComponent } from './shared/components/icon-card/icon-card.component';
import {ApiService} from './shared/api/service/api.service';
import {HttpClientModule} from '@angular/common/http';
import {MapService} from './shared/api/util/mapper';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {WaitingComponent} from './pages/waiting/waiting.component';
import { ResultComponent } from './pages/result/result.component';
import {AngularFontAwesomeModule} from 'angular-font-awesome';
import { StatisticsComponent } from './pages/statistics/statistics.component';

@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    IconCardComponent,
    WaitingComponent,
    ResultComponent,
    StatisticsComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    NgbModule,
    AngularFontAwesomeModule
  ],
  entryComponents: [WaitingComponent, MainComponent, ResultComponent, StatisticsComponent],
  providers: [ApiService, MapService, WaitingComponent, ResultComponent, StatisticsComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }
