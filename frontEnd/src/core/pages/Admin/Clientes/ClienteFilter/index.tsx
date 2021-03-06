import { useState } from 'react';
import { useForm } from 'react-hook-form';
import SearchButton from 'core/components/ActionButtonsAdmin/SearchButton';

import './styles.scss';
import ExpandButton from 'core/components/ActionButtonsAdmin/ExpandButton';

type Props = {
  onSubmitFilter: (data: ClienteFilterData) => void;
};

export type ClienteFilterData = {
  id: number;
  nome: string;
  status: number;
  genero: string;
  dataNascimento: string;
  cpf: string;
  email: string;
};

const ClienteFilter = ({ onSubmitFilter }: Props) => {
  const { register, handleSubmit, setValue } = useForm<ClienteFilterData>();

  const [checked, setChecked] = useState(true);
  const [expanded, setExpanded] = useState(false);

  const handleExpanded = () => {
    !expanded ? setExpanded(true) : setExpanded(false);
  };

  const onSubmit = (formData: ClienteFilterData) => {
    // const config: AxiosRequestConfig = {
    //   method: 'POST',
    //   url: `/clientes/buscarClientes/`,
    //   data: formDataToCliente(formData),
    // };
    console.log(formData);
    onSubmitFilter(formData);
    //  requestBackend(config).then(() => {
    //Toast.info('Cliente cadastrado com sucesso');
    //  });
  };

  const handleFormClear = () => {
    setValue('id', 0);
    setValue('nome', '');
    setValue('cpf', '');
    setValue('email', '');
    setValue('genero', '');
    setValue('dataNascimento', '');
  };

  return (
    <>
      <div className="cliente-filter-container container filter-container border-radius-20">
        <div className="button-add-item">
          <button
            className="btn btn-primary"
            type="button"
            onClick={handleExpanded}
          >
            <ExpandButton />
          </button>
        </div>

        <form onSubmit={handleSubmit(onSubmit)}>
          <div className="container-fields-padrao">
            <div className="form-group col-md-3 campo-linha">
              <input
                {...register('id')}
                type="number"
                className="form-control"
                id="inputId"
                placeholder="C??digo do cliente"
              />
            </div>
            <div className="form-group col-md-3 campo-linha">
              <input
                {...register('nome')}
                type="text"
                className="form-control"
                id="inputNome"
                placeholder="Nome"
              />
            </div>

            <div className="form-group col-md-3 campo-linha">
              <input
                {...register('cpf')}
                type="number"
                className="form-control"
                id="inputCPF"
                placeholder="CPF"
              />
            </div>
            <div className="form-group col-md-3 campo-linha">
              <input
                {...register('email')}
                type="text"
                className="form-control"
                id="inputEmail"
                placeholder="E-mail"
              />
            </div>
          </div>
          {expanded && (
            <>
              <div className="form-group col-md-3 campo-linha">
                <input
                  {...register('genero')}
                  type="text"
                  className="form-control"
                  id="inputGenero"
                  placeholder="G??nero"
                />
              </div>
              <div className="form-group col-md-3 campo-linha">
                <input
                  {...register('dataNascimento')}
                  className="form-control"
                  placeholder="Data Nascimento"
                  type="date"
                />
              </div>

              <div className="form-group col-md-3 campo-linha">
                <label htmlFor="inputStatus" className="form-check-label">
                  Status:
                </label>
                <div className="form-check form-switch checkStatus">
                  <input
                    {...register('status')}
                    type="checkbox"
                    id="inputStatus"
                    className="form-check-input"
                    defaultChecked={checked}
                    onChange={() => setChecked(!checked)}
                  />
                </div>
              </div>
            </>
          )}

          <button onClick={handleFormClear} className="btn btn-warning">
            Limpar Filtro
          </button>

          <button className="btn btn-primary" type="submit">
            <SearchButton />
          </button>
        </form>
      </div>
    </>
  );
};

export default ClienteFilter;
