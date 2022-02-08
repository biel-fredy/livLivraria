import axios, { AxiosRequestConfig } from 'axios';
import ActionButtonsAdmin from 'core/components/ActionButtonsAdmin';
import { Cliente } from 'core/types/cliente';
import { useState, useEffect, useCallback } from 'react';

import { Link } from 'react-router-dom';
import ClienteFilter, { ClienteFilterData } from '../ClienteFilter';

import './styles.scss';

type ControlComponentsData = {
  filterData: ClienteFilterData;
};

const ListCliente = () => {
  const [filtro, setFiltro] = useState<Boolean>(false);

  const [clientes, setClientes] = useState<Cliente[]>();
  const [controlComponentsData, setControlComponentsData] =
    useState<ControlComponentsData>({
      filterData: {
        id: 0,
        nome: '',
        status: 1,
        genero: '',
        dataNascimento: '',
        cpf: '',
        email: '',
      },
    });

  const getClientes = useCallback(() => {
    const params: AxiosRequestConfig = {
      method: filtro ? 'POST' : 'GET',
      url: filtro ? '/clientes/buscarClientes' : '/clientes',
      data: filtro ? controlComponentsData.filterData : undefined,
    };

    axios(params).then((response) => {
      console.log('teste');
      console.log(filtro);
      setClientes(response.data);
    });
  }, [controlComponentsData.filterData, filtro]);

  const handleSubmitFilter = (data: ClienteFilterData) => {
    setControlComponentsData({ filterData: data });
    setFiltro(true);
  };

  useEffect(() => {
    getClientes();
  }, [getClientes]);

  return (
    <>
      <ClienteFilter onSubmitFilter={handleSubmitFilter} />
      <div className="product-crud-container">
        <div className="container table-container border-radius-20">
          <div className="button-add-item">
            <Link to={`/admin/clientes/novo`}>
              <button className="btn btn-primary">Adicionar Cliente</button>
            </Link>
          </div>
          <table className="table">
            <thead>
              <tr>
                <th>Código Cliente</th>
                <th>Nome Cliente</th>
                <th>Status</th>
                <th colSpan={4}>Ações</th>
              </tr>
            </thead>
            <tbody>
              {clientes?.map((cliente) => (
                <tr>
                  <td>{cliente.id}</td>
                  <td>{cliente.nome}</td>
                  {cliente.status ? <td>Ativo</td> : <td>Inativo</td>}
                  <td colSpan={4}>
                    <ActionButtonsAdmin clienteId={cliente.id} />
                  </td>
                  <td>
                    <button
                    //onClick={() => handleAlteraStatus(cliente.id)}
                    >
                      Teste
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    </>
  );
};

export default ListCliente;
