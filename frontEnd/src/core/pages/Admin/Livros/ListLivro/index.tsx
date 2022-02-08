import axios, { AxiosRequestConfig } from 'axios';
import ActionButtonsAdmin from 'core/components/ActionButtonsAdmin';
import { Livro } from 'core/types/livro';
import { useCallback, useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import ClienteFilter from '../../Clientes/ClienteFilter';
import { LivroFilterData } from '../LivroFilter';
import './styles.scss';

type ControlComponentsData = {
  filterData: LivroFilterData;
};

const ListLivro = () => {
  const [filtro, setFiltro] = useState<Boolean>(false);

  const [livros, setLivros] = useState<Livro[]>();
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

  const getLivros = useCallback(() => {
    const params: AxiosRequestConfig = {
      method: filtro ? 'POST' : 'GET',
      url: filtro ? '/clientes/buscarClientes' : '/clientes',
      data: filtro ? controlComponentsData.filterData : undefined,
    };

    axios(params).then((response) => {
      console.log('teste');
      console.log(filtro);
      setLivros(response.data);
    });
  }, [controlComponentsData.filterData, filtro]);

  const handleSubmitFilter = (data: LivroFilterData) => {
    setControlComponentsData({ filterData: data });
    setFiltro(true);
  };

  useEffect(() => {
    getLivros();
  }, [getLivros]);

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
                <th>Código Livro</th>
                <th>Nome Livro</th>
                <th>Preço</th>
                <th colSpan={4}>Ações</th>
              </tr>
            </thead>
            <tbody>
              {livros?.map((livro) => (
                <tr>
                  <td>{livro.id}</td>
                  <td>{livro.nome}</td>
                  {livro.preco ? <td>Ativo</td> : <td>Inativo</td>}
                  <td colSpan={4}>
                    <ActionButtonsAdmin clienteId={livro.id} />
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

export default ListLivro;
