import axios, { AxiosRequestConfig } from 'axios';
import ActionButtonsAdmin from 'core/components/ActionButtonsAdmin';
import { Cartao } from 'core/types/cartao';
import { BASE_URL } from 'core/utils/requests';
import { useState, useEffect } from 'react';
import { Button, Table } from 'react-bootstrap';

type Props = {
  clienteId: string;
};

const List = ({ clienteId }: Props) => {
  const [cartoes, setCartoes] = useState<Cartao[]>();

  useEffect(() => {
    const params: AxiosRequestConfig = {
      method: 'GET',
      url: `${BASE_URL}/clientes/${clienteId}/cartoes`,
    };

    axios(params).then((response) => {
      setCartoes(response.data);
    });
  }, [clienteId]);

  return (
    <div className="container table-container border-radius-20">
      <div className="button-add-item">
        <Button href="/admin/cartoes/create">Adicionar Cartão</Button>
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
          {cartoes?.map((cartao) => (
            <tr>
              <td>{cartao.id}</td>
              <td colSpan={4}></td>
            </tr>
          ))}
        </tbody>
      </Table>
    </div>
  );
};

export default List;
