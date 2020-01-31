export class CurbResponse {
  result: string;
  description: string;
  winnerBet: Bet;
}

export class Bet {
  picture: string;
  name: string;
}

export class GameStatistics {
  id: number;
  userChoice: string;
  curbChoice: string;
  winner: string;
}
