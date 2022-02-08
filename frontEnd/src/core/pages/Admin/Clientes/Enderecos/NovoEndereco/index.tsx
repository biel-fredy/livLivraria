import { useForm } from 'react-hook-form';
import { Route, Switch } from 'react-router-dom';
import { ClienteDTO } from 'core/types/dto/clienteDTO';
import Form from '../Form';

const NovoEndereco = () => {
  const {
    register,
    handleSubmit,
    control,
    formState: { errors },
  } = useForm<ClienteDTO>();

  return (
    <div className="card-novo-form container table-container border-radius-20">
      <h2>Cadastrar Novo Endereço</h2>
      <Form control={control} register={register} required />
      <button className="btn btn-primary" type="submit">
        Cadastrar
      </button>
    </div>
  );
};

export default NovoEndereco;
