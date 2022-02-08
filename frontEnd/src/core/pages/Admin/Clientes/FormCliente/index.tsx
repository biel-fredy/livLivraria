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
import { TipoLogradouro } from 'core/types/enums/tipologradouro';

type UrlParams = {
  clienteId: string;
};

const FormCliente = () => {
  const { clienteId } = useParams<UrlParams>();

  const isEditing = clienteId !== 'novo';

  const history = useHistory();

  const [addEndereco, setAddEndereco] = useState(false);

  const [selectTiposTelefone, setSelectTiposTelefone] = useState<
    TipoTelefone[]
  >([]);

  const [selectTiposEndereco, setSelectTiposEndereco] = useState<
    TipoEndereco[]
  >([]);

  const [selectTiposLogradouro, setSelectTiposLogradouro] = useState<
    TipoLogradouro[]
  >([]);

  const {
    register,
    handleSubmit,
    control,
    setValue,
    formState: { errors },
  } = useForm<ClienteDTO>();

  useEffect(() => {
    requestBackend({ url: `/tiposTelefone` }).then((response) => {
      setSelectTiposTelefone(response.data);
    });
  }, []);

  useEffect(() => {
    requestBackend({ url: `/tiposEndereco` }).then((response) => {
      setSelectTiposEndereco(response.data);
    });
  }, []);

  useEffect(() => {
    requestBackend({ url: `/tiposLogradouro` }).then((response) => {
      setSelectTiposLogradouro(response.data);
    });
  }, []);

  const [checked, setChecked] = useState(false);

  useEffect(() => {
    if (isEditing) {
      requestBackend({ url: `/clientes/${clienteId}` }).then((response) => {
        const clienteSelecionado = response.data as ClienteDTO;

        setValue('id', clienteSelecionado.id);
        setValue('nome', clienteSelecionado.nome);
        setValue('dataCadastro', clienteSelecionado.dataCadastro);
        setValue('email', clienteSelecionado.email);
        setValue('cpf', clienteSelecionado.cpf);
        setValue('status', clienteSelecionado.status);
        setValue('genero', clienteSelecionado.genero);
        setValue('dataNascimento', clienteSelecionado.dataNascimento);
        setValue('telefones', clienteSelecionado.telefones);
        setValue('enderecos', clienteSelecionado.enderecos);
        setValue('cartoes', clienteSelecionado.cartoes);
      });
    }
  }, [isEditing, clienteId, setValue]);

  const formDataToCliente = (formData: ClienteDTO) => {
    const cliente = {
      id: 0,
      nome: formData.nome,
      status: formData.status,
      genero: formData.genero,
      dataNascimento: formData.dataNascimento,
      cpf: formData.cpf,
      email: formData.email,
      dataCadastro: formData.dataCadastro,
      ranking: formData.ranking,
      telefones: formData.telefones,
      enderecos: formData.enderecos,
      documentos: formData.documentos,
      pedidos: formData.pedidos,
      cartoes: formData.cartoes,
    };
    return cliente as Cliente;
  };

  const onSubmit = (formData: ClienteDTO) => {
    const config: AxiosRequestConfig = {
      method: isEditing ? 'PUT' : 'POST',
      url: isEditing ? `/clientes/${clienteId}` : '/clientes',
      data: formDataToCliente(formData),
    };
    console.log(formData);
    console.log(clienteId);
    console.log(isEditing);
    requestBackend(config).then(() => {
      //Toast.info('Cliente cadastrado com sucesso');
      history.push('/admin/clientes');
    });
  };

  const handleCancel = () => {
    history.push('/admin/products');
  };

  const { fields, append, remove } = useFieldArray({
    name: 'telefones',
    control,
  });

  const {
    fields: fields2,
    append: append2,
    remove: remove2,
  } = useFieldArray({
    name: 'enderecos',
    control,
  });

  const {
    fields: fields3,
    append: append3,
    remove: remove3,
  } = useFieldArray({
    name: 'cartoes',
    control,
  });

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
                Nome:
              </label>
              <div className="col-sm-11">
                <input
                  {...register('nome')}
                  type="text"
                  className="form-control"
                  id="inputNome"
                />
              </div>
            </div>

            <div className="input-email-cadastro mb-2 row">
              <label htmlFor="inputEmail" className="col-sm-1 col-form-label">
                Email:
              </label>
              <div className="col-sm-11">
                <input
                  {...register('email')}
                  type="text"
                  className="form-control"
                  id="inputEmail"
                />
              </div>
            </div>

            <div className="input-cpf-cadastro mb-2 row">
              <label htmlFor="inputCPF" className="col-sm-1 col-form-label">
                CPF:
              </label>
              <div className="col-sm-11">
                <input
                  {...register('cpf')}
                  type="number"
                  className="form-control"
                  id="inputCPF"
                />
              </div>
            </div>

            <div className="input-genero-cadastro mb-2 row">
              <label htmlFor="inputGenero" className="col-sm-1 col-form-label">
                Genero:
              </label>
              <div className="col-sm-11">
                <input
                  {...register('genero')}
                  type="text"
                  className="form-control"
                  id="inputGenero"
                />
              </div>
            </div>

            <div className="input-senha-cadastro mb-2 row">
              <label htmlFor="inputSenha" className="col-sm-1 col-form-label">
                Senha:
              </label>
              <div className="col-sm-11">
                <input type="text" className="form-control" id="inputSenha" />
              </div>
            </div>

            <div className="input-data-nascimento-cadastro mb-2 row">
              <label
                htmlFor="inputDataNascimento"
                className="col-sm-1 col-form-label"
              >
                Data de nascimento:
              </label>
              <div className="col-sm-11">
                <input
                  {...register('dataNascimento')}
                  type="date"
                  className="form-control"
                  id="inputDataNascimento"
                />
              </div>
            </div>

            {isEditing && (
              <div className="input-status-cadastro mb-2 row">
                <label
                  htmlFor="inputStatus"
                  className="col-sm-1 col-form-label form-check-label"
                >
                  Status:
                </label>
                <div className="form-check form-switch col-sm-11 checkStatus">
                  <input
                    {...register('status')}
                    type="checkbox"
                    id="inputStatus"
                    className="form-check-input"
                  />
                </div>
              </div>
            )}

            {!isEditing && (
              <div id="listas">
                <Card className="card-base border-radius-20 lista-card">
                  <Card.Header>
                    Telefones
                    <button
                      className="btn btn-primary col-6 botao-add-lista"
                      type="button"
                      onClick={() =>
                        append({
                          tipoTelefone: new TipoTelefone(
                            '0',
                            'Tipo de Telefone'
                          ),
                          ddd: '',
                          numero: '',
                        })
                      }
                    >
                      Adicionar Telefone
                    </button>
                  </Card.Header>
                  <Card.Body>
                    {fields.map((field, index) => {
                      return (
                        <div key={field.id}>
                          <section className={'section'} key={field.id}>
                            <div className="form-row">
                              <div className="form-group col-md-6 campo-telefone">
                                <Controller
                                  name={`telefones.${index}.tipoTelefone`}
                                  control={control}
                                  render={({ field }) => (
                                    <Select
                                      {...field}
                                      options={selectTiposTelefone}
                                      placeholder="Tipo"
                                      classNamePrefix="telefone-select"
                                      getOptionLabel={(
                                        tipoTelefone: TipoTelefone
                                      ) => tipoTelefone.descricao}
                                      getOptionValue={(
                                        tipoTelefone: TipoTelefone
                                      ) => tipoTelefone.valorNumerico}
                                    />
                                  )}
                                />
                              </div>

                              <div className="form-group col-md-2 campo-telefone">
                                <input
                                  className="form-control"
                                  placeholder="DDD"
                                  {...register(
                                    `telefones.${index}.ddd` as const,
                                    {
                                      required: true,
                                    }
                                  )}
                                />
                              </div>

                              <div className="form-group col-md-4 campo-telefone">
                                <input
                                  className="form-control"
                                  placeholder="Número"
                                  {...register(
                                    `telefones.${index}.numero` as const,
                                    {
                                      required: true,
                                    }
                                  )}
                                />
                              </div>

                              <div className="form-group col-md-12 campo-telefone">
                                <button
                                  className="btn btn-danger col-12"
                                  type="button"
                                  onClick={() => remove(index)}
                                >
                                  Delete
                                </button>
                              </div>
                            </div>
                          </section>
                        </div>
                      );
                    })}
                  </Card.Body>
                </Card>

                <Card className="card-base border-radius-20 lista-card">
                  <Card.Header>
                    Endereços
                    <button
                      className="btn btn-primary col-6 botao-add-lista"
                      type="button"
                      onClick={() =>
                        append2({
                          tipoLogradouro: new TipoLogradouro(
                            '0',
                            'Tipo Logradouro'
                          ),
                          logradouro: '',
                          numero: '',
                          cep: '',
                          complemento: '',
                          tipoEndereco: new TipoEndereco(
                            '0',
                            'Tipo de Residência'
                          ),
                          cidade: '',
                          estado: '',
                        })
                      }
                    >
                      Adicionar Endereço
                    </button>
                  </Card.Header>
                  <Card.Body>
                    {fields2.map((field, index) => {
                      return (
                        <>
                          <div key={field.id}>
                            <section className={'section'} key={field.id}>
                              <div className="form-row">
                                <div className="form-group col-md-12 campo-endereco">
                                  <input
                                    className="form-control"
                                    placeholder="Apelido do Endereço"
                                    {...register(
                                      `enderecos.${index}.apelido` as const,
                                      {
                                        required: true,
                                      }
                                    )}
                                  />
                                </div>

                                <div className="form-check">
                                  <label
                                    htmlFor="inputEnderecoEntrega"
                                    className="form-check-label"
                                  >
                                    Endereço de Entrega
                                  </label>
                                  <input
                                    type="checkbox"
                                    id="inputEnderecoEntrega"
                                    className="form-check-input"
                                    {...register(
                                      `enderecos.${index}.enderecoEntrega` as const
                                    )}
                                  />
                                </div>

                                <div className="form-check">
                                  <label
                                    htmlFor="inputEnderecoCobranca"
                                    className="form-check-label"
                                  >
                                    Endereço de Cobrança
                                  </label>
                                  <input
                                    type="checkbox"
                                    id="inputEnderecoCobranca"
                                    className="form-check-input"
                                    {...register(
                                      `enderecos.${index}.enderecoCobranca` as const
                                    )}
                                  />
                                </div>

                                <div className="form-group col-md-3 campo-endereco">
                                  <input
                                    className="form-control"
                                    placeholder="CEP"
                                    {...register(
                                      `enderecos.${index}.cep` as const,
                                      {
                                        required: true,
                                      }
                                    )}
                                  />
                                </div>

                                <div className="form-group col-md-6 campo-endereco">
                                  <Controller
                                    name={`enderecos.${index}.tipoLogradouro`}
                                    control={control}
                                    render={({ field }) => (
                                      <Select
                                        {...field}
                                        options={selectTiposLogradouro}
                                        placeholder="Tipo"
                                        classNamePrefix="endereco-select"
                                        getOptionLabel={(
                                          tipoLogradouro: TipoLogradouro
                                        ) => tipoLogradouro.descricao}
                                        getOptionValue={(
                                          tipoLogradouro: TipoLogradouro
                                        ) => tipoLogradouro.valorNumerico}
                                      />
                                    )}
                                  />
                                </div>

                                <div className="form-group col-md-6 campo-endereco">
                                  <input
                                    className="form-control"
                                    placeholder="Logradouro"
                                    {...register(
                                      `enderecos.${index}.logradouro` as const,
                                      {
                                        required: true,
                                      }
                                    )}
                                  />
                                </div>

                                <div className="form-group col-md-3 campo-endereco">
                                  <input
                                    className="form-control"
                                    placeholder="Número"
                                    {...register(
                                      `enderecos.${index}.numero` as const,
                                      {
                                        required: true,
                                      }
                                    )}
                                  />
                                </div>

                                <div className="form-group col-md-9 campo-endereco">
                                  <input
                                    className="form-control"
                                    placeholder="Complemento"
                                    {...register(
                                      `enderecos.${index}.complemento` as const,
                                      {
                                        required: true,
                                      }
                                    )}
                                  />
                                </div>

                                <div className="form-group col-md-6 campo-endereco">
                                  <Controller
                                    name={`enderecos.${index}.tipoEndereco`}
                                    control={control}
                                    render={({ field }) => (
                                      <Select
                                        {...field}
                                        options={selectTiposEndereco}
                                        placeholder="Tipo"
                                        classNamePrefix="endereco-select"
                                        getOptionLabel={(
                                          tipoEndereco: TipoEndereco
                                        ) => tipoEndereco.descricao}
                                        getOptionValue={(
                                          tipoEndereco: TipoEndereco
                                        ) => tipoEndereco.valorNumerico}
                                      />
                                    )}
                                  />
                                </div>

                                <div className="form-group col-md-3 campo-endereco">
                                  <input
                                    className="form-control"
                                    placeholder="Bairro"
                                    {...register(
                                      `enderecos.${index}.bairro` as const,
                                      {
                                        required: true,
                                      }
                                    )}
                                  />
                                </div>

                                <div className="form-group col-md-3 campo-endereco">
                                  <input
                                    className="form-control"
                                    placeholder="Cidade"
                                    {...register(
                                      `enderecos.${index}.cidade` as const,
                                      {
                                        required: true,
                                      }
                                    )}
                                  />
                                </div>

                                <div className="form-group col-md-3 campo-endereco">
                                  <input
                                    className="form-control"
                                    placeholder="Estado"
                                    {...register(
                                      `enderecos.${index}.estado` as const,
                                      {
                                        required: true,
                                      }
                                    )}
                                  />
                                </div>

                                <div className="form-group col-md-3 campo-endereco">
                                  <input
                                    className="form-control"
                                    placeholder="País"
                                    {...register(
                                      `enderecos.${index}.pais` as const,
                                      {
                                        required: true,
                                      }
                                    )}
                                  />
                                </div>

                                <div className="form-group col-md-12 campo-endereco">
                                  <textarea
                                    className="form-control"
                                    placeholder="Observações"
                                    rows={2}
                                    {...register(
                                      `enderecos.${index}.observacoes` as const,
                                      {
                                        required: false,
                                      }
                                    )}
                                  />
                                </div>

                                <div className="form-group col-md-6 campo-endereco">
                                  <button
                                    className="btn btn-danger btn-block col-12"
                                    type="button"
                                    onClick={() => remove2(index)}
                                  >
                                    Delete
                                  </button>
                                </div>

                                <hr></hr>
                              </div>
                            </section>
                          </div>
                        </>
                      );
                    })}
                  </Card.Body>
                </Card>

                <Card className="card-base border-radius-20 lista-card">
                  <Card.Header>
                    Cartões
                    <button
                      className="btn btn-primary col-6 botao-add-lista"
                      type="button"
                      onClick={() =>
                        append3({
                          numero: '',
                          nomeImpresso: '',
                          codigoSeguranca: '',
                        })
                      }
                    >
                      Adicionar Cartão
                    </button>
                  </Card.Header>
                  <Card.Body>
                    {fields3.map((field, index) => {
                      return (
                        <div key={field.id}>
                          <section className={'section'} key={field.id}>
                            <div className="form-row">
                              <div className="form-group col-md-12 campo-cartao">
                                <input
                                  className="form-control"
                                  placeholder="Número do Cartão"
                                  {...register(
                                    `cartoes.${index}.numero` as const,
                                    {
                                      required: true,
                                    }
                                  )}
                                />
                              </div>

                              <div className="form-group col-md-12 campo-cartao">
                                <input
                                  className="form-control"
                                  placeholder="Nome Impresso"
                                  {...register(
                                    `cartoes.${index}.nomeImpresso` as const,
                                    {
                                      required: true,
                                    }
                                  )}
                                />
                              </div>

                              <div className="form-group col-md-6 campo-cartao">
                                <input
                                  className="form-control"
                                  placeholder="Bandeira"
                                  {...register(
                                    `cartoes.${index}.bandeira` as const,
                                    {
                                      required: true,
                                    }
                                  )}
                                />
                              </div>

                              <div className="form-group col-md-6 campo-cartao">
                                <input
                                  className="form-control"
                                  placeholder="Código Segurança"
                                  {...register(
                                    `cartoes.${index}.codigoSeguranca` as const,
                                    {
                                      required: true,
                                    }
                                  )}
                                />
                              </div>

                              <div className="form-group col-md-12 campo-cartao">
                                <button
                                  className="btn btn-danger btn-block col-12"
                                  type="button"
                                  onClick={() => remove3(index)}
                                >
                                  Delete
                                </button>
                              </div>

                              <hr></hr>
                            </div>
                          </section>
                        </div>
                      );
                    })}
                  </Card.Body>
                </Card>
              </div>
            )}
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

export default FormCliente;
