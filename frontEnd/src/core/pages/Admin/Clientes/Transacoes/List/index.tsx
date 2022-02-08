import axios, { AxiosRequestConfig } from 'axios';
import ActionButtonsAdmin from 'core/components/ActionButtonsAdmin';
import { Endereco } from 'core/types/endereco';
import { BASE_URL } from 'core/utils/requests';
import { useState, useEffect } from 'react';
import { Button, Table } from 'react-bootstrap';

type Props = {
  clienteId: string;
};

const List = ({ clienteId }: Props) => {
  const [enderecos, setEnderecos] = useState<Endereco[]>();

  useEffect(() => {
    const params: AxiosRequestConfig = {
      method: 'GET',
      url: `${BASE_URL}/clientes/${clienteId}/enderecos`,
    };

    axios(params).then((response) => {
      setEnderecos(response.data);
    });
  }, [clienteId]);

  return (
    <div className="container table-container border-radius-20">
      <div className="button-add-item">
        <Button href="/clientes/adicionar">Adicionar Cliente</Button>
      </div>
      <Table className="bg-white">
        <thead>
          <tr>
            <th>Código Cliente</th>
            <th>Nome Cliente</th>
            <th>Status</th>
            <th colSpan={4}>Ações</th>
          </tr>
        </thead>
        <tbody>
          {enderecos?.map((endereco) => (
            <tr>
              <td>{endereco.cep}</td>
              <td>{endereco.logradouro}</td>
              <td>{endereco.tipoEndereco}</td>
              <td colSpan={4}></td>
            </tr>
          ))}
        </tbody>
      </Table>
    </div>
  );
};

export default List;
