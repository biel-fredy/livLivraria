import { Bandeira } from './bandeira';

export type Cartao = {
  id: number;
  numero: string;
  nomeImpresso: string;
  codigoSeguranca: string;
  bandeira: Bandeira;
};
