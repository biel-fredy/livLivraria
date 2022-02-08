import { TipoTelefone } from './enums/tipotelefone';

export type Telefone = {
  tipoTelefone: TipoTelefone;
  ddd: string;
  numero: string;
};
