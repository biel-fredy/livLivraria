import axios, { AxiosRequestConfig } from 'axios';
import ActionButtonsAdmin from 'core/components/ActionButtonsAdmin';
import { Bandeira } from 'core/types/bandeira';
import { useCallback, useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import './styles.scss';

const ListBandeira = () => {
  const [bandeiras, setBandeiras] = useState<Bandeira[]>();

  const getBandeiras = useCallback(() => {
    const params: AxiosRequestConfig = {
      method: 'GET',
      url: '/bandeiras',
    };

    axios(params).then((response) => {
      console.log('teste');
      setBandeiras(response.data);
    });
  }, []);

  useEffect(() => {
    getBandeiras();
  }, [getBandeiras]);

  return (
    <>
      <div className="product-crud-container">
        <div className="container table-container border-radius-20">
          <div className="button-add-item">
            <Link to={`/admin/bandeiras/novo`}>
              <button className="btn btn-primary">Adicionar Bandeira</button>
            </Link>
          </div>
          <table className="table">
            <thead>
              <tr>
                <th>Código Bandeira</th>
                <th>Nome Bandeira</th>
                <th>Ícone Bandeira</th>
                <th colSpan={4}>Ações</th>
              </tr>
            </thead>
            <tbody>
              {bandeiras?.map((bandeira) => (
                <tr>
                  <td>{bandeira.id}</td>
                  <td>{bandeira.nomeBandeira}</td>
                  <td colSpan={4}>
                    <ActionButtonsAdmin clienteId={bandeira.id} />
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

export default ListBandeira;
