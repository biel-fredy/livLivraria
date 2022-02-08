import { Cartao } from './cartao';
import { Documento } from './documento';
import { Endereco } from './endereco';
import { Pedido } from './pedido';
import { Telefone } from './telefone';

export type Cliente = {
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
