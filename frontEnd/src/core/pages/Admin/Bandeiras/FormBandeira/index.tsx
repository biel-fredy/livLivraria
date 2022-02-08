import { AxiosRequestConfig } from 'axios';
import { Cliente } from 'core/types/cliente';
import { TipoEndereco } from 'core/types/enums/tipoendereco';
import { TipoTelefone } from 'core/types/enums/tipotelefone';
import { ClienteDTO } from 'core/types/dto/clienteDTO';
import { requestBackend } from 'core/utils/requests';
import { useEffect } from 'react';
import { useState } from 'react';
import { useFieldArray, useForm, Controller } from 'react-hook-form';
import { useHistory, useParams } from 'react-router-dom';
import { Card } from 'react-bootstrap';
import Select from 'react-select';
import './styles.scss';
import { BandeiraDTO } from 'core/types/dto/bandeiraDTO';
import { Bandeira } from 'core/types/bandeira';

type UrlParams = {
  bandeiraId: string;
};

const FormBandeira = () => {
  const { bandeiraId } = useParams<UrlParams>();

  const isEditing = bandeiraId !== 'novo';

  const history = useHistory();

  const {
    register,
    handleSubmit,
    control,
    setValue,
    formState: { errors },
  } = useForm<BandeiraDTO>();

  useEffect(() => {
    if (isEditing) {
      requestBackend({ url: `/bandeiras/${bandeiraId}` }).then((response) => {
        const bandeiraSelecionada = response.data as BandeiraDTO;

        setValue('id', bandeiraSelecionada.id);
        setValue('nomeBandeira', bandeiraSelecionada.nomeBandeira);
        setValue('dataCadastro', bandeiraSelecionada.dataCadastro);
      });
    }
  }, [isEditing, bandeiraId, setValue]);

  const formDataToBandeira = (formData: BandeiraDTO) => {
    const bandeira = {
      id: 0,
      nomeBandeira: formData.nomeBandeira,
      dataCadastro: formData.dataCadastro,
    };
    return bandeira as Bandeira;
  };

  const onSubmit = (formData: BandeiraDTO) => {
    const config: AxiosRequestConfig = {
      method: isEditing ? 'PUT' : 'POST',
      url: isEditing ? `/bandeiras/${bandeiraId}` : '/bandeiras',
      data: formDataToBandeira(formData),
    };

    requestBackend(config).then(() => {
      //Toast.info('Cliente cadastrado com sucesso');
      history.push('/admin/bandeiras');
    });
  };

  const handleCancel = () => {
    history.push('/admin/bandeira');
  };

  return (
    <>
      <div className="container-fluid d-flex cadastro-cliente-container card-base">
        <div className="card-cadastro-cliente-container">
          <div className="cadastro-cliente-title-container">
            <h2 className="cadastro-cliente-title">Cadastro de Clientes</h2>
          </div>

          <form onSubmit={handleSubmit(onSubmit)}>
            <div className="input-nome-cadastro mb-2 row">
              <label htmlFor="inputNome" className="col-sm-1 col-form-label">
                Nome Bandeira:
              </label>
              <div className="col-sm-11">
                <input
                  {...register('nomeBandeira')}
                  type="text"
                  className="form-control"
                  id="inputNome"
                />
              </div>
            </div>
            <div className="mt-4 d-grid gap-2 col-6 mx-auto">
              <button className="btn btn-primary" type="submit">
                Cadastrar
              </button>
            </div>
          </form>
        </div>
      </div>
    </>
  );
};
export default FormBandeira;
