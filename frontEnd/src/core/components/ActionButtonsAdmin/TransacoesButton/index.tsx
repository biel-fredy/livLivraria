import { Button } from 'react-bootstrap';
import AttachMoney from '@material-ui/icons/AttachMoney';
import '../styles.scss';

const TransacoesButton = () => (
  <Button
    variant="primary"
    className="action-button"
    title="Transações"
    href="/transacoes"
  >
    <AttachMoney />
  </Button>
);

export default TransacoesButton;
