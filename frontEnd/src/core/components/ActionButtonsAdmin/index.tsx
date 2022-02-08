import { Cliente } from 'core/types/cliente';
import { Link } from 'react-router-dom';
import DeleteButton from '../ActionButtons/DeleteButton';
import EditButton from '../ActionButtons/EditButton';
import CartoesButton from './CartoesButton';
import EnderecosButton from './EnderecosButton';
import './styles.scss';
import TransacoesButton from './TransacoesButton';

type Props = {
  clienteId: number;
};
const ActionButtonsAdmin = ({ clienteId }: Props) => {
  return (
    <div>
      <Link to={`/admin/clientes/${clienteId}`}>
        <EditButton />
      </Link>

      <CartoesButton />

      <Link to={`/admin/clientes/${clienteId}/enderecos`}>
        <EnderecosButton />
      </Link>

      <TransacoesButton />
    </div>
  );
};

export default ActionButtonsAdmin;
