import { UseFormRegister, Path, Control } from 'react-hook-form';

import './styles.scss';
import { ClienteDTO } from 'core/types/dto/clienteDTO';
import { Endereco } from 'core/types/endereco';

type EnderecoProps = {
  label?: Path<ClienteDTO>;
  register: UseFormRegister<ClienteDTO>;
  required?: boolean;
  control?: Control<ClienteDTO, object>;

  enderecoValues?: Endereco;
};

function Form({ control, register, required, enderecoValues }: EnderecoProps) {
  return <h1>FormEnderec</h1>;
}

export default Form;
