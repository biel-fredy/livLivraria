import { TipoEndereco } from './enums/tipoendereco';
import { TipoLogradouro } from './enums/tipologradouro';

export type Endereco = {
  apelido: string;
  tipoLogradouro: TipoLogradouro;
  logradouro: string;
  numero: string;
  cep: string;
  complemento: string;
  tipoEndereco: TipoEndereco;
  bairro: string;
  cidade: string;
  estado: string;
  pais: string;
  enderecoCobranca: boolean;
  enderecoEntrega: boolean;
  observacoes: string;
};
