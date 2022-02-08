import { Telefone } from '../telefone';
import { Endereco } from '../endereco';
import { Documento } from '../documento';
import { Pedido } from '../pedido';
import { Cartao } from '../cartao';

export type ClienteDTO = {
  id: number;
  nome: string;
  status: number;
  genero?: string;
  dataNascimento?: string;
  cpf?: string;
  email?: string;
  dataCadastro: string;
  ranking: number;
  telefones: Telefone[];
  enderecos: Endereco[];
  documentos: Documento[];
  pedidos: Pedido[];
  cartoes: Cartao[];
  enderecoEntrega: string;
};
