import {Injectable} from '@angular/core';

@Injectable()
export class MapService {

  constructor() {
  }

  mapResponse(response: any) {
    return {
      result: response.result,
      description: response.description,
      winnerBet: {
        picture: response.winnerBet.picture,
        name: response.winnerBet.name
      }
    };
  }

  simpleResponse(response: any) {
    return response;
  }
}
